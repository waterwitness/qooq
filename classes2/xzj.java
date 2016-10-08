import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;

class xzj
  implements SurfaceHolder.Callback
{
  xzj(xzi paramxzi, C2BTakePhotoActivity paramC2BTakePhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.a = paramSurfaceHolder;
    if (!this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.e)
    {
      this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.g();
      return;
    }
    this.jdField_a_of_type_Xzi.setVisibility(4);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.a = null;
    if (this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.b) {
      this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.a(true);
    }
    while (this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.e) {
      return;
    }
    this.jdField_a_of_type_Xzi.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.h();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */