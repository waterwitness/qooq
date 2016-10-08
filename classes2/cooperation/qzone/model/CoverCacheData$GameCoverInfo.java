package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ymi;

public class CoverCacheData$GameCoverInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ymi();
  public double a;
  public int a;
  public String a;
  public double b;
  public String b;
  public double c;
  public double d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CoverCacheData$GameCoverInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeDouble(this.jdField_b_of_type_Double);
    paramParcel.writeDouble(this.c);
    paramParcel.writeDouble(this.d);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\CoverCacheData$GameCoverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */