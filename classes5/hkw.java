import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hkw
  implements Runnable
{
  public hkw(EqqAccountDetailActivity paramEqqAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailInSubThread");
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */