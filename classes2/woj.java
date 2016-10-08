import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class woj
  extends Animation
{
  public woj(ShaderAnimLayout paramShaderAnimLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.a.jdField_a_of_type_Boolean == true) {}
    for (this.a.jdField_a_of_type_Float = (1.0F - paramFloat);; this.a.jdField_a_of_type_Float = paramFloat)
    {
      this.a.invalidate();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */