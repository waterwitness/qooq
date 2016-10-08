package cooperation.qzone;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import yjy;

public class CrashGuard
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 0L;
  private static final int b = 15;
  private static final int c = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CrashGuard.CrashListener jdField_a_of_type_CooperationQzoneCrashGuard$CrashListener;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public AtomicBoolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CrashGuard()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static int a()
  {
    return QzoneConfig.a().a("SafeModeSetting", "StartDuration", 15) * 1000;
  }
  
  public static CrashGuard a()
  {
    return CrashGuard.H.a;
  }
  
  public static int b()
  {
    return QzoneConfig.a().a("SafeModeSetting", "CrashMax", 2);
  }
  
  public void a(long paramLong, Handler paramHandler, CrashGuard.CrashListener paramCrashListener)
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_CooperationQzoneCrashGuard$CrashListener = paramCrashListener;
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new yjy(this, paramLong);
    }
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = a();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
  }
  
  public void a(Throwable paramThrowable, long paramLong)
  {
    int j = 0;
    if (this.jdField_a_of_type_CooperationQzoneCrashGuard$CrashListener != null) {
      this.jdField_a_of_type_CooperationQzoneCrashGuard$CrashListener.a(paramThrowable);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    int i = LocalMultiProcConfig.a("key_crash_count", 0, paramLong);
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = a();
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long <= jdField_a_of_type_Int)
    {
      i += 1;
      paramThrowable = String.valueOf(paramLong);
      if (i < b()) {
        break label182;
      }
      i = j;
      if (!TextUtils.isEmpty(paramThrowable))
      {
        String str = SecurityUtil.a(paramThrowable);
        BaseApplication.getContext().deleteDatabase(str);
        QLog.i("QZLog", 1, "crash in a row, delete db for " + paramThrowable);
        i = j;
      }
    }
    label182:
    for (;;)
    {
      LocalMultiProcConfig.a("key_crash_count", i, paramLong);
      return;
      QLog.i("QZLog", 1, "clear crash count with overtime");
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qzone\CrashGuard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */