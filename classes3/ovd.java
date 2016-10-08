import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class ovd
  extends Handler
{
  public ovd(VACDReportMgr paramVACDReportMgr, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message arg1)
  {
    Object[] arrayOfObject = (Object[])???.obj;
    Object localObject4;
    ReportItem localReportItem2;
    String str1;
    long l;
    String str2;
    switch (???.arg1)
    {
    default: 
      return;
    case 1: 
      synchronized (VACDReportMgr.a())
      {
        localObject4 = (ReportHeader)arrayOfObject[1];
        if ((ReportInfo)VACDReportMgr.a(this.a).get(Long.valueOf(((ReportHeader)localObject4).seqno)) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "start report seqno=" + ((ReportHeader)localObject4).seqno + " is exist ignore...");
          }
          return;
        }
      }
      localReportItem2 = (ReportItem)localObject1[2];
      str1 = (String)localObject1[0];
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.header = ((ReportHeader)localObject4);
      localReportInfo.body = new ReportBody();
      localReportInfo.body.sKey = str1;
      localReportInfo.body.reportItems = new ArrayList(16);
      localReportInfo.body.startTime = ((ReportHeader)localObject4).createTime;
      if (localReportItem2 != null) {
        localReportInfo.body.reportItems.add(localReportItem2);
      }
      VACDReportMgr.a(this.a).put(Long.valueOf(((ReportHeader)localObject4).seqno), localReportInfo);
      VACDReportMgr.a().notify();
      return;
    case 2: 
      synchronized (VACDReportMgr.a())
      {
        l = ((Long)str1[0]).longValue();
        localObject4 = (ReportInfo)VACDReportMgr.a(this.a).get(Long.valueOf(l));
        if (localObject4 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "addReportItem seqno=" + l + " is illegal, please check call startReport first.");
          }
          return;
        }
      }
      localReportItem2 = (ReportItem)localObject2[2];
      ((ReportInfo)localObject4).body.reportItems.add(localReportItem2);
      str2 = (String)localObject2[1];
      if (!TextUtils.isEmpty(str2)) {
        ((ReportInfo)localObject4).body.sKey = str2;
      }
      return;
    }
    synchronized (VACDReportMgr.a())
    {
      l = ((Long)str2[0]).longValue();
      localObject4 = (ReportInfo)VACDReportMgr.a(this.a).remove(Long.valueOf(l));
      if (localObject4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VACDReport", 2, "end report seqno=" + l + " is illegal, please check call startReport first.");
        }
        return;
      }
    }
    ReportItem localReportItem1 = (ReportItem)localObject3[1];
    ((ReportInfo)localObject4).body.reportItems.add(localReportItem1);
    VACDReportMgr.a(this.a).a(l, ((ReportInfo)localObject4).body.reportItems);
    VACDReportMgr.a(this.a).a(l);
    VACDReportMgr.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */