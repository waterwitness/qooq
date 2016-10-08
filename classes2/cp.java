import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.mpfile.MpfileTaskInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cp
  implements Parcelable.Creator
{
  public cp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MpfileTaskInfo a(Parcel paramParcel)
  {
    MpfileTaskInfo localMpfileTaskInfo = new MpfileTaskInfo();
    localMpfileTaskInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localMpfileTaskInfo.jdField_g_of_type_Int = paramParcel.readInt();
    localMpfileTaskInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.h = paramParcel.readString();
    localMpfileTaskInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_d_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_e_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_f_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_g_of_type_Long = paramParcel.readLong();
    return localMpfileTaskInfo;
  }
  
  public MpfileTaskInfo[] a(int paramInt)
  {
    return new MpfileTaskInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */