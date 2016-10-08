package com.tencent.tmassistantsdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class TMAssistantCallYYB_V1
  extends TMAssistantBaseCallYYB
  implements com.tencent.tmassistantsdk.internal.openSDK.b
{
  public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
  public static final Uri CONTENT_URI = com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.b.a;
  protected static final String TAG = "TMAssistantCallYYB_V1";
  protected static TMAssistantCallYYB_V1 mInstance = null;
  Map<String, TMAssistantCallYYBParamStruct> mDownloadParams = null;
  protected int sdkAPILevel = 1;
  
  public static TMAssistantCallYYB_V1 getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantCallYYB_V1();
      }
      TMAssistantCallYYB_V1 localTMAssistantCallYYB_V1 = mInstance;
      return localTMAssistantCallYYB_V1;
    }
    finally {}
  }
  
  private boolean isFileExist(String paramString)
  {
    if (new File(paramString).exists())
    {
      m.c("TMAssistantCallYYB_V1", "File is exist");
      return true;
    }
    m.c("TMAssistantCallYYB_V1", "File is not exist");
    return false;
  }
  
  private void relateToQQDownloader(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    m.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",param = " + paramTMAssistantCallYYBParamStruct + ",taskId = " + paramString);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, false, false, paramString);
    paramTMAssistantCallYYBParamStruct.put("taskid", paramString);
    paramTMAssistantCallYYBParamStruct = super.formatIntentUriPath(4, paramTMAssistantCallYYBParamStruct);
    paramString = new Intent("com.tencent.android.qqdownloader.action.RELATED");
    paramString.setPackage("com.tencent.android.qqdownloader");
    paramString.putExtra("command", "cmd_updatedownload");
    paramString.putExtra("relatedurl", paramTMAssistantCallYYBParamStruct);
    paramContext.sendBroadcast(paramString);
  }
  
  public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    m.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if ((this.mDownloadParams != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
      StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_addDownloadTaskFromAppDetail");
      com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 2, str);
    m.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    m.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",verifyType = " + paramString);
    String str = UUID.randomUUID().toString();
    if ((this.mDownloadParams != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
      StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_addDownloadTaskFromAuthorize");
      com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, true, true, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, 3, str);
    m.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(String paramString)
  {
    m.c("TMAssistantCallYYB_V1", "url = " + paramString);
    paramString = super.formatEncryptUrl(paramString);
    long l = System.currentTimeMillis();
    l = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L, 0, null);
    m.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    m.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if ((this.mDownloadParams != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
      StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_addDownloadTaskFromTaskList");
      com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 1, str);
    m.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    m.c("TMAssistantCallYYB_V1", "mContext = " + this.mContext);
    NetworkMonitorReceiver.a().c();
    com.tencent.tmassistantsdk.internal.c.e.a().d();
    com.tencent.tmassistantsdk.internal.c.e.a().b();
    if (this.mContext != null)
    {
      DownloadStateChangedReceiver.a().b(this.mContext);
      DownloadStateChangedReceiver.a().b(this);
    }
    f.a().c();
    this.mContext = null;
  }
  
  /* Error */
  public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 230	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   4: ifnonnull +22 -> 26
    //   7: ldc 15
    //   9: ldc_w 272
    //   12: invokestatic 275	com/tencent/tmassistantbase/a/m:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 270	java/lang/Exception
    //   18: dup
    //   19: ldc_w 277
    //   22: invokespecial 278	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: aload_1
    //   27: ifnonnull +22 -> 49
    //   30: ldc 15
    //   32: ldc_w 280
    //   35: invokestatic 275	com/tencent/tmassistantbase/a/m:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: new 270	java/lang/Exception
    //   41: dup
    //   42: ldc_w 282
    //   45: invokespecial 278	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: ldc 15
    //   51: new 72	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   58: ldc -119
    //   60: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 66	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 230	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   77: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   80: astore_2
    //   81: aload_2
    //   82: getstatic 33	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:CONTENT_URI	Landroid/net/Uri;
    //   85: aconst_null
    //   86: ldc_w 288
    //   89: iconst_3
    //   90: anewarray 290	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: getfield 293	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload_1
    //   103: getfield 296	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   106: invokestatic 300	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   109: aastore
    //   110: dup
    //   111: iconst_2
    //   112: aload_1
    //   113: getfield 303	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:channelId	Ljava/lang/String;
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 309	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore_2
    //   122: ldc 15
    //   124: new 72	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 311
    //   134: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: getfield 293	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   141: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 313
    //   147: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: getfield 296	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   154: invokestatic 300	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   157: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 315
    //   163: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: getfield 303	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:channelId	Ljava/lang/String;
    //   170: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 317	com/tencent/tmassistantbase/a/m:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_2
    //   180: ifnull +521 -> 701
    //   183: aload_2
    //   184: invokeinterface 322 1 0
    //   189: ifeq +512 -> 701
    //   192: ldc 15
    //   194: new 72	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 324
    //   204: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: getfield 293	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   211: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 66	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_2
    //   221: aload_2
    //   222: ldc_w 326
    //   225: invokeinterface 330 2 0
    //   230: invokeinterface 334 2 0
    //   235: lstore 7
    //   237: aload_2
    //   238: aload_2
    //   239: ldc_w 336
    //   242: invokeinterface 330 2 0
    //   247: invokeinterface 339 2 0
    //   252: invokestatic 342	com/tencent/tmassistantbase/a/f:c	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   255: iconst_0
    //   256: invokevirtual 348	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   259: checkcast 290	java/lang/String
    //   262: astore_3
    //   263: aload_2
    //   264: aload_2
    //   265: ldc_w 350
    //   268: invokeinterface 330 2 0
    //   273: invokeinterface 339 2 0
    //   278: astore 4
    //   280: aload_2
    //   281: aload_2
    //   282: ldc_w 352
    //   285: invokeinterface 330 2 0
    //   290: invokeinterface 334 2 0
    //   295: lstore 9
    //   297: aload_2
    //   298: aload_2
    //   299: ldc_w 354
    //   302: invokeinterface 330 2 0
    //   307: invokeinterface 334 2 0
    //   312: lstore 11
    //   314: aload_2
    //   315: aload_2
    //   316: ldc_w 356
    //   319: invokeinterface 330 2 0
    //   324: invokeinterface 360 2 0
    //   329: invokestatic 362	com/tencent/tmassistantbase/a/f:a	(I)I
    //   332: istore 6
    //   334: ldc 15
    //   336: new 72	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 364
    //   346: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: iload 6
    //   351: invokevirtual 367	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 66	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: iconst_4
    //   361: iload 6
    //   363: if_icmpne +28 -> 391
    //   366: aload_0
    //   367: aload 4
    //   369: invokespecial 369	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:isFileExist	(Ljava/lang/String;)Z
    //   372: istore 13
    //   374: iload 13
    //   376: ifne +15 -> 391
    //   379: aload_2
    //   380: ifnull +9 -> 389
    //   383: aload_2
    //   384: invokeinterface 372 1 0
    //   389: aconst_null
    //   390: areturn
    //   391: new 374	com/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo
    //   394: dup
    //   395: aload_3
    //   396: aload 4
    //   398: iload 6
    //   400: lload 9
    //   402: lload 11
    //   404: ldc_w 376
    //   407: invokespecial 379	com/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   410: astore 4
    //   412: aload 4
    //   414: astore_3
    //   415: aload_0
    //   416: getfield 41	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   419: ifnull +158 -> 577
    //   422: aload_0
    //   423: getfield 41	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   426: invokeinterface 383 1 0
    //   431: invokeinterface 389 1 0
    //   436: astore_3
    //   437: aload_3
    //   438: invokeinterface 394 1 0
    //   443: ifeq +252 -> 695
    //   446: aload_3
    //   447: invokeinterface 398 1 0
    //   452: checkcast 400	java/util/Map$Entry
    //   455: invokeinterface 403 1 0
    //   460: checkcast 170	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct
    //   463: astore 5
    //   465: aload 5
    //   467: ifnull -30 -> 437
    //   470: aload 5
    //   472: getfield 293	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   475: aload_1
    //   476: getfield 293	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   479: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   482: ifeq -45 -> 437
    //   485: aload 5
    //   487: getfield 296	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   490: aload_1
    //   491: getfield 296	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   494: if_icmpne -57 -> 437
    //   497: iconst_1
    //   498: istore 6
    //   500: aload 4
    //   502: astore_3
    //   503: iload 6
    //   505: ifne +72 -> 577
    //   508: ldc 15
    //   510: new 72	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 324
    //   520: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_1
    //   524: getfield 293	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   527: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 66	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: invokestatic 150	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   539: invokevirtual 151	java/util/UUID:toString	()Ljava/lang/String;
    //   542: astore_3
    //   543: aload_1
    //   544: lload 7
    //   546: invokestatic 410	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   549: putfield 413	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskApkId	Ljava/lang/String;
    //   552: aload_0
    //   553: getfield 41	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   556: aload_3
    //   557: aload_1
    //   558: invokeinterface 102 3 0
    //   563: pop
    //   564: aload_0
    //   565: aload_0
    //   566: getfield 230	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   569: aload_1
    //   570: aload_3
    //   571: invokespecial 415	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct;Ljava/lang/String;)V
    //   574: aload 4
    //   576: astore_3
    //   577: aload_3
    //   578: astore 4
    //   580: aload_2
    //   581: ifnull +12 -> 593
    //   584: aload_2
    //   585: invokeinterface 372 1 0
    //   590: aload_3
    //   591: astore 4
    //   593: ldc 15
    //   595: new 72	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 417
    //   605: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 4
    //   610: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 66	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload 4
    //   621: areturn
    //   622: astore_3
    //   623: aconst_null
    //   624: astore_2
    //   625: aconst_null
    //   626: astore_1
    //   627: aload_3
    //   628: invokevirtual 420	java/lang/Exception:printStackTrace	()V
    //   631: ldc 15
    //   633: ldc_w 422
    //   636: aload_3
    //   637: invokestatic 425	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   640: aload_1
    //   641: astore 4
    //   643: aload_2
    //   644: ifnull -51 -> 593
    //   647: aload_2
    //   648: invokeinterface 372 1 0
    //   653: aload_1
    //   654: astore 4
    //   656: goto -63 -> 593
    //   659: astore_1
    //   660: aconst_null
    //   661: astore_2
    //   662: aload_2
    //   663: ifnull +9 -> 672
    //   666: aload_2
    //   667: invokeinterface 372 1 0
    //   672: aload_1
    //   673: athrow
    //   674: astore_1
    //   675: goto -13 -> 662
    //   678: astore_1
    //   679: goto -17 -> 662
    //   682: astore_3
    //   683: aconst_null
    //   684: astore_1
    //   685: goto -58 -> 627
    //   688: astore_3
    //   689: aload 4
    //   691: astore_1
    //   692: goto -65 -> 627
    //   695: iconst_0
    //   696: istore 6
    //   698: goto -198 -> 500
    //   701: aconst_null
    //   702: astore_3
    //   703: goto -126 -> 577
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	TMAssistantCallYYB_V1
    //   0	706	1	paramTMAssistantCallYYBParamStruct	TMAssistantCallYYBParamStruct
    //   80	587	2	localObject1	Object
    //   262	329	3	localObject2	Object
    //   622	15	3	localException1	Exception
    //   682	1	3	localException2	Exception
    //   688	1	3	localException3	Exception
    //   702	1	3	localObject3	Object
    //   278	412	4	localObject4	Object
    //   463	23	5	localTMAssistantCallYYBParamStruct	TMAssistantCallYYBParamStruct
    //   332	365	6	i	int
    //   235	310	7	l1	long
    //   295	106	9	l2	long
    //   312	91	11	l3	long
    //   372	3	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   81	122	622	java/lang/Exception
    //   81	122	659	finally
    //   122	179	674	finally
    //   183	360	674	finally
    //   366	374	674	finally
    //   391	412	674	finally
    //   415	437	674	finally
    //   437	465	674	finally
    //   470	497	674	finally
    //   508	574	674	finally
    //   627	640	678	finally
    //   122	179	682	java/lang/Exception
    //   183	360	682	java/lang/Exception
    //   366	374	682	java/lang/Exception
    //   391	412	682	java/lang/Exception
    //   415	437	688	java/lang/Exception
    //   437	465	688	java/lang/Exception
    //   470	497	688	java/lang/Exception
    //   508	574	688	java/lang/Exception
  }
  
  public void initTMAssistantCallYYBApi(Context paramContext)
  {
    m.c("TMAssistantCallYYB_V1", "context = " + paramContext);
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = f.c(this.mContext);
    f.a().a(this.mContext);
    this.sdkAPILevel = 1;
    DownloadStateChangedReceiver.a().a(this.mContext);
    DownloadStateChangedReceiver.a().a(this);
    NetworkMonitorReceiver.a().b();
    com.tencent.tmassistantsdk.internal.c.e.a();
  }
  
  public void onDownloadStateChanged(com.tencent.tmassistantsdk.internal.openSDK.e parame)
  {
    m.c("TMAssistantCallYYB_V1", "stateChangedParam = " + parame);
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = parame.a;
    int i = f.a(parame.e);
    int j = f.b(parame.f);
    Object localObject2 = parame.g;
    Object localObject3 = parame.d;
    m.c("TMAssistantCallYYB_V1", "onDownloadStateChanged state = " + i);
    Object localObject1 = null;
    parame = (com.tencent.tmassistantsdk.internal.openSDK.e)localObject1;
    if (localObject3 != null)
    {
      parame = (com.tencent.tmassistantsdk.internal.openSDK.e)localObject1;
      if (((String)localObject3).trim().length() > 0) {
        parame = (TMAssistantCallYYBParamStruct)this.mDownloadParams.get(localObject3);
      }
    }
    if (parame != null) {
      onStateChanged(parame, i, j, (String)localObject2);
    }
    while (6 == i)
    {
      parame = new ArrayList();
      localObject1 = this.mDownloadParams.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (TMAssistantCallYYBParamStruct)((Map.Entry)localObject3).getValue();
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          if ((localObject2 != null) && (!TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.taskPackageName)) && (((TMAssistantCallYYBParamStruct)localObject2).taskPackageName.equals(localTMAssistantCallYYBParamStruct.taskPackageName)) && (((TMAssistantCallYYBParamStruct)localObject2).taskVersion == localTMAssistantCallYYBParamStruct.taskVersion))
          {
            parame.add(localObject3);
            continue;
            m.c("TMAssistantCallYYB_V1", "onDownloadStateChanged storeParam = null");
            break;
          }
        }
      }
      parame = parame.iterator();
      while (parame.hasNext())
      {
        localObject1 = (String)parame.next();
        this.mDownloadParams.remove(localObject1);
      }
    }
  }
  
  public void startToAppDetail(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      m.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    m.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
    }
    StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_startToAppDetail");
    com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, str);
    paramTMAssistantCallYYBParamStruct.put("taskid", str);
    paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, paramTMAssistantCallYYBParamStruct)));
    if ((paramContext instanceof Application)) {
      paramTMAssistantCallYYBParamStruct.addFlags(268435456);
    }
    paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
  }
  
  public void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    if (paramContext == null)
    {
      m.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMAssistantCallYYBParamStruct == null)
    {
      m.e("TMAssistantCallYYB_V1", "QQDownloaderParam param is null");
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    m.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",param = " + paramTMAssistantCallYYBParamStruct + ",verifyType = " + paramString);
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
    }
    StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_startToAuthorized");
    com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, true, true, str);
    paramTMAssistantCallYYBParamStruct.put("verifytype", paramString);
    paramTMAssistantCallYYBParamStruct.put("taskid", str);
    paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, paramTMAssistantCallYYBParamStruct)));
    if ((paramContext instanceof Application)) {
      paramTMAssistantCallYYBParamStruct.addFlags(268435456);
    }
    paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    m.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",jumpUrl = " + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(paramString)));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
  
  public void startToDownloadTaskList(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      m.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMAssistantCallYYBParamStruct == null)
    {
      m.e("TMAssistantCallYYB_V1", "param is null");
      return;
    }
    m.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
    }
    StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_startToDownloadTaskList");
    com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, str);
    paramTMAssistantCallYYBParamStruct.put("taskid", str);
    paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, paramTMAssistantCallYYBParamStruct)));
    if ((paramContext instanceof Application)) {
      paramTMAssistantCallYYBParamStruct.addFlags(268435456);
    }
    paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      m.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      m.e("TMAssistantCallYYB_V1", "url is null");
      throw new Exception("param url shouldn't be null!");
    }
    m.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",url = " + paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    paramString = super.formatIntentUriPath(5, localHashMap);
    m.c("TMAssistantCallYYB_V1", "startToWebView finalPath:" + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\TMAssistantCallYYB_V1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */