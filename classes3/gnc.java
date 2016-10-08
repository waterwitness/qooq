import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gnc
  implements IQQServiceLocationCallback
{
  private IBinder a;
  
  public gnc(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.av.service.IQQServiceLocationCallback";
  }
  
  public void a(int paramInt, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceLocationCallback");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, com.tencent.av.service.LBSInfo paramLBSInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_3
    //   7: aload_3
    //   8: ldc 25
    //   10: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: ifeq +43 -> 57
    //   17: aload_3
    //   18: iload 4
    //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   23: aload_2
    //   24: ifnull +39 -> 63
    //   27: aload_3
    //   28: iconst_1
    //   29: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   32: aload_2
    //   33: aload_3
    //   34: iconst_0
    //   35: invokevirtual 59	com/tencent/av/service/LBSInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   38: aload_0
    //   39: getfield 21	gnc:a	Landroid/os/IBinder;
    //   42: iconst_2
    //   43: aload_3
    //   44: aconst_null
    //   45: iconst_1
    //   46: invokeinterface 49 5 0
    //   51: pop
    //   52: aload_3
    //   53: invokevirtual 52	android/os/Parcel:recycle	()V
    //   56: return
    //   57: iconst_0
    //   58: istore 4
    //   60: goto -43 -> 17
    //   63: aload_3
    //   64: iconst_0
    //   65: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   68: goto -30 -> 38
    //   71: astore_2
    //   72: aload_3
    //   73: invokevirtual 52	android/os/Parcel:recycle	()V
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	gnc
    //   0	78	1	paramBoolean	boolean
    //   0	78	2	paramLBSInfo	com.tencent.av.service.LBSInfo
    //   6	67	3	localParcel	Parcel
    //   1	58	4	i	int
    // Exception table:
    //   from	to	target	type
    //   7	13	71	finally
    //   17	23	71	finally
    //   27	38	71	finally
    //   38	52	71	finally
    //   63	68	71	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */