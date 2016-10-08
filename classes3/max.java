import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class max
  implements View.OnClickListener
{
  public max(ProfileLabelEditorActivity paramProfileLabelEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent().getStringExtra("uin");
    if ((paramView != null) && (paramView.equals(this.a.app.a())))
    {
      ProfileLabelEditorActivity.a(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "4", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\max.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */