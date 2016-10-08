import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.HeartAnimatorListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svb
  extends Animation
{
  public float a;
  public int a;
  public PathMeasure a;
  public View a;
  public Interpolator a;
  public HeartAnimator.Config a;
  public HeartAnimator.HeartAnimatorListener a;
  public float b;
  
  public svb(Path paramPath, float paramFloat, View paramView1, View paramView2, HeartAnimator.Config paramConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure(paramPath, false);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramFloat;
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config = paramConfig;
    paramView1.setLayerType(2, null);
  }
  
  private static float a(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return (float)Math.pow(paramFloat, 2.0D);
    case 1: 
      if (paramFloat < 0.8D) {
        return 0.0F;
      }
      return 5.0F * paramFloat - 4.0F;
    }
    return 0.5F * paramFloat + 0.5F;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    Object localObject = paramTransformation.getMatrix();
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.getMatrix(this.jdField_a_of_type_Float * paramFloat, (Matrix)localObject, 1);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      f = this.b;
      HeartAnimator.Config localConfig = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config;
      ((View)localObject).setRotation(f * paramFloat * HeartAnimator.Config.b);
    }
    float f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(paramFloat);
    this.jdField_a_of_type_AndroidViewView.setScaleX(f);
    this.jdField_a_of_type_AndroidViewView.setScaleY(f);
    paramTransformation.setAlpha(1.0F - a(this.jdField_a_of_type_Int, paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */