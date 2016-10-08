import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qpq
  implements IArConfigManager
{
  private IBinder a;
  
  public qpq(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  /* Error */
  public com.tencent.mobileqq.ar.aidl.ArConfigInfo a()
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 21	qpq:a	Landroid/os/IBinder;
    //   18: iconst_3
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 41 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 44	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 48	android/os/Parcel:readInt	()I
    //   36: ifeq +26 -> 62
    //   39: getstatic 54	com/tencent/mobileqq/ar/aidl/ArConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   42: aload_3
    //   43: invokeinterface 60 2 0
    //   48: checkcast 50	com/tencent/mobileqq/ar/aidl/ArConfigInfo
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: aload_2
    //   57: invokevirtual 63	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -12 -> 52
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 63	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	qpq
    //   51	13	1	localArConfigInfo	com.tencent.mobileqq.ar.aidl.ArConfigInfo
    //   67	10	1	localObject	Object
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	52	67	finally
  }
  
  /* Error */
  public com.tencent.mobileqq.ar.aidl.ArEffectConfig a()
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 21	qpq:a	Landroid/os/IBinder;
    //   18: iconst_4
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 41 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 44	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 48	android/os/Parcel:readInt	()I
    //   36: ifeq +26 -> 62
    //   39: getstatic 67	com/tencent/mobileqq/ar/aidl/ArEffectConfig:CREATOR	Landroid/os/Parcelable$Creator;
    //   42: aload_3
    //   43: invokeinterface 60 2 0
    //   48: checkcast 66	com/tencent/mobileqq/ar/aidl/ArEffectConfig
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: aload_2
    //   57: invokevirtual 63	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -12 -> 52
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 63	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	qpq
    //   51	13	1	localArEffectConfig	com.tencent.mobileqq.ar.aidl.ArEffectConfig
    //   67	10	1	localObject	Object
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	52	67	finally
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.ar.aidl.IArConfigManager";
  }
  
  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(5, localParcel1, localParcel2, 0);
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
  public void a(com.tencent.mobileqq.ar.aidl.IArRemoteCallback paramIArRemoteCallback)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 75 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 78	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 21	qpq:a	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 41 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 44	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 63	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 63	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 63	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	qpq
    //   0	73	1	paramIArRemoteCallback	com.tencent.mobileqq.ar.aidl.IArRemoteCallback
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(6, localParcel1, localParcel2, 0);
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
  public void b(com.tencent.mobileqq.ar.aidl.IArRemoteCallback paramIArRemoteCallback)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 75 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 78	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 21	qpq:a	Landroid/os/IBinder;
    //   34: iconst_2
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 41 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 44	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 63	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 63	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 63	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 63	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	qpq
    //   0	73	1	paramIArRemoteCallback	com.tencent.mobileqq.ar.aidl.IArRemoteCallback
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */