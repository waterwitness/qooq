package ct;

import com.tencent.map.geolocation.TencentPoi;
import org.json.JSONException;
import org.json.JSONObject;

final class ct
  implements TencentPoi
{
  private String a;
  private String b;
  private String c;
  private double d;
  private String e;
  private double f;
  private double g;
  private String h;
  
  public ct(TencentPoi paramTencentPoi)
  {
    this.a = paramTencentPoi.getName();
    this.b = paramTencentPoi.getAddress();
    this.c = paramTencentPoi.getCatalog();
    this.d = paramTencentPoi.getDistance();
    this.e = paramTencentPoi.getUid();
    this.f = paramTencentPoi.getLatitude();
    this.g = paramTencentPoi.getLongitude();
    this.h = paramTencentPoi.getDirection();
  }
  
  public ct(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      this.a = paramJSONObject.getString("name");
      this.b = paramJSONObject.getString("addr");
      this.c = paramJSONObject.getString("catalog");
      this.d = paramJSONObject.optDouble("dist");
      this.e = paramJSONObject.getString("uid");
      this.f = paramJSONObject.optDouble("latitude");
      this.g = paramJSONObject.optDouble("longitude");
      this.h = paramJSONObject.optString("direction", "");
      if (Double.isNaN(this.f)) {
        this.f = paramJSONObject.optDouble("pointy");
      }
      if (Double.isNaN(this.g)) {
        this.g = paramJSONObject.optDouble("pointx");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
  
  public final String getAddress()
  {
    return this.b;
  }
  
  public final String getCatalog()
  {
    return this.c;
  }
  
  public final String getDirection()
  {
    return this.h;
  }
  
  public final double getDistance()
  {
    return this.d;
  }
  
  public final double getLatitude()
  {
    return this.f;
  }
  
  public final double getLongitude()
  {
    return this.g;
  }
  
  public final String getName()
  {
    return this.a;
  }
  
  public final String getUid()
  {
    return this.e;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PoiData{");
    localStringBuilder.append("name=").append(this.a).append(",");
    localStringBuilder.append("addr=").append(this.b).append(",");
    localStringBuilder.append("catalog=").append(this.c).append(",");
    localStringBuilder.append("dist=").append(this.d).append(",");
    localStringBuilder.append("latitude=").append(this.f).append(",");
    localStringBuilder.append("longitude=").append(this.g).append(",");
    localStringBuilder.append("direction=").append(this.h).append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */