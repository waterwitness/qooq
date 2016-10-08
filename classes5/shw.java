import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class shw
  implements Runnable
{
  public shw(FMSettings paramFMSettings)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.a.keySet().iterator();
    Object localObject;
    for (long l = 0L; localIterator.hasNext(); l += FMSettings.a(this.a, (String)localObject, localArrayList))
    {
      localObject = (String)localIterator.next();
      localObject = (sih)this.a.a.get(localObject);
      localObject = FMSettings.b(this.a, ((sih)localObject).b + ((sih)localObject).c);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */