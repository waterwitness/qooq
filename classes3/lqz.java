import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class lqz
  implements Runnable
{
  public lqz(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = LebaShowListManager.a().a(this.a.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if (localLebaViewItem != null)
        {
          ReportController.b(this.a.a, "CliOper", "", "", "0X8005416", "0X8005416", 0, 0, localLebaViewItem.a.uiResId + "", "", "", "");
          if (localLebaViewItem.a.uiResId == 3050L) {
            StoryReportor.a("dynamic", "exp_story", 0, ((TroopRedTouchManager)this.a.a.getManager(69)).d(), new String[0]);
          }
        }
      }
    }
    Leba.a(this.a).a();
    QZoneHelper.a(this.a.a, "Leba");
    Leba.a(this.a);
    localObject = (QZoneManagerImp)this.a.a.getManager(9);
    if (localObject != null)
    {
      if (((QZoneManagerImp)localObject).a(1) > 0)
      {
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).c = "1";
        ((QZoneClickReport.ReportInfo)localObject).d = "5";
        QZoneClickReport.report(this.a.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "5");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
    }
    else if (System.currentTimeMillis() - LocalMultiProcConfig.a(BaseApplicationImpl.getContext().getString(2131368471) + this.a.a.getAccount(), 0L) > 86400000L)
    {
      localObject = new HashMap();
      if (!LocalMultiProcConfig.a(BaseApplicationImpl.getContext().getString(2131368470) + this.a.a.getAccount(), true)) {
        break label566;
      }
      ((HashMap)localObject).put("myfeednotifypush", "0");
      label390:
      if (!CliNotifyPush.a(BaseApplicationImpl.getContext(), "com.qzone")) {
        break label578;
      }
      ((HashMap)localObject).put("qzoneinstalled", "0");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      LocalMultiProcConfig.a(BaseApplicationImpl.getContext().getString(2131368471) + this.a.a.getAccount(), System.currentTimeMillis());
      return;
      if (((QZoneManagerImp)localObject).a(2) <= 0) {
        break;
      }
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).c = "1";
      ((QZoneClickReport.ReportInfo)localObject).d = "6";
      QZoneClickReport.report(this.a.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("unread_type", "6");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      break;
      label566:
      ((HashMap)localObject).put("myfeednotifypush", "1");
      break label390;
      label578:
      ((HashMap)localObject).put("qzoneinstalled", "1");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */