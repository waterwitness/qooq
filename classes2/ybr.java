import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.data.ScheduleReminderMgr.onScheduleTipsListener;
import cooperation.dingdong.data.ScheduleTipsDialog;

public class ybr
  implements ScheduleReminderMgr.onScheduleTipsListener
{
  public ybr(ScheduleTipsDialog paramScheduleTipsDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    ScheduleTipsDialog.a(this.a, paramScheduleSummaryData);
  }
  
  public boolean a()
  {
    if (this.a.isFinishing()) {
      return false;
    }
    return ScheduleTipsDialog.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */