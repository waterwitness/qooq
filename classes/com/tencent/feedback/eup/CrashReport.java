package com.tencent.feedback.eup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.feedback.eup.jni.NativeExceptionHandlerRQDImp;
import com.tencent.feedback.eup.jni.NativeExceptionUpload;
import com.tencent.feedback.upload.UploadHandleListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class CrashReport
  extends com.tencent.bugly.a
{
  public static final int MODULE_ID = 1003;
  private static boolean a = false;
  private static CrashStrategyBean b = null;
  private static e c = null;
  private static CrashHandleListener d = null;
  private static r e = null;
  private static CrashReport f = new CrashReport();
  
  public static boolean addPlugin(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, paramString2, paramString3);
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    paramContext = s.a();
    if (paramContext != null)
    {
      paramContext.b();
      paramContext.c();
    }
  }
  
  public static int countExceptionDatas(Context paramContext)
  {
    paramContext = c.a();
    if (paramContext != null) {
      return paramContext.j();
    }
    return 0;
  }
  
  @Deprecated
  public static int countStoredRecord(Context paramContext)
  {
    return countExceptionDatas(paramContext);
  }
  
  public static boolean doUploadExceptionDatas()
  {
    c localc = c.a();
    if (localc != null)
    {
      localc.a(0L);
      return true;
    }
    return false;
  }
  
  public static Set<String> getAllUserDataKeys(Context paramContext)
  {
    if (paramContext == null)
    {
      v.d("getAllUserDataKeys args context should not be null", new Object[0]);
      return null;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).z();
  }
  
  public static CrashHandleListener getCrashHandler()
  {
    return d;
  }
  
  public static CrashStrategyBean getCrashRuntimeStrategy()
  {
    return b;
  }
  
  public static byte[] getExceptionDatas(Context paramContext)
  {
    if (c.a() != null) {
      return c.a().i();
    }
    return null;
  }
  
  public static CrashReport getInstance()
  {
    return f;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = s.a();
    if (paramContext != null) {
      return paramContext.a(false);
    }
    return -1L;
  }
  
  public static String getUserData(Context paramContext, String paramString)
  {
    int i = 0;
    if (paramContext == null) {
      v.d("getUserDataValue args context should not be null", new Object[0]);
    }
    for (;;)
    {
      return null;
      if ((paramString != null) && (paramString.trim().length() > 0)) {}
      while (i == 0)
      {
        return com.tencent.bugly.crashreport.common.info.a.a(paramContext).i(paramString);
        i = 1;
      }
    }
  }
  
  public static int getUserDatasSize(Context paramContext)
  {
    if (paramContext == null)
    {
      v.d("getUserDatasSize args context should not be null", new Object[0]);
      return -1;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).y();
  }
  
  public static int getUserSceneTagId(Context paramContext)
  {
    if (paramContext == null)
    {
      v.d("getUserSceneTagId args context should not be null", new Object[0]);
      return -1;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).B();
  }
  
  public static boolean handleCatchException(Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    c localc = c.a();
    if (localc != null)
    {
      localc.a(paramThread, paramThrowable, false, paramString, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  public static void initCrashReport(Context paramContext)
  {
    initCrashReport(paramContext, null, null, true, null);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean)
  {
    initCrashReport(paramContext, paramCrashHandleListener, paramUploadHandleListener, paramBoolean, paramCrashStrategyBean, 0L);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    v.b = "eup";
    v.a = "eup";
    StrategyBean.c = "http://monitor.uu.qq.com/analytics/rqdsync";
    StrategyBean.a = "http://android.rqd.qq.com/analytics/async";
    StrategyBean.b = "http://android.rqd.qq.com/analytics/async";
    b = paramCrashStrategyBean;
    a = true;
    setCrashHandler(paramCrashHandleListener);
    if (paramUploadHandleListener != null)
    {
      e = new r()
      {
        public final void a(int paramAnonymousInt)
        {
          this.a.onUploadStart(paramAnonymousInt);
        }
        
        public final void a(int paramAnonymousInt, ak paramAnonymousak, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          if (paramAnonymousak == null) {}
          for (int i = -1;; i = paramAnonymousak.b)
          {
            this.a.onUploadEnd(paramAnonymousInt, i, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean, paramAnonymousString);
            return;
          }
        }
      };
      paramCrashHandleListener = s.a();
      if (paramCrashHandleListener != null) {
        paramCrashHandleListener.a = e;
      }
    }
    paramCrashHandleListener = new BuglyStrategy();
    if (paramCrashStrategyBean != null)
    {
      c.f = paramCrashStrategyBean.getRecordOverDays() * 24 * 3600 * 1000;
      c.g = paramCrashStrategyBean.getOnlyLogTag();
      c.h = paramCrashStrategyBean.isStoreCrashSdcard();
      c.i = paramCrashStrategyBean.getStoreDirectoryPath();
      c.j = paramCrashStrategyBean.getCrashSdcardMaxSize();
      c.d = paramCrashStrategyBean.getMaxLogLength();
      c.e = paramCrashStrategyBean.getMaxStackLength();
      c.c = paramCrashStrategyBean.isMerged();
      c.k = paramCrashStrategyBean.isUploadSpotCrash();
    }
    paramCrashHandleListener.setAppReportDelay(paramLong);
    paramUploadHandleListener = com.tencent.bugly.crashreport.common.info.a.a(paramContext).e;
    int i;
    if ((paramUploadHandleListener != null) && (paramUploadHandleListener.trim().length() > 0))
    {
      i = 0;
      if (i != 0) {
        com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramContext.getPackageName());
      }
      paramUploadHandleListener = com.tencent.bugly.crashreport.common.info.a.a(paramContext).l;
      if (paramUploadHandleListener == null) {
        break label377;
      }
      if ((paramUploadHandleListener == null) || (paramUploadHandleListener.trim().length() <= 0)) {
        break label311;
      }
      i = 0;
    }
    for (;;)
    {
      label247:
      if (i == 0)
      {
        int j = 0;
        char[] arrayOfChar = paramUploadHandleListener.toCharArray();
        i = 0;
        for (;;)
        {
          if (i < arrayOfChar.length)
          {
            int k = j;
            if (arrayOfChar[i] == '.') {
              k = j + 1;
            }
            i += 1;
            j = k;
            continue;
            i = 1;
            break;
            label311:
            i = 1;
            break label247;
          }
        }
        if (j < 3)
        {
          paramUploadHandleListener = paramUploadHandleListener + "." + com.tencent.bugly.crashreport.common.info.a.a(paramContext).x;
          com.tencent.bugly.crashreport.common.info.a.a(paramContext).l = paramUploadHandleListener;
          v.a("rqdp{ RQD version: %s }", new Object[] { paramUploadHandleListener });
        }
      }
    }
    label377:
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).f = paramBoolean;
    c.b = true;
    com.tencent.bugly.crashreport.common.strategy.a.b = 21600000L;
    paramCrashHandleListener.setEnableUserInfo(false);
    b.a(paramContext, paramContext.getPackageName(), false, paramCrashHandleListener);
    c.a(1003, paramContext, false, null, c, null);
    c.a().c();
    if ((paramCrashStrategyBean == null) || (paramCrashStrategyBean.isOpenANR())) {
      c.a().f();
    }
    for (;;)
    {
      s.a().a = e;
      c.a().a(paramLong);
      return;
      v.a("[crash] Closed ANR monitor!", new Object[0]);
      c.a().g();
    }
  }
  
  public static void initCrashReport(Context paramContext, boolean paramBoolean)
  {
    initCrashReport(paramContext, null, null, paramBoolean, null, 0L);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, null, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, paramList, null);
  }
  
  @SuppressLint({"SdCardPath"})
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList, File paramFile)
  {
    int j = 0;
    if (!a) {
      return;
    }
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    if (paramFile != null)
    {
      localObject = paramFile.getAbsolutePath();
      if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
        break label221;
      }
      i = 0;
      if (i == 0) {
        locala.n = ((String)localObject);
      }
    }
    Object localObject = paramList;
    if (paramFile != null)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(paramFile);
    }
    if (locala.E() == null)
    {
      v.c("no setted SO , query so!", new Object[0]);
      paramList = "/data/data/" + paramContext.getPackageName() + "/lib/";
      u.a().b(new a(paramContext, paramList, (List)localObject));
    }
    paramList = NativeCrashHandler.getInstance();
    if (paramList != null) {
      if ((paramString == null) || (paramString.trim().length() <= 0)) {
        break label227;
      }
    }
    label221:
    label227:
    for (int i = j;; i = 1)
    {
      if (i == 0) {
        paramList.setDumpFilePath(paramString);
      }
      paramContext = NativeExceptionHandlerRQDImp.getInstance(paramContext);
      paramContext.setTombDir(paramString);
      NativeExceptionUpload.setmHandler(paramContext);
      c.a().e();
      c.a().a(0L);
      return;
      i = 1;
      break;
    }
  }
  
  public static boolean needUploadCrash(Context paramContext)
  {
    return countExceptionDatas(paramContext) > 0;
  }
  
  public static void putUserData(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      v.d("putUserData args context should not be null", new Object[0]);
      return;
    }
    if ((paramString1 != null) && (paramString1.trim().length() > 0)) {}
    for (int i = 0; i != 0; i = 1)
    {
      v.d("putUserData args key should not be null", new Object[0]);
      return;
    }
    if ((paramString2 != null) && (paramString2.trim().length() > 0)) {}
    for (i = 0; i != 0; i = 1)
    {
      v.d("putUserData args value should not be null", new Object[0]);
      return;
    }
    if (!paramString1.matches("[a-zA-Z[0-9]_]+"))
    {
      v.d("putUserData args key should match [a-zA-Z[0-9]_]+  {" + paramString1 + "}", new Object[0]);
      return;
    }
    String str = paramString2;
    if (paramString2.length() > 200)
    {
      v.d("user data value length over limit %d , has been cutted!", new Object[] { Integer.valueOf(200) });
      str = paramString2.substring(0, 200);
    }
    paramString2 = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    if (paramString2.z().contains(paramString1))
    {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, str);
      v.c("replace KV %s %s", new Object[] { paramString1, str });
      return;
    }
    if (paramString2.y() >= 100)
    {
      v.d("user data size is over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(10), paramString1 });
      return;
    }
    if (paramString1.length() > 50)
    {
      v.d("user data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, str);
    v.b("[param] set user data: %s - %s", new Object[] { paramString1, str });
  }
  
  public static void removePlugin(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).f(paramString);
  }
  
  public static String removeUserData(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      v.d("removeUserData args context should not be null", new Object[0]);
    }
    for (;;)
    {
      return null;
      if ((paramString != null) && (paramString.trim().length() > 0)) {}
      for (int i = 0; i == 0; i = 1)
      {
        v.b("[param] remove user data: %s", new Object[] { paramString });
        return com.tencent.bugly.crashreport.common.info.a.a(paramContext).h(paramString);
      }
    }
  }
  
  public static void setAPKSHa1(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).j = paramString;
    v.c("set sha1 %s", new Object[] { paramString });
  }
  
  public static void setCountryName(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).g(paramString);
  }
  
  public static void setCrashHandler(CrashHandleListener paramCrashHandleListener)
  {
    if (paramCrashHandleListener == null) {}
    do
    {
      return;
      d = paramCrashHandleListener;
      c = new e()
      {
        public final void a(boolean paramAnonymousBoolean)
        {
          this.a.onCrashHandleStart(paramAnonymousBoolean);
        }
        
        public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt, long paramAnonymousLong, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6)
        {
          return this.a.onCrashSaving(paramAnonymousBoolean, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt, paramAnonymousLong, paramAnonymousString4, paramAnonymousString5, paramAnonymousString6);
        }
        
        public final byte[] a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt, long paramAnonymousLong)
        {
          return this.a.getCrashExtraData(paramAnonymousBoolean, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, -1234567890, paramAnonymousLong);
        }
        
        public final String b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt, long paramAnonymousLong)
        {
          return this.a.getCrashExtraMessage(paramAnonymousBoolean, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, -1234567890, paramAnonymousLong);
        }
        
        public final boolean b(boolean paramAnonymousBoolean)
        {
          return this.a.onCrashHandleEnd(paramAnonymousBoolean);
        }
      };
      paramCrashHandleListener = c.a();
    } while (paramCrashHandleListener == null);
    paramCrashHandleListener.a(c);
  }
  
  public static void setCrashReportAble(boolean paramBoolean)
  {
    c localc = c.a();
    if (localc != null)
    {
      if (paramBoolean) {
        localc.c();
      }
    }
    else {
      return;
    }
    localc.b();
  }
  
  public static void setDatabaseCloseAfterUse(boolean paramBoolean)
  {
    com.tencent.bugly.proguard.n.a = paramBoolean;
  }
  
  public static void setDengta_AppKey(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).e = paramString;
  }
  
  public static void setDeviceId(Context paramContext, String paramString)
  {
    if (paramString != null) {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).c(paramString);
    }
  }
  
  public static void setDeviceRooted(Context paramContext, boolean paramBoolean)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(Boolean.valueOf(paramBoolean));
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      v.b = "eup";
      v.a = "eup";
      v.c = true;
      b.b = true;
      v.d("'setLogAble(boolean)' is true , so running in debug model , close it when you release!", new Object[0]);
      return;
    }
    v.c = false;
  }
  
  public static void setNativeCrashReportAble(boolean paramBoolean)
  {
    c localc = c.a();
    if (localc != null)
    {
      if (paramBoolean) {
        localc.e();
      }
      localc.d();
    }
  }
  
  public static void setProductID(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString);
  }
  
  public static void setProductVersion(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (paramString.length() > 100)
      {
        str = paramString.substring(0, 100);
        v.d("appVersion %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), str });
      }
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).l = str;
    }
  }
  
  public static void setRdmUuid(String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a();
    if (locala == null)
    {
      v.d("Can not set RDM UUID if RQD has not been initialized.", new Object[0]);
      return;
    }
    locala.y = paramString;
  }
  
  public static void setSOFile(Context paramContext, List<SOFile> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    HashMap localHashMap = new HashMap(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SOFile localSOFile = (SOFile)paramList.next();
      PlugInBean localPlugInBean = new PlugInBean(localSOFile.fileName, localSOFile.arch, localSOFile.sha1);
      localHashMap.put("sosha1_" + localSOFile.sha1, localPlugInBean);
    }
    paramContext.a(localHashMap);
  }
  
  public static void setThreadPoolService(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramScheduledExecutorService != null) {
      u.a().a(paramScheduledExecutorService);
    }
  }
  
  public static void setUserId(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (paramString.length() > 100)
      {
        str = paramString.substring(0, 100);
        v.d("userId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), str });
      }
    } while (str.equals(com.tencent.bugly.crashreport.common.info.a.a(paramContext).e()));
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(str);
    v.b("[user] set userId : %s", new Object[] { str });
  }
  
  public static void setUserSceneTag(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      v.d("setTag args context should not be null", new Object[0]);
      return;
    }
    if (paramInt <= 0)
    {
      v.d("setTag args tagId should > 0", new Object[0]);
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramInt);
    v.b("[param] set user scene tag: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public String[] getTables()
  {
    return new String[] { "t_cr" };
  }
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {}
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean == null) {}
    c localc;
    do
    {
      return;
      localc = c.a();
    } while (localc == null);
    localc.a(paramStrategyBean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\feedback\eup\CrashReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */