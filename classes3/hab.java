import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hab
  implements Runnable
{
  public hab(VideoLayerUI paramVideoLayerUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null) {}
    try
    {
      String str = this.a.a.a().c;
      this.a.a.b(str);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoLayerUI", 2, "pauseVideo Runnable exception", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */