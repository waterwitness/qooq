import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.SucDownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;
import com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class sai
  implements Runnable
{
  public sai(UniformDownloadPkgInstallReceiver paramUniformDownloadPkgInstallReceiver, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = UniformDownloadMgr.a().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          UniformDownloadMgr.SucDownloadInfo localSucDownloadInfo = (UniformDownloadMgr.SucDownloadInfo)((Iterator)localObject).next();
          if (localSucDownloadInfo != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.b + " notificationId:" + localSucDownloadInfo.a);
            UniformDownloadNfn.a().c(localSucDownloadInfo.a, null);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */