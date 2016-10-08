import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.FriendListHandler.QQHeadDetails;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class pxz
  implements Parcelable.Creator
{
  public pxz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FriendListHandler.QQHeadDetails a(Parcel paramParcel)
  {
    FriendListHandler.QQHeadDetails localQQHeadDetails = new FriendListHandler.QQHeadDetails(null);
    localQQHeadDetails.jdField_a_of_type_Int = paramParcel.readInt();
    localQQHeadDetails.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQQHeadDetails.jdField_a_of_type_Long = paramParcel.readLong();
    localQQHeadDetails.jdField_a_of_type_Byte = paramParcel.readByte();
    return localQQHeadDetails;
  }
  
  public FriendListHandler.QQHeadDetails[] a(int paramInt)
  {
    return new FriendListHandler.QQHeadDetails[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */