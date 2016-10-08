import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class sti
  implements View.OnClickListener
{
  sti(stg paramstg, Dialog paramDialog, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_Stg.a.b();
    this.jdField_a_of_type_Stg.a.jdField_a_of_type_AndroidAppDialog.show();
    ((HotChatHandler)this.jdField_a_of_type_Stg.a.app.a(35)).a(this.jdField_a_of_type_Stg.a.b, this.jdField_a_of_type_Stg.a.c, this.jdField_a_of_type_JavaLangString, this.b);
    ReportController.b(this.jdField_a_of_type_Stg.a.app, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */