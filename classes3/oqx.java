import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class oqx
  implements Parcelable.Creator
{
  public oqx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    ImageInfo localImageInfo = new ImageInfo();
    if (paramParcel.readInt() == 0)
    {
      bool1 = false;
      localImageInfo.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 0) {
        break label376;
      }
      bool1 = false;
      label34:
      localImageInfo.jdField_b_of_type_Boolean = bool1;
      localImageInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 0) {
        break label381;
      }
      bool1 = false;
      label56:
      localImageInfo.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 0) {
        break label386;
      }
      bool1 = false;
      label70:
      localImageInfo.jdField_d_of_type_Boolean = bool1;
      localImageInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_a_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        break label391;
      }
      bool1 = false;
      label108:
      localImageInfo.jdField_e_of_type_Boolean = bool1;
      localImageInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_c_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_d_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_e_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        break label396;
      }
      bool1 = false;
      label162:
      localImageInfo.jdField_f_of_type_Boolean = bool1;
      localImageInfo.jdField_a_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 0) {
        break label401;
      }
      bool1 = false;
      label184:
      localImageInfo.jdField_h_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 0) {
        break label406;
      }
      bool1 = false;
      label198:
      localImageInfo.i = bool1;
      localImageInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_b_of_type_Long = paramParcel.readLong();
      localImageInfo.g = paramParcel.readString();
      localImageInfo.jdField_c_of_type_Long = paramParcel.readLong();
      localImageInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_h_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_h_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_j_of_type_Int = paramParcel.readInt();
      localImageInfo.jdField_j_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_m_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label411;
      }
      bool1 = true;
      label293:
      localImageInfo.jdField_o_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label416;
      }
      bool1 = true;
      label308:
      localImageInfo.n = bool1;
      if (paramParcel.readInt() != 1) {
        break label421;
      }
    }
    label376:
    label381:
    label386:
    label391:
    label396:
    label401:
    label406:
    label411:
    label416:
    label421:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageInfo.q = bool1;
      localImageInfo.jdField_e_of_type_Long = paramParcel.readLong();
      localImageInfo.k = paramParcel.readString();
      localImageInfo.l = paramParcel.readString();
      localImageInfo.jdField_m_of_type_JavaLangString = paramParcel.readString();
      localImageInfo.jdField_o_of_type_Int = paramParcel.readInt();
      return localImageInfo;
      bool1 = true;
      break;
      bool1 = true;
      break label34;
      bool1 = true;
      break label56;
      bool1 = true;
      break label70;
      bool1 = true;
      break label108;
      bool1 = true;
      break label162;
      bool1 = true;
      break label184;
      bool1 = true;
      break label198;
      bool1 = false;
      break label293;
      bool1 = false;
      break label308;
    }
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */