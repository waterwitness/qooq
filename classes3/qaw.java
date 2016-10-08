import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageRoamConstants;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class qaw
  implements Runnable
{
  public qaw(MessageRoamManager paramMessageRoamManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)MessageRoamManager.a(this.a).getManager(46)).a(1);
    if ((localDownloaderInterface != null) && (localDownloaderInterface.a(MessageRoamConstants.D) == null))
    {
      Object localObject = new File(MessageRoamConstants.E);
      DownloadTask localDownloadTask = new DownloadTask(MessageRoamConstants.D, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localDownloadTask.i = MessageRoamManager.a(this.a).getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localDownloadTask.i)
        {
          localDownloadTask.k = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localDownloadTask.i);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */