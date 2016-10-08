import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gmy
  implements IAVServiceCallback
{
  private IBinder a;
  
  public gmy(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.av.service.IAVServiceCallback";
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceCallback");
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeInt(paramInt3);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */