import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class nzh
  implements Runnable
{
  public nzh(NearbyChatPie paramNearbyChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    if (localNearbyPeopleCard != null) {
      this.a.dR = localNearbyPeopleCard.gender;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */