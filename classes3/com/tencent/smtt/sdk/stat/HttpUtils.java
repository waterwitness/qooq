package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.SysCoreQua2Utils;
import com.tencent.smtt.utils.TbsCommonConfig;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class HttpUtils
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final int DEFAULT_TIME_OUT = 20000;
  private static final String LOGTAG = "HttpUtils";
  public static byte[] POST_DATA_KEY = null;
  private static final int PROTOCOL_VERSION = 3;
  private static final int TIDTYPE_MM = 0;
  private static final int TIDTYPE_QQ = 1;
  private static final String qqPackageName = "com.tencent.mobileqq";
  
  static
  {
    try
    {
      POST_DATA_KEY = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  public static void doReport(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject3 = "";
    Object localObject2 = localObject3;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
      Object localObject1 = localObject3;
      localObject2 = localObject3;
      if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
      {
        localObject2 = localObject3;
        localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
        {
          localObject2 = localObject3;
          localObject1 = (String)localObject3 + "." + QbSdk.getQQBuildNumber();
        }
      }
      for (;;) {}
    }
    catch (Exception localException)
    {
      try
      {
        localObject2 = new ThirdAppInfoNew();
        ((ThirdAppInfoNew)localObject2).sAppName = paramContext.getApplicationInfo().packageName;
        TbsCommonConfig.getInstance(paramContext);
        localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
        ((ThirdAppInfoNew)localObject2).sTime = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
        ((ThirdAppInfoNew)localObject2).sGuid = paramString1;
        if (paramBoolean) {}
        for (((ThirdAppInfoNew)localObject2).sQua2 = paramString2;; ((ThirdAppInfoNew)localObject2).sQua2 = SysCoreQua2Utils.getQUA2(paramContext))
        {
          ((ThirdAppInfoNew)localObject2).sLc = paramString3;
          paramString1 = AppUtil.getMacAddress(paramContext);
          paramString2 = AppUtil.getImei(paramContext);
          paramString3 = AppUtil.getImsi(paramContext);
          localObject3 = AppUtil.getAndroidID(paramContext);
          if ((paramString2 != null) && (!"".equals(paramString2))) {
            ((ThirdAppInfoNew)localObject2).sImei = paramString2;
          }
          if ((paramString3 != null) && (!"".equals(paramString3))) {
            ((ThirdAppInfoNew)localObject2).sImsi = paramString3;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ThirdAppInfoNew)localObject2).sAndroidID = ((String)localObject3);
          }
          if ((paramString1 != null) && (!"".equals(paramString1))) {
            ((ThirdAppInfoNew)localObject2).sMac = paramString1;
          }
          ((ThirdAppInfoNew)localObject2).iPv = paramInt;
          if (!paramBoolean) {
            break label384;
          }
          paramInt = 1;
          ((ThirdAppInfoNew)localObject2).iCoreType = paramInt;
          ((ThirdAppInfoNew)localObject2).sAppVersionName = ((String)localObject1);
          ((ThirdAppInfoNew)localObject2).sAppSignature = getSHA1(paramContext);
          if (!paramBoolean)
          {
            ((ThirdAppInfoNew)localObject2).sWifiConnectedTime = paramLong;
            ((ThirdAppInfoNew)localObject2).localCoreVersion = QbSdk.getTbsVersion(paramContext);
          }
          post((ThirdAppInfoNew)localObject2, paramContext);
          return;
          localException = localException;
          localObject1 = localObject2;
          localException.printStackTrace();
          break;
        }
        paramInt = 0;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  private static org.json.JSONObject getPostData(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: new 236	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 237	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc -17
    //   11: aload_0
    //   12: getfield 118	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   15: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_2
    //   20: ldc -11
    //   22: aload_0
    //   23: getfield 159	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   26: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_2
    //   31: ldc -9
    //   33: aload_0
    //   34: getfield 165	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   37: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_2
    //   42: ldc -7
    //   44: aload_0
    //   45: getfield 168	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   48: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_2
    //   53: ldc -5
    //   55: aload_0
    //   56: getfield 162	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   59: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_2
    //   64: ldc -3
    //   66: aload_0
    //   67: getfield 186	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   70: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_2
    //   75: ldc -1
    //   77: aload_0
    //   78: getfield 189	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   81: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_2
    //   86: ldc_w 257
    //   89: aload_0
    //   90: getfield 195	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   93: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload_2
    //   98: ldc_w 259
    //   101: aload_0
    //   102: getfield 199	MTT/ThirdAppInfoNew:iPv	J
    //   105: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   108: pop
    //   109: aload_2
    //   110: ldc_w 264
    //   113: aload_0
    //   114: getfield 202	MTT/ThirdAppInfoNew:iCoreType	I
    //   117: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload_2
    //   122: ldc_w 269
    //   125: aload_0
    //   126: getfield 205	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   129: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: pop
    //   133: aload_0
    //   134: getfield 211	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   137: ifnonnull +152 -> 289
    //   140: aload_2
    //   141: ldc_w 271
    //   144: ldc_w 273
    //   147: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_2
    //   152: ldc_w 274
    //   155: iconst_3
    //   156: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 276
    //   164: aload_0
    //   165: getfield 192	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   168: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload_0
    //   173: getfield 202	MTT/ThirdAppInfoNew:iCoreType	I
    //   176: ifne +67 -> 243
    //   179: aload_2
    //   180: ldc_w 278
    //   183: aload_0
    //   184: getfield 214	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   187: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_2
    //   192: ldc_w 280
    //   195: aload_0
    //   196: getfield 221	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   199: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   202: pop
    //   203: getstatic 285	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   206: istore_3
    //   207: aload_0
    //   208: getfield 221	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   211: ifgt +105 -> 316
    //   214: aload_2
    //   215: ldc_w 287
    //   218: aload_1
    //   219: invokestatic 292	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   222: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   225: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   228: pop
    //   229: iload_3
    //   230: iconst_m1
    //   231: if_icmpne +12 -> 243
    //   234: ldc_w 298
    //   237: ldc_w 300
    //   240: invokestatic 306	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: invokestatic 309	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   246: ifnull +41 -> 287
    //   249: aload_0
    //   250: getfield 118	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   253: ldc 27
    //   255: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +70 -> 328
    //   261: aload_2
    //   262: ldc_w 311
    //   265: invokestatic 316	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   268: invokestatic 309	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   271: invokevirtual 320	com/tencent/smtt/utils/PostEncryption:RSAEncode	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: aload_2
    //   279: ldc_w 322
    //   282: iconst_1
    //   283: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   286: pop
    //   287: aload_2
    //   288: areturn
    //   289: aload_2
    //   290: ldc_w 271
    //   293: aload_0
    //   294: getfield 211	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   297: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   300: pop
    //   301: goto -150 -> 151
    //   304: astore_0
    //   305: ldc_w 298
    //   308: ldc_w 324
    //   311: invokestatic 306	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aconst_null
    //   315: areturn
    //   316: aload_2
    //   317: ldc_w 287
    //   320: iload_3
    //   321: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   324: pop
    //   325: goto -96 -> 229
    //   328: aload_0
    //   329: getfield 118	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   332: ldc_w 326
    //   335: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq -51 -> 287
    //   341: aload_2
    //   342: ldc_w 311
    //   345: invokestatic 309	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   348: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_2
    //   353: ldc_w 322
    //   356: iconst_0
    //   357: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   360: pop
    //   361: aload_2
    //   362: areturn
    //   363: astore_0
    //   364: aload_2
    //   365: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	366	1	paramContext	Context
    //   7	358	2	localJSONObject	org.json.JSONObject
    //   206	115	3	i	int
    // Exception table:
    //   from	to	target	type
    //   0	151	304	java/lang/Exception
    //   151	229	304	java/lang/Exception
    //   234	243	304	java/lang/Exception
    //   289	301	304	java/lang/Exception
    //   316	325	304	java/lang/Exception
    //   243	287	363	java/lang/Exception
    //   328	361	363	java/lang/Exception
  }
  
  private static String getSHA1(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      if (paramContext != null)
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null)
        {
          localObject = new StringBuilder("");
          if (paramContext != null)
          {
            if (paramContext.length <= 0) {
              return null;
            }
            while (i < paramContext.length)
            {
              String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
              if (i > 0) {
                ((StringBuilder)localObject).append(":");
              }
              if (str.length() < 2) {
                ((StringBuilder)localObject).append(0);
              }
              ((StringBuilder)localObject).append(str);
              i += 1;
            }
            paramContext = ((StringBuilder)localObject).toString();
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void post(final ThirdAppInfoNew paramThirdAppInfoNew, final Context paramContext)
  {
    new Thread("HttpUtils")
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: getstatic 43	android/os/Build$VERSION:SDK_INT	I
        //   3: bipush 8
        //   5: if_icmpge +4 -> 9
        //   8: return
        //   9: getstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   12: ifnonnull +13 -> 25
        //   15: ldc 49
        //   17: ldc 51
        //   19: invokevirtual 57	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   22: putstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   25: getstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   28: ifnonnull +26 -> 54
        //   31: ldc 59
        //   33: ldc 61
        //   35: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   38: return
        //   39: astore_1
        //   40: aconst_null
        //   41: putstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   44: ldc 59
        //   46: ldc 69
        //   48: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   51: goto -26 -> 25
        //   54: invokestatic 75	com/tencent/smtt/utils/TbsCommonConfig:getInstance	()Lcom/tencent/smtt/utils/TbsCommonConfig;
        //   57: invokevirtual 79	com/tencent/smtt/utils/TbsCommonConfig:getPvUploadPostUrl	()Ljava/lang/String;
        //   60: astore_1
        //   61: invokestatic 84	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
        //   64: invokevirtual 87	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
        //   67: astore_2
        //   68: new 89	java/net/URL
        //   71: dup
        //   72: new 91	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   79: aload_1
        //   80: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   83: aload_2
        //   84: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   90: invokespecial 101	java/net/URL:<init>	(Ljava/lang/String;)V
        //   93: invokevirtual 105	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   96: checkcast 107	java/net/HttpURLConnection
        //   99: astore_2
        //   100: aload_2
        //   101: ldc 109
        //   103: invokevirtual 112	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   106: aload_2
        //   107: iconst_1
        //   108: invokevirtual 116	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   111: aload_2
        //   112: iconst_1
        //   113: invokevirtual 119	java/net/HttpURLConnection:setDoInput	(Z)V
        //   116: aload_2
        //   117: iconst_0
        //   118: invokevirtual 122	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   121: aload_2
        //   122: sipush 20000
        //   125: invokevirtual 126	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   128: getstatic 43	android/os/Build$VERSION:SDK_INT	I
        //   131: bipush 13
        //   133: if_icmple +11 -> 144
        //   136: aload_2
        //   137: ldc -128
        //   139: ldc -126
        //   141: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aload_0
        //   145: getfield 17	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
        //   148: aload_0
        //   149: getfield 19	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
        //   152: invokestatic 137	com/tencent/smtt/sdk/stat/HttpUtils:access$000	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)Lorg/json/JSONObject;
        //   155: astore_1
        //   156: aload_1
        //   157: ifnonnull +99 -> 256
        //   160: ldc 59
        //   162: ldc -117
        //   164: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   167: return
        //   168: astore_1
        //   169: ldc 59
        //   171: new 91	java/lang/StringBuilder
        //   174: dup
        //   175: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   178: ldc -115
        //   180: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: aload_1
        //   184: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   187: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   190: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   193: return
        //   194: astore_1
        //   195: ldc 59
        //   197: new 91	java/lang/StringBuilder
        //   200: dup
        //   201: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   204: ldc -110
        //   206: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   209: aload_1
        //   210: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   213: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   216: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   219: return
        //   220: astore_1
        //   221: ldc 59
        //   223: new 91	java/lang/StringBuilder
        //   226: dup
        //   227: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   230: ldc -108
        //   232: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   235: aload_1
        //   236: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   239: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   242: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   245: return
        //   246: astore_1
        //   247: aload_1
        //   248: invokevirtual 151	java/lang/Exception:printStackTrace	()V
        //   251: aconst_null
        //   252: astore_1
        //   253: goto -97 -> 156
        //   256: aload_1
        //   257: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
        //   260: ldc 51
        //   262: invokevirtual 57	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   265: astore_1
        //   266: invokestatic 84	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
        //   269: aload_1
        //   270: invokevirtual 158	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
        //   273: astore_1
        //   274: aload_2
        //   275: ldc -96
        //   277: ldc -94
        //   279: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   282: aload_2
        //   283: ldc -92
        //   285: aload_1
        //   286: arraylength
        //   287: invokestatic 168	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   290: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   293: aload_2
        //   294: invokevirtual 172	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   297: astore_3
        //   298: aload_3
        //   299: aload_1
        //   300: invokevirtual 178	java/io/OutputStream:write	([B)V
        //   303: aload_3
        //   304: invokevirtual 181	java/io/OutputStream:flush	()V
        //   307: aload_2
        //   308: invokevirtual 185	java/net/HttpURLConnection:getResponseCode	()I
        //   311: sipush 200
        //   314: if_icmpeq -306 -> 8
        //   317: ldc 59
        //   319: ldc -69
        //   321: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   324: return
        //   325: astore_1
        //   326: ldc 59
        //   328: new 91	java/lang/StringBuilder
        //   331: dup
        //   332: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   335: ldc -67
        //   337: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   340: aload_1
        //   341: invokevirtual 192	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   344: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   347: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   350: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   353: return
        //   354: astore_1
        //   355: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	356	0	this	1
        //   39	1	1	localUnsupportedEncodingException	UnsupportedEncodingException
        //   60	97	1	localObject1	Object
        //   168	16	1	localIOException	java.io.IOException
        //   194	16	1	localAssertionError	AssertionError
        //   220	16	1	localNoClassDefFoundError	NoClassDefFoundError
        //   246	2	1	localException	Exception
        //   252	48	1	arrayOfByte	byte[]
        //   325	16	1	localThrowable1	Throwable
        //   354	1	1	localThrowable2	Throwable
        //   67	241	2	localObject2	Object
        //   297	7	3	localOutputStream	java.io.OutputStream
        // Exception table:
        //   from	to	target	type
        //   15	25	39	java/io/UnsupportedEncodingException
        //   54	106	168	java/io/IOException
        //   54	106	194	java/lang/AssertionError
        //   54	106	220	java/lang/NoClassDefFoundError
        //   144	156	246	java/lang/Exception
        //   293	324	325	java/lang/Throwable
        //   256	274	354	java/lang/Throwable
      }
    }.start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\stat\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */