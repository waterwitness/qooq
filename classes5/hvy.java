import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyBaseRNView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class hvy
  extends BundleListener
{
  public hvy(ReadInjoyBaseRNView paramReadInjoyBaseRNView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadFail(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyBaseRNView.TAG, 2, "BundleListener onLoadFail");
    }
    ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "2", "1", "BundleFacade.loadBundle", "");
    ReportController.b(null, "CliOper", "", "", "0X800713A", "0X800713A", 0, 0, "2", "1", "BundleFacade.loadBundle", Long.toString(System.currentTimeMillis() - ReadInjoyBaseRNView.access$000(this.a)));
  }
  
  public void onLoadSuccess(String paramString, Bundle paramBundle)
  {
    super.onLoadSuccess(paramString, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyBaseRNView.TAG, 2, "BundleListener onLoadSuccess");
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyBaseRNView.TAG, 2, "BundleListener onLoadSuccess :" + (System.currentTimeMillis() - ReadInjoyBaseRNView.access$000(this.a)));
    }
    ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "2", "0", "BundleFacade.loadBundle", "");
    ReportController.b(null, "CliOper", "", "", "0X800713A", "0X800713A", 0, 0, "2", "0", "BundleFacade.loadBundle", Long.toString(System.currentTimeMillis() - ReadInjoyBaseRNView.access$000(this.a)));
    UiThreadUtil.runOnUiThread(new hvz(this, paramBundle));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */