import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.biz.common.offline.util.OfflineDownloaderManager;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class jjx
  implements Runnable
{
  public jjx(XChooserActivity paramXChooserActivity, String paramString, jkc paramjkc, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "get real download url");
    }
    int i = 0;
    for (;;)
    {
      Object localObject4;
      if ((this.jdField_a_of_type_Jkc.jdField_a_of_type_JavaLangString == null) && (i < 3)) {
        localObject4 = localObject1;
      }
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL((String)localObject1).openConnection();
        localObject4 = localObject1;
        localHttpURLConnection.setRequestMethod("GET");
        localObject4 = localObject1;
        localHttpURLConnection.setInstanceFollowRedirects(false);
        localObject4 = localObject1;
        localHttpURLConnection.addRequestProperty("Accept-Charset", "UTF-8;");
        localObject4 = localObject1;
        localHttpURLConnection.connect();
        localObject4 = localObject1;
        int j = localHttpURLConnection.getResponseCode();
        Object localObject3;
        if ((j == 302) || (j == 301))
        {
          localObject4 = localObject1;
          localObject3 = localHttpURLConnection.getHeaderField(QQMapConstants.k);
        }
        do
        {
          localObject4 = localObject3;
          localHttpURLConnection.disconnect();
          localObject1 = localObject3;
          break;
          localObject3 = localObject1;
        } while (j != 200);
        localObject4 = localObject1;
        this.jdField_a_of_type_Jkc.a((String)localObject1);
        if (this.jdField_a_of_type_Jkc.jdField_a_of_type_JavaLangString == null)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(new jjy(this));
          this.jdField_a_of_type_Jkc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 0);
          this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_JavaLangRunnable);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject2 = localObject4;
        break label324;
        if (QLog.isColorLevel()) {
          QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "got real url, start download");
        }
        localObject2 = new File(AppConstants.bx);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        for (;;)
        {
          OfflineDownloaderManager.a().a().a(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getApplicationContext(), this.jdField_a_of_type_Jkc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Jkc.b, new jjz(this));
          return;
          if ((!((File)localObject2).isDirectory()) && (((File)localObject2).delete())) {
            ((File)localObject2).mkdir();
          }
        }
        label324:
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */