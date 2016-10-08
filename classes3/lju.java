import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lju
  extends Handler
{
  public lju(FreshNewsEditActivity paramFreshNewsEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    FreshNewsEditActivity.c(this.a);
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */