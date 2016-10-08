import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import mqq.observer.AccountObserver;

public class kzq
  extends AccountObserver
{
  public kzq(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if (paramString1 == null) {
      while (i > 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b - 1);
        i -= 1;
      }
    }
    TroopUtils.a(paramString1, this.a.app.a(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */