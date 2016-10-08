import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ArcImageView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class wks
  implements Runnable
{
  public wks(ArcImageView paramArcImageView, AppInterface paramAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = SharedPreUtils.f(localMobileQQ);
    if (SharedPreUtils.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), i, this.jdField_a_of_type_JavaLangString))
    {
      SharedPreUtils.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), i, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, this.jdField_a_of_type_JavaLangString + " close redDot");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */