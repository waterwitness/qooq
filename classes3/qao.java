import com.tencent.mobileqq.app.MessageRoamConstants;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class qao
  extends DownloadListener
{
  public qao(MessageRoamManager paramMessageRoamManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + paramDownloadTask.D + ", url: " + paramDownloadTask.a);
    }
    int i = paramDownloadTask.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.a;
      if (!MessageRoamConstants.D.contains(str)) {
        break label105;
      }
      MessageRoamManager.a(this.a, paramDownloadTask);
    }
    label105:
    do
    {
      return;
      str = paramDownloadTask.a.substring(0, i - 1);
      break;
      if ("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        MessageRoamManager.b(this.a, paramDownloadTask);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + paramDownloadTask.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */