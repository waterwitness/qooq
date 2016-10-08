import com.tencent.biz.qqstory.takevideo.bitmap.JavaBlurProcess;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.Callable;

public class ixa
  implements Callable
{
  private final int jdField_a_of_type_Int;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  
  public ixa(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  public Void a()
  {
    JavaBlurProcess.a(this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Int, this.b, this.c, this.d, this.e, this.f);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */