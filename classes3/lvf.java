import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lvf
  extends Handler
{
  public lvf(ModifyFriendInfoActivity paramModifyFriendInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while ((this.a.c == null) || (this.a.c.length() <= 0));
      this.a.b.setText(this.a.c);
      return;
    }
    this.a.a.setText(this.a.d);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */