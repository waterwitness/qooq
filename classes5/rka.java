import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rka
  implements Runnable
{
  public rka(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      EmoticonMainPanel.a(this.a).setVisibility(0);
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(EmoticonMainPanel.a(this.a), "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(EmoticonMainPanel.a(this.a), "alpha", new float[] { 1.0F, 0.6F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(EmoticonMainPanel.a(this.a), "rotation", new float[] { 0.0F, 50.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(EmoticonMainPanel.a(this.a), "alpha", new float[] { 0.6F, 1.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(EmoticonMainPanel.a(this.a), "rotation", new float[] { 50.0F, 0.0F });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator3.setDuration(400L);
    localObjectAnimator3.setInterpolator(new LinearInterpolator());
    localObjectAnimator4.setDuration(400L);
    localObjectAnimator4.setInterpolator(new LinearInterpolator());
    localObjectAnimator5.setDuration(400L);
    localObjectAnimator5.setInterpolator(new LinearInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator4).after(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator5).after(localObjectAnimator3);
    localAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator3).after(localObjectAnimator1);
    EmoticonMainPanel.a(this.a).setVisibility(0);
    localAnimatorSet.start();
    this.a.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", true).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */