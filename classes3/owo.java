import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotAcitivtyHelper;
import cooperation.qqhotspot.QQHotSpotHelper;
import cooperation.qqhotspot.QQHotSpotHelper.AP;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;

public class owo
  implements View.OnClickListener
{
  public owo(BannerManager paramBannerManager, String paramString, QQHotSpotHelper.AP paramAP)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = QQHotSpotHelper.a(this.jdField_a_of_type_JavaLangString);
      localObject = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("selfSet_leftViewText", BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getString(2131367975));
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).startActivity((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent.banner", 2, "from blue WiFiO2OBar open jumpto ApAdUrlPage");
      }
      if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.From == null) {
        break label263;
      }
      paramView = this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.From;
      label127:
      if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.AuthType == null) {
        break label269;
      }
      localObject = this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.AuthType;
      label151:
      if (this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.ManuID == null) {
        break label275;
      }
    }
    label263:
    label269:
    label275:
    for (String str = this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.Apinfo.ManuID;; str = "")
    {
      ReportController.b(null, "CliOper", "", "", "0X800634B", "0X800634B", 0, 0, paramView, (String)localObject, "", str);
      return;
      paramView = new Bundle();
      paramView.putSerializable("APINFO", this.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP);
      paramView.putInt("wifi_conn_activity_from", 1);
      QQHotSpotAcitivtyHelper.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app, BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), "com.qqhotspot.activity.WiFiConnectActivity", paramView, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent.banner", 2, "from blue WiFiO2OBar open WiFiConnectActivity");
      break;
      paramView = "";
      break label127;
      localObject = "";
      break label151;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */