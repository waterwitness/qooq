import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;

public class qjx
  extends MessageObserver
{
  private qjx(RegisterProxy paramRegisterProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void h()
  {
    long l1;
    long l2;
    Object localObject;
    if ((RegisterProxy.a(this.a) == 2) && (RegisterProxy.c(this.a) == 2))
    {
      l1 = SystemClock.uptimeMillis();
      RegisterProxy.c(this.a).b.a().jdField_c_of_type_Boolean = true;
      RegisterProxy.d(this.a).b.a().a(true);
      if ((BaseApplicationImpl.jdField_a_of_type_Long < 0L) && (BaseApplicationImpl.b < 0L))
      {
        l2 = BaseApplicationImpl.jdField_a_of_type_Long + l1;
        if (!QLog.isColorLevel()) {
          break label381;
        }
        QLog.i("AutoMonitor", 2, "registerB, cost=" + l2);
        StatisticCollector.a(RegisterProxy.e(this.a).b.a()).a(null, "prxyRegisterB", true, l2, 0L, null, null);
      }
      if (BaseApplicationImpl.jdField_c_of_type_Long > 0L)
      {
        l2 = BaseApplicationImpl.jdField_c_of_type_Long;
        if ((!BaseApplicationImpl.jdField_c_of_type_Boolean) || (!BaseApplicationImpl.d)) {
          break label410;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("actLoginType", localObject);
      StatisticCollector.a(RegisterProxy.f(this.a).b.a()).a(null, "prxyRegisterT", true, l1 - l2, 0L, localHashMap, null);
      if (RegisterProxy.g(this.a).jdField_a_of_type_Long > 0L)
      {
        l1 = System.currentTimeMillis() - RegisterProxy.h(this.a).jdField_a_of_type_Long;
        if (NetworkUtil.h(RegisterProxy.i(this.a).b.a()))
        {
          boolean bool = RegisterProxy.j(this.a).jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true);
          localObject = new HashMap();
          ((HashMap)localObject).put("param_isFirstInit", String.valueOf(bool));
          StatisticCollector.a(RegisterProxy.k(this.a).b.a()).a(null, "prxyRegisterM", RegisterProxy.a(this.a), l1, 0L, (HashMap)localObject, null);
          if (QLog.isColorLevel()) {
            QLog.i("AutoMonitor", 2, "machineStartToStopCircle, cost=" + l1 + ", isfirstQQInit=" + bool);
          }
        }
      }
      return;
      label381:
      Log.i("AutoMonitor", "registerB, cost=" + l2);
      break;
      label410:
      if ((BaseApplicationImpl.jdField_c_of_type_Boolean) && (!BaseApplicationImpl.d)) {
        localObject = "2";
      } else if ((!BaseApplicationImpl.jdField_c_of_type_Boolean) && (BaseApplicationImpl.d)) {
        localObject = "3";
      } else {
        localObject = "4";
      }
    }
  }
  
  private void i()
  {
    if (this.a.a()) {
      this.a.a(7);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.d(this.a) + " onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    RegisterProxy localRegisterProxy;
    if (paramLong2 == 0L)
    {
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label218;
      }
      i = 2;
      RegisterProxy.d(localRegisterProxy, i);
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 128L) || (paramLong1 == 64L) || (paramLong1 == 32L)) {
        break label224;
      }
      i = 2;
      label144:
      RegisterProxy.c(localRegisterProxy, i);
      this.a.jdField_c_of_type_Long = paramLong1;
      if (MessageHandler.a)
      {
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label230;
        }
        i = 2;
        label179:
        RegisterProxy.b(localRegisterProxy, i);
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label236;
        }
      }
    }
    label218:
    label224:
    label230:
    label236:
    for (int i = j;; i = 1)
    {
      RegisterProxy.e(localRegisterProxy, i);
      MessageHandler.a = false;
      i();
      return;
      i = 1;
      break;
      i = 1;
      break label144;
      i = 1;
      break label179;
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.c(this.a) + " on GetTroopMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().h();
    paramArrayOfString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.d(paramArrayOfString, i);
      i();
      return;
      i = 1;
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.a(this.a) + " on GetC2CMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().f();
    Object localObject = this.a;
    int i;
    if (paramBoolean)
    {
      i = 2;
      RegisterProxy.b((RegisterProxy)localObject, i);
      localObject = RegisterProxy.a(this.a);
      if (RegisterProxy.a(this.a) != 2) {
        break label115;
      }
    }
    label115:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).d = paramBoolean;
      if (MessageHandler.b) {
        h();
      }
      i();
      return;
      i = 1;
      break;
    }
  }
  
  protected void f(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.a(localRegisterProxy, i);
      if (!paramBoolean) {
        break;
      }
      i();
      return;
      i = 1;
    }
    this.a.a(6);
  }
  
  protected void g(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.b(this.a) + " on GetDiscussionMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().j();
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.c(localRegisterProxy, i);
      i();
      return;
      i = 1;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.e(this.a) + " on GetPAMsg Fin:" + paramBoolean);
    }
    Object localObject = this.a;
    int i;
    if (paramBoolean)
    {
      i = 2;
      RegisterProxy.e((RegisterProxy)localObject, i);
      localObject = RegisterProxy.b(this.a);
      if (RegisterProxy.b(this.a) != 2) {
        break label99;
      }
    }
    label99:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).e = paramBoolean;
      i();
      return;
      i = 1;
      break;
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.f(this.a) + " on GetFirstGroup Fin:" + paramBoolean);
    }
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.f(localRegisterProxy, i);
      h();
      return;
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */