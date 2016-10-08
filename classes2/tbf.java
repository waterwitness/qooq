import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.view.GLRender;

public class tbf
{
  public float a;
  public int a;
  public boolean a;
  public byte[] a;
  public int b;
  public byte[] b;
  public int c;
  public int d;
  
  public tbf(GLRender paramGLRender)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte1.length];
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label21;
      }
    }
    label21:
    do
    {
      return false;
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte1.length);
      this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte2.length];
    } while (this.jdField_b_of_type_ArrayOfByte == null);
    System.arraycopy(paramArrayOfByte2, 0, this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte2.length);
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */