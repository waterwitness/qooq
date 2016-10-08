import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public class wba
  extends FriendListObserver
{
  private final JumpAction b;
  
  public wba(JumpAction paramJumpAction1, JumpAction paramJumpAction2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramJumpAction2;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (JumpAction.a(this.a) == null) || (!JumpAction.a(this.a).containsKey(paramString))) {}
    do
    {
      return;
      JumpAction.a(this.a).remove(paramString);
      if (JumpAction.a(this.a).size() == 0) {
        JumpAction.a(this.a).b(JumpAction.a(this.a));
      }
      Object localObject = Uri.parse(JumpAction.a(this.a) + "&uin=" + paramString);
      localObject = new Intent(this.b.fz, (Uri)localObject);
      this.a.a.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + this.b.fz);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */