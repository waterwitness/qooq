import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.OpenSdkFriendService;
import java.util.ArrayList;

public class wri
  implements Runnable
{
  public wri(OpenSdkFriendService paramOpenSdkFriendService, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a();
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 888802, localArrayList).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */