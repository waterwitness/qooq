import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.StringUtil;

public final class vyv
  implements Runnable
{
  public vyv(QQAppInterface paramQQAppInterface, long paramLong, String paramString, NearbyCardHandler paramNearbyCardHandler, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject1;
    long l;
    if (localEntityManager != null) {
      if (this.jdField_a_of_type_Long > 0L)
      {
        localObject1 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (!StringUtil.b(this.jdField_a_of_type_JavaLangString)) {
            localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_JavaLangString });
          }
        }
        if (localObject2 != null)
        {
          localObject1 = ((NearbyPeopleCard)localObject2).vSeed;
          l = ((NearbyPeopleCard)localObject2).feedPreviewTime;
          label106:
          localEntityManager.a();
        }
      }
    }
    for (;;)
    {
      NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte[])localObject1, l, false, 0L);
      return;
      localObject1 = null;
      l = 0L;
      break label106;
      localObject1 = null;
      break;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */