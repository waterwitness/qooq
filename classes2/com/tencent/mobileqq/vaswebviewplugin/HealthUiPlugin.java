package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Map;

public class HealthUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "HealthUiPlugin";
  public boolean mIsJDUpdateConfigInit;
  public ArrayList mJDUpdateConfig;
  
  public HealthUiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mJDUpdateConfig = new ArrayList(4);
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramLong != 16L) {
      return false;
    }
    ThreadManager.a(new HealthUiPlugin.1(this, paramString), 5, null, false);
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 65536L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\HealthUiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */