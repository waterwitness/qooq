import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nfs
  implements Runnable
{
  public nfs(CommonRecordSoundPanel paramCommonRecordSoundPanel, int paramInt, double paramDouble)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.c(i);
    CommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */