import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.data.ScheduleReminderMgr;

public class ybp
  implements Runnable
{
  public ybp(ScheduleReminderMgr paramScheduleReminderMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b(ScheduleReminderMgr.a(this.a));
    ScheduleReminderMgr.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */