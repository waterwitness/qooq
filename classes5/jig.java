import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class jig
  implements WXShareHelper.WXShareListener
{
  public jig(Share paramShare, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o == null) || (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o.equals(paramBaseResp.transaction))) {}
    do
    {
      return;
      BaseApplicationImpl.getContext();
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        QRUtils.a(1, 2131369518);
        return;
      }
      QRUtils.a(2, 2131369517);
    } while (!(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a instanceof QQBrowserActivity));
    paramBaseResp = (QQBrowserActivity)this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a;
    if (Share.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare) == 1) {}
    String str1;
    String str2;
    String str3;
    for (int i = 1009;; i = 1004)
    {
      str1 = paramBaseResp.ax;
      str2 = paramBaseResp.aw;
      str3 = AccountDetailActivity.a(paramBaseResp.ab);
      String str4 = paramBaseResp.ay;
      if ((str4 == null) || ("".equals(str4))) {
        break;
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.ab, str3);
      return;
    }
    if (Share.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare) == 1) {
      i = 1003;
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */