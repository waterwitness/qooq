import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.IPreparePresendCallBack;

public class tsu
  implements IPreparePresendCallBack
{
  private IBinder a;
  
  public tsu(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.pic.IPreparePresendCallBack";
  }
  
  public void a(IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPreparePresendCallBack");
      localParcel1.writeStrongBinder(paramIBinder);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */