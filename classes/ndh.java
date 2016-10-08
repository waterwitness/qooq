import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ndh
  implements Parcelable.Creator
{
  public ndh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ForwardUtils.Section_Text a(Parcel paramParcel)
  {
    return new ForwardUtils.Section_Text(paramParcel);
  }
  
  public ForwardUtils.Section_Text[] a(int paramInt)
  {
    return new ForwardUtils.Section_Text[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */