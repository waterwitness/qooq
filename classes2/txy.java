import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordTextView;

public class txy
  implements Runnable
{
  public txy(LSRecordPanel paramLSRecordPanel, int paramInt, double paramDouble)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.b(i);
    LSRecordPanel.a(this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\txy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */