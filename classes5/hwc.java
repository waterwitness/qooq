import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyRNManager;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyRNManager.PreLoadBundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hwc
  implements Runnable
{
  public hwc(ReadInjoyRNManager.PreLoadBundle paramPreLoadBundle, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((ReadInjoyRNManager.c) || (ReadInjoyRNManager.b)) {}
    BitAppInstanceManager localBitAppInstanceManager;
    do
    {
      return;
      localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    } while (localBitAppInstanceManager == null);
    localBitAppInstanceManager.loadBundle(this.jdField_a_of_type_ComTencentBitappBundleBundle, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */