import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ust
  implements TVK_SDKMgr.InstallListener
{
  ust(uss paramuss)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ShortVideoGuideUtil.a, 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ShortVideoGuideUtil.a, 2, "installSDK onInstalledSuccessed=");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */