import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class qnn
  implements Runnable
{
  public qnn(ProxyManager paramProxyManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ProxyManager.a(this.a, System.currentTimeMillis());
    while (!this.a.jdField_a_of_type_Boolean) {
      synchronized (this.a.jdField_a_of_type_JavaUtilVector)
      {
        try
        {
          this.a.jdField_a_of_type_JavaUtilVector.wait(10000L);
          ThreadRegulator.a().b();
          if (((!this.a.jdField_a_of_type_JavaUtilVector.isEmpty()) || (ProxyManager.a(this.a).a().size() > 0)) && (ProxyManager.a(this.a)))
          {
            this.a.c();
            ProxyManager.a(this.a).c();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MsgProxy", 2, "writeRunable Exception:" + localException);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */