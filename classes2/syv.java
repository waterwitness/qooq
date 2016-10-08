import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;

public class syv
  implements TroopMemberApiClient.Callback
{
  public syv(UiApiPlugin paramUiApiPlugin, Integer paramInteger, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i != this.jdField_a_of_type_JavaLangInteger.intValue()) || (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString))) {
        break label170;
      }
      str1 = paramBundle.getString("uin");
      bool = paramBundle.getBoolean("isFriend", false);
      localObject = paramBundle.getString("nickName");
      str2 = paramBundle.getString("remark");
      if (!TextUtils.isEmpty(str1))
      {
        if (!bool) {
          break label156;
        }
        paramBundle = new ProfileActivity.AllInOne(str1, 1);
        paramBundle.h = ((String)localObject);
        paramBundle.i = str2;
        localObject = new Intent(UiApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin), FriendProfileCardActivity.class);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).addFlags(536870912);
        UiApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin).startActivity((Intent)localObject);
      }
    }
    label156:
    label170:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str1;
        boolean bool;
        String str2;
        return;
        paramBundle = new ProfileActivity.AllInOne(str1, 78);
      }
    }
    QLog.d(UiApiPlugin.jdField_a_of_type_JavaLangString, 2, "appId != appID || !openId.equals(openID)");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */