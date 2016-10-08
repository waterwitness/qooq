import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.data.FreshNewsDataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class smm
  implements Handler.Callback
{
  public smm(FreshNewsFragment paramFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b();
      this.a.a(0L);
      return true;
    case 1: 
      localObject1 = Long.valueOf(0L);
      if (paramMessage.obj != null) {
        localObject1 = (Long)paramMessage.obj;
      }
      boolean bool1;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if (paramMessage.arg2 != 1) {
          break label313;
        }
      }
      label313:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramMessage = new ArrayList();
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a();
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          paramMessage.addAll((Collection)localObject2);
        }
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b();
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          paramMessage.addAll((Collection)localObject2);
        }
        localObject2 = new ArrayList();
        FreshNewsDataFactory.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramMessage, (List)localObject2);
        paramMessage = new Bundle();
        paramMessage.putBoolean("hasMore", this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a());
        paramMessage.putBoolean("isSuccess", bool1);
        paramMessage.putBoolean("isPullToRefresh", bool2);
        localObject2 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, 0, localObject2);
        ((Message)localObject2).setData(paramMessage);
        if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        }
        if (((Long)localObject1).longValue() <= 0L) {
          break label319;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, ((Long)localObject1).longValue());
        return true;
        bool1 = false;
        break;
      }
      label319:
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      return true;
    }
    if (paramMessage.obj != null) {}
    for (Object localObject1 = (byte[])paramMessage.obj;; localObject1 = null)
    {
      localObject2 = (FreshNewsHandler)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1);
      if (paramMessage.arg1 == 1)
      {
        ((FreshNewsHandler)localObject2).a((byte[])localObject1, true);
        return true;
      }
      ((FreshNewsHandler)localObject2).a((byte[])localObject1, false);
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */