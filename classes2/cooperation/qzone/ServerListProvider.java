package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.Utility;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerListProvider
{
  public static final int A = 36;
  public static final int B = 37;
  public static final int C = 38;
  public static final int D = 39;
  public static final int E = 40;
  public static final int F = 41;
  public static final int G = 42;
  public static final int H = 43;
  public static final int I = 44;
  public static final int J = 45;
  public static final int K = 46;
  public static final int L = 47;
  public static final int M = 48;
  public static final int N = 49;
  public static final int O = 50;
  public static final int P = 51;
  public static final int Q = 60;
  public static final int R = 61;
  public static final int S = 62;
  public static final int T = 63;
  public static final int U = 64;
  public static final int V = 65;
  public static final int W = 66;
  public static final int X = 67;
  public static final int Y = 68;
  public static final int Z = 69;
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = ServerListProvider.class.getSimpleName();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static final int aa = 70;
  public static final int ab = 71;
  public static final int ac = 72;
  public static final int ad = 73;
  public static final int ae = 74;
  public static final int af = 75;
  public static final int ag = 76;
  public static final int ah = 77;
  public static final int ai = 78;
  public static final int aj = 79;
  public static final int ak = 80;
  public static final int al = 81;
  public static final int am = 82;
  public static final int an = 83;
  public static final int ao = 84;
  public static final int ap = 85;
  public static final int b = 11;
  private static String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/com/tencent/mobileqq";
  public static final int c = 12;
  public static final int d = 13;
  public static final int e = 14;
  public static final int f = 15;
  public static final int g = 16;
  public static final int h = 17;
  public static final int i = 18;
  public static final int j = 19;
  public static final int k = 20;
  public static final int l = 21;
  public static final int m = 22;
  public static final int n = 23;
  public static final int o = 24;
  public static final int p = 25;
  public static final int q = 26;
  public static final int r = 27;
  public static final int s = 28;
  public static final int t = 29;
  public static final int u = 30;
  public static final int v = 31;
  public static final int w = 32;
  public static final int x = 33;
  public static final int y = 34;
  public static final int z = 35;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.a("ServerEnvironment", 0);
  }
  
  public static String a()
  {
    switch ()
    {
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    default: 
      return "SQQzoneSvc.";
    case 11: 
      return "SQQzoneSvcTest001.";
    case 12: 
      return "SQQzoneSvcTouch001.";
    case 13: 
      return "SQQzoneSvcDb2.";
    case 14: 
      return "SQQzoneSvcPublish.";
    case 15: 
      return "SQQzoneSvcDev001.";
    case 16: 
      return "SQQzoneSvcDev002.";
    case 17: 
      return "SQQzoneSvcDev003.";
    case 18: 
      return "SQQzoneSvcDev004.";
    case 19: 
      return "SQQzoneSvcDev005.";
    case 20: 
      return "SQQzoneSvcDev006.";
    case 21: 
      return "SQQzoneSvcDev007.";
    case 22: 
      return "SQQzoneSvcDev008.";
    case 23: 
      return "SQQzoneSvcDev009.";
    case 24: 
      return "SQQzoneSvcDev010.";
    case 25: 
      return "SQQzoneSvcDev011.";
    case 26: 
      return "SQQzoneSvcDev012.";
    case 27: 
      return "SQQzoneSvcDev013.";
    case 28: 
      return "SQQzoneSvcDev014.";
    case 29: 
      return "SQQzoneSvcDev015.";
    case 30: 
      return "SQQzoneSvcDev016.";
    case 31: 
      return "SQQzoneSvcDev017.";
    case 32: 
      return "SQQzoneSvcDev018.";
    case 33: 
      return "SQQzoneSvcDev019.";
    case 34: 
      return "SQQzoneSvcDev020.";
    case 35: 
      return "SQQzoneSvcDev021.";
    case 36: 
      return "SQQzoneSvcDev022.";
    case 37: 
      return "SQQzoneSvcDev023.";
    case 38: 
      return "SQQzoneSvcDev024.";
    case 39: 
      return "SQQzoneSvcDev025.";
    case 40: 
      return "SQQzoneSvcDev026.";
    case 41: 
      return "SQQzoneSvcDev027.";
    case 42: 
      return "SQQzoneSvcDev028.";
    case 43: 
      return "SQQzoneSvcDev029.";
    case 44: 
      return "SQQzoneSvcDev030.";
    case 45: 
      return "SQQzoneSvcDev031.";
    case 46: 
      return "SQQzoneSvcDev032.";
    case 47: 
      return "SQQzoneSvcDev033.";
    case 48: 
      return "SQQzoneSvcDev034.";
    case 49: 
      return "SQQzoneSvcDev035.";
    case 50: 
      return "SQQzoneSvcDev036.";
    case 51: 
      return "SQQzoneSvcDev037.";
    case 60: 
      return "SQQzoneSvcDev050.";
    case 61: 
      return "SQQzoneSvcDev051.";
    case 62: 
      return "SQQzoneSvcDev052.";
    case 63: 
      return "SQQzoneSvcDev053.";
    case 64: 
      return "SQQzoneSvcDev054.";
    case 65: 
      return "SQQzoneSvcDev055.";
    case 66: 
      return "SQQzoneSvcDev056.";
    case 67: 
      return "SQQzoneSvcDev057.";
    case 68: 
      return "SQQzoneSvcDev058.";
    case 69: 
      return "SQQzoneSvcDev059.";
    case 70: 
      return "SQQzoneSvcDev060.";
    case 71: 
      return "SQQzoneSvcDev061.";
    case 72: 
      return "SQQzoneSvcDev062.";
    case 73: 
      return "SQQzoneSvcDev063.";
    case 74: 
      return "SQQzoneSvcDev064.";
    case 75: 
      return "SQQzoneSvcDev065.";
    case 76: 
      return "SQQzoneSvcDev066.";
    case 77: 
      return "SQQzoneSvcDev067.";
    case 78: 
      return "SQQzoneSvcDev068.";
    case 79: 
      return "SQQzoneSvcDev069.";
    case 80: 
      return "SQQzoneSvcDev089.";
    case 81: 
      return "SQQzoneSvcTest007.";
    case 82: 
      return "SQQzoneSvcDev070.";
    case 83: 
      return "SQQzoneSvcDev071.";
    case 84: 
      return "SQQzoneSvcTest008.";
    }
    return "SQQzoneSvcTest009.";
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 337	cooperation/qzone/ServerListProvider:b	()Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: new 170	java/io/File
    //   14: dup
    //   15: getstatic 184	cooperation/qzone/ServerListProvider:b	Ljava/lang/String;
    //   18: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 343	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_0
    //   30: invokevirtual 346	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 170	java/io/File
    //   37: dup
    //   38: new 159	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   45: getstatic 184	cooperation/qzone/ServerListProvider:b	Ljava/lang/String;
    //   48: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 348
    //   54: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 343	java/io/File:exists	()Z
    //   68: ifne -58 -> 10
    //   71: aload_0
    //   72: invokevirtual 351	java/io/File:createNewFile	()Z
    //   75: ifeq +166 -> 241
    //   78: new 353	java/io/FileWriter
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 356	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   86: astore_0
    //   87: new 358	java/io/BufferedWriter
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 361	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   95: astore_1
    //   96: aload_1
    //   97: ldc_w 363
    //   100: invokevirtual 366	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   115: aload_0
    //   116: ifnull -106 -> 10
    //   119: aload_0
    //   120: invokevirtual 370	java/io/FileWriter:close	()V
    //   123: return
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   135: goto -20 -> 115
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_2
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   151: aload_0
    //   152: ifnull -142 -> 10
    //   155: aload_0
    //   156: invokevirtual 370	java/io/FileWriter:close	()V
    //   159: return
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   171: goto -20 -> 151
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: aload_3
    //   178: astore_2
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   187: aload_2
    //   188: ifnull +7 -> 195
    //   191: aload_2
    //   192: invokevirtual 370	java/io/FileWriter:close	()V
    //   195: aload_0
    //   196: athrow
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   202: goto -15 -> 187
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   210: goto -15 -> 195
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_0
    //   217: astore_2
    //   218: aload_3
    //   219: astore_0
    //   220: goto -41 -> 179
    //   223: astore_3
    //   224: aload_0
    //   225: astore_2
    //   226: aload_3
    //   227: astore_0
    //   228: goto -49 -> 179
    //   231: astore_1
    //   232: aload_2
    //   233: astore_1
    //   234: goto -91 -> 143
    //   237: astore_2
    //   238: goto -95 -> 143
    //   241: aconst_null
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_1
    //   245: goto -138 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	99	0	localObject1	Object
    //   124	2	0	localException1	Exception
    //   138	1	0	localException2	Exception
    //   140	16	0	localObject2	Object
    //   160	2	0	localException3	Exception
    //   174	43	0	localObject3	Object
    //   219	24	0	localObject4	Object
    //   95	17	1	localBufferedWriter	java.io.BufferedWriter
    //   130	2	1	localException4	Exception
    //   142	6	1	localObject5	Object
    //   166	2	1	localException5	Exception
    //   176	8	1	localObject6	Object
    //   197	2	1	localException6	Exception
    //   205	2	1	localException7	Exception
    //   215	1	1	localObject7	Object
    //   231	1	1	localException8	Exception
    //   233	12	1	localObject8	Object
    //   3	230	2	localObject9	Object
    //   237	1	2	localException9	Exception
    //   1	177	3	localObject10	Object
    //   213	6	3	localObject11	Object
    //   223	4	3	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   119	123	124	java/lang/Exception
    //   111	115	130	java/lang/Exception
    //   71	87	138	java/lang/Exception
    //   155	159	160	java/lang/Exception
    //   147	151	166	java/lang/Exception
    //   71	87	174	finally
    //   183	187	197	java/lang/Exception
    //   191	195	205	java/lang/Exception
    //   87	96	213	finally
    //   96	107	223	finally
    //   87	96	231	java/lang/Exception
    //   96	107	237	java/lang/Exception
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    LocalMultiProcConfig.b("key_enable_debug", paramBoolean);
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(LocalMultiProcConfig.a("key_enable_debug", false));
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static int b()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("upload", 2, "debug Version server:" + 0);
    }
    IUploadService.UploadServiceCreator.getInstance().setTestServer(0);
    return 0;
  }
  
  private static void b()
  {
    try
    {
      File localFile = new File(b + "/testserver");
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    try
    {
      File localFile = new File(b + "/testserver");
      boolean bool1 = bool2;
      if (localFile.exists())
      {
        long l1 = localFile.length();
        bool1 = bool2;
        if (l1 > 0L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static void c()
  {
    Utility.CUSTOM_IP = LocalMultiProcConfig.a("ServerUploadCustomIp", "113.108.67.16");
    Utility.CUSTOM_PORT = LocalMultiProcConfig.a("ServerUploadCustomPort", 19994);
    if (QLog.isColorLevel()) {
      QLog.d("upload", 2, "custom server loaded:" + Utility.CUSTOM_IP + ":" + Utility.CUSTOM_PORT);
    }
  }
  
  public static boolean c()
  {
    if (!b())
    {
      a();
      if (!e()) {}
    }
    else
    {
      return true;
    }
    b();
    return false;
  }
  
  public static boolean d()
  {
    if (b())
    {
      b();
      if (!e()) {}
    }
    else
    {
      return true;
    }
    a();
    return false;
  }
  
  private static boolean e()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null)
      {
        Iterator localIterator = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (localRunningAppProcessInfo.processName.equals(localBaseApplication.getPackageName() + ":MSF"))
          {
            Process.killProcess(localRunningAppProcessInfo.pid);
            return true;
          }
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\ServerListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */