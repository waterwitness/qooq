import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.DeviceAbilityCollector;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class pts
  extends pyi
{
  private String b;
  
  public pts()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Long += 1L;
    this.jdField_b_of_type_Long += 1L;
    this.c += 1L;
    if ((this.jdField_b_of_type_Long == 1L) && (SetSplash.b()) && (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.d == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
      }
      ReportController.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
      System.exit(-1);
    }
    int i = GuardManager.a();
    if (this.jdField_a_of_type_Long >= pyg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.a(Process.myPid())) / 12000L)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_b_of_type_Long != 50L) && (this.jdField_b_of_type_Long != 51L)) {
        break label430;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[0]);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Long == 5L) || (this.jdField_b_of_type_Long == 6L))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("sp_dex_patch", 4);
        boolean bool1 = localSharedPreferences.getBoolean("enable", false);
        String str = localSharedPreferences.getString("name", "");
        boolean bool2 = localSharedPreferences.getBoolean("verify", false);
        if ((bool1) && (bool2) && ((BaseApplicationImpl.jdField_j_of_type_Int == 0) || (!str.equals(BaseApplicationImpl.jdField_j_of_type_JavaLangString)) || (!BaseApplicationImpl.e)))
        {
          QLog.d("BackgroundGuard", 1, "exit for patch, to install name=" + str + ", installed name=" + BaseApplicationImpl.jdField_j_of_type_JavaLangString + ", install result=" + BaseApplicationImpl.jdField_j_of_type_Int + ", isRestartInstall=" + BaseApplicationImpl.e);
          this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[0]);
        }
      }
      return;
      if (this.jdField_b_of_type_Long == 1L)
      {
        MemoryManager.a().a();
        DeviceAbilityCollector.a(BaseApplicationImpl.getContext());
        break;
      }
      if ((this.jdField_b_of_type_Long != 3L) && (this.jdField_b_of_type_Long != 4L)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[] { "com.tencent.mobileqq:qzone", this.jdField_b_of_type_JavaLangString });
      break;
      label430:
      if ((this.jdField_b_of_type_Long == i) || (this.jdField_b_of_type_Long == i + 1)) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, "com.tencent.mobileqq:qzone");
      }
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Long > 2L) {
      this.jdField_a_of_type_Long -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.jdField_b_of_type_JavaLangString = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.jdField_a_of_type_Long = (pyg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.a(Process.myPid())) / 12000L - 2L);
    }
    CoreService.a();
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.e();
    BaseApplicationImpl.a.a().onGuardEvent(1, 0L, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */