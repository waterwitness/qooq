import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kpc
  implements Runnable
{
  public kpc(BaseChatPie paramBaseChatPie, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, new View(this.jdField_a_of_type_AndroidAppActivity));
    BaseChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setOnTouchListener(new kpd(this));
    this.jdField_a_of_type_AndroidAppActivity.addContentView(BaseChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie), new ViewGroup.LayoutParams(-1, -1));
    View localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0);
    AnimationSet localAnimationSet = new AnimationSet(false);
    long[] arrayOfLong = new long[6];
    long[] tmp93_92 = arrayOfLong;
    tmp93_92[0] = 200L;
    long[] tmp99_93 = tmp93_92;
    tmp99_93[1] = 300L;
    long[] tmp105_99 = tmp99_93;
    tmp105_99[2] = 200L;
    long[] tmp111_105 = tmp105_99;
    tmp111_105[3] = 300L;
    long[] tmp117_111 = tmp111_105;
    tmp117_111[4] = 200L;
    long[] tmp123_117 = tmp117_111;
    tmp123_117[5] = 300L;
    tmp123_117;
    int i = 0;
    long l = 0L;
    while (i < arrayOfLong.length)
    {
      if (i % 2 != 0)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 10.0F);
        localTranslateAnimation.setDuration(arrayOfLong[i]);
        localTranslateAnimation.setStartOffset(l);
        localTranslateAnimation.setInterpolator(new CycleInterpolator((float)localTranslateAnimation.getDuration() / 60.0F));
        localAnimationSet.addAnimation(localTranslateAnimation);
      }
      l += arrayOfLong[i];
      i += 1;
    }
    localAnimationSet.setAnimationListener(new kpe(this));
    localView.startAnimation(localAnimationSet);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */