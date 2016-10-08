import android.os.Handler;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;

public class snu
  implements Runnable
{
  public snu(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    Object[] arrayOfObject = NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount());
    long l2 = 0L;
    int i = j;
    long l1 = l2;
    if (arrayOfObject != null)
    {
      i = j;
      l1 = l2;
      if (arrayOfObject.length == 2)
      {
        i = j;
        l1 = l2;
        if ((arrayOfObject[0] instanceof Long))
        {
          i = j;
          l1 = l2;
          if ((arrayOfObject[1] instanceof Integer))
          {
            l1 = ((Long)arrayOfObject[0]).longValue();
            i = ((Integer)arrayOfObject[1]).intValue();
          }
        }
      }
    }
    if (NearbyCmdHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, l1, i)) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */