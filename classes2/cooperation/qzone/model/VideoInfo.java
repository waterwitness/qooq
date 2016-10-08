package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yms;

public class VideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new yms();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "[videoUrl=" + this.jdField_a_of_type_JavaLangString + ", originVideoUrl=" + this.b + ",originVideoSize=" + this.jdField_a_of_type_Long + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\VideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */