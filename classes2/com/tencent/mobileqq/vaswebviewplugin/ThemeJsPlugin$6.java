package com.tencent.mobileqq.vaswebviewplugin;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ThemeJsPlugin$6
  implements Runnable
{
  ThemeJsPlugin$6(ThemeJsPlugin paramThemeJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.this$0.tmpScreenShot.getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.this$0.tmpScreenShot);
      localViewGroup.clearDisappearingChildren();
    }
    this.this$0.drawingCache.recycle();
    this.this$0.drawingCache = null;
    this.this$0.isAnimating = false;
    this.this$0.isSwitchTheme = Boolean.valueOf(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */