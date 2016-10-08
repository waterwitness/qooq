import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class kiz
  implements Runnable
{
  public kiz(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
    Object localObject = "{\"m\":0,\"source\":\"joinTroop\", \"gc\":" + this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c + "}";
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(1);
    for (;;)
    {
      try
      {
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, true);
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, "");
        String str = TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.a(), "http://admin.qun.qq.com/cgi-bin/qun_admin/upload_msg_img", this.jdField_a_of_type_JavaLangString, (String)localObject, "", LoginHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app), TroopNoticeJsHandler.f);
        if (i != AddFriendVerifyActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.w("AddFriendVerifyActivity", 2, "uploadImage task cancelled.");
          return;
        }
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, false);
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          localObject = HttpUtil.b(str);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = new JSONObject((String)localObject);
        i = ((JSONObject)localObject).optInt("ec", -1);
        if (i != 0) {
          continue;
        }
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optLong("gc"));
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optInt("fileid"));
        AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optString("md5"));
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optString("url"));
      }
      catch (InterruptedException localInterruptedException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage exception:" + localInterruptedException.getMessage());
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(3);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage error.");
        continue;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage json exception:" + localJSONException.getMessage());
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(2);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(3);
      if (QLog.isColorLevel()) {
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage error. ec:" + i);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */