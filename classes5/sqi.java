import appoint.define.appoint_define.FeedEvent;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class sqi
  implements Runnable
{
  public sqi(FreshNewsManager paramFreshNewsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsManager", 2, "start building cache...");
    }
    FreshNewsManager.a(this.a);
    FreshNewsManager.a(this.a, true);
    for (;;)
    {
      synchronized (FreshNewsManager.a(this.a))
      {
        if (FreshNewsManager.a(this.a).size() <= 0) {
          break label145;
        }
        ArrayList localArrayList = new ArrayList(FreshNewsManager.a(this.a));
        FreshNewsManager.a(this.a).clear();
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          int i = 0;
          if (i < localArrayList.size())
          {
            ??? = (appoint_define.FeedEvent)localArrayList.get(i);
            if (??? != null) {
              this.a.a((appoint_define.FeedEvent)???);
            }
            i += 1;
          }
        }
      }
      return;
      label145:
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */