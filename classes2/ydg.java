import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.utils.MultiAsyncDataHelper;
import cooperation.huangye.utils.MultiAsyncDataHelper.DataListener;
import cooperation.huangye.utils.MultiAsyncDataHelper.MultiAsyncDataTask;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;

public class ydg
  extends TimerTask
{
  public ydg(MultiAsyncDataHelper paramMultiAsyncDataHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a)
    {
      long l = System.currentTimeMillis();
      Iterator localIterator1;
      Map.Entry localEntry;
      do
      {
        localIterator1 = MultiAsyncDataHelper.a(this.a).entrySet().iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)localIterator1.next();
          localIterator2 = ((List)localEntry.getValue()).iterator();
        }
        MultiAsyncDataHelper.MultiAsyncDataTask localMultiAsyncDataTask = (MultiAsyncDataHelper.MultiAsyncDataTask)localIterator2.next();
        if (l - localMultiAsyncDataTask.jdField_a_of_type_Long > localMultiAsyncDataTask.b)
        {
          localMultiAsyncDataTask.jdField_a_of_type_CooperationHuangyeUtilsMultiAsyncDataHelper$DataListener.a(false, localEntry.getKey(), null);
          localIterator2.remove();
        }
      } while (((List)localEntry.getValue()).size() != 0);
      localIterator1.remove();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */