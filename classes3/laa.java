import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class laa
  implements Runnable
{
  public laa(ChatSettingForTroop paramChatSettingForTroop, TroopManager paramTroopManager, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.a());
    if (localObject != null)
    {
      localObject = ((TroopMemberInfo)localObject).troopnick;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.runOnUiThread(new lab(this, (String)localObject));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\laa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */