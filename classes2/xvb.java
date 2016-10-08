import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.TCWNumberPicker.Formatter;
import java.util.Formatter;

public final class xvb
  implements TCWNumberPicker.Formatter
{
  final StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  final Formatter jdField_a_of_type_JavaUtilFormatter;
  final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  public xvb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder);
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[1];
  }
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject[0] = Integer.valueOf(paramInt);
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_JavaUtilFormatter.format("%02d", this.jdField_a_of_type_ArrayOfJavaLangObject);
    return this.jdField_a_of_type_JavaUtilFormatter.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */