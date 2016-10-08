import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class lfp
  implements CompoundButton.OnCheckedChangeListener
{
  public lfp(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a), this.a.app.a());
    int i = paramCompoundButton.flag;
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      paramCompoundButton.flag = ((byte)(paramCompoundButton.flag | 0x1));
      if (i != paramCompoundButton.flag)
      {
        byte b = (byte)(paramCompoundButton.flag & 0x1);
        DiscussionInfoCardActivity.a(this.a).a(paramCompoundButton);
        if (QLog.isDevelopLevel()) {
          QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag changed save now:" + paramCompoundButton.flag + " flag:" + b);
        }
        DiscussionInfoCardActivity.a(this.a).a(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue(), b);
      }
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label270;
      }
      paramCompoundButton = "1";
      label160:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800629B", "0X800629B", 0, 0, paramCompoundButton, "", "", "");
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label276;
      }
    }
    label270:
    label276:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006679", "0X8006679", 0, 0, paramCompoundButton, "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006668", "0X8006668", 0, 0, "", "", "", "");
      return;
      paramCompoundButton.flag = ((byte)(paramCompoundButton.flag & 0xFFFFFFFE));
      break;
      paramCompoundButton = "0";
      break label160;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */