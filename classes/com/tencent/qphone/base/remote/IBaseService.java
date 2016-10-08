package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IBaseService
  extends IInterface
{
  public abstract FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException;
  
  public abstract int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IBaseService
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseService";
    static final int TRANSACTION_sendSyncToServiceMsg = 1;
    static final int TRANSACTION_sendToServiceMsg = 2;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qphone.base.remote.IBaseService");
    }
    
    public static IBaseService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IBaseService");
      if ((localIInterface != null) && ((localIInterface instanceof IBaseService))) {
        return (IBaseService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.qphone.base.remote.IBaseService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = sendSyncToServiceMsg((ToServiceMsg)localObject1);
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
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
      }
      paramInt1 = sendToServiceMsg((ToServiceMsg)localObject1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class Proxy
      implements IBaseService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.qphone.base.remote.IBaseService";
      }
      
      public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
            if (paramToServiceMsg != null)
            {
              localParcel1.writeInt(1);
              paramToServiceMsg.writeToParcel(localParcel1, 0);
              this.mRemote.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramToServiceMsg = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(localParcel2);
                return paramToServiceMsg;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramToServiceMsg = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +49 -> 64
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 50	com/tencent/qphone/base/remote/ToServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/tencent/qphone/base/remote/IBaseService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 56 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 59	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 63	android/os/Parcel:readInt	()I
        //   51: istore 4
        //   53: aload_3
        //   54: invokevirtual 78	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 78	android/os/Parcel:recycle	()V
        //   61: iload 4
        //   63: ireturn
        //   64: aload_2
        //   65: iconst_0
        //   66: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   69: goto -40 -> 29
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 78	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 78	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramToServiceMsg	ToServiceMsg
        //   3	75	2	localParcel1	Parcel
        //   7	67	3	localParcel2	Parcel
        //   51	11	4	i	int
        // Exception table:
        //   from	to	target	type
        //   8	14	72	finally
        //   18	29	72	finally
        //   29	53	72	finally
        //   64	69	72	finally
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\remote\IBaseService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */