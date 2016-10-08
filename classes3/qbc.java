import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class qbc
  extends DownloadListener
{
  public qbc(NearbyFlowerManager paramNearbyFlowerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("nearby_flower_task_id");
    if (QLog.isColorLevel()) {
      QLog.d(NearbyFlowerManager.jdField_a_of_type_JavaLangString, 2, "onDone Id=" + str + " task:" + paramDownloadTask);
    }
    if (paramDownloadTask.z == 0)
    {
      paramDownloadTask = new File(NearbyFlowerUtil.b(str));
      if (!paramDownloadTask.exists()) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.a(paramDownloadTask.getAbsolutePath(), AppConstants.cY, false);
        paramDownloadTask.delete();
        this.a.c.put(str, Integer.valueOf(3));
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController != null)) {}
        return;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(NearbyFlowerManager.jdField_a_of_type_JavaLangString, 2, "mDownloaderListener.onDone, id=" + str + ", when uncompressZip, ", localIOException);
          this.a.c.put(str, Integer.valueOf(4));
          return;
        }
        QLog.i(NearbyFlowerManager.jdField_a_of_type_JavaLangString, 1, "mDownloaderListener, uncompressZip failed, id=" + str);
        continue;
      }
      finally
      {
        paramDownloadTask.delete();
      }
      this.a.c.put(localObject, Integer.valueOf(4));
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */