import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class qqc
  implements Runnable
{
  public qqc(ArkAppCGI paramArkAppCGI, qqh paramqqh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      DownloaderInterface localDownloaderInterface = ((DownloaderFactory)ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI).getManager(46)).a(1);
      File localFile = new File(ArkAppCenter.c + "/tmp");
      localFile.mkdirs();
      localFile = File.createTempFile("ark", ".tmp", localFile);
      this.jdField_a_of_type_Qqh.jdField_a_of_type_JavaIoFile = localFile;
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_Qqh.jdField_a_of_type_JavaLangString, localFile);
      localDownloadTask.l = true;
      localDownloadTask.n = true;
      Bundle localBundle = new Bundle();
      localDownloaderInterface.a(localDownloadTask, new qqd(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.jdField_a_of_type_Qqh.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Qqh, false, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */