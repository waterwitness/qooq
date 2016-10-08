import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

class wgr
  implements QbSdk.PreInitCallback
{
  wgr(wgq paramwgq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCoreInitFinished()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "preloadForTool QbSdk.preInit.onCoreInitFinished");
    }
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "preloadForTool QbSdk.preInit.onViewInitFinished");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */