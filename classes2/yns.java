import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.OnQZonePluginInstallListner;

public class yns
  implements OnQZonePluginInstallListner
{
  private IBinder a;
  
  public yns(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "cooperation.qzone.plugin.OnQZonePluginInstallListner";
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(String paramString, float paramFloat, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      localParcel1.writeFloat(paramFloat);
      localParcel1.writeLong(paramLong);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */