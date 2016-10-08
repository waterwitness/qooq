package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmojiSubHomeUiPlugin
  extends EmojiUiPlugin
{
  private int tt;
  
  public EmojiSubHomeUiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnActivityCreate()
  {
    this.mActivityType = 3;
    super.OnActivityCreate();
    if (!checkOncreateParam(getInfoIntent())) {
      this.activity.finish();
    }
  }
  
  protected long getPluginBusiness()
  {
    return 4L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiSubHomeUiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */