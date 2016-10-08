import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jko
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private long b;
  private long c;
  
  public jko(long paramLong1, String paramString, long paramLong2, Throwable paramThrowable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = -1L;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */