import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oxl
  implements Runnable
{
  public oxl(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReportController.b(this.a.a, "CliOper", "", "", "0X8004C0A", "0X8004C0A", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */