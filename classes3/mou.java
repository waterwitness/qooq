import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class mou
  extends Handler
{
  public mou(ThemeNoviceGuideActivity paramThemeNoviceGuideActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = this.a.findViewById(2131305116);
    if (paramMessage != null) {
      paramMessage.setBackgroundResource(2130843426);
    }
    ReportController.b(this.a.app, "CliOper", "", this.a.app.a(), "theme_mall", "theme_popup", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */