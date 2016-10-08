import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class spa
  implements Runnable
{
  public spa(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onResume, mFailedPicUrlList.size()=" + this.a.jdField_a_of_type_JavaUtilLinkedList.size());
    }
    for (;;)
    {
      int i;
      try
      {
        String str1;
        if (this.a.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
        {
          str1 = (String)this.a.jdField_a_of_type_JavaUtilLinkedList.poll();
          if (str1 == null) {
            continue;
          }
          i = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size();
          if (i != 1) {
            break label286;
          }
          i = 300;
          localObject = NearbyImgDownloader.a(str1 + String.valueOf(i));
          if (localObject != null) {}
        }
        else
        {
          if (!this.a.g) {
            break label285;
          }
          this.a.jdField_a_of_type_AndroidOsHandler.post(new spb(this));
          return;
        }
        Object localObject = ((URL)localObject).toString();
        String str2 = AbsDownloader.d((String)localObject);
        URL localURL = NearbyImgDownloader.a(str1);
        if (localURL == null) {
          continue;
        }
        boolean bool = FreshNewsUtil.a((String)localObject, str2, localURL.toString(), i);
        if (bool)
        {
          BaseApplicationImpl.a.remove(new URL((String)localObject).toString());
          this.a.g = true;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FreshNewsDetailActivity", 2, "onResume, create thumb, url=" + str1 + ", result=" + bool);
        continue;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FreshNewsDetailActivity", 2, "onResume, catch exception", localException);
        }
      }
      label285:
      label286:
      if (i == 2) {
        i = 250;
      } else {
        i = 200;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */