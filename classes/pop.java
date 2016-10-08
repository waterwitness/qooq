import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class pop
  implements Runnable
{
  public pop(ForwardRecentListAdapter paramForwardRecentListAdapter, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = ForwardRecentListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter, this.jdField_a_of_type_JavaUtilList);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      ThreadManager.c().post(new poq(this, localArrayList));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */