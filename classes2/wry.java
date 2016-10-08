import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.datamodel.Friend;

public final class wry
  implements Parcelable.Creator
{
  public wry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Friend a(Parcel paramParcel)
  {
    Friend localFriend = new Friend();
    localFriend.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFriend.b = paramParcel.readString();
    localFriend.c = paramParcel.readString();
    localFriend.d = paramParcel.readString();
    localFriend.jdField_a_of_type_Int = paramParcel.readInt();
    localFriend.e = paramParcel.readString();
    return localFriend;
  }
  
  public Friend[] a(int paramInt)
  {
    return new Friend[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */