import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class tn
{
  private final byte[] a;
  private final byte[] b;
  
  public tn(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public byte[] b()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\tn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */