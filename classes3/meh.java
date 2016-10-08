import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.biz.common.offline.util.OfflineDownloaderManager;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class meh
  implements Runnable
{
  public meh(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OfflineDownloaderManager.a().a().a(this.a.getApplicationContext(), this.a.s, QQMapConstants.i, this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\meh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */