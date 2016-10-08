import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ibb
  implements URLDrawableDownListener
{
  public ibb(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, URLImageView paramURLImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayerType(2, null);
        paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
        paramView.setDuration(600L);
        paramView.start();
        paramView.addListener(new ibc(this));
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    paramURLDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramURLDrawable.setDuration(600L);
    paramView.startAnimation(paramURLDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */