import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kut
  implements View.OnClickListener
{
  public kut(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.g();
    ReportController.b(this.a.app, "CliOper", "", "", "0X800568E", "0X800568E", ChatHistory.a(this.a), 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */