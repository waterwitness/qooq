import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class qrm
  implements qrt
{
  public qrm(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String[] arg1)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (??? != null)
    {
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        localArrayList1.add(???[i]);
        i += 1;
      }
    }
    boolean bool1 = ArkLocalAppMgr.a();
    label342:
    for (;;)
    {
      synchronized (ArkLocalAppMgr.a(this.a))
      {
        localObject = ArkLocalAppMgr.a(this.a).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (localArrayList1.contains(str)) {
            break label342;
          }
          localArrayList1.add(str);
          bool1 = true;
          break label342;
        }
        ArkLocalAppMgr.a(this.a).clear();
        if (localArrayList1.isEmpty())
        {
          ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, update app list is empty.", new Object[0]));
          return;
        }
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        ??? = localArrayList2.iterator();
        do
        {
          bool2 = bool1;
          if (!???.hasNext()) {
            break;
          }
          localObject = (String)???.next();
        } while (!ArkLocalAppMgr.a(this.a, (String)localObject));
        bool2 = true;
      }
      if ((!bool2) || (localArrayList2.isEmpty()))
      {
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, no app need update.", new Object[0]));
        return;
      }
      ??? = new StringBuffer();
      Object localObject = localArrayList2.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ???.append((String)((Iterator)localObject).next());
        ???.append(';');
      }
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, start to update, last-time=%d, app-count=%d, app-name-list=%s.", new Object[] { Long.valueOf(ArkLocalAppMgr.a(this.a)), Integer.valueOf(localArrayList2.size()), ???.toString() }));
      ??? = new qrv(null);
      ???.a = localArrayList2;
      ArkLocalAppMgr.a(this.a, ???);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */