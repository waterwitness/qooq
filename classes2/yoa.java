import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePluginDownloader;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class yoa
  implements Downloader.DownloadListener
{
  yob jdField_a_of_type_Yob;
  
  public yoa(QZonePluginDownloader paramQZonePluginDownloader, yob paramyob)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Yob = paramyob;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = Message.obtain(this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a, 2);
    paramString.obj = this.jdField_a_of_type_Yob;
    paramString.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain(this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a, 3);
    paramString.obj = this.jdField_a_of_type_Yob;
    paramString.sendToTarget();
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = Message.obtain(this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a, 5);
    yob.a(this.jdField_a_of_type_Yob).a = paramFloat;
    paramString.obj = this.jdField_a_of_type_Yob;
    paramString.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("patch", 2, "onDownloadSucceed path:" + paramDownloadResult.getPath());
      paramString = QZonePluginUtils.e(QZonePluginDownloader.a(this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader), yob.a(this.jdField_a_of_type_Yob));
      QLog.d("patch", 2, "onDownloadSucceed path:" + paramString + " exsit:" + paramString.exists());
    }
    paramString = Message.obtain(this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a, 4);
    paramString.obj = this.jdField_a_of_type_Yob;
    paramString.sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */