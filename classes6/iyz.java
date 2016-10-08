import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;

public final class iyz
{
  public final int a;
  public final String a;
  public final Field a;
  
  public iyz(String paramString, int paramInt, Field paramField)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangReflectField = paramField;
    paramField.setAccessible(true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */