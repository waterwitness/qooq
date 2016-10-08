import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView.TimerCallback;

public class uwu
  implements CountdownTextView.TimerCallback
{
  public uwu(StructMsgItemTimer paramStructMsgItemTimer, CountdownTextView paramCountdownTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer.d = 0L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer.e = true;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(StructMsgItemTimer.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer, 0L));
  }
  
  public void a(long paramLong)
  {
    paramLong /= 1000L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(StructMsgItemTimer.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer, paramLong));
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemTimer.d = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */