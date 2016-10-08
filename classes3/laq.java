import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class laq
  implements CompoundButton.OnCheckedChangeListener
{
  public laq(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((Boolean)paramCompoundButton.getTag()).booleanValue()) {
      paramCompoundButton.setTag(Boolean.FALSE);
    }
    label20:
    int i;
    do
    {
      do
      {
        break label20;
        do
        {
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
        i = this.a.app.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      } while (i == -1);
      if (!paramBoolean) {
        break;
      }
    } while (i != 1);
    ChatSettingForTroop.a(this.a, 4);
    label77:
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "msg_open";; paramCompoundButton = "msg_close")
    {
      ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "Grp_data", paramCompoundButton, 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      return;
      if (i == 1) {
        break;
      }
      ChatSettingForTroop.a(this.a, 1);
      break label77;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\laq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */