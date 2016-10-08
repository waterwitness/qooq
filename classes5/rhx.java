import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;

public class rhx
  extends DownloadListener
{
  public rhx(MessengerService paramMessengerService, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Bundle localBundle = paramDownloadTask.a();
    localBundle.putString("status", "onDone");
    localBundle.putLong("readSize", paramDownloadTask.b);
    localBundle.putInt("result", paramDownloadTask.a());
    localBundle.putLong("downloadTime", paramDownloadTask.h - paramDownloadTask.g);
    localBundle.putInt("errCode", paramDownloadTask.z);
    this.a.a.a(localBundle);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    Bundle localBundle = paramDownloadTask.a();
    localBundle.putString("status", "onProgress");
    localBundle.putLong("readSize", paramDownloadTask.b);
    this.a.a.a(localBundle);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */