import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.IPresendPicMgr;

public class tsv
  implements IPresendPicMgr
{
  private IBinder a;
  
  public tsv(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  public int a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.pic.IPresendPicMgr";
  }
  
  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
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
  
  public void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      localParcel1.writeInt(paramInt);
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
  
  public void a(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(2, localParcel1, localParcel2, 0);
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
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 31
    //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: aload_1
    //   23: invokevirtual 59	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload 6
    //   28: aload_2
    //   29: invokevirtual 59	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: iload_3
    //   33: ifeq +56 -> 89
    //   36: aload 6
    //   38: iload 8
    //   40: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   43: aload 6
    //   45: iload 4
    //   47: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   50: aload 6
    //   52: iload 5
    //   54: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   57: aload_0
    //   58: getfield 21	tsv:a	Landroid/os/IBinder;
    //   61: iconst_1
    //   62: aload 6
    //   64: aload 7
    //   66: iconst_0
    //   67: invokeinterface 41 5 0
    //   72: pop
    //   73: aload 7
    //   75: invokevirtual 44	android/os/Parcel:readException	()V
    //   78: aload 7
    //   80: invokevirtual 50	android/os/Parcel:recycle	()V
    //   83: aload 6
    //   85: invokevirtual 50	android/os/Parcel:recycle	()V
    //   88: return
    //   89: iconst_0
    //   90: istore 8
    //   92: goto -56 -> 36
    //   95: astore_1
    //   96: aload 7
    //   98: invokevirtual 50	android/os/Parcel:recycle	()V
    //   101: aload 6
    //   103: invokevirtual 50	android/os/Parcel:recycle	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	tsv
    //   0	108	1	paramString1	String
    //   0	108	2	paramString2	String
    //   0	108	3	paramBoolean	boolean
    //   0	108	4	paramInt1	int
    //   0	108	5	paramInt2	int
    //   6	96	6	localParcel1	Parcel
    //   11	86	7	localParcel2	Parcel
    //   1	90	8	i	int
    // Exception table:
    //   from	to	target	type
    //   13	32	95	finally
    //   36	78	95	finally
  }
  
  public int[] a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int[] arrayOfInt = localParcel2.createIntArray();
      return arrayOfInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean[] a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      boolean[] arrayOfBoolean = localParcel2.createBooleanArray();
      return arrayOfBoolean;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */