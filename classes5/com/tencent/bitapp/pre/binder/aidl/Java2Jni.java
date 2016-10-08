package com.tencent.bitapp.pre.binder.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface Java2Jni
  extends IInterface
{
  public abstract void reactBridgeCallfunction(int paramInt1, int paramInt2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void reactBridgeDestory()
    throws RemoteException;
  
  public abstract void reactBridgeExecuteJSScript(String paramString)
    throws RemoteException;
  
  public abstract void reactBridgeHandleMemoryPressure(String paramString)
    throws RemoteException;
  
  public abstract void reactBridgeInvokeCallback(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void reactBridgeLoadScriptFromFile(String[] paramArrayOfString, String paramString)
    throws RemoteException;
  
  public abstract void reactBridgeSetGlobalvariable(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void registerCallback(Jni2Java paramJni2Java)
    throws RemoteException;
  
  public abstract void setSoLoadPath(String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void unregisterCallback(Jni2Java paramJni2Java)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements Java2Jni
  {
    private static final String DESCRIPTOR = "com.tencent.bitapp.pre.binder.aidl.Java2Jni";
    static final int TRANSACTION_reactBridgeCallfunction = 8;
    static final int TRANSACTION_reactBridgeDestory = 5;
    static final int TRANSACTION_reactBridgeExecuteJSScript = 7;
    static final int TRANSACTION_reactBridgeHandleMemoryPressure = 6;
    static final int TRANSACTION_reactBridgeInvokeCallback = 9;
    static final int TRANSACTION_reactBridgeLoadScriptFromFile = 10;
    static final int TRANSACTION_reactBridgeSetGlobalvariable = 3;
    static final int TRANSACTION_registerCallback = 1;
    static final int TRANSACTION_setSoLoadPath = 4;
    static final int TRANSACTION_unregisterCallback = 2;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.bitapp.pre.binder.aidl.Java2Jni");
    }
    
    public static Java2Jni asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
      if ((localIInterface != null) && ((localIInterface instanceof Java2Jni))) {
        return (Java2Jni)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        registerCallback(Jni2Java.Stub.asInterface(paramParcel1.readStrongBinder()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        unregisterCallback(Jni2Java.Stub.asInterface(paramParcel1.readStrongBinder()));
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        reactBridgeSetGlobalvariable(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        setSoLoadPath(paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        reactBridgeDestory();
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        reactBridgeHandleMemoryPressure(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        reactBridgeExecuteJSScript(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          reactBridgeCallfunction(paramInt1, paramInt2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 9: 
        paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          reactBridgeInvokeCallback(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
      reactBridgeLoadScriptFromFile(paramParcel1.createStringArray(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements Java2Jni
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
        return "com.tencent.bitapp.pre.binder.aidl.Java2Jni";
      }
      
      /* Error */
      public void reactBridgeCallfunction(int paramInt1, int paramInt2, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 26
        //   14: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: iload_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload 4
        //   25: iload_2
        //   26: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnull +49 -> 79
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 50	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 19	com/tencent/bitapp/pre/binder/aidl/Java2Jni$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   50: bipush 8
        //   52: aload 4
        //   54: aload 5
        //   56: iconst_0
        //   57: invokeinterface 56 5 0
        //   62: pop
        //   63: aload 5
        //   65: invokevirtual 59	android/os/Parcel:readException	()V
        //   68: aload 5
        //   70: invokevirtual 62	android/os/Parcel:recycle	()V
        //   73: aload 4
        //   75: invokevirtual 62	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 4
        //   81: iconst_0
        //   82: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   85: goto -39 -> 46
        //   88: astore_3
        //   89: aload 5
        //   91: invokevirtual 62	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: invokevirtual 62	android/os/Parcel:recycle	()V
        //   99: aload_3
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	Proxy
        //   0	101	1	paramInt1	int
        //   0	101	2	paramInt2	int
        //   0	101	3	paramBundle	Bundle
        //   3	92	4	localParcel1	Parcel
        //   8	82	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	88	finally
        //   33	46	88	finally
        //   46	68	88	finally
        //   79	85	88	finally
      }
      
      public void reactBridgeDestory()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void reactBridgeExecuteJSScript(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          localParcel1.writeString(paramString);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void reactBridgeHandleMemoryPressure(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          localParcel1.writeString(paramString);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void reactBridgeInvokeCallback(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 26
        //   12: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +45 -> 66
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 50	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 19	com/tencent/bitapp/pre/binder/aidl/Java2Jni$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   39: bipush 9
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 56 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 59	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 62	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 62	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   71: goto -36 -> 35
        //   74: astore_2
        //   75: aload 4
        //   77: invokevirtual 62	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 62	android/os/Parcel:recycle	()V
        //   84: aload_2
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	Proxy
        //   0	86	1	paramInt	int
        //   0	86	2	paramBundle	Bundle
        //   3	78	3	localParcel1	Parcel
        //   7	69	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	74	finally
        //   24	35	74	finally
        //   35	56	74	finally
        //   66	71	74	finally
      }
      
      public void reactBridgeLoadScriptFromFile(String[] paramArrayOfString, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          localParcel1.writeStringArray(paramArrayOfString);
          localParcel1.writeString(paramString);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void reactBridgeSetGlobalvariable(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void registerCallback(Jni2Java paramJni2Java)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          if (paramJni2Java != null) {
            localIBinder = paramJni2Java.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void setSoLoadPath(String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          localParcel1.writeStringArray(paramArrayOfString);
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
      
      public void unregisterCallback(Jni2Java paramJni2Java)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.bitapp.pre.binder.aidl.Java2Jni");
          if (paramJni2Java != null) {
            localIBinder = paramJni2Java.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\aidl\Java2Jni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */