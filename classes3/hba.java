import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hba
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  
  hba()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */