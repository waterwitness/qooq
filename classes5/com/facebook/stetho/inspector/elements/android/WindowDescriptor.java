package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import javax.annotation.Nullable;

final class WindowDescriptor
  extends AbstractChainedDescriptor<Window>
  implements HighlightableDescriptor
{
  @Nullable
  public View getViewForHighlighting(Object paramObject)
  {
    return ((Window)paramObject).peekDecorView();
  }
  
  protected void onGetChildren(Window paramWindow, Accumulator<Object> paramAccumulator)
  {
    paramWindow = paramWindow.peekDecorView();
    if (paramWindow != null) {
      paramAccumulator.store(paramWindow);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\WindowDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */