import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LocalMultiProcConfig;

public final class kgc
{
  public int a;
  public long a;
  public long b;
  
  private kgc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    LocalMultiProcConfig.a("last_report_time", this.jdField_a_of_type_Long);
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\kgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */