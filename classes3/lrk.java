import android.text.TextUtils;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import cooperation.comic.PluginPreloader;
import cooperation.comic.QQComicPreloadManager;
import cooperation.qqreader.QRProcessManager;

public class lrk
  implements Runnable
{
  public lrk(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a.a.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      long l = WebProcessManager.a((String)localObject);
      if (System.currentTimeMillis() - l < 604800000L) {
        WebProcessManager.a(Leba.a(), "key_health_dns_parse");
      }
      l = WebProcessManager.c((String)localObject);
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(Leba.b(), "key_gamecenter_dns_parse");
      }
    }
    localObject = (QRProcessManager)this.a.a.getManager(128);
    if (localObject != null) {
      ((QRProcessManager)localObject).a(6);
    }
    localObject = (QQComicPreloadManager)this.a.a.getManager(141);
    if (localObject != null) {
      PluginPreloader.a(((QQComicPreloadManager)localObject).a(6));
    }
    if (LebaShowListManager.a().a()) {
      SearchProtocol.a(this.a.a(), this.a.a, 10800000L, "Leba");
    }
    ThreadManager.a(new lrl(this), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */