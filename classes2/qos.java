import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class qos
  implements Runnable
{
  qos(qor paramqor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.a(this.a.a.getWidth() / 2.0F, this.a.a.getHeight() / 2.0F, 400.0F);
    if (QLog.isColorLevel()) {
      QLog.d("ARGLSurfaceView", 2, "Camera auto focus when it is not tracked for 3000ms.");
    }
    ARGLSurfaceView.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */