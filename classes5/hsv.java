import android.net.TrafficStats;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hsv
  extends Handler
{
  public hsv(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    ImageView localImageView = (ImageView)this.a.a.findViewById(2131298788);
    ViewGroup localViewGroup = (ViewGroup)this.a.a.findViewById(2131298787);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ((TextView)this.a.a.findViewById(2131298789)).setText(this.a.a());
      return;
    case 2: 
      this.a.b = TrafficStats.getTotalRxBytes();
      return;
    case 4: 
      localViewGroup.setVisibility(0);
      localViewGroup.bringToFront();
      paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramMessage.setDuration(500L);
      paramMessage.setRepeatCount(-1);
      paramMessage.setRepeatMode(1);
      paramMessage.setStartTime(-1L);
      paramMessage.setInterpolator(new LinearInterpolator());
      localImageView.startAnimation(paramMessage);
      return;
    }
    if (localImageView.getVisibility() == 0)
    {
      paramMessage = localImageView.getAnimation();
      if (paramMessage != null) {
        paramMessage.cancel();
      }
      localImageView.clearAnimation();
    }
    localViewGroup.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */