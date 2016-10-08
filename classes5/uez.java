import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;

public final class uez
  implements Parcelable.Creator
{
  public uez()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedDisplayInfo a(Parcel paramParcel)
  {
    RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
    localRedDisplayInfo.a = paramParcel.readArrayList(RedTypeInfo.class.getClassLoader());
    RedDisplayInfo.a(localRedDisplayInfo, (RedTypeInfo)paramParcel.readSerializable());
    return localRedDisplayInfo;
  }
  
  public RedDisplayInfo[] a(int paramInt)
  {
    return new RedDisplayInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */