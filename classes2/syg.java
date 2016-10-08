import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;

class syg
  implements TroopMemberApiClient.Callback
{
  syg(syf paramsyf, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i != this.jdField_a_of_type_Syf.jdField_a_of_type_JavaLangInteger.intValue()) || (!((String)localObject).equals(this.jdField_a_of_type_Syf.jdField_a_of_type_JavaLangString))) {
        break label120;
      }
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent(UiApiPlugin.a(this.jdField_a_of_type_Syf.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin), TroopMemberCardActivity.class);
        ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("memberUin", paramBundle);
        UiApiPlugin.a(this.jdField_a_of_type_Syf.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin).startActivity((Intent)localObject);
      }
    }
    label120:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(UiApiPlugin.jdField_a_of_type_JavaLangString, 2, "appId != appID || !openId.equals(openID)");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */