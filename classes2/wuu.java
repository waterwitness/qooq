import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class wuu
  implements Runnable
{
  public wuu(DownloadListener paramDownloadListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadManager.a().b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */