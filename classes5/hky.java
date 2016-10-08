import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hky
  implements Runnable
{
  public hky(EqqAccountDetailActivity paramEqqAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "updateFollowInfo");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      EqqAccountDetailActivity.b(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.a.c();
      EnterpriseQQManager.a(EqqAccountDetailActivity.g(this.a)).a(EqqAccountDetailActivity.f(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
      if (EqqAccountDetailActivity.a(this.a) != null) {
        break label130;
      }
    }
    for (;;)
    {
      if (i != 0) {
        EqqAccountDetailActivity.b(this.a, new hkz(this));
      }
      return;
      label130:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */