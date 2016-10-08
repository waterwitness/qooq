import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.CrashGuard;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.concurrent.atomic.AtomicBoolean;

public class yjy
  implements Runnable
{
  public yjy(CrashGuard paramCrashGuard, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_CooperationQzoneCrashGuard.a.set(true);
    QLog.i("QZLog", 1, "clear crash count with no crash");
    LocalMultiProcConfig.a("key_crash_count", 0, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */