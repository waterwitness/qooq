import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hvz
  implements Runnable
{
  hvz(hvy paramhvy, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null) {
      localBitAppInstanceManager.loadBundle(this.jdField_a_of_type_ComTencentBitappBundleBundle, new hwa(this), false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */