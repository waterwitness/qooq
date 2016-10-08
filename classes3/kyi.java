import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kyi
  implements Runnable
{
  public kyi(ChatSettingActivity paramChatSettingActivity, StringBuilder paramStringBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Message localMessage = null;
    Object localObject = localMessage;
    if (this.jdField_a_of_type_JavaLangStringBuilder != null)
    {
      localObject = localMessage;
      if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
        localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      }
    }
    if (ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), this.jdField_a_of_type_JavaLangStringBuilder) > 0)
    {
      localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.a.obtainMessage();
      localMessage.what = 18;
      localMessage.obj = localObject;
      localMessage.sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */