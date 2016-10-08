import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ngv
  implements Runnable
{
  public ngv(PressToSpeakPanel paramPressToSpeakPanel, int paramInt, double paramDouble)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.b())
    {
      int i = AudioPanel.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.b(i);
    }
    if (PressToSpeakPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) == 1)
    {
      PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText("松手试听");
      return;
    }
    if (PressToSpeakPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel) == 2)
    {
      PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText("松手取消发送");
      return;
    }
    PressToSpeakPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */