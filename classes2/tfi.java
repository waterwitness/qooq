import com.tencent.mobileqq.data.TroopVideoUrlEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tfi
  implements Runnable
{
  public tfi(TroopInfoManager paramTroopInfoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b = new ArrayList();
    Object localObject = (ArrayList)this.a.a.a(TroopVideoUrlEntity.class, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopVideoUrlEntity localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
        this.a.b.add(localTroopVideoUrlEntity);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */