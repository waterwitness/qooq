import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class tmm
  implements Runnable
{
  public tmm(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.a(NearbyProfileDisplayPanel.a(this.a));
      localEntityManager.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */