import android.os.AsyncTask;
import com.tencent.mfsdk.collector.FPSCalculator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class kgd
  extends AsyncTask
{
  public kgd(FPSCalculator paramFPSCalculator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = FPSCalculator.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    FPSCalculator.a(this.a).clear();
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */