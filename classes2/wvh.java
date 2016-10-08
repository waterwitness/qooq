import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public class wvh
  implements Runnable
{
  public wvh(DownloadManager paramDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.a)
    {
      if (!MyAppApi.a().b()) {
        this.a.a(true);
      }
      this.a.a = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */