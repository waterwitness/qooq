import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class ljn
  implements View.OnClickListener
{
  public ljn(ForwardRecentActivity paramForwardRecentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    int i = paramView.getIntExtra("req_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->addQZoneEntry--onClick--req_type = " + i);
    }
    Bundle localBundle = paramView.getExtras();
    Object localObject = localBundle.getString("image_url_remote");
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = localBundle.getString("image_url");
    }
    localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramView))
    {
      paramView = paramView.split(";");
      i = 0;
      while (i < paramView.length)
      {
        ((ArrayList)localObject).add(URLDecoder.decode(paramView[i]));
        i += 1;
      }
    }
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    localBundle.putString("share_action", "shareToQQ");
    localBundle.putString("jfrom", "login");
    localBundle.putBoolean("thirdPartShare", true);
    com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
    QZoneShareManager.a(this.a.app, this.a, localBundle, null);
    paramView = new QZoneClickReport.ReportInfo();
    paramView.c = "1";
    paramView.d = "0";
    paramView.b = 4;
    paramView.k = "5";
    paramView.l = "thirdApp";
    paramView.m = "activefeed";
    QZoneClickReport.startReportImediately(this.a.app.getAccount(), paramView);
    paramView = new HashMap();
    paramView.put("source_type", "5");
    paramView.put("source_from", "thirdApp");
    paramView.put("source_to", "activefeed");
    StatisticCollector.a(this.a.getApplicationContext()).a(this.a.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
    if (this.a.a) {
      ReportCenter.a().a(this.a.app.getAccount(), "", this.a.k, "1000", "33", "0", false);
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ljn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */