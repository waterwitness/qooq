import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iau
  extends Handler
{
  public iau(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    ReadInJoyBaseAdapter.a(this.a, this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */