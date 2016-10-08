package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TbsDownloadConfig
{
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  private static final int DEFAULT_DOWNLOAD_FAILED_MAX_RETRYTIMES = 100;
  private static final int DEFAULT_DOWNLOAD_MAX_FLOW = 20;
  private static final int DEFAULT_DOWNLOAD_MIN_FREE_SPACE = 70;
  private static final long DEFAULT_DOWNLOAD_SINGLE_TIMEOUT = 1200000L;
  private static final int DEFAULT_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = 3;
  public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400L;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  static final int INTERRUPT_CODE_DEFALUT = -99;
  static final int INTERRUPT_TIME_OUT = -98;
  private static final long INTERRUPT_TIME_OUT_INTERVAL = 86400000L;
  static final int NEEDDOWNLOAD_API_LEVEL_BELOW_FROYO = -102;
  static final int NEEDDOWNLOAD_DEFAULT = -100;
  static final int NEEDDOWNLOAD_DEVICE_CUPABI_IN_BLACKLIST = -104;
  static final int NEEDDOWNLOAD_DISABLE_OVERSEA = -103;
  static final int NEEDDOWNLOAD_INIT_THREAD_EXCEPTION = -105;
  static final int NEEDDOWNLOAD_READ_RESPONSE_ARGS_ERROR = -112;
  static final int NEEDDOWNLOAD_READ_RESPONSE_EMPTY = -108;
  static final int NEEDDOWNLOAD_READ_RESPONSE_HAS_LOCAL_VERSION = -113;
  static final int NEEDDOWNLOAD_READ_RESPONSE_RESET_TBS = -110;
  static final int NEEDDOWNLOAD_READ_RESPONSE_RESPONSE_CODE_ZERO = -111;
  static final int NEEDDOWNLOAD_READ_RESPONSE_RET_ERROR = -109;
  static final int NEEDDOWNLOAD_SEND_REQUEST_LOCAL_EXCEPTION = -106;
  static final int NEEDDOWNLOAD_SEND_REQUEST_SERVER_EXCEPTION = -107;
  static final int NEEDDOWNLOAD_UNCALL = -101;
  static final int STARTDOWNLOAD_API_LEVEL_BELOW_FROYO = -201;
  static final int STARTDOWNLOAD_DEFAULT = -200;
  static final int STARTDOWNLOAD_DEVICE_CUPABI_IN_BLACKLIST = -205;
  static final int STARTDOWNLOAD_FINISH = -215;
  static final int STARTDOWNLOAD_INIT_THREAD_EXCEPTION = -202;
  static final int STARTDOWNLOAD_NOSDCARD_WRITEABLE_PERMISSION = -204;
  static final int STARTDOWNLOAD_PROCESS_LOCKED = -203;
  static final int STARTDOWNLOAD_READ_RESPONSE_ARGS_ERROR = -212;
  static final int STARTDOWNLOAD_READ_RESPONSE_EMPTY = -208;
  static final int STARTDOWNLOAD_READ_RESPONSE_HAS_LOCAL_APK = -214;
  static final int STARTDOWNLOAD_READ_RESPONSE_HAS_LOCAL_VERSION = -213;
  static final int STARTDOWNLOAD_READ_RESPONSE_RESET_TBS = -210;
  static final int STARTDOWNLOAD_READ_RESPONSE_RESPONSE_CODE_ZERO = -211;
  static final int STARTDOWNLOAD_READ_RESPONSE_RET_ERROR = -209;
  static final int STARTDOWNLOAD_SEND_REQUEST_LOCAL_EXCEPTION = -206;
  static final int STARTDOWNLOAD_SEND_REQUEST_SERVER_EXCEPTION = -207;
  private static final String TBS_CFG_FILE = "tbs_download_config";
  private static TbsDownloadConfig mInstance;
  SharedPreferences mPreferences;
  Map<String, Object> mSyncMap = new HashMap();
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = mInstance;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsDownloadConfig(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.mSyncMap.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        Iterator localIterator = this.mSyncMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label203;
        }
        str = (String)localIterator.next();
        localObject2 = this.mSyncMap.get(str);
        if ((localObject2 instanceof String))
        {
          localEditor.putString(str, (String)localObject2);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        if ((localObject2 instanceof Boolean))
        {
          localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
          continue;
        }
      }
      finally {}
      if ((localObject2 instanceof Long))
      {
        ((SharedPreferences.Editor)localObject1).putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        ((SharedPreferences.Editor)localObject1).putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Float))
      {
        ((SharedPreferences.Editor)localObject1).putFloat(str, ((Float)localObject2).floatValue());
        continue;
        label203:
        ((SharedPreferences.Editor)localObject1).commit();
        this.mSyncMap.clear();
      }
    }
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 100;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getDownloadInterruptCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: ldc -11
    //   8: invokeinterface 249 2 0
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +10 -> 25
    //   18: bipush -101
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: invokestatic 254	java/lang/System:currentTimeMillis	()J
    //   28: aload_0
    //   29: getfield 135	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   32: ldc_w 256
    //   35: lconst_0
    //   36: invokeinterface 260 4 0
    //   41: lsub
    //   42: ldc2_w 45
    //   45: lcmp
    //   46: ifle +9 -> 55
    //   49: bipush -98
    //   51: istore_2
    //   52: goto -31 -> 21
    //   55: aload_0
    //   56: getfield 135	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   59: ldc -11
    //   61: bipush -99
    //   63: invokeinterface 242 3 0
    //   68: istore_2
    //   69: goto -48 -> 21
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	TbsDownloadConfig
    //   72	4	1	localObject	Object
    //   20	49	2	i	int
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	72	finally
    //   25	49	72	finally
    //   55	69	72	finally
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int j = i;
      if (i == 0) {
        j = 20;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getDownloadMinFreeSpace()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_min_free_space", 0);
      int j = i;
      if (i == 0) {
        j = 70;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l1 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l2 = l1;
      if (l1 == 0L) {
        l2 = 1200000L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 3;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getRetryInterval()
  {
    try
    {
      long l = this.mPreferences.getLong("retry_interval", 86400L);
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isOverSea()
  {
    try
    {
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void setDownloadInterruptCode(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 156 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc -11
    //   15: iload_1
    //   16: invokeinterface 225 3 0
    //   21: pop
    //   22: aload_2
    //   23: ldc_w 256
    //   26: invokestatic 254	java/lang/System:currentTimeMillis	()J
    //   29: invokeinterface 215 4 0
    //   34: pop
    //   35: aload_2
    //   36: invokeinterface 164 1 0
    //   41: pop
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    //   50: astore_2
    //   51: goto -9 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TbsDownloadConfig
    //   0	54	1	paramInt	int
    //   11	25	2	localEditor	SharedPreferences.Editor
    //   45	4	2	localObject	Object
    //   50	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	42	45	finally
    //   2	42	50	java/lang/Exception
  }
  
  public static abstract interface TbsConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
    public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
    public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
    public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
    public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
    public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
    public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
    public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
    public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
    public static final String KEY_IS_OVERSEA = "is_oversea";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
    public static final String KEY_RESPONSECODE = "tbs_responsecode";
    public static final String KEY_RETRY_INTERVAL = "retry_interval";
    public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
    public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
    public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
    public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
    public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
    public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsDownloadConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */