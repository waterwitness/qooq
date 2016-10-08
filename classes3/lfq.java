import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class lfq
  implements DialogInterface.OnClickListener
{
  public lfq(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.a.getActivity()))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006669", "0X8006669", 0, 0, "", "", "", "");
      DiscussionInfoCardActivity.a(this.a).d(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue());
      this.a.a(this.a.getString(2131369494));
      DiscussionInfoCardActivity.a(this.a).show();
      return;
    }
    this.a.a(1, this.a.getString(2131368805));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */