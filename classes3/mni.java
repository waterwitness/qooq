import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class mni
  implements View.OnClickListener
{
  public mni(SubAccountMessageActivity paramSubAccountMessageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.app.a().c(SubAccountMessageActivity.a(this.a).subuin, 7000);
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {}
    do
    {
      return;
      paramView = "";
      if (SubAccountMessageActivity.a(this.a) != null) {
        paramView = SubAccountMessageActivity.a(this.a).subuin;
      }
      ReportController.b(this.a.app, "CliOper", "", paramView, "Bind_account", "Clk_readmsg", 0, 0, "", "", "", "");
    } while (!this.a.b());
    this.a.a(0);
    if (SubAccountMessageActivity.a(this.a))
    {
      ((MessageHandler)this.a.app.a(0)).a().a(SubAccountMessageActivity.a(this.a).subuin, "sub.account.switchAccount");
      return;
    }
    SubAccountMessageActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */