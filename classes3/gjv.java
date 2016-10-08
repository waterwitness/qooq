import com.tencent.av.opengl.glrenderer.GLES11Canvas;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gjv
{
  public float a;
  public gjv a;
  public float[] a;
  
  private gjv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
  }
  
  public void a(GLES11Canvas paramGLES11Canvas)
  {
    if (this.jdField_a_of_type_Float >= 0.0F) {
      paramGLES11Canvas.a(this.jdField_a_of_type_Float);
    }
    if (this.jdField_a_of_type_ArrayOfFloat[0] != Float.NEGATIVE_INFINITY) {
      System.arraycopy(this.jdField_a_of_type_ArrayOfFloat, 0, GLES11Canvas.a(paramGLES11Canvas), 0, 16);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */