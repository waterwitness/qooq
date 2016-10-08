import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.util.HandlerPlus;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.PassData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class wqa
  implements Handler.Callback
{
  public wqa(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject3;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      localObject3 = (SdkAuthorize.GetAuthApiListResponse)paramMessage.obj;
      i = ((SdkAuthorize.GetAuthApiListResponse)localObject3).ret.get();
      if (i != 0) {
        QLog.d("AuthorityActivity", 1, "rec | cmd: G_A_L_D | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + i);
      }
      break;
    }
    label704:
    label1733:
    label1874:
    label2042:
    label2071:
    label2163:
    label2468:
    label2793:
    for (;;)
    {
      Object localObject2;
      try
      {
        ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, "", AuthorityActivity.y, "1", "6", "" + i, false);
        if (i == 110405)
        {
          if (TextUtils.isEmpty(((SdkAuthorize.GetAuthApiListResponse)localObject3).msg.get()))
          {
            paramMessage = String.format(this.a.getResources().getString(2131369831), new Object[] { Integer.valueOf(i) });
            this.a.a(paramMessage, new wqb(this));
            this.a.b(i, paramMessage);
            return true;
          }
          paramMessage = String.format(this.a.getResources().getString(2131369836), new Object[] { ((SdkAuthorize.GetAuthApiListResponse)localObject3).msg.get(), Integer.valueOf(i) });
          continue;
        }
        if (i == 100044)
        {
          localObject1 = AuthorityActivity.a(this.a).getBundleExtra("key_params");
          paramMessage = ((Bundle)localObject1).getString("packagename");
          if (paramMessage != null) {
            break label2793;
          }
          paramMessage = "";
          localObject2 = ((Bundle)localObject1).getString("packagesign");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("uin", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          ((Bundle)localObject2).putString("openid", "");
          ((Bundle)localObject2).putString("report_type", "1");
          ((Bundle)localObject2).putString("act_type", "7");
          ((Bundle)localObject2).putString("via", "2");
          ((Bundle)localObject2).putString("app_id", AuthorityActivity.y);
          ((Bundle)localObject2).putString("packagename", paramMessage);
          ((Bundle)localObject2).putString("stringext_1", (String)localObject1);
          ((Bundle)localObject2).putString("result", "0");
          ReportCenter.a().a((Bundle)localObject2, AuthorityActivity.y, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, false);
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("ret", ((SdkAuthorize.GetAuthApiListResponse)localObject3).ret.get());
        ((JSONObject)localObject1).put("msg", ((SdkAuthorize.GetAuthApiListResponse)localObject3).msg.get());
        if (!TextUtils.isEmpty(((SdkAuthorize.GetAuthApiListResponse)localObject3).msg.get())) {
          break label704;
        }
        paramMessage = String.format(this.a.getResources().getString(2131369831), new Object[] { Integer.valueOf(i) });
        this.a.a(paramMessage, new wqc(this, (SdkAuthorize.GetAuthApiListResponse)localObject3, (JSONObject)localObject1));
        continue;
        this.a.i = SystemClock.elapsedRealtime();
      }
      catch (JSONException paramMessage) {}
      if (((SdkAuthorize.GetAuthApiListResponse)localObject3).redirect_time.has()) {
        this.a.x = (((SdkAuthorize.GetAuthApiListResponse)localObject3).redirect_time.get() * 2);
      }
      if (this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((SdkAuthorize.GetAuthApiListResponse)localObject3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "rec | cmd: G_A_L_D | authorized");
        }
        this.a.jdField_f_of_type_Boolean = true;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.v);
        if (((SdkAuthorize.GetAuthApiListResponse)localObject3).auth_response != null) {
          this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = ((SdkAuthorize.AuthorizeResponse)((SdkAuthorize.GetAuthApiListResponse)localObject3).auth_response.get());
        }
        if ((this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse == null) && (this.a.jdField_c_of_type_Boolean))
        {
          this.a.j();
          return true;
          paramMessage = String.format(this.a.getResources().getString(2131369836), new Object[] { ((SdkAuthorize.GetAuthApiListResponse)localObject3).msg.get(), Integer.valueOf(i) });
          continue;
        }
        if (!this.a.jdField_b_of_type_Boolean) {
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
        paramMessage = new HashMap();
        paramMessage.put("appid", AuthorityActivity.y);
        paramMessage.put("p1", "logged");
        paramMessage.put("p2", "auth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, paramMessage, "");
        this.a.b("wtl_loggednunauthorized", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        if ((this.a.jdField_b_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SDKQQAgentPref", 2, "AutoLogin: " + SystemClock.elapsedRealtime());
          }
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          paramMessage = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
          paramMessage.what = 1;
          paramMessage.obj = this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
          this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(paramMessage);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        long l = Long.parseLong(AuthorityActivity.y);
        this.a.a(l);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "rec | cmd: G_A_L_D | not authorized");
        }
        this.a.jdField_f_of_type_Boolean = false;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.w);
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramMessage = new HashMap();
        paramMessage.put("appid", AuthorityActivity.y);
        paramMessage.put("p1", "logged");
        paramMessage.put("p2", "uauth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, paramMessage, "");
        if (!this.a.jdField_e_of_type_Boolean) {
          this.a.b("wtl_loggednauthorized", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "AUTHORIZE_DONE:" + SystemClock.elapsedRealtime());
      }
      Object localObject1 = (SdkAuthorize.AuthorizeResponse)paramMessage.obj;
      i = ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get();
      if (i != 0)
      {
        QLog.d("AuthorityActivity", 1, "rec | cmd: A_D | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + i);
        try
        {
          localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get();
          paramMessage = "";
          if (i == 110405) {
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramMessage = String.format(this.a.getResources().getString(2131369831), new Object[] { Integer.valueOf(i) });
              this.a.a(paramMessage, new wqd(this));
            }
          }
          while (i != 1105030) {
            for (;;)
            {
              this.a.b(i, paramMessage);
              return true;
              paramMessage = String.format(this.a.getResources().getString(2131369836), new Object[] { localObject2, Integer.valueOf(i) });
            }
          }
          this.a.d(i, (String)localObject2);
          paramMessage = this.a.a(AuthorityActivity.y, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          if ((paramMessage != null) && (paramMessage.length > 0))
          {
            localObject3 = new SdkAuthorize.AuthorizeResponse();
            try
            {
              paramMessage = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom(paramMessage);
              localObject3 = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
              ((Message)localObject3).what = 1;
              ((Message)localObject3).obj = paramMessage;
              this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage((Message)localObject3);
              return true;
            }
            catch (InvalidProtocolBufferMicroException paramMessage) {}
          }
          this.a.c(i, (String)localObject2);
          return true;
        }
        catch (JSONException paramMessage) {}
      }
      this.a.b(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
      this.a.a(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get(), ((SdkAuthorize.AuthorizeResponse)localObject1).encrytoken.get());
      try
      {
        paramMessage = new JSONObject();
        paramMessage.put("ret", ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get());
        paramMessage.put("openid", ((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
        paramMessage.put("access_token", ((SdkAuthorize.AuthorizeResponse)localObject1).access_token.get());
        paramMessage.put("pay_token", ((SdkAuthorize.AuthorizeResponse)localObject1).pay_token.get());
        paramMessage.put("expires_in", ((SdkAuthorize.AuthorizeResponse)localObject1).expires_in.get());
        paramMessage.put("pf", ((SdkAuthorize.AuthorizeResponse)localObject1).pf.get());
        paramMessage.put("pfkey", ((SdkAuthorize.AuthorizeResponse)localObject1).pfkey.get());
        paramMessage.put("msg", ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get());
        paramMessage.put("login_cost", this.a.jdField_f_of_type_Long - this.a.jdField_e_of_type_Long);
        paramMessage.put("query_authority_cost", this.a.jdField_h_of_type_Long - this.a.jdField_g_of_type_Long);
        if (this.a.j == 0L)
        {
          paramMessage.put("authority_cost", 0);
          if (((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.has()) {
            paramMessage.put("sendinstall", ((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.get());
          }
          if ((((SdkAuthorize.AuthorizeResponse)localObject1).installwording.has()) && (!TextUtils.isEmpty(((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get()))) {
            paramMessage.put("installwording", ((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get());
          }
          if ((!((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.has()) || (((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.size() <= 0)) {
            break label2042;
          }
          localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SdkAuthorize.PassData)((Iterator)localObject2).next();
            paramMessage.put(((SdkAuthorize.PassData)localObject3).key.get(), ((SdkAuthorize.PassData)localObject3).value.get());
          }
        }
      }
      catch (JSONException paramMessage)
      {
        localObject1 = new HashMap();
        if (this.a.jdField_h_of_type_Boolean) {}
        for (paramMessage = "1";; paramMessage = "0")
        {
          ((HashMap)localObject1).put("autologin", paramMessage);
          if (!this.a.jdField_e_of_type_Boolean) {
            break label2163;
          }
          if (!this.a.jdField_f_of_type_Boolean) {
            break label2071;
          }
          ((HashMap)localObject1).put("appid", AuthorityActivity.y);
          ((HashMap)localObject1).put("p1", "notlogged");
          ((HashMap)localObject1).put("p2", "auth");
          StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
          this.a.b("wtl_lognback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          break;
          paramMessage.put("authority_cost", this.a.j - this.a.i);
          break label1733;
          this.a.b(((SdkAuthorize.AuthorizeResponse)localObject1).ret.get(), paramMessage.toString(), null, null);
          break label1874;
        }
        ((HashMap)localObject1).put("appid", AuthorityActivity.y);
        ((HashMap)localObject1).put("p1", "notlogged");
        ((HashMap)localObject1).put("p2", "uauth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_lognauthorizenback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
      }
      break;
      if (this.a.jdField_f_of_type_Boolean)
      {
        ((HashMap)localObject1).put("appid", AuthorityActivity.y);
        ((HashMap)localObject1).put("p1", "logged");
        ((HashMap)localObject1).put("p2", "auth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_loggednunauthorizedback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        break;
      }
      ((HashMap)localObject1).put("appid", AuthorityActivity.y);
      ((HashMap)localObject1).put("p1", "logged");
      ((HashMap)localObject1).put("p2", "uauth");
      StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
      this.a.b("wtl_loggednauthorizedback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
      break;
      paramMessage = (SdkAuthorize.GetAuthApiListRequest)paramMessage.obj;
      this.a.a(paramMessage);
      break;
      paramMessage = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.appName != null) && (!TextUtils.isEmpty(paramMessage.appName.get())))
      {
        localObject1 = paramMessage.appName.get();
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject1, null);
      }
      if ((this.a.jdField_g_of_type_Boolean) || (paramMessage == null) || (paramMessage.iconsURL == null) || (!paramMessage.iconsURL.has())) {
        break;
      }
      int m = 0;
      int j = 0;
      i = 0;
      if (i < paramMessage.iconsURL.get().size()) {
        localObject1 = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
      }
      for (;;)
      {
        try
        {
          k = Integer.parseInt(((GetAppInfoProto.MsgIconsurl)localObject1).size.get());
          if (k >= 100)
          {
            paramMessage = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
            if (paramMessage == null) {
              break;
            }
            ThreadManager.d(new wqe(this, paramMessage));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int k = 0;
          continue;
          int n = m;
          if (k > m)
          {
            j = i;
            n = k;
          }
          i += 1;
          m = n;
        }
        break label2468;
        paramMessage = (Bitmap)paramMessage.obj;
        this.a.jdField_g_of_type_Boolean = true;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("", paramMessage);
        break;
        this.a.a();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getResources().getString(2131369835));
        if ((this.a.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        break;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        this.a.b(i, paramMessage);
        break;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        if (this.a.l) {
          break;
        }
        localObject2 = paramMessage.getData();
        i = ((Bundle)localObject2).getInt("error", -1);
        paramMessage = ((Bundle)localObject2).getString("response");
        String str = ((Bundle)localObject2).getString("msg");
        localObject2 = ((Bundle)localObject2).getString("detail");
        this.a.b(i, paramMessage, str, (String)localObject2);
        break;
        i = j;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */