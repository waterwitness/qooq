import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qwr
  implements Parcelable.Creator
{
  public qwr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CardMobileInfo a(Parcel paramParcel)
  {
    return new CardMobileInfo(paramParcel);
  }
  
  public CardMobileInfo[] a(int paramInt)
  {
    return new CardMobileInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */