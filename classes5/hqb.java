import com.tencent.biz.pubaccount.PublicAccountManageAdapter;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class hqb
  implements Runnable
{
  public hqb(PublicAccountManageAdapter paramPublicAccountManageAdapter, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PublicAccountManager.a().a(PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter), this.jdField_a_of_type_JavaLangString);
    Object localObject = (PublicAccountDataManager)PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter).getManager(55);
    if (localObject != null)
    {
      ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter).a().createEntityManager();
        ((EntityManager)localObject).b(localAccountDetail);
        ((EntityManager)localObject).a();
      }
    }
    PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter).a().a(this.jdField_a_of_type_JavaLangString, 1008);
    RecentUtil.b(PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */