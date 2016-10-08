import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Queue;

public class qgj
  extends Handler
{
  public qgj(StartAppCheckHandler paramStartAppCheckHandler, Looper paramLooper)
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
    paramMessage = (qgm)paramMessage.obj;
    this.a.a.remove(paramMessage);
    paramMessage.jdField_a_of_type_AndroidContentContext.startActivity(paramMessage.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */