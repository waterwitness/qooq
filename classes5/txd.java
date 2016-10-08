import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.BreatheEffectView.BreatheListener;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;

public class txd
  implements BreatheEffectView.BreatheListener
{
  public txd(ProfileTagView paramProfileTagView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    Object localObject1;
    if (ProfileTagView.a(this.a) != null)
    {
      localObject1 = ProfileTagView.a(this.a);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
        {
          RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)((View)localObject2).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.a = ProfileTagView.a(this.a).x;
            localLayoutParams.b = ProfileTagView.a(this.a).y;
            ((View)localObject2).setLayoutParams(localLayoutParams);
          }
        }
        i += 1;
      }
      this.a.b();
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = (FrameLayout)this.a.a.findViewById(16908290);
      if (localObject1 != null)
      {
        ProfileTagView.a(this.a, ((FrameLayout)localObject1).getBackground());
        ((FrameLayout)localObject1).setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */