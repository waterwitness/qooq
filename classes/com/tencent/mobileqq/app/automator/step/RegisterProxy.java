package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.Random;
import qjw;
import qjx;
import qjy;

public class RegisterProxy
  extends AsyncStep
{
  private static final long d = 3000L;
  public static final int j = 100;
  public static int k = 0;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  Handler jdField_a_of_type_AndroidOsHandler;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private qjw jdField_a_of_type_Qjw;
  private boolean jdField_a_of_type_Boolean;
  public long c;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  
  public RegisterProxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.b + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new qjy(this, ThreadManager.b());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.b + "[ReSendProxy] RESULT_NET_CONNECT resend request!");
    }
    super.a(4);
  }
  
  private boolean b()
  {
    return (this.p == 2) && (this.q == 2) && (this.r == 2) && (this.s == 2);
  }
  
  private void c()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    long l3;
    HashMap localHashMap;
    String str;
    if ((BaseApplicationImpl.jdField_a_of_type_Long < 0L) && (BaseApplicationImpl.b < 0L))
    {
      MsgAutoMonitorUtil.a().k();
      l2 = l1 + BaseApplicationImpl.jdField_a_of_type_Long;
      l3 = l1 + BaseApplicationImpl.b;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e <= 9) {
          break label477;
        }
        str = ">9";
        label151:
        localHashMap.put("param_FailCount", str);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e <= 0) {
          break label491;
        }
        str = "CLIENT_TIMEOUT";
        label172:
        localHashMap.put("param_FailCode", str);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_c_of_type_Long));
        localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
        if (k != 0) {
          break label497;
        }
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, "actLoginB", true, l2, 0L, localHashMap, null);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, "actLoginR", true, l3, 0L, localHashMap, null);
      }
    }
    else
    {
      label266:
      BaseApplicationImpl.b = 0L;
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      if (BaseApplicationImpl.jdField_c_of_type_Long > 0L)
      {
        l1 -= BaseApplicationImpl.jdField_c_of_type_Long;
        if ((!BaseApplicationImpl.jdField_c_of_type_Boolean) || (!BaseApplicationImpl.d)) {
          break label631;
        }
        str = "1";
        label303:
        Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + str);
        localHashMap = new HashMap();
        localHashMap.put("actLoginType", str);
        if (k != 0) {
          break label676;
        }
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, "actLoginT", true, l1, 0L, localHashMap, null);
      }
    }
    for (;;)
    {
      BaseApplicationImpl.jdField_c_of_type_Long = 0L;
      k = 0;
      return;
      Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      Log.i("AutoMonitor", "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      break;
      label477:
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      break label151;
      label491:
      str = "";
      break label172;
      label497:
      localHashMap.put("param_exceptionReason", String.valueOf(k));
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, "actLoginB_prxyError", true, l2, 0L, localHashMap, null);
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, "actLoginR_prxyError", true, l3, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationB:" + l2 + ", durationR:" + l3 + ",totalFailCount:" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e + ",actBExcetpionReason=" + k);
      break label266;
      label631:
      if ((BaseApplicationImpl.jdField_c_of_type_Boolean) && (!BaseApplicationImpl.d))
      {
        str = "2";
        break label303;
      }
      if ((!BaseApplicationImpl.jdField_c_of_type_Boolean) && (BaseApplicationImpl.d))
      {
        str = "3";
        break label303;
      }
      str = "4";
      break label303;
      label676:
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, "actLoginT_prxyError", true, l1, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationT:" + l1 + ",actLoginType:" + str + ",actBExcetpionReason=" + k);
    }
  }
  
  protected int a()
  {
    boolean bool2 = true;
    long l1 = System.currentTimeMillis();
    Object localObject;
    int i;
    long l2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a();
      if (this.h == 18)
      {
        i = 2;
        ((MessageHandler)localObject).a(i);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      l2 = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
      if (this.h != 18) {
        break label253;
      }
      MessageHandler.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a(2, true, l2, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doStep , mStepId = ").append(this.h).append(" , isGetPassword = ");
        if (this.h != 17) {
          break label342;
        }
      }
    }
    label253:
    label342:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("RegisterProxy", 2, bool1 + " ,isUseNewRegisterProxy = " + MessageHandler.b);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      if (QLog.isColorLevel()) {
        QLog.i("AutoMonitor", 2, "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      }
      return 2;
      i = 1;
      break;
      if (MessageHandler.b)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a();
        if (this.h == 17) {}
        for (bool1 = true;; bool1 = false)
        {
          ((MessageHandler)localObject).a(1, l2, bool1);
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a();
      if (this.h == 17) {}
      for (bool1 = true;; bool1 = false)
      {
        ((MessageHandler)localObject).a(1, true, l2, bool1);
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new qjx(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_Qjw = new qjw(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_Qjw);
    }
    if ((this.h == 17) || (this.h == 19)) {
      MsgAutoMonitorUtil.a().a(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.i = 3;
    this.jdField_a_of_type_Boolean = false;
    MessageHandler.b = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d())
    {
      if (paramInt != 4) {
        break label26;
      }
      a(true);
    }
    for (;;)
    {
      super.a(paramInt);
      return;
      label26:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
    }
  }
  
  public boolean a()
  {
    return ((this.o == 2) || (this.o == 1)) && ((this.p == 2) || (this.p == 1)) && ((this.s == 2) || (this.s == 1)) && ((this.q == 2) || (this.q == 1)) && ((this.r == 2) || (this.r == 1));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_Qjw);
      this.jdField_a_of_type_Qjw = null;
    }
    MsgAutoMonitorUtil.a().b(Thread.currentThread().getThreadGroup().activeCount());
    c();
    if (this.h == 17)
    {
      AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
      AIOPreLoadEngine.a().a(BaseActivity.sTopActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a(b());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l1);
      if (NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label351;
        }
        localObject = "actSyncMsgFirst";
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFirstQQInit", false).commit();
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a()).a(null, (String)localObject, b(), l1, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().b()) {}
    for (int i = 2;; i = 1)
    {
      ((Automator)localObject).d = i;
      if (ReadInJoyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b))
      {
        localObject = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(162);
        if (localObject != null) {
          ((ReadInJoyLogicManager)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getLongAccountUin());
        }
      }
      return;
      label351:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\RegisterProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */