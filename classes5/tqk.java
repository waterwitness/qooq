import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemManager;

public class tqk
  extends Handler
{
  private tqk()
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
    ((ItemManager)paramMessage.obj).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */