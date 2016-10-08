package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import javax.annotation.Nullable;

abstract interface AndroidDescriptorHost
  extends Descriptor.Host
{
  @Nullable
  public abstract View getHighlightingView(@Nullable Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AndroidDescriptorHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */