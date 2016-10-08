package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ThemeDIYActivity$8
  extends UniPayHandler.UniPayUpdateListener
{
  ThemeDIYActivity$8(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void update()
  {
    this.this$0.runOnUiThread(new ThemeDIYActivity.8.1(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */