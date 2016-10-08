import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lad
  extends BizTroopObserver
{
  public lad(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (((paramObject instanceof TroopNotificationCache)) && (this.a.jdField_a_of_type_AndroidOsHandler != null))
    {
      paramObject = (TroopNotificationCache)paramObject;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(((TroopNotificationCache)paramObject).title))) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopMemo = ((TroopNotificationCache)paramObject).title;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */