import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.ad.HotTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class srp
  implements Parcelable.Creator
{
  public srp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotTopic a(Parcel paramParcel)
  {
    return new HotTopic(paramParcel);
  }
  
  public HotTopic[] a(int paramInt)
  {
    return new HotTopic[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */