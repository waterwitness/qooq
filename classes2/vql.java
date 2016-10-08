import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class vql
  implements Runnable
{
  public vql(TroopFileTransferManager.TaskPool paramTaskPool)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a)
    {
      for (;;)
      {
        if (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
          return;
        }
        TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)this.a.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localTask.run();
        if (localTask.f != 0) {
          continue;
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */