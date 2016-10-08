import android.view.animation.Interpolator;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmt
  implements Interpolator
{
  rmt(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.36363637F) {
      return 7.5625F * paramFloat * paramFloat;
    }
    if (paramFloat < 0.72727275F)
    {
      paramFloat -= 0.54545456F;
      return paramFloat * (7.5625F * paramFloat) + 0.75F;
    }
    if (paramFloat < 0.90909094F)
    {
      paramFloat -= 0.8181818F;
      return paramFloat * (7.5625F * paramFloat) + 0.9375F;
    }
    paramFloat -= 0.95454544F;
    return paramFloat * (7.5625F * paramFloat) + 0.984375F;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */