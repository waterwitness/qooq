import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class igg
  implements Runnable
{
  igg(igf paramigf, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AccountDetail localAccountDetail = new AccountDetail(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    Object localObject = this.jdField_a_of_type_Igf.a.a(this.jdField_a_of_type_Igf.a.getAccount()).createEntityManager();
    if (localObject != null) {
      ((EntityManager)localObject).b(localAccountDetail);
    }
    if ((this.jdField_a_of_type_Igf.a instanceof QQAppInterface))
    {
      localObject = (PublicAccountHandler)((QQAppInterface)this.jdField_a_of_type_Igf.a).a(11);
      if (localObject != null) {
        ((PublicAccountHandler)localObject).a(localAccountDetail);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */