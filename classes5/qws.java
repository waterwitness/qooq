import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qws
  implements Parcelable.Creator
{
  public qws()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CardOCRInfo a(Parcel paramParcel)
  {
    return new CardOCRInfo(paramParcel);
  }
  
  public CardOCRInfo[] a(int paramInt)
  {
    return new CardOCRInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */