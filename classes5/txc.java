import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class txc
  implements ValueAnimation.AnimationUpdateListener
{
  public txc(ProfileTagView paramProfileTagView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramTransformation = ProfileTagView.a(this.a).getLayoutParams();
    if (paramTransformation != null)
    {
      paramTransformation.height = paramInteger.intValue();
      ProfileTagView.a(this.a).setLayoutParams(paramTransformation);
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramInteger = (FrameLayout)this.a.a.findViewById(16908290);
        if ((paramInteger != null) && (paramInteger.getChildCount() > 0))
        {
          paramInteger = paramInteger.getChildAt(0);
          if (paramInteger != null)
          {
            paramInteger = paramInteger.getBackground();
            if ((paramInteger instanceof BitmapDrawable))
            {
              int j = (int)(255.0F * paramFloat);
              int i = j;
              if (paramValueAnimation == ProfileTagView.a(this.a)) {
                i = 255 - j;
              }
              paramInteger.setAlpha(i);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */