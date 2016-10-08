import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ViewUtils;

public class nve
  implements Runnable
{
  public nve(PhotoListPanel paramPhotoListPanel, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).getPaint();
    int i = ViewUtils.a((Paint)localObject, "《");
    int j = PhotoListPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).getLeft();
    int k = PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).getRight();
    localObject = ViewUtils.a((Paint)localObject, this.jdField_a_of_type_JavaLangString, j - k - i * 2);
    PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).setText("《" + (String)localObject + "》");
    PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */