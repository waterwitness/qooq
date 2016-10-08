import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class vie
  implements BusinessObserver
{
  public vie(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.a(false);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    TroopBarReplyActivity localTroopBarReplyActivity = this.a;
    this.a.getString(2131364761);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          continue;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          this.a.getWindow().setSoftInputMode(19);
          this.a.b = true;
          Object localObject = paramBundle.optJSONObject("post");
          if (localObject != null) {
            ((JSONObject)localObject).optString("title");
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("result", paramBundle.toString());
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
          return;
          paramBundle = paramBundle;
          paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(9992) });
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localException));
          continue;
        }
        paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(9991) });
        continue;
      }
      this.a.jdField_a_of_type_Boolean = false;
      QQToast.a(localTroopBarReplyActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      if (this.a.k) {
        TroopBarUtils.a("reply_page", "fail", this.a.p, "4", "", "");
      }
      return;
      paramBundle = paramBundle.getJSONObject("result");
      localObject = new StringBuffer();
      if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        ((StringBuffer)localObject).append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        ((StringBuffer)localObject).append("1");
      }
      if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.jdField_a_of_type_AndroidWidgetEditText))) {
        ((StringBuffer)localObject).append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        ((StringBuffer)localObject).append("5");
      }
      if (this.a.k) {
        TroopBarUtils.a("reply_page", "suc", this.a.p, "", ((StringBuffer)localObject).toString(), "");
      }
      paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */