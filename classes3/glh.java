import android.os.Build.VERSION;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class glh
  extends CameraObserver
{
  public glh(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onBeforeOpenCamera");
    }
    this.a.d.setEnabled(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onAfterCloseCamera success: " + paramBoolean);
    }
    this.a.d(2131299023);
    if (this.a.jdField_b_of_type_AndroidWidgetImageButton != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a() > 1)
      {
        this.a.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
        this.a.jdField_b_of_type_AndroidWidgetImageButton.setClickable(true);
      }
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    int i;
    if (paramBoolean)
    {
      if (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
        break label346;
      }
      if (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.jdField_b_of_type_Int != 2) {
        break label316;
      }
      i = 1;
    }
    for (;;)
    {
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().g) && (i == 0))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = 1;
        this.a.b(1);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().g) && (Build.VERSION.SDK_INT > 11)) {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(0.0F);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        this.a.d.setEnabled(false);
        this.a.d.setClickable(false);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c(true);
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().G == 3) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
        }
        return;
        label316:
        i = 0;
        break;
        this.a.d.setEnabled(true);
        this.a.d.setClickable(true);
      }
      label346:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onAfterOpenCamera success: " + paramBoolean + ", preSessionType: " + paramInt);
    }
    this.a.d.setEnabled(true);
    this.a.d.setClickable(true);
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a() > 1) && (this.a.jdField_b_of_type_AndroidWidgetImageButton != null)) {
        this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().j = true;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
        this.a.c(2131299023);
      }
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().g) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
        this.a.b(2);
      }
      this.a.e(10);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_b_of_type_Int);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
    if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
    }
  }
  
  protected void b()
  {
    this.a.d.setEnabled(false);
    this.a.d.setClickable(false);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.a.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.a.jdField_b_of_type_AndroidWidgetImageButton.setClickable(true);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  protected void c()
  {
    this.a.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
    this.a.jdField_b_of_type_AndroidWidgetImageButton.setClickable(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */