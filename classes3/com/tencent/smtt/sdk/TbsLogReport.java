package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.SysCoreQua2Utils;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

class TbsLogReport
{
  private static final String KEY_TBSDOWNLOAD_UPLOAD = "tbs_download_upload";
  protected static final String LOGTAG = "upload";
  static final int MAX_CALLSTACK_LENGTH = 1024;
  private static final String TBSAPK_DOWNLOAD_STAT_FILENAME = "tbs_download_stat";
  private static TbsLogReport mInstance;
  private String mApn;
  private String mCheckErrorDetail;
  private Context mContext;
  private long mDownConsumeTime;
  private int mDownFinalFlag;
  private String mDownUrl;
  private int mDownloadCancel;
  private long mDownloadSize;
  int mErrorCode;
  private long mEventTime;
  private String mFailDetail;
  private int mHttpCode;
  private int mNetworkChange;
  private int mNetworkType;
  private int mPatchUpdateFlag;
  private long mPkgSize;
  private String mResolveIp;
  private int mUnpkgFlag;
  
  private TbsLogReport(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    resetArgs();
  }
  
  private String addData(int paramInt)
  {
    return paramInt + "|";
  }
  
  private String addData(long paramLong)
  {
    return paramLong + "|";
  }
  
  private String addData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private void clearUploadData()
  {
    SharedPreferences.Editor localEditor = sharedPreferences().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private String formatTime(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsLogReport(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private JSONArray getUploadData()
  {
    Object localObject = sharedPreferences().getString("tbs_download_upload", null);
    if (localObject == null) {
      return new JSONArray();
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      return (JSONArray)localObject;
    }
    catch (Exception localException) {}
    return new JSONArray();
  }
  
  private void resetArgs()
  {
    this.mEventTime = 0L;
    this.mDownUrl = null;
    this.mResolveIp = null;
    this.mHttpCode = 0;
    this.mPatchUpdateFlag = 0;
    this.mDownloadCancel = 0;
    this.mUnpkgFlag = 2;
    this.mApn = "unknown";
    this.mNetworkType = 0;
    this.mDownFinalFlag = 2;
    this.mPkgSize = 0L;
    this.mDownConsumeTime = 0L;
    this.mNetworkChange = 1;
    this.mErrorCode = 0;
    this.mCheckErrorDetail = null;
    this.mFailDetail = null;
    this.mDownloadSize = 0L;
  }
  
  private SharedPreferences sharedPreferences()
  {
    return this.mContext.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public void clear()
  {
    try
    {
      resetArgs();
      SharedPreferences.Editor localEditor = sharedPreferences().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public int getDownFinalFlag()
  {
    return this.mDownFinalFlag;
  }
  
  public void reportDownloadStat()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] Run in UIThread, Report delay");
      return;
    }
    try
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
      JSONArray localJSONArray = getUploadData();
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
        return;
      }
    }
    finally {}
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      String str = HttpUtil.postData(TbsCommonConfig.getInstance(this.mContext).getTbsDownloadStatPostUrl(), ((JSONArray)localObject).toString().getBytes("utf-8"), new HttpUtil.HttpResponseListener()
      {
        public void onHttpResponseCode(int paramAnonymousInt)
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramAnonymousInt);
          if (paramAnonymousInt < 300) {
            TbsLogReport.this.clearUploadData();
          }
        }
      }, true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + str + " testcase: " + -1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  /* Error */
  public void reportTbsLog()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   7: invokestatic 281	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   10: iconst_3
    //   11: if_icmpeq +4 -> 15
    //   14: return
    //   15: invokestatic 284	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   18: astore 5
    //   20: aload 5
    //   22: ifnull -8 -> 14
    //   25: invokestatic 289	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   28: invokevirtual 292	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
    //   31: astore 8
    //   33: aload_0
    //   34: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   37: invokestatic 298	com/tencent/smtt/utils/AppUtil:getImei	(Landroid/content/Context;)Ljava/lang/String;
    //   40: astore_2
    //   41: aload_0
    //   42: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   45: invokestatic 301	com/tencent/smtt/utils/AppUtil:getAndroidID	(Landroid/content/Context;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_2
    //   50: invokevirtual 304	java/lang/String:getBytes	()[B
    //   53: astore_2
    //   54: aload_1
    //   55: invokevirtual 304	java/lang/String:getBytes	()[B
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: invokestatic 289	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   64: aload_2
    //   65: invokevirtual 308	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   68: astore_2
    //   69: aload_2
    //   70: astore_1
    //   71: invokestatic 289	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   74: aload_3
    //   75: invokevirtual 308	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   78: astore 4
    //   80: aload 4
    //   82: astore_1
    //   83: aload_2
    //   84: astore_3
    //   85: aload_1
    //   86: astore_2
    //   87: aload_3
    //   88: invokestatic 312	com/tencent/smtt/utils/Post3DESEncryption:bytesToHex	([B)Ljava/lang/String;
    //   91: astore_1
    //   92: aload_2
    //   93: invokestatic 312	com/tencent/smtt/utils/Post3DESEncryption:bytesToHex	([B)Ljava/lang/String;
    //   96: astore_2
    //   97: new 77	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   104: aload_0
    //   105: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   108: invokestatic 247	com/tencent/smtt/utils/TbsCommonConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/utils/TbsCommonConfig;
    //   111: invokevirtual 315	com/tencent/smtt/utils/TbsCommonConfig:getTbsLogPostUrl	()Ljava/lang/String;
    //   114: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 317
    //   124: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_2
    //   128: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore 9
    //   136: new 319	java/util/HashMap
    //   139: dup
    //   140: invokespecial 320	java/util/HashMap:<init>	()V
    //   143: astore 10
    //   145: aload 10
    //   147: ldc_w 322
    //   150: ldc_w 324
    //   153: invokeinterface 330 3 0
    //   158: pop
    //   159: aload 10
    //   161: ldc_w 332
    //   164: ldc_w 334
    //   167: invokeinterface 330 3 0
    //   172: pop
    //   173: aload 10
    //   175: ldc_w 336
    //   178: aload_0
    //   179: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   182: invokestatic 341	com/tencent/smtt/utils/SysCoreQua2Utils:getQUA2	(Landroid/content/Context;)Ljava/lang/String;
    //   185: invokeinterface 330 3 0
    //   190: pop
    //   191: new 343	java/io/File
    //   194: dup
    //   195: getstatic 348	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   198: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: pop
    //   202: new 15	com/tencent/smtt/sdk/TbsLogReport$ZipHelper
    //   205: dup
    //   206: aload 5
    //   208: new 77	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   215: getstatic 348	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   218: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 351
    //   224: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 353	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: invokevirtual 356	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:Zip	()V
    //   236: new 343	java/io/File
    //   239: dup
    //   240: getstatic 348	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   243: ldc_w 358
    //   246: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: astore 4
    //   251: new 361	java/io/FileInputStream
    //   254: dup
    //   255: aload 4
    //   257: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   260: astore_3
    //   261: sipush 8192
    //   264: newarray <illegal type>
    //   266: astore_2
    //   267: new 366	java/io/ByteArrayOutputStream
    //   270: dup
    //   271: invokespecial 367	java/io/ByteArrayOutputStream:<init>	()V
    //   274: astore_1
    //   275: aload_1
    //   276: astore 7
    //   278: aload 4
    //   280: astore 6
    //   282: aload_3
    //   283: astore 5
    //   285: aload_3
    //   286: aload_2
    //   287: invokevirtual 371	java/io/FileInputStream:read	([B)I
    //   290: istore 11
    //   292: iload 11
    //   294: iconst_m1
    //   295: if_icmpeq +111 -> 406
    //   298: aload_1
    //   299: astore 7
    //   301: aload 4
    //   303: astore 6
    //   305: aload_3
    //   306: astore 5
    //   308: aload_1
    //   309: aload_2
    //   310: iconst_0
    //   311: iload 11
    //   313: invokevirtual 375	java/io/ByteArrayOutputStream:write	([BII)V
    //   316: goto -41 -> 275
    //   319: astore_2
    //   320: aload_1
    //   321: astore 7
    //   323: aload 4
    //   325: astore 6
    //   327: aload_3
    //   328: astore 5
    //   330: aload_2
    //   331: invokevirtual 376	java/lang/Exception:printStackTrace	()V
    //   334: aload_3
    //   335: ifnull +7 -> 342
    //   338: aload_3
    //   339: invokevirtual 379	java/io/FileInputStream:close	()V
    //   342: aload_1
    //   343: ifnull +7 -> 350
    //   346: aload_1
    //   347: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   350: aload 4
    //   352: ifnull +240 -> 592
    //   355: aload 4
    //   357: invokevirtual 383	java/io/File:delete	()Z
    //   360: pop
    //   361: aconst_null
    //   362: astore_1
    //   363: new 77	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   370: aload 9
    //   372: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 385
    //   378: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 8
    //   383: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: aload 10
    //   391: aload_1
    //   392: new 8	com/tencent/smtt/sdk/TbsLogReport$2
    //   395: dup
    //   396: aload_0
    //   397: invokespecial 386	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   400: iconst_0
    //   401: invokestatic 389	com/tencent/smtt/utils/HttpUtil:postData	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/HttpUtil$HttpResponseListener;Z)Ljava/lang/String;
    //   404: pop
    //   405: return
    //   406: aload_1
    //   407: astore 7
    //   409: aload 4
    //   411: astore 6
    //   413: aload_3
    //   414: astore 5
    //   416: aload_1
    //   417: invokevirtual 392	java/io/ByteArrayOutputStream:flush	()V
    //   420: aload_1
    //   421: astore 7
    //   423: aload 4
    //   425: astore 6
    //   427: aload_3
    //   428: astore 5
    //   430: invokestatic 289	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   433: aload_1
    //   434: invokevirtual 395	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   437: invokevirtual 308	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   440: astore_2
    //   441: aload_3
    //   442: ifnull +7 -> 449
    //   445: aload_3
    //   446: invokevirtual 379	java/io/FileInputStream:close	()V
    //   449: aload_1
    //   450: ifnull +7 -> 457
    //   453: aload_1
    //   454: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   457: aload_2
    //   458: astore_1
    //   459: aload 4
    //   461: ifnull -98 -> 363
    //   464: aload 4
    //   466: invokevirtual 383	java/io/File:delete	()Z
    //   469: pop
    //   470: aload_2
    //   471: astore_1
    //   472: goto -109 -> 363
    //   475: astore_1
    //   476: aconst_null
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_2
    //   481: aload_2
    //   482: ifnull +7 -> 489
    //   485: aload_2
    //   486: invokevirtual 379	java/io/FileInputStream:close	()V
    //   489: aload 7
    //   491: ifnull +8 -> 499
    //   494: aload 7
    //   496: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   499: aload 4
    //   501: ifnull +9 -> 510
    //   504: aload 4
    //   506: invokevirtual 383	java/io/File:delete	()Z
    //   509: pop
    //   510: aload_1
    //   511: athrow
    //   512: astore_3
    //   513: goto -64 -> 449
    //   516: astore_1
    //   517: goto -60 -> 457
    //   520: astore_2
    //   521: goto -179 -> 342
    //   524: astore_1
    //   525: goto -175 -> 350
    //   528: astore_2
    //   529: goto -40 -> 489
    //   532: astore_2
    //   533: goto -34 -> 499
    //   536: astore_1
    //   537: aconst_null
    //   538: astore_2
    //   539: goto -58 -> 481
    //   542: astore_1
    //   543: aload_3
    //   544: astore_2
    //   545: goto -64 -> 481
    //   548: astore_1
    //   549: aload 6
    //   551: astore 4
    //   553: aload 5
    //   555: astore_2
    //   556: goto -75 -> 481
    //   559: astore_2
    //   560: aconst_null
    //   561: astore_1
    //   562: aconst_null
    //   563: astore 4
    //   565: aconst_null
    //   566: astore_3
    //   567: goto -247 -> 320
    //   570: astore_2
    //   571: aconst_null
    //   572: astore_1
    //   573: aconst_null
    //   574: astore_3
    //   575: goto -255 -> 320
    //   578: astore_2
    //   579: aconst_null
    //   580: astore_1
    //   581: goto -261 -> 320
    //   584: astore_2
    //   585: aload_3
    //   586: astore_2
    //   587: aload_1
    //   588: astore_3
    //   589: goto -502 -> 87
    //   592: aconst_null
    //   593: astore_1
    //   594: goto -231 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	TbsLogReport
    //   48	424	1	localObject1	Object
    //   475	36	1	localObject2	Object
    //   516	1	1	localException1	Exception
    //   524	1	1	localException2	Exception
    //   536	1	1	localObject3	Object
    //   542	1	1	localObject4	Object
    //   548	1	1	localObject5	Object
    //   561	33	1	localObject6	Object
    //   40	270	2	localObject7	Object
    //   319	12	2	localException3	Exception
    //   440	46	2	arrayOfByte	byte[]
    //   520	1	2	localException4	Exception
    //   528	1	2	localException5	Exception
    //   532	1	2	localException6	Exception
    //   538	18	2	localObject8	Object
    //   559	1	2	localException7	Exception
    //   570	1	2	localException8	Exception
    //   578	1	2	localException9	Exception
    //   584	1	2	localException10	Exception
    //   586	1	2	localObject9	Object
    //   58	388	3	localObject10	Object
    //   512	32	3	localException11	Exception
    //   566	23	3	localObject11	Object
    //   78	486	4	localObject12	Object
    //   18	536	5	localObject13	Object
    //   280	270	6	localObject14	Object
    //   1	494	7	localObject15	Object
    //   31	351	8	str1	String
    //   134	237	9	str2	String
    //   143	247	10	localHashMap	java.util.HashMap
    //   290	22	11	i	int
    // Exception table:
    //   from	to	target	type
    //   285	292	319	java/lang/Exception
    //   308	316	319	java/lang/Exception
    //   416	420	319	java/lang/Exception
    //   430	441	319	java/lang/Exception
    //   191	251	475	finally
    //   445	449	512	java/lang/Exception
    //   453	457	516	java/lang/Exception
    //   338	342	520	java/lang/Exception
    //   346	350	524	java/lang/Exception
    //   485	489	528	java/lang/Exception
    //   494	499	532	java/lang/Exception
    //   251	261	536	finally
    //   261	275	542	finally
    //   285	292	548	finally
    //   308	316	548	finally
    //   330	334	548	finally
    //   416	420	548	finally
    //   430	441	548	finally
    //   191	251	559	java/lang/Exception
    //   251	261	570	java/lang/Exception
    //   261	275	578	java/lang/Exception
    //   61	69	584	java/lang/Exception
    //   71	80	584	java/lang/Exception
  }
  
  public void saveUploadData(EventType paramEventType)
  {
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(addData(paramEventType.value));
    localStringBuilder.append(addData(AppUtil.getImei(this.mContext)));
    localStringBuilder.append(addData(SysCoreQua2Utils.getQUA2(this.mContext)));
    localStringBuilder.append(addData(TbsInstaller.getInstance().getTbsCoreInstalledVer(this.mContext)));
    paramEventType = Build.MODEL;
    try
    {
      localObject = new String(paramEventType.getBytes("UTF-8"), "ISO8859-1");
      paramEventType = (EventType)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        localStringBuilder.append(addData(AppUtil.getAppVersionCode(this.mContext)));
      }
    }
    localStringBuilder.append(addData(paramEventType));
    paramEventType = this.mContext.getPackageName();
    localStringBuilder.append(addData(paramEventType));
    if ("com.tencent.mm".equals(paramEventType))
    {
      localStringBuilder.append(addData(AppUtil.getAppMetadata(this.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(addData(formatTime(this.mEventTime)));
      localStringBuilder.append(addData(this.mDownUrl));
      localStringBuilder.append(addData(this.mResolveIp));
      localStringBuilder.append(addData(this.mHttpCode));
      localStringBuilder.append(addData(this.mPatchUpdateFlag));
      localStringBuilder.append(addData(this.mDownloadCancel));
      localStringBuilder.append(addData(this.mUnpkgFlag));
      localStringBuilder.append(addData(this.mApn));
      localStringBuilder.append(addData(this.mNetworkType));
      localStringBuilder.append(addData(this.mDownFinalFlag));
      localStringBuilder.append(addData(this.mDownloadSize));
      localStringBuilder.append(addData(this.mPkgSize));
      localStringBuilder.append(addData(this.mDownConsumeTime));
      localStringBuilder.append(addData(this.mNetworkChange));
      localStringBuilder.append(addData(this.mErrorCode));
      localStringBuilder.append(addData(this.mCheckErrorDetail));
      localStringBuilder.append(addData(this.mFailDetail));
      localStringBuilder.append(addData(TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(addData(AppUtil.getAndroidID(this.mContext)));
      localStringBuilder.append(addData("2.2.0.1095_36548"));
      localStringBuilder.append(false);
      localObject = sharedPreferences();
      paramEventType = getUploadData();
      paramEventType.put(localStringBuilder.toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("tbs_download_upload", paramEventType.toString());
      ((SharedPreferences.Editor)localObject).commit();
      resetArgs();
      new Thread(new Runnable()
      {
        public void run()
        {
          TbsLogReport.this.reportDownloadStat();
        }
      }).start();
      return;
    }
  }
  
  public void setApn(String paramString)
  {
    this.mApn = paramString;
  }
  
  public void setCheckErrorDetail(String paramString)
  {
    setErrorCode(108);
    this.mCheckErrorDetail = paramString;
  }
  
  public void setDownConsumeTime(long paramLong)
  {
    this.mDownConsumeTime += paramLong;
  }
  
  public void setDownFinalFlag(int paramInt)
  {
    this.mDownFinalFlag = paramInt;
  }
  
  public void setDownloadCancel(int paramInt)
  {
    this.mDownloadCancel = paramInt;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.mDownloadSize += paramLong;
  }
  
  public void setDownloadUrl(String paramString)
  {
    if (this.mDownUrl == null)
    {
      this.mDownUrl = paramString;
      return;
    }
    this.mDownUrl = (this.mDownUrl + ";" + paramString);
  }
  
  public void setErrorCode(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
      TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
    }
    if (paramInt == 111) {
      TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
    }
    this.mErrorCode = paramInt;
  }
  
  public void setEventTime(long paramLong)
  {
    this.mEventTime = paramLong;
  }
  
  public void setFailDetail(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = paramString;
    if (paramString.length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    this.mFailDetail = str;
  }
  
  public void setFailDetail(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.mFailDetail = "";
      return;
    }
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    this.mFailDetail = paramThrowable;
  }
  
  public void setHttpCode(int paramInt)
  {
    this.mHttpCode = paramInt;
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    setErrorCode(paramInt);
    setEventTime(System.currentTimeMillis());
    setFailDetail(paramString);
    QbSdk.mTbsListenerWrapper.onInstallFinish(paramInt);
    saveUploadData(EventType.TYPE_INSTALL);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    setFailDetail(paramThrowable);
    setInstallErrorCode(paramInt, this.mFailDetail);
  }
  
  public void setLoadErrorCode(int paramInt, String paramString)
  {
    setErrorCode(paramInt);
    setEventTime(System.currentTimeMillis());
    setFailDetail(paramString);
    saveUploadData(EventType.TYPE_LOAD);
  }
  
  public void setLoadErrorCode(int paramInt, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      String str = "msg: " + paramThrowable.getMessage() + "; err: " + paramThrowable + "; cause: " + Log.getStackTraceString(paramThrowable.getCause());
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
    }
    for (this.mFailDetail = paramThrowable;; this.mFailDetail = "NULL")
    {
      setLoadErrorCode(paramInt, this.mFailDetail);
      return;
    }
  }
  
  public void setNetworkChange(int paramInt)
  {
    this.mNetworkChange = paramInt;
  }
  
  public void setNetworkType(int paramInt)
  {
    this.mNetworkType = paramInt;
  }
  
  public void setPatchUpdateFlag(int paramInt)
  {
    this.mPatchUpdateFlag = paramInt;
  }
  
  public void setPkgSize(long paramLong)
  {
    this.mPkgSize = paramLong;
  }
  
  public void setResolveIp(String paramString)
  {
    this.mResolveIp = paramString;
  }
  
  public void setUnpkgFlag(int paramInt)
  {
    this.mUnpkgFlag = paramInt;
  }
  
  public static enum EventType
  {
    TYPE_DOWNLOAD(0),  TYPE_INSTALL(1),  TYPE_LOAD(2);
    
    int value;
    
    private EventType(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static class ZipHelper
  {
    private static final int BUFFER = 2048;
    private final String files;
    private final String zipFile;
    
    public ZipHelper(String paramString1, String paramString2)
    {
      this.files = paramString1;
      this.zipFile = paramString2;
    }
    
    /* Error */
    private static void replaceWrongZipByte(java.io.File paramFile)
      throws java.io.IOException
    {
      // Byte code:
      //   0: new 31	java/io/RandomAccessFile
      //   3: dup
      //   4: aload_0
      //   5: ldc 33
      //   7: invokespecial 36	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   10: astore_1
      //   11: aload_1
      //   12: ifnull +61 -> 73
      //   15: aload_1
      //   16: astore_0
      //   17: ldc 38
      //   19: iconst_2
      //   20: invokestatic 44	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   23: istore_3
      //   24: aload_1
      //   25: astore_0
      //   26: aload_1
      //   27: ldc2_w 45
      //   30: invokevirtual 50	java/io/RandomAccessFile:seek	(J)V
      //   33: aload_1
      //   34: astore_0
      //   35: aload_1
      //   36: invokevirtual 54	java/io/RandomAccessFile:read	()I
      //   39: istore 4
      //   41: iload 4
      //   43: iload_3
      //   44: iand
      //   45: ifle +28 -> 73
      //   48: aload_1
      //   49: astore_0
      //   50: aload_1
      //   51: ldc2_w 45
      //   54: invokevirtual 50	java/io/RandomAccessFile:seek	(J)V
      //   57: aload_1
      //   58: astore_0
      //   59: aload_1
      //   60: iload_3
      //   61: iconst_m1
      //   62: ixor
      //   63: sipush 255
      //   66: iand
      //   67: iload 4
      //   69: iand
      //   70: invokevirtual 58	java/io/RandomAccessFile:write	(I)V
      //   73: aload_1
      //   74: ifnull +7 -> 81
      //   77: aload_1
      //   78: invokevirtual 61	java/io/RandomAccessFile:close	()V
      //   81: return
      //   82: astore_0
      //   83: aload_0
      //   84: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   87: return
      //   88: astore_2
      //   89: aconst_null
      //   90: astore_1
      //   91: aload_1
      //   92: astore_0
      //   93: aload_2
      //   94: invokevirtual 65	java/lang/Exception:printStackTrace	()V
      //   97: aload_1
      //   98: ifnull -17 -> 81
      //   101: aload_1
      //   102: invokevirtual 61	java/io/RandomAccessFile:close	()V
      //   105: return
      //   106: astore_0
      //   107: aload_0
      //   108: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   111: return
      //   112: astore_1
      //   113: aconst_null
      //   114: astore_0
      //   115: aload_0
      //   116: ifnull +7 -> 123
      //   119: aload_0
      //   120: invokevirtual 61	java/io/RandomAccessFile:close	()V
      //   123: aload_1
      //   124: athrow
      //   125: astore_0
      //   126: aload_0
      //   127: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   130: goto -7 -> 123
      //   133: astore_1
      //   134: goto -19 -> 115
      //   137: astore_2
      //   138: goto -47 -> 91
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	paramFile	java.io.File
      //   10	92	1	localRandomAccessFile	java.io.RandomAccessFile
      //   112	12	1	localObject1	Object
      //   133	1	1	localObject2	Object
      //   88	6	2	localException1	Exception
      //   137	1	2	localException2	Exception
      //   23	40	3	i	int
      //   39	31	4	j	int
      // Exception table:
      //   from	to	target	type
      //   77	81	82	java/io/IOException
      //   0	11	88	java/lang/Exception
      //   101	105	106	java/io/IOException
      //   0	11	112	finally
      //   119	123	125	java/io/IOException
      //   17	24	133	finally
      //   26	33	133	finally
      //   35	41	133	finally
      //   50	57	133	finally
      //   59	73	133	finally
      //   93	97	133	finally
      //   17	24	137	java/lang/Exception
      //   26	33	137	java/lang/Exception
      //   35	41	137	java/lang/Exception
      //   50	57	137	java/lang/Exception
      //   59	73	137	java/lang/Exception
    }
    
    /* Error */
    public void Zip()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore_1
      //   5: new 69	java/io/FileOutputStream
      //   8: dup
      //   9: aload_0
      //   10: getfield 22	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:zipFile	Ljava/lang/String;
      //   13: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   16: astore_3
      //   17: new 74	java/util/zip/ZipOutputStream
      //   20: dup
      //   21: new 76	java/io/BufferedOutputStream
      //   24: dup
      //   25: aload_3
      //   26: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   29: invokespecial 80	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   32: astore 5
      //   34: sipush 2048
      //   37: newarray <illegal type>
      //   39: astore 6
      //   41: aload_0
      //   42: getfield 20	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:files	Ljava/lang/String;
      //   45: astore 7
      //   47: new 82	java/io/FileInputStream
      //   50: dup
      //   51: aload 7
      //   53: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   56: astore 4
      //   58: new 85	java/io/BufferedInputStream
      //   61: dup
      //   62: aload 4
      //   64: sipush 2048
      //   67: invokespecial 88	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   70: astore_2
      //   71: aload 5
      //   73: new 90	java/util/zip/ZipEntry
      //   76: dup
      //   77: aload 7
      //   79: aload 7
      //   81: ldc 92
      //   83: invokevirtual 98	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   86: iconst_1
      //   87: iadd
      //   88: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
      //   91: invokespecial 103	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   94: invokevirtual 107	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   97: aload_2
      //   98: aload 6
      //   100: iconst_0
      //   101: sipush 2048
      //   104: invokevirtual 110	java/io/BufferedInputStream:read	([BII)I
      //   107: istore 8
      //   109: iload 8
      //   111: iconst_m1
      //   112: if_icmpeq +79 -> 191
      //   115: aload 5
      //   117: aload 6
      //   119: iconst_0
      //   120: iload 8
      //   122: invokevirtual 113	java/util/zip/ZipOutputStream:write	([BII)V
      //   125: goto -28 -> 97
      //   128: astore 6
      //   130: aload 4
      //   132: astore_1
      //   133: aload 6
      //   135: astore 4
      //   137: aload 4
      //   139: invokevirtual 65	java/lang/Exception:printStackTrace	()V
      //   142: aload_2
      //   143: ifnull +7 -> 150
      //   146: aload_2
      //   147: invokevirtual 114	java/io/BufferedInputStream:close	()V
      //   150: aload_1
      //   151: ifnull +7 -> 158
      //   154: aload_1
      //   155: invokevirtual 115	java/io/FileInputStream:close	()V
      //   158: new 117	java/io/File
      //   161: dup
      //   162: aload_0
      //   163: getfield 22	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:zipFile	Ljava/lang/String;
      //   166: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
      //   169: invokestatic 120	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:replaceWrongZipByte	(Ljava/io/File;)V
      //   172: aload 5
      //   174: ifnull +8 -> 182
      //   177: aload 5
      //   179: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
      //   182: aload_3
      //   183: ifnull +7 -> 190
      //   186: aload_3
      //   187: invokevirtual 122	java/io/FileOutputStream:close	()V
      //   190: return
      //   191: aload 5
      //   193: invokevirtual 125	java/util/zip/ZipOutputStream:flush	()V
      //   196: aload 5
      //   198: invokevirtual 128	java/util/zip/ZipOutputStream:closeEntry	()V
      //   201: aload_2
      //   202: ifnull +7 -> 209
      //   205: aload_2
      //   206: invokevirtual 114	java/io/BufferedInputStream:close	()V
      //   209: aload 4
      //   211: ifnull -53 -> 158
      //   214: aload 4
      //   216: invokevirtual 115	java/io/FileInputStream:close	()V
      //   219: goto -61 -> 158
      //   222: astore_1
      //   223: aload_1
      //   224: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   227: goto -69 -> 158
      //   230: astore_2
      //   231: aload_3
      //   232: astore_1
      //   233: aload 5
      //   235: astore_3
      //   236: aload_2
      //   237: invokevirtual 65	java/lang/Exception:printStackTrace	()V
      //   240: aload_3
      //   241: ifnull +7 -> 248
      //   244: aload_3
      //   245: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
      //   248: aload_1
      //   249: ifnull -59 -> 190
      //   252: aload_1
      //   253: invokevirtual 122	java/io/FileOutputStream:close	()V
      //   256: return
      //   257: astore_1
      //   258: aload_1
      //   259: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   262: return
      //   263: astore_1
      //   264: aload_1
      //   265: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   268: goto -59 -> 209
      //   271: astore_1
      //   272: aload 5
      //   274: astore_2
      //   275: aload_2
      //   276: ifnull +7 -> 283
      //   279: aload_2
      //   280: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
      //   283: aload_3
      //   284: ifnull +7 -> 291
      //   287: aload_3
      //   288: invokevirtual 122	java/io/FileOutputStream:close	()V
      //   291: aload_1
      //   292: athrow
      //   293: astore_2
      //   294: aload_2
      //   295: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   298: goto -148 -> 150
      //   301: astore_1
      //   302: aload_1
      //   303: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   306: goto -148 -> 158
      //   309: astore_1
      //   310: aconst_null
      //   311: astore_2
      //   312: aconst_null
      //   313: astore 4
      //   315: aload_2
      //   316: ifnull +7 -> 323
      //   319: aload_2
      //   320: invokevirtual 114	java/io/BufferedInputStream:close	()V
      //   323: aload 4
      //   325: ifnull +8 -> 333
      //   328: aload 4
      //   330: invokevirtual 115	java/io/FileInputStream:close	()V
      //   333: aload_1
      //   334: athrow
      //   335: astore_2
      //   336: aload_2
      //   337: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   340: goto -17 -> 323
      //   343: astore_2
      //   344: aload_2
      //   345: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   348: goto -15 -> 333
      //   351: astore_1
      //   352: aload_1
      //   353: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   356: goto -174 -> 182
      //   359: astore_1
      //   360: aload_1
      //   361: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   364: return
      //   365: astore_2
      //   366: aload_2
      //   367: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   370: goto -122 -> 248
      //   373: astore_2
      //   374: aload_2
      //   375: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   378: goto -95 -> 283
      //   381: astore_2
      //   382: aload_2
      //   383: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   386: goto -95 -> 291
      //   389: astore_1
      //   390: aconst_null
      //   391: astore_2
      //   392: aconst_null
      //   393: astore_3
      //   394: goto -119 -> 275
      //   397: astore_1
      //   398: aconst_null
      //   399: astore_2
      //   400: goto -125 -> 275
      //   403: astore 4
      //   405: aload_3
      //   406: astore_2
      //   407: aload_1
      //   408: astore_3
      //   409: aload 4
      //   411: astore_1
      //   412: goto -137 -> 275
      //   415: astore_2
      //   416: aconst_null
      //   417: astore_1
      //   418: aload 4
      //   420: astore_3
      //   421: goto -185 -> 236
      //   424: astore_2
      //   425: aload_3
      //   426: astore_1
      //   427: aload 4
      //   429: astore_3
      //   430: goto -194 -> 236
      //   433: astore_1
      //   434: aconst_null
      //   435: astore_2
      //   436: goto -121 -> 315
      //   439: astore_1
      //   440: goto -125 -> 315
      //   443: astore 6
      //   445: aload_1
      //   446: astore 4
      //   448: aload 6
      //   450: astore_1
      //   451: goto -136 -> 315
      //   454: astore 4
      //   456: aconst_null
      //   457: astore_2
      //   458: goto -321 -> 137
      //   461: astore 6
      //   463: aconst_null
      //   464: astore_2
      //   465: aload 4
      //   467: astore_1
      //   468: aload 6
      //   470: astore 4
      //   472: goto -335 -> 137
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	475	0	this	ZipHelper
      //   4	151	1	localObject1	Object
      //   222	2	1	localIOException1	java.io.IOException
      //   232	21	1	localObject2	Object
      //   257	2	1	localIOException2	java.io.IOException
      //   263	2	1	localIOException3	java.io.IOException
      //   271	21	1	localObject3	Object
      //   301	2	1	localIOException4	java.io.IOException
      //   309	25	1	localObject4	Object
      //   351	2	1	localIOException5	java.io.IOException
      //   359	2	1	localIOException6	java.io.IOException
      //   389	1	1	localObject5	Object
      //   397	11	1	localObject6	Object
      //   411	16	1	localObject7	Object
      //   433	1	1	localObject8	Object
      //   439	7	1	localObject9	Object
      //   450	18	1	localObject10	Object
      //   70	136	2	localBufferedInputStream	java.io.BufferedInputStream
      //   230	7	2	localException1	Exception
      //   274	6	2	localZipOutputStream1	java.util.zip.ZipOutputStream
      //   293	2	2	localIOException7	java.io.IOException
      //   311	9	2	localObject11	Object
      //   335	2	2	localIOException8	java.io.IOException
      //   343	2	2	localIOException9	java.io.IOException
      //   365	2	2	localIOException10	java.io.IOException
      //   373	2	2	localIOException11	java.io.IOException
      //   381	2	2	localIOException12	java.io.IOException
      //   391	16	2	localObject12	Object
      //   415	1	2	localException2	Exception
      //   424	1	2	localException3	Exception
      //   435	30	2	localObject13	Object
      //   16	414	3	localObject14	Object
      //   1	328	4	localObject15	Object
      //   403	25	4	localObject16	Object
      //   446	1	4	localObject17	Object
      //   454	12	4	localException4	Exception
      //   470	1	4	localObject18	Object
      //   32	241	5	localZipOutputStream2	java.util.zip.ZipOutputStream
      //   39	79	6	arrayOfByte	byte[]
      //   128	6	6	localException5	Exception
      //   443	6	6	localObject19	Object
      //   461	8	6	localException6	Exception
      //   45	35	7	str	String
      //   107	14	8	i	int
      // Exception table:
      //   from	to	target	type
      //   71	97	128	java/lang/Exception
      //   97	109	128	java/lang/Exception
      //   115	125	128	java/lang/Exception
      //   191	201	128	java/lang/Exception
      //   214	219	222	java/io/IOException
      //   34	47	230	java/lang/Exception
      //   146	150	230	java/lang/Exception
      //   154	158	230	java/lang/Exception
      //   158	172	230	java/lang/Exception
      //   205	209	230	java/lang/Exception
      //   214	219	230	java/lang/Exception
      //   223	227	230	java/lang/Exception
      //   264	268	230	java/lang/Exception
      //   294	298	230	java/lang/Exception
      //   302	306	230	java/lang/Exception
      //   319	323	230	java/lang/Exception
      //   328	333	230	java/lang/Exception
      //   333	335	230	java/lang/Exception
      //   336	340	230	java/lang/Exception
      //   344	348	230	java/lang/Exception
      //   252	256	257	java/io/IOException
      //   205	209	263	java/io/IOException
      //   34	47	271	finally
      //   146	150	271	finally
      //   154	158	271	finally
      //   158	172	271	finally
      //   205	209	271	finally
      //   214	219	271	finally
      //   223	227	271	finally
      //   264	268	271	finally
      //   294	298	271	finally
      //   302	306	271	finally
      //   319	323	271	finally
      //   328	333	271	finally
      //   333	335	271	finally
      //   336	340	271	finally
      //   344	348	271	finally
      //   146	150	293	java/io/IOException
      //   154	158	301	java/io/IOException
      //   47	58	309	finally
      //   319	323	335	java/io/IOException
      //   328	333	343	java/io/IOException
      //   177	182	351	java/io/IOException
      //   186	190	359	java/io/IOException
      //   244	248	365	java/io/IOException
      //   279	283	373	java/io/IOException
      //   287	291	381	java/io/IOException
      //   5	17	389	finally
      //   17	34	397	finally
      //   236	240	403	finally
      //   5	17	415	java/lang/Exception
      //   17	34	424	java/lang/Exception
      //   58	71	433	finally
      //   71	97	439	finally
      //   97	109	439	finally
      //   115	125	439	finally
      //   191	201	439	finally
      //   137	142	443	finally
      //   47	58	454	java/lang/Exception
      //   58	71	461	java/lang/Exception
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsLogReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */