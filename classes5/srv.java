import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.hotchat.HotchatFeedInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class srv
  implements Parcelable.Creator
{
  public srv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotchatFeedInfo a(Parcel paramParcel)
  {
    return new HotchatFeedInfo(paramParcel);
  }
  
  public HotchatFeedInfo[] a(int paramInt)
  {
    return new HotchatFeedInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */