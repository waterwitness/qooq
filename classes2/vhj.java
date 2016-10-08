import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopBarCommentWindow;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class vhj
  implements BusinessObserver
{
  public vhj(TroopBarCommentWindow paramTroopBarCommentWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364761);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          continue;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364762, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364762, new Object[] { Integer.valueOf(9992) });
        continue;
        paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364762, new Object[] { Integer.valueOf(9991) });
        continue;
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramBundle, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      TroopBarUtils.a("two_comment", "fail", this.a.e, "4", "", "");
      this.a.c = false;
      return;
      paramBundle = paramBundle.getJSONObject("result");
      TroopBarUtils.a("two_comment", "suc", this.a.e, this.a.i, "", "");
      this.a.jdField_a_of_type_Boolean = true;
      this.a.a(this.a.d, paramBundle.toString(), true);
      this.a.dismiss();
      return;
      paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364762, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */