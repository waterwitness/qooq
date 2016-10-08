import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager.PreLoadBundle;

public class tpn
  implements Runnable
{
  public tpn(NearbyRNAppManager.PreLoadBundle paramPreLoadBundle, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!NearbyRNAppManager.b) || (NearbyRNAppManager.c)) {}
    BitAppInstanceManager localBitAppInstanceManager;
    do
    {
      return;
      localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    } while (localBitAppInstanceManager == null);
    localBitAppInstanceManager.loadBundle(this.jdField_a_of_type_ComTencentBitappBundleBundle, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */