import android.hardware.Camera;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARFragment;
import com.tencent.mobileqq.ar.ARListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;

public class qoo
  implements Runnable
{
  public qoo(ARFragment paramARFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (!ARDeviceController.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARFragment", 2, "ARDeviceController is not ready, wait 100ms.");
      }
      j = i + 1;
    }
    while (!this.a.a) {
      try
      {
        int j;
        Thread.currentThread();
        Thread.sleep(100L);
        i = j;
        if (j < 30) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ARFragment", 2, "ARDeviceController is not ready, time out.");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    long l1;
    synchronized (this.a)
    {
      l1 = System.currentTimeMillis();
      Camera localCamera = ARFragment.a(this.a);
      if (localCamera != null) {}
    }
    try
    {
      ARFragment.a(this.a, CameraUtil.a());
      if (ARFragment.a(this.a) != null) {
        ARFragment.a(this.a);
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ARFragment", 2, "startAR cost : " + (l2 - l1));
      }
      return;
      localObject = finally;
      throw ((Throwable)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (ARFragment.a(this.a) != null) {
          ARFragment.a(this.a).a(1);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qoo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */