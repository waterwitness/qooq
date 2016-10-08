import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ViewUtils;

public class orm
  implements Runnable
{
  public orm(PhotoListActivity paramPhotoListActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidWidgetTextView.getPaint();
    int i = ViewUtils.a((Paint)localObject, "《");
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidViewView.getLeft();
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.d.getRight();
    localObject = ViewUtils.a((Paint)localObject, this.jdField_a_of_type_JavaLangString, j - k - i * 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidWidgetTextView.setText("《" + (String)localObject + "》");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */