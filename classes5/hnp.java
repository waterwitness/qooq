import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel.InfoUpdateListener;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class hnp
  implements FriendProfileImageModel.InfoUpdateListener
{
  WeakReference a;
  
  public hnp(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  public void a() {}
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return;
    }
    ((AccountDetailActivity)this.a.get()).a(paramProfileImageInfo);
    ((AccountDetailActivity)this.a.get()).R();
  }
  
  public void b() {}
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDownloadFail: ");
      if (paramProfileImageInfo == null) {
        break label43;
      }
    }
    label43:
    for (paramProfileImageInfo = paramProfileImageInfo.e;; paramProfileImageInfo = "null")
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, paramProfileImageInfo);
      return;
    }
  }
  
  public void c() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */