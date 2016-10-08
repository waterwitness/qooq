import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class glw
  implements Animation.AnimationListener
{
  public glw(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_Glx);
    this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    if (!this.a.jdField_g_of_type_Boolean)
    {
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.a.b.setVisibility(4);
      this.a.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      if (Build.VERSION.SDK_INT >= 19) {
        this.a.findViewById(2131299103).setBackgroundColor(0);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(true);
      }
      this.a.jdField_f_of_type_Int = 0;
    }
    for (;;)
    {
      this.a.jdField_f_of_type_Boolean = false;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.jdField_a_of_type_Glx);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
      {
        this.a.b.setVisibility(0);
        if (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null)
        {
          int j = SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("RandomDoubleActivity", 2, "showMatchingView : matchStatus = " + j);
            i = j;
          }
        }
        if (i == 2) {
          RandomDoubleActivity.b(this.a);
        }
      }
      return;
      if (Build.VERSION.SDK_INT >= 19) {}
      try
      {
        if (this.a.getWindow() != null) {
          this.a.getWindow().setFlags(2048, 1024);
        }
        this.a.jdField_f_of_type_Int = this.a.e;
      }
      catch (Exception paramAnimation)
      {
        for (;;) {}
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_f_of_type_Boolean = true;
    if (this.a.jdField_g_of_type_Boolean)
    {
      this.a.b.setVisibility(0);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
      {
        this.a.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    else
    {
      this.a.jdField_g_of_type_Int = ((int)(this.a.jdField_a_of_type_AndroidViewAnimationAnimation.getDuration() / this.a.e));
      if (!this.a.jdField_g_of_type_Boolean) {
        break label188;
      }
      this.a.jdField_f_of_type_Int = 0;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.jdField_a_of_type_Glx);
      return;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
        break;
      }
      this.a.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.d.setVisibility(0);
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      break;
      label188:
      this.a.jdField_f_of_type_Int = this.a.e;
      if (Build.VERSION.SDK_INT >= 19) {
        try
        {
          if (this.a.getWindow() != null) {
            this.a.getWindow().addFlags(1024);
          }
        }
        catch (Exception paramAnimation) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */