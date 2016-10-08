package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public an f;
  
  public d() {}
  
  public d(ai paramai)
  {
    this.a = paramai.a;
    this.b = paramai.b;
    this.c = paramai.c;
    this.d = paramai.d;
    this.e = paramai.e;
    this.f = paramai.f;
  }
  
  private void c()
  {
    if ((this.a < 10000) || (this.a > 30000)) {
      this.a = 20000;
    }
    if ((this.b < 10000) || (this.b > 30000)) {
      this.b = 20000;
    }
    if ((this.c < 3) || (this.c > 15)) {
      this.c = 8;
    }
    if ((this.d <= 0) || (this.d > 5)) {
      this.d = 2;
    }
    if ((this.e < 5) || (this.e > 240)) {
      this.e = 60;
    }
  }
  
  public final void a()
  {
    an localan = null;
    Object localObject = p.a().getSharedPreferences("Access_Preferences", 0);
    this.a = ((SharedPreferences)localObject).getInt("connectTimeout", 20000);
    this.b = ((SharedPreferences)localObject).getInt("readTimeout", 20000);
    this.c = ((SharedPreferences)localObject).getInt("apnCachedNum", 8);
    this.d = ((SharedPreferences)localObject).getInt("parallelNum", 2);
    this.e = ((SharedPreferences)localObject).getInt("expireTime", 30);
    localObject = ((SharedPreferences)localObject).getString("samplingInfo", null);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      localan = new an();
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < localObject.length - 1)
      {
        String[] arrayOfString = localObject[i].split(",");
        localHashMap.put(Integer.valueOf(Integer.parseInt(arrayOfString[0])), Byte.valueOf(Byte.parseByte(arrayOfString[1])));
        i += 1;
      }
      localan.a = localHashMap;
      localan.b = Byte.parseByte(localObject[(localObject.length - 1)]);
    }
    this.f = localan;
    c();
  }
  
  public final void b()
  {
    Object localObject = p.a().getSharedPreferences("Access_Preferences", 0);
    c();
    ((SharedPreferences)localObject).edit().putInt("connectTimeout", this.a).commit();
    ((SharedPreferences)localObject).edit().putInt("readTimeout", this.b).commit();
    ((SharedPreferences)localObject).edit().putInt("apnCachedNum", this.c).commit();
    ((SharedPreferences)localObject).edit().putInt("parallelNum", this.d).commit();
    ((SharedPreferences)localObject).edit().putInt("expireTime", this.e).commit();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    if (((an)localObject).a != null)
    {
      Iterator localIterator = ((an)localObject).a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey() + "," + localEntry.getValue() + ";");
      }
      localStringBuilder.append(((an)localObject).b);
    }
    for (localObject = localStringBuilder.toString();; localObject = null)
    {
      localEditor.putString("samplingInfo", (String)localObject).commit();
      return;
    }
  }
  
  public final String toString()
  {
    return "connectTimeout:" + this.a + ",readTimeout:" + this.b + ",apnCachedNum:" + this.c + ",parallelNum:" + this.d + ",expireTime:" + this.e;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */