import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.util.HandlerPlus;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

public class wpq
  extends SSOAccountObserver
{
  public wpq(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.k = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      ReportManager.a().a("agent_login", this.a.e, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      OpenSdkStatic.a().a(1, "LOGIN_GETTICKT", paramString, AuthorityActivity.y, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      ReportCenter.a().a(paramString, "", AuthorityActivity.y, "1", "1", "" + paramInt1, false);
      ReportCenter.a().a(paramString, "", AuthorityActivity.y, "1", "6", "" + paramInt1, false);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == 64536) || (paramInt2 == 154))
      {
        this.a.f = SystemClock.elapsedRealtime();
        LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
        if ((paramInt1 == 1002) && (this.a.z < 2))
        {
          paramString = this.a;
          paramString.z += 1;
          this.a.f();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131369830));
      paramString = this.a.a.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131369830);
      this.a.a.sendMessage(paramString);
      return;
    }
    this.a.c(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    int i = paramBundle.getInt("code");
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success" + " | code: " + i);
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
    try
    {
      ReportManager.a().a("agent_login", this.a.e, this.a.m.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null);
      OpenSdkStatic.a().a(0, "LOGIN_GETTICKT", paramString, AuthorityActivity.y, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      ReportCenter.a().a(paramString, "", AuthorityActivity.y, "1", "1", "0", false);
      this.a.k = false;
      this.a.z = 0;
      String str = null;
      if (paramInt == 4096) {
        str = new String(paramArrayOfByte);
      }
      this.a.a(paramString, str, paramBundle);
      this.a.f = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    this.a.z = 0;
    this.a.f = SystemClock.elapsedRealtime();
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel" + " | code: " + paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */