import android.view.animation.Interpolator;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmu
  implements Interpolator
{
  public rmu(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return 1.0F - paramFloat * (paramFloat * paramFloat * paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */