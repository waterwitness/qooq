import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

class yak
  implements QbSdk.PreInitCallback
{
  yak(yaj paramyaj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCoreInitFinished()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProxyPreLoadComicProcess", 2, "QbSdk.preInit.onCoreInitFinished");
    }
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProxyPreLoadComicProcess", 2, "QbSdk.preInit.onViewInitFinished");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */