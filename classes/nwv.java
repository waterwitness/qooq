import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class nwv
  implements ActionSheet.OnDismissListener
{
  nwv(nwu paramnwu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    ReportController.b(this.a.a.a, "CliOper", "", "", "0X8004862", "0X8004862", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */