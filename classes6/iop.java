import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iop
  implements View.OnTouchListener
{
  public iop(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.a.a.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */