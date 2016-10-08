import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;

class qbo
  implements Runnable
{
  qbo(qbn paramqbn, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (NewFriendManager.a(this.jdField_a_of_type_Qbn.a))
      {
        Iterator localIterator = NewFriendManager.a(this.jdField_a_of_type_Qbn.a).iterator();
        if (localIterator.hasNext()) {
          ((NewFriendManager.INewFriendListener)localIterator.next()).a();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */