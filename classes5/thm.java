import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public final class thm
  implements Runnable
{
  public thm(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a(this.a.a(), 200, true);
    long l1 = ((Long)NearbySPUtil.a(this.a.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
    long l2 = l1;
    EntityManager localEntityManager;
    if (l1 == 0L)
    {
      localEntityManager = this.a.a(this.a.getAccount()).createEntityManager();
      l2 = l1;
      if (localEntityManager != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.a() });
        if (localNearbyPeopleCard == null) {
          break label141;
        }
        l1 = localNearbyPeopleCard.tinyId;
      }
    }
    label141:
    for (;;)
    {
      localEntityManager.a();
      l2 = l1;
      if (l2 != 0L) {
        this.a.a(String.valueOf(l2), 202, true);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */