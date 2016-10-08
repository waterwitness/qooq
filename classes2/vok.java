import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache;
import com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache.QueueItem;
import java.util.LinkedList;

public class vok
  implements Runnable
{
  public vok(RollangleImageView.ImageCache paramImageCache)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      if (this.a.a) {
        return;
      }
      try
      {
        Thread.sleep(100L);
        synchronized (this.a)
        {
          if (RollangleImageView.ImageCache.a(this.a) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          RollangleImageView.ImageCache.a(this.a).poll();
        }
        if (RollangleImageView.ImageCache.a(this.a).isEmpty()) {
          return;
        }
        RollangleImageView.ImageCache.QueueItem localQueueItem = (RollangleImageView.ImageCache.QueueItem)RollangleImageView.ImageCache.a(this.a).peek();
        ??? = RollangleImageView.a(localQueueItem.jdField_a_of_type_JavaLangString);
        Object localObject3 = localQueueItem;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localQueueItem.jdField_a_of_type_JavaLangString, ???);
        RollangleImageView.ImageCache.a(this.a).obtainMessage(0, new Object[] { localQueueItem.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localQueueItem.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localQueueItem;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */