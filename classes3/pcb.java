import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pcb
  implements View.OnTouchListener
{
  public pcb(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.a.a.isPlaying()) {
        if (NewFlowCameraActivity.a(this.a))
        {
          this.a.i = false;
          this.a.a.pause();
          NewFlowCameraActivity.b(this.a).setVisibility(0);
        }
      }
      while (!NewFlowCameraActivity.a(this.a)) {
        return true;
      }
      this.a.a.start();
      this.a.i = true;
      NewFlowCameraActivity.b(this.a).setVisibility(4);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */