package com.tencent.tencentmap.mapsdk.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeoPoint
  implements Parcelable
{
  public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator()
  {
    public final GeoPoint createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GeoPoint(paramAnonymousParcel, (byte)0);
    }
    
    public final GeoPoint[] newArray(int paramAnonymousInt)
    {
      return new GeoPoint[paramAnonymousInt];
    }
  };
  private int a = 0;
  private int b = 0;
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private GeoPoint(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public GeoPoint Copy()
  {
    return new GeoPoint(this.a, this.b);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (paramObject.getClass() != getClass());
      paramObject = (GeoPoint)paramObject;
    } while ((this.a != ((GeoPoint)paramObject).a) || (this.b != ((GeoPoint)paramObject).b));
    return true;
  }
  
  public int getLatitudeE6()
  {
    return this.a;
  }
  
  public int getLongitudeE6()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    return this.b * 7 + this.a * 11;
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final String toString()
  {
    return this.a + "," + this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */