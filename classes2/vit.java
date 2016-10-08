import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.AudioUploadTask;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.File;

public class vit
  extends Handler
{
  public vit(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      TroopBarReplyActivity.a(this.a, false);
      return;
    }
    paramMessage = paramMessage.obj.toString();
    File localFile = new File(paramMessage);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      TroopBarReplyActivity.a(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
      TroopBarReplyActivity.a(this.a, new AudioInfo(paramMessage, (int)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(), l));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = TroopBarReplyActivity.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$AudioUploadTask = new TroopBarReplyActivity.AudioUploadTask(this.a, this.a, this.a.jdField_a_of_type_AndroidOsHandler, "http://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      ThreadManager.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$AudioUploadTask, 5, null, true);
      this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      TroopBarReplyActivity.a(this.a, 0);
      if (!this.a.k) {
        break;
      }
      TroopBarUtils.a(this.a.n, this.a.o, "sure_record", this.a.p, "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */