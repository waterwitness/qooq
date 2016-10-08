package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static final String TAG = "TbsLinuxToolsJni";
  private static boolean gJniloaded = false;
  private static boolean mbIsInited = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    init(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void init(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (mbIsInited) {
          return;
        }
        mbIsInited = true;
      }
      finally {}
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label94;
        }
        paramContext = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
        if (paramContext != null)
        {
          System.load(paramContext.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
          gJniloaded = true;
        }
        ChmodInner("/checkChmodeExists", "700");
      }
      catch (Throwable paramContext)
      {
        label94:
        paramContext.printStackTrace();
        gJniloaded = false;
        continue;
      }
      return;
      paramContext = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
    }
  }
  
  public int Chmod(String paramString1, String paramString2)
  {
    if (!gJniloaded)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsLinuxToolsJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */