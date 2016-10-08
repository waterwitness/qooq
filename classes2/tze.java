import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class tze
  implements ActionSheet.OnDismissListener
{
  public tze(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004E70", "0X8004E70", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */