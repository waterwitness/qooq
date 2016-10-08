import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class sdz
  implements View.OnClickListener
{
  public sdz(BaseActionBar paramBaseActionBar, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a.dismiss();
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BaseActionBar", 1, paramView.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */