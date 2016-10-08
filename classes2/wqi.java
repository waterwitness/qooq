import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class wqi
  extends OpenIdObserver
{
  public wqi(BindGroupActivity paramBindGroupActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID.toString());
    }
    if ((this.a.isFinishing()) || (this.a.c)) {}
    do
    {
      return;
      this.a.b.hide();
      if (this.a.a != null) {
        this.a.a.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "openIdObserver success");
        }
        this.a.f = paramOpenID.openID;
        if (!paramOpenID.openID.equals(this.a.e))
        {
          this.a.b();
          return;
        }
        this.a.a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupActivity", 2, "openIdObserver fail");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */