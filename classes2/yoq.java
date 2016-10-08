import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.IServiceHandler;

public class yoq
  implements IServiceHandler
{
  private IBinder a;
  
  public yoq(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "cooperation.qzone.remote.IServiceHandler";
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void sendMsg(cooperation.qzone.remote.SendMsg paramSendMsg)
  {
    // Byte code:
    //   0: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 49	cooperation/qzone/remote/SendMsg:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 21	yoq:a	Landroid/os/IBinder;
    //   33: iconst_1
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 55 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 58	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 61	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 61	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 61	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 61	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	yoq
    //   0	75	1	paramSendMsg	cooperation.qzone.remote.SendMsg
    //   3	67	2	localParcel1	android.os.Parcel
    //   7	59	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */