import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Timer;
import java.util.TimerTask;

public class qdd
  extends TimerTask
{
  public qdd(PrinterStatusHandler paramPrinterStatusHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReportController.b(this.a.b, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (PrinterStatusHandler.a(this.a) != null)
    {
      PrinterStatusHandler.a(this.a).cancel();
      PrinterStatusHandler.a(this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */