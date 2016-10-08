import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class hgp
  implements Handler.Callback
{
  public static final long a = 67324752L;
  static Context jdField_a_of_type_AndroidContentContext;
  public static IOfflineDownloader a;
  public static IThreadManager a;
  static hgu jdField_a_of_type_Hgu;
  protected static ArrayList a;
  protected static HashMap a;
  public static final long b = 930790575L;
  public static final int d = 0;
  public static final String d = "updateNotification";
  public static final int e = 1;
  public static final String e = "wording";
  public static final int f = 2;
  public static final String f = "wifiUpdatingText";
  public static final int g = 3;
  public static final String g = "nonWifiUpdatingText";
  public static boolean g = false;
  public static final int h = 4;
  public static final String h = "updateCompletedText";
  public static final int i = 5;
  public static final String i = "expirelist";
  public static final int j = 6;
  public static final String j = "bid";
  public static final int k = 7;
  public static final String k = "expired";
  public static final int l = 8;
  public static final String l = "zip";
  public static final int m = 13;
  public static final String m = "7z";
  public static final int n = -1;
  private static String n = "BidDownloader";
  public static final int o = 9;
  public static final int p = 10;
  public static final int q = 0;
  public static final int r = 1;
  protected static final int s = 1;
  static final int t = 0;
  static final int u = 1;
  static final int v = 2;
  static final int w = 3;
  protected int a;
  Handler jdField_a_of_type_AndroidOsHandler;
  AsyncBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack;
  public String a;
  public boolean a;
  public int b;
  private AsyncBack jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack;
  String jdField_b_of_type_JavaLangString = null;
  protected boolean b;
  public int c;
  public String c;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  public boolean f;
  private int x;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager = new QQThreadManager();
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = new OfflineDownloader();
  }
  
  public hgp(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_Hgu = new hgu();
    }
    this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack = paramAsyncBack;
    jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication().getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Boolean = true;
      paramString = HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramString))
      {
        if (!this.e) {
          break label215;
        }
        this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_JavaLangString + ".7z");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_Int = 0;
      return;
      if (paramInt == 3)
      {
        this.d = true;
        break;
      }
      if (paramInt == 4)
      {
        this.e = true;
        break;
      }
      if (paramInt != 2) {
        break;
      }
      this.jdField_c_of_type_Boolean = true;
      break;
      label215:
      if ((this.d) || (this.jdField_c_of_type_Boolean))
      {
        this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_JavaLangString + ".zip");
      }
      else
      {
        QLog.e(n, 1, "do not know what format, use default zip name!");
        this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_JavaLangString + ".zip");
      }
    }
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_JavaUtilHashMap.size() == 0) && (jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      hgp localhgp = (hgp)jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (jdField_a_of_type_AndroidContentContext != null) {
        localhgp.b();
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
      this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, paramInt1);
    }
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.i(n, 2, "addDownloadingState:" + paramString);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    while (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  protected static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
            jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          }
        } while ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.isEmpty()));
        paramString = (hgp)jdField_a_of_type_JavaUtilArrayList.get(0);
      } while (jdField_a_of_type_AndroidContentContext == null);
      if ((paramString.f) && (NetworkUtil.a(jdField_a_of_type_AndroidContentContext) != 1) && (!g))
      {
        paramString = new IntentFilter();
        paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        jdField_a_of_type_AndroidContentContext.registerReceiver(jdField_a_of_type_Hgu, paramString);
        g = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(n, 2, "start download from queue:" + paramString.jdField_a_of_type_JavaLangString);
      }
      paramString.b();
      jdField_a_of_type_JavaUtilArrayList.remove(0);
    } while ((!g) || (jdField_a_of_type_JavaUtilArrayList.size() != 0));
    jdField_a_of_type_AndroidContentContext.unregisterReceiver(jdField_a_of_type_Hgu);
    g = false;
  }
  
  private void c()
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new hgs(this));
  }
  
  private void d()
  {
    if (a(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.i(n, 2, this.jdField_a_of_type_JavaLangString + " is downloading");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(n, 2, this.jdField_a_of_type_JavaLangString + "download");
      }
      if (jdField_a_of_type_JavaUtilHashMap.size() < 1) {
        break;
      }
      a(this);
    } while (!QLog.isColorLevel());
    QLog.i(n, 2, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)) + "," + this.jdField_a_of_type_JavaLangString + "add to queue");
    return;
    HtmlOffline.a(jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    c();
    if (QLog.isColorLevel()) {
      QLog.i(n, 2, this.jdField_a_of_type_JavaLangString + this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: ldc_w 320
    //   10: astore_2
    //   11: aload_2
    //   12: areturn
    //   13: new 322	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 327	java/io/File:exists	()Z
    //   26: ifne +40 -> 66
    //   29: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +30 -> 62
    //   35: getstatic 102	hgp:n	Ljava/lang/String;
    //   38: iconst_2
    //   39: new 161	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 329
    //   49: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 244	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: ldc_w 320
    //   65: areturn
    //   66: ldc_w 320
    //   69: astore 4
    //   71: new 331	java/io/RandomAccessFile
    //   74: dup
    //   75: aload_2
    //   76: ldc_w 332
    //   79: invokespecial 335	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   82: astore_3
    //   83: aload_3
    //   84: astore_2
    //   85: aload_3
    //   86: lconst_0
    //   87: invokevirtual 339	java/io/RandomAccessFile:seek	(J)V
    //   90: aload_3
    //   91: astore_2
    //   92: aload_3
    //   93: invokevirtual 342	java/io/RandomAccessFile:readInt	()I
    //   96: invokestatic 346	java/lang/Integer:reverseBytes	(I)I
    //   99: istore 6
    //   101: iload 6
    //   103: i2l
    //   104: ldc2_w 9
    //   107: lcmp
    //   108: ifne +21 -> 129
    //   111: ldc 58
    //   113: astore_1
    //   114: aload_1
    //   115: astore_2
    //   116: aload_3
    //   117: ifnull -106 -> 11
    //   120: aload_3
    //   121: invokevirtual 349	java/io/RandomAccessFile:close	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_2
    //   127: aload_1
    //   128: areturn
    //   129: aload 4
    //   131: astore_1
    //   132: iload 6
    //   134: i2l
    //   135: ldc2_w 18
    //   138: lcmp
    //   139: ifne -25 -> 114
    //   142: ldc 62
    //   144: astore_1
    //   145: goto -31 -> 114
    //   148: astore 5
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_3
    //   153: astore_2
    //   154: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +34 -> 191
    //   160: aload_3
    //   161: astore_2
    //   162: getstatic 102	hgp:n	Ljava/lang/String;
    //   165: iconst_2
    //   166: new 161	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 351
    //   176: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload 5
    //   188: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload 4
    //   193: astore_2
    //   194: aload_3
    //   195: ifnull -184 -> 11
    //   198: aload_3
    //   199: invokevirtual 349	java/io/RandomAccessFile:close	()V
    //   202: ldc_w 320
    //   205: areturn
    //   206: astore_1
    //   207: ldc_w 320
    //   210: areturn
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 349	java/io/RandomAccessFile:close	()V
    //   222: aload_1
    //   223: athrow
    //   224: astore_2
    //   225: goto -3 -> 222
    //   228: astore_1
    //   229: goto -15 -> 214
    //   232: astore 5
    //   234: goto -82 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	hgp
    //   0	237	1	paramString	String
    //   10	106	2	localObject1	Object
    //   126	1	2	localException1	Exception
    //   153	66	2	localObject2	Object
    //   224	1	2	localException2	Exception
    //   82	117	3	localRandomAccessFile	java.io.RandomAccessFile
    //   69	123	4	str	String
    //   148	39	5	localException3	Exception
    //   232	1	5	localException4	Exception
    //   99	34	6	i1	int
    // Exception table:
    //   from	to	target	type
    //   120	124	126	java/lang/Exception
    //   71	83	148	java/lang/Exception
    //   198	202	206	java/lang/Exception
    //   71	83	211	finally
    //   218	222	224	java/lang/Exception
    //   85	90	228	finally
    //   92	101	228	finally
    //   154	160	228	finally
    //   162	191	228	finally
    //   85	90	232	java/lang/Exception
    //   92	101	232	java/lang/Exception
  }
  
  protected void a(hgp paramhgp)
  {
    int i2 = jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      hgp localhgp = (hgp)jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (paramhgp.jdField_a_of_type_JavaLangString.equals(localhgp.jdField_a_of_type_JavaLangString)) {
        return;
      }
      i1 += 1;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramhgp);
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new hgq(this, l1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  void b()
  {
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(n, 2, this.jdField_a_of_type_JavaLangString + " is downloading");
      }
      return;
    }
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new hgt(this));
  }
  
  public boolean b()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    String str4;
    boolean bool2;
    Object localObject1;
    try
    {
      String str1 = this.jdField_a_of_type_JavaLangString;
      str4 = this.jdField_b_of_type_JavaLangString;
      bool2 = TextUtils.isEmpty(str1);
      if (bool2) {
        bool2 = bool1;
      }
      for (;;)
      {
        return bool2;
        bool2 = bool1;
        if (!TextUtils.isEmpty(HtmlOffline.b(str1)))
        {
          localObject1 = new File(str4);
          if (((File)localObject1).exists()) {
            break;
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i(n, 2, "doUnzipZip: no zip ! : businessId:" + str1);
            bool2 = bool1;
          }
        }
      }
      l1 = System.currentTimeMillis();
    }
    finally {}
    long l1;
    String str3 = ((File)localObject1).getParent() + File.separator + str2;
    Object localObject2 = a(str4);
    if (QLog.isColorLevel()) {
      QLog.i(n, 2, "fileFormat: " + (String)localObject2 + ", path: " + str4);
    }
    int i1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (((String)localObject2).equals("zip"))
      {
        i1 = ZipUtils.a(str4, str3);
        label231:
        if (QLog.isColorLevel()) {
          QLog.i(n, 2, "now delete original download offline zip, path: " + str4);
        }
        Util.b(str4);
        if (i1 <= 0) {
          break label479;
        }
        HtmlOffline.a(str2, 13, 0L, i1, "lixian_update", "0");
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.i(n, 2, "unZipFolder fail!");
          bool1 = bool3;
        }
      }
    }
    label479:
    label702:
    for (;;)
    {
      Util.a(str3);
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(n, 2, "time of unzip zip：" + (System.currentTimeMillis() - l1) + ", isSuccess: " + bool1);
      bool2 = bool1;
      break;
      if (((String)localObject2).equals("7z"))
      {
        i1 = LzmaUtils.a(BaseApplicationImpl.a().getApplicationContext(), str4, str3);
        break label231;
        QLog.w(n, 1, "can not recognize download compress file format, " + this.jdField_b_of_type_JavaLangString);
        if (this.d)
        {
          i1 = ZipUtils.a(str4, str3);
          break label231;
        }
        if (this.e)
        {
          i1 = LzmaUtils.a(BaseApplicationImpl.a().getApplicationContext(), str4, str3);
          break label231;
          str4 = str3 + File.separator + str2 + ".zip";
          localObject2 = new File(str4);
          localObject1 = ((File)localObject1).getParent() + File.separator + str2 + ".zip";
          if (QLog.isColorLevel()) {
            QLog.i(n, 2, "now move zip file to location: " + (String)localObject1);
          }
          if (((File)localObject2).exists())
          {
            bool2 = ((File)localObject2).renameTo(new File((String)localObject1));
            bool1 = bool2;
            if (!bool2) {
              bool1 = FileUtils.b(str4, (String)localObject1);
            }
            if (!bool1)
            {
              HtmlOffline.a(str2, 13, 0L, i1, "lixian_update", "0");
              bool1 = false;
              break label702;
            }
            HtmlOffline.a(str2, 13, 0L, i1, "lixian_time", "0");
            bool1 = true;
            break label702;
          }
          HtmlOffline.a(str2, 13, 0L, i1, "lixian_update", "0");
          bool1 = bool3;
          continue;
        }
      }
      i1 = 1;
      break label231;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(this.jdField_a_of_type_JavaLangString);
      continue;
      b();
      continue;
      a(paramMessage.arg1, paramMessage.arg2);
      continue;
      d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */