import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class oiv
  extends Handler
{
  private WeakReference a;
  
  public oiv(NewFriendActivity paramNewFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramNewFriendActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NewFriendActivity localNewFriendActivity = (NewFriendActivity)this.a.get();
    if (localNewFriendActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      localNewFriendActivity.a(paramMessage.arg1);
      return;
    }
    localNewFriendActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */