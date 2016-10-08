import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class miq
  extends MqqHandler
{
  public miq(RegisterPhoneNumActivity paramRegisterPhoneNumActivity)
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
      return;
      this.a.finish();
      return;
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        RegisterPhoneNumActivity.a(this.a, paramMessage);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterPhoneNumActivity", 2, "captcha sig is empty");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\miq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */