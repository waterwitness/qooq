import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import org.json.JSONObject;

public class oah
  implements HttpWebCgiAsyncTask.Callback
{
  public oah(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = (TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    paramInt = paramJSONObject.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramJSONObject.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, paramInt & 0xF);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */