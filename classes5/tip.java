import android.os.Handler;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.SpecialNearbyListActivity;

public class tip
  implements Runnable
{
  public tip(SpecialNearbyListActivity paramSpecialNearbyListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    Object[] arrayOfObject = NearbySPUtil.a(this.a.b.getAccount());
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
    if (NearbyCmdHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter, this.a.b, l1, i)) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */