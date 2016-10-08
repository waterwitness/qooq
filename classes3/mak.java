import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class mak
  implements Parcelable.Creator
{
  public mak()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileActivity.AllInOne a(Parcel paramParcel)
  {
    boolean bool = true;
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(null);
    localAllInOne.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localAllInOne.jdField_a_of_type_Int = paramParcel.readInt();
    localAllInOne.jdField_b_of_type_Int = paramParcel.readInt();
    localAllInOne.jdField_a_of_type_Byte = paramParcel.readByte();
    localAllInOne.jdField_a_of_type_Short = ((short)paramParcel.readInt());
    localAllInOne.jdField_b_of_type_Byte = paramParcel.readByte();
    localAllInOne.jdField_c_of_type_Int = paramParcel.readInt();
    localAllInOne.jdField_c_of_type_Byte = paramParcel.readByte();
    localAllInOne.jdField_a_of_type_ArrayOfByte = paramParcel.createByteArray();
    localAllInOne.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localAllInOne.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localAllInOne.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localAllInOne.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localAllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readTypedList(localAllInOne.jdField_a_of_type_JavaUtilArrayList, ProfileActivity.CardContactInfo.CREATOR);
    localAllInOne.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      localAllInOne.jdField_a_of_type_Boolean = bool;
      localAllInOne.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localAllInOne.jdField_e_of_type_Int = paramParcel.readInt();
      localAllInOne.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localAllInOne.jdField_i_of_type_JavaLangString = paramParcel.readString();
      localAllInOne.jdField_j_of_type_JavaLangString = paramParcel.readString();
      localAllInOne.jdField_k_of_type_JavaLangString = paramParcel.readString();
      localAllInOne.l = paramParcel.readString();
      localAllInOne.m = paramParcel.readString();
      localAllInOne.n = paramParcel.readString();
      localAllInOne.jdField_f_of_type_Int = paramParcel.readInt();
      localAllInOne.g = paramParcel.readInt();
      localAllInOne.jdField_h_of_type_Int = paramParcel.readInt();
      localAllInOne.jdField_b_of_type_ArrayOfByte = paramParcel.createByteArray();
      localAllInOne.jdField_i_of_type_Int = paramParcel.readInt();
      localAllInOne.jdField_j_of_type_Int = paramParcel.readInt();
      localAllInOne.o = paramParcel.readString();
      localAllInOne.p = paramParcel.readString();
      localAllInOne.jdField_a_of_type_Long = paramParcel.readLong();
      localAllInOne.jdField_k_of_type_Int = paramParcel.readInt();
      return localAllInOne;
      bool = false;
    }
  }
  
  public ProfileActivity.AllInOne[] a(int paramInt)
  {
    return new ProfileActivity.AllInOne[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */