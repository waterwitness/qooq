import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class uzv
  extends BroadcastReceiver
{
  uzv(uzt paramuzt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext)) {
      if ((!this.a.a.d) && (this.a.a.jdField_a_of_type_JavaLangRunnable != null))
      {
        this.a.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.a.jdField_a_of_type_JavaLangRunnable);
        this.a.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.a.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "screenBroadcastReceiver action:" + paramContext);
      }
      return;
      if (("android.intent.action.SCREEN_OFF".equals(paramContext)) && (this.a.a.jdField_a_of_type_JavaLangRunnable != null)) {
        this.a.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.a.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */