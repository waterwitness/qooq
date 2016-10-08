import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.AudioRecordActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class vdh
  extends Handler
{
  public vdh(AudioRecordActivity paramAudioRecordActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = paramMessage.obj.toString();
        File localFile = new File(paramMessage);
        if (localFile.exists()) {}
        for (long l = localFile.length();; l = 0L)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = new AudioInfo(paramMessage, (int)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(), l);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
          paramMessage = new Intent();
          paramMessage.putExtra("audio_info", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
          this.a.setResult(-1, paramMessage);
          this.a.finish();
          return;
        }
      } while ((this.a.g == null) || (!this.a.g.equals("publish")) || (this.a.h == null));
      TroopBarUtils.a("pub_page", "preview_record", this.a.h, this.a.i, "", "");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AIOAudioPanel", 2, "RECORD_TO_START =============");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */