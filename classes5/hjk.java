import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hjk
  extends Handler
{
  public hjk(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)paramMessage.obj;
      this.a.a(paramMessage, true);
      return;
    }
    paramMessage = (List)paramMessage.obj;
    this.a.a(paramMessage, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */