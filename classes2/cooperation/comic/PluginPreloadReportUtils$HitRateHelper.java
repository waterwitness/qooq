package cooperation.comic;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class PluginPreloadReportUtils$HitRateHelper
{
  private final int jdField_a_of_type_Int;
  public PreloadProcHitPluginSession a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public PluginPreloadReportUtils$HitRateHelper(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 0;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    c();
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 1)
    {
      PluginPreloadReportUtils.a(localAppRuntime, i, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(this.d) });
      c();
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.d = 0;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    HitRateHelper localHitRateHelper = (HitRateHelper)PluginPreloadReportUtils.a().get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localHitRateHelper != null) && (localHitRateHelper.jdField_a_of_type_Boolean)) {
      localHitRateHelper.b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.c = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt2;
    PluginPreloadReportUtils.a().put(Integer.valueOf(this.jdField_a_of_type_Int), this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginPreloadReportUtils$HitRateHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */