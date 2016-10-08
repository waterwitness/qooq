package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class SuitUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "SuitUIPlugin";
  
  public SuitUIPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.ab = super.decodeUrl(this.activity.ab);
    if (QLog.isColorLevel()) {
      QLog.d("SuitUIPlugin", 2, this.activity.ab);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 262144L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\SuitUIPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */