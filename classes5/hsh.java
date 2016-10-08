import android.net.TrafficStats;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hsh
  extends Handler
{
  public hsh(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {}
    View localView;
    do
    {
      return;
      localView = this.a.a.findViewById(2131298788);
      localObject = this.a.a.findViewById(2131298787);
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
      }
    } while (((View)localObject).getVisibility() == 0);
    paramMessage = (ImageView)this.a.a.findViewById(2131298788);
    paramMessage.setBackgroundResource(2130839555);
    ((TextView)this.a.a.findViewById(2131298789)).setText(" ");
    ((View)localObject).setVisibility(0);
    ((View)localObject).bringToFront();
    Object localObject = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject).setDuration(500L);
    ((RotateAnimation)localObject).setRepeatCount(-1);
    ((RotateAnimation)localObject).setRepeatMode(1);
    ((RotateAnimation)localObject).setStartTime(-1L);
    ((RotateAnimation)localObject).setInterpolator(new LinearInterpolator());
    paramMessage.startAnimation((Animation)localObject);
    return;
    if (localView.getVisibility() == 0)
    {
      paramMessage = localView.getAnimation();
      if (paramMessage != null) {
        paramMessage.cancel();
      }
      localView.clearAnimation();
    }
    ((View)localObject).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */