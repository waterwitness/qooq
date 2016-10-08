import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sdn
  extends DirectForwarder.CallBack
{
  sdn(sdm paramsdm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a.a, paramAsyncTask, paramInt, new sdo(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */