import android.app.Activity;
import android.os.Handler;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class wli
  implements ActionMode.Callback
{
  public wli(ContainerView.SelectableTextView paramSelectableTextView, ContainerView paramContainerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMenuItem.getItemId() == 2131305400)
    {
      paramActionMode = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getContext();
      bool1 = bool2;
      if (paramActionMode != null)
      {
        bool1 = bool2;
        if ((paramActionMode instanceof TextPreviewActivity))
        {
          paramMenuItem = (TextPreviewActivity)paramActionMode;
          CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getText().subSequence(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getSelectionStart(), this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getSelectionEnd());
          if (localCharSequence != null) {
            TextPreviewActivity.a(localCharSequence.toString(), (Activity)paramActionMode, paramMenuItem.app, paramMenuItem.l, paramMenuItem.c, TextPreviewActivity.b, false);
          }
          ReportController.b(paramMenuItem.app, "CliOper", "", "", "0X8004065", "0X8004065", 0, 0, "", "", "", "");
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131689472, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a.sendEmptyMessageDelayed(100, 10L);
    }
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */