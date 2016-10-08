import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

class wpa
  implements Runnable
{
  wpa(woz paramwoz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.a.b, this.a.c, this.a.jdField_a_of_type_Long);
    if (localMessageRecord == null) {
      return;
    }
    MQPSensitiveMsgUtil.a(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.a.b, this.a.c, this.a.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */