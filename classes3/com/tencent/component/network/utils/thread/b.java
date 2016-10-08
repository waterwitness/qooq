package com.tencent.component.network.utils.thread;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class b
  extends AsyncTask.e<Params, Result>
{
  b(AsyncTask paramAsyncTask)
  {
    super((byte)0);
  }
  
  public final Result call()
    throws Exception
  {
    AsyncTask.a(this.b).set(true);
    Process.setThreadPriority(10);
    return (Result)AsyncTask.b(this.b, this.b.doInBackground(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\thread\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */