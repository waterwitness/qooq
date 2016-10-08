import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kqo
  extends Handler
{
  public kqo(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        return;
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
      } while (!QLog.isColorLevel());
      QLog.i("BlessPTVActivity", 2, "ret is " + i);
      QLog.i("BlessPTVActivity", 2, "data is " + paramMessage);
      return;
    }
    int i = paramMessage.arg1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */