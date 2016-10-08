import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hbb
  implements Parcelable.Creator
{
  public hbb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InviteBaseData a(Parcel paramParcel)
  {
    return new InviteBaseData(paramParcel);
  }
  
  public InviteBaseData[] a(int paramInt)
  {
    return new InviteBaseData[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */