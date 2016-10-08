import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

public class pvq
  implements Runnable
{
  public pvq(ConditionSearchManager paramConditionSearchManager, String paramString, GetResourceRespInfo paramGetResourceRespInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool3 = true;
    File localFile = new File(ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager).getApplication().getFilesDir(), "temp_admin_regin_config");
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager), (String)localObject, localFile);
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onCheckupConfig | download result = ");
      if (i == 0)
      {
        bool1 = true;
        QLog.d("ConditionSearch.Manager", 2, bool1);
      }
    }
    else
    {
      if (i != 0) {
        break label272;
      }
      localObject = new File(ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager).getApplication().getFilesDir(), "admin_region_config");
      if ((!localFile.renameTo((File)localObject)) && (!localFile.renameTo((File)localObject)) && (!localFile.renameTo((File)localObject))) {
        break label260;
      }
      ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer);
      ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager).edit().putLong("key_config_version", ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager)).commit();
      bool1 = true;
      label191:
      bool2 = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | rename result = " + bool1);
      }
    }
    label260:
    label272:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((i == 0) && (bool2)) {}
      for (bool1 = bool3;; bool1 = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(bool1);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label191;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */