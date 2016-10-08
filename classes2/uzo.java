import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class uzo
  extends DownloadListener
{
  public uzo(NightModeLogic paramNightModeLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    boolean bool = true;
    super.onDone(paramDownloadTask);
    paramDownloadTask.a();
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0)) {
      if (NightModeLogic.a(this.a) != null) {
        new CustomHandler(Looper.getMainLooper(), this.a.jdField_a_of_type_AndroidOsHandler$Callback).sendEmptyMessage(4097);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("downloadThemeInfoJson", 2, "downloadThemeInfoJson, http://i.gtimg.cn/qqshow/admindata/comdata/vipData_theme_night/xydata.json,ret=" + bool + "_" + paramDownloadTask.a() + "_" + paramDownloadTask.z);
      }
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(paramDownloadTask.z));
        StatisticCollector.a(this.a.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeJsonDowned", bool, 1L, 0L, (HashMap)localObject, "", false);
        localObject = (QQAppInterface)BaseApplicationImpl.a.a();
        int j = NetworkUtil.a(null);
        if (bool) {}
        for (int i = 33;; i = paramDownloadTask.z)
        {
          ThemeReporter.a((QQAppInterface)localObject, "theme_detail", "202", 151, j, i, "1103", "", String.valueOf(paramDownloadTask.a()), "");
          return;
          NightModeLogic.a(this.a, true);
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      bool = false;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */