import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.RedPacketServlet;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class tuk
  implements Runnable
{
  public tuk(RedPacketServlet paramRedPacketServlet, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalRedPacketServlet.getAppRuntime().startServlet((NewIntent)this.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */