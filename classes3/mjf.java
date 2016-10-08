import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;

public class mjf
  extends MqqHandler
{
  public mjf(RegisterSendUpSms paramRegisterSendUpSms)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        RegisterSendUpSms.a(this.a, false);
        RegisterSendUpSms.a(this.a).removeMessages(1);
        RegisterSendUpSms.a(this.a).setEnabled(true);
        RegisterSendUpSms.a(this.a).setVisibility(8);
        RegisterSendUpSms.a(this.a).setVisibility(0);
        paramMessage = this.a.getString(2131368530);
      } while (TextUtils.isEmpty(paramMessage));
      RegisterSendUpSms.a(this.a).setText(paramMessage);
      return;
      paramMessage = (AccountManager)this.a.app.getManager(0);
    } while (paramMessage == null);
    paramMessage.queryUpSmsStat(RegisterSendUpSms.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */