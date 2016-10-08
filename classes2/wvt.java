import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class wvt
  implements Runnable
{
  public wvt(DownloadManager paramDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      if (!CommonDataAdapter.a().a().getSharedPreferences("opensdk_config", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label174;
          }
          localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.jdField_h_of_type_Int != 0) {
            break label135;
          }
          if (localDownloadInfo.f != 0) {
            break;
          }
          String str = localDownloadInfo.c;
          label77:
          if (this.a.a(str) == null)
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.b);
            DownloadDBHelper.a().a(localDownloadInfo.b);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "checkDownloadList>>>", localException);
    }
    label135:
    label174:
    do
    {
      localObject = localDownloadInfo.jdField_h_of_type_JavaLangString;
      break label77;
      if (this.a.a(localDownloadInfo) != null) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.b);
      DownloadDBHelper.a().a(localDownloadInfo.b);
      break;
    } while (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 200);
    Object localObject = CommonDataAdapter.a().a().getSharedPreferences("opensdk_config", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */