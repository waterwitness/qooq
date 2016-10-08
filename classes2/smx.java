import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;

public class smx
  implements Runnable
{
  public smx(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyMyTabCard localNearbyMyTabCard = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
    this.a.b = System.currentTimeMillis();
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.arg1 = 1;
    localMessage.obj = localNearbyMyTabCard;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */