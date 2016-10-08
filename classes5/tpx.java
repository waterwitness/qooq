import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyReactBaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class tpx
  implements Runnable
{
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  tpx(NearbyReactBaseActivity paramNearbyReactBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  public void run()
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(NearbyReactBaseActivity.jdField_a_of_type_JavaLangString, "askUserToDownloadSo", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.b) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      tpy localtpy = new tpy(this);
      tpz localtpz = new tpz(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = RNPreDownloadFacade.a(this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity, localtpy, localtpz);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyReactBaseActivity.jdField_a_of_type_Tpx = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */