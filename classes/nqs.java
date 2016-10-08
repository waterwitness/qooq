import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nqs
  extends Handler
{
  public nqs(ThumbItemBuilder paramThumbItemBuilder, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ThumbItemBuilder.a) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */