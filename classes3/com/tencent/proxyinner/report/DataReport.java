package com.tencent.proxyinner.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataReport
{
  private static final int MSG_BOOT_COMPLETE = 1;
  private static final int MSG_DOWNLOAD_COMPLETE = 3;
  private static final int MSG_DOWNLOAD_START = 2;
  private static final String TAG = "ODSDK|DataReport";
  public static DataReport sInstance = null;
  long bootTimeStart = 0L;
  long downloadTimeStart = 0L;
  long loadTimeStart = 0L;
  private CgiReporter mCgiReporter = new DefaultCgiReporter();
  private List<Event> mEventList = new ArrayList();
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Bundle localBundle = paramAnonymousMessage.getData();
      Iterator localIterator = DataReport.this.mEventList.iterator();
      while (localIterator.hasNext())
      {
        DataReport.Event localEvent = (DataReport.Event)localIterator.next();
        if (paramAnonymousMessage.what == 1) {
          localEvent.onDataReport("boot", localBundle);
        } else if (paramAnonymousMessage.what == 2) {
          localEvent.onDataReport("download_start", localBundle);
        } else if (paramAnonymousMessage.what == 3) {
          localEvent.onDataReport("download_complete", localBundle);
        }
      }
    }
  };
  private long mHostID = 0L;
  String mPluginID;
  private boolean mReportHost = false;
  private int mSourceChannelId;
  private String mSourceFromId;
  private String mSourceVersion;
  private int mVasType = 2;
  
  private Map<String, String> createCommonPairs()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("platform", "2");
      localHashMap.put("channelid", String.valueOf(this.mSourceChannelId));
      localHashMap.put("shellversion", String.valueOf(3));
      localHashMap.put("qiqiversion", this.mSourceVersion);
      localHashMap.put("fromid", this.mSourceFromId);
      localHashMap.put("vastype", String.valueOf(this.mVasType));
      localHashMap.put("qquin", String.valueOf(this.mHostID));
      localHashMap.put("sysversion", Build.VERSION.RELEASE);
      localHashMap.put("macversion", Build.MODEL);
      localHashMap.put("str5", this.mPluginID);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static DataReport getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new DataReport();
      }
      DataReport localDataReport = sInstance;
      return localDataReport;
    }
    finally {}
  }
  
  public void addListener(Event paramEvent)
  {
    if (paramEvent != null) {}
    try
    {
      this.mEventList.add(paramEvent);
      return;
    }
    finally
    {
      paramEvent = finally;
      throw paramEvent;
    }
  }
  
  public void reportAction(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      paramString4 = createCommonPairs();
      paramString4.put("action", paramString1);
      paramString4.put("int1", String.valueOf(paramInt1));
      paramString4.put("int2", String.valueOf(paramInt2));
      paramString4.put("int3", String.valueOf(paramInt1));
      paramString4.put("int4", String.valueOf(paramInt2));
      paramString4.put("int5", String.valueOf(paramInt1));
      paramString4.put("str1", String.valueOf(paramString2));
      paramString4.put("str2", String.valueOf(paramString3));
      paramString4.put("str3", String.valueOf(paramString2));
      paramString4.put("str4", String.valueOf(paramString3));
      paramString4.put("str5", String.valueOf(paramString2));
      this.mCgiReporter.reportPairs(paramString4);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void reportAction(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      Map localMap = createCommonPairs();
      localMap.put("action", paramString1);
      localMap.put("int1", String.valueOf(paramInt1));
      localMap.put("int2", String.valueOf(paramInt2));
      localMap.put("str1", String.valueOf(paramString2));
      localMap.put("str2", String.valueOf(paramString3));
      this.mCgiReporter.reportPairs(localMap);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void reportBootComplete(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 193	java/lang/System:currentTimeMillis	()J
    //   5: aload_0
    //   6: getfield 51	com/tencent/proxyinner/report/DataReport:bootTimeStart	J
    //   9: lsub
    //   10: lstore 7
    //   12: aload_0
    //   13: getfield 57	com/tencent/proxyinner/report/DataReport:mReportHost	Z
    //   16: ifeq +58 -> 74
    //   19: invokestatic 199	android/os/Message:obtain	()Landroid/os/Message;
    //   22: astore 5
    //   24: aload 5
    //   26: iconst_1
    //   27: putfield 202	android/os/Message:what	I
    //   30: new 204	android/os/Bundle
    //   33: dup
    //   34: invokespecial 205	android/os/Bundle:<init>	()V
    //   37: astore 6
    //   39: aload 6
    //   41: ldc -49
    //   43: iload_2
    //   44: invokevirtual 211	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   47: aload 6
    //   49: ldc -43
    //   51: lload 7
    //   53: l2i
    //   54: invokevirtual 211	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   57: aload 5
    //   59: aload 6
    //   61: invokevirtual 217	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   64: aload_0
    //   65: getfield 76	com/tencent/proxyinner/report/DataReport:mHandler	Landroid/os/Handler;
    //   68: aload 5
    //   70: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   73: pop
    //   74: ldc 20
    //   76: ldc -32
    //   78: invokestatic 230	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_0
    //   83: invokespecial 155	com/tencent/proxyinner/report/DataReport:createCommonPairs	()Ljava/util/Map;
    //   86: astore 6
    //   88: aload 6
    //   90: ldc -43
    //   92: lload 7
    //   94: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   97: invokeinterface 93 3 0
    //   102: pop
    //   103: aload 6
    //   105: ldc -99
    //   107: ldc -24
    //   109: invokeinterface 93 3 0
    //   114: pop
    //   115: iload_1
    //   116: ifeq +27 -> 143
    //   119: aload 6
    //   121: ldc -97
    //   123: ldc -22
    //   125: invokeinterface 93 3 0
    //   130: pop
    //   131: aload_0
    //   132: getfield 69	com/tencent/proxyinner/report/DataReport:mCgiReporter	Lcom/tencent/proxyinner/report/CgiReporter;
    //   135: aload 6
    //   137: invokevirtual 184	com/tencent/proxyinner/report/CgiReporter:reportPairs	(Ljava/util/Map;)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: aload 6
    //   145: ldc -97
    //   147: ldc 87
    //   149: invokeinterface 93 3 0
    //   154: pop
    //   155: aload 6
    //   157: ldc -95
    //   159: iload_2
    //   160: invokestatic 103	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   163: invokeinterface 93 3 0
    //   168: pop
    //   169: aload 6
    //   171: ldc -93
    //   173: iload_3
    //   174: invokestatic 103	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   177: invokeinterface 93 3 0
    //   182: pop
    //   183: aload 4
    //   185: astore 5
    //   187: aload 4
    //   189: ifnonnull +7 -> 196
    //   192: ldc -20
    //   194: astore 5
    //   196: aload 6
    //   198: ldc -87
    //   200: aload 5
    //   202: invokeinterface 93 3 0
    //   207: pop
    //   208: goto -77 -> 131
    //   211: astore 4
    //   213: aload_0
    //   214: monitorexit
    //   215: aload 4
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	DataReport
    //   0	218	1	paramBoolean	boolean
    //   0	218	2	paramInt1	int
    //   0	218	3	paramInt2	int
    //   0	218	4	paramString	String
    //   22	179	5	localObject1	Object
    //   37	160	6	localObject2	Object
    //   10	83	7	l	long
    // Exception table:
    //   from	to	target	type
    //   2	74	211	finally
    //   74	115	211	finally
    //   119	131	211	finally
    //   131	140	211	finally
    //   143	183	211	finally
    //   196	208	211	finally
  }
  
  public void reportDownloadComplete(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, int paramInt6, int paramInt7, String paramString3)
  {
    try
    {
      Log.i("ODSDK|DataReport", "reportDownloadComplete");
      long l = System.currentTimeMillis() - this.downloadTimeStart;
      if (this.mReportHost)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 3;
        Bundle localBundle = new Bundle();
        localBundle.putInt("errcode", paramInt1);
        localBundle.putInt("type", paramInt2);
        localBundle.putInt("trigger", paramInt3);
        localBundle.putInt("timeconsume", (int)l);
        ((Message)localObject).setData(localBundle);
        this.mHandler.sendMessage((Message)localObject);
      }
      Object localObject = createCommonPairs();
      ((Map)localObject).put("action", "download");
      ((Map)localObject).put("timeconsume", String.valueOf(l));
      ((Map)localObject).put("int1", "2");
      ((Map)localObject).put("int2", String.valueOf(paramInt1));
      ((Map)localObject).put("int3", String.valueOf(paramInt3));
      ((Map)localObject).put("int4", String.valueOf(paramInt2));
      ((Map)localObject).put("int5", String.valueOf(paramInt4));
      ((Map)localObject).put("str1", paramString1);
      ((Map)localObject).put("str2", paramString2);
      ((Map)localObject).put("str3", String.valueOf(paramInt6) + " " + String.valueOf(paramInt7));
      ((Map)localObject).put("str4", String.valueOf(paramInt5));
      ((Map)localObject).put("str5", paramString3);
      this.mCgiReporter.reportPairs((Map)localObject);
      return;
    }
    finally {}
  }
  
  public void reportDownloadStart(int paramInt1, int paramInt2)
  {
    try
    {
      Log.i("ODSDK|DataReport", "reportDownloadStart");
      this.downloadTimeStart = System.currentTimeMillis();
      if (this.mReportHost)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 2;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", paramInt1);
        localBundle.putInt("trigger", paramInt2);
        ((Message)localObject1).setData(localBundle);
        this.mHandler.sendMessage((Message)localObject1);
      }
      Object localObject1 = createCommonPairs();
      ((Map)localObject1).put("action", "download");
      ((Map)localObject1).put("int1", "1");
      ((Map)localObject1).put("int3", String.valueOf(paramInt2));
      ((Map)localObject1).put("int4", String.valueOf(paramInt1));
      this.mCgiReporter.reportPairs((Map)localObject1);
      return;
    }
    finally {}
  }
  
  public void reportDuplicateEnterDuringDownload()
  {
    try
    {
      Map localMap = createCommonPairs();
      localMap.put("action", "dupplicateenterdownload");
      this.mCgiReporter.reportPairs(localMap);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void reportException(String paramString)
  {
    try
    {
      Map localMap = createCommonPairs();
      localMap.put("action", paramString);
      this.mCgiReporter.reportPairs(localMap);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reportLoadStart(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      this.loadTimeStart = System.currentTimeMillis();
      Map localMap = createCommonPairs();
      localMap.put("action", "bootstart");
      localMap.put("int1", String.valueOf(paramInt));
      localMap.put("str1", paramString1);
      localMap.put("str2", paramString2);
      this.mCgiReporter.reportPairs(localMap);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void reportUserCancelDuringDownload(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    try
    {
      Log.i("ODSDK|DataReport", "reportUserCancelDuringDownload");
      long l = System.currentTimeMillis() - this.downloadTimeStart;
      if (this.mReportHost)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 3;
        Bundle localBundle = new Bundle();
        localBundle.putInt("status", paramInt1);
        localBundle.putInt("step", paramInt3);
        localBundle.putInt("trigger", paramInt4);
        localBundle.putInt("timeconsume", (int)l);
        ((Message)localObject1).setData(localBundle);
        this.mHandler.sendMessage((Message)localObject1);
      }
      Object localObject1 = createCommonPairs();
      ((Map)localObject1).put("action", "usercancel");
      ((Map)localObject1).put("timeconsume", String.valueOf(l));
      ((Map)localObject1).put("int1", String.valueOf(paramInt2));
      ((Map)localObject1).put("int2", String.valueOf(paramInt3));
      ((Map)localObject1).put("int3", String.valueOf(paramInt1));
      ((Map)localObject1).put("int4", String.valueOf(paramInt4));
      this.mCgiReporter.reportPairs((Map)localObject1);
      return;
    }
    finally {}
  }
  
  public void reportUserReload(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Log.i("ODSDK|DataReport", "reportUserReload");
      if (this.mReportHost) {}
      Map localMap = createCommonPairs();
      localMap.put("action", "userreload");
      localMap.put("int1", String.valueOf(paramInt2));
      localMap.put("int3", String.valueOf(paramInt3));
      localMap.put("int4", String.valueOf(paramInt1));
      this.mCgiReporter.reportPairs(localMap);
      return;
    }
    finally {}
  }
  
  public void setSourceFromId(String paramString)
  {
    try
    {
      this.mSourceFromId = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setSourceInfo(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, boolean paramBoolean)
  {
    try
    {
      this.mSourceVersion = paramString2;
      this.mSourceChannelId = paramInt2;
      this.mReportHost = paramBoolean;
      this.mVasType = paramInt1;
      this.mHostID = paramLong;
      this.mPluginID = paramString1;
      Log.i("ODSDK|DataReport", "Using DefaultCgiReporter ");
      this.mCgiReporter = new DefaultCgiReporter();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static abstract interface Event
  {
    public abstract void onDataReport(String paramString, Bundle paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\report\DataReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */