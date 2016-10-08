import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class rte
  implements Runnable
{
  rte(rtd paramrtd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.b != null)
    {
      Iterator localIterator = this.a.a.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)this.a.a.b.get(str)).size() == 0) {
          localIterator.remove();
        }
      }
    }
    this.a.a.a.putAll(this.a.a.b);
    this.a.a.j();
    this.a.a.setSelect(0);
    this.a.a.b.clear();
    this.a.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */