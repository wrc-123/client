package com.looker.core.data.fdroid.sync.signature

import com.looker.core.common.extension.certificate
import com.looker.core.common.extension.codeSigner
import com.looker.core.common.extension.fingerprint
import com.looker.core.common.extension.toJarFile
import com.looker.core.common.signature.FileValidator
import com.looker.core.common.signature.ValidationException
import com.looker.core.domain.model.Fingerprint
import com.looker.core.domain.model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.fdroid.index.IndexParser
import org.fdroid.index.parseEntry
import org.fdroid.index.v2.Entry
import java.io.File

class EntryValidator(
    private val repo: Repo,
    private val fingerprintBlock: (Entry, String) -> Unit
) : FileValidator {
    override suspend fun validate(file: File) = withContext(Dispatchers.IO) {
        val (entry, fingerprint) = getEntryAndFingerprint(file)
        if (repo.fingerprint.check(Fingerprint(fingerprint))) {
            throw ValidationException(
                "Expected Fingerprint: ${repo.fingerprint}, Acquired Fingerprint: $fingerprint"
            )
        }
        fingerprintBlock(entry, fingerprint)
    }

    companion object {
        const val JSON_NAME = "entry.json"
    }

    private suspend fun getEntryAndFingerprint(
        file: File
    ): Pair<Entry, String> = withContext(Dispatchers.IO) {
        val jar = file.toJarFile()
        val jarEntry = requireNotNull(jar.getJarEntry(JSON_NAME)) {
            "No entry for: $JSON_NAME"
        }

        val entry = jar
            .getInputStream(jarEntry)
            .use(IndexParser::parseEntry)

        val fingerprint = jarEntry
            .codeSigner
            .certificate
            .fingerprint()
        entry to fingerprint
    }
}
