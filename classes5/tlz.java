import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

public class tlz
  implements Runnable
{
  public tlz(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!StringUtil.b(NearbyPeopleProfileActivity.a(this.a).uin)) {
      this.a.app.a(NearbyPeopleProfileActivity.a(this.a).uin, 200, false);
    }
    if (this.a.b > 0L) {
      this.a.app.a(String.valueOf(this.a.b), 202, false);
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
      } while (StringUtil.b(NearbyPeopleProfileActivity.a(this.a).uin));
      localEntityManager = this.a.app.a().createEntityManager();
    } while (localEntityManager == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.a).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.a.app.a(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
    }
    localEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */