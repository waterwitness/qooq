package ct;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class cq
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public cu c;
  
  cq() {}
  
  public cq(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new cu(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              ct localct = new ct(paramJSONObject.getJSONObject(i));
              this.b.add(localct);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = cu.a;
              new StringBuilder("DetailsData: unknown json ").append(paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject) {}
      }
    }
  }
  
  private static cu a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    cu localcu;
    int j;
    Object localObject2;
    do
    {
      return (cu)localObject1;
      localcu = cu.a(cu.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localcu.b = ((JSONObject)localObject1).optString("n");
        localcu.e = ((JSONObject)localObject1).optString("p");
        localcu.f = ((JSONObject)localObject1).optString("c");
        localcu.g = ((JSONObject)localObject1).optString("d");
        localcu.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localcu.l.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localcu.l.putParcelable("addrdesp.landmark", new cp((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localcu.l.putParcelable("addrdesp.second_landmark", new cp((JSONObject)localObject1));
        }
      }
      localObject1 = localcu;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new cp(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((cp)localObject2).b)) {
        localcu.j = ((cp)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((cp)localObject2).b)) {
          localcu.k = ((cp)localObject2).a;
        }
      }
    }
    localcu.l.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localcu;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */