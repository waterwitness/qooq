import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class pdo
  implements Runnable
{
  pdo(pdn parampdn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.e()) {}
    for (;;)
    {
      return;
      File localFile = new File(GloableValue.c + File.separator + ".nomedia");
      if (!localFile.exists()) {}
      try
      {
        localFile.createNewFile();
        localRMVideoStateMgr.a.postDelayed(this.a.a, 10000L);
        localRMVideoStateMgr.j();
        localRMVideoStateMgr.k();
        localRMVideoStateMgr.i();
        try
        {
          AVCodec.get().init();
          this.a.c = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            localUnsatisfiedLinkError.printStackTrace();
            this.a.c = false;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */