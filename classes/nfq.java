import android.os.Build;
import android.view.LayoutInflater;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.qphone.base.util.QLog;

public class nfq
  implements Runnable
{
  public nfq(AudioPanelAdapter paramAudioPanelAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b == null) {}
    try
    {
      ListenChangeVoicePanel localListenChangeVoicePanel = (ListenChangeVoicePanel)LayoutInflater.from(AudioPanelAdapter.a(this.a).a()).inflate(2130904071, null);
      if (this.a.b == null) {
        this.a.b = localListenChangeVoicePanel;
      }
      PttPreSendManager.a(AudioPanelAdapter.a(this.a));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "inflate ListenPanel on subthread get exception " + localException + " model=" + Build.MANUFACTURER + Build.MODEL);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */