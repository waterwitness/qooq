import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginInstaller;
import cooperation.qzone.plugin.QZonePluginManger;
import cooperation.qzone.plugin.QZonePluginManger.LaunchState;

public class yoi
  extends OnQZonePluginInstallListner.Stub
{
  private QZonePluginManger.LaunchState jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState;
  
  public yoi(QZonePluginManger paramQZonePluginManger, QZonePluginManger.LaunchState paramLaunchState)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState = paramLaunchState;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onInstallBegin." + paramString);
    }
  }
  
  public void a(String paramString, float paramFloat, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onInstallDownloadProgress." + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onInstallError." + paramString + "," + paramInt);
    }
    QZonePluginManger.LaunchState localLaunchState = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState;
    if ((localLaunchState != null) && (localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener != null))
    {
      paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger.a(paramString);
      if ((paramString != null) && (paramString.k != null)) {
        localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.c = paramString.k;
      }
      paramString = localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener;
      if (paramInt != 2) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState;
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener != null))
    {
      PluginRecord localPluginRecord = QZonePluginManger.a(this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger).a(paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.b);
      if ((localPluginRecord != null) && (localPluginRecord.k != null)) {
        paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.c = localPluginRecord.k;
      }
      paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */