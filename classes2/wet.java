import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class wet
  extends DownloadListener
{
  public wet(PendantInfo paramPendantInfo, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "pendantDownloadListener.onCancel| task:" + paramDownloadTask);
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "pendantDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {}
    long l1;
    long l2;
    int i;
    long l3;
    do
    {
      do
      {
        return;
        Bundle localBundle = paramDownloadTask.a();
        localObject = localBundle.getString("name");
        l1 = localBundle.getLong("id");
        l2 = localBundle.getLong("targetId");
        i = localBundle.getInt("pendantResType");
        l3 = paramDownloadTask.h - paramDownloadTask.g;
        if (paramDownloadTask.a() == -1)
        {
          this.a.a(1, i, l3);
          return;
        }
        paramDownloadTask = AvatarPendantUtil.a(l1, i);
      } while (localObject == null);
      if (2 != i) {
        break;
      }
      paramDownloadTask = new File(paramDownloadTask);
    } while (((String)localObject).lastIndexOf(".zip") < 0);
    Object localObject = new File(AvatarPendantUtil.a(l1, 8));
    if (DownloaderFactory.a(paramDownloadTask, (File)localObject, true))
    {
      this.a.a();
      paramDownloadTask = this.a.a.obtainMessage(20);
      if (PendantInfo.a(paramDownloadTask, l2)) {
        this.a.a.sendMessage(paramDownloadTask);
      }
    }
    for (;;)
    {
      this.a.a(0, i, l3);
      return;
      if (paramDownloadTask.exists()) {
        paramDownloadTask.delete();
      }
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        continue;
        paramDownloadTask = this.a.a.obtainMessage(19);
        if (PendantInfo.a(paramDownloadTask, PendantInfo.m)) {
          this.a.a.sendMessage(paramDownloadTask);
        }
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "pendantDownloadListener.onStart| task:" + paramDownloadTask);
    }
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */