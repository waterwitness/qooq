import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;

public class vly
{
  public static final int a = 16;
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  
  public vly(long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 2882377846L;
    this.b = 1007L;
    this.c = 0L;
    this.d = paramLong;
  }
  
  public vly(ByteBuffer paramByteBuffer)
  {
    this.a = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.b = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.c = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.d = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.putInt((int)(this.a & 0xFFFFFFFFFFFFFFFF));
    paramByteBuffer.putInt((int)(this.b & 0xFFFFFFFFFFFFFFFF));
    paramByteBuffer.putInt((int)(this.c & 0xFFFFFFFFFFFFFFFF));
    paramByteBuffer.putInt((int)(this.d & 0xFFFFFFFFFFFFFFFF));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */