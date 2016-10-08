import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.List;

public class tet
  implements Runnable
{
  public tet(EmoticonManager paramEmoticonManager, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager)
    {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a(EmoticonTab.class.getSimpleName());
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a();
      try
      {
        localEntityTransaction.a();
        int j = this.jdField_a_of_type_JavaUtilList.size();
        int i = 0;
        while (i < j)
        {
          String str = (String)this.jdField_a_of_type_JavaUtilList.get(i);
          EmoticonTab localEmoticonTab = new EmoticonTab();
          localEmoticonTab.setStatus(1000);
          localEmoticonTab.epId = str;
          this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localEmoticonTab);
          i += 1;
        }
        localEntityTransaction.c();
        localEntityTransaction.b();
        EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, true);
        return;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */