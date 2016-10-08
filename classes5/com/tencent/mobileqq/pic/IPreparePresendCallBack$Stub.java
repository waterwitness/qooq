package com.tencent.mobileqq.pic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tsu;

public abstract class IPreparePresendCallBack$Stub
  extends Binder
  implements IPreparePresendCallBack
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.pic.IPreparePresendCallBack";
  
  public IPreparePresendCallBack$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.mobileqq.pic.IPreparePresendCallBack");
  }
  
  public static IPreparePresendCallBack a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pic.IPreparePresendCallBack");
    if ((localIInterface != null) && ((localIInterface instanceof IPreparePresendCallBack))) {
      return (IPreparePresendCallBack)localIInterface;
    }
    return new tsu(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.pic.IPreparePresendCallBack");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPreparePresendCallBack");
    a(paramParcel1.readStrongBinder());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\IPreparePresendCallBack$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */