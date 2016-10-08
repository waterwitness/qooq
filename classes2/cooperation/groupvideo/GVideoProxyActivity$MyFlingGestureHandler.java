package cooperation.groupvideo;

import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GVideoProxyActivity$MyFlingGestureHandler
  extends FlingGestureHandler
{
  boolean a;
  
  public GVideoProxyActivity$MyFlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (!a()) {
      a();
    }
    this.mTopLayout.setInterceptTouchFlag(paramBoolean);
  }
  
  public void flingLToR()
  {
    if (this.a) {
      super.flingLToR();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\groupvideo\GVideoProxyActivity$MyFlingGestureHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */