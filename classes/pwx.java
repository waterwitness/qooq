import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCConfigInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class pwx
  implements Runnable
{
  public pwx(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$RespGetConfig.config_list.get(0);
    Object localObject1 = localConfig.content_list;
    QLog.i(DeviceProfileManager.jdField_a_of_type_JavaLangString, 1, "onDPCResponse is called, version=" + localConfig.version.get());
    if (localObject1 != null) {}
    boolean bool1;
    int i;
    Iterator localIterator;
    SharedPreferences.Editor localEditor2;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor3;
    HashMap localHashMap2;
    label294:
    break label791;
    label295:
    Object localObject7;
    pwz localpwz;
    Object localObject5;
    Object localObject6;
    SharedPreferences.Editor localEditor1;
    label573:
    label684:
    do
    {
      do
      {
        do
        {
          try
          {
            if (((PBRepeatField)localObject1).size() != 0)
            {
              bool1 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
              if (!bool1) {}
            }
            else
            {
              return;
            }
            ??? = new HashMap();
            i = 0;
            if (i < ((PBRepeatField)localObject1).size())
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a((String)((PBRepeatField)localObject1).get(i), (HashMap)???)) {
                break label1195;
              }
              QLog.e(DeviceProfileManager.jdField_a_of_type_JavaLangString, 1, "onDPCResponse parseDPCXML error, so return");
              break label1195;
            }
            localIterator = ((HashMap)???).entrySet().iterator();
            localEditor2 = ReflectedMethods.a(BaseApplicationImpl.a(), "dpcConfig").edit();
            localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.a(), "dpcConfig_account");
            localEditor3 = localSharedPreferences.edit();
            localObject1 = null;
            Intent localIntent1;
            localObject6 = DeviceProfileManager.a().b;
          }
          catch (Exception localException) {}finally
          {
            this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
            ??? = new Intent("com.tentcent.mobileqq.dpc.broadcast");
            localObject5 = new Bundle();
            ((Bundle)localObject5).putSerializable("featureMapLV2", DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager));
            if (DeviceProfileManager.a() != null) {
              ((Bundle)localObject5).putSerializable("featureAccountMapLV2", DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap);
            }
            ((Intent)???).putExtras((Bundle)localObject5);
            BaseApplicationImpl.a().sendBroadcast((Intent)???, "com.tencent.msg.permission.pushnotify");
          }
          bool1 = true;
          ??? = DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a(), (String)localObject7);
          localEditor1 = localEditor3;
          localObject5 = localHashMap1;
          if (QLog.isColorLevel()) {
            QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + (String)localObject7 + ", value=" + localpwz.toString() + ", isAccountName=" + bool1);
          }
        } while (localObject5 == null);
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject5).get(???);
        bool1 = false;
        localObject7 = localDPCConfigInfo;
        if (localDPCConfigInfo != null) {
          break label684;
        }
        bool1 = true;
        localObject6 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject6).get(???);
      } while (localObject6 == null);
      localObject7 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject6).clone();
    } while (localObject7 == null);
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 4, "onDPCResponse tempFeatureMap old value: key=" + (String)??? + " " + localObject7 + ", isAddConfig=" + bool1);
    }
    boolean bool2 = DeviceProfileManager.a((DeviceProfileManager.DPCConfigInfo)localObject7, localpwz.b.toString().trim());
    if (bool1) {
      ((HashMap)localObject5).put(???, localObject7);
    }
    for (;;)
    {
      localEditor1.putString((String)???, localpwz.b);
      label791:
      if (!QLog.isColorLevel()) {
        break label295;
      }
      QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse tempFeatureMap new value: key=" + (String)??? + " " + localObject7 + ", isAddConfig=" + bool1 + ", hasUpdate=" + bool2);
      break label295;
      localObject6 = DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager);
      bool1 = false;
      localObject5 = localHashMap2;
      localEditor1 = localEditor2;
      ??? = localObject7;
      break label573;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager)
      {
        DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager, localHashMap2);
        if ((DeviceProfileManager.a() != null) && (DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface.a()))) {
          DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap = localHashMap1;
        }
        if (DeviceProfileManager.a() != null)
        {
          localEditor3.putLong(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface, "last_update_time"), System.currentTimeMillis());
          localEditor3.putInt(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface, "server_version"), localConfig.version.get());
        }
        i = localSharedPreferences.getInt("key_versioncode", 0);
        int j = ApkUtils.a(BaseApplicationImpl.a());
        if (i < j) {
          localEditor3.putInt("key_versioncode", j);
        }
        localEditor2.commit();
        localEditor3.commit();
        QLog.i(DeviceProfileManager.jdField_a_of_type_JavaLangString, 1, "onDPCResponse KEY_LAST_UPDATE_TIME=" + System.currentTimeMillis() + ", versioncode=" + j + ", keyVersionCode =" + i);
        this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
        Intent localIntent2 = new Intent("com.tentcent.mobileqq.dpc.broadcast");
        ??? = new Bundle();
        ((Bundle)???).putSerializable("featureMapLV2", DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager));
        if (DeviceProfileManager.a() != null) {
          ((Bundle)???).putSerializable("featureAccountMapLV2", DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap);
        }
        localIntent2.putExtras((Bundle)???);
        BaseApplicationImpl.a().sendBroadcast(localIntent2, "com.tencent.msg.permission.pushnotify");
        return;
      }
      label1195:
      i += 1;
      break;
      if (!bool1) {
        if (!bool2) {
          break label294;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */