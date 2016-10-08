import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class vho
  implements BusinessObserver
{
  public vho(TroopBarPublishActivity paramTroopBarPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b(false);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.a.rightViewText.setEnabled(true);
    TroopBarPublishActivity localTroopBarPublishActivity = this.a;
    this.a.getString(2131364761);
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label645;
        }
        localObject1 = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject1).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject1).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject1).data.get());
        if (paramInt == 0) {
          break label289;
        }
        localObject1 = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(paramInt) });
        }
        if (this.a.i == 2) {
          ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "", "" + paramInt, "", "");
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Object localObject1;
          paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(9992) });
          continue;
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
          continue;
          paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(9991) });
        }
      }
      QQToast.a(localTroopBarPublishActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label697;
      }
    }
    label289:
    label645:
    label697:
    for (paramBundle = "0";; paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "fail", paramBundle, "4", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
      return;
      localObject1 = paramBundle.getJSONObject("result");
      Object localObject2 = new StringBuffer();
      if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        ((StringBuffer)localObject2).append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        ((StringBuffer)localObject2).append("1");
      }
      if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.b))) {
        ((StringBuffer)localObject2).append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        ((StringBuffer)localObject2).append("5");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
      {
        paramBundle = "0";
        TroopBarUtils.a("pub_page", "suc", paramBundle, this.a.jdField_c_of_type_JavaLangString, ((StringBuffer)localObject2).toString(), "");
        this.a.d = true;
        localObject2 = ((JSONObject)localObject1).optString("pid");
        if ((this.a.jdField_c_of_type_Boolean) && (this.a.jdField_a_of_type_OrgJsonJSONObject != null))
        {
          String str1 = this.a.getIntent().getStringExtra("pkg_name");
          String str2 = this.a.jdField_a_of_type_OrgJsonJSONObject.optString("share_app_name");
          long l = this.a.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id");
          paramBundle = "";
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
          }
          TroopBarShareUtils.a(this.a, str1, str2, l, paramBundle, (String)localObject2);
          TroopBarShareUtils.a(this.a.app, "share_suc", paramBundle);
        }
        paramBundle = new Intent();
        paramBundle.putExtra("result", ((JSONObject)localObject1).toString());
        this.a.setResult(-1, paramBundle);
        this.a.finish();
        return;
      }
      paramBundle = this.a.getString(2131364762, new Object[] { Integer.valueOf(9992) });
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */