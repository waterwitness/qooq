package cooperation.qzone;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import yjz;

public class CrashNotificationActivity
  extends Activity
{
  private Dialog a;
  
  public CrashNotificationActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903421);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131298535);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131298534);
    localObject = (TextView)((Window)localObject).findViewById(2131298529);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131369247) + "6.5.5" + getString(2131369248));
    localObject = new yjz(this);
    localButton1.setOnClickListener((View.OnClickListener)localObject);
    localButton2.setOnClickListener((View.OnClickListener)localObject);
    return localAlertDialog;
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    try
    {
      this.a = a();
      if (this.a != null)
      {
        this.a.setCancelable(false);
        this.a.show();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a();
      }
    }
  }
  
  public void a()
  {
    finish();
  }
  
  public void finish()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903420);
    b();
  }
  
  public void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\CrashNotificationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */