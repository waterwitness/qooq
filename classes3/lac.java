import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;

public class lac
  implements Runnable
{
  public lac(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = null;
    Object localObject = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.a());
    if (localObject != null)
    {
      str = ((TroopMemberInfo)localObject).troopnick;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = ((TroopMemberInfo)localObject).troopnick;
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 18;
    Bundle localBundle = new Bundle();
    localBundle.putString("troopnick", str);
    ((Message)localObject).setData(localBundle);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */