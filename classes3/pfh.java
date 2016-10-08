import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pfh
  extends Handler
{
  public pfh(FriendListInnerFrame paramFriendListInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a.setPadding(0, 0, 40, 0);
      return;
    }
    this.a.a.setPadding(0, 0, 0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */