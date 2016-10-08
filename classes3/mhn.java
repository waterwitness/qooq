import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class mhn
  extends FriendListObserver
{
  public mhn(RecentLoginDevActivity paramRecentLoginDevActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    RecentLoginDevActivity.b(this.a);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult success");
      }
      RecentLoginDevActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = RecentLoginDevActivity.a(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.RecentLoginDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
      }
      RecentLoginDevActivity.a(this.a, RecentLoginDevActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data is null");
    }
    for (;;)
    {
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131370732), 0).b(this.a.getTitleBarHeight());
      return;
      label288:
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onDelHistoryDevResult isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    }
    RecentLoginDevActivity.b(this.a);
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (RecentLoginDevActivity.a(this.a) != null) && (paramInt < RecentLoginDevActivity.a(this.a).size()))
      {
        RecentLoginDevActivity.a(this.a).remove(paramInt);
        RecentLoginDevActivity.a(this.a, RecentLoginDevActivity.a(this.a));
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131370734), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131370655), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */