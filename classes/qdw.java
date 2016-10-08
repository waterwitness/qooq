import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;

public class qdw
  implements Runnable
{
  public qdw(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface.a(this.a);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    localIntentFilter.addAction("com.tecent.qzone.clearAlbumRedTouch");
    QQAppInterface.c(this.a).registerReceiver(QQAppInterface.a(this.a), localIntentFilter);
    VideoBroadcastReceiver.a(this.a);
    if (this.a.e()) {
      PtvTemplateManager.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */