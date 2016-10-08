package ct;

import org.json.JSONException;
import org.json.JSONObject;

public final class cs
{
  public double a;
  public double b;
  public double c;
  public float d;
  public String e;
  public String f;
  
  cs() {}
  
  public cs(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      this.a = paramJSONObject.getDouble("latitude");
      this.b = paramJSONObject.getDouble("longitude");
      this.c = paramJSONObject.getDouble("altitude");
      this.d = ((float)paramJSONObject.getDouble("accuracy"));
      this.e = paramJSONObject.optString("name");
      this.f = paramJSONObject.optString("addr");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */