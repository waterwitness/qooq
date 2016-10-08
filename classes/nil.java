import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class nil
{
  protected int a;
  protected String a;
  protected nll a;
  protected int b;
  protected String b;
  
  nil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(nll paramnll)
  {
    this.jdField_a_of_type_Nll = paramnll;
  }
  
  public boolean a(String paramString)
  {
    a();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = -1;
    return true;
  }
  
  public abstract boolean b(String paramString);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */