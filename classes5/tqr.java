import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.ranking.ShowLoveEditorActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class tqr
  implements View.OnTouchListener
{
  public tqr(ShowLoveEditorActivity paramShowLoveEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005294", "0X8005294", 0, 0, "", "", "", "");
      DatingUtil.c("edit", new Object[] { "on touch edittext" });
      this.a.b = true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */