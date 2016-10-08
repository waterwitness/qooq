import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mbx
  extends Handler
{
  public mbx(QQBroadcastActivity paramQQBroadcastActivity)
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
    } while (this.a.a == null);
    this.a.a.changeCursor(this.a.a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */