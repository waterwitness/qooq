import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.PhotoParam;

public final class ymr
  implements Parcelable.Creator
{
  public ymr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PhotoParam a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoParam localPhotoParam = new PhotoParam();
    localPhotoParam.jdField_a_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_b_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_c_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_d_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_d_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_e_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_f_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoParam.jdField_a_of_type_Boolean = bool1;
      localPhotoParam.jdField_g_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_h_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_i_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoParam.jdField_i_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label338;
      }
      bool1 = true;
      label219:
      localPhotoParam.jdField_b_of_type_Boolean = bool1;
      localPhotoParam.jdField_j_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label343;
      }
      bool1 = true;
      label242:
      localPhotoParam.jdField_c_of_type_Boolean = bool1;
      localPhotoParam.jdField_j_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label348;
      }
      bool1 = true;
      label265:
      localPhotoParam.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label353;
      }
      bool1 = true;
      label280:
      localPhotoParam.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label358;
      }
      bool1 = true;
      label295:
      localPhotoParam.jdField_f_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label363;
      }
      bool1 = true;
      label310:
      localPhotoParam.jdField_g_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label368;
      }
    }
    label338:
    label343:
    label348:
    label353:
    label358:
    label363:
    label368:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.jdField_h_of_type_Boolean = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label219;
      bool1 = false;
      break label242;
      bool1 = false;
      break label265;
      bool1 = false;
      break label280;
      bool1 = false;
      break label295;
      bool1 = false;
      break label310;
    }
  }
  
  public PhotoParam[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */