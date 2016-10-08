import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.SongInfo;

public final class tgd
  implements Parcelable.Creator
{
  public tgd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SongInfo a(Parcel paramParcel)
  {
    return new SongInfo(paramParcel, null);
  }
  
  public SongInfo[] a(int paramInt)
  {
    return new SongInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */