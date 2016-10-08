package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  public static final int[] a = { 80, 8080, 14000 };
  public long b;
  private Map c;
  
  public c() {}
  
  public c(am paramam)
  {
    try
    {
      this.b = paramam.b;
      this.c = new HashMap();
      Iterator localIterator = paramam.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (bb.a(localInteger))
        {
          Object localObject = (ArrayList)paramam.a.get(localInteger);
          ArrayList localArrayList = new ArrayList();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            s locals = new s();
            if (locals.a(str)) {
              localArrayList.add(locals);
            }
          }
          this.c.put(localInteger, localArrayList);
        }
      }
      return;
    }
    catch (Exception paramam) {}
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "access_cm";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "access_uni";
      }
    } while (paramInt != 3);
    return "access_ct";
  }
  
  public final void a()
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
        this.b = localSharedPreferences.getLong("timeStamp", 0L);
        this.c = new HashMap();
        i = 1;
        if (i <= 3)
        {
          Object localObject2 = localSharedPreferences.getString(a(i), "");
          Object localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = "";
            if (i != 1) {
              break label186;
            }
            localObject1 = "183.61.38.168:14000,117.135.171.182:14000";
            bc.b();
          }
          localObject1 = ((String)localObject1).split(",");
          if (localObject1.length > 0)
          {
            localObject2 = new ArrayList();
            int k = localObject1.length;
            j = 0;
            if (j < k)
            {
              String str2 = localObject1[j];
              s locals = new s();
              if (locals.a(str2)) {
                ((ArrayList)localObject2).add(locals);
              }
            }
            else
            {
              this.c.put(Integer.valueOf(i), localObject2);
            }
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException) {}
      j += 1;
      continue;
      label186:
      String str1;
      if (i == 2) {
        str1 = "112.90.140.213:14000,112.90.140.216:14000";
      } else if (i == 3) {
        str1 = "14.17.41.159:14000,140.206.160.242:14000";
      }
    }
  }
  
  public final void b()
  {
    try
    {
      SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
      if ((this.c != null) && (this.c.size() > 0))
      {
        Iterator localIterator = this.c.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (Integer)localIterator.next();
          if (bb.a((Integer)localObject1))
          {
            String str = a(((Integer)localObject1).intValue());
            Object localObject2 = (ArrayList)this.c.get(localObject1);
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
            {
              localObject2 = new StringBuilder();
              localObject1 = ((ArrayList)this.c.get(localObject1)).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                ((StringBuilder)localObject2).append(((s)((Iterator)localObject1).next()).a());
                ((StringBuilder)localObject2).append(",");
              }
              ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
              localSharedPreferences.edit().putString(str, ((StringBuilder)localObject2).toString()).commit();
            }
          }
        }
        localSharedPreferences.edit().putLong("timesStamp", this.b).commit();
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public final ArrayList c()
  {
    int k = 0;
    for (;;)
    {
      ArrayList localArrayList1;
      Object localObject2;
      ArrayList localArrayList2;
      try
      {
        localArrayList1 = new ArrayList();
        try
        {
          i = bb.d();
          if (!bb.a(Integer.valueOf(i))) {
            break label118;
          }
          Iterator localIterator1 = this.c.keySet().iterator();
          if (localIterator1.hasNext())
          {
            localObject2 = (Integer)localIterator1.next();
            localArrayList2 = (ArrayList)this.c.get(localObject2);
            if (i != ((Integer)localObject2).intValue()) {
              continue;
            }
            localArrayList1.addAll(0, localArrayList2);
            continue;
          }
        }
        catch (Exception localException) {}
        return localArrayList1;
      }
      finally {}
      localArrayList1.addAll(localArrayList2);
      continue;
      label118:
      Iterator localIterator2 = this.c.keySet().iterator();
      int j;
      for (int i = 0;; i = Math.max(i, ((ArrayList)this.c.get(localObject2)).size()))
      {
        j = k;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (Integer)localIterator2.next();
      }
      while (j < i)
      {
        localIterator2 = this.c.keySet().iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (Integer)localIterator2.next();
          localObject2 = (ArrayList)this.c.get(localObject2);
          if (j < ((ArrayList)localObject2).size()) {
            ((ArrayList)localObject1).add(((ArrayList)localObject2).get(j));
          }
        }
        j += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */