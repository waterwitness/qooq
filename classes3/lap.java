import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

public class lap
  implements TroopPluginManager.TroopPluginCallback
{
  public lap(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.b = true;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.a.a(3, null, true);
        this.a.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */