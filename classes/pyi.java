import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pyi
{
  static final int a = 0;
  public static final String a = "com.tencent.mobileqq:qzone";
  public static final String[] a;
  static final int jdField_b_of_type_Int = 1;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "MSG", "RESUME", "TICK", "FG", "BG", "ENTER", "MAIN" };
  static final int c = 2;
  static final int d = 3;
  static final int e = 4;
  static final int f = 5;
  static final int g = 6;
  static final int h = 7;
  static final int i = 8;
  static final int j = 9;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  protected static final int n = 3;
  public static final int o = 3;
  public static final int p = 4;
  protected static final int q = 5;
  public static final int r = 6;
  protected long a;
  public GuardManager a;
  protected long b;
  protected long c;
  public int s;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "EMPTY", "BG_FETCH", "FG_MAIN", "FG_OTHER", "BG_GUARD", "BG_UNGUARD", "LITE_GUARD", "LITE_UNGUARD", "DEAD" };
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long += 1L;
    this.jdField_b_of_type_Long += 1L;
    this.c += 1L;
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, jdField_a_of_type_ArrayOfJavaLangString[this.s] + " onEvent " + jdField_b_of_type_ArrayOfJavaLangString[paramInt] + ", " + paramObject + ", " + this.jdField_a_of_type_Long + ", " + this.jdField_b_of_type_Long);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a();
      return;
    case 0: 
      b();
      return;
    case 3: 
      a((String)paramObject);
      return;
    case 4: 
      d((String)paramObject);
      return;
    case 5: 
      b((String)paramObject);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(2, null);
      return;
    }
    c((String)paramObject);
  }
  
  protected void a(String paramString) {}
  
  protected void b() {}
  
  protected void b(String paramString)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.c = 0L;
  }
  
  protected void c(String paramString) {}
  
  protected void d(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */