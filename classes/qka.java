import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class qka
  extends AccountObserver
{
  private qka(RegisterPush paramRegisterPush)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, long paramLong, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onlineStatusChanged isSuccess=" + paramBoolean1 + ",curStatus=" + paramStatus.toString() + ",isFriendListChang=" + paramBoolean2 + ",timeStamp=" + paramLong + ",isGatherListChange=" + paramBoolean3);
    }
    if (paramBoolean1)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */