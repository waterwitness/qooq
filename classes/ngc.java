import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class ngc
  extends DownloadListener
{
  public ngc(ListenChangeVoicePanel paramListenChangeVoicePanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas jsonDownloadListener changeVoice jsonLoaded ok");
      }
      this.a.a(true);
      return;
    }
    QLog.e("ListenChangeVoicePanel", 1, "initVoiceDatas jsonDownloadListener changeVoice JsonErr: status=" + paramDownloadTask.a() + ", errCode=" + paramDownloadTask.z + ", errMsg=" + paramDownloadTask.b);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */