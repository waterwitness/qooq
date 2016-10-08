import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class pax
  implements View.OnTouchListener
{
  public pax(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.u) {}
    do
    {
      do
      {
        return false;
      } while (!this.a.n);
      NewFlowCameraActivity.d(this.a);
      this.a.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    } while (paramView.getId() != 2131301332);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.a.C = false;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_DOWN, event = " + paramMotionEvent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_DOWN isTemplateMode " + this.a.d);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new pay(this), 300L);
      return false;
    }
    this.a.k = false;
    this.a.C = true;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_UP, event = " + paramMotionEvent);
    }
    paramView = this.a.jdField_a_of_type_AndroidViewVelocityTracker;
    paramView.computeCurrentVelocity(1000, this.a.J);
    int i = (int)paramView.getXVelocity();
    if ((!this.a.p) && (Math.abs(i) > this.a.I)) {
      this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.f(-i);
    }
    NewFlowCameraActivity.e(this.a);
    if (this.a.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      paramView = this.a.jdField_b_of_type_AndroidWidgetImageView.getAnimation();
      if (paramView != null)
      {
        paramView.cancel();
        paramView.setAnimationListener(null);
      }
      this.a.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.a.p) {}
    for (;;)
    {
      this.a.q = true;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
        this.a.p = false;
      }
      NewFlowCameraActivity.a(this.a, SystemClock.uptimeMillis());
      NewFlowCameraActivity.f(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_UP isBlueAnimEnd=" + this.a.jdField_b_of_type_Boolean);
      }
      if (!this.a.jdField_b_of_type_Boolean) {
        break;
      }
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a()) {
        break label649;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK()");
      }
      this.a.r();
      return false;
      paramView = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
      paramView.width = AIOUtils.a(80.0F, this.a.getResources());
      paramView.height = AIOUtils.a(80.0F, this.a.getResources());
      paramView.addRule(13);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.width = AIOUtils.a(50.0F, this.a.getResources());
      paramView.height = AIOUtils.a(50.0F, this.a.getResources());
      paramView.addRule(13);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    label649:
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK nop");
    }
    this.a.a(this.a, 2131370344);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.lockFrameSync();
    this.a.t();
    this.a.r();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */