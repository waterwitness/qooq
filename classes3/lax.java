import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class lax
  implements View.OnClickListener
{
  public lax(ChatTextSizeSettingActivity paramChatTextSizeSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.e = 0;
    }
    for (;;)
    {
      this.a.a(this.a.e);
      ReportController.b(this.a.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(this.a.e), "", "", "");
      return;
      this.a.e = 1;
      continue;
      this.a.e = 2;
      continue;
      this.a.e = 3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */