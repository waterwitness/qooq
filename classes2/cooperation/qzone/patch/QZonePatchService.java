package cooperation.qzone.patch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ynm;

public class QZonePatchService
{
  private static int jdField_a_of_type_Int = 0;
  private static QZonePatchService jdField_a_of_type_CooperationQzonePatchQZonePatchService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "qz_patch";
  private static volatile boolean jdField_a_of_type_Boolean = false;
  public static final String b = "patchs";
  public static final String c = ".jar";
  public static final String d = "p_len";
  public static final String e = "qz_patch";
  public static final String f = "p_ver";
  private static String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramString == null) {
      i = paramInt + jdField_a_of_type_Int * 10000;
    }
    return i;
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = Uri.parse(paramString).getLastPathSegment();
      } while (TextUtils.isEmpty(paramString));
      paramString = Pattern.compile("_r(\\d+)").matcher(paramString);
    } while (!paramString.find());
    paramString = paramString.group(1);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static QZonePatchService a()
  {
    if (jdField_a_of_type_CooperationQzonePatchQZonePatchService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzonePatchQZonePatchService == null) {
        jdField_a_of_type_CooperationQzonePatchQZonePatchService = new QZonePatchService();
      }
      return jdField_a_of_type_CooperationQzonePatchQZonePatchService;
    }
  }
  
  private static String a(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void a(int paramInt)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("QZ_setting", 0).edit().putInt("V 6.5.5.2880p_ver", paramInt).commit();
  }
  
  public static void a(String paramString)
  {
    int i = a(paramString);
    jdField_a_of_type_Int = i;
    a(i);
  }
  
  private static void b()
  {
    b("开始验证补丁包");
    g = null;
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
    long l;
    int i;
    Object localObject3;
    if (((File)localObject1).exists())
    {
      Object localObject2 = QUA.a() + "p_len";
      l = LocalMultiProcConfig.a((String)localObject2, 0L);
      b((String)localObject2 + " = " + l);
      b("补丁包的文件长度期待的是：" + l);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (localObject3 != null) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (!((File)localObject3).isDirectory()) {
        if (l != ((File)localObject3).length()) {
          ((File)localObject3).delete();
        } else {
          try
          {
            localObject1 = PluginStatic.encodeFile(((File)localObject3).getAbsolutePath()).toLowerCase();
            String str2 = ((File)localObject3).getName();
            str3 = str2.substring(0, str2.length() - ".jar".length());
            if (((String)localObject1 + ".jar").endsWith(str2.toLowerCase()))
            {
              g = str3;
              if (!TextUtils.isEmpty(g)) {
                break label334;
              }
              b("本地没有补丁包,当前md5是空的");
              return;
            }
          }
          catch (Exception localException)
          {
            String str3;
            String str1;
            for (;;)
            {
              QLog.w("qz_patch", 1, QLog.getStackTraceString(localException));
              str1 = null;
            }
            ((File)localObject3).delete();
            QZoneHelper.a((QQAppInterface)BaseApplicationImpl.a().a(), "qz_patch", 4, "patch verify failed: file md5: " + str1 + " but expected md5: " + str3, 1, System.currentTimeMillis());
            g = null;
          }
        }
      }
    }
    label334:
    b("当前补丁包的md5是" + g);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qz_patch", 2, paramString);
    }
  }
  
  private static void c(String paramString1, String paramString2)
  {
    b("开始更新补丁包");
    if (TextUtils.isEmpty(paramString1)) {
      b("md5是空的，什么都不做");
    }
    while (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    if (g == null)
    {
      b("本地没有补丁包");
      if (!"del".equals(paramString1)) {}
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = false;
      return;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        d(paramString1, paramString2);
        g = paramString1;
        continue;
        b("本地有补丁包");
        if (!g.equals(paramString1)) {
          break;
        }
        b("md5相同，什么都不做");
      }
    }
    if ((paramString1.equals("del")) || (paramString1.equals("delete"))) {
      b("md5是del，直接删除旧的Patch");
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
        if (paramString1.exists())
        {
          paramString1 = paramString1.listFiles();
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            paramString2 = paramString1[i];
            if (paramString2.isDirectory()) {
              break label307;
            }
            paramString2.delete();
          }
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
        }
      }
      for (;;)
      {
        QZoneHelper.a((QQAppInterface)BaseApplicationImpl.a().a(), "qz_patch", 1, "clear patch:" + g, 1, System.currentTimeMillis());
        break;
        LocalMultiProcConfig.a(QUA.a() + "p_len", 0L);
        g = null;
      }
      b("本地补丁包和网络补丁包不一样");
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break;
      }
      d(paramString1, paramString2);
      g = paramString1;
      break;
      label307:
      i += 1;
    }
  }
  
  /* Error */
  private static void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 298	cooperation/qzone/patch/QZonePatchService:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8: invokevirtual 236	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   11: checkcast 300	com/tencent/common/app/AppInterface
    //   14: aload_1
    //   15: new 118	java/io/File
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokestatic 307	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   26: ifeq +371 -> 397
    //   29: new 96	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 309
    //   39: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 159	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   52: invokestatic 110	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: ldc 16
    //   57: iconst_0
    //   58: invokevirtual 116	com/tencent/qphone/base/util/BaseApplication:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 164	java/io/File:exists	()Z
    //   66: ifeq +331 -> 397
    //   69: aload_2
    //   70: invokevirtual 184	java/io/File:listFiles	()[Ljava/io/File;
    //   73: astore 4
    //   75: aload 4
    //   77: arraylength
    //   78: istore 7
    //   80: iconst_0
    //   81: istore 6
    //   83: iload 6
    //   85: iload 7
    //   87: if_icmpge +310 -> 397
    //   90: aload 4
    //   92: iload 6
    //   94: aaload
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 187	java/io/File:isDirectory	()Z
    //   102: ifeq +6 -> 108
    //   105: goto +385 -> 490
    //   108: new 96	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 19
    //   121: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload 5
    //   129: invokevirtual 207	java/io/File:getName	()Ljava/lang/String;
    //   132: invokevirtual 218	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   135: istore 10
    //   137: iload 10
    //   139: ifeq +338 -> 477
    //   142: aload 5
    //   144: invokevirtual 121	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: invokestatic 199	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_2
    //   151: new 96	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 311
    //   161: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_2
    //   165: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 159	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: aload_2
    //   176: invokevirtual 314	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   179: ifeq +235 -> 414
    //   182: ldc_w 316
    //   185: invokestatic 159	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   188: new 96	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   195: invokestatic 168	cooperation/qzone/QUA:a	()Ljava/lang/String;
    //   198: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 22
    //   203: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore_2
    //   210: aload 5
    //   212: invokevirtual 191	java/io/File:length	()J
    //   215: lstore 8
    //   217: new 96	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   224: aload_2
    //   225: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc -81
    //   230: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: lload 8
    //   235: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 159	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   244: aload_2
    //   245: lload 8
    //   247: invokestatic 292	cooperation/qzone/LocalMultiProcConfig:a	(Ljava/lang/String;J)V
    //   250: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +40 -> 293
    //   256: ldc 12
    //   258: iconst_2
    //   259: new 96	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 318
    //   269: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 320
    //   279: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: lload 8
    //   284: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_1
    //   294: invokestatic 322	cooperation/qzone/patch/QZonePatchService:a	(Ljava/lang/String;)V
    //   297: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   300: invokevirtual 236	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   303: checkcast 238	com/tencent/mobileqq/app/QQAppInterface
    //   306: ldc 12
    //   308: bipush 10
    //   310: aconst_null
    //   311: invokestatic 324	cooperation/qzone/patch/QZonePatchService:a	(ILjava/lang/String;)I
    //   314: new 96	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 326
    //   324: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc_w 320
    //   334: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: lload 8
    //   339: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: iconst_1
    //   346: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   349: invokestatic 252	cooperation/qzone/QZoneHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;IJ)V
    //   352: ldc 12
    //   354: iconst_2
    //   355: new 96	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 328
    //   365: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: bipush 10
    //   370: aconst_null
    //   371: invokestatic 324	cooperation/qzone/patch/QZonePatchService:a	(ILjava/lang/String;)I
    //   374: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: goto +107 -> 490
    //   386: astore_0
    //   387: ldc 12
    //   389: iconst_1
    //   390: aload_0
    //   391: invokestatic 226	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   394: invokestatic 230	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: return
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_2
    //   401: ldc 12
    //   403: iconst_1
    //   404: aload_3
    //   405: invokestatic 226	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   408: invokestatic 230	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto -237 -> 174
    //   414: ldc_w 333
    //   417: invokestatic 159	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   420: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq +45 -> 468
    //   426: ldc 12
    //   428: iconst_2
    //   429: new 96	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 335
    //   439: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_2
    //   443: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc_w 337
    //   449: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 339
    //   459: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload 5
    //   470: invokevirtual 194	java/io/File:delete	()Z
    //   473: pop
    //   474: goto +16 -> 490
    //   477: aload 5
    //   479: invokevirtual 194	java/io/File:delete	()Z
    //   482: pop
    //   483: goto +7 -> 490
    //   486: astore_3
    //   487: goto -86 -> 401
    //   490: iload 6
    //   492: iconst_1
    //   493: iadd
    //   494: istore 6
    //   496: goto -413 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	paramString1	String
    //   0	499	1	paramString2	String
    //   4	439	2	localObject	Object
    //   398	7	3	localException1	Exception
    //   486	1	3	localException2	Exception
    //   73	18	4	arrayOfFile	File[]
    //   95	383	5	localFile	File
    //   81	414	6	i	int
    //   78	10	7	j	int
    //   215	123	8	l	long
    //   135	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	80	386	java/lang/Error
    //   97	105	386	java/lang/Error
    //   108	137	386	java/lang/Error
    //   142	151	386	java/lang/Error
    //   151	174	386	java/lang/Error
    //   174	293	386	java/lang/Error
    //   293	383	386	java/lang/Error
    //   401	411	386	java/lang/Error
    //   414	468	386	java/lang/Error
    //   468	474	386	java/lang/Error
    //   477	483	386	java/lang/Error
    //   142	151	398	java/lang/Exception
    //   151	174	486	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QzoneConfig.a().a("QZoneSetting", "isPatchEnable", 1) == 0) {
      return;
    }
    ThreadManager.b(new ynm(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\patch\QZonePatchService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */