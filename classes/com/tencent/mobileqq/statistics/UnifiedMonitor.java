package com.tencent.mobileqq.statistics;

import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.reporter.StackObservable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LooperMonitorHelper;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.ProcessStats.Stats;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MainService;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;
import uus;
import uut;
import uuu;
import uuv;

public class UnifiedMonitor
  extends AbstractUnifiedMonitor
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 1;
  private static UnifiedMonitor jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
  public static final String a = "unifiedMonitor";
  static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "UnifiedMonitor";
  public static final boolean b = true;
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  private static final String jdField_d_of_type_JavaLangString = "user_ratio_";
  static final int jdField_e_of_type_Int = 5;
  private static final String jdField_e_of_type_JavaLangString = "max_report_";
  static final int jdField_f_of_type_Int = 6;
  private static final String jdField_f_of_type_JavaLangString = "num_thresh_";
  static final int jdField_g_of_type_Int = 7;
  private static final String jdField_g_of_type_JavaLangString = "event_ratio_";
  static final int jdField_h_of_type_Int = 8;
  private static final String jdField_h_of_type_JavaLangString = "max_stackdep_";
  static final int jdField_i_of_type_Int = 9;
  private static final String jdField_i_of_type_JavaLangString = "max_stack_ts_";
  private static final int jdField_j_of_type_Int = 3000;
  private static final String jdField_j_of_type_JavaLangString = "max_monitor_time_";
  private static final String k = "max_log_num_";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public volatile boolean a;
  private uut[] jdField_a_of_type_ArrayOfUut;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private String jdField_c_of_type_JavaLangString;
  
  public UnifiedMonitor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfUut = new uut[] { new uut(0.001F, 100, 10, 0.1F, 6, 0, 0, 0), new uut(), new uut(), new uut(), new uut(0.001F, 200, 10, 0.001F, 6, 0, 0, 0), new uut(0.001F, 200, 10, 0.001F, 6, 0, 0, 0), new uut(0.001F, 1000, 10, 0.001F, 0, 0, 0, 0), new uut(0.001F, 1000, 10, 0.1F, 6, 6, 0, 0), new uut(0.001F, 0, 10, 0.1F, 0, 0, 0, 0), new uut(0.01F, 100, 5, 0.01F, 0, 0, 0, 0), new uut(0.001F, 100, 10, 0.1F, 6, 0, 0, 0), new uuu(0.0F, 100100005, 1, 0.01F, 0, 0, 2, 300), new uut(0.01F, 100, 5, 0.01F, 0, 0, 0, 0), new uut(0.001F, 1000, 10, 0.1F, 6, 0, 0, 0), new uut(0.001F, 100, 10, 0.1F, 6, 0, 0, 0) };
  }
  
  public static UnifiedMonitor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor != null) {
      return jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor = new UnifiedMonitor();
      }
      UnifiedMonitor localUnifiedMonitor = jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
      return localUnifiedMonitor;
    }
    finally {}
  }
  
  public static Map a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      String str = localObject.getClass().getName();
      if (((localObject instanceof SplashActivity)) && (SplashActivity.jdField_c_of_type_Int == 1)) {
        str = str + "_" + ((SplashActivity)localObject).a();
      }
      for (;;)
      {
        localObject = new HashMap(8);
        ((Map)localObject).put("act", str);
        return (Map)localObject;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Uuv = null;
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback != null)
    {
      this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback.onThreadMonitorEnd(paramInt);
      this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = null;
    }
  }
  
  private boolean a()
  {
    return new File(Environment.getExternalStorageDirectory().getPath() + "/looper").exists();
  }
  
  private void c()
  {
    if (2 == BaseApplicationImpl.i)
    {
      LooperMonitorHelper.b();
      return;
    }
    if (whetherReportDuringThisStartup(0)) {
      LooperMonitorHelper.a();
    }
    if (whetherReportDuringThisStartup(4)) {
      LooperMonitorHelper.c();
    }
    if (whetherReportDuringThisStartup(5)) {
      LooperMonitorHelper.e();
    }
    if (whetherReportDuringThisStartup(6)) {
      LooperMonitorHelper.f();
    }
    if (whetherReportDuringThisStartup(13)) {
      LooperMonitorHelper.d();
    }
    MainService.setUnifiedMonitorInstance(a());
    new Handler(Looper.getMainLooper()).post(new uus(this));
    d();
  }
  
  private final void d()
  {
    if ((whetherReportDuringThisStartup(11)) && (this.jdField_a_of_type_AndroidOsHandlerThread == null))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("cpu-stats", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      Looper localLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
      if (localLooper != null)
      {
        this.b = new Handler(localLooper, this);
        this.b.sendEmptyMessage(4);
      }
    }
  }
  
  private final void e()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (this.b != null) {
        this.b.removeCallbacksAndMessages(null);
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: invokestatic 270	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3: getstatic 276	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:unified_monitor_params	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   6: invokevirtual 279	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   9: invokevirtual 282	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: invokestatic 287	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   16: ifeq +29 -> 45
    //   19: ldc 17
    //   21: iconst_4
    //   22: new 111	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 289
    //   32: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_1
    //   46: ifnull +510 -> 556
    //   49: aload_1
    //   50: ldc_w 294
    //   53: invokevirtual 300	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnonnull +18 -> 76
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 301	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: aload_3
    //   77: arraylength
    //   78: istore 8
    //   80: iconst_0
    //   81: istore 6
    //   83: iload 6
    //   85: iload 8
    //   87: if_icmpge +469 -> 556
    //   90: aload_3
    //   91: iload 6
    //   93: aaload
    //   94: astore_1
    //   95: aload_1
    //   96: ldc_w 303
    //   99: invokevirtual 300	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull +637 -> 743
    //   109: aload 4
    //   111: arraylength
    //   112: iconst_2
    //   113: if_icmpne +630 -> 743
    //   116: aload 4
    //   118: iconst_0
    //   119: aaload
    //   120: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +620 -> 743
    //   126: aload 4
    //   128: iconst_1
    //   129: aaload
    //   130: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +610 -> 743
    //   136: aload 4
    //   138: iconst_0
    //   139: aaload
    //   140: bipush 95
    //   142: invokevirtual 313	java/lang/String:lastIndexOf	(I)I
    //   145: istore 9
    //   147: iload 9
    //   149: iconst_m1
    //   150: if_icmpeq +602 -> 752
    //   153: aload 4
    //   155: iconst_0
    //   156: aaload
    //   157: iconst_0
    //   158: iload 9
    //   160: iconst_1
    //   161: iadd
    //   162: invokevirtual 317	java/lang/String:substring	(II)Ljava/lang/String;
    //   165: astore_1
    //   166: iload 9
    //   168: iconst_m1
    //   169: if_icmpeq +588 -> 757
    //   172: iload 9
    //   174: aload 4
    //   176: iconst_0
    //   177: aaload
    //   178: invokevirtual 320	java/lang/String:length	()I
    //   181: iconst_1
    //   182: isub
    //   183: if_icmpge +574 -> 757
    //   186: aload 4
    //   188: iconst_0
    //   189: aaload
    //   190: iload 9
    //   192: iconst_1
    //   193: iadd
    //   194: invokevirtual 323	java/lang/String:substring	(I)Ljava/lang/String;
    //   197: astore_2
    //   198: aload_2
    //   199: invokestatic 329	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   202: invokevirtual 332	java/lang/Integer:intValue	()I
    //   205: istore 7
    //   207: invokestatic 287	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   210: ifeq +66 -> 276
    //   213: ldc 17
    //   215: iconst_4
    //   216: new 111	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 334
    //   226: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 7
    //   231: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 336
    //   237: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 338
    //   247: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 4
    //   252: iconst_0
    //   253: aaload
    //   254: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 340
    //   260: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload 4
    //   265: iconst_1
    //   266: aaload
    //   267: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_1
    //   277: ifnull +466 -> 743
    //   280: iload 9
    //   282: iconst_m1
    //   283: if_icmpeq +460 -> 743
    //   286: iload 7
    //   288: iconst_m1
    //   289: if_icmpeq +454 -> 743
    //   292: aload_2
    //   293: ifnull +450 -> 743
    //   296: iload 7
    //   298: bipush 15
    //   300: if_icmpge +443 -> 743
    //   303: ldc 24
    //   305: aload_1
    //   306: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifeq +26 -> 335
    //   312: aload_0
    //   313: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   316: iload 7
    //   318: aaload
    //   319: aload 4
    //   321: iconst_1
    //   322: aaload
    //   323: invokestatic 349	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   326: invokevirtual 353	java/lang/Float:floatValue	()F
    //   329: putfield 356	uut:jdField_a_of_type_Float	F
    //   332: goto +411 -> 743
    //   335: ldc 28
    //   337: aload_1
    //   338: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   341: ifeq +66 -> 407
    //   344: aload_0
    //   345: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   348: iload 7
    //   350: aaload
    //   351: aload 4
    //   353: iconst_1
    //   354: aaload
    //   355: invokestatic 329	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   358: invokevirtual 332	java/lang/Integer:intValue	()I
    //   361: putfield 358	uut:jdField_b_of_type_Int	I
    //   364: goto +379 -> 743
    //   367: astore_1
    //   368: invokestatic 287	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   371: ifeq +372 -> 743
    //   374: aload_1
    //   375: invokevirtual 361	java/lang/Throwable:printStackTrace	()V
    //   378: goto +365 -> 743
    //   381: astore_1
    //   382: invokestatic 287	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   385: ifeq +7 -> 392
    //   388: aload_1
    //   389: invokevirtual 361	java/lang/Throwable:printStackTrace	()V
    //   392: aload_0
    //   393: monitorenter
    //   394: aload_0
    //   395: iconst_1
    //   396: putfield 301	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   399: aload_0
    //   400: monitorexit
    //   401: return
    //   402: astore_1
    //   403: aload_0
    //   404: monitorexit
    //   405: aload_1
    //   406: athrow
    //   407: ldc 32
    //   409: aload_1
    //   410: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   413: ifeq +38 -> 451
    //   416: aload_0
    //   417: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   420: iload 7
    //   422: aaload
    //   423: aload 4
    //   425: iconst_1
    //   426: aaload
    //   427: invokestatic 329	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   430: invokevirtual 332	java/lang/Integer:intValue	()I
    //   433: putfield 363	uut:jdField_a_of_type_Int	I
    //   436: goto +307 -> 743
    //   439: astore_1
    //   440: aload_0
    //   441: monitorenter
    //   442: aload_0
    //   443: iconst_1
    //   444: putfield 301	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   447: aload_0
    //   448: monitorexit
    //   449: aload_1
    //   450: athrow
    //   451: ldc 36
    //   453: aload_1
    //   454: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   457: ifeq +27 -> 484
    //   460: aload_0
    //   461: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   464: iload 7
    //   466: aaload
    //   467: aload 4
    //   469: iconst_1
    //   470: aaload
    //   471: invokestatic 329	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   474: invokevirtual 332	java/lang/Integer:intValue	()I
    //   477: i2f
    //   478: putfield 365	uut:jdField_b_of_type_Float	F
    //   481: goto +262 -> 743
    //   484: ldc 40
    //   486: aload_1
    //   487: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   490: ifeq +34 -> 524
    //   493: getstatic 370	android/os/Build$VERSION:SDK_INT	I
    //   496: bipush 17
    //   498: if_icmpeq +245 -> 743
    //   501: aload_0
    //   502: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   505: iload 7
    //   507: aaload
    //   508: aload 4
    //   510: iconst_1
    //   511: aaload
    //   512: invokestatic 329	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   515: invokevirtual 332	java/lang/Integer:intValue	()I
    //   518: putfield 371	uut:jdField_c_of_type_Int	I
    //   521: goto +222 -> 743
    //   524: ldc 44
    //   526: aload_1
    //   527: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   530: ifeq +213 -> 743
    //   533: aload_0
    //   534: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   537: iload 7
    //   539: aaload
    //   540: aload 4
    //   542: iconst_1
    //   543: aaload
    //   544: invokestatic 329	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   547: invokevirtual 332	java/lang/Integer:intValue	()I
    //   550: putfield 373	uut:d	I
    //   553: goto +190 -> 743
    //   556: iconst_0
    //   557: istore 6
    //   559: iload 6
    //   561: aload_0
    //   562: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   565: arraylength
    //   566: if_icmpge +47 -> 613
    //   569: aload_0
    //   570: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   573: iload 6
    //   575: aaload
    //   576: astore_1
    //   577: invokestatic 379	java/lang/Math:random	()D
    //   580: aload_0
    //   581: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   584: iload 6
    //   586: aaload
    //   587: getfield 356	uut:jdField_a_of_type_Float	F
    //   590: f2d
    //   591: dcmpg
    //   592: ifgt +178 -> 770
    //   595: iconst_1
    //   596: istore 10
    //   598: aload_1
    //   599: iload 10
    //   601: putfield 142	uut:jdField_a_of_type_Boolean	Z
    //   604: iload 6
    //   606: iconst_1
    //   607: iadd
    //   608: istore 6
    //   610: goto -51 -> 559
    //   613: aload_0
    //   614: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   617: bipush 10
    //   619: aaload
    //   620: iconst_0
    //   621: putfield 142	uut:jdField_a_of_type_Boolean	Z
    //   624: invokestatic 382	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq +53 -> 680
    //   630: aload_0
    //   631: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   634: iconst_0
    //   635: aaload
    //   636: iconst_1
    //   637: putfield 142	uut:jdField_a_of_type_Boolean	Z
    //   640: aload_0
    //   641: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   644: iconst_0
    //   645: aaload
    //   646: ldc_w 383
    //   649: putfield 358	uut:jdField_b_of_type_Int	I
    //   652: aload_0
    //   653: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   656: iconst_0
    //   657: aaload
    //   658: fconst_1
    //   659: putfield 365	uut:jdField_b_of_type_Float	F
    //   662: invokestatic 382	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   665: ifeq +15 -> 680
    //   668: aload_0
    //   669: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   672: iconst_0
    //   673: aaload
    //   674: sipush 400
    //   677: putfield 363	uut:jdField_a_of_type_Int	I
    //   680: aload_0
    //   681: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   684: bipush 11
    //   686: aaload
    //   687: iconst_0
    //   688: putfield 142	uut:jdField_a_of_type_Boolean	Z
    //   691: aload_0
    //   692: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   695: bipush 14
    //   697: aaload
    //   698: invokestatic 388	common/config/service/QzoneConfig:a	()Lcommon/config/service/QzoneConfig;
    //   701: ldc_w 390
    //   704: ldc_w 392
    //   707: aload_0
    //   708: getfield 78	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfUut	[Luut;
    //   711: bipush 14
    //   713: aaload
    //   714: getfield 363	uut:jdField_a_of_type_Int	I
    //   717: invokevirtual 395	common/config/service/QzoneConfig:a	(Ljava/lang/String;Ljava/lang/String;I)I
    //   720: putfield 363	uut:jdField_a_of_type_Int	I
    //   723: aload_0
    //   724: monitorenter
    //   725: aload_0
    //   726: iconst_1
    //   727: putfield 301	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   730: aload_0
    //   731: monitorexit
    //   732: return
    //   733: astore_1
    //   734: aload_0
    //   735: monitorexit
    //   736: aload_1
    //   737: athrow
    //   738: astore_1
    //   739: aload_0
    //   740: monitorexit
    //   741: aload_1
    //   742: athrow
    //   743: iload 6
    //   745: iconst_1
    //   746: iadd
    //   747: istore 6
    //   749: goto -666 -> 83
    //   752: aconst_null
    //   753: astore_1
    //   754: goto -588 -> 166
    //   757: aconst_null
    //   758: astore_2
    //   759: goto -561 -> 198
    //   762: astore 5
    //   764: iconst_m1
    //   765: istore 7
    //   767: goto -560 -> 207
    //   770: iconst_0
    //   771: istore 10
    //   773: goto -175 -> 598
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	this	UnifiedMonitor
    //   12	38	1	str1	String
    //   71	4	1	localObject1	Object
    //   94	244	1	str2	String
    //   367	8	1	localThrowable1	Throwable
    //   381	8	1	localThrowable2	Throwable
    //   402	8	1	localObject2	Object
    //   439	88	1	localObject3	Object
    //   576	23	1	localuut	uut
    //   733	4	1	localObject4	Object
    //   738	4	1	localObject5	Object
    //   753	1	1	localObject6	Object
    //   197	562	2	str3	String
    //   56	35	3	arrayOfString1	String[]
    //   102	439	4	arrayOfString2	String[]
    //   762	1	5	localNumberFormatException	NumberFormatException
    //   81	667	6	m	int
    //   205	561	7	n	int
    //   78	10	8	i1	int
    //   145	139	9	i2	int
    //   596	176	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   63	70	71	finally
    //   72	74	71	finally
    //   95	104	367	java/lang/Throwable
    //   109	147	367	java/lang/Throwable
    //   153	166	367	java/lang/Throwable
    //   172	198	367	java/lang/Throwable
    //   198	207	367	java/lang/Throwable
    //   207	276	367	java/lang/Throwable
    //   303	332	367	java/lang/Throwable
    //   335	364	367	java/lang/Throwable
    //   407	436	367	java/lang/Throwable
    //   451	481	367	java/lang/Throwable
    //   484	521	367	java/lang/Throwable
    //   524	553	367	java/lang/Throwable
    //   0	45	381	java/lang/Throwable
    //   49	57	381	java/lang/Throwable
    //   76	80	381	java/lang/Throwable
    //   368	378	381	java/lang/Throwable
    //   559	595	381	java/lang/Throwable
    //   598	604	381	java/lang/Throwable
    //   613	680	381	java/lang/Throwable
    //   680	723	381	java/lang/Throwable
    //   394	401	402	finally
    //   403	405	402	finally
    //   0	45	439	finally
    //   49	57	439	finally
    //   76	80	439	finally
    //   95	104	439	finally
    //   109	147	439	finally
    //   153	166	439	finally
    //   172	198	439	finally
    //   198	207	439	finally
    //   207	276	439	finally
    //   303	332	439	finally
    //   335	364	439	finally
    //   368	378	439	finally
    //   382	392	439	finally
    //   407	436	439	finally
    //   451	481	439	finally
    //   484	521	439	finally
    //   524	553	439	finally
    //   559	595	439	finally
    //   598	604	439	finally
    //   613	680	439	finally
    //   680	723	439	finally
    //   725	732	733	finally
    //   734	736	733	finally
    //   442	449	738	finally
    //   739	741	738	finally
    //   198	207	762	java/lang/NumberFormatException
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = ThreadManager.a("unified-monitor", 0);
      ((HandlerThread)localObject).start();
      localObject = ((HandlerThread)localObject).getLooper();
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler((Looper)localObject, this);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (((uuu)this.jdField_a_of_type_ArrayOfUut[11]).d)
    {
      this.b.removeCallbacksAndMessages(null);
      this.b.obtainMessage(7, paramString).sendToTarget();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((((uuu)this.jdField_a_of_type_ArrayOfUut[11]).d) && (this.b.hasMessages(8)))
    {
      this.b.removeMessages(8);
      paramString = this.b.obtainMessage(8, paramString);
      this.b.sendMessageDelayed(paramString, paramLong);
    }
  }
  
  public void a(int[] paramArrayOfInt) {}
  
  public int[] a()
  {
    return new int[4];
  }
  
  public void addEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, Map paramMap)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!whetherReportDuringThisStartup(paramInt1))) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ArrayOfUut[paramInt1].jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ArrayOfUut[paramInt1].jdField_c_of_type_Boolean) && (TextUtils.isEmpty(str)));
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(17);
    }
    ((Map)localObject).put("family", String.valueOf(paramInt1));
    boolean bool;
    if (paramString != null)
    {
      ((Map)localObject).put("event", paramString);
      ((Map)localObject).put("revision", "229354");
      if (this.c == null)
      {
        this.c = "dbg";
        this.c = "pub";
      }
      ((Map)localObject).put("build_type", this.c);
      if (SystemClock.uptimeMillis() - ProcessStats.jdField_a_of_type_Long < 60000L)
      {
        ((Map)localObject).put("totalCpu", String.valueOf(ProcessStats.jdField_a_of_type_Int));
        ((Map)localObject).put("appCpu", String.valueOf(ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int));
        ((Map)localObject).put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - ProcessStats.jdField_a_of_type_Long) / 1000L));
      }
      if (paramInt1 == 0)
      {
        paramString = BaseApplicationImpl.a().a();
        if ((paramString != null) && ((paramString instanceof QQAppInterface)))
        {
          if (((QQAppInterface)paramString).a.jdField_a_of_type_Long == 0L) {
            break label455;
          }
          bool = true;
          label264:
          ((Map)localObject).put("param_is_logining", String.valueOf(bool));
          if (((QQAppInterface)paramString).a.c()) {
            break label461;
          }
          bool = true;
          label296:
          ((Map)localObject).put("param_syncing_msg", String.valueOf(bool));
        }
        ((Map)localObject).put("max_heap_size", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((Map)localObject).put("currentHeapSize", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
      }
      if (!QLog.isColorLevel()) {
        break label467;
      }
      paramString = "-1";
      label369:
      ((Map)localObject).put("not_reported", paramString);
      if (str != null)
      {
        if (str.length() > 950) {
          break label476;
        }
        ((Map)localObject).put("stack", str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt2, 0, localObject));
      paramString = this.jdField_a_of_type_ArrayOfUut[paramInt1];
      paramString.g += 1;
      return;
      paramString = "";
      break;
      label455:
      bool = false;
      break label264;
      label461:
      bool = false;
      break label296;
      label467:
      paramString = String.valueOf(paramInt3);
      break label369;
      label476:
      ((Map)localObject).put("stack", str.substring(0, 950));
      ((Map)localObject).put("stack1", str.substring(950));
    }
  }
  
  public void b() {}
  
  public int getThreshold(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Int;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj == null) {
        continue;
      }
      Object localObject;
      try
      {
        localObject = (HashMap)paramMessage.obj;
        int m = paramMessage.arg1;
        StatisticCollector.a(BaseApplicationImpl.a()).a(null, "unifiedMonitor", true, m, 0L, (HashMap)localObject, null);
        if (!((String)((HashMap)localObject).get("family")).equals("0")) {
          continue;
        }
        StackObservable.a().a((HashMap)localObject, m);
        return true;
      }
      catch (Throwable paramMessage) {}
      if (!QLog.isColorLevel()) {
        continue;
      }
      paramMessage.printStackTrace();
      return true;
      addEvent(paramMessage.arg1, "", 3000, -1, a());
      this.jdField_a_of_type_ArrayOfUut[paramMessage.arg1].jdField_a_of_type_JavaLangString = null;
      return true;
      f();
      c();
      return true;
      this.jdField_a_of_type_ArrayOfUut[11].jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.b.sendEmptyMessageDelayed(5, 2000L);
      return true;
      ProcessStats.a(false);
      if (this.b.hasMessages(7)) {
        continue;
      }
      this.b.sendEmptyMessageDelayed(6, 1500L);
      return true;
      ProcessStats.b(false);
      paramMessage = (uuu)this.jdField_a_of_type_ArrayOfUut[11];
      if (whetherReportThisTime(11, true))
      {
        localObject = new HashMap(10);
        ((Map)localObject).put("total_cpu", String.valueOf(ProcessStats.jdField_a_of_type_Int));
        ((Map)localObject).put("app_cpu", String.valueOf(ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int));
        a().addEvent(11, null, 0, 0, (Map)localObject);
      }
      if ((ProcessStats.jdField_a_of_type_Int >= paramMessage.j) || (ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int >= paramMessage.k)) {
        if ((QLog.isColorLevel()) && (SystemClock.uptimeMillis() - paramMessage.c > 60000L))
        {
          QLog.d("UnifiedMonitor", 2, "totalCpu exceed: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int);
          ProcessStats.a(true);
        }
      }
      try
      {
        Thread.sleep(2000L);
        ProcessStats.b(true);
        localObject = ProcessStats.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)((Iterator)localObject).next());
        }
        QLog.d("UnifiedMonitor", 2, ProcessStats.a(10));
        localObject = ProcessStats.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)((Iterator)localObject).next());
        }
        paramMessage.c = SystemClock.uptimeMillis();
        label518:
        paramMessage.h += 1;
        while ((paramMessage.h < paramMessage.e) && (SystemClock.uptimeMillis() - paramMessage.jdField_a_of_type_Long < paramMessage.f * 1000L))
        {
          this.b.sendEmptyMessageDelayed(5, 2000L);
          return true;
          QLog.d("UnifiedMonitor", 1, "totalCpu exceed: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int);
          break label518;
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedMonitor", 2, "totalCpu: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int);
          }
          paramMessage.m = 1;
        }
        this.b.removeCallbacksAndMessages(null);
        ProcessStats.a(true);
        this.b.sendEmptyMessageDelayed(8, 10000L);
        return true;
        ProcessStats.b(true);
        localObject = (uuu)this.jdField_a_of_type_ArrayOfUut[11];
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = ProcessStats.a(((uuu)localObject).l, true);
        QLog.d("UnifiedMonitor", 2, "trace " + paramMessage.obj + "'s cpu end(" + ProcessStats.jdField_a_of_type_Int + ", " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int + ")");
        paramMessage = ((List)localObject).iterator();
        while (paramMessage.hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)paramMessage.next());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public void notifyNotTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_JavaLangString = null;
    if ((paramInt == 0) || (paramInt == 10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
  }
  
  public void reportStackIfTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Boolean = false;
  }
  
  public boolean setMonitoredThread(int paramInt, Thread paramThread, AbstractUnifiedMonitor.ThreadMonitorCallback arg3)
  {
    if ((paramThread == null) || (!this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Uuv != null) || (this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_c_of_type_Int <= 0)) {
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UnifiedMonitor", 4, "setMonitoredThread for family=" + paramInt);
    }
    synchronized (this.jdField_a_of_type_ArrayOfUut[paramInt])
    {
      if (this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Uuv == null)
      {
        this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Uuv = new uuv(this, paramInt, paramThread);
        ThreadManager.a(this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Uuv, "um-stack-fetcher-" + paramInt, 5).start();
        this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_c_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public boolean whetherReportDuringThisStartup(int paramInt)
  {
    if (paramInt >= 15) {
      return false;
    }
    return this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Boolean;
  }
  
  public boolean whetherReportThisTime(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_a_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Boolean;
    }
    return whetherReportThisTime(paramInt, false);
  }
  
  public boolean whetherReportThisTime(int paramInt, boolean paramBoolean)
  {
    float f1 = this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Float;
    if (this.jdField_a_of_type_ArrayOfUut[paramInt].g >= this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_b_of_type_Int) {}
    while (Math.random() > f1) {
      return false;
    }
    return true;
  }
  
  public boolean whetherStackEnabled(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfUut[paramInt].jdField_c_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\statistics\UnifiedMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */