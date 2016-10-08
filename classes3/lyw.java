import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQBrowserLinkSpan;

public class lyw
  extends QQBrowserLinkSpan
{
  public lyw(PermisionPrivacyActivity paramPermisionPrivacyActivity, Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004E73", "0X8004E73", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */