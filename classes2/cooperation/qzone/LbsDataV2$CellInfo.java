package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yka;

public class LbsDataV2$CellInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new yka();
  public double a;
  public int a;
  public double b;
  public int b;
  public int c = -1;
  public int d = -1;
  public int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2$CellInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public LbsDataV2$CellInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
  }
  
  public boolean a()
  {
    return this.d != -1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "CellInfo [mcc=" + this.jdField_a_of_type_Int + ", mnc=" + this.jdField_b_of_type_Int + ", lac=" + this.c + ", cellId=" + this.d + ", rssi=" + this.e + ", stationLat=" + this.jdField_a_of_type_Double + ", stationLon=" + this.jdField_b_of_type_Double + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeDouble(this.jdField_b_of_type_Double);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\LbsDataV2$CellInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */