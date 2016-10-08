import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import mqq.os.MqqHandler;

public class oti
  extends DownloadListener
{
  public oti(PreloadImgManager paramPreloadImgManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    ThreadManager.a().post(new otj(this, paramDownloadTask));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */