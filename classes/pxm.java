import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;

public class pxm
  extends pyi
{
  private String b;
  
  public pxm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    boolean bool2 = true;
    super.a();
    if (this.jdField_b_of_type_Long >= 3L)
    {
      if (this.a.d == null) {
        break label134;
      }
      bool1 = true;
      this.a.a(bool1, new String[] { "com.tencent.mobileqq:qzone", this.jdField_b_of_type_JavaLangString });
      this.jdField_b_of_type_Long = 0L;
      if (!bool1) {
        this.a.a(4, null);
      }
    }
    if ((this.c >= 15L) && (!DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.disable_qzone_kill.name()))) {
      if (this.a.d == null) {
        break label139;
      }
    }
    label134:
    label139:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.a.a(bool1, "com.tencent.mobileqq:qzone");
      StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
      this.c = 0L;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void a(String paramString)
  {
    if (!"com.tencent.mobileqq".equals(paramString)) {
      this.a.a(3, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    CoreService.a();
    this.a.e();
    this.a.d = "com.tencent.mobileqq";
  }
  
  protected void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if ("com.tencent.mobileqq".equals(paramString)) {
      this.a.a(4, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */