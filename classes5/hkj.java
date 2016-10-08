import android.os.Handler;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.now.NowVideoView;
import com.tencent.biz.now.NowVideoView.ThirdDataSourceAdapter;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class hkj
  implements QQLiveDrawable.OnStateListener
{
  public hkj(NowVideoView paramNowVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onStateChange(int paramInt, Object paramObject)
  {
    this.a.g = this.a.h;
    this.a.h = paramInt;
    ImageView localImageView = this.a.jdField_a_of_type_AndroidWidgetImageView;
    boolean bool = NowVideoController.a().b;
    if (paramInt == 3)
    {
      if (this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
      {
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(500L);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
        paramObject = new LinearInterpolator();
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator((Interpolator)paramObject);
      }
      if (localImageView != null)
      {
        localImageView.setVisibility(0);
        localImageView.setImageResource(2130839555);
        localImageView.clearAnimation();
        this.a.jdField_a_of_type_AndroidOsHandler.post(new hkk(this, localImageView));
      }
    }
    for (;;)
    {
      this.a.a(this.a.g, this.a.h);
      return;
      if (paramInt == 0)
      {
        if (localImageView != null)
        {
          localImageView.clearAnimation();
          localImageView.setImageResource(2130839556);
          localImageView.setVisibility(0);
        }
      }
      else if (paramInt == 4)
      {
        if ((localImageView != null) && (!bool))
        {
          localImageView.clearAnimation();
          localImageView.setImageResource(2130839556);
          localImageView.setVisibility(0);
        }
      }
      else if (paramInt == 2)
      {
        if (localImageView != null)
        {
          localImageView.clearAnimation();
          localImageView.setVisibility(8);
        }
        this.a.i = 0;
        this.a.j = 0;
        this.a.a(1);
      }
      else if (paramInt == 5)
      {
        if (localImageView != null)
        {
          localImageView.clearAnimation();
          localImageView.setVisibility(0);
          localImageView.setImageResource(2130839553);
        }
        if (!NetworkUtil.h(this.a.getContext()))
        {
          QQToast.a(this.a.getContext(), 1, 2131369041, 0).b(NowVideoView.k);
          return;
        }
        if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1));
          this.a.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter.a();
        }
        if ((this.a.jdField_a_of_type_JavaUtilList.size() == 0) && ((paramObject instanceof QQLiveDrawable.ErrorInfo)))
        {
          paramObject = (QQLiveDrawable.ErrorInfo)paramObject;
          QLog.d("NowVideoView", 2, "ErrorInf = " + ((QQLiveDrawable.ErrorInfo)paramObject).toString());
        }
      }
      else if (paramInt != 1) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */