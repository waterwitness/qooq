import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.qphone.base.util.QLog;

public class twv
  extends GestureDetector.SimpleOnGestureListener
{
  public twv(ProfileTagView paramProfileTagView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    ProfileTagView.a(this.a, true);
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (Math.abs(paramFloat1) > ProfileTagView.a(this.a))
    {
      if ((paramFloat1 > 0.0F) && (ProfileTagView.a(this.a))) {
        if (ProfileTagView.b(this.a))
        {
          this.a.f();
          ProfileTagView.a(this.a).b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (ProfileTagView.a(this.a))) {
        return true;
      }
      ProfileTagView.b(this.a);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */