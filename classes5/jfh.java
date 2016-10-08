import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jfh
  implements PopupWindow.OnDismissListener
{
  public jfh(CustomMenuBar paramCustomMenuBar, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = true;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */