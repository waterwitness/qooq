import VACDReport.ReportBody;
import VACDReport.ReportInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ove
  implements Runnable
{
  public ove(VACDReportMgr paramVACDReportMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject2;
      long l;
      synchronized ()
      {
        try
        {
          if (!VACDReportMgr.a(this.a).isEmpty()) {
            break label221;
          }
          VACDReportMgr.a().wait();
          continue;
          Iterator localIterator;
          localObject2 = (Map.Entry)localIterator.next();
        }
        catch (InterruptedException localInterruptedException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "Write report info size=" + VACDReportMgr.a(this.a).size());
          }
          localIterator = VACDReportMgr.a(this.a).entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
        }
        l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
        localObject2 = (ReportInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((ReportInfo)localObject2).body.reportItems.isEmpty())) {
          continue;
        }
        if (((ReportInfo)localObject2).header == null) {
          break label233;
        }
        VACDReportMgr.a(this.a).a(((ReportInfo)localObject2).body.sKey, ((ReportInfo)localObject2).header);
        ((ReportInfo)localObject2).header = null;
        VACDReportMgr.a(this.a).a(l, ((ReportInfo)localObject2).body.reportItems);
        ((ReportInfo)localObject2).body.reportItems.clear();
      }
      label221:
      VACDReportMgr.a().wait(700L);
      continue;
      label233:
      if (!TextUtils.isEmpty(((ReportInfo)localObject2).body.sKey)) {
        VACDReportMgr.a(this.a).a(l, ((ReportInfo)localObject2).body.sKey);
      }
    }
    VACDReportMgr.b(this.a).post(this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */