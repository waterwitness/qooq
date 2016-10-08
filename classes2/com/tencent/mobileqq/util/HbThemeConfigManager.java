package com.tencent.mobileqq.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import vyj;
import vyk;

public class HbThemeConfigManager
{
  private static HbThemeConfigManager jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager;
  private static final String jdField_a_of_type_JavaLangString = "HbThemeConfigManager";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final String b = "hbThemeConfig.cfg";
  public List a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HbThemeConfigManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(8);
  }
  
  /* Error */
  public static HbThemeConfigManager a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 24	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 38	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/mobileqq/util/HbThemeConfigManager
    //   24: dup
    //   25: invokespecial 39	com/tencent/mobileqq/util/HbThemeConfigManager:<init>	()V
    //   28: putstatic 38	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 38	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private String a(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppInterface.a().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append(paramAppInterface.a()).append(File.separator);
    return localStringBuilder.toString();
  }
  
  private List a(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "convertToHBThemeConfig config is empty return. ");
      }
    }
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramAppInterface = new JSONObject(paramString).optJSONArray("hb_theme");
          if (paramAppInterface != null)
          {
            int j = paramAppInterface.length();
            paramString = new ArrayList(16);
            int i = 0;
            while (i < j)
            {
              JSONObject localJSONObject = paramAppInterface.optJSONObject(i);
              HbThemeConfigManager.HBThemeConfig localHBThemeConfig = new HbThemeConfigManager.HBThemeConfig();
              localHBThemeConfig.jdField_a_of_type_Int = localJSONObject.optInt("id", -1);
              localHBThemeConfig.jdField_a_of_type_JavaLangString = localJSONObject.optString("name", "");
              localHBThemeConfig.jdField_b_of_type_JavaLangString = localJSONObject.optString("img", "");
              localHBThemeConfig.c = localJSONObject.optString("aio_left_img", "");
              localHBThemeConfig.d = localJSONObject.optString("aio_right_img", "");
              localHBThemeConfig.e = localJSONObject.optString("begintime", "");
              localHBThemeConfig.f = localJSONObject.optString("endtime", "");
              localHBThemeConfig.jdField_a_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("wish_array");
              localHBThemeConfig.jdField_b_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("money_array");
              paramString.add(localHBThemeConfig);
              i += 1;
            }
            return paramString;
          }
        }
        catch (Exception paramAppInterface) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("HbThemeConfigManager", 2, "convertToHBThemeConfig Exception: " + paramAppInterface.toString());
    return null;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager = null;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, HbThemeConfigManager.LoadHbThemeConfigCallback paramLoadHbThemeConfigCallback)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.a())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config, but AppInterface is null or account is empty return. ");
      }
      return;
    }
    ThreadManager.a().post(new vyk(this, paramQQAppInterface, paramLoadHbThemeConfigCallback));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.a())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config, but AppInterface is null or account is empty return. ");
      }
      return;
    }
    ThreadManager.a().post(new vyj(this, paramString, paramQQAppInterface));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\HbThemeConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */