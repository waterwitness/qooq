import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class klq
  extends Handler
{
  public klq(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.d();
    String str = paramMessage.obj.toString();
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131369039);
    }
    this.a.a(paramMessage, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */