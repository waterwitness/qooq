import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.utils.SingleAsyncDataHelper;
import cooperation.huangye.utils.SingleAsyncDataHelper.DataListener;
import cooperation.huangye.utils.SingleAsyncDataHelper.SingleAsyncDataTask;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

public class ydh
  extends TimerTask
{
  public ydh(SingleAsyncDataHelper paramSingleAsyncDataHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a)
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = SingleAsyncDataHelper.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        SingleAsyncDataHelper.SingleAsyncDataTask localSingleAsyncDataTask = (SingleAsyncDataHelper.SingleAsyncDataTask)localIterator.next();
        if (l - localSingleAsyncDataTask.jdField_a_of_type_Long > localSingleAsyncDataTask.b)
        {
          localSingleAsyncDataTask.jdField_a_of_type_CooperationHuangyeUtilsSingleAsyncDataHelper$DataListener.a(false, null);
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */