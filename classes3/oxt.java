import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class oxt
  implements Handler.Callback
{
  public oxt(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (List)paramMessage.obj;
      if (paramMessage != null)
      {
        this.a.a.clear();
        this.a.a.addAll(paramMessage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */