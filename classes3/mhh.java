import com.tencent.mobileqq.activity.QZoneDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.DiscoverTab;

public class mhh
  implements Runnable
{
  public mhh(QZoneDiscoverActivity paramQZoneDiscoverActivity, DiscoverTab paramDiscoverTab)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_CooperationQzoneModelDiscoverTab.a == null)
    {
      QZoneDiscoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneDiscoverActivity, this.jdField_a_of_type_CooperationQzoneModelDiscoverTab);
      return;
    }
    QZoneDiscoverActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneDiscoverActivity, this.jdField_a_of_type_CooperationQzoneModelDiscoverTab);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */