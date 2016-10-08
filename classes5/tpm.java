import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager.PreLoadBundle;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager.PreLoadSo;
import com.tencent.mobileqq.rn.RNTest;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.lang.ref.WeakReference;

public final class tpm
  implements Runnable
{
  public tpm(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NearbyRNAppManager.c) {}
    do
    {
      do
      {
        return;
        try
        {
          if (!RNPreDownloadFacade.a()) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(217);
          }
          BundleStruct localBundleStruct2 = BundleStructCache.INSTANCE.get(this.jdField_a_of_type_Int);
          BundleStruct localBundleStruct1 = localBundleStruct2;
          if (localBundleStruct2.module_version < this.b)
          {
            localBundleStruct1 = new BundleStruct(this.jdField_a_of_type_Int);
            localBundleStruct1.module_version = this.b;
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
            localBundleStruct1.localFile = RNTest.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
          }
          if (NearbyRNAppManager.jdField_a_of_type_ComTencentBitappBundleIBundleListener == null) {
            NearbyRNAppManager.jdField_a_of_type_ComTencentBitappBundleIBundleListener = new NearbyRNAppManager.PreLoadBundle();
          }
          BundleFacade.loadBundle(localBundleStruct1, new WeakReference(NearbyRNAppManager.jdField_a_of_type_ComTencentBitappBundleIBundleListener));
          return;
        }
        catch (Throwable localThrowable) {}
      } while (!NearbyUtils.b());
      localThrowable.printStackTrace();
      NearbyUtils.a(NearbyRNAppManager.jdField_a_of_type_JavaLangString, new Object[] { "preLoadBundle", localThrowable.toString() });
      return;
    } while (!NetworkUtil.i(BaseApplicationImpl.getContext()));
    if (NearbyRNAppManager.jdField_a_of_type_ComTencentBitappPreDownloadIRNPreDownloadListener == null) {
      NearbyRNAppManager.jdField_a_of_type_ComTencentBitappPreDownloadIRNPreDownloadListener = new NearbyRNAppManager.PreLoadSo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b);
    }
    RNPreDownloadFacade.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, false, NearbyRNAppManager.jdField_a_of_type_ComTencentBitappPreDownloadIRNPreDownloadListener);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */