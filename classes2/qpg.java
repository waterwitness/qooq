import android.os.RemoteCallbackList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArResourceDownload;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class qpg
  extends IArConfigManager.Stub
{
  public qpg(ArConfigService paramArConfigService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArConfigInfo a()
  {
    ArConfigInfo localArConfigInfo = null;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
      localArConfigInfo = this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "getArConfigInfo | mConfigInfo = " + localArConfigInfo);
    }
    return localArConfigInfo;
  }
  
  public ArEffectConfig a()
  {
    ArEffectConfig localArEffectConfig = null;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
      localArEffectConfig = this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "getArEffectConfig|mEffectConfig=" + localArEffectConfig);
    }
    return localArEffectConfig;
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(false, false);
      HashMap localHashMap = new HashMap();
      localHashMap.put("click_download", "1");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ar_client_download_times", true, 0L, 0L, localHashMap, null);
    }
  }
  
  public void a(IArRemoteCallback paramIArRemoteCallback)
  {
    if (paramIArRemoteCallback != null) {
      ArConfigService.a(this.a).register(paramIArRemoteCallback);
    }
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a.a();
    }
  }
  
  public void b(IArRemoteCallback paramIArRemoteCallback)
  {
    if (paramIArRemoteCallback != null) {
      ArConfigService.a(this.a).unregister(paramIArRemoteCallback);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */