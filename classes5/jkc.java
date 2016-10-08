import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class jkc
{
  int a;
  public String a;
  public AtomicInteger a;
  public String b;
  
  public jkc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Int = 0;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = Utils.Crc64String(paramString);
    this.b = (AppConstants.bx + paramString + ".apk");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */