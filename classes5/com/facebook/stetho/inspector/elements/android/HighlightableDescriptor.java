package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import javax.annotation.Nullable;

abstract interface HighlightableDescriptor
{
  @Nullable
  public abstract View getViewForHighlighting(Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\HighlightableDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */