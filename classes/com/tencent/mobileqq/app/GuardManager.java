package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.memory.ProcReporter;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.trick.TrickHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import pts;
import ptt;
import pxm;
import pxn;
import pyg;
import pyh;
import pyi;
import pzl;
import pzm;
import qcy;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  private static final int A = 3;
  private static final int B = 4;
  private static final int C = 5;
  private static final int D = 6;
  private static final int E = 7;
  public static GuardManager a;
  public static final String a = "com.tencent.plugin.state.change";
  public static final String b = "key_plugin_state";
  public static final int c = 0;
  static final String jdField_c_of_type_JavaLangString = "GuardManager";
  private static final boolean jdField_c_of_type_Boolean = true;
  public static final int d = 1;
  public static long d = 0L;
  public static int e = -1;
  public static final String e = "guardmgr_qzone_bg_time";
  public static final int f = 0;
  protected static final String f = "fake_p_msg";
  public static final int g = 1;
  protected static final String g = "trick_p_msg";
  public static final int h = 2;
  private static final String h = "com.tencent.process.stopping";
  protected static final int i = 12000;
  private static final String i = "com.tencent.process.starting";
  protected static final int j = 1;
  private static final String j = "20140619";
  protected static final int k = 3;
  protected static final int l = 50;
  protected static final int m = 2;
  protected static final int n = 15;
  protected static final int o = 5;
  public static final int p = 6;
  public static final int q = 0;
  public static final int r = 1;
  public static int s = 5;
  public static final int t = 1;
  public static final int u = 6;
  public static final int v = 0;
  private static final int x = 101;
  private static final int y = 1;
  private static final int z = 2;
  public int a;
  public long a;
  private Application jdField_a_of_type_AndroidAppApplication;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler;
  Random jdField_a_of_type_JavaUtilRandom;
  private pyi jdField_a_of_type_Pyi;
  private boolean jdField_a_of_type_Boolean;
  pyi[] jdField_a_of_type_ArrayOfPyi = new pyi[9];
  public long[][] a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long;
  public String d;
  private int w = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GuardManager(Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_Array2dOfLong = ((long[][])Array.newInstance(Long.TYPE, new int[] { 3, 15 }));
    this.jdField_a_of_type_Long = 0L;
    this.c = 0L;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.a(), this);
    a(paramInt, null);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this, paramApplication);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pyh(this);
        paramApplication = new IntentFilter();
        paramApplication.addAction("android.intent.action.SCREEN_OFF");
        paramApplication.addAction("android.intent.action.SCREEN_ON");
      }
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramApplication);
        Foreground.setReady();
        return;
      }
      catch (Throwable paramApplication)
      {
        for (;;) {}
      }
    }
    catch (Throwable paramApplication)
    {
      for (;;) {}
    }
  }
  
  public static int a()
  {
    int i1 = 3;
    String str;
    if (e == -1) {
      str = BaseApplicationImpl.a.getSharedPreferences("GuardManager", 0).getString("QZoneBgKillTick", String.valueOf(3));
    }
    try
    {
      int i2 = Integer.parseInt(str);
      i1 = i2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    e = i1;
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "getQZoneFgKillTick: " + e);
    }
    return e;
  }
  
  public static void a(String paramString)
  {
    try
    {
      e = Integer.parseInt(paramString);
      BaseApplicationImpl.a.getSharedPreferences("GuardManager", 0).edit().putString("QZoneBgKillTick", paramString).commit();
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "setQZoneBgKillTick: " + paramString);
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  pyi a(int paramInt)
  {
    pyi localpyi = this.jdField_a_of_type_ArrayOfPyi[paramInt];
    Object localObject = localpyi;
    if (localpyi == null) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 2: 
        localObject = new pxm();
      }
    }
    for (;;)
    {
      ((pyi)localObject).jdField_a_of_type_ComTencentMobileqqAppGuardManager = this;
      ((pyi)localObject).s = paramInt;
      this.jdField_a_of_type_ArrayOfPyi[paramInt] = localObject;
      return (pyi)localObject;
      localObject = new pxn();
      continue;
      localObject = new pts();
      continue;
      localObject = new ptt();
      continue;
      localObject = new pzm();
      continue;
      localObject = new pyi();
      continue;
      localObject = new pzl();
      continue;
      localObject = new qcy();
    }
  }
  
  public void a()
  {
    a(8, null);
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        do
        {
          this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
          CoreService.b();
          return;
          localThrowable1 = localThrowable1;
        } while (!QLog.isColorLevel());
        QLog.d("GuardManager", 2, "", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
  }
  
  void a(int paramInt)
  {
    int i3 = (int)(System.currentTimeMillis() / 60000L);
    if (i3 == this.jdField_b_of_type_Int)
    {
      long[] arrayOfLong = this.jdField_a_of_type_Array2dOfLong[paramInt];
      paramInt = this.jdField_a_of_type_Int;
      arrayOfLong[paramInt] += 1L;
      return;
    }
    int i2;
    if ((i3 < this.jdField_b_of_type_Int) || (i3 - this.jdField_b_of_type_Int > 15))
    {
      i1 = 0;
      while (i1 < 3)
      {
        i2 = 0;
        while (i2 < 15)
        {
          this.jdField_a_of_type_Array2dOfLong[i1][i2] = 0L;
          i2 += 1;
        }
        i1 += 1;
      }
      this.jdField_b_of_type_Int = (i3 - 15);
      this.jdField_a_of_type_Int = 0;
    }
    int i4 = (i3 - this.jdField_b_of_type_Int) % 15;
    int i1 = 1;
    while (i1 <= i4)
    {
      i2 = 0;
      while (i2 < 3)
      {
        this.jdField_a_of_type_Array2dOfLong[i2][((this.jdField_a_of_type_Int + i1) % 15)] = 0L;
        i2 += 1;
      }
      i1 += 1;
    }
    this.jdField_b_of_type_Int = i3;
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + i4) % 15);
    this.jdField_a_of_type_Array2dOfLong[paramInt][this.jdField_a_of_type_Int] = 1L;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == ThreadManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "nextState: " + pyi.jdField_a_of_type_ArrayOfJavaLangString[this.w] + ", " + pyi.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ", " + paramObject);
      }
      if (this.w == 8) {
        return;
      }
      if (this.w != paramInt)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, this.w, paramInt);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
        this.jdField_a_of_type_Pyi = a(paramInt);
        this.w = paramInt;
      }
      for (;;)
      {
        this.jdField_a_of_type_Pyi.a(5, paramObject);
        return;
        if (paramInt == 0) {
          this.jdField_a_of_type_Pyi = a(paramInt);
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getAccount())) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    paramHashMap.put("config", pyg.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.a("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Long == 0L) {}
    long l1;
    int i1;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      i1 = (int)((l1 - this.jdField_a_of_type_Long) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "reportForeground(" + paramBoolean + "):[" + this.jdField_a_of_type_Long + " - " + l1 + " = " + i1 + "]");
      }
      if (i1 > 0)
      {
        Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        localObject = new SimpleDateFormat("yyyyMMdd", Locale.US).format((Date)localObject);
        ReportController.b((QQAppInterface)BaseApplicationImpl.a.a(), "CliOper", "", "", "Online_time", "Fe_time", 0, i1, 0, (String)localObject, "", "", "");
      }
      if (!paramBoolean) {
        break;
      }
    } while (i1 <= 0);
    this.jdField_a_of_type_Long = l1;
    return;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    PreloadProcHitMgr.b(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    Intent localIntent = new Intent("com.tencent.process.exit");
    localIntent.putExtra("exit_type", 101);
    localIntent.putExtra("qq_mode_foreground", paramBoolean);
    localIntent.putStringArrayListExtra("procNameList", localArrayList);
    localIntent.putExtra("verify", BaseApplicationImpl.a(localArrayList, false));
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(BaseApplicationImpl.getContext()) + ", toExitTargetProcess=" + paramString + " isForeground=" + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, String... paramVarArgs)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject = ((ActivityManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        String str1 = localRunningAppProcessInfo.processName;
        if ((str1.startsWith("com.tencent.mobileqq")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF")))
        {
          int i3;
          int i2;
          int i1;
          if (paramVarArgs != null)
          {
            i3 = paramVarArgs.length;
            i2 = 0;
            i1 = 0;
          }
          for (;;)
          {
            if (i2 < i3)
            {
              String str2 = paramVarArgs[i2];
              if ((TextUtils.isEmpty(str2)) || (!str1.endsWith(str2))) {
                break label261;
              }
            }
            label261:
            for (i1 = 1;; i1 = 0)
            {
              if (i1 == 0) {
                break label267;
              }
              localArrayList3.add(str1);
              if (i1 != 0) {
                break;
              }
              if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0)))) {
                break label276;
              }
              localArrayList1.add(str1);
              PreloadProcHitMgr.b(str1);
              if (!str1.endsWith(":qzone")) {
                break;
              }
              StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
              break;
            }
            label267:
            i2 += 1;
          }
          label276:
          localArrayList2.add(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(BaseApplicationImpl.getContext()) + ", toExitProcess=" + localArrayList1 + ", forgroundProcess=" + localArrayList2 + ", exceptions:" + localArrayList3);
    }
    if (localArrayList1.size() > 0)
    {
      paramVarArgs = new Intent("com.tencent.process.exit");
      paramVarArgs.putExtra("exit_type", 101);
      paramVarArgs.putExtra("qq_mode_foreground", paramBoolean);
      paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
      paramVarArgs.putExtra("verify", BaseApplicationImpl.a(localArrayList1, false));
      this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(paramVarArgs);
    }
  }
  
  public boolean a()
  {
    int i1 = this.w;
    return (i1 == 6) || (i1 == 7) || (i1 == 5);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "enterQQLSActivity");
    }
    this.jdField_b_of_type_Boolean = true;
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = true;
    if ((!bool) && (this.jdField_a_of_type_Boolean))
    {
      Intent localIntent = new Intent("com.tencent.plugin.state.change");
      localIntent.putExtra("key_plugin_state", 1);
      BaseApplicationImpl.a().sendBroadcast(localIntent);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      TrickHelper.a().b();
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void b(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void b(boolean paramBoolean)
  {
    long l1 = MemoryManager.a(Process.myPid());
    a(0);
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i1 < 15)
    {
      i3 = (int)(i3 + this.jdField_a_of_type_Array2dOfLong[1][i1]);
      i2 = (int)(i2 + this.jdField_a_of_type_Array2dOfLong[0][i1]);
      i1 += 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l1 / 1024L));
    localHashMap.put("resumeCount", String.valueOf(i3 * 1.0D / 15.0D));
    localHashMap.put("msgCount", String.valueOf(i2 * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(pyg.a().a(this.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int)));
    if (paramBoolean) {}
    for (String str = "actLiteActive";; str = "actFullActive")
    {
      a(str, localHashMap);
      return;
    }
  }
  
  public boolean b()
  {
    int i1 = this.w;
    return (i1 == 4) || (i1 == 6);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "exitQQLSActivity");
    }
    this.jdField_b_of_type_Boolean = false;
    IntentFilter localIntentFilter;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pyh(this);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      if ((this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void c(boolean paramBoolean)
  {
    pyg localpyg = pyg.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    int i1 = localpyg.jdField_a_of_type_Int;
    long l1 = localpyg.jdField_b_of_type_Int | i1 << 8;
    int i2 = pyg.a().c;
    if (paramBoolean) {}
    for (i1 = 1;; i1 = 0)
    {
      localAppRuntime.onGuardEvent(5, l1, i1 | i2 << 8);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "cancelTimer");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_d_of_type_JavaLangString == null) {
        continue;
      }
      Object localObject1 = (String)paramMessage.obj;
      if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, (CharSequence)localObject1)) {
        continue;
      }
      this.jdField_d_of_type_JavaLangString = null;
      if (Foreground.sCountActivity > 0)
      {
        this.jdField_d_of_type_JavaLangString = "com.tencent.mobileqq";
        return true;
      }
      localObject1 = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningAppProcesses();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if ((((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith("com.tencent.mobileqq")) && (((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (this.jdField_d_of_type_JavaLangString == null))
          {
            this.jdField_d_of_type_JavaLangString = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            if (QLog.isColorLevel()) {
              QLog.d("GuardManager", 2, "GmVersion= 20140619, Fg= " + this.jdField_d_of_type_JavaLangString);
            }
          }
        }
        if (this.jdField_d_of_type_JavaLangString != null) {
          continue;
        }
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
      try
      {
        this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        boolean bool = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = false;
        a(false);
        b(4, paramMessage.obj);
        if ((bool) && (!this.jdField_a_of_type_Boolean))
        {
          paramMessage = new Intent("com.tencent.plugin.state.change");
          paramMessage.putExtra("key_plugin_state", 0);
          BaseApplicationImpl.a().sendBroadcast(paramMessage);
        }
        TrickHelper.a().a();
        jdField_d_of_type_Long = System.currentTimeMillis();
        paramMessage = (QQAppInterface)BaseApplicationImpl.a.a();
        if (!paramMessage.isRunning()) {
          continue;
        }
        paramMessage.a(BaseApplicationImpl.a);
        return true;
        this.jdField_d_of_type_JavaLangString = ((String)paramMessage.obj);
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pyh(this);
          localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
          ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
        }
        try
        {
          this.jdField_a_of_type_AndroidAppApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
          bool = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_Boolean = true;
          localObject1 = (QQAppInterface)BaseApplicationImpl.a.a();
          a((QQAppInterface)localObject1);
          if ((!bool) && (this.jdField_a_of_type_Boolean))
          {
            localObject2 = new Intent("com.tencent.plugin.state.change");
            ((Intent)localObject2).putExtra("key_plugin_state", 1);
            BaseApplicationImpl.a().sendBroadcast((Intent)localObject2);
          }
          if (StartService.jdField_a_of_type_Boolean)
          {
            TrickHelper.a().b();
            MemoryManager.a().a(BaseApplicationImpl.a, (QQAppInterface)localObject1);
          }
          b(3, paramMessage.obj);
          try
          {
            ProcReporter.a().a();
            return true;
          }
          catch (Throwable paramMessage)
          {
            return true;
          }
          try
          {
            if (((paramMessage.arg2 == 2) || (paramMessage.arg2 == 3)) && ((paramMessage.arg1 == 4) || (paramMessage.arg1 == 5))) {
              BaseApplicationImpl.a.a().onGuardEvent(7, 0L, 0L);
            }
            if (this.jdField_a_of_type_JavaUtilRandom == null) {
              this.jdField_a_of_type_JavaUtilRandom = new Random();
            }
            if (this.jdField_a_of_type_JavaUtilRandom.nextInt(20000) != 0) {
              continue;
            }
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("before", pyi.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg1]);
            ((HashMap)localObject1).put("after", pyi.jdField_a_of_type_ArrayOfJavaLangString[paramMessage.arg2]);
            a("GM_guardChangeS", (HashMap)localObject1);
            return true;
          }
          catch (Throwable paramMessage)
          {
            return true;
          }
          int i1 = paramMessage.arg1;
          if (paramMessage.arg1 < 3) {
            a(i1);
          }
          this.jdField_a_of_type_Pyi.a(i1, paramMessage.obj);
          return true;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 12000L);
          this.jdField_a_of_type_Pyi.a();
          return true;
          if (!b()) {
            continue;
          }
          a(this.w + 1, "trick_p_msg");
          return true;
          a(paramMessage.arg1, paramMessage.obj);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          for (;;) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    long l1;
    try
    {
      paramContext = paramIntent.getAction();
      str = paramIntent.getStringExtra("runningProcessName");
      l1 = paramIntent.getLongExtra("runningtime", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, paramContext + " received with " + str + " at " + l1 + ", when " + this.c + ", " + this.jdField_b_of_type_Long + ", QQLS:" + this.jdField_b_of_type_Boolean);
      }
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      if ("com.tencent.process.stopping".equals(paramContext))
      {
        if ((l1 < this.c) && (l1 >= this.c - 1000000L)) {
          return;
        }
        this.c = l1;
        paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramContext, 50L);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.d("GuardManager", 1, "", paramContext);
      return;
    }
    if (("com.tencent.process.starting".equals(paramContext)) && ((l1 >= this.jdField_b_of_type_Long) || (l1 < this.c - 1000000L)))
    {
      this.jdField_b_of_type_Long = l1;
      paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, str);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\GuardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */