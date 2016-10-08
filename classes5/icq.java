import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class icq
  implements Runnable
{
  public icq(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, String paramString, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PublicAccountManager.a().a(ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter), this.jdField_a_of_type_JavaLangString);
    Object localObject = (PublicAccountDataManager)ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).getManager(55);
    if (localObject != null)
    {
      ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).a().createEntityManager();
        ((EntityManager)localObject).b(localAccountDetail);
        ((EntityManager)localObject).a();
      }
    }
    ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).a().a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b, 1008);
    RecentUtil.b(ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */