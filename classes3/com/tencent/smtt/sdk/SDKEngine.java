package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class SDKEngine
{
  public static final String COUNT_PROPERTIES = "count.prop";
  private static int REBOOT_CALLED_TIMES_MAX = 3;
  private static final String TAG = "SDKEngine";
  private static String mCalledCountKey = null;
  private static int mInitCount;
  private static SDKEngine mInstance = null;
  private static int mTbsCoreVersion = 0;
  static boolean mTbsNeedReboot;
  private boolean mIsInited = false;
  private boolean mTbsAvailable = false;
  private TbsWizard mTbsWizard = null;
  private File mX5CorePath = null;
  
  static
  {
    mInitCount = 0;
    mTbsNeedReboot = false;
  }
  
  private int getCountProp()
  {
    try
    {
      Object localObject = new File(this.mX5CorePath, "count.prop");
      if (!((File)localObject).exists()) {
        return 0;
      }
      localObject = new FileInputStream((File)localObject);
      Properties localProperties = new Properties();
      localProperties.load((InputStream)localObject);
      int i = Integer.valueOf(localProperties.getProperty(mCalledCountKey, "1")).intValue();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public static SDKEngine getInstance(boolean paramBoolean)
  {
    try
    {
      if ((mInstance == null) && (paramBoolean)) {
        mInstance = new SDKEngine();
      }
      SDKEngine localSDKEngine = mInstance;
      return localSDKEngine;
    }
    finally {}
  }
  
  public static int getTbsCoreVersion()
  {
    return mTbsCoreVersion;
  }
  
  private void setCountProp(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(mCalledCountKey, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.mX5CorePath, "count.prop")), null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  static void setTbsCoreVersion(int paramInt)
  {
    mTbsCoreVersion = paramInt;
  }
  
  public String getCrashExtraMessage()
  {
    if ((this.mTbsWizard == null) || (QbSdk.mIsSysWebViewForced)) {
      return "system webview get nothing...";
    }
    return this.mTbsWizard.getCrashExtraMessage();
  }
  
  boolean getTbsNeedReboot()
  {
    int i;
    if (mTbsNeedReboot)
    {
      if (mCalledCountKey == null) {
        return false;
      }
      i = getCountProp();
      if (i != 0) {
        break label32;
      }
      setCountProp(1);
    }
    for (;;)
    {
      return mTbsNeedReboot;
      label32:
      if (i + 1 > REBOOT_CALLED_TIMES_MAX) {
        break;
      }
      setCountProp(i + 1);
    }
  }
  
  public void init(Context paramContext)
  {
    try
    {
      init(paramContext, false, false);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      init(paramContext, paramBoolean, false);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    int j = 0;
    int i;
    label97:
    Object localObject4;
    Object localObject5;
    Object localObject3;
    label210:
    label239:
    label260:
    label274:
    label309:
    Object localObject2;
    for (;;)
    {
      try
      {
        TbsLog.initIfNeed(paramContext);
        mInitCount += 1;
        TbsCoreLoadStat.getInstance().clearErrorCodeQueue();
        Object localObject1 = TbsInstaller.getInstance();
        boolean bool;
        if (mInitCount == 1)
        {
          bool = true;
          ((TbsInstaller)localObject1).installTbsCoreIfNeeded(paramContext, bool);
          paramBoolean2 = QbSdk.canLoadX5(paramContext, paramBoolean1, paramBoolean2);
          if (Build.VERSION.SDK_INT >= 7)
          {
            paramBoolean1 = true;
            break label523;
            if (i == 0) {
              break label425;
            }
            paramBoolean1 = this.mTbsAvailable;
            if (!paramBoolean1) {
              continue;
            }
          }
        }
        else
        {
          bool = false;
          continue;
        }
        paramBoolean1 = false;
        break label523;
        i = 0;
        continue;
        try
        {
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break label274;
          }
          if (!TbsShareManager.isShareTbsCoreAvailable(paramContext)) {
            break label260;
          }
          localObject4 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
          localObject5 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
          localObject1 = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
          localObject3 = localObject5;
          if (localObject5 != null) {
            break;
          }
          this.mTbsAvailable = false;
          QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
        }
        catch (Throwable localThrowable)
        {
          TbsLog.e("SDKEngine", "useSystemWebView by exception: " + localThrowable);
          if (localThrowable != null) {
            break label410;
          }
        }
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 326);
        this.mTbsAvailable = false;
        QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by exception: " + localThrowable);
        this.mX5CorePath = TbsInstaller.getTbsCorePrivateDir(paramContext);
        this.mIsInited = true;
        continue;
        this.mTbsAvailable = false;
      }
      finally {}
      QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
      continue;
      localObject3 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      i = k;
      if (mTbsCoreVersion != 25436)
      {
        if (mTbsCoreVersion != 25437) {
          break label537;
        }
        i = k;
      }
      if (i == 0) {
        break label543;
      }
      localObject2 = paramContext.getApplicationContext();
      label320:
      if (localObject3 != null) {
        break label549;
      }
      this.mTbsAvailable = false;
      QbSdk.forceSysWebViewInner(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
    }
    for (;;)
    {
      localObject5 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject2, ((File)localObject4).getAbsolutePath());
      i = j;
      while (i < localObject5.length) {
        i += 1;
      }
      this.mTbsWizard = new TbsWizard(paramContext, (Context)localObject2, ((File)localObject4).getAbsolutePath(), ((File)localObject3).getAbsolutePath(), (String[])localObject5, QbSdk.sLibraryPath);
      this.mTbsAvailable = true;
      break label239;
      label410:
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 327, (Throwable)localObject2);
      break label210;
      label425:
      localObject2 = "can_load_x5=" + paramBoolean2 + "; is_compatible=" + paramBoolean1;
      TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + (String)localObject2);
      if ((QbSdk.mIsSysWebViewForced) && (this.mTbsAvailable)) {
        break label239;
      }
      this.mTbsAvailable = false;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 405, new Throwable((String)localObject2));
      break label239;
      label523:
      if ((!paramBoolean2) || (!paramBoolean1)) {
        break label97;
      }
      i = 1;
      break;
      label537:
      i = 0;
      break label309;
      label543:
      localObject2 = paramContext;
      break label320;
      label549:
      localObject4 = localObject3;
    }
  }
  
  boolean isInited()
  {
    return this.mIsInited;
  }
  
  public boolean isTbsAvailable()
  {
    return this.mTbsAvailable;
  }
  
  void setCalledCountKey(String paramString)
  {
    mCalledCountKey = paramString;
  }
  
  boolean setTbsNeedReboot(boolean paramBoolean)
  {
    mTbsNeedReboot = paramBoolean;
    return paramBoolean;
  }
  
  public boolean useSoftWare()
  {
    return QbSdk.useSoftWare();
  }
  
  public TbsWizard wizard()
  {
    if (this.mTbsAvailable) {
      return this.mTbsWizard;
    }
    return null;
  }
  
  TbsWizard wizardForReaderView()
  {
    return this.mTbsWizard;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\SDKEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */