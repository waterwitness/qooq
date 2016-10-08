import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.huangye.QQYPQRCodePreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class hiq
  extends BroadcastReceiver
{
  private hiq(QQYPQRCodePreviewActivity paramQQYPQRCodePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (paramContext.length() == 0)) {}
    int i;
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("uin");
        if ((paramIntent != null) && (paramIntent.equals(this.a.c))) {}
        for (i = 1; paramContext.equals("com.tencent.mobile.qq.action.hycontroluiready"); i = 0)
        {
          if ((i != 0) && (this.a.a != null) && (this.a.a.isShowing())) {
            this.a.a.dismiss();
          }
          QQYPQRCodePreviewActivity.a(this.a);
          ReportController.b(null, "CliOper", "", "", "0X8005F20", "0X8005F20", 0, 0, "", "", "", "");
          return;
        }
        if (!paramContext.equals("com.tencent.mobile.qq.action.voicecall.failed")) {
          break;
        }
      } while ((i == 0) || (this.a.a == null) || (!this.a.a.isShowing()));
      this.a.a.dismiss();
      return;
    } while ((!paramContext.equals("tencent.video.v2q.ypc2b.failEnter.asIsInviting")) || (i == 0));
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    this.a.a("通话异常，请稍后再试。");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hiq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */