import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class ntz
  extends Handler
{
  public ntz()
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
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "self-destory BOOM!!!!");
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */