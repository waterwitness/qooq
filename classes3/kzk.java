import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;

public class kzk
  implements Runnable
{
  public kzk(ChatSettingForTroop paramChatSettingForTroop, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */