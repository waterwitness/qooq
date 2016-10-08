import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oup
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public oup(QzoneHbFragment paramQzoneHbFragment, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getRootView().getHeight() - localRect.bottom;
    int j = QzoneHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment).getScrollY();
    if ((QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment) != null) && (i != 0))
    {
      k = QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment).getBottom();
      i = i + QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment).getMeasuredHeight() - k - j;
      if (i > 0) {
        QzoneHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment).scrollBy(0, i);
      }
      QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment, true);
    }
    while (i != 0)
    {
      int k;
      return;
    }
    QzoneHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment).scrollBy(0, -j);
    QzoneHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */