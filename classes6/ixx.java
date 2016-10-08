import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.control.ColorPicker;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixx
  implements BaseLayer.OnLayerTouchListener
{
  private ixx(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(AlphaAnimation paramAlphaAnimation)
  {
    DoodleLayout.d(this.a).startAnimation(paramAlphaAnimation);
    DoodleLayout.c(this.a).startAnimation(paramAlphaAnimation);
    DoodleLayout.e(this.a).startAnimation(paramAlphaAnimation);
    DoodleLayout.b(this.a).startAnimation(paramAlphaAnimation);
    DoodleLayout.a(this.a).startAnimation(paramAlphaAnimation);
    DoodleLayout.a(this.a).startAnimation(paramAlphaAnimation);
  }
  
  public boolean a(LineLayer paramLineLayer, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      DoodleLayout.a(this.a, 5);
      paramLineLayer = new AlphaAnimation(1.0F, 0.0F);
      paramLineLayer.setDuration(500L);
      paramLineLayer.setFillAfter(true);
      a(paramLineLayer);
      return false;
    }
    DoodleLayout.a(this.a, 2);
    if (paramLineLayer.d() > 0) {
      DoodleLayout.a(this.a, new View[] { DoodleLayout.c(this.a) });
    }
    paramLineLayer = new AlphaAnimation(0.0F, 1.0F);
    paramLineLayer.setDuration(500L);
    paramLineLayer.setFillAfter(true);
    paramLineLayer.setAnimationListener(new ixy(this));
    a(paramLineLayer);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */