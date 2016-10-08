import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadManager;

public class rpy
  implements Runnable
{
  public rpy(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadManager.a().b(UniformDownloadActivity.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */