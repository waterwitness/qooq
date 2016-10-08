import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sjd
  extends DirectForwarder.CallBack
{
  public sjd(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    try
    {
      DirectForwarder.a(this.a, paramAsyncTask, paramInt, new sje(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */