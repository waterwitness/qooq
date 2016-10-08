import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public final class raq
  extends SosoInterface.OnLocationListener
{
  public raq(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject1 = "";
    String str2 = "";
    try
    {
      ConfigServlet.h = this.jdField_a_of_type_JavaLangString;
      String str1 = str2;
      Object localObject2 = localObject1;
      if (paramInt == 0)
      {
        str1 = str2;
        localObject2 = localObject1;
        if (paramSosoLbsInfo != null)
        {
          str1 = str2;
          localObject2 = localObject1;
          if (paramSosoLbsInfo.a != null)
          {
            if (paramSosoLbsInfo.a.d != null)
            {
              str1 = paramSosoLbsInfo.a.d;
              localObject1 = str1;
              if (QLog.isColorLevel())
              {
                QLog.d("SPLASH_ConfigServlet", 2, "getPrecoverConfig, PRECOVER_CONFIG_CMD, strProvince=" + str1);
                localObject1 = str1;
              }
            }
            str1 = str2;
            localObject2 = localObject1;
            if (paramSosoLbsInfo.a.e != null)
            {
              str2 = paramSosoLbsInfo.a.e;
              str1 = str2;
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("SPLASH_ConfigServlet", 2, "getPrecoverConfig, PRECOVER_CONFIG_CMD, strCity=" + str2);
                localObject2 = localObject1;
                str1 = str2;
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "getPrecoverConfig, PRECOVER_CONFIG_CMD, onLocationFinish, errCode=", Integer.valueOf(paramInt), ", info=", paramSosoLbsInfo });
      }
      paramSosoLbsInfo = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), ConfigServlet.class);
      paramSosoLbsInfo.putExtra("k_cmd_type", new int[] { 113 });
      paramSosoLbsInfo.putExtra("key_province", (String)localObject2);
      paramSosoLbsInfo.putExtra("key_city", str1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramSosoLbsInfo);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      do
      {
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "getPrecoverConfig, PRECOVER_CONFIG_CMD", "getGeneralLBSConfigs", paramSosoLbsInfo.getMessage() });
      } while (!QLog.isColorLevel());
      paramSosoLbsInfo.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\raq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */