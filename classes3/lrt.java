import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class lrt
  extends MqqHandler
{
  public lrt(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.a != null) && ("0".equals(this.a.a.a()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1134006: 
      this.a.a();
      return;
    case 11340002: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
      }
      this.a.k();
      return;
    }
    Leba.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */