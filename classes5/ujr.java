import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.ISameStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ujr
  extends AsyncTask
{
  public ujr(StatusManager paramStatusManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected ArrayList a(Void... paramVarArgs)
  {
    return this.a.a();
  }
  
  protected void a(ArrayList paramArrayList)
  {
    StatusManager.b(this.a, paramArrayList);
    StatusManager.b(this.a, null);
    if (StatusManager.c(this.a) != null)
    {
      paramArrayList = this.a.a(StatusManager.b(this.a), StatusManager.c(this.a), StatusManager.b(this.a));
      StatusManager.a(this.a, null);
      if (StatusManager.c(this.a) != null)
      {
        Iterator localIterator = StatusManager.c(this.a).iterator();
        if (localIterator.hasNext())
        {
          ISameStatusListener localISameStatusListener = (ISameStatusListener)localIterator.next();
          int i = StatusManager.b(this.a);
          if ((StatusManager.a(this.a) != null) && (StatusManager.a(this.a).length > 1)) {}
          for (boolean bool = true;; bool = false)
          {
            localISameStatusListener.a(true, true, i, paramArrayList, bool);
            break;
          }
        }
      }
    }
  }
  
  protected void onCancelled()
  {
    StatusManager.b(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */