import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop.GetClassChoiceCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class law
  implements Runnable
{
  public law(ChatSettingForTroop.GetClassChoiceCallBack paramGetClassChoiceCallBack, InputStream paramInputStream)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaIoInputStream != null)
    {
      GroupCatalogTool localGroupCatalogTool = GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_AndroidContentContext);
      if ((localGroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoInputStream)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_JavaLangString)))
      {
        localGroupCatalogTool.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_JavaLangString);
        localGroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_AndroidContentContext, System.currentTimeMillis());
        boolean bool = localGroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.jdField_a_of_type_AndroidContentContext);
        if ((!bool) && (QLog.isColorLevel())) {
          QLog.d("Q.chatopttroop", 2, "isMoveSuccess " + bool);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\law.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */