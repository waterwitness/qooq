import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qwq
  implements Parcelable.Creator
{
  public qwq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BusinessCard a(Parcel paramParcel)
  {
    return new BusinessCard(paramParcel);
  }
  
  public BusinessCard[] a(int paramInt)
  {
    return new BusinessCard[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */