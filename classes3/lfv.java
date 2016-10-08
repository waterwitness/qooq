import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class lfv
  implements CompoundButton.OnCheckedChangeListener
{
  public lfv(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramCompoundButton = DiscussionInfoCardActivity.a(this.a);
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        QQToast.a(this.a, 2131364258, 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    if ((paramBoolean) && (!this.a.a.hasCollect) && (((DiscussionManager)this.a.app.getManager(52)).a() >= 80))
    {
      paramCompoundButton = DiscussionInfoCardActivity.a(this.a);
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        QQToast.a(this.a, this.a.getString(2131364259, new Object[] { String.valueOf(80) }), 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (!this.a.a.hasCollect))
    {
      DiscussionInfoCardActivity.a(this.a).e(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue());
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label350;
      }
      paramCompoundButton = "1";
      label215:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800629C", "0X800629C", 0, 0, paramCompoundButton, "", "", "");
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label356;
      }
    }
    label350:
    label356:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006678", "0X8006678", 0, 0, paramCompoundButton, "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006667", "0X8006667", 0, 0, "", "", "", "");
      return;
      if ((paramBoolean) || (!this.a.a.hasCollect)) {
        break;
      }
      DiscussionInfoCardActivity.a(this.a).f(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue());
      break;
      paramCompoundButton = "0";
      break label215;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */