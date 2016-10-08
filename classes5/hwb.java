import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyRNManager;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyRNManager.PreLoadBundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.lang.ref.WeakReference;

public final class hwb
  implements Runnable
{
  public hwb(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ReadInjoyRNManager.b) {}
    for (;;)
    {
      return;
      try
      {
        if (RNPreDownloadFacade.a())
        {
          BundleStruct localBundleStruct2 = BundleStructCache.INSTANCE.get(this.a);
          BundleStruct localBundleStruct1 = localBundleStruct2;
          if (localBundleStruct2.module_version < this.b)
          {
            localBundleStruct1 = new BundleStruct(this.a);
            localBundleStruct1.module_version = this.b;
          }
          if (ReadInjoyRNManager.a == null) {
            ReadInjoyRNManager.a = new ReadInjoyRNManager.PreLoadBundle();
          }
          BundleFacade.loadBundle(localBundleStruct1, new WeakReference(ReadInjoyRNManager.a));
          return;
        }
        boolean bool = NetworkUtil.i(BaseApplicationImpl.getContext());
        if (bool) {}
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */