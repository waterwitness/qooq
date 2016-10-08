package com.tencent.av.utils;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;

public class TintStateDrawable
  extends BitmapDrawable
{
  private ColorStateList a;
  
  public TintStateDrawable(Resources paramResources, InputStream paramInputStream, int paramInt)
  {
    super(paramResources, paramInputStream);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public static TintStateDrawable a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return new TintStateDrawable(paramResources, paramResources.openRawResource(paramInt1), paramInt2);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    TintStateDrawable localTintStateDrawable = a(paramView.getResources(), paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(localTintStateDrawable);
      return;
    }
    paramView.setBackgroundDrawable(localTintStateDrawable);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.a.getColorForState(paramArrayOfInt, 0);
    if (i != 0) {
      setColorFilter(i, PorterDuff.Mode.MULTIPLY);
    }
    for (;;)
    {
      invalidateSelf();
      return super.onStateChange(paramArrayOfInt);
      clearColorFilter();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\TintStateDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */