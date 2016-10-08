import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mgm
  implements Runnable
{
  public mgm(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "checkChatHistoryEventConfig start...");
    }
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.app.getManager(46)).a(1);
    if ((localDownloaderInterface != null) && (localDownloaderInterface.a("http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json") == null))
    {
      Object localObject = new File(QQSettingMsgHistoryActivity.d);
      DownloadTask localDownloadTask = new DownloadTask("http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json", (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localDownloadTask.i = this.a.app.getPreferences().getLong("chatHistoryEventJsonLastModified", 0L);
        if (((Long)localObject).longValue() != localDownloadTask.i)
        {
          localDownloadTask.k = true;
          if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "checkChatHistoryEventConfig file modified local time: " + localObject + ", sp time: " + localDownloadTask.i);
          }
        }
      }
      localDownloadTask.h = true;
      localDownloadTask.n = false;
      localObject = new Bundle();
      localDownloaderInterface.a(localDownloadTask, this.a.a, (Bundle)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */