import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jft
  implements View.OnTouchListener
{
  public jft(Context paramContext, URLImageView paramURLImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968655);
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(paramView);
    }
    for (;;)
    {
      return false;
      if (i == 1)
      {
        paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968656);
        this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(paramView);
      }
      else if (i == 3)
      {
        paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968656);
        this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(paramView);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */