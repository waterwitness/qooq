import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;

public class vsy
  extends Handler
{
  public vsy(MediaControllerX paramMediaControllerX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return;
      this.a.c();
      return;
      i = MediaControllerX.a(this.a);
    } while ((MediaControllerX.b(this.a)) || (!MediaControllerX.a(this.a)) || (!MediaControllerX.a(this.a).a()));
    sendMessageDelayed(obtainMessage(2), 1000 - i % 1000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */