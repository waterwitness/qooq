import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class orc
  implements Runnable
{
  public orc(PeakService paramPeakService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "peak service start MediaScanner.doScan()");
    }
    MediaScanner.a(BaseApplicationImpl.getContext()).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */