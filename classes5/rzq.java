import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rzq
  implements Runnable
{
  public rzq(UniformDownloadMgr paramUniformDownloadMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    UniformDownloaderAppBabySdk.a().a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */