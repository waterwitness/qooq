import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vqo
  extends DirectForwarder.CallBack
{
  public vqo(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a, paramAsyncTask, paramInt, new vqp(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */