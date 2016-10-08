import android.view.animation.Interpolator;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rms
  implements Interpolator
{
  public rms(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    float f = paramFloat * 2.0F;
    if (f >= 2.0F) {
      return 1.0F;
    }
    paramFloat = 0.45000002F / 4.0F;
    if (f < 1.0F)
    {
      f -= 1.0F;
      d = Math.pow(2.0D, 10.0F * f);
      return (float)(Math.sin((f - paramFloat) * 6.283185307179586D / 0.45000002F) * (-0.5D * d));
    }
    f -= 1.0F;
    double d = Math.pow(2.0D, -10.0F * f);
    return (float)(Math.sin((f - paramFloat) * 6.283185307179586D / 0.45000002F) * (0.5D * d)) + 1.0F;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */