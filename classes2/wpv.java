import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.util.HandlerPlus;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class wpv
  implements BusinessObserver
{
  public wpv(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("ssoAccount");
    if (!this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a.equals(str)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    if (!this.a.b) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    paramInt = paramBundle.getInt("code");
    if (!this.a.j) {}
    for (str = "g_a_a_l_emp";; str = "g_a_a_l")
    {
      SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse;
      if (paramBoolean)
      {
        this.a.A = 0;
        localGetAuthApiListResponse = new SdkAuthorize.GetAuthApiListResponse();
      }
      for (;;)
      {
        try
        {
          localObject = paramBundle.getByteArray("data");
          paramBundle = (Bundle)localObject;
          if (!this.a.j) {
            paramBundle = this.a.b((byte[])localObject);
          }
          if (paramBundle != null)
          {
            l1 = paramBundle.length;
            paramBundle = (SdkAuthorize.GetAuthApiListResponse)localGetAuthApiListResponse.mergeFrom(paramBundle);
            if (paramBundle != null)
            {
              localObject = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
              ((Message)localObject).what = 0;
              ((Message)localObject).obj = paramBundle;
              this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage((Message)localObject);
              i = paramBundle.toByteArray().length;
              l2 = i;
            }
          }
        }
        catch (Exception paramBundle)
        {
          long l1;
          int i;
          long l2;
          Object localObject = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
          ((Message)localObject).what = 6;
          ((Message)localObject).arg1 = 3001;
          ((Message)localObject).obj = this.a.getResources().getString(2131369833);
          this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage((Message)localObject);
          localObject = (String)((Message)localObject).obj;
          QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + paramInt, paramBundle);
          continue;
        }
        try
        {
          i = paramBundle.ret.get();
          ReportManager.a().a("agent_query_authority", this.a.g, l1, l2, 0, Long.parseLong(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a), "1000069", "ret: " + i);
          OpenSdkStatic.a().a(0, "LOGIN_GETAUTHLIST_AGENT", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, AuthorityActivity.y, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
          ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, "", AuthorityActivity.y, "1", "2", "0", false);
          QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + paramInt);
          this.a.h = SystemClock.elapsedRealtime();
          LogUtility.c("Authority_TimeCost", "<TimeStamp> query authority cost : " + (this.a.h - this.a.g));
          return;
        }
        catch (Exception paramBundle)
        {
          LogUtility.c("AuthorityActivity", "-->report exception cmd: agent_query_authority", paramBundle);
          continue;
        }
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : failed" + " | code : " + paramInt);
        this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        if ((paramInt == 1002) && (this.a.A < 2))
        {
          this.a.i();
          paramBundle = this.a;
          paramBundle.A += 1;
          return;
        }
        paramBundle = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
        paramBundle.what = 6;
        paramBundle.arg1 = 3001;
        paramBundle.obj = this.a.getResources().getString(2131369833);
        this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(paramBundle);
        paramBundle = this.a.getResources().getString(2131369833);
        try
        {
          ReportManager.a().a("agent_query_authority", this.a.g, 0L, 0L, paramInt, Long.parseLong(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a), "1000069", paramBundle);
          OpenSdkStatic.a().a(1, "LOGIN_GETAUTHLIST_AGENT", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, AuthorityActivity.y, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt, 1, paramBundle);
          ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, "", AuthorityActivity.y, "1", "2", "" + paramInt, false);
          ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, "", AuthorityActivity.y, "1", "6", "" + paramInt, false);
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */