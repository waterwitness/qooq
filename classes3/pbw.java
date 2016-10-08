import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pbw
  implements View.OnClickListener
{
  public pbw(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a.isPlaying())
    {
      this.a.i = false;
      this.a.a.pause();
      NewFlowCameraActivity.b(this.a).setVisibility(0);
      return;
    }
    this.a.i = true;
    NewFlowCameraActivity.a(this.a).setVisibility(8);
    this.a.a.start();
    NewFlowCameraActivity.b(this.a).setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */