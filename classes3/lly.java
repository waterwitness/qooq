import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

public class lly
  implements WebProcessManager.WebProcessStartListener
{
  public lly(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FriendProfileCardActivity.a(this.a).a();
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web process!");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */