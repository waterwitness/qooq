import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.IdleTask;
import java.util.ArrayList;

public class wjq
  implements MessageQueue.IdleHandler
{
  public wjq(SwiftBrowserIdleTaskHelper paramSwiftBrowserIdleTaskHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!SwiftBrowserIdleTaskHelper.a().isEmpty())
    {
      localObject = (SwiftBrowserIdleTaskHelper.IdleTask)SwiftBrowserIdleTaskHelper.a().remove(0);
      i = ((SwiftBrowserIdleTaskHelper.IdleTask)localObject).a();
      if (2 == i) {
        SwiftBrowserIdleTaskHelper.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (SwiftBrowserIdleTaskHelper.a().isEmpty()) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      SwiftBrowserIdleTaskHelper.a((SwiftBrowserIdleTaskHelper)localObject, bool);
      return SwiftBrowserIdleTaskHelper.a(this.a);
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */