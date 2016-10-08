import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;

public final class yrl
  implements ThreadPool.Job
{
  public yrl(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    QzoneOfflineCacheHelper.a().a(this.a, true);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */