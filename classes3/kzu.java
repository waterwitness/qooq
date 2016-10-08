import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;

public class kzu
  extends FriendListObserver
{
  public kzu(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l != 0L)
      {
        this.a.a(l);
        this.a.b(l);
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
      }
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    super.a(paramBoolean, paramMap);
    if ((paramMap == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {
      return;
    }
    if (!paramBoolean) {
      if (paramMap.get(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin) != null) {
        QQToast.a(this.a.app.a(), 1, this.a.getString(2131368707), 0).b(this.a.getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
      return;
      paramMap = (Integer)paramMap.get(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      if (paramMap != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask = paramMap.intValue();
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    this.a.t();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */