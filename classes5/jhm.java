import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class jhm
  implements Runnable
{
  public jhm(OfflinePlugin paramOfflinePlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a == null) || (this.a.a.size() == 0)) {
      return;
    }
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.a.b(str);
    }
    this.a.a.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */