import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;

public class mce
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  public mce(QQBrowserActivity paramQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Bundle paramBundle)
  {
    switch (this.a.W)
    {
    default: 
      return -1;
    case 1: 
      return this.a.b(paramBundle);
    case 2: 
      return this.a.d(paramBundle);
    case 3: 
      return this.a.e(paramBundle);
    case 4: 
      return this.a.c(paramBundle);
    case 5: 
      return this.a.f(paramBundle);
    case 6: 
      return this.a.g(paramBundle);
    case 7: 
      return this.a.h(paramBundle);
    }
    return this.a.a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */