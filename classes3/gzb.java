import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class gzb
  implements Animation.AnimationListener
{
  public gzb(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_Gzc);
    this.a.f.clearAnimation();
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.a.m), Boolean.valueOf(false), Long.valueOf(paramAnimation.getDuration()) });
    }
    if (!this.a.m)
    {
      this.a.f.setVisibility(4);
      if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 19) {
          this.a.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        }
        if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(true);
        }
        this.a.E = 0;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramAnimation = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          if (((paramAnimation.F == 2) || (paramAnimation.F == 1)) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
            this.a.s(this.a.y);
          }
        }
      }
    }
    for (;;)
    {
      this.a.s = false;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.jdField_a_of_type_Gzc);
      return;
      this.a.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      break;
      if (this.a.jdField_e_of_type_AndroidViewView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoControlUI", 2, "onAnimationEnd, change member list ui to visible");
        }
        this.a.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      if (Build.VERSION.SDK_INT >= 19) {}
      try
      {
        paramAnimation = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramAnimation != null) && (paramAnimation.getWindow() != null)) {
          paramAnimation.getWindow().setFlags(2048, 1024);
        }
      }
      catch (Exception paramAnimation)
      {
        for (;;) {}
      }
      this.a.E = this.a.D;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramAnimation = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        if (((paramAnimation.F == 2) || (paramAnimation.F == 1)) && (Build.VERSION.SDK_INT >= 11)) {
          this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.s = true;
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.a.m), Boolean.valueOf(true), Long.valueOf(paramAnimation.getDuration()) });
    }
    this.a.F = ((int)(this.a.c.getDuration() / this.a.D));
    if (this.a.m) {
      this.a.E = 0;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.jdField_a_of_type_Gzc);
      return;
      this.a.E = this.a.D;
      if (Build.VERSION.SDK_INT >= 19) {
        try
        {
          paramAnimation = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((paramAnimation != null) && (paramAnimation.getWindow() != null)) {
            paramAnimation.getWindow().addFlags(1024);
          }
        }
        catch (Exception paramAnimation) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */