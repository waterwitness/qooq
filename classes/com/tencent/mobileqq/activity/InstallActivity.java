package com.tencent.mobileqq.activity;

import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.SetSplash;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class InstallActivity
  extends AppActivity
  implements Runnable
{
  public static final String a = "NT_AY";
  boolean a;
  
  public InstallActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = false;
  }
  
  /* Error */
  protected boolean doOnCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 31	mqq/app/AppActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: invokevirtual 35	com/tencent/mobileqq/activity/InstallActivity:getIntent	()Landroid/content/Intent;
    //   10: ldc 10
    //   12: invokevirtual 41	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   15: checkcast 37	android/content/Intent
    //   18: astore_2
    //   19: aload_2
    //   20: ifnonnull +59 -> 79
    //   23: new 37	android/content/Intent
    //   26: dup
    //   27: aload_0
    //   28: ldc 43
    //   30: invokestatic 49	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   33: invokespecial 52	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: astore_1
    //   37: aload_1
    //   38: ldc 53
    //   40: invokevirtual 57	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   43: pop
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 61	com/tencent/mobileqq/activity/InstallActivity:startActivity	(Landroid/content/Intent;)V
    //   49: aload_0
    //   50: invokevirtual 64	com/tencent/mobileqq/activity/InstallActivity:finish	()V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_3
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 67	java/lang/ClassNotFoundException:printStackTrace	()V
    //   64: goto -20 -> 44
    //   67: astore_1
    //   68: iconst_m1
    //   69: invokestatic 73	java/lang/System:exit	(I)V
    //   72: goto -19 -> 53
    //   75: astore_2
    //   76: goto -16 -> 60
    //   79: aload_2
    //   80: astore_1
    //   81: goto -37 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	InstallActivity
    //   0	84	1	paramBundle	android.os.Bundle
    //   18	43	2	localObject	Object
    //   75	5	2	localClassNotFoundException1	ClassNotFoundException
    //   55	4	3	localClassNotFoundException2	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   23	37	55	java/lang/ClassNotFoundException
    //   44	53	67	java/lang/Exception
    //   37	44	75	java/lang/ClassNotFoundException
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      setContentView(new LinearLayout(this));
      this.mRuntime = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.a) {
      BaseApplicationImpl.jdField_a_of_type_MqqOsMqqHandler.post(this);
    }
  }
  
  public void run()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources();
    SetSplash.a(this, null);
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\InstallActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */