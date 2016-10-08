import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class upx
  implements Runnable
{
  public upx(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("faceu_reddot_click_sp", 4);
    if (localSharedPreferences.getBoolean("faceu_reddot_click_sp", false)) {}
    do
    {
      int k;
      File localFile;
      int i;
      do
      {
        do
        {
          long l;
          do
          {
            do
            {
              return;
              k = localSharedPreferences.getInt("teach_video_download_time", 0);
            } while (k >= 10);
            l = localSharedPreferences.getLong("download_teach_video_last_time", 0L);
          } while (System.currentTimeMillis() - l < 21600000L);
          localFile = new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, "ptv_teach_video.mp4");
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.l)) {
            break;
          }
        } while (!localFile.exists());
        localFile.delete();
        return;
        int j = 1;
        i = j;
        if (localFile.exists())
        {
          localObject = FileUtils.b(localFile.getPath());
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i = j;
            if (((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.m)) {
              i = 0;
            }
          }
        }
      } while (i == 0);
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new upy(this, localSharedPreferences, k);
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.l;
      ((HttpNetReq)localObject).c = 0;
      ((HttpNetReq)localObject).b = localFile.getPath();
      ((HttpNetReq)localObject).k = NetworkUtil.a(NetworkCenter.a().a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(0).a((NetReq)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "startDownloadTeachVideo, url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.l);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */