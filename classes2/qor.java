import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qor
  extends Handler
{
  public qor(ARGLSurfaceView paramARGLSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((this.a.jdField_a_of_type_AndroidHardwareCamera != null) && (!this.a.jdField_a_of_type_Boolean))
      {
        ThreadManager.a(new qos(this), 8, null, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ARGLSurfaceView", 2, "AUTO_FOCUS_INTERVAL. mCamera = " + this.a.jdField_a_of_type_AndroidHardwareCamera + ", isTracked = " + this.a.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */