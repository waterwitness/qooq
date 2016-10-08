import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class pny
  implements SurfaceHolder.Callback
{
  pny(pnx parampnx, QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "CameraView surfaceCreated");
      this.jdField_a_of_type_Pnx.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
      if (!this.jdField_a_of_type_Pnx.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Pnx.c();
        return;
      }
      this.jdField_a_of_type_Pnx.setVisibility(4);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Pnx.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest.jdField_a_of_type_AndroidViewSurfaceHolder = null;
    try
    {
      QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "CameraView surfaceDestroyed");
      this.jdField_a_of_type_Pnx.a();
      return;
    }
    catch (Exception paramSurfaceHolder) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */