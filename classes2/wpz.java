import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.util.HandlerPlus;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class wpz
  implements BusinessObserver
{
  public wpz(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->doAuthorize-onReceive, ssoAccount: " + str + " | uin: " + this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
    }
    if (!this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a.equals(str)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    paramInt = paramBundle.getInt("code");
    if (!this.a.jdField_j_of_type_Boolean) {}
    for (str = "s_a_a_emp";; str = "s_a_a")
    {
      Object localObject2;
      if (paramBoolean)
      {
        this.a.B = 0;
        localObject2 = new SdkAuthorize.AuthorizeResponse();
      }
      for (;;)
      {
        try
        {
          localObject1 = paramBundle.getByteArray("data");
          paramBundle = (Bundle)localObject1;
          if (!this.a.jdField_j_of_type_Boolean) {
            paramBundle = this.a.b((byte[])localObject1);
          }
          if (paramBundle != null)
          {
            l1 = paramBundle.length;
            localObject1 = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject2).mergeFrom(paramBundle);
            if (localObject1 != null)
            {
              localObject2 = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
              ((Message)localObject2).what = 1;
              ((Message)localObject2).obj = localObject1;
              this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage((Message)localObject2);
              if (((SdkAuthorize.AuthorizeResponse)localObject1).ret.get() == 0) {
                this.a.a(AuthorityActivity.y, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, ((SdkAuthorize.AuthorizeResponse)localObject1).expires_in.get(), paramBundle);
              }
              i = ((SdkAuthorize.AuthorizeResponse)localObject1).toByteArray().length;
              l2 = i;
            }
          }
        }
        catch (Exception paramBundle)
        {
          long l1;
          int i;
          long l2;
          Object localObject1 = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
          ((Message)localObject1).what = 6;
          ((Message)localObject1).arg1 = 3002;
          ((Message)localObject1).obj = this.a.getResources().getString(2131369830);
          this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage((Message)localObject1);
          localObject1 = (String)((Message)localObject1).obj;
          QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + paramInt, paramBundle);
          continue;
        }
        try
        {
          i = ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get();
          ReportManager.a().a("agent_authority", this.a.i, l1, l2, 0, Long.parseLong(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a), "1000069", "ret: " + i);
          OpenSdkStatic.a().a(0, "LOGIN_AUTH", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, AuthorityActivity.y, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
          QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + paramInt);
          this.a.jdField_j_of_type_Long = SystemClock.elapsedRealtime();
          LogUtility.c("Authority_TimeCost", "<TimeStamp> authority cost : " + (this.a.jdField_j_of_type_Long - this.a.i));
          return;
        }
        catch (Exception paramBundle)
        {
          LogUtility.c("AuthorityActivity", "-->success report exception cmd: agent_authority", paramBundle);
          continue;
        }
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : failed" + " | code : " + paramInt);
        if ((paramInt == 1002) && (this.a.B < 2))
        {
          paramBundle = this.a;
          paramBundle.B += 1;
          this.a.j();
          return;
        }
        paramBundle = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
        paramBundle.what = 6;
        paramBundle.arg1 = 3002;
        paramBundle.obj = this.a.getResources().getString(2131369830);
        this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(paramBundle);
        paramBundle = this.a.getResources().getString(2131369830);
        try
        {
          ReportManager.a().a("agent_authority", this.a.i, 0L, 0L, paramInt, Long.parseLong(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a), "1000069", paramBundle);
          OpenSdkStatic.a().a(1, "LOGIN_AUTH", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, AuthorityActivity.y, null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, paramBundle);
          ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a, "", AuthorityActivity.y, "1", "6", "" + 3002, false);
        }
        catch (Exception paramBundle)
        {
          LogUtility.c("AuthorityActivity", "-->failed report exception cmd: agent_authority", paramBundle);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */