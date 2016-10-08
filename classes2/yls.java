import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.util.NetworkState.NetworkStateListener;

public class yls
  implements NetworkState.NetworkStateListener
{
  public yls(UploadEnv paramUploadEnv, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "registerNetworkStateObserver|onNetworkConnect：" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentUploadCommonUploadConfiguration$NetworkStateObserver.onStateChanged(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */