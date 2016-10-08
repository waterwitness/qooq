import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class xuo
  implements Interpolator
{
  public xuo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */