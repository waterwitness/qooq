import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class tzw
  implements ActionSheet.OnDismissListener
{
  public tzw(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8005AFA", "0X8005AFA", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */