import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class the
  implements Runnable
{
  public the(ImgDownloadListener paramImgDownloadListener, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime() - ImgDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyImgDownloadListener);
    Object localObject2 = NetworkUtil.a(ImgDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyImgDownloadListener));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "wifi";
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("fileSize", String.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject2).put("costTime", String.valueOf(l));
    ((HashMap)localObject2).put("apn", localObject1);
    ((HashMap)localObject2).put("param_NetType", NetworkUtil.a(null) + "");
    StatisticCollector.a(ImgDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyImgDownloadListener)).a("", ImgDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyImgDownloadListener), true, l, 0L, (HashMap)localObject2, "", true);
    if (QLog.isColorLevel()) {
      QLog.d(ImgDownloadListener.a, 2, "onFileDownloadSucceed, fileSize=" + this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\the.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */