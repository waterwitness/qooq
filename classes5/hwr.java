import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import cooperation.readinjoy.ReadInJoyHelper;

public class hwr
  implements PopupMenuDialog.OnClickActionListener
{
  public hwr(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, KandianMergeManager paramKandianMergeManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d()) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(bool1);
        if (!bool1) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getResources().getString(2131362979), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
        ReportController.b(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", ReadInJoyUtils.c());
        return;
        bool1 = false;
      }
      ReportController.b(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", ReadInJoyUtils.c());
      return;
    case 1: 
      paramMenuItem = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity, ReadInJoySettingActivity.class);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.startActivity(paramMenuItem);
      ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ReadInJoyUtils.c());
      return;
    }
    paramMenuItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime();
    if (!ReadInJoyHelper.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime())) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ReadInJoyHelper.c(paramMenuItem, bool1);
      ReadInJoyLogicEngineEventDispatcher.a().b();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */