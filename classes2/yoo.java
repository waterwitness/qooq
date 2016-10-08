import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.QZoneRemotePluginManager;

public class yoo
  implements QZoneRemotePluginManager
{
  private IBinder a;
  
  public yoo(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  /* Error */
  public cooperation.qzone.plugin.PluginRecord a(String paramString)
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
    //   16: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 21	yoo:a	Landroid/os/IBinder;
    //   23: bipush 6
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 44 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 47	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 51	android/os/Parcel:readInt	()I
    //   42: ifeq +26 -> 68
    //   45: getstatic 57	cooperation/qzone/plugin/PluginRecord:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 63 2 0
    //   54: checkcast 53	cooperation/qzone/plugin/PluginRecord
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 66	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 66	android/os/Parcel:recycle	()V
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 66	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 66	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	yoo
    //   0	84	1	paramString	String
    //   3	76	2	localParcel1	Parcel
    //   7	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	58	73	finally
  }
  
  public String a()
  {
    return "cooperation.qzone.plugin.QZoneRemotePluginManager";
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_1
    //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore_2
    //   11: aload_1
    //   12: ldc 31
    //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 21	yoo:a	Landroid/os/IBinder;
    //   21: iconst_1
    //   22: aload_1
    //   23: aload_2
    //   24: iconst_0
    //   25: invokeinterface 44 5 0
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 47	android/os/Parcel:readException	()V
    //   35: aload_2
    //   36: invokevirtual 51	android/os/Parcel:readInt	()I
    //   39: istore 4
    //   41: iload 4
    //   43: ifeq +14 -> 57
    //   46: aload_2
    //   47: invokevirtual 66	android/os/Parcel:recycle	()V
    //   50: aload_1
    //   51: invokevirtual 66	android/os/Parcel:recycle	()V
    //   54: iload 5
    //   56: ireturn
    //   57: iconst_0
    //   58: istore 5
    //   60: goto -14 -> 46
    //   63: astore_3
    //   64: aload_2
    //   65: invokevirtual 66	android/os/Parcel:recycle	()V
    //   68: aload_1
    //   69: invokevirtual 66	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	yoo
    //   6	63	1	localParcel1	Parcel
    //   10	55	2	localParcel2	Parcel
    //   63	10	3	localObject	Object
    //   39	3	4	i	int
    //   1	58	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	41	63	finally
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
      localParcel1.writeString(paramString);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public boolean a(String paramString, cooperation.qzone.plugin.OnQZonePluginInstallListner paramOnQZonePluginInstallListner)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_3
    //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 4
    //   12: aload_3
    //   13: ldc 31
    //   15: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   18: aload_3
    //   19: aload_1
    //   20: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload_2
    //   24: ifnull +62 -> 86
    //   27: aload_2
    //   28: invokeinterface 76 1 0
    //   33: astore_1
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 79	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   39: aload_0
    //   40: getfield 21	yoo:a	Landroid/os/IBinder;
    //   43: iconst_3
    //   44: aload_3
    //   45: aload 4
    //   47: iconst_0
    //   48: invokeinterface 44 5 0
    //   53: pop
    //   54: aload 4
    //   56: invokevirtual 47	android/os/Parcel:readException	()V
    //   59: aload 4
    //   61: invokevirtual 51	android/os/Parcel:readInt	()I
    //   64: istore 5
    //   66: iload 5
    //   68: ifeq +6 -> 74
    //   71: iconst_1
    //   72: istore 6
    //   74: aload 4
    //   76: invokevirtual 66	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 66	android/os/Parcel:recycle	()V
    //   83: iload 6
    //   85: ireturn
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -54 -> 34
    //   91: astore_1
    //   92: aload 4
    //   94: invokevirtual 66	android/os/Parcel:recycle	()V
    //   97: aload_3
    //   98: invokevirtual 66	android/os/Parcel:recycle	()V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	yoo
    //   0	103	1	paramString	String
    //   0	103	2	paramOnQZonePluginInstallListner	cooperation.qzone.plugin.OnQZonePluginInstallListner
    //   6	92	3	localParcel1	Parcel
    //   10	83	4	localParcel2	Parcel
    //   64	3	5	i	int
    //   1	83	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   12	23	91	finally
    //   27	34	91	finally
    //   34	66	91	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
      localParcel1.writeString(paramString);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean c(String paramString)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
      localParcel1.writeString(paramString);
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */