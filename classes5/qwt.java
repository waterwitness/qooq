import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qwt
  implements Parcelable.Creator
{
  public qwt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CardUinInfo a(Parcel paramParcel)
  {
    return new CardUinInfo(paramParcel);
  }
  
  public CardUinInfo[] a(int paramInt)
  {
    return new CardUinInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */