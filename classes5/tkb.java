import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

public final class tkb
  implements Parcelable.Creator
{
  public tkb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BasicTypeDataParcel a(Parcel paramParcel)
  {
    return new BasicTypeDataParcel(paramParcel);
  }
  
  public BasicTypeDataParcel[] a(int paramInt)
  {
    return new BasicTypeDataParcel[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */