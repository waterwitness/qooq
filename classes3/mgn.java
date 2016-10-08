import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class mgn
  extends DownloadListener
{
  public mgn(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onDone status: " + paramDownloadTask.D + ", url: " + paramDownloadTask.a);
    }
    int i = paramDownloadTask.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.a;
      if (!"http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json".contains(str)) {
        break label104;
      }
      QQSettingMsgHistoryActivity.a(this.a, paramDownloadTask);
    }
    label104:
    while (!QLog.isColorLevel())
    {
      return;
      str = paramDownloadTask.a.substring(0, i - 1);
      break;
    }
    QLog.e("IphoneTitleBarActivity", 2, "onDone unkonw url: " + paramDownloadTask.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */