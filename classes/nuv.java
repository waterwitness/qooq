import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class nuv
  implements Parcelable.Creator
{
  public nuv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AIORichMediaData a(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    try
    {
      localObject = AIORichMediaData.a((String)localObject);
      ((AIORichMediaData)localObject).a(paramParcel);
      return (AIORichMediaData)localObject;
    }
    catch (ClassNotFoundException paramParcel)
    {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public AIORichMediaData[] a(int paramInt)
  {
    return new AIORichMediaData[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */