import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sky
  extends DirectForwarder.CallBack
{
  public sky(ForwardBaseOption paramForwardBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a.a, paramAsyncTask, paramInt, new skz(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\sky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */