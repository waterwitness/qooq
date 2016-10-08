package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.uinterface.IUploadEnv;
import cooperation.qzone.util.NetworkState;
import yls;

public final class UploadEnv
  implements IUploadEnv
{
  private static final String a = "UploadEnv";
  
  public UploadEnv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getApnName()
  {
    return NetworkState.b();
  }
  
  public String getBSSID()
  {
    return DeviceInfoUtil.b(BaseApplication.getContext());
  }
  
  public int getCurrentNetworkCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 6;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public int getMobileOperatorCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public String getProviderName()
  {
    return NetworkState.a();
  }
  
  public boolean isAvailable()
  {
    return NetworkState.d();
  }
  
  public boolean isMobile()
  {
    return NetworkState.b();
  }
  
  public boolean isWap()
  {
    return NetworkState.a();
  }
  
  public boolean isWifi()
  {
    return NetworkState.c();
  }
  
  public boolean loadLibrary(String paramString)
  {
    QLog.d("UploadEnv", 1, "loadLibrary");
    return Native.a(paramString, BaseApplication.getContext());
  }
  
  public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "registerNetworkStateObserver");
    }
    NetworkState.a(new yls(this, paramNetworkStateObserver));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\UploadEnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */