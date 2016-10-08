import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ssl
  implements Parcelable.Creator
{
  public ssl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TopicInfo a(Parcel paramParcel)
  {
    return new TopicInfo(paramParcel);
  }
  
  public TopicInfo[] a(int paramInt)
  {
    return new TopicInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */