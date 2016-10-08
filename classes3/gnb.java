import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gnb
  implements IQQServiceForAV
{
  private IBinder a;
  
  public gnb(IBinder paramIBinder)
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
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(19, localParcel1, localParcel2, 0);
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
  
  public int a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(12, localParcel1, localParcel2, 0);
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
  
  public long a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(20, localParcel1, localParcel2, 0);
      localParcel2.readException();
      long l = localParcel2.readLong();
      return l;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
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
    //   22: iload_1
    //   23: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   26: aload 6
    //   28: aload_2
    //   29: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: aload 6
    //   34: aload_3
    //   35: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   38: iload 4
    //   40: ifeq +80 -> 120
    //   43: iconst_1
    //   44: istore_1
    //   45: aload 6
    //   47: iload_1
    //   48: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   51: iload 5
    //   53: ifeq +72 -> 125
    //   56: iload 8
    //   58: istore_1
    //   59: aload 6
    //   61: iload_1
    //   62: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   65: aload_0
    //   66: getfield 21	gnb:a	Landroid/os/IBinder;
    //   69: iconst_2
    //   70: aload 6
    //   72: aload 7
    //   74: iconst_0
    //   75: invokeinterface 41 5 0
    //   80: pop
    //   81: aload 7
    //   83: invokevirtual 44	android/os/Parcel:readException	()V
    //   86: aload 7
    //   88: invokevirtual 47	android/os/Parcel:readInt	()I
    //   91: ifeq +39 -> 130
    //   94: getstatic 70	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
    //   97: aload 7
    //   99: invokeinterface 76 2 0
    //   104: checkcast 66	android/graphics/Bitmap
    //   107: astore_2
    //   108: aload 7
    //   110: invokevirtual 50	android/os/Parcel:recycle	()V
    //   113: aload 6
    //   115: invokevirtual 50	android/os/Parcel:recycle	()V
    //   118: aload_2
    //   119: areturn
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -77 -> 45
    //   125: iconst_0
    //   126: istore_1
    //   127: goto -68 -> 59
    //   130: aconst_null
    //   131: astore_2
    //   132: goto -24 -> 108
    //   135: astore_2
    //   136: aload 7
    //   138: invokevirtual 50	android/os/Parcel:recycle	()V
    //   141: aload 6
    //   143: invokevirtual 50	android/os/Parcel:recycle	()V
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	gnb
    //   0	148	1	paramInt	int
    //   0	148	2	paramString1	String
    //   0	148	3	paramString2	String
    //   0	148	4	paramBoolean1	boolean
    //   0	148	5	paramBoolean2	boolean
    //   6	136	6	localParcel1	Parcel
    //   11	126	7	localParcel2	Parcel
    //   1	56	8	i	int
    // Exception table:
    //   from	to	target	type
    //   13	38	135	finally
    //   45	51	135	finally
    //   59	108	135	finally
  }
  
  public String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(27, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString1 = localParcel2.readString();
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(6, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeInt(paramInt);
      this.a.transact(28, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString);
      this.a.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString1);
      localParcel.writeString(paramString2);
      this.a.transact(9, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeLong(paramLong);
      this.a.transact(16, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeLong(paramLong);
      localParcel.writeString(paramString);
      localParcel.writeInt(paramInt);
      this.a.transact(38, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      if (paramIQQServiceCallback != null) {
        localIBinder = paramIQQServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(7, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      if (paramIQQServiceLocationCallback != null) {
        localIBinder = paramIQQServiceLocationCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(25, localParcel, null, 1);
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
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeString(paramString);
      this.a.transact(29, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeString(paramString);
      localParcel.writeLong(paramLong);
      this.a.transact(54, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeString(paramString1);
      localParcel.writeString(paramString2);
      localParcel.writeString(paramString3);
      this.a.transact(36, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 31
    //   10: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: ifeq +29 -> 43
    //   17: aload_2
    //   18: iload 4
    //   20: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   23: aload_0
    //   24: getfield 21	gnb:a	Landroid/os/IBinder;
    //   27: bipush 43
    //   29: aload_2
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokeinterface 41 5 0
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual 50	android/os/Parcel:recycle	()V
    //   42: return
    //   43: iconst_0
    //   44: istore 4
    //   46: goto -29 -> 17
    //   49: astore_3
    //   50: aload_2
    //   51: invokevirtual 50	android/os/Parcel:recycle	()V
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	gnb
    //   0	56	1	paramBoolean	boolean
    //   6	45	2	localParcel	Parcel
    //   49	6	3	localObject	Object
    //   1	44	4	i	int
    // Exception table:
    //   from	to	target	type
    //   7	13	49	finally
    //   17	38	49	finally
  }
  
  public void a(long[] paramArrayOfLong, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeLongArray(paramArrayOfLong);
      localParcel.writeString(paramString);
      this.a.transact(37, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(13, localParcel1, localParcel2, 0);
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
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeLong(paramLong);
      this.a.transact(11, localParcel1, localParcel2, 0);
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
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_2
    //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore_3
    //   11: aload_2
    //   12: ldc 31
    //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 21	gnb:a	Landroid/os/IBinder;
    //   26: iconst_1
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokeinterface 41 5 0
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 44	android/os/Parcel:readException	()V
    //   40: aload_3
    //   41: invokevirtual 47	android/os/Parcel:readInt	()I
    //   44: istore 4
    //   46: iload 4
    //   48: ifeq +14 -> 62
    //   51: aload_3
    //   52: invokevirtual 50	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 50	android/os/Parcel:recycle	()V
    //   59: iload 5
    //   61: ireturn
    //   62: iconst_0
    //   63: istore 5
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 50	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 50	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	gnb
    //   0	79	1	paramString	String
    //   6	68	2	localParcel1	Parcel
    //   10	60	3	localParcel2	Parcel
    //   44	3	4	i	int
    //   1	63	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	46	68	finally
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(23, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
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
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(21, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt1 = localParcel2.readInt();
      if (paramInt1 != 0) {
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
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(39, localParcel1, localParcel2, 0);
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
  public boolean a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
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
    //   20: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: iload_2
    //   24: ifeq +59 -> 83
    //   27: iconst_1
    //   28: istore 5
    //   30: aload_3
    //   31: iload 5
    //   33: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   36: aload_0
    //   37: getfield 21	gnb:a	Landroid/os/IBinder;
    //   40: bipush 24
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 41 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 44	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 47	android/os/Parcel:readInt	()I
    //   62: istore 5
    //   64: iload 5
    //   66: ifeq +23 -> 89
    //   69: iload 6
    //   71: istore_2
    //   72: aload 4
    //   74: invokevirtual 50	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 50	android/os/Parcel:recycle	()V
    //   81: iload_2
    //   82: ireturn
    //   83: iconst_0
    //   84: istore 5
    //   86: goto -56 -> 30
    //   89: iconst_0
    //   90: istore_2
    //   91: goto -19 -> 72
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 50	android/os/Parcel:recycle	()V
    //   100: aload_3
    //   101: invokevirtual 50	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	gnb
    //   0	106	1	paramString	String
    //   0	106	2	paramBoolean	boolean
    //   6	95	3	localParcel1	Parcel
    //   10	86	4	localParcel2	Parcel
    //   28	57	5	i	int
    //   1	69	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   12	23	94	finally
    //   30	64	94	finally
  }
  
  public int[] a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(49, localParcel1, localParcel2, 0);
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
  
  public long[] a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createLongArray();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String[] a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(41, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createStringArray();
      return paramString;
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
  
  public int b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(47, localParcel1, localParcel2, 0);
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
  
  public int b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(18, localParcel1, localParcel2, 0);
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
  
  public String b()
  {
    return "com.tencent.av.service.IQQServiceForAV";
  }
  
  public String b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(42, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void b()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(33, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString);
      this.a.transact(10, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void b(IQQServiceCallback paramIQQServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      if (paramIQQServiceCallback != null) {
        localIBinder = paramIQQServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(8, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void b(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      if (paramIQQServiceLocationCallback != null) {
        localIBinder = paramIQQServiceLocationCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(26, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void b(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeString(paramString);
      this.a.transact(31, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 31
    //   10: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: ifeq +29 -> 43
    //   17: aload_2
    //   18: iload 4
    //   20: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   23: aload_0
    //   24: getfield 21	gnb:a	Landroid/os/IBinder;
    //   27: bipush 53
    //   29: aload_2
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokeinterface 41 5 0
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual 50	android/os/Parcel:recycle	()V
    //   42: return
    //   43: iconst_0
    //   44: istore 4
    //   46: goto -29 -> 17
    //   49: astore_3
    //   50: aload_2
    //   51: invokevirtual 50	android/os/Parcel:recycle	()V
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	gnb
    //   0	56	1	paramBoolean	boolean
    //   6	45	2	localParcel	Parcel
    //   49	6	3	localObject	Object
    //   1	44	4	i	int
    // Exception table:
    //   from	to	target	type
    //   7	13	49	finally
    //   17	38	49	finally
  }
  
  public boolean b()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(14, localParcel1, localParcel2, 0);
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
  
  public boolean b(long paramLong)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeLong(paramLong);
      this.a.transact(22, localParcel1, localParcel2, 0);
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
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(17, localParcel1, localParcel2, 0);
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
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(30, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
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
  
  public long[] b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(40, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createLongArray();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(48, localParcel1, localParcel2, 0);
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
  
  public int c(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(35, localParcel1, localParcel2, 0);
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
  
  public String c(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(45, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void c()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(34, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void c(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeString(paramString);
      this.a.transact(32, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 31
    //   10: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: ifeq +29 -> 43
    //   17: aload_2
    //   18: iload 4
    //   20: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   23: aload_0
    //   24: getfield 21	gnb:a	Landroid/os/IBinder;
    //   27: bipush 55
    //   29: aload_2
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokeinterface 41 5 0
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual 50	android/os/Parcel:recycle	()V
    //   42: return
    //   43: iconst_0
    //   44: istore 4
    //   46: goto -29 -> 17
    //   49: astore_3
    //   50: aload_2
    //   51: invokevirtual 50	android/os/Parcel:recycle	()V
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	gnb
    //   0	56	1	paramBoolean	boolean
    //   6	45	2	localParcel	Parcel
    //   49	6	3	localObject	Object
    //   1	44	4	i	int
    // Exception table:
    //   from	to	target	type
    //   7	13	49	finally
    //   17	38	49	finally
  }
  
  public boolean c()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(44, localParcel1, localParcel2, 0);
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
  
  public int d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(52, localParcel1, localParcel2, 0);
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
  
  public String d(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(46, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean d()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(50, localParcel1, localParcel2, 0);
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
  
  public boolean e()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(51, localParcel1, localParcel2, 0);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */