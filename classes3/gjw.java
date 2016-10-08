import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import javax.microedition.khronos.opengles.GL11;

public class gjw
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final GL11 jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public gjw(GL11 paramGL11)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 7681;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 3553;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11 = paramGL11;
    paramGL11.glDisable(2896);
    paramGL11.glEnable(3024);
    paramGL11.glEnableClientState(32884);
    paramGL11.glEnableClientState(32888);
    paramGL11.glEnable(3553);
    paramGL11.glTexEnvf(8960, 8704, 7681.0F);
    paramGL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    paramGL11.glEnable(3042);
    paramGL11.glBlendFunc(1, 771);
    paramGL11.glPixelStorei(3317, 2);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_b_of_type_Float == paramFloat) {
      return;
    }
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glLineWidth(paramFloat);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexEnvf(8960, 8704, paramInt);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if ((!Utils.a(paramInt)) || (paramFloat < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_Float = -1.0F;
      b(0);
      paramFloat = (paramInt >>> 24) * paramFloat * 65535.0F / 255.0F / 255.0F;
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glColor4x(Math.round((paramInt >> 16 & 0xFF) * paramFloat), Math.round((paramInt >> 8 & 0xFF) * paramFloat), Math.round((paramInt & 0xFF) * paramFloat), Math.round(paramFloat * 255.0F));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glEnable(3042);
      return;
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glDisable(3042);
  }
  
  public void b(float paramFloat)
  {
    if (this.jdField_a_of_type_Float == paramFloat) {
      return;
    }
    this.jdField_a_of_type_Float = paramFloat;
    if (paramFloat >= 0.95F)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      a(7681);
      return;
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glColor4f(paramFloat, paramFloat, paramFloat, paramFloat);
    a(8448);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int == paramInt) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 0) {
        this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glDisable(this.jdField_b_of_type_Int);
      }
      this.jdField_b_of_type_Int = paramInt;
    } while (this.jdField_b_of_type_Int == 0);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glEnable(this.jdField_b_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */