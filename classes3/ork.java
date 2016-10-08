import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ork
  implements Runnable
{
  final boolean jdField_a_of_type_Boolean;
  
  public ork(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.w) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.runOnUiThread(new orl(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */