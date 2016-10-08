import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class plu
  extends Handler
{
  public plu(SpecailCareListActivity paramSpecailCareListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.H();
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.H();
      QQToast.a(BaseApplication.getContext(), 1, 2131369008, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131371051);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\plu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */