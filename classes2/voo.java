import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

public class voo
  implements IVideoViewBase.IVideoViewCallBack
{
  public voo(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.e(TVKTroopVideoManager.jdField_a_of_type_JavaLangString, 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.e(TVKTroopVideoManager.jdField_a_of_type_JavaLangString, 2, "onSurfaceDestory");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    this.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */