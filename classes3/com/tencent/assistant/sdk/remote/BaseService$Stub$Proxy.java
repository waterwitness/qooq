package com.tencent.assistant.sdk.remote;

import android.os.IBinder;
import android.os.Parcel;

class BaseService$Stub$Proxy
  implements BaseService
{
  private IBinder mRemote;
  
  BaseService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.assistant.sdk.remote.BaseService";
  }
  
  /* Error */
  public int registerActionCallback(String paramString1, String paramString2, SDKActionCallback paramSDKActionCallback)
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 22
    //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: aload_2
    //   26: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload_3
    //   30: ifnull +57 -> 87
    //   33: aload_3
    //   34: invokeinterface 41 1 0
    //   39: astore_1
    //   40: aload 4
    //   42: aload_1
    //   43: invokevirtual 44	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   46: aload_0
    //   47: getfield 15	com/tencent/assistant/sdk/remote/BaseService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 50 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 53	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 57	android/os/Parcel:readInt	()I
    //   72: istore 6
    //   74: aload 5
    //   76: invokevirtual 60	android/os/Parcel:recycle	()V
    //   79: aload 4
    //   81: invokevirtual 60	android/os/Parcel:recycle	()V
    //   84: iload 6
    //   86: ireturn
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -49 -> 40
    //   92: astore_1
    //   93: aload 5
    //   95: invokevirtual 60	android/os/Parcel:recycle	()V
    //   98: aload 4
    //   100: invokevirtual 60	android/os/Parcel:recycle	()V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	Proxy
    //   0	105	1	paramString1	String
    //   0	105	2	paramString2	String
    //   0	105	3	paramSDKActionCallback	SDKActionCallback
    //   3	96	4	localParcel1	Parcel
    //   8	86	5	localParcel2	Parcel
    //   72	13	6	i	int
    // Exception table:
    //   from	to	target	type
    //   10	29	92	finally
    //   33	40	92	finally
    //   40	74	92	finally
  }
  
  public void sendAsyncData(String paramString, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
      localParcel1.writeString(paramString);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public byte[] sendSyncData(String paramString, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
      localParcel1.writeString(paramString);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createByteArray();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public int unregisterActionCallback(SDKActionCallback paramSDKActionCallback)
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 22
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +50 -> 65
    //   18: aload_1
    //   19: invokeinterface 41 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 44	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/tencent/assistant/sdk/remote/BaseService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   34: iconst_2
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 50 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 53	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 57	android/os/Parcel:readInt	()I
    //   52: istore 4
    //   54: aload_3
    //   55: invokevirtual 60	android/os/Parcel:recycle	()V
    //   58: aload_2
    //   59: invokevirtual 60	android/os/Parcel:recycle	()V
    //   62: iload 4
    //   64: ireturn
    //   65: aconst_null
    //   66: astore_1
    //   67: goto -42 -> 25
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 60	android/os/Parcel:recycle	()V
    //   75: aload_2
    //   76: invokevirtual 60	android/os/Parcel:recycle	()V
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	Proxy
    //   0	81	1	paramSDKActionCallback	SDKActionCallback
    //   3	73	2	localParcel1	Parcel
    //   7	65	3	localParcel2	Parcel
    //   52	11	4	i	int
    // Exception table:
    //   from	to	target	type
    //   8	14	70	finally
    //   18	25	70	finally
    //   25	54	70	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\assistant\sdk\remote\BaseService$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */