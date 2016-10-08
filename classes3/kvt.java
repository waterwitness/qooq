import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kvt
  implements View.OnClickListener
{
  public kvt(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.a > 1000L)
    {
      this.a.a = l;
      this.a.a();
      ReportController.b(this.a.app, "CliOper", "", "", "0X800568D", "0X800568D", ChatHistory.a(this.a), 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */