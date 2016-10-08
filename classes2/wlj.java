import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;
import com.tencent.qphone.base.util.QLog;

public class wlj
  implements View.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  
  public wlj(ContainerView.SelectableTextView paramSelectableTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "popupClickListener";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131305407) {}
    try
    {
      ((ClipboardManager)ContainerView.SelectableTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView).getSystemService("clipboard")).setText(ContainerView.SelectableTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView).getText());
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getContext(), "已经复制到剪贴板", 0).show();
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, paramView.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */