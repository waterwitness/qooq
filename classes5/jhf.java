import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.webviewplugin.KeyInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class jhf
  implements Runnable
{
  public jhf(KeyInfo paramKeyInfo, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      int i;
      try
      {
        if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (!this.jdField_a_of_type_MqqAppAppRuntime.isLogin())) {
          break label316;
        }
        if (this.jdField_a_of_type_AndroidContentIntent == null) {
          break label310;
        }
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("avoidLoginWeb", false)) {
          break label304;
        }
        i = 0;
        localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        if (i != 0)
        {
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
              QLog.d("KeyInfo", 2, "Batch load pt4_token when process preload");
            }
            this.jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo.b(this.jdField_a_of_type_MqqAppAppRuntime);
            Thread.yield();
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("KeyInfo", 2, "Get tickets when load url");
          continue;
        }
        KeyInfo.b(this.jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo, 1);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("KeyInfo", 2, "preGetKey exception:" + localException.toString());
        }
        KeyInfo.b(this.jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo, 1);
        localException.printStackTrace();
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("KeyInfo", 2, "Not need login tickets");
        continue;
        label304:
        i = 1;
        continue;
        label310:
        i = 1;
        continue;
        label316:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */