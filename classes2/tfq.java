import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.IQQPlayerCallback;

public class tfq
  implements IQQPlayerCallback
{
  private IBinder a;
  
  public tfq(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.music.IQQPlayerCallback";
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerCallback");
      localParcel.writeInt(paramInt);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.music.SongInfo paramSongInfo)
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
    //   16: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 55	com/tencent/mobileqq/music/SongInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 21	tfq:a	Landroid/os/IBinder;
    //   29: iconst_2
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 45 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 48	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 48	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	tfq
    //   0	59	1	paramSongInfo	com.tencent.mobileqq.music.SongInfo
    //   3	51	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */