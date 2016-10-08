import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class mtg
  implements Runnable
{
  mtg(mtf parammtf, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Mtf.a.isFinishing()) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_Mtf.a.a, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_Mtf.a.app.a());
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Mtf.a.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, url:" + this.jdField_a_of_type_JavaLangString);
    }
    ReportController.b(this.jdField_a_of_type_Mtf.a.app, "CliOper", "", "", "vip", "logo_in", 24, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */