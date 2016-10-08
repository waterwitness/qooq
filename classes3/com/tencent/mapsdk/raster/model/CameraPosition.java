package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mapsdk.a.d;

public final class CameraPosition
  implements Parcelable
{
  public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator()
  {
    public final CameraPosition createFromParcel(Parcel paramAnonymousParcel)
    {
      float f1 = paramAnonymousParcel.readFloat();
      float f2 = paramAnonymousParcel.readFloat();
      float f3 = paramAnonymousParcel.readFloat();
      return new CameraPosition(new LatLng(f1, f2), f3);
    }
    
    public final CameraPosition[] newArray(int paramAnonymousInt)
    {
      return new CameraPosition[paramAnonymousInt];
    }
  };
  private final LatLng a;
  private float b = -1.0F;
  
  public CameraPosition(LatLng paramLatLng, float paramFloat)
  {
    this.a = paramLatLng;
    this.b = paramFloat;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CameraPosition)) {
        return false;
      }
      paramObject = (CameraPosition)paramObject;
    } while ((getTarget().equals(((CameraPosition)paramObject).getTarget())) && (Float.floatToIntBits(getZoom()) == Float.floatToIntBits(((CameraPosition)paramObject).getZoom())));
    return false;
  }
  
  public final LatLng getTarget()
  {
    return this.a;
  }
  
  public final float getZoom()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final String toString()
  {
    return d.a(new String[] { d.a("target", getTarget()), d.a("zoom", Float.valueOf(getZoom())) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat((float)getTarget().getLatitude());
    paramParcel.writeFloat((float)getTarget().getLongitude());
    paramParcel.writeFloat(getZoom());
  }
  
  public static final class Builder
  {
    private LatLng a;
    private float b = -1.0F;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      target(paramCameraPosition.getTarget()).zoom(paramCameraPosition.getZoom());
    }
    
    public final CameraPosition build()
    {
      return new CameraPosition(this.a, this.b);
    }
    
    public final Builder target(LatLng paramLatLng)
    {
      this.a = paramLatLng;
      return this;
    }
    
    public final Builder zoom(float paramFloat)
    {
      this.b = paramFloat;
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\raster\model\CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */