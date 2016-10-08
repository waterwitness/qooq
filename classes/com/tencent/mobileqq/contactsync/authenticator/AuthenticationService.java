package com.tencent.mobileqq.contactsync.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class AuthenticationService
  extends Service
{
  public static final String a = "from_add_account";
  private static final String b = "ContactSync.AuthenticationService";
  private Authenticator a;
  
  public AuthenticationService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getIBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ localMobileQQ = (MobileQQ)super.getApplicationContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("k_start_mode", 2);
    localMobileQQ.onActivityCreate(this, localIntent);
    this.a = new Authenticator(this);
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\contactsync\authenticator\AuthenticationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */