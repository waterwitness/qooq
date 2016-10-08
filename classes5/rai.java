import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class rai
  implements URLDrawable.URLDrawableListener
{
  public rai(NearbyDataManager paramNearbyDataManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a = true;
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.f = this.jdField_a_of_type_JavaLangString;
    ReportController.b(null, "CliOper", "", "", "0X8005D3A", "0X8005D3A", 2, 0, "", "", NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager).getAccount(), "");
    if (QLog.isColorLevel()) {
      QLog.d("NearbyDataManager", 2, "decodeNearbyPushBanner drawable Load successc, mFindSchoolMatePicMd5 =" + this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.f);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */