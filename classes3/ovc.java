import VACDReport.ReportBody;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ovc
  implements Runnable
{
  public ovc(VACDReportMgr paramVACDReportMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      long l1;
      Map.Entry localEntry;
      ReportInfo localReportInfo;
      synchronized ()
      {
        l1 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("VACDReport", 2, "LocalTimeOut report info size=" + VACDReportMgr.a(this.a).size());
        }
        Iterator localIterator = VACDReportMgr.a(this.a).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
        localReportInfo = (ReportInfo)localEntry.getValue();
        if (localReportInfo == null) {
          localIterator.remove();
        }
      }
      if (Math.abs(l1 - localReportInfo.body.startTime) >= 2100000L)
      {
        ReportItem localReportItem = new ReportItem();
        localReportItem.step = "payresult";
        localReportItem.params = "";
        localReportItem.createTime = l1;
        localReportItem.result = 668808;
        localReportItem.failReason = "illegalEndReport";
        long l2 = ((Long)localEntry.getKey()).longValue();
        localReportInfo.body.reportItems.add(localReportItem);
        VACDReportMgr.a(this.a).a(l2, localReportInfo.body.reportItems);
        VACDReportMgr.a(this.a).a(l2);
        ((Iterator)localObject).remove();
      }
      VACDReportMgr.a(this.a);
      VACDReportMgr.a(this.a).postDelayed(this, 2100000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */