import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.ProfileCardTemplate;

public class llk
  implements Runnable
{
  public llk(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = ((FriendsManager)this.a.app.getManager(50)).a(this.a.app.a());
    if (localObject == null) {
      this.a.h = "-1";
    }
    for (;;)
    {
      this.a.h = "-1";
      return;
      if (((Card)localObject).lCurrentStyleId == ProfileCardTemplate.a)
      {
        localObject = (QZoneCover)this.a.app.a().createEntityManager().a(QZoneCover.class, this.a.app.a());
        if (localObject != null) {
          this.a.h = ((QZoneCover)localObject).type;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */