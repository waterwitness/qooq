import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

class kxl
  implements Runnable
{
  kxl(kxk paramkxk, int paramInt, DevlockInfo paramDevlockInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = true;
    ChatHistoryForC2C.c(this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C);
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
    {
      ChatHistoryForC2C localChatHistoryForC2C = this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C;
      boolean bool1;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        bool1 = true;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
          break label77;
        }
      }
      for (;;)
      {
        ChatHistoryForC2C.a(localChatHistoryForC2C, bool1, bool2, this.jdField_a_of_type_Kxk.jdField_a_of_type_Boolean);
        return;
        bool1 = false;
        break;
        label77:
        bool2 = false;
      }
    }
    if (1 == ChatHistoryForC2C.a(this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).b())
    {
      ChatHistoryForC2C.b(this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C);
      return;
    }
    if (!ChatHistoryForC2C.a(this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).f())
    {
      this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b();
      return;
    }
    ChatHistoryForC2C.b(this.jdField_a_of_type_Kxk.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C, this.jdField_a_of_type_Kxk.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */