import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.gvideo.IGVServiceForQQ;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gjj
  implements IGVServiceForQQ
{
  private IBinder a;
  
  public gjj(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public int a(long paramLong, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String a()
  {
    return "com.tencent.av.gvideo.IGVServiceForQQ";
  }
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      this.a.transact(6, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(com.tencent.arrange.op.MeetingInfo paramMeetingInfo)
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
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 67	com/tencent/arrange/op/MeetingInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 21	gjj:a	Landroid/os/IBinder;
    //   33: iconst_4
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 49 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 52	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 59	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 59	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 59	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 59	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	gjj
    //   0	75	1	paramMeetingInfo	com.tencent.arrange.op.MeetingInfo
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      if (paramIAVServiceCallback != null) {
        localIBinder = paramIAVServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, android.app.Notification paramNotification)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_3
    //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 4
    //   12: aload_3
    //   13: ldc 31
    //   15: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: ifeq +54 -> 73
    //   22: aload_3
    //   23: iload 5
    //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   28: aload_2
    //   29: ifnull +50 -> 79
    //   32: aload_3
    //   33: iconst_1
    //   34: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokevirtual 81	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
    //   43: aload_0
    //   44: getfield 21	gjj:a	Landroid/os/IBinder;
    //   47: iconst_3
    //   48: aload_3
    //   49: aload 4
    //   51: iconst_0
    //   52: invokeinterface 49 5 0
    //   57: pop
    //   58: aload 4
    //   60: invokevirtual 52	android/os/Parcel:readException	()V
    //   63: aload 4
    //   65: invokevirtual 59	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 59	android/os/Parcel:recycle	()V
    //   72: return
    //   73: iconst_0
    //   74: istore 5
    //   76: goto -54 -> 22
    //   79: aload_3
    //   80: iconst_0
    //   81: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   84: goto -41 -> 43
    //   87: astore_2
    //   88: aload 4
    //   90: invokevirtual 59	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 59	android/os/Parcel:recycle	()V
    //   97: aload_2
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	gjj
    //   0	99	1	paramBoolean	boolean
    //   0	99	2	paramNotification	android.app.Notification
    //   6	88	3	localParcel1	Parcel
    //   10	79	4	localParcel2	Parcel
    //   1	74	5	i	int
    // Exception table:
    //   from	to	target	type
    //   12	18	87	finally
    //   22	28	87	finally
    //   32	43	87	finally
    //   43	63	87	finally
    //   79	84	87	finally
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      localParcel.writeByteArray(paramArrayOfByte);
      this.a.transact(2, localParcel, null, 1);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */