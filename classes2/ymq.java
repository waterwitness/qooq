import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.ImageTagInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import java.util.ArrayList;

public final class ymq
  implements Parcelable.Creator
{
  public ymq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PhotoInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localPhotoInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.d = paramParcel.readString();
    localPhotoInfo.e = paramParcel.readString();
    localPhotoInfo.f = paramParcel.readString();
    localPhotoInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoInfo.jdField_g_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoInfo.jdField_a_of_type_Boolean = bool1;
      localPhotoInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_i_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_j_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoInfo.jdField_h_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_i_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_j_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = ((GpsInfo4LocalImage)paramParcel.readParcelable(getClass().getClassLoader()));
      if (paramParcel.readInt() != 1) {
        break label336;
      }
    }
    label336:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoInfo.jdField_b_of_type_Boolean = bool1;
      localPhotoInfo.jdField_a_of_type_Long = paramParcel.readLong();
      localPhotoInfo.jdField_b_of_type_Long = paramParcel.readLong();
      localPhotoInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readTypedList(localPhotoInfo.jdField_a_of_type_JavaUtilArrayList, ImageTagInfo.CREATOR);
      localPhotoInfo.jdField_k_of_type_Int = paramParcel.readInt();
      localPhotoInfo.q = paramParcel.readInt();
      localPhotoInfo.r = paramParcel.readInt();
      localPhotoInfo.s = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo = ((VideoInfo)paramParcel.readParcelable(VideoInfo.class.getClassLoader()));
      localPhotoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.t = paramParcel.readInt();
      localPhotoInfo.u = paramParcel.readInt();
      localPhotoInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_c_of_type_Long = paramParcel.readLong();
      localPhotoInfo.v = paramParcel.readInt();
      return localPhotoInfo;
      bool1 = false;
      break;
    }
  }
  
  public PhotoInfo[] a(int paramInt)
  {
    return new PhotoInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */