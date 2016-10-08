import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public final class rap
  extends SosoInterface.OnLocationListener
{
  public rap(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString1);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str1 = "";
    String str4 = "";
    try
    {
      ConfigServlet.h = this.jdField_a_of_type_JavaLangString;
      String str3 = str4;
      String str2 = str1;
      if (paramInt == 0)
      {
        str3 = str4;
        str2 = str1;
        if (paramSosoLbsInfo != null)
        {
          str3 = str4;
          str2 = str1;
          if (paramSosoLbsInfo.a != null)
          {
            if (paramSosoLbsInfo.a.d != null) {
              str1 = paramSosoLbsInfo.a.d;
            }
            str3 = str4;
            str2 = str1;
            if (paramSosoLbsInfo.a.e != null)
            {
              str3 = paramSosoLbsInfo.a.e;
              str2 = str1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", "onLocationFinish", Integer.valueOf(paramInt), str2, str3, Long.valueOf(Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long)) });
      }
      paramSosoLbsInfo = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), ConfigServlet.class);
      paramSosoLbsInfo.putExtra("k_cmd_type", new int[] { 104, 87 });
      paramSosoLbsInfo.putExtra("key_province", str2);
      paramSosoLbsInfo.putExtra("key_city", str3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramSosoLbsInfo);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      do
      {
        paramSosoLbsInfo.printStackTrace();
      } while (!QLog.isColorLevel());
      NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramSosoLbsInfo.toString() });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */