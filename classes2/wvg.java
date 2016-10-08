import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadInfo;

public final class wvg
  implements Parcelable.Creator
{
  public wvg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DownloadInfo a(Parcel paramParcel)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.d = paramParcel.readString();
    localDownloadInfo.e = paramParcel.readString();
    localDownloadInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.a = paramParcel.readInt();
    localDownloadInfo.g = paramParcel.readString();
    localDownloadInfo.h = paramParcel.readString();
    localDownloadInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_k_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_l_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_b_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDownloadInfo.jdField_c_of_type_Boolean = bool;
      localDownloadInfo.jdField_l_of_type_JavaLangString = paramParcel.readString();
      localDownloadInfo.o = paramParcel.readInt();
      localDownloadInfo.p = paramParcel.readInt();
      localDownloadInfo.m = paramParcel.readString();
      return localDownloadInfo;
    }
  }
  
  public DownloadInfo[] a(int paramInt)
  {
    return new DownloadInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */