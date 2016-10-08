import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;

public class vma
{
  public static final int a = 9;
  public final long a;
  public final int b;
  public final long b;
  
  public vma(ByteBuffer paramByteBuffer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = (paramByteBuffer.get() & 0xFFFF);
    this.a = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.jdField_b_of_type_Long = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */