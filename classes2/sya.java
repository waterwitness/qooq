import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class sya
  implements WXShareHelper.WXShareListener
{
  sya(sxz paramsxz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.G == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.G.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131369518);
      bool = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.E))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.callJs(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.E, new String[] { String.valueOf(bool) });
        return;
        QRUtils.a(2, 2131369517);
        if ((QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin) != null) && (QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin) != null))
        {
          int i;
          label174:
          String str1;
          String str2;
          String str3;
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
          {
            i = 1009;
            paramBaseResp = QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin).e();
            str1 = QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin).f();
            str2 = this.a.b;
            str3 = AccountDetailActivity.a(QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin).getCurrentUrl());
            String str4 = QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin).g();
            if ((str4 == null) || ("".equals(str4))) {
              break label317;
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin).getCurrentUrl(), str3);
          }
          for (;;)
          {
            bool = true;
            break;
            i = 1004;
            break label174;
            label317:
            if ("2".equals(this.a.jdField_a_of_type_JavaLangString)) {
              i = 1003;
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3);
          }
          bool = false;
        }
      }
      else
      {
        QQApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, "shareMsg", 0, String.valueOf(bool));
        return;
      }
      bool = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */