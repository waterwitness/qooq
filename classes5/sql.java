import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.NotifyListener;
import com.tencent.mobileqq.freshnews.FreshNewsManager.UnpublishedFeedsListener;
import com.tencent.mobileqq.freshnews.FreshNewsPublisher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class sql
  extends Handler
{
  public sql(FreshNewsManager paramFreshNewsManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message arg1)
  {
    Iterator localIterator;
    switch (???.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return;
          FreshNewsInfo localFreshNewsInfo1 = (FreshNewsInfo)???.obj;
          synchronized (this.a.b)
          {
            localIterator = this.a.b.iterator();
            if (localIterator.hasNext()) {
              ((FreshNewsManager.UnpublishedFeedsListener)localIterator.next()).a(localFreshNewsInfo1);
            }
          }
          return;
          FreshNewsInfo localFreshNewsInfo2 = (FreshNewsInfo)???.obj;
          synchronized (this.a.b)
          {
            localIterator = this.a.b.iterator();
            if (localIterator.hasNext()) {
              ((FreshNewsManager.UnpublishedFeedsListener)localIterator.next()).b(localFreshNewsInfo2);
            }
          }
          return;
          synchronized (this.a.b)
          {
            localIterator = this.a.b.iterator();
            if (localIterator.hasNext()) {
              ((FreshNewsManager.UnpublishedFeedsListener)localIterator.next()).a(this.a.a());
            }
          }
        } while ((???.obj == null) || (!(???.obj instanceof FreshNewsInfo)));
        synchronized (this.a.b)
        {
          localIterator = this.a.b.iterator();
          if (localIterator.hasNext()) {
            ((FreshNewsManager.UnpublishedFeedsListener)localIterator.next()).c((FreshNewsInfo)???.obj);
          }
        }
        return;
        ??? = (FreshNewsInfo)???.obj;
        ??? = new FreshNewsPublisher(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.a, ???);
        this.a.jdField_a_of_type_JavaUtilLinkedList.add(???);
      } while (this.a.jdField_a_of_type_Boolean);
      this.a.c();
      return;
    case 5: 
      int i;
      synchronized (FreshNewsManager.b(this.a))
      {
        i = this.a.a(true);
        if (QLog.isDevelopLevel()) {
          QLog.d("FreshNewsManager", 4, "notifyEventCountChanged. count=" + i);
        }
        ??? = FreshNewsManager.b(this.a).iterator();
        if (((Iterator)???).hasNext()) {
          ((FreshNewsManager.NotifyListener)((Iterator)???).next()).a(i);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(2, i, new Object[] { Long.valueOf(this.a.f), Long.valueOf(this.a.e) });
      return;
    }
    ??? = (Object[])???.obj;
    boolean bool = ((Boolean)???[0]).booleanValue();
    FreshNewsInfo localFreshNewsInfo3 = (FreshNewsInfo)???[1];
    synchronized (this.a.b)
    {
      localIterator = this.a.b.iterator();
      if (localIterator.hasNext()) {
        ((FreshNewsManager.UnpublishedFeedsListener)localIterator.next()).a(bool, localFreshNewsInfo3);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */