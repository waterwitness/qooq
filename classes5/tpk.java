import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.report.RNReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyBaseRRV;
import com.tencent.mobileqq.nearby.rn.NearbyBaseRRV.INearbyBaseRRVListener;

class tpk
  implements Runnable
{
  tpk(tpj paramtpj, String paramString, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    int i;
    if (localBitAppInstanceManager != null)
    {
      if (this.jdField_a_of_type_Tpj.a.mListener != null) {
        this.jdField_a_of_type_Tpj.a.mListener.e(this.jdField_a_of_type_JavaLangString);
      }
      String str = "RNINIT_" + this.jdField_a_of_type_JavaLangString;
      RNReport.reportStageStart(str, 6);
      if (localBitAppInstanceManager.isInitContextOk())
      {
        i = 1;
        RNReport.addStageFlag(str, 6, 4, i);
        localBitAppInstanceManager.loadBundle(this.jdField_a_of_type_ComTencentBitappBundleBundle, new tpl(this), false);
      }
    }
    do
    {
      return;
      i = 0;
      break;
      if (NearbyUtils.a()) {
        NearbyUtils.a(NearbyBaseRRV.TAG, "onLoadSuccess manager is null", new Object[0]);
      }
    } while (this.jdField_a_of_type_Tpj.a.mListener == null);
    this.jdField_a_of_type_Tpj.a.mListener.a(this.jdField_a_of_type_Tpj.a.mKey, 0, "onLoadSuccess manager is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */