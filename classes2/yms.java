import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.VideoInfo;

public final class yms
  implements Parcelable.Creator
{
  public yms()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoInfo a(Parcel paramParcel)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localVideoInfo.b = paramParcel.readString();
    localVideoInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localVideoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    return localVideoInfo;
  }
  
  public VideoInfo[] a(int paramInt)
  {
    return new VideoInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */