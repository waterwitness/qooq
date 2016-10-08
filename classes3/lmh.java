import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.QQToast;

public class lmh
  extends ContactBindObserver
{
  public lmh(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a.v();
    if (paramBoolean) {
      return;
    }
    QQToast.a(this.a, 1, "当前网络不可用", 1000).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */