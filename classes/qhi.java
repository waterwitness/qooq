import android.os.HandlerThread;
import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class qhi
  extends ThreadPoolExecutor
{
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private static qhj jdField_a_of_type_Qhj = new qhj();
  private int jdField_a_of_type_Int;
  private LinkedBlockingQueue jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue;
  private qgw jdField_a_of_type_Qgw;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public qhi(int paramInt1, int paramInt2, long paramLong, BlockingQueue paramBlockingQueue, qdh paramqdh)
  {
    super(paramInt1, paramInt2, paramLong, TimeUnit.SECONDS, paramBlockingQueue, paramqdh, jdField_a_of_type_Qhj);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private static MqqHandler b()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null)
    {
      HandlerThread localHandlerThread = ThreadExcutor.a().a("Rejected_Handler", 10);
      localHandlerThread.start();
      jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
    }
    return jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void a(Job paramJob)
  {
    if (paramJob == null) {
      throw new IllegalArgumentException();
    }
    if (paramJob.a != null) {
      paramJob.a.a();
    }
    execute(paramJob);
  }
  
  public void a(LinkedBlockingQueue paramLinkedBlockingQueue, qgw paramqgw)
  {
    this.jdField_a_of_type_Qgw = paramqgw;
    this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = paramLinkedBlockingQueue;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (ThreadManager.d)
    {
      QLog.i("TM.global", 1, "pool has shutdown:" + paramRunnable.toString());
      return;
    }
    try
    {
      super.execute(paramRunnable);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("TM.global", 1, "commamd:" + paramRunnable.toString(), localOutOfMemoryError);
      b().post(paramRunnable);
      return;
    }
    catch (InternalError paramRunnable)
    {
      QLog.e("TM.global", 1, "java.lang.InternalError: Thread starting during runtime shutdown", paramRunnable);
    }
  }
  
  protected void terminated()
  {
    if (this.jdField_a_of_type_Qgw != null) {
      this.jdField_a_of_type_Qgw.a();
    }
    super.terminated();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */