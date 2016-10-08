import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

public class kzv
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  public kzv(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 17;
      Bundle localBundle = new Bundle();
      localBundle.putString("uinname", paramAccountDetail.name);
      localBundle.putString("extra_type", paramAccountDetail.summary);
      localBundle.putLong("uin", paramLong);
      localMessage.setData(localBundle);
      this.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */