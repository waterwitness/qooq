import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class skc
  implements ActionSheet.OnButtonClickListener
{
  public skc(QfileEditBottomBar paramQfileEditBottomBar, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).a().a(false);
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).h();
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).d(FMDataCache.c());
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).e(FMDataCache.b());
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).f(FMDataCache.e());
    FMDataCache.b();
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).e(false);
    QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).b();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\skc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */