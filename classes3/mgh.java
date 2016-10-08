import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class mgh
  implements ActionSheet.OnButtonClickListener
{
  public mgh(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.showDialog(1);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actCleanCacheData", true, 0L, 0L, null, null);
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity, WebProcessReceiver.class);
    paramView.setAction("action_clear_cache");
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.sendBroadcast(paramView, "com.tencent.msg.permission.pushnotify");
    paramView = new mgi(this);
    ThreadManager.b().post(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */