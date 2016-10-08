package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ykd;

public class LbsDataV2$GpsInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ykd();
  public int a = LbsDataV2.a;
  public int b = LbsDataV2.a;
  public int c = -10000000;
  public int d = 0;
  public int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2$GpsInfo()
  {
    a();
  }
  
  public LbsDataV2$GpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }
  
  public GpsInfo a()
  {
    return new GpsInfo(this.a, this.b, this.c, this.d, this.e);
  }
  
  public void a()
  {
    this.a = LbsDataV2.a;
    this.b = LbsDataV2.a;
    this.c = -10000000;
    this.d = 0;
    this.e = -1;
  }
  
  public boolean a()
  {
    return (this.a != LbsDataV2.a) && (this.b != LbsDataV2.a);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "lat: " + this.a + ", lon: " + this.b + ", alt: " + this.c + ", gpsType: " + this.d + ", accuracy: " + this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\LbsDataV2$GpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */