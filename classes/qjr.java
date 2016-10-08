import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

public class qjr
  extends MessageObserver
{
  private qjr(GetTroopAssisMsg paramGetTroopAssisMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    if (paramLong2 == 1L) {
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label95;
      }
    }
    label95:
    for (int i = 1; i == 0; i = 0)
    {
      this.a.a(6);
      return;
    }
    this.a.a(7);
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on GetTroopMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().h();
    this.a.a(7);
  }
  
  protected void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    if (!paramBoolean) {
      this.a.a(6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */