package cooperation.qqfav.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ygp;

public abstract class IQfavRemoteProxyInterface$Stub
  extends Binder
  implements IQfavRemoteProxyInterface
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "cooperation.qqfav.ipc.IQfavRemoteProxyInterface";
  
  public IQfavRemoteProxyInterface$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
  }
  
  public static IQfavRemoteProxyInterface a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
    if ((localIInterface != null) && ((localIInterface instanceof IQfavRemoteProxyInterface))) {
      return (IQfavRemoteProxyInterface)localIInterface;
    }
    return new ygp(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramInt1, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\ipc\IQfavRemoteProxyInterface$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */