import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class vlk
{
  public static final int a = 1;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public vlk(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = paramInt1;
    this.a = paramString1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */