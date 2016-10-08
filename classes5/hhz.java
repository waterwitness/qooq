import android.os.Handler;
import android.os.Message;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hhz
  extends Handler
{
  public hhz(SensorAPIJavaScript paramSensorAPIJavaScript)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      SensorAPIJavaScript.a(this.a, (String)paramMessage.obj);
    }
    while (paramMessage.what != 291) {
      return;
    }
    this.a.a((String)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */