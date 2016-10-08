import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public final class whr
  implements Runnable
{
  public whr(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = null;
    int i = 1;
    int j = 1;
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_MqqAppAppRuntime.isLogin()))
        {
          if (this.jdField_a_of_type_AndroidContentIntent != null)
          {
            i = j;
            if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("avoidLoginWeb", false)) {
              i = 0;
            }
            localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
          }
          if (i == 0) {
            break;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject2 = AuthorizeConfig.a();
            localObject1 = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
            String str = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
            Object localObject3 = ((AuthorizeConfig)localObject2).a("pt4_token");
            localObject2 = new String[((Set)localObject3).size()];
            localObject3 = ((Set)localObject3).iterator();
            i = 0;
            if (((Iterator)localObject3).hasNext())
            {
              localObject2[i] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
              i += 1;
              continue;
            }
            ((TicketManager)localObject1).GetPskey(str, 16L, (String[])localObject2, null);
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserCookieMonster", 2, "Batch load pt4_token when process preload");
            }
            SwiftBrowserCookieMonster.a(this.jdField_a_of_type_MqqAppAppRuntime);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SwiftBrowserCookieMonster", 2, "Get tickets when load url");
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftBrowserCookieMonster", 2, "preGetKey exception:" + localException.toString());
        }
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */