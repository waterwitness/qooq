import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rnd
  implements View.OnClickListener
{
  public rnd(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.f())
    {
      FMDataCache.b();
      this.a.e(false);
      if (this.a.c())
      {
        this.a.setResult(5);
        this.a.finish();
        return;
      }
      this.a.rightViewText.setVisibility(0);
      this.a.rightViewText.setText(2131362718);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      this.a.setTitle(this.a.b);
      this.a.b();
      this.a.a();
      if (this.a.jdField_a_of_type_Int == 1) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.a.b(false);
      return;
    }
    if (BaseFileAssistantActivity.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      BaseFileAssistantActivity.a(this.a).g();
    }
    FMDataCache.b();
    this.a.e(true);
    this.a.rightViewText.setVisibility(0);
    this.a.rightViewText.setText(2131362754);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
    this.a.b();
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.b(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */