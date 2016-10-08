import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nks
  extends ClickableSpan
{
  public nks(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Bundle paramBundle, String paramString4, int paramInt3, long paramLong, String paramString5, int paramInt4, String paramString6)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("makePhoneCall") == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "makePhoneCall", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    Object localObject3;
    String str;
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("showAlert") == 0)
      {
        paramView = this.jdField_a_of_type_AndroidOsBundle.getString("AlertTitle");
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertText");
        localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertOtherBtnText");
        str = this.jdField_a_of_type_AndroidOsBundle.getString("AlertCancelBtnText");
        MQPSensitiveMsgUtil.a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramView, (String)localObject1, (String)localObject3, str);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("openURL") != 0) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "openURL", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("Action");
    } while (TextUtils.isEmpty((CharSequence)localObject3));
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (((String)localObject3).startsWith("http://")) {
        break label348;
      }
      paramView = "http://" + (String)localObject3;
    }
    for (;;)
    {
      localObject1 = paramView;
      if (paramView.contains("?")) {}
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", (String)localObject1);
      paramView.putExtra("hide_left_button", true);
      paramView.putExtra("show_right_close_button", true);
      paramView.putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      label348:
      paramView = (View)localObject3;
      if (!((String)localObject3).startsWith("https://")) {
        paramView = "https://" + (String)localObject3;
      }
    }
    if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("transfer") == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "transfer", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      paramView = this.e;
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3000)) {
        paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.jdField_b_of_type_JavaLangString);
      }
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, TransactionActivity.class);
      ((Intent)localObject1).putExtra("come_from", 2);
      localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("targetUin", this.jdField_d_of_type_JavaLangString);
        ((JSONObject)localObject3).put("targetNickname", paramView);
        ((JSONObject)localObject3).put("sign", "");
        ((Intent)localObject1).putExtra("extra_data", ((JSONObject)localObject3).toString());
        ((Intent)localObject1).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#graytips");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return;
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
      }
    }
    if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("openDeviceLock") == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "openDeviceLock", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      paramView = new Intent();
      paramView.setFlags(268435456);
      paramView.setAction("android.intent.action.VIEW");
      paramView.putExtra("devlock_open_source", "Graytips");
      paramView.putExtra("enable_open_allowset_dev", true);
      paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("tipOff") == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "tipOff", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break label1368;
      }
    }
    label1077:
    label1362:
    label1368:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramView = null)
    {
      ProfileCardUtil.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1101);
      return;
      int i;
      if ((this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("QQCall") == 0) || (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("videoCall") == 0))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break;
        }
        paramView = this.e;
        i = this.jdField_d_of_type_Int;
        if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3000))
        {
          paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.jdField_b_of_type_JavaLangString);
          i = 0;
        }
        str = this.jdField_d_of_type_JavaLangString;
        localObject3 = this.f;
        if ((i != 1006) || (this.jdField_d_of_type_JavaLangString == null)) {
          break label1362;
        }
        localObject1 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
        if (localObject1 == null) {
          break label1362;
        }
        localObject3 = null;
      }
      for (;;)
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Activity localActivity = (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext;
        if (this.jdField_d_of_type_Int == 1006)
        {
          str = this.jdField_d_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("QQCall") != 0) {
            break label1077;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ChatActivityUtils.a(localQQAppInterface, localActivity, i, (String)localObject1, paramView, str, bool, (String)localObject3, true, true, null, "from_internal");
          return;
          str = null;
          break;
        }
        if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("luckyMoney") != 0) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "luckyMoney", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        i = 1;
        if (this.jdField_d_of_type_Int == 3000) {
          i = 2;
        }
        for (;;)
        {
          paramView = new JSONObject();
          try
          {
            paramView.put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.put("recv_nick", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
            paramView.put("recv_type", i);
            if (QLog.isColorLevel()) {
              QLog.d("PlusPanel", 2, "click HongBao:params=" + paramView.toString());
            }
            localObject1 = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
            ((Intent)localObject1).putExtra("come_from", 2);
            ((Intent)localObject1).putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
            ((Intent)localObject1).putExtra("extra_data", paramView.toString());
            ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            return;
            if (this.jdField_d_of_type_Int == 1) {
              i = 3;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        Object localObject2 = str;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */