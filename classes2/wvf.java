import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadManager;

public final class wvf
  implements Runnable
{
  public wvf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadManager.a().c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */