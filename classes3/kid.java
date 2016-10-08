import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class kid
  implements Runnable
{
  public kid(AddFriendLogicActivity paramAddFriendLogicActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a = true;
    AddFriendLogicActivity.a(this.a).hide();
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */