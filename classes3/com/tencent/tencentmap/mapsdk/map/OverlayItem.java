package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OverlayItem
  implements Parcelable
{
  public static final Parcelable.Creator<OverlayItem> CREATOR = new Parcelable.Creator()
  {
    public final OverlayItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OverlayItem(paramAnonymousParcel);
    }
    
    public final OverlayItem[] newArray(int paramAnonymousInt)
    {
      return new OverlayItem[paramAnonymousInt];
    }
  };
  private GeoPoint a;
  private String b;
  private String c;
  private Drawable d;
  private boolean e = true;
  
  protected OverlayItem(Parcel paramParcel)
  {
    this.a = ((GeoPoint)paramParcel.readValue(GeoPoint.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public OverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2)
  {
    this.a = paramGeoPoint.Copy();
    this.b = paramString1;
    this.c = paramString2;
    this.d = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getMarker()
  {
    return this.d;
  }
  
  public GeoPoint getPoint()
  {
    return this.a;
  }
  
  public String getSnippet()
  {
    return this.c;
  }
  
  public String getTitle()
  {
    return this.b;
  }
  
  public boolean isDragable()
  {
    return this.e;
  }
  
  public void setDragable(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setMarker(Drawable paramDrawable)
  {
    this.d = paramDrawable;
    if (this.d == null) {}
    do
    {
      return;
      paramDrawable = this.d.getBounds();
      if (paramDrawable == null)
      {
        ItemizedOverlay.boundCenterBottom(this.d);
        return;
      }
    } while ((paramDrawable.left != 0) || (paramDrawable.right != 0) || (paramDrawable.top != 0) || (paramDrawable.bottom != 0));
    ItemizedOverlay.boundCenterBottom(this.d);
  }
  
  public void setPoint(GeoPoint paramGeoPoint)
  {
    this.a = paramGeoPoint.Copy();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tencentmap\mapsdk\map\OverlayItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */