import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class huc
  extends DownloadListener
{
  public huc(EcShopAssistantManager paramEcShopAssistantManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.z == 0) && (this.a.a != null))
    {
      if (this.a.a != null) {
        this.a.a.getPreferences().edit().putLong("last_modified_time", paramDownloadTask.i).commit();
      }
      if (paramDownloadTask.D == 200)
      {
        EcShopAssistantManager.c();
        this.a.a.runOnUiThread(new hud(this));
      }
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(EcShopAssistantManager.l);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("EcShopAssistantManager", 2, "download onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.z + "," + "httpCode=" + paramDownloadTask.D + ",local lastModify=" + l + ",server lastModify=" + paramDownloadTask.i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\huc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */