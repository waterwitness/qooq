import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import java.util.ArrayList;

public final class uey
  implements Parcelable.Creator
{
  public uey()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedAppInfo a(Parcel paramParcel)
  {
    RedAppInfo localRedAppInfo = new RedAppInfo();
    RedAppInfo.a(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.b(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.c(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.a(localRedAppInfo, paramParcel.readString());
    RedAppInfo.b(localRedAppInfo, paramParcel.readString());
    RedAppInfo.d(localRedAppInfo, paramParcel.readInt());
    localRedAppInfo.a = new ArrayList();
    paramParcel.readList(localRedAppInfo.a, null);
    RedAppInfo.e(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.f(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.c(localRedAppInfo, paramParcel.readString());
    RedAppInfo.g(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.h(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.i(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.j(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.a(localRedAppInfo, (RedDisplayInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    return localRedAppInfo;
  }
  
  public RedAppInfo[] a(int paramInt)
  {
    return new RedAppInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */