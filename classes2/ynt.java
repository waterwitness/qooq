import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.PluginRecord;

public final class ynt
  implements Parcelable.Creator
{
  public ynt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PluginRecord a(Parcel paramParcel)
  {
    return new PluginRecord(paramParcel);
  }
  
  public PluginRecord[] a(int paramInt)
  {
    return new PluginRecord[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */