import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;

public class pzl
  extends pyi
{
  public pzl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Long >= pyg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.a(Process.myPid())) / 12000L) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(7, null);
    }
    while (this.b != 1L) {
      return;
    }
    MemoryManager.a().a();
  }
  
  protected void a(String paramString)
  {
    GuardManager localGuardManager = this.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if ("com.tencent.mobileqq".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.a(i, paramString);
      return;
    }
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
    CoreService.a();
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.e();
    BaseApplicationImpl.a.a().onGuardEvent(3, 0L, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */