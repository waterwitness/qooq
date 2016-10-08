import VACDReport.ReportRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class ovg
  implements BusinessObserver
{
  public ovg(VACDReportMgr paramVACDReportMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBundle.containsKey("rsp")) {}
    for (paramBundle = ((ReportRsp)paramBundle.getSerializable("rsp")).headers;; paramBundle = null)
    {
      VACDReportMgr.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */