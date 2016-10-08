import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qzm
  extends Handler
{
  public qzm(LocationSelectActivity paramLocationSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      this.a.a(((Boolean)((Object[])(Object[])paramMessage.obj)[0]).booleanValue(), (String[])((Object[])(Object[])paramMessage.obj)[1]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */