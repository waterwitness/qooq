import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.MyFreshNewsFragment;
import com.tencent.mobileqq.freshnews.data.FreshNewsDataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class srk
  implements Handler.Callback
{
  public srk(MyFreshNewsFragment paramMyFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    }
    Object localObject;
    label123:
    label223:
    label237:
    do
    {
      return true;
      if (MyFreshNewsFragment.a(this.a))
      {
        bool = MyFreshNewsFragment.a(this.a).c;
        localObject = new ArrayList();
        if (MyFreshNewsFragment.a(this.a))
        {
          paramMessage = MyFreshNewsFragment.a(this.a).a();
          if ((paramMessage != null) && (paramMessage.size() > 0)) {
            ((List)localObject).addAll(paramMessage);
          }
        }
        if (!MyFreshNewsFragment.a(this.a)) {
          break label223;
        }
        paramMessage = MyFreshNewsFragment.a(this.a).c();
        if ((paramMessage != null) && (paramMessage.size() > 0)) {
          ((List)localObject).addAll(paramMessage);
        }
        paramMessage = new ArrayList();
        FreshNewsDataFactory.a(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsActivity, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, (List)localObject, paramMessage);
        if (!bool) {
          break label237;
        }
      }
      for (int i = 1;; i = 0)
      {
        paramMessage = MyFreshNewsFragment.a(this.a).obtainMessage(12, i, 0, paramMessage);
        MyFreshNewsFragment.a(this.a).sendMessage(paramMessage);
        return true;
        bool = MyFreshNewsFragment.a(this.a).d;
        break;
        paramMessage = MyFreshNewsFragment.a(this.a).d();
        break label123;
      }
      if (!NetworkUtil.e(this.a.getActivity()))
      {
        paramMessage = MyFreshNewsFragment.a(this.a).obtainMessage(10, 0, 0);
        MyFreshNewsFragment.a(this.a).sendMessageDelayed(paramMessage, 1000L);
        return true;
      }
      localObject = null;
      if (paramMessage.obj != null) {
        localObject = (byte[])paramMessage.obj;
      }
    } while (MyFreshNewsFragment.e(this.a));
    MyFreshNewsFragment.b(this.a, true);
    paramMessage = this.a;
    if (localObject == null) {
      bool = true;
    }
    MyFreshNewsFragment.c(paramMessage, bool);
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsFragment.getDataFromServer.. cookie=" + localObject);
    }
    if (MyFreshNewsFragment.a(this.a))
    {
      MyFreshNewsFragment.a(this.a).a("0", (byte[])localObject, 20, MyFreshNewsFragment.a(this.a));
      return true;
    }
    if (MyFreshNewsFragment.b(this.a) > 0L)
    {
      MyFreshNewsFragment.a(this.a).a(String.valueOf(MyFreshNewsFragment.b(this.a)), (byte[])localObject, 20, MyFreshNewsFragment.a(this.a));
      return true;
    }
    MyFreshNewsFragment.a(this.a).a(MyFreshNewsFragment.a(this.a), (byte[])localObject, 20, MyFreshNewsFragment.a(this.a), true);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */