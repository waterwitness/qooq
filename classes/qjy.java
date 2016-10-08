import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qjy
  extends Handler
{
  public qjy(RegisterProxy paramRegisterProxy, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    RegisterProxy.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */