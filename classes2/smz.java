import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class smz
  implements Runnable
{
  public smz(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, i, 0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */