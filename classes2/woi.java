import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class woi
  extends Animation
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private float b;
  
  public woi(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.b;
    float f3 = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb((int)((f1 + (f2 - f3) * paramFloat) * 255.0F), 255, 255, 255));
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */