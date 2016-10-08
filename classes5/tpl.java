import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.manager.BitAppInstanceManager.LoadBundleCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyBaseRRV;
import com.tencent.mobileqq.nearby.rn.NearbyBaseRRV.INearbyBaseRRVListener;

class tpl
  implements BitAppInstanceManager.LoadBundleCallBack
{
  tpl(tpk paramtpk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void callBack()
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(NearbyBaseRRV.TAG, "callBack", new Object[] { this.a.jdField_a_of_type_Tpj.a.mKey });
    }
    if (this.a.jdField_a_of_type_Tpj.a.mListener != null) {
      this.a.jdField_a_of_type_Tpj.a.mListener.f(this.a.jdField_a_of_type_Tpj.a.mKey);
    }
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null)
    {
      this.a.jdField_a_of_type_Tpj.a.mBundle = this.a.jdField_a_of_type_ComTencentBitappBundleBundle;
      this.a.jdField_a_of_type_Tpj.a.startReactApplication(localBitAppInstanceManager, this.a.jdField_a_of_type_Tpj.a.mKey, this.a.jdField_a_of_type_Tpj.a.mLaunchOptions);
      if (this.a.jdField_a_of_type_Tpj.a.mListener != null) {
        this.a.jdField_a_of_type_Tpj.a.mListener.c(this.a.jdField_a_of_type_Tpj.a.mKey);
      }
    }
    do
    {
      return;
      if (NearbyUtils.a()) {
        NearbyUtils.a(NearbyBaseRRV.TAG, "callBack manager is null", new Object[0]);
      }
    } while (this.a.jdField_a_of_type_Tpj.a.mListener == null);
    this.a.jdField_a_of_type_Tpj.a.mListener.a(this.a.jdField_a_of_type_Tpj.a.mKey, 0, "callBack manager is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */