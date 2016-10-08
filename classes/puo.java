import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class puo
  implements TbsListener
{
  public puo(BrowserAppInterface paramBrowserAppInterface, SharedPreferences paramSharedPreferences, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 120))
    {
      if (BrowserAppInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
      {
        QbSdk.setTbsListener(null);
        int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
        long l2 = System.currentTimeMillis();
        long l3 = this.jdField_a_of_type_Long;
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putInt("tbs_download_count", i + 1);
        localEditor.putLong("tbs_download_cost", l1 + (l2 - l3));
        localEditor.commit();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_error", 0, 1, paramInt, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs download aborted:" + paramInt);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_Boolean) {
        BrowserAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_AndroidContentIntent);
      }
    }
    do
    {
      return;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_ok", 0, 1, paramInt, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("TBS_update", 2, "tbs download finished");
  }
  
  public void onDownloadProgress(int paramInt) {}
  
  public void onInstallFinish(int paramInt)
  {
    int i;
    long l1;
    long l2;
    long l3;
    SharedPreferences.Editor localEditor;
    if (BrowserAppInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      QbSdk.setTbsListener(null);
      if ((paramInt == 200) || (paramInt == 220)) {
        break label194;
      }
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
      l2 = System.currentTimeMillis();
      l3 = this.jdField_a_of_type_Long;
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_count", i + 1);
      localEditor.putLong("tbs_download_cost", l1 + (l2 - l3));
      localEditor.commit();
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_error", 0, 1, paramInt, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs install error:" + paramInt);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_Boolean) {
        BrowserAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_AndroidContentIntent);
      }
      return;
      label194:
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
      l2 = System.currentTimeMillis();
      l3 = this.jdField_a_of_type_Long;
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.remove("tbs_download_count");
      localEditor.remove("tbs_download_cost");
      localEditor.commit();
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_ok", 0, 1, paramInt, Long.toString(l1 + (l2 - l3)), Integer.toString(i + 1), "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs install finished:" + paramInt);
      }
      WebpSoLoader.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\puo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */