package com.tencent.component.network.module.cache;

import com.tencent.component.network.module.cache.a.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class b
  implements e.a
{
  public final Collection<com.tencent.component.network.module.cache.a.b> a()
  {
    synchronized ()
    {
      if (a.b().size() <= 0)
      {
        localObject1 = null;
        return (Collection<com.tencent.component.network.module.cache.a.b>)localObject1;
      }
      Object localObject1 = new ArrayList(a.b().values());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\cache\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */