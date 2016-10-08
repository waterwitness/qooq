import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.manager.BitAppInstanceManager.LoadBundleCallBack;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyBaseRNView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class hwa
  implements BitAppInstanceManager.LoadBundleCallBack
{
  hwa(hvz paramhvz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void callBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyBaseRNView.TAG, 2, "LoadBundleCallBack callBack mKey" + this.a.jdField_a_of_type_Hvy.a.mKey);
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyBaseRNView.TAG, 2, "LoadBundleCallBack callBack :" + (System.currentTimeMillis() - ReadInjoyBaseRNView.access$000(this.a.jdField_a_of_type_Hvy.a)));
    }
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null)
    {
      this.a.jdField_a_of_type_Hvy.a.mBundle = this.a.jdField_a_of_type_ComTencentBitappBundleBundle;
      this.a.jdField_a_of_type_Hvy.a.startReactApplication(localBitAppInstanceManager, this.a.jdField_a_of_type_Hvy.a.mKey, this.a.jdField_a_of_type_Hvy.a.mLaunchOptions);
      if (QLog.isColorLevel()) {
        QLog.d(ReadInjoyBaseRNView.TAG, 2, "LoadBundleCallBack callBack startReactApplication");
      }
      ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "3", "0", "BitAppInstanceManager.loadBundle", "");
      ReportController.b(null, "CliOper", "", "", "0X800713A", "0X800713A", 0, 0, "3", "0", "BitAppInstanceManager.loadBundle", Long.toString(System.currentTimeMillis() - ReadInjoyBaseRNView.access$000(this.a.jdField_a_of_type_Hvy.a)));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyBaseRNView.TAG, 2, "LoadBundleCallBack callBack fail");
    }
    ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "3", "1", "BitAppInstanceManager.loadBundle", "");
    ReportController.b(null, "CliOper", "", "", "0X800713A", "0X800713A", 0, 0, "3", "1", "BitAppInstanceManager.loadBundle", Long.toString(System.currentTimeMillis() - ReadInjoyBaseRNView.access$000(this.a.jdField_a_of_type_Hvy.a)));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */