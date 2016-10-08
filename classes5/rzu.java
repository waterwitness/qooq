import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rzu
  implements Runnable
{
  public rzu(UniformDownloadMgr paramUniformDownloadMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (UniformDownloadMgr.a(this.a))
    {
      if (UniformDownloadMgr.a(this.a).size() > 0)
      {
        Iterator localIterator = UniformDownloadMgr.a(this.a).entrySet().iterator();
        while (localIterator.hasNext())
        {
          sae localsae = (sae)((Map.Entry)localIterator.next()).getValue();
          if ((localsae != null) && (localsae.a != null) && (localsae.a.b()) && (2 == localsae.a.g())) {
            localArrayList.add(localsae);
          }
        }
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext()) {
      ((sae)((Iterator)???).next()).a.e();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */