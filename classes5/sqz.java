import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsPublisher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class sqz
  implements Runnable
{
  sqz(sqy paramsqy, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).a(FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).getAccount()).createEntityManager();
    localEntityManager.a(FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a));
    if (this.jdField_a_of_type_Boolean)
    {
      FreshNewsInfo localFreshNewsInfo = new FreshNewsInfo();
      localFreshNewsInfo.whichPage = 3;
      localFreshNewsInfo.feedId = FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).feedId;
      localFreshNewsInfo.publishTime = FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).publishTime;
      localFreshNewsInfo.feedType = FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).feedType;
      localFreshNewsInfo.feedContent = FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).feedContent;
      localFreshNewsInfo.topicInfo = FreshNewsPublisher.a(this.jdField_a_of_type_Sqy.a).topicInfo;
      localEntityManager.a(localFreshNewsInfo);
    }
    localEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */