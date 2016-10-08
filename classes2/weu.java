import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class weu
  extends DownloadListener
{
  public weu(PendantInfo paramPendantInfo, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    File localFile = new File(AvatarPendantUtil.a(this.a.a, 4));
    long l1 = paramDownloadTask.a().getLong("targetId");
    int i = paramDownloadTask.a().getInt("pendantResType");
    if ((paramDownloadTask.b()) || (paramDownloadTask.a() == -1))
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    if (this.a.a(localFile, i)) {
      this.a.a(l1, i);
    }
    l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    this.a.a(0, 4, l1 - l2);
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\weu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */