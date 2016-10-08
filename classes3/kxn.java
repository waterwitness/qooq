import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kxn
  implements Runnable
{
  kxn(kxm paramkxm, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatHistoryForC2C.c(this.jdField_a_of_type_Kxm.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C);
    if (this.jdField_a_of_type_Boolean)
    {
      ChatHistoryForC2C.b(this.jdField_a_of_type_Kxm.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C, this.jdField_a_of_type_Kxm.jdField_a_of_type_Boolean);
      return;
    }
    ChatHistoryForC2C.b(this.jdField_a_of_type_Kxm.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */