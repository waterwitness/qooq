package cooperation.huangye.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ydf;

public abstract class IHuangyeService$Stub
  extends Binder
  implements IHuangyeService
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "cooperation.huangye.ipc.IHuangyeService";
  static final int b = 2;
  
  public IHuangyeService$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "cooperation.huangye.ipc.IHuangyeService");
  }
  
  public static IHuangyeService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.huangye.ipc.IHuangyeService");
    if ((localIInterface != null) && ((localIInterface instanceof IHuangyeService))) {
      return (IHuangyeService)localIInterface;
    }
    return new ydf(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str1 = null;
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.huangye.ipc.IHuangyeService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.huangye.ipc.IHuangyeService");
      str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a(str1, (Bundle)localObject);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("cooperation.huangye.ipc.IHuangyeService");
    String str2 = paramParcel1.readString();
    localObject = str1;
    if (paramParcel1.readInt() != 0) {
      localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    a(str2, (Bundle)localObject);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\ipc\IHuangyeService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */