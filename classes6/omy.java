import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class omy
  extends DownloadListener
{
  public omy(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.z);
    }
    int i = paramDownloadTask.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.a;
      if (!AvatarPendantUtil.a.equals(str)) {
        break label291;
      }
      if ((paramDownloadTask.z != 0) || (paramDownloadTask.D != 200)) {
        break label238;
      }
      str = AvatarPendantUtil.b + "/icon.zip";
      File localFile = new File(AvatarPendantUtil.c);
      if (DownloaderFactory.a(new File(str), localFile, false)) {
        break label216;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + paramDownloadTask.D + ", url: " + paramDownloadTask.a);
      }
      FileUtils.a(AvatarPendantUtil.b);
    }
    label216:
    label238:
    label291:
    do
    {
      return;
      str = paramDownloadTask.a.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + paramDownloadTask.D + ", url: " + paramDownloadTask.a);
      }
      FileUtils.a(AvatarPendantUtil.b);
      return;
      if ((ClubContentJsonTask.m.c.equals(str)) && (paramDownloadTask.z == 0) && (paramDownloadTask.D == 200))
      {
        AvatarPendantActivity.a(this.a, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + paramDownloadTask.a + ",errCode:" + paramDownloadTask.z + ",httpCode:" + paramDownloadTask.D);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */