package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gmy;

public abstract class IAVServiceCallback$Stub
  extends Binder
  implements IAVServiceCallback
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IAVServiceCallback";
  
  public IAVServiceCallback$Stub()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    attachInterface(this, "com.tencent.av.service.IAVServiceCallback");
  }
  
  public static IAVServiceCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IAVServiceCallback))) {
      return (IAVServiceCallback)localIInterface;
    }
    return new gmy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.service.IAVServiceCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceCallback");
    a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\IAVServiceCallback$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */