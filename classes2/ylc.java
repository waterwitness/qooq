import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVideoDownloadActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class ylc
  implements EarlyDownloadManager.EarlyDownLoadListener
{
  public ylc(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(QZoneVideoDownloadActivity.jdField_a_of_type_JavaLangString, 4, "so download, onDownloadBegin");
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isDevelopLevel()) {
      QLog.d(QZoneVideoDownloadActivity.jdField_a_of_type_JavaLangString, 4, "so download, onDownloadProgress, " + i);
    }
    Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 1001, i, 2).sendToTarget();
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(QZoneVideoDownloadActivity.jdField_a_of_type_JavaLangString, 4, "so download, onDownloadFinish, result=" + paramBoolean1 + ", errCode=" + paramInt + ", mIsSoDownloaded=" + QZoneVideoDownloadActivity.b(this.a));
    }
    if ((paramBoolean1) && (!QZoneVideoDownloadActivity.b(this.a).get()))
    {
      QZoneVideoDownloadActivity.b(this.a).set(true);
      QZoneVideoDownloadActivity.a(this.a);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(QZoneVideoDownloadActivity.jdField_a_of_type_JavaLangString, 4, "so download, onDownloadCancel");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */