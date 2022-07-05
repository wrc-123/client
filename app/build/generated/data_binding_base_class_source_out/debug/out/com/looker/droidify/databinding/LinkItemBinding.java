// Generated by view binder compiler. Do not edit!
package com.looker.droidify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.looker.droidify.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LinkItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ShapeableImageView icon;

  @NonNull
  public final MaterialTextView link;

  @NonNull
  public final MaterialTextView text;

  private LinkItemBinding(@NonNull LinearLayout rootView, @NonNull ShapeableImageView icon,
      @NonNull MaterialTextView link, @NonNull MaterialTextView text) {
    this.rootView = rootView;
    this.icon = icon;
    this.link = link;
    this.text = text;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LinkItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LinkItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.link_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LinkItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.icon;
      ShapeableImageView icon = ViewBindings.findChildViewById(rootView, id);
      if (icon == null) {
        break missingId;
      }

      id = R.id.link;
      MaterialTextView link = ViewBindings.findChildViewById(rootView, id);
      if (link == null) {
        break missingId;
      }

      id = R.id.text;
      MaterialTextView text = ViewBindings.findChildViewById(rootView, id);
      if (text == null) {
        break missingId;
      }

      return new LinkItemBinding((LinearLayout) rootView, icon, link, text);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
