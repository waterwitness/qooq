import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ouc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ouc(CommonHbFragment paramCommonHbFragment, View paramView, ImageView paramImageView, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int k = this.jdField_a_of_type_AndroidViewView.getHeight();
    int j = (int)(k * 3.076923076923077D + 0.5D);
    int i = j;
    if (j > CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment)) {
      i = CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment);
    }
    if ((i > 0) && (k > 0))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, k);
      localLayoutParams.gravity = 5;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.postInvalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */