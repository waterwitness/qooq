import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessSendTextActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class oga
  extends MessageObserver
{
  public oga(BlessSendTextActivity paramBlessSendTextActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d(BlessManager.a, 2, "onBlessDirtyTextCheck " + paramBoolean + " code=" + paramInt);
    }
    if (paramBoolean) {}
    while (i != 0) {
      if ((this.a.s == null) || (this.a.s.equals("")) || (this.a.t == null) || (this.a.t.equals("")))
      {
        BlessSendTextActivity.a(this.a, false);
        return;
        if (paramInt != 0) {
          if (paramInt == 1)
          {
            QQToast.a(this.a, 2131372383, 1).a();
            i = 0;
          }
          else
          {
            if (paramInt == 8) {
              QQToast.a(this.a, 2131372384, 1).a();
            }
            i = 0;
          }
        }
      }
      else
      {
        this.a.a(this.a.s);
        this.a.B();
        return;
      }
    }
    this.a.B();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */