package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

class TbsWizard
{
  private static final String TAG = "TbsWizard";
  static final String WEBCOREPROXY_CLASSNAME = "com.tencent.tbs.tbsshell.WebCoreProxy";
  private String loadFailureDetails = null;
  private Context mCallerAppContext = null;
  private String[] mDexFileList = null;
  private DexLoader mDexLoader = null;
  private String mDexOptPath = "TbsDexOpt";
  private Context mHostContext = null;
  private String mtbsInstallLocation = null;
  
  public TbsWizard(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
    throws Exception
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || (paramContext2 == null) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new Exception("TbsWizard paramter error:-1");
    }
    this.mCallerAppContext = paramContext1.getApplicationContext();
    this.mHostContext = paramContext2;
    this.mtbsInstallLocation = paramString1;
    this.mDexFileList = paramArrayOfString;
    this.mDexOptPath = paramString2;
    this.mDexLoader = new DexLoader(paramString3, this.mCallerAppContext, this.mDexFileList, paramString2);
    libwebp.loadWepLibraryIfNeed(paramContext2, this.mtbsInstallLocation);
    if ("com.nd.android.pandahome2".equals(this.mCallerAppContext.getApplicationInfo().packageName))
    {
      paramContext2 = this.mDexLoader;
      paramString1 = this.mCallerAppContext;
      paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
    }
    if (QbSdk.mSettings != null)
    {
      paramContext2 = this.mDexLoader;
      paramString1 = QbSdk.mSettings;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    int i = init(paramContext1);
    if (i < 0) {
      throw new Exception("TbsWizard init error: " + i + "; msg: " + this.loadFailureDetails);
    }
    TbsLog.i("TbsWizard", "construction end...");
  }
  
  private int init(Context paramContext)
  {
    Object localObject1 = this.mDexLoader;
    Object localObject2 = AppUtil.mImei;
    Object localObject3 = AppUtil.mImsi;
    Object localObject4 = AppUtil.mCpu;
    String str1 = AppUtil.mMac;
    ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[] { Context.class, String.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
    localObject1 = this.mDexLoader;
    localObject2 = Integer.TYPE;
    localObject3 = this.mHostContext;
    localObject4 = this.mDexLoader;
    str1 = this.mtbsInstallLocation;
    String str2 = this.mDexOptPath;
    String str3 = QbSdk.getTbsCoreVersionString();
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "2.2.0.1095", Integer.valueOf(36548), str3 });
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      setSdkVersionNameInTbsShell();
      setSdkVersionInTbsShell();
      localObject1 = this.mDexLoader;
      localObject2 = this.mHostContext;
      localObject3 = this.mDexLoader;
      localObject4 = this.mtbsInstallLocation;
      str1 = this.mDexOptPath;
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
    }
    int i;
    if (localObject1 == null) {
      i = -3;
    }
    while (i < 0)
    {
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext instanceof Throwable))
      {
        localObject1 = (Throwable)paramContext;
        this.loadFailureDetails = ("#" + ((Throwable)localObject1).getMessage() + "; cause: " + ((Throwable)localObject1).getCause() + "; th: " + localObject1);
      }
      if ((paramContext instanceof String)) {
        this.loadFailureDetails = ((String)paramContext);
      }
      return i;
      if ((localObject1 instanceof Integer))
      {
        i = ((Integer)localObject1).intValue();
      }
      else if ((localObject1 instanceof Throwable))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(this.mCallerAppContext, 328, (Throwable)localObject1);
        i = -5;
      }
      else
      {
        i = -4;
      }
    }
    this.loadFailureDetails = null;
    return i;
  }
  
  private void setSdkVersionInTbsShell()
  {
    this.mDexLoader.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(36548));
  }
  
  private void setSdkVersionNameInTbsShell()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "2.2.0.1095" });
  }
  
  public Object createGamePlayer(Context paramContext)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayer", new Class[] { Context.class }, new Object[] { paramContext });
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = null;
    }
    return paramContext;
  }
  
  public Object createGamePlayerClientExtensionHost(Object paramObject)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayerClientExtensionHost", new Class[] { Object.class }, new Object[] { paramObject });
    paramObject = localObject;
    if (localObject == null) {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object createGamePlayerClientHost(Object paramObject)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayerClientHost", new Class[] { Object.class }, new Object[] { paramObject });
    paramObject = localObject;
    if (localObject == null) {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object createGamePlayerServiceHost(Object paramObject)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayerServiceHost", new Class[] { Object.class }, new Object[] { paramObject });
    paramObject = localObject;
    if (localObject == null) {
      paramObject = null;
    }
    return paramObject;
  }
  
  public DexLoader dexLoader()
  {
    return this.mDexLoader;
  }
  
  public String getCrashExtraMessage()
  {
    String str = null;
    Object localObject1 = this.mDexLoader;
    Object localObject2 = Boolean.TYPE;
    Object[] arrayOfObject = new Object[0];
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, Class[].class, Object[].class }, new Object[] { Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, arrayOfObject });
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null) {
      str = String.valueOf(localObject1);
    }
    localObject1 = str;
    if (str == null) {
      localObject1 = "X5 core get nothing...";
    }
    return (String)localObject1;
  }
  
  public boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */