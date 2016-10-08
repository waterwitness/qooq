import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import java.util.concurrent.ScheduledFuture;

public class szj
{
  private long jdField_a_of_type_Long;
  private TimerTaskManager.TimerTaskRunnable jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  
  private szj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRunnable = new szk(this);
    this.jdField_a_of_type_Long = Long.MIN_VALUE;
  }
  
  public static szj a(TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    szj localszj = new szj();
    TimerTaskManager.TimerTaskRunnable.a(paramTimerTaskRunnable, true);
    localszj.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = paramTimerTaskRunnable;
    return localszj;
  }
  
  public String toString()
  {
    boolean bool2 = false;
    long l = this.jdField_a_of_type_Long;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable != null)
    {
      bool1 = bool2;
      if (TimerTaskManager.TimerTaskRunnable.a(this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable)) {
        bool1 = true;
      }
    }
    return String.format("Period = %d; IsValid = %b;", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */