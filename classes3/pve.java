import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class pve
  implements Runnable
{
  public pve(CircleManager paramCircleManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c.iterator();
      while (localIterator.hasNext()) {
        ((IFriendObserver)localIterator.next()).a(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */