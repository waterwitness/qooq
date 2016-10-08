package cooperation.c2b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class C2BDestoryReceiver
  extends BroadcastReceiver
{
  private static final String a = "C2BDestoryReceiver";
  protected WeakReference a;
  private String b;
  
  public C2BDestoryReceiver(String paramString, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "";
    this.b = paramString;
    this.a = new WeakReference(paramActivity);
  }
  
  public static BroadcastReceiver a(Activity paramActivity, Intent paramIntent)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.c2b.action.C2B_DESTORY");
    C2BDestoryReceiver localC2BDestoryReceiver = new C2BDestoryReceiver(paramIntent.getStringExtra("caller"), paramActivity);
    paramActivity.registerReceiver(localC2BDestoryReceiver, localIntentFilter);
    if (QLog.isColorLevel()) {
      QLog.i("C2BDestoryReceiver", 2, "register destroy receiver caller = " + paramIntent.getStringExtra("caller") + " , activity = " + paramActivity.getClass().getName());
    }
    return localC2BDestoryReceiver;
  }
  
  public static void a(Activity paramActivity, BroadcastReceiver paramBroadcastReceiver)
  {
    if ((paramActivity != null) && (paramBroadcastReceiver != null)) {
      paramActivity.unregisterReceiver(paramBroadcastReceiver);
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (this.a.get() != null)
    {
      ((Activity)this.a.get()).finish();
      this.a.clear();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(paramContext.getPackageName()))) {
      if (QLog.isColorLevel()) {
        QLog.d("C2BDestoryReceiver", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramIntent.getAction());
      }
    }
    do
    {
      do
      {
        return;
      } while (!"tencent.c2b.action.C2B_DESTORY".equals(localObject));
      paramContext = paramIntent.getStringExtra("caller");
    } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(this.b)));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("receive action:").append(paramIntent.getAction()).append(",caller = ").append(this.b).append(",destroy activity = ");
      if (this.a.get() == null) {
        break label200;
      }
    }
    label200:
    for (paramContext = ((Activity)this.a.get()).getClass().getName();; paramContext = "null")
    {
      QLog.i("C2BDestoryReceiver", 2, paramContext);
      a(paramIntent);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BDestoryReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */