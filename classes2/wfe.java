import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

public class wfe
  implements BusinessObserver
{
  public wfe(HealthStepCounterPlugin paramHealthStepCounterPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str;
    if (paramBoolean)
    {
      str = paramBundle.getString("json_string");
      paramBundle = paramBundle.getString("StepInfoJSON");
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "HealthStepCounterPlugin receive stepInfoJson:" + paramBundle);
      }
      if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramBundle)))
      {
        if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.a.h = paramBundle;
        }
        if (System.currentTimeMillis() - HealthStepCounterPlugin.jdField_a_of_type_Long >= 4000L) {
          break label101;
        }
      }
    }
    return;
    label101:
    HealthStepCounterPlugin.jdField_a_of_type_Long = System.currentTimeMillis();
    HealthStepCounterPlugin.a(this.a, str, paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */