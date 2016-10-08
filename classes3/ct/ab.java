package ct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ab
{
  private static String d = "bott";
  public s a;
  public String b;
  public List c = new ArrayList();
  
  public ab(ad paramad)
  {
    if ((paramad.n == 0) || (!paramad.b))
    {
      this.c.add(a(paramad));
      return;
    }
    if (!bb.d)
    {
      Object localObject = h.a();
      if (localObject != null)
      {
        localObject = ((a)localObject).a(paramad.c);
        if (localObject != null)
        {
          this.a = ((t.a)localObject).d;
          List localList = ((t.a)localObject).c;
          this.b = ((t.a)localObject).b;
          localObject = localList;
          if (localList != null)
          {
            localObject = localList;
            if (localList.size() > paramad.n) {
              localObject = localList.subList(0, paramad.n);
            }
          }
          boolean bool = a((List)localObject, this.a);
          if ((this.b != null) && (!this.b.contains(d)))
          {
            this.c.addAll((Collection)localObject);
            if ((this.a != null) && (!bool)) {
              this.c.add(this.a);
            }
            this.c.add(a(paramad));
            return;
          }
          if ((this.a != null) && (!bool)) {
            this.c.add(this.a);
          }
          this.c.add(a(paramad));
          this.c.addAll((Collection)localObject);
          return;
        }
        this.c.add(a(paramad));
        return;
      }
      this.c.add(a(paramad));
      return;
    }
    this.c.add(a(paramad));
  }
  
  private static s a(ad paramad)
  {
    if (paramad.d != null) {
      return new s(paramad.c, paramad.d[0]);
    }
    return new s(paramad.c, -1);
  }
  
  private static boolean a(List paramList, s params)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((s)paramList.next()).a(params)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */