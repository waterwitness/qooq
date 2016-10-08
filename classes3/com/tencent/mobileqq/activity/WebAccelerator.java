package com.tencent.mobileqq.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import nbj;

public class WebAccelerator
{
  public static final int a = 1;
  private static WebAccelerator jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator;
  public static final String a = "WebAccelerator";
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  public static boolean a = false;
  public static final int b = 2;
  public static final String b = "hit_shortLink";
  public static boolean b = false;
  public static final int c = 4;
  public static final String c = "hit_safeCheck";
  public static final int d = 8;
  private static final String d = "http://url.cn/";
  public static final int e = 16;
  private static final String e = "http%3A%2F%2Furl.cn%2F";
  public static final int f = 32;
  private static final String f = "bankSize";
  public static final int g = 64;
  private static final String g = "bank_download_key";
  public static final int h = 128;
  private static final String h = "updateTime";
  public static final int i = 256;
  private static final String i = "load_shortLink";
  public static final int j = 512;
  private static final String j = "load_safeCheck";
  public static final int k = 1024;
  private static final String k = "load_time";
  public static int l = -1;
  private static final String l = "hit_time";
  private static final String jdField_m_of_type_JavaLangString = "AIOWebShortLink";
  private static final String jdField_n_of_type_JavaLangString = "AIOWebSafeCheck";
  private long jdField_a_of_type_Long = 86400000L;
  private DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  private Map jdField_a_of_type_JavaUtilMap;
  private Set jdField_a_of_type_JavaUtilSet;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private boolean c = true;
  private int jdField_m_of_type_Int;
  private int jdField_n_of_type_Int;
  private int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(Patterns.c.pattern());
    jdField_a_of_type_Boolean = true;
  }
  
  public WebAccelerator()
  {
    this.m = 15;
    this.n = 10;
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    SosoSrvAddrProvider.a().c();
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerator", 2, "DPC:" + str);
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length <= 5) {}
    }
    for (;;)
    {
      try
      {
        this.o = Integer.parseInt(arrayOfString[4]);
        this.jdField_a_of_type_Long = (Integer.parseInt(arrayOfString[5]) * 1000 * 60 * 60);
        if (arrayOfString.length > 6) {
          this.n = Integer.parseInt(arrayOfString[6]);
        }
        i1 = i2;
        if (this.n > 30)
        {
          this.n = 10;
          i1 = i2;
        }
        if ((i1 == 0) && (QLog.isColorLevel())) {
          QLog.d("WebAccelerator", 2, "DPC not catch success[" + str + "]");
        }
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        try
        {
          this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).a().getCacheDir(), 1, 1, 1048576L);
          return;
        }
        catch (Exception localException1)
        {
          this.c = false;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        return;
      }
      catch (Exception localException2)
      {
        this.c = false;
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        }
      }
      int i1 = 0;
    }
  }
  
  public static WebAccelerator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator = new WebAccelerator();
      }
      WebAccelerator localWebAccelerator = jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator;
      return localWebAccelerator;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      ThreadManager.a(new nbj(paramString, paramIntent, paramContext), 8, null, false);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  private final boolean a(int paramInt)
  {
    return (this.o & paramInt) == paramInt;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramChatMessage.isSend())
    {
      if (!(paramChatMessage instanceof MessageForStructing)) {
        break label53;
      }
      AbsStructMsg localAbsStructMsg2 = ((MessageForStructing)paramChatMessage).structingMsg;
      AbsStructMsg localAbsStructMsg1 = localAbsStructMsg2;
      if (localAbsStructMsg2 == null) {
        localAbsStructMsg1 = StructMsgFactory.a(paramChatMessage.msgData);
      }
      if (!a(localAbsStructMsg1)) {
        break label109;
      }
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      label53:
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = (MessageForText)paramChatMessage;
        bool1 = bool2;
        if (paramChatMessage.msg != null)
        {
          bool1 = bool2;
          if (!paramChatMessage.msg.equals(""))
          {
            bool1 = bool2;
            if (c(paramChatMessage.msg) != null)
            {
              return true;
              label109:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public static final boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && ("web".equals(paramAbsStructMsg.mMsgAction)) && ((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!CGILoader.a((AbsShareMsg)paramAbsStructMsg));
  }
  
  private final boolean b()
  {
    boolean bool = false;
    try
    {
      Object localObject1 = a();
      int i2 = ((SharedPreferences)localObject1).getInt("bankSize", 0);
      int i1 = i2;
      if (i2 < this.m)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        i1 = i2 + 1;
        ((SharedPreferences.Editor)localObject1).putInt("bankSize", i1);
        ((SharedPreferences.Editor)localObject1).commit();
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "shouldUseAccelerator:" + bool + "   " + i1);
      }
      return bool;
    }
    finally {}
  }
  
  private static boolean b(Context paramContext, String paramString, Intent paramIntent)
  {
    boolean bool2 = false;
    String str1 = QzoneConfig.a().a("QZVideo", "qzonelivevideo_livehost", "http://h5.qzone.qq.com/live/video/qzone/");
    int i1 = QzoneConfig.a().a("QZVideo", "module_jump_native", 1);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool1 = bool2;
    if (paramString.startsWith(str1))
    {
      try
      {
        Uri localUri = Uri.parse(paramString);
        String str2 = localUri.getQueryParameter("stayin");
        if ((i1 != 1) || ((str2 != null) && (TextUtils.equals(str2, "1"))))
        {
          QLog.d("WebAccelerator", 1, "is_native not available, jump to H5, " + paramString);
          paramString = new Intent(paramContext, QQBrowserActivity.class);
          paramString.putExtra("url", localUri.toString());
          paramString.setData(localUri);
          paramContext.startActivity(paramString);
          return true;
        }
        paramIntent = paramIntent.getStringExtra("self_uin");
        str1 = paramString.substring(str1.length(), paramString.length()).split("/")[0];
        bool1 = bool2;
        if (paramIntent == null) {
          break label398;
        }
        bool1 = bool2;
        if (str1 == null) {
          break label398;
        }
        bool1 = bool2;
        if (TextUtils.isEmpty(paramIntent)) {
          break label398;
        }
        bool1 = bool2;
        if (TextUtils.isEmpty(str1)) {
          break label398;
        }
        if (!d(str1))
        {
          QLog.d("WebAccelerator", 2, "room_id not number!");
          return false;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("WebAccelerator", 2, "getQzoneVideoIntent parse url error!");
        return false;
      }
      localStringBuilder.append("mqqzone://arouse/livevideo").append("?room=" + str1).append("&uin=" + paramIntent).append("&video_play_source=12").append("&backup=" + URLEncoder.encode(paramString));
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      paramContext.startActivity(localIntent);
      bool1 = true;
    }
    label398:
    return bool1;
  }
  
  public static String c(String paramString)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    String str = null;
    if (localMatcher.find()) {
      str = paramString.substring(localMatcher.start(), localMatcher.end());
    }
    return str;
  }
  
  public static final boolean c(String paramString)
  {
    return (paramString.startsWith("http://url.cn/")) || (paramString.startsWith("http%3A%2F%2Furl.cn%2F"));
  }
  
  private final String d(String paramString)
  {
    String str3 = "";
    String str1 = str3;
    String str2 = str3;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      str1 = str3;
      str2 = str3;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      str1 = str3;
      str2 = str3;
      localHttpURLConnection.connect();
      str1 = str3;
      str2 = str3;
      paramString = localHttpURLConnection.getHeaderField("Location");
      str1 = paramString;
      str2 = paramString;
      QLog.d("WebAccelerator", 2, "code:" + localHttpURLConnection.getResponseCode());
    }
    catch (MalformedURLException localMalformedURLException)
    {
      do
      {
        paramString = str1;
      } while (!QLog.isColorLevel());
      QLog.e("WebAccelerator", 2, "doRedirect", localMalformedURLException);
      return str1;
    }
    catch (IOException localIOException)
    {
      do
      {
        paramString = localMalformedURLException;
      } while (!QLog.isColorLevel());
      QLog.e("WebAccelerator", 2, "doRedirect", localIOException);
    }
    return paramString;
    return localMalformedURLException;
  }
  
  public static boolean d(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public final SharedPreferences a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 514	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: ldc 11
    //   7: iconst_0
    //   8: invokevirtual 518	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 42
    //   15: lconst_0
    //   16: invokeinterface 522 4 0
    //   21: lstore 6
    //   23: lload 6
    //   25: lconst_0
    //   26: lcmp
    //   27: ifne +33 -> 60
    //   30: aload_1
    //   31: invokeinterface 324 1 0
    //   36: astore_2
    //   37: aload_2
    //   38: ldc 42
    //   40: invokestatic 528	java/lang/System:currentTimeMillis	()J
    //   43: invokeinterface 532 4 0
    //   48: pop
    //   49: aload_2
    //   50: invokeinterface 333 1 0
    //   55: pop
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: invokestatic 528	java/lang/System:currentTimeMillis	()J
    //   63: lload 6
    //   65: lsub
    //   66: ldc2_w 109
    //   69: lcmp
    //   70: ifle -14 -> 56
    //   73: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +12 -> 88
    //   79: ldc 11
    //   81: iconst_2
    //   82: ldc_w 534
    //   85: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_1
    //   89: invokeinterface 324 1 0
    //   94: astore_2
    //   95: aload_2
    //   96: ldc 42
    //   98: invokestatic 528	java/lang/System:currentTimeMillis	()J
    //   101: invokeinterface 532 4 0
    //   106: pop
    //   107: aload_2
    //   108: ldc 34
    //   110: iconst_0
    //   111: invokeinterface 330 3 0
    //   116: pop
    //   117: aload_2
    //   118: ldc 38
    //   120: iconst_0
    //   121: invokeinterface 330 3 0
    //   126: pop
    //   127: aload_0
    //   128: getfield 200	com/tencent/mobileqq/activity/WebAccelerator:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   131: invokeinterface 539 1 0
    //   136: aload_1
    //   137: ldc 46
    //   139: iconst_0
    //   140: invokeinterface 320 3 0
    //   145: istore 4
    //   147: aload_2
    //   148: ldc 46
    //   150: iconst_0
    //   151: invokeinterface 330 3 0
    //   156: pop
    //   157: aload_1
    //   158: ldc 18
    //   160: iconst_0
    //   161: invokeinterface 320 3 0
    //   166: istore 5
    //   168: aload_2
    //   169: ldc 18
    //   171: iconst_0
    //   172: invokeinterface 330 3 0
    //   177: pop
    //   178: iload 4
    //   180: ifgt +8 -> 188
    //   183: iload 5
    //   185: ifle +88 -> 273
    //   188: new 197	java/util/HashMap
    //   191: dup
    //   192: iconst_4
    //   193: invokespecial 542	java/util/HashMap:<init>	(I)V
    //   196: astore_3
    //   197: aload_3
    //   198: ldc 54
    //   200: new 146	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   207: iload 4
    //   209: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 289
    //   215: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 546	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload_3
    //   226: ldc 57
    //   228: new 146	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   235: iload 5
    //   237: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc_w 289
    //   243: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 546	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: invokestatic 552	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   256: invokestatic 557	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   259: aconst_null
    //   260: ldc 60
    //   262: iconst_0
    //   263: lconst_0
    //   264: lconst_0
    //   265: aload_3
    //   266: ldc_w 289
    //   269: iconst_0
    //   270: invokevirtual 560	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   273: aload_1
    //   274: ldc 50
    //   276: iconst_0
    //   277: invokeinterface 320 3 0
    //   282: istore 4
    //   284: aload_2
    //   285: ldc 50
    //   287: iconst_0
    //   288: invokeinterface 330 3 0
    //   293: pop
    //   294: aload_1
    //   295: ldc 22
    //   297: iconst_0
    //   298: invokeinterface 320 3 0
    //   303: istore 5
    //   305: aload_2
    //   306: ldc 22
    //   308: iconst_0
    //   309: invokeinterface 330 3 0
    //   314: pop
    //   315: iload 4
    //   317: ifgt +8 -> 325
    //   320: iload 5
    //   322: ifle +88 -> 410
    //   325: new 197	java/util/HashMap
    //   328: dup
    //   329: iconst_4
    //   330: invokespecial 542	java/util/HashMap:<init>	(I)V
    //   333: astore_3
    //   334: aload_3
    //   335: ldc 54
    //   337: new 146	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   344: iload 4
    //   346: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc_w 289
    //   352: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 546	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   361: pop
    //   362: aload_3
    //   363: ldc 57
    //   365: new 146	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   372: iload 5
    //   374: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: ldc_w 289
    //   380: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokevirtual 546	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: pop
    //   390: invokestatic 552	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   393: invokestatic 557	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   396: aconst_null
    //   397: ldc 63
    //   399: iconst_0
    //   400: lconst_0
    //   401: lconst_0
    //   402: aload_3
    //   403: ldc_w 289
    //   406: iconst_0
    //   407: invokevirtual 560	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   410: aload_2
    //   411: invokeinterface 333 1 0
    //   416: pop
    //   417: goto -361 -> 56
    //   420: astore_1
    //   421: aload_0
    //   422: monitorexit
    //   423: aload_1
    //   424: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	WebAccelerator
    //   11	284	1	localSharedPreferences	SharedPreferences
    //   420	4	1	localObject	Object
    //   36	375	2	localEditor	SharedPreferences.Editor
    //   196	207	3	localHashMap	HashMap
    //   145	200	4	i1	int
    //   166	207	5	i2	int
    //   21	43	6	l1	long
    // Exception table:
    //   from	to	target	type
    //   2	23	420	finally
    //   30	56	420	finally
    //   60	88	420	finally
    //   88	178	420	finally
    //   188	273	420	finally
    //   273	315	420	finally
    //   325	410	420	finally
    //   410	417	420	finally
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: ifnull +13 -> 25
    //   15: aload_1
    //   16: ldc_w 289
    //   19: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +7 -> 29
    //   25: aload_1
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: aload 4
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 114	com/tencent/mobileqq/activity/WebAccelerator:c	Z
    //   36: ifeq -9 -> 27
    //   39: aload 4
    //   41: astore_2
    //   42: getstatic 94	com/tencent/mobileqq/activity/WebAccelerator:jdField_a_of_type_Boolean	Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: invokestatic 565	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 231	com/tencent/mobileqq/activity/WebAccelerator:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   57: aload_2
    //   58: invokevirtual 569	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +17 -> 82
    //   68: aload 4
    //   70: astore_2
    //   71: aload 6
    //   73: astore 5
    //   75: aload 4
    //   77: iconst_0
    //   78: invokevirtual 575	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   81: astore_3
    //   82: aload 4
    //   84: astore_2
    //   85: aload_3
    //   86: astore 5
    //   88: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +41 -> 132
    //   94: aload 4
    //   96: astore_2
    //   97: aload_3
    //   98: astore 5
    //   100: ldc 11
    //   102: iconst_2
    //   103: invokestatic 186	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   106: ldc_w 577
    //   109: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 340
    //   119: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_3
    //   133: astore_2
    //   134: aload 4
    //   136: ifnull -109 -> 27
    //   139: aload 4
    //   141: invokevirtual 580	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   144: aload_3
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 5
    //   152: astore_1
    //   153: aload 4
    //   155: astore_2
    //   156: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +16 -> 175
    //   162: aload 4
    //   164: astore_2
    //   165: ldc 11
    //   167: iconst_2
    //   168: ldc_w 582
    //   171: aload_3
    //   172: invokestatic 504	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload_1
    //   176: astore_2
    //   177: aload 4
    //   179: ifnull -152 -> 27
    //   182: aload 4
    //   184: invokevirtual 580	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   187: aload_1
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 580	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: goto -11 -> 192
    //   206: astore_3
    //   207: aload 5
    //   209: astore_1
    //   210: goto -57 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	WebAccelerator
    //   0	213	1	paramString	String
    //   26	171	2	localObject1	Object
    //   1	144	3	str	String
    //   146	26	3	localIOException1	IOException
    //   206	1	3	localIOException2	IOException
    //   9	174	4	localSnapshot	DiskLruCache.Snapshot
    //   3	205	5	localObject2	Object
    //   6	66	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	63	146	java/io/IOException
    //   53	63	189	finally
    //   75	82	202	finally
    //   88	94	202	finally
    //   100	132	202	finally
    //   156	162	202	finally
    //   165	175	202	finally
    //   75	82	206	java/io/IOException
    //   88	94	206	java/io/IOException
    //   100	132	206	java/io/IOException
  }
  
  public final void a(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("WebAccelerator", 0);
      int i1 = localSharedPreferences.getInt(paramString, 0);
      if (i1 > 0) {
        localSharedPreferences.edit().putInt(paramString, i1 - 1).commit();
      }
      return;
    }
    finally {}
  }
  
  public final void a(String arg1, int paramInt, String paramString2, String paramString3)
  {
    int i1 = 2;
    if ((TextUtils.isEmpty(???)) || (!jdField_a_of_type_Boolean)) {}
    String str;
    do
    {
      return;
      str = ???.trim();
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilSet.add(str);
      switch (HttpUtil.a())
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "unknown network type , not use accelerator");
    return;
    i1 = 4;
    if ((a(i1)) && (b())) {
      if (!a(16)) {
        break label225;
      }
    }
    label225:
    for (??? = b(str);; ??? = str)
    {
      if (a(32)) {
        a(???, paramInt, paramString2, paramString3);
      }
      if (a(64)) {
        b(???);
      }
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilSet.remove(str);
        return;
      }
      i1 = 8;
      break;
      i1 = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i2 = 256;
    int i3 = HttpUtil.a();
    int i1 = i2;
    switch (i3)
    {
    default: 
      i1 = i2;
    }
    while (a(i1)) {
      if (i3 == 1)
      {
        return true;
        i1 = 512;
        continue;
        i1 = 1024;
        continue;
        i1 = 128;
      }
      else
      {
        Object localObject = a();
        i1 = ((SharedPreferences)localObject).getInt("bank_download_key", 0);
        if (i1 < this.n)
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt("bank_download_key", i1 + 1);
          ((SharedPreferences.Editor)localObject).commit();
          return true;
        }
        return false;
      }
    }
    return false;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label34;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      label34:
      bool2 = bool1;
      if (!this.c) {
        continue;
      }
      bool2 = bool1;
      if (!jdField_a_of_type_Boolean) {
        continue;
      }
      Object localObject3 = null;
      Object localObject1 = null;
      String str = Md5Utils.getMD5(paramString);
      boolean bool3 = bool5;
      try
      {
        DiskLruCache.Snapshot localSnapshot = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.get(str);
        bool1 = bool4;
        if (localSnapshot != null)
        {
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
        }
        try
        {
          l1 = Long.parseLong(localSnapshot.getString(0));
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
          if (SystemClock.uptimeMillis() - l1 < this.jdField_a_of_type_Long)
          {
            bool1 = true;
            bool3 = bool1;
            localObject1 = localSnapshot;
            localObject3 = localSnapshot;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              localObject1 = localSnapshot;
              localObject3 = localSnapshot;
              QLog.d("WebAccelerator", 2, "isSafeCheck:" + paramString + "   " + bool1);
            }
            bool2 = bool1;
            if (localSnapshot == null) {
              continue;
            }
            localSnapshot.close();
            return bool1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            long l1 = 0L;
            continue;
            bool3 = bool5;
            localObject2 = localSnapshot;
            localObject3 = localSnapshot;
            this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.remove(str);
            bool1 = bool4;
          }
        }
      }
      catch (IOException paramString)
      {
        Object localObject2;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject2;
          QLog.e("WebAccelerator", 2, "isSafeCheck fail", paramString);
        }
        bool2 = bool3;
        return bool3;
      }
      finally
      {
        if (localObject3 != null) {
          ((DiskLruCache.Snapshot)localObject3).close();
        }
      }
    }
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramString1 != null)
    {
      if (!paramString1.equals("")) {
        break label31;
      }
      bool2 = bool3;
    }
    label31:
    do
    {
      return bool2;
      if ((this.c) && (jdField_a_of_type_Boolean) && (!paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) && (!a(paramString1))) {
        break;
      }
      bool2 = bool3;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "no need doSafeCheck");
    return false;
    for (;;)
    {
      Object localObject2;
      try
      {
        i1 = (int)SystemClock.uptimeMillis() % 2;
        localObject1 = SosoPlugin.a;
        if (i1 > -1)
        {
          localObject2 = localObject1[i1];
          String str = SosoSrvAddrProvider.a().a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV);
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = localObject2;
            if (str.length() > 0) {
              localObject1 = ((String)localObject2).replaceFirst("http://[^/\\s]*/", str);
            }
          }
          localObject2 = AIOUtils.a();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&u=");
          ((StringBuilder)localObject2).append(URLEncoder.encode(paramString1, "UTF-8"));
          ((StringBuilder)localObject2).append("&wap=3");
          switch (paramInt)
          {
          case 0: 
            ((StringBuilder)localObject2).append("&qq-pf-to=mqq.temporaryc2c");
            if (!TextUtils.isEmpty(paramString2)) {
              ((StringBuilder)localObject2).append("&uin=").append(paramString2);
            }
            if (!TextUtils.isEmpty(paramString3)) {
              ((StringBuilder)localObject2).append("&originuin=").append(paramString3);
            }
            localObject1 = ((StringBuilder)localObject2).toString();
            paramString2 = d((String)localObject1);
            paramString3 = a();
            paramInt = paramString3.getInt("load_safeCheck", 0);
            paramString3.edit().putInt("load_safeCheck", paramInt + 1).commit();
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString1))) {
              break label694;
            }
            paramString2 = null;
            paramString3 = null;
            localObject2 = Md5Utils.getMD5(paramString1);
            paramString1 = paramString3;
          }
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        int i1;
        Object localObject1;
        bool2 = bool3;
      }
      try
      {
        paramString3 = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit((String)localObject2);
        if (paramString3 == null) {
          break label554;
        }
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.set(0, SystemClock.uptimeMillis() + "");
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.commit();
        bool1 = true;
      }
      catch (IOException paramString2)
      {
        if (!QLog.isColorLevel()) {
          break label609;
        }
        QLog.d("WebAccelerator", 2, "doSafeCheck", paramString2);
        bool1 = bool4;
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.abort();
          bool1 = bool4;
        }
        catch (IOException paramString1)
        {
          bool1 = bool4;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        bool1 = bool4;
        continue;
      }
      catch (Exception paramString1)
      {
        bool2 = bool3;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebAccelerator", 2, "doSafeCheck:" + (String)localObject1 + "   " + bool1);
      return bool1;
      i1 = 0;
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.c2c");
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("WebAccelerator", 2, "buildUrl fail", paramString1);
      return false;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.group");
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.discussion");
      continue;
      label554:
      boolean bool1 = bool4;
      paramString1 = paramString3;
      paramString2 = paramString3;
      if (QLog.isColorLevel())
      {
        paramString1 = paramString3;
        paramString2 = paramString3;
        QLog.e("WebAccelerator", 2, "fail to open cache.editor");
        bool1 = bool4;
        continue;
        label609:
        if (paramString2 == null) {
          break;
        }
        try
        {
          paramString2.abort();
          return false;
        }
        catch (IOException paramString1)
        {
          bool2 = bool3;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        return false;
        label694:
        bool1 = bool4;
        if (QLog.isColorLevel())
        {
          QLog.d("WebAccelerator", 2, "doRedirect get fail url");
          bool1 = bool4;
        }
      }
    }
  }
  
  public final String b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Object localObject2;
    do
    {
      DiskLruCache.Editor localEditor1;
      for (;;)
      {
        return paramString;
        if ((this.c) && (jdField_a_of_type_Boolean) && (c(paramString)))
        {
          Object localObject1 = a(paramString);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label362;
          }
          String str1 = d(paramString);
          if ((str1 != null) && (!str1.equals("")))
          {
            localObject1 = a();
            int i1 = ((SharedPreferences)localObject1).getInt("load_shortLink", 0);
            ((SharedPreferences)localObject1).edit().putInt("load_shortLink", i1 + 1).commit();
            DiskLruCache.Editor localEditor2 = null;
            localObject2 = null;
            localObject1 = localObject2;
            localEditor1 = localEditor2;
            try
            {
              String str2 = Md5Utils.getMD5(paramString);
              localObject1 = localObject2;
              localEditor1 = localEditor2;
              localEditor2 = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit(str2);
              if (localEditor2 != null)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.set(0, str1);
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.commit();
              }
              for (;;)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                QLog.d("WebAccelerator", 2, "doShortLink:" + paramString + "   " + str1);
                localObject2 = str1;
                break;
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                if (QLog.isColorLevel())
                {
                  localObject1 = localEditor2;
                  localEditor1 = localEditor2;
                  QLog.d("WebAccelerator", 2, "fail to open cache.Editor");
                }
              }
              if (localEditor1 == null) {}
            }
            catch (IOException paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.e("WebAccelerator", 2, "doShortLink", paramString);
              }
              localObject2 = str1;
              if (localObject1 == null) {
                break label362;
              }
              try
              {
                ((DiskLruCache.Editor)localObject1).abort();
                localObject2 = str1;
              }
              catch (IOException paramString)
              {
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break label362;
                }
              }
              QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", paramString);
              localObject2 = str1;
            }
            catch (Exception localException) {}
          }
        }
      }
      try
      {
        localEditor1.abort();
        return paramString;
      }
      catch (IOException localIOException) {}
    } while (!QLog.isColorLevel());
    QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", localIOException);
    return paramString;
    label362:
    return (String)localObject2;
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    while ((!b) || (!a())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    Intent localIntent = new Intent(localBaseApplicationImpl.getBaseContext(), PreloadWebService.class);
    localIntent.putExtra("url", paramString);
    localBaseApplicationImpl.getBaseContext().startService(localIntent);
    paramString = new HashMap();
    paramString.put("count", "1");
    StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "AIOWebPreDownload", false, 0L, 0L, paramString, "", false);
  }
  
  public final boolean b(String paramString)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label28;
      }
      bool2 = bool1;
    }
    label28:
    do
    {
      do
      {
        return bool2;
        bool2 = bool1;
      } while (!jdField_a_of_type_Boolean);
      String str = CGILoader.a(paramString);
      try
      {
        InetAddress.getByName(str);
        bool1 = true;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localUnknownHostException);
            bool1 = bool3;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localSecurityException);
            bool1 = bool3;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "doDNS:" + paramString + "   " + bool1);
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\WebAccelerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */