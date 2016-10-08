package com.tencent.mobileqq.nearby.flat.async;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementHost;

public class HeadlessElementHost
  implements UIElementHost
{
  private final Context a;
  
  public HeadlessElementHost(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramContext;
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public int[] getDrawableState()
  {
    return new int[0];
  }
  
  public Resources getResources()
  {
    return this.a.getResources();
  }
  
  public void invalidate() {}
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void invalidateDrawable(Drawable paramDrawable) {}
  
  public void requestLayout() {}
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\async\HeadlessElementHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */