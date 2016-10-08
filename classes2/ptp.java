import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class ptp
  extends DownloadListener
{
  public ptp(QQFrameZipDecoder paramQQFrameZipDecoder, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a()) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "downloadZip onDone task.getStatus()->" + paramDownloadTask.a());
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a = 2;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */