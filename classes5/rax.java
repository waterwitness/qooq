import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class rax
  implements Runnable
{
  public rax(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i1 = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime();
    HashSet localHashSet = new HashSet(16);
    SparseArray localSparseArray = new SparseArray(16);
    Object localObject2 = null;
    Object localObject1 = null;
    HashMap localHashMap = new HashMap(8);
    int k = SharedPreUtils.E(localQQAppInterface.a(), ConfigServlet.h);
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
      }
    }
    if (i > k)
    {
      if (i <= k) {
        break label925;
      }
      j = i;
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content_list is empty ,version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
        }
      }
    }
    int n;
    for (;;)
    {
      return;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size();
      int m = 0;
      n = j;
      localObject2 = localObject1;
      Object localObject3;
      if (m < i2)
      {
        localObject3 = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content: " + (String)localObject3 + ",version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {}
        for (localObject3 = localObject1;; localObject3 = localObject2)
        {
          for (;;)
          {
            m += 1;
            localObject1 = localObject3;
            break;
            localObject2 = localObject1;
            try
            {
              JSONObject localJSONObject2 = new JSONObject((String)localObject3);
              localObject2 = localObject1;
              Iterator localIterator = localJSONObject2.keys();
              for (;;)
              {
                label328:
                localObject3 = localObject1;
                localObject2 = localObject1;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject2 = localObject1;
                localObject3 = (String)localIterator.next();
                localObject2 = localObject1;
                int i3;
                label390:
                Object localObject4;
                if ("image_urls".equals(localObject3))
                {
                  localObject2 = localObject1;
                  localObject3 = localJSONObject2.optJSONArray((String)localObject3);
                  if (localObject3 != null)
                  {
                    localObject2 = localObject1;
                    i3 = ((JSONArray)localObject3).length();
                    n = 0;
                    if (n < i3)
                    {
                      localObject2 = localObject1;
                      localObject4 = ((JSONArray)localObject3).optString(n);
                      localObject2 = localObject1;
                      if (TextUtils.isEmpty((CharSequence)localObject4)) {
                        break label932;
                      }
                      localObject2 = localObject1;
                      if (localHashSet.contains(localObject4)) {
                        break label932;
                      }
                      localObject2 = localObject1;
                      localHashSet.add(localObject4);
                      break label932;
                    }
                  }
                }
                else
                {
                  localObject2 = localObject1;
                  if ("hb_theme".equals(localObject3))
                  {
                    localObject2 = localObject1;
                    localObject3 = localJSONObject2.optJSONArray((String)localObject3);
                    if (localObject3 != null)
                    {
                      localObject2 = localObject1;
                      i3 = ((JSONArray)localObject3).length();
                      n = 0;
                      while (n < i3)
                      {
                        localObject2 = localObject1;
                        localObject4 = ((JSONArray)localObject3).optJSONObject(n);
                        localObject2 = localObject1;
                        localSparseArray.append(((JSONObject)localObject4).optInt("id"), localObject4);
                        n += 1;
                      }
                    }
                  }
                  else
                  {
                    localObject2 = localObject1;
                    if ("hb_normal".equals(localObject3))
                    {
                      localObject2 = localObject1;
                      localObject3 = localJSONObject2.optJSONObject((String)localObject3);
                      if (i <= j) {
                        break label922;
                      }
                      localObject1 = localObject3;
                      break label941;
                    }
                    localObject2 = localObject1;
                    localHashMap.put(localObject3, localJSONObject2.opt((String)localObject3));
                  }
                }
              }
              if (!QLog.isColorLevel()) {}
            }
            catch (Exception localException1)
            {
              localObject3 = localObject2;
            }
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG remote version: " + i + " | localVersion: " + k);
        }
        n = k;
      }
      if (n > k) {
        try
        {
          SharedPreUtils.k(localQQAppInterface.a(), ConfigServlet.h, n);
          JSONObject localJSONObject1 = new JSONObject();
          j = localSparseArray.size();
          if (j > 0)
          {
            localObject3 = new JSONArray();
            i = 0;
            while (i < j)
            {
              ((JSONArray)localObject3).put(localSparseArray.valueAt(i));
              i += 1;
            }
            localJSONObject1.put("hb_theme", localObject3);
            localSparseArray.clear();
          }
          if (localObject2 != null) {
            localJSONObject1.put("hb_normal", localObject2);
          }
          if (!localHashMap.isEmpty())
          {
            localObject2 = localHashMap.entrySet().iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject2).next();
                localJSONObject1.put((String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
                continue;
                if (i != 0) {
                  break;
                }
              }
            }
          }
        }
        catch (Exception localException2)
        {
          i = i1;
          if (QLog.isColorLevel())
          {
            QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException2);
            i = i1;
          }
        }
      }
    }
    label922:
    label925:
    label932:
    label941:
    label944:
    for (;;)
    {
      HbThemeConfigManager.a().a(localQQAppInterface, null);
      return;
      localHashMap.clear();
      localObject2 = HbThemeConfigManager.a();
      if (localException2.length() > 0) {}
      for (String str = localException2.toString();; str = "")
      {
        ((HbThemeConfigManager)localObject2).a(localQQAppInterface, str);
        PreloadImgManager.a().a(localQQAppInterface, localHashSet);
        if (!localHashSet.isEmpty()) {
          PreloadImgManager.a().b(localQQAppInterface, localHashSet);
        }
        localHashSet.clear();
        i = 1;
        break;
      }
      i = 0;
      break label944;
      break label941;
      j = k;
      break;
      n += 1;
      break label390;
      break label328;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */