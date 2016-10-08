package com.tencent.mobileqq.startup.director;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import uti;
import utj;
import utk;

public class StartupDirector
  implements Handler.Callback
{
  private static final int A = 10;
  private static final int B = 11;
  private static final int C = 12;
  private static final int D = 13;
  public static final int a = 8;
  public static final long a = 550L;
  public static final String a = "AutoMonitor";
  public static final boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final int b = 90;
  public static final String b = "com.tencent.mobileqq";
  public static final boolean b = false;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static int c = 0;
  public static final String c = "k_start_mode";
  public static final boolean c = true;
  private static final int[] c;
  public static int d = 0;
  private static final String jdField_d_of_type_JavaLangString = "suicide_count";
  public static boolean d = false;
  private static final int[] jdField_d_of_type_ArrayOfInt;
  private static final int jdField_e_of_type_Int = -1;
  public static boolean e = false;
  private static final int[] jdField_e_of_type_ArrayOfInt;
  private static final int jdField_f_of_type_Int = 0;
  private static final long jdField_f_of_type_Long = 1000L;
  private static final boolean jdField_f_of_type_Boolean = false;
  private static final int[] jdField_f_of_type_ArrayOfInt;
  private static final int jdField_g_of_type_Int = 1;
  private static final int[] jdField_g_of_type_ArrayOfInt;
  private static final int jdField_h_of_type_Int = 2;
  private static long jdField_h_of_type_Long = 0L;
  private static final int[] jdField_h_of_type_ArrayOfInt;
  private static final int jdField_i_of_type_Int = 3;
  private static final int[] jdField_i_of_type_ArrayOfInt;
  private static final int jdField_j_of_type_Int = 4;
  private static final int[] jdField_j_of_type_ArrayOfInt;
  private static final int jdField_k_of_type_Int = 5;
  private static final int[] jdField_k_of_type_ArrayOfInt;
  private static final int jdField_l_of_type_Int = 6;
  private static final int[] jdField_l_of_type_ArrayOfInt;
  private static final int jdField_m_of_type_Int = 101;
  private static final int[] jdField_m_of_type_ArrayOfInt;
  private static final int jdField_n_of_type_Int = 201;
  private static final int[] jdField_n_of_type_ArrayOfInt;
  private static final int jdField_o_of_type_Int = 1000;
  private static final int[] jdField_o_of_type_ArrayOfInt;
  private static final int jdField_p_of_type_Int;
  private static final int[] jdField_p_of_type_ArrayOfInt;
  private static final int[] jdField_q_of_type_ArrayOfInt;
  private static final int r = 1;
  private static final int s = 2;
  private static final int t = 3;
  private static final int u = 4;
  private static final int v = 5;
  private static final int w = 6;
  private static final int x = 7;
  private static final int y = 8;
  private static final int z = 9;
  private int E;
  private int F;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public AppActivity a;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public long c;
  public long d;
  private long jdField_e_of_type_Long;
  private long jdField_g_of_type_Long;
  private int jdField_q_of_type_Int = -1;
  
  static
  {
    if (Build.MODEL.toLowerCase().startsWith("coolpad 80")) {}
    for (int i1 = 1;; i1 = 3)
    {
      jdField_p_of_type_Int = i1;
      jdField_a_of_type_ArrayOfInt = new int[] { 1, 7, 6, 13 };
      jdField_b_of_type_ArrayOfInt = new int[] { 4, 5, 17 };
      jdField_c_of_type_ArrayOfInt = new int[] { 10 };
      jdField_d_of_type_ArrayOfInt = new int[] { 9, 10, 15, 16 };
      jdField_e_of_type_ArrayOfInt = new int[] { 9, 10, 15 };
      f = new int[] { 5, 17 };
      jdField_g_of_type_ArrayOfInt = new int[] { 9, 15 };
      jdField_h_of_type_ArrayOfInt = f;
      i = new int[] { 4, 12, 8 };
      j = new int[] { 4, 9, 12, 8 };
      k = new int[] { 9, 12 };
      l = new int[] { 4, 8, 18 };
      m = new int[] { 11, 4 };
      n = new int[] { 11, 4, 12, 10, 8 };
      o = new int[] { 11, 4, 12, 10, 19 };
      jdField_p_of_type_ArrayOfInt = new int[] { 11, 4, 12, 10 };
      jdField_q_of_type_ArrayOfInt = new int[] { 27, 31 };
      jdField_d_of_type_Boolean = false;
      jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  /* Error */
  private final int a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: iconst_0
    //   9: istore 9
    //   11: iconst_0
    //   12: istore 7
    //   14: new 151	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 157	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc 37
    //   24: invokespecial 160	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 6
    //   29: iload 9
    //   31: istore 8
    //   33: aload 6
    //   35: invokevirtual 164	java/io/File:exists	()Z
    //   38: ifeq +50 -> 88
    //   41: new 166	java/io/BufferedInputStream
    //   44: dup
    //   45: new 168	java/io/FileInputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 178	java/io/BufferedInputStream:read	()I
    //   64: istore 8
    //   66: iload 8
    //   68: iconst_m1
    //   69: if_icmpne +208 -> 277
    //   72: iload 7
    //   74: istore 8
    //   76: aload_2
    //   77: ifnull +11 -> 88
    //   80: aload_2
    //   81: invokevirtual 181	java/io/BufferedInputStream:close	()V
    //   84: iload 7
    //   86: istore 8
    //   88: iload 8
    //   90: iconst_1
    //   91: iadd
    //   92: istore 7
    //   94: aload 5
    //   96: astore_1
    //   97: new 183	java/io/FileOutputStream
    //   100: dup
    //   101: aload 6
    //   103: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: astore_2
    //   107: aload_2
    //   108: iload 7
    //   110: invokevirtual 188	java/io/FileOutputStream:write	(I)V
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   121: iload 7
    //   123: ireturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   129: iload 7
    //   131: istore 8
    //   133: goto -45 -> 88
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   145: iload 9
    //   147: istore 8
    //   149: aload_2
    //   150: ifnull -62 -> 88
    //   153: aload_2
    //   154: invokevirtual 181	java/io/BufferedInputStream:close	()V
    //   157: iload 9
    //   159: istore 8
    //   161: goto -73 -> 88
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   169: iload 9
    //   171: istore 8
    //   173: goto -85 -> 88
    //   176: astore_1
    //   177: aload_3
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull +7 -> 187
    //   183: aload_2
    //   184: invokevirtual 181	java/io/BufferedInputStream:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   202: iload 7
    //   204: ireturn
    //   205: astore_3
    //   206: aload 4
    //   208: astore_2
    //   209: aload_2
    //   210: astore_1
    //   211: aload_3
    //   212: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   215: aload_2
    //   216: ifnull -95 -> 121
    //   219: aload_2
    //   220: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   223: iload 7
    //   225: ireturn
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   231: iload 7
    //   233: ireturn
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: aload_3
    //   238: astore_1
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   247: aload_1
    //   248: athrow
    //   249: astore_2
    //   250: aload_2
    //   251: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   254: goto -7 -> 247
    //   257: astore_1
    //   258: goto -19 -> 239
    //   261: astore_3
    //   262: goto -53 -> 209
    //   265: astore_3
    //   266: aload_1
    //   267: astore_2
    //   268: aload_3
    //   269: astore_1
    //   270: goto -91 -> 179
    //   273: astore_3
    //   274: goto -135 -> 139
    //   277: iload 8
    //   279: istore 7
    //   281: goto -209 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	StartupDirector
    //   0	284	1	paramContext	Context
    //   57	127	2	localObject1	Object
    //   189	2	2	localIOException1	java.io.IOException
    //   208	36	2	localObject2	Object
    //   249	2	2	localIOException2	java.io.IOException
    //   267	1	2	localContext	Context
    //   7	1	3	localObject3	Object
    //   136	42	3	localException1	Exception
    //   205	7	3	localIOException3	java.io.IOException
    //   234	4	3	localObject4	Object
    //   261	1	3	localIOException4	java.io.IOException
    //   265	4	3	localObject5	Object
    //   273	1	3	localException2	Exception
    //   1	206	4	localObject6	Object
    //   4	91	5	localObject7	Object
    //   27	75	6	localFile	File
    //   12	268	7	i1	int
    //   31	247	8	i2	int
    //   9	161	9	i3	int
    // Exception table:
    //   from	to	target	type
    //   80	84	124	java/io/IOException
    //   41	58	136	java/lang/Exception
    //   153	157	164	java/io/IOException
    //   41	58	176	finally
    //   183	187	189	java/io/IOException
    //   117	121	197	java/io/IOException
    //   97	107	205	java/io/IOException
    //   219	223	226	java/io/IOException
    //   97	107	234	finally
    //   211	215	234	finally
    //   243	247	249	java/io/IOException
    //   107	113	257	finally
    //   107	113	261	java/io/IOException
    //   60	66	265	finally
    //   141	145	265	finally
    //   60	66	273	java/lang/Exception
  }
  
  public static StartupDirector a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    StartupDirector localStartupDirector = new StartupDirector();
    localStartupDirector.a(0);
    Step.AmStepFactory.b(0, localStartupDirector, jdField_a_of_type_ArrayOfInt).c();
    if (BaseApplicationImpl.i == 1)
    {
      localStartupDirector.a(1);
      return localStartupDirector;
    }
    if (BaseApplicationImpl.i == 3)
    {
      Step.AmStepFactory.b(29, localStartupDirector, null).c();
      Step.AmStepFactory.b(11, localStartupDirector, null).c();
      Step.AmStepFactory.b(9, localStartupDirector, null).c();
      localStartupDirector.a(1);
      return localStartupDirector;
    }
    if (BaseApplicationImpl.i == 6)
    {
      jdField_d_of_type_Boolean = false;
      return localStartupDirector;
    }
    jdField_d_of_type_Boolean = false;
    Step.AmStepFactory.b(11, localStartupDirector, null).c();
    if (BaseApplicationImpl.i == 2)
    {
      Thread localThread = new Thread(Step.AmStepFactory.b(0, localStartupDirector, l));
      localThread.setPriority(10);
      localThread.start();
      Step.AmStepFactory.b(0, localStartupDirector, k).c();
    }
    label280:
    label373:
    label386:
    for (;;)
    {
      return null;
      if ((BaseApplicationImpl.i == 5) || (BaseApplicationImpl.processName.endsWith(":tool")))
      {
        Step.AmStepFactory.b(9, localStartupDirector, null).c();
        Step.AmStepFactory.b(6, localStartupDirector, null).c();
        Step.AmStepFactory.b(0, localStartupDirector, i).c();
        Step.AmStepFactory.b(10, localStartupDirector, null).c();
      }
      else if (BaseApplicationImpl.processName.endsWith(":secmsg"))
      {
        Step.AmStepFactory.b(10, localStartupDirector, null).c();
      }
      else
      {
        int i1;
        if (BaseApplicationImpl.processName.endsWith(":MSF"))
        {
          i1 = 4;
          BaseApplicationImpl.i = i1;
          if (!BaseApplicationImpl.processName.endsWith(":troopbar")) {
            break label373;
          }
          Step.AmStepFactory.b(10, localStartupDirector, null).c();
          Step.AmStepFactory.b(9, localStartupDirector, null).c();
          Step.AmStepFactory.b(12, localStartupDirector, null).c();
        }
        for (;;)
        {
          if ((BaseApplicationImpl.processName.endsWith(":picture")) || (BaseApplicationImpl.processName.endsWith(":qzonevideo"))) {
            break label386;
          }
          ThreadManager.a(Step.AmStepFactory.b(0, localStartupDirector, jdField_q_of_type_ArrayOfInt), 8, null, false);
          break;
          i1 = -1;
          break label280;
          Step.AmStepFactory.b(0, localStartupDirector, j).c();
        }
      }
    }
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("AutoMonitor", 2, "realCreateActivity " + this.jdField_q_of_type_Int + ", " + this.jdField_a_of_type_JavaUtilArrayList);
      QLog.d("AutoMonitor", 2, "realCreateActivity time=" + System.currentTimeMillis());
    }
    if (this.jdField_q_of_type_Int == 3) {
      a(4);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localObject != null) {}
        for (localObject = (AppActivity)((WeakReference)localObject).get();; localObject = null)
        {
          if (localObject != null) {
            ((AppActivity)localObject).realOnCreate();
          }
          i1 -= 1;
          break;
        }
      }
    }
    long l1;
    if (BaseApplicationImpl.jdField_a_of_type_Long > 0L)
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_d_of_type_Long = (l1 - BaseApplicationImpl.jdField_a_of_type_Long);
      Log.d("AutoMonitor", "ActionLoginA, cost=" + this.jdField_d_of_type_Long);
      if (!NetworkUtil.e(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
        break label250;
      }
    }
    label250:
    for (BaseApplicationImpl.jdField_a_of_type_Long = -l1;; BaseApplicationImpl.jdField_a_of_type_Long = 0L)
    {
      a(5);
      a(2, 0, 3000L);
      if (BaseApplicationImpl.i == 1) {
        b(12, 0, 10000L);
      }
      return;
    }
  }
  
  private void a(int paramInt)
  {
    long l1;
    if (jdField_d_of_type_Boolean)
    {
      if (this.jdField_q_of_type_Int == -1) {
        break label106;
      }
      l1 = SystemClock.uptimeMillis();
      Log.i("AutoMonitor", "STATE_" + this.jdField_q_of_type_Int + ", cost=" + (l1 - jdField_h_of_type_Long) + " then " + paramInt);
    }
    for (;;)
    {
      if (paramInt != 1000)
      {
        if (this.jdField_q_of_type_Int == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          jdField_h_of_type_Long = l1;
        }
      }
      this.jdField_q_of_type_Int = paramInt;
      return;
      label106:
      l1 = 0L;
    }
  }
  
  private void a(AppActivity paramAppActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppActivity == null) {
      return;
    }
    TextView localTextView = new TextView(paramAppActivity);
    paramAppActivity.getWindow().setBackgroundDrawableResource(17170446);
    localTextView.setGravity(17);
    localTextView.setBackgroundColor(-16777216);
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!paramBoolean1) {
      if (InjectUtils.a) {
        localTextView.setText(2131367325);
      }
    }
    for (;;)
    {
      paramAppActivity.setContentView(localTextView);
      QLog.flushLog();
      InjectUtils.a(paramAppActivity, "SuicideFailed", Integer.toString(jdField_d_of_type_Int));
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new utk(this, paramAppActivity), 8000L);
      return;
      localTextView.setText(2131367324);
      continue;
      localTextView.setText("程序启动失败，请稍候重试.");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onEndStep with " + paramBoolean + ", when " + this.jdField_q_of_type_Int);
    }
    if (paramBoolean)
    {
      ThreadManager.b().post(Step.AmStepFactory.b(8, this, null));
      if (jdField_c_of_type_Int == 1) {
        ThreadManager.b().post(Step.AmStepFactory.b(20, this, null));
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a(1000);
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if (paramBoolean)
    {
      l1 = SystemClock.uptimeMillis();
      l2 = this.jdField_c_of_type_Long;
      l3 = this.jdField_c_of_type_Long;
      l4 = BaseApplicationImpl.jdField_b_of_type_Long;
      l5 = BaseApplicationImpl.jdField_b_of_type_Long;
      if ((BaseApplicationImpl.jdField_b_of_type_Long <= 0L) || (!NetworkUtil.h(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl))) {
        break label249;
      }
    }
    label249:
    for (BaseApplicationImpl.jdField_b_of_type_Long = -l1;; BaseApplicationImpl.jdField_b_of_type_Long = 0L)
    {
      long l6 = this.jdField_b_of_type_Long;
      long l7 = this.jdField_d_of_type_Long;
      ThreadManager.b().postDelayed(new uti(this, l7, l6, l2, l1 - l3, l4, l1 - l5), 10000L);
      ThreadManager.b().postDelayed(new utj(this), 3000L);
      ThreadManager.b().postDelayed(Step.AmStepFactory.b(27, this, null), 5000L);
      BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = null;
      return;
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.E = 1;
    paramArrayOfInt1 = Step.AmStepFactory.b(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      this.E = 2;
      this.F = paramInt;
      paramArrayOfInt1.a(this.jdField_b_of_type_AndroidOsHandler, 10);
      paramArrayOfInt2 = Step.AmStepFactory.b(0, this, paramArrayOfInt2);
      paramArrayOfInt2.a(this.jdField_b_of_type_AndroidOsHandler, 10);
      ThreadManager.a().post(paramArrayOfInt2);
    }
    for (;;)
    {
      paramArrayOfInt1.c();
      return;
      paramArrayOfInt1.a(this.jdField_b_of_type_AndroidOsHandler, paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onActivityFocusChanged when " + this.jdField_q_of_type_Int + ", " + paramAppActivity + ", " + paramBoolean);
    }
    if (!paramBoolean) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_q_of_type_Int == 2)
      {
        a(11, 1, 5L);
        a(3);
        return;
      }
      if (this.jdField_q_of_type_Int == 101)
      {
        a(11, 7, 5L);
        a(3);
        return;
      }
      if (this.jdField_q_of_type_Int == 201)
      {
        a(11, 8, 5L);
        a(3);
        return;
      }
      if ((this.jdField_q_of_type_Int == 5) || (this.jdField_q_of_type_Int == 6))
      {
        a(true);
        return;
      }
    } while (this.jdField_q_of_type_Int == 3);
  }
  
  public boolean a(Object paramObject, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    QLog.i("AutoMonitor", 1, "onActivityCreate" + paramObject);
    if ((paramObject instanceof AppActivity)) {}
    for (paramObject = (AppActivity)paramObject;; paramObject = null)
    {
      long l1 = SystemClock.uptimeMillis();
      if ((this.jdField_q_of_type_Int == 1) && (Math.abs(l1 - BaseApplicationImpl.jdField_c_of_type_Long) > 4000L))
      {
        BaseApplicationImpl.jdField_b_of_type_Long = 0L;
        BaseApplicationImpl.jdField_a_of_type_Long = 0L;
        BaseApplicationImpl.jdField_c_of_type_Long = 0L;
      }
      int i1;
      if (paramObject == null) {
        if (this.jdField_q_of_type_Int == 1)
        {
          BaseApplicationImpl.jdField_b_of_type_Boolean = true;
          BaseApplicationImpl.jdField_b_of_type_Long = 0L;
          BaseApplicationImpl.jdField_a_of_type_Long = 0L;
          if (paramIntent != null) {
            jdField_c_of_type_Int = paramIntent.getIntExtra("k_start_mode", 0);
          }
          QLog.i("AutoMonitor", 1, "onActivityCreate" + this.jdField_q_of_type_Int + ", " + jdField_c_of_type_Int);
          paramObject = n;
          if (jdField_c_of_type_Int == 1)
          {
            paramObject = o;
            Step.AmStepFactory.b(0, this, (int[])paramObject).c();
            if (GuardManager.a != null)
            {
              paramObject = GuardManager.a;
              if (jdField_c_of_type_Int != 2) {
                break label260;
              }
              i1 = 1;
              label209:
              ((GuardManager)paramObject).a(i1, null);
            }
            a(201);
            label223:
            bool2 = false;
          }
        }
      }
      for (;;)
      {
        return bool2;
        if (jdField_c_of_type_Int == 2)
        {
          paramObject = jdField_p_of_type_ArrayOfInt;
          BaseApplicationImpl.jdField_c_of_type_Long = 0L;
          break;
        }
        if (jdField_c_of_type_Int != 0) {
          break;
        }
        paramObject = n;
        break;
        label260:
        i1 = 6;
        break label209;
        if (this.jdField_q_of_type_Int == 2)
        {
          Step.AmStepFactory.b(0, this, m).c();
          a(101);
          break label223;
        }
        if ((this.jdField_q_of_type_Int != 201) || (jdField_c_of_type_Int != 2) || (paramIntent == null)) {
          break label223;
        }
        i1 = paramIntent.getIntExtra("k_start_mode", 2);
        QLog.i("AutoMonitor", 1, "onActivityCreate" + this.jdField_q_of_type_Int + ", " + i1);
        if ((i1 != 3) && (i1 != 0) && (i1 != 1)) {
          break label223;
        }
        Step.AmStepFactory.b(8, this, null).c();
        break label223;
        if ((this.jdField_q_of_type_Int != 1) && (this.jdField_q_of_type_Int != 2) && (this.jdField_q_of_type_Int != 101) && (this.jdField_q_of_type_Int != 201)) {
          break label821;
        }
        if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) && (!(paramObject instanceof InstallActivity)))
        {
          paramIntent = new Intent((Context)paramObject, InstallActivity.class);
          paramIntent.addFlags(603979776);
          Intent localIntent = ((AppActivity)paramObject).getIntent();
          localIntent.addFlags(67108864);
          paramIntent.putExtra("NT_AY", localIntent);
          try
          {
            ((AppActivity)paramObject).superStartActivityForResult(paramIntent, -1, null);
          }
          catch (Exception paramIntent)
          {
            try
            {
              for (;;)
              {
                ((AppActivity)paramObject).superFinish();
                jdField_d_of_type_Int = a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
                bool2 = bool1;
                if (jdField_d_of_type_Int > jdField_p_of_type_Int) {
                  break;
                }
                System.exit(-1);
                return true;
                paramIntent = paramIntent;
                QLog.e("AutoMonitor", 1, "", paramIntent);
              }
            }
            catch (Exception paramObject)
            {
              for (;;)
              {
                QLog.e("AutoMonitor", 1, "", (Throwable)paramObject);
              }
            }
          }
        }
      }
      this.jdField_a_of_type_MqqAppAppActivity = ((AppActivity)paramObject);
      if ((paramObject instanceof InstallActivity)) {}
      try
      {
        new File(this.jdField_a_of_type_MqqAppAppActivity.getFilesDir(), "suicide_count").delete();
        if (!(paramObject instanceof SplashActivity))
        {
          BaseApplicationImpl.jdField_a_of_type_Long = 0L;
          BaseApplicationImpl.jdField_b_of_type_Long = 0L;
        }
        if ((BaseApplicationImpl.i == 3) && (this.jdField_q_of_type_Int == 201))
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObject));
          a(5);
          if (this.jdField_b_of_type_AndroidOsHandler == null) {
            this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
          }
          return false;
        }
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
        }
        Step.AmStepFactory.b(2, this, null).c();
        a(2, 0, 1000L);
        if ((this.jdField_q_of_type_Int == 201) || ((this.jdField_q_of_type_Int == 1) && (jdField_c_of_type_Int == 2))) {
          this.jdField_c_of_type_Long = l1;
        }
        bool1 = bool2;
        if (this.jdField_q_of_type_Int == 1)
        {
          a(2);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObject));
        return bool1;
        label821:
        if ((this.jdField_q_of_type_Int == 5) || (this.jdField_q_of_type_Int == 6))
        {
          BaseApplicationImpl.jdField_a_of_type_Long = 0L;
          BaseApplicationImpl.jdField_b_of_type_Long = 0L;
          this.jdField_a_of_type_MqqAppAppActivity = ((AppActivity)paramObject);
          a(6);
          a(2, 0, 1000L);
          bool1 = false;
        }
        else
        {
          bool1 = bool2;
          if (this.jdField_q_of_type_Int == 3) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "handleMessage when " + this.jdField_q_of_type_Int + ", what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 7: 
    case 8: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                a(4, 0, 300L);
                bool1 = Step.AmStepFactory.b(11, this, null).c();
                if ((bool1) && (jdField_d_of_type_Int <= jdField_p_of_type_Int))
                {
                  a(5, 0, 0L);
                  if (BaseApplicationImpl.i == 3) {
                    a(jdField_c_of_type_ArrayOfInt, null, 6);
                  }
                  for (;;)
                  {
                    b(9, 0, 300L);
                    return true;
                    a(jdField_b_of_type_ArrayOfInt, jdField_d_of_type_ArrayOfInt, 6);
                  }
                }
                if (bool1) {
                  i1 = 1;
                }
                a(3, i1, 0L);
                return true;
                b(9, 0, 300L);
                a(jdField_e_of_type_ArrayOfInt, f, 6);
                return true;
                a(jdField_g_of_type_ArrayOfInt, jdField_h_of_type_ArrayOfInt, 6);
                return true;
                a(this.jdField_a_of_type_MqqAppAppActivity, true);
                return true;
              } while (this.jdField_a_of_type_MqqAppAppActivity == null);
              AppActivity localAppActivity = this.jdField_a_of_type_MqqAppAppActivity;
              if (paramMessage.arg1 > 0) {}
              for (bool1 = true;; bool1 = false)
              {
                if (jdField_d_of_type_Int < jdField_p_of_type_Int) {
                  bool2 = true;
                }
                a(localAppActivity, bool1, bool2);
                return true;
              }
            } while (this.jdField_a_of_type_MqqAppAppActivity == null);
            ShortcutUtils.a(this.jdField_a_of_type_MqqAppAppActivity, "com.tencent.mobileqq.activity.MainActivity");
            ShortcutUtils.a(this.jdField_a_of_type_MqqAppAppActivity, SplashActivity.class.getName());
            return true;
            if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(4)) {
              ShortcutUtils.a(this.jdField_a_of_type_MqqAppAppActivity.getApplicationContext(), SplashActivity.class.getName());
            }
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
            return true;
            if (paramMessage.arg1 == 0)
            {
              if (this.jdField_b_of_type_Long > 0L) {
                this.jdField_e_of_type_Long = (this.jdField_g_of_type_Long + this.jdField_b_of_type_Long - SystemClock.uptimeMillis());
              }
              if (BaseApplicationImpl.jdField_c_of_type_Boolean)
              {
                System.gc();
                System.runFinalization();
                this.jdField_e_of_type_Long = 2000L;
              }
              if ((this.jdField_e_of_type_Long > 0L) && (this.jdField_e_of_type_Long < 6000L))
              {
                a(6, 1, this.jdField_e_of_type_Long);
                return true;
              }
              a();
              return true;
            }
            a();
            return true;
            Step.AmStepFactory.b(12, this, null).c();
          } while (BaseApplicationImpl.i != 3);
          a(13, 0, 0L);
          return true;
          i1 = this.E - 1;
          this.E = i1;
        } while (i1 != 0);
        a(this.F, 0, 0L);
        return true;
        if (this.jdField_b_of_type_Long > 0L) {
          this.jdField_g_of_type_Long = SystemClock.uptimeMillis();
        }
        b(paramMessage.arg1, 0, 0L);
        return true;
      } while (GuardManager.a == null);
      paramMessage = GuardManager.a;
      if (jdField_c_of_type_Int == 2) {
        bool1 = true;
      }
      paramMessage.c(bool1);
      return true;
    }
    Step.AmStepFactory.b(26, this, null).c();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\director\StartupDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */