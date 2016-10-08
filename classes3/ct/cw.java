package ct;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class cw
  implements Parcelable, TencentLocation
{
  public static final cw a = new cw(-1);
  public cs b;
  private int c;
  private String d;
  private cq e;
  private final Bundle f = new Bundle();
  private String g = "network";
  private Location h;
  private final long i;
  private long j;
  
  static
  {
    new Parcelable.Creator() {};
  }
  
  private cw(int paramInt)
  {
    this.c = paramInt;
    this.i = SystemClock.elapsedRealtime();
    this.j = System.currentTimeMillis();
  }
  
  private cw(String paramString)
    throws JSONException
  {
    this.i = SystemClock.elapsedRealtime();
    this.j = System.currentTimeMillis();
    paramString = new JSONObject(paramString);
    for (;;)
    {
      try
      {
        this.b = new cs(paramString.getJSONObject("location"));
        this.d = paramString.optString("bearing");
      }
      catch (JSONException paramString)
      {
        try
        {
          int k;
          JSONObject localJSONObject;
          this.e = new cq(localJSONObject);
          if ((this.e != null) && (this.e.c != null)) {
            this.f.putAll(this.e.c.l);
          }
          return;
        }
        catch (JSONException paramString)
        {
          throw paramString;
        }
        paramString = paramString;
        throw paramString;
      }
      try
      {
        k = paramString.optInt("icontrol", -1);
        if (k >= 0) {
          this.f.putInt("icontrol", k);
        }
      }
      catch (Exception localException) {}
    }
    localJSONObject = paramString.optJSONObject("details");
    if (localJSONObject != null) {}
    for (;;)
    {
      paramString = paramString.optJSONObject("addrdesp");
      if ((paramString != null) && (paramString.has("detail"))) {
        this.e = new cq(paramString.optJSONObject("detail"));
      }
    }
  }
  
  public static cw a(cw paramcw, ck paramck)
  {
    int n;
    int k;
    if ((paramcw != null) && (paramck != null) && (paramcw.d != null))
    {
      String str = paramcw.d;
      int m = 0;
      n = paramck.f;
      k = m;
      if (str != null)
      {
        k = m;
        if (str.split(",").length > 1) {
          k = Integer.parseInt(str.split(",")[1]);
        }
      }
      paramck = paramcw.b;
      if (paramck == null) {}
    }
    try
    {
      paramck.d = ((float)e.r(paramck.d, k, n));
      return paramcw;
    }
    catch (UnsatisfiedLinkError paramck) {}
    return paramcw;
  }
  
  public static void a(cw paramcw)
    throws JSONException
  {
    if (paramcw == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final void a(Location paramLocation)
  {
    if (this.b != null)
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      this.b.a = d2;
      this.b.b = d1;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (this.c == 5) {
      return this.f.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (this.e != null) {
      return Integer.valueOf(this.e.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (this.h == null) {
      return 0.0F;
    }
    return this.h.getBearing();
  }
  
  public final String getCity()
  {
    if (this.e != null) {
      return this.e.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (this.e != null) {
      return this.e.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return 0;
  }
  
  public final double getDirection()
  {
    return this.f.getDouble("direction");
  }
  
  public final String getDistrict()
  {
    if (this.e != null) {
      return this.e.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return this.i;
  }
  
  public final Bundle getExtra()
  {
    return this.f;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {
      return this.b.b;
    }
    return 0.0D;
  }
  
  public final String getName()
  {
    if (this.c == 5) {
      return this.f.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (this.e != null) {
      return this.e.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.e != null) {
      return new ArrayList(this.e.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.g;
  }
  
  public final String getProvince()
  {
    if (this.e != null) {
      return this.e.c.e;
    }
    return "";
  }
  
  public final int getRssi()
  {
    if (this.h == null) {}
    Bundle localBundle;
    do
    {
      return 0;
      localBundle = this.h.getExtras();
    } while (localBundle == null);
    return localBundle.getInt("rssi", 0);
  }
  
  public final float getSpeed()
  {
    if (this.h == null) {
      return 0.0F;
    }
    return this.h.getSpeed();
  }
  
  public final String getStreet()
  {
    if (this.e != null) {
      return this.e.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (this.e != null) {
      return this.e.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.j;
  }
  
  public final String getTown()
  {
    if (this.e != null) {
      return this.e.c.h;
    }
    return "";
  }
  
  public final String getVillage()
  {
    if (this.e != null) {
      return this.e.c.i;
    }
    return "";
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.c).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (this.e != null) {}
    for (String str = this.e.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(this.j);
      paramParcel.writeBundle(this.f);
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public cw b;
    public int c;
    public String d = "network";
    private Location e;
    
    public final a a(Location paramLocation)
    {
      this.e = new Location(paramLocation);
      return this;
    }
    
    public final cw a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          cw localcw1 = new cw(this.a, (byte)0);
          cw.a(cw.b(cw.a(localcw1, this.c), this.d), this.e);
          TencentExtraKeys.setRawGps(localcw1, this.e);
          return localcw1;
        }
        catch (JSONException localJSONException)
        {
          return cw.a;
        }
        cw localcw2 = cw.c(this.b);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */