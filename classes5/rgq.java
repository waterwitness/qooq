import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;

public class rgq
  implements Runnable
{
  public rgq(ChirpSoHandler paramChirpSoHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (ChirpSoHandler.a(this.a))
    {
      Iterator localIterator = ChirpSoHandler.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((ChirpSoHandler.Callback)localIterator.next()).k();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */