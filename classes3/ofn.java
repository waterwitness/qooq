import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ofn
  extends MessageObserver
{
  public ofn(BlessBaseActivity paramBlessBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessManager.a, 2, "onSendBlessMsgResp " + paramBoolean);
    }
    this.a.B();
    if (!this.a.b) {
      return;
    }
    this.a.b = false;
    if (paramInt == 67L)
    {
      this.a.f = System.currentTimeMillis();
      this.a.b(paramLong);
      QQToast.a(this.a.app.a(), 2131372386, 1).a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(BlessManager.a, 2, "onSendBlessMsgResp failed:" + paramInt + " waitTime=" + paramLong);
      }
      this.a.c(paramBoolean);
      return;
      if (!paramBoolean) {
        QQToast.a(this.a.app.a(), 2131372387, 1).a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */