import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;

public class qbr
  implements Runnable
{
  public qbr(NewFriendManager paramNewFriendManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager))
    {
      Iterator localIterator = NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager).iterator();
      if (localIterator.hasNext()) {
        ((NewFriendManager.INewFriendListener)localIterator.next()).a(this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */