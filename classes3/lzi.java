import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lzi
  extends BroadcastReceiver
{
  public lzi(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getAction();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.equals((CharSequence)localObject, "mqq.intent.action.DEVLOCK_ROAM")));
      if (paramContext != null) {
        paramContext.unregisterReceiver(this);
      }
      Object localObject = DevlockPhoneStatus.a();
      if (paramIntent.getIntExtra("guardphone_state", DevlockPhoneStatus.e) == DevlockPhoneStatus.d)
      {
        paramIntent = paramIntent.getStringExtra("guardphone_mask");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = "";
        }
        ((DevlockPhoneStatus)localObject).a(this.a, paramContext);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager.a = true;
      paramContext = (SecSvcHandler)this.a.app.a(34);
    } while (paramContext == null);
    this.a.app.a(this.a.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    PhoneUnityBindInfoActivity.a(this.a, this.a.c, 2, 1);
    paramContext.a(4, 31, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */