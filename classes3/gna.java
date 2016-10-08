import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gna
  implements IQQServiceCallback
{
  private IBinder a;
  
  public gna(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.av.service.IQQServiceCallback";
  }
  
  /* Error */
  public void a(com.tencent.av.service.RecvMsg paramRecvMsg)
  {
    // Byte code:
    //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 25
    //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 46	com/tencent/av/service/RecvMsg:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 21	gna:a	Landroid/os/IBinder;
    //   29: iconst_1
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 52 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 55	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 55	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	gna
    //   0	59	1	paramRecvMsg	com.tencent.av.service.RecvMsg
    //   3	51	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
  
  public void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceCallback");
      localParcel.writeTypedArray(paramArrayOfRecvGVideoLevelInfo, 0);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */