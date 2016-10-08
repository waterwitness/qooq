import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gmz
  implements IAVServiceForQQ
{
  private IBinder a;
  
  public gmz(IBinder paramIBinder)
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
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      this.a.transact(8, localParcel1, localParcel2, 0);
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
  
  /* Error */
  public com.tencent.av.service.AVPbInfo a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 64	android/os/Parcel:writeByteArray	([B)V
    //   19: aload_0
    //   20: getfield 21	gmz:a	Landroid/os/IBinder;
    //   23: bipush 10
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 49 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 52	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 56	android/os/Parcel:readInt	()I
    //   42: ifeq +26 -> 68
    //   45: getstatic 70	com/tencent/av/service/AVPbInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 76 2 0
    //   54: checkcast 66	com/tencent/av/service/AVPbInfo
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 59	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 59	android/os/Parcel:recycle	()V
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 59	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 59	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	gmz
    //   0	84	1	paramArrayOfByte	byte[]
    //   3	76	2	localParcel1	Parcel
    //   7	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	58	73	finally
  }
  
  public String a()
  {
    return "com.tencent.av.service.IAVServiceForQQ";
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
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 84	com/tencent/arrange/op/MeetingInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 21	gmz:a	Landroid/os/IBinder;
    //   33: bipush 6
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 49 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 52	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 59	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 59	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 59	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 59	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	gmz
    //   0	76	1	paramMeetingInfo	com.tencent.arrange.op.MeetingInfo
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
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
  
  public void a(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel.writeString(paramString);
      this.a.transact(9, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(String paramString, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 31
    //   7: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 97	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: ifnull +34 -> 50
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 101	android/graphics/Bitmap:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 21	gmz:a	Landroid/os/IBinder;
    //   34: bipush 7
    //   36: aload_3
    //   37: aconst_null
    //   38: iconst_1
    //   39: invokeinterface 49 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 59	android/os/Parcel:recycle	()V
    //   49: return
    //   50: aload_3
    //   51: iconst_0
    //   52: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   55: goto -25 -> 30
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 59	android/os/Parcel:recycle	()V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	gmz
    //   0	65	1	paramString	String
    //   0	65	2	paramBitmap	android.graphics.Bitmap
    //   3	57	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	15	58	finally
    //   19	30	58	finally
    //   30	45	58	finally
    //   50	55	58	finally
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
    //   40: invokevirtual 105	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
    //   43: aload_0
    //   44: getfield 21	gmz:a	Landroid/os/IBinder;
    //   47: iconst_5
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
    //   0	99	0	this	gmz
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
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
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
  
  public void b(byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */