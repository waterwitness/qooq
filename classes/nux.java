import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nux
  implements IAIOImageProviderCallBack
{
  private IBinder a;
  
  public nux(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 11
    //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 9
    //   8: aload 9
    //   10: ldc 33
    //   12: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 9
    //   17: lload_1
    //   18: invokevirtual 41	android/os/Parcel:writeLong	(J)V
    //   21: aload 9
    //   23: iload_3
    //   24: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   27: aload 9
    //   29: iload 4
    //   31: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   34: aload 9
    //   36: iload 5
    //   38: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   41: aload 9
    //   43: lload 6
    //   45: invokevirtual 41	android/os/Parcel:writeLong	(J)V
    //   48: iload 8
    //   50: ifeq +34 -> 84
    //   53: iload 11
    //   55: istore_3
    //   56: aload 9
    //   58: iload_3
    //   59: i2b
    //   60: invokevirtual 49	android/os/Parcel:writeByte	(B)V
    //   63: aload_0
    //   64: getfield 21	nux:a	Landroid/os/IBinder;
    //   67: iconst_3
    //   68: aload 9
    //   70: aconst_null
    //   71: iconst_1
    //   72: invokeinterface 55 5 0
    //   77: pop
    //   78: aload 9
    //   80: invokevirtual 58	android/os/Parcel:recycle	()V
    //   83: return
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -30 -> 56
    //   89: astore 10
    //   91: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: ldc 66
    //   99: iconst_2
    //   100: aload 10
    //   102: invokevirtual 70	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   105: aload 10
    //   107: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 9
    //   112: invokevirtual 58	android/os/Parcel:recycle	()V
    //   115: return
    //   116: astore 10
    //   118: aload 9
    //   120: invokevirtual 58	android/os/Parcel:recycle	()V
    //   123: aload 10
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	nux
    //   0	126	1	paramLong1	long
    //   0	126	3	paramInt1	int
    //   0	126	4	paramInt2	int
    //   0	126	5	paramInt3	int
    //   0	126	6	paramLong2	long
    //   0	126	8	paramBoolean	boolean
    //   6	113	9	localParcel	Parcel
    //   89	17	10	localRemoteException	RemoteException
    //   116	8	10	localObject	Object
    //   1	53	11	i	int
    // Exception table:
    //   from	to	target	type
    //   8	48	89	android/os/RemoteException
    //   56	78	89	android/os/RemoteException
    //   8	48	116	finally
    //   56	78	116	finally
    //   91	110	116	finally
  }
  
  /* Error */
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 8
    //   8: aload 8
    //   10: ldc 33
    //   12: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 8
    //   17: lload_1
    //   18: invokevirtual 41	android/os/Parcel:writeLong	(J)V
    //   21: aload 8
    //   23: iload_3
    //   24: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   27: aload 8
    //   29: iload 4
    //   31: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   34: aload 8
    //   36: iload 5
    //   38: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   41: aload 8
    //   43: aload 6
    //   45: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   48: iload 7
    //   50: ifeq +34 -> 84
    //   53: iload 9
    //   55: istore_3
    //   56: aload 8
    //   58: iload_3
    //   59: i2b
    //   60: invokevirtual 49	android/os/Parcel:writeByte	(B)V
    //   63: aload_0
    //   64: getfield 21	nux:a	Landroid/os/IBinder;
    //   67: iconst_1
    //   68: aload 8
    //   70: aconst_null
    //   71: iconst_1
    //   72: invokeinterface 55 5 0
    //   77: pop
    //   78: aload 8
    //   80: invokevirtual 58	android/os/Parcel:recycle	()V
    //   83: return
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -30 -> 56
    //   89: astore 6
    //   91: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: ldc 66
    //   99: iconst_2
    //   100: aload 6
    //   102: invokevirtual 70	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   105: aload 6
    //   107: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 8
    //   112: invokevirtual 58	android/os/Parcel:recycle	()V
    //   115: return
    //   116: astore 6
    //   118: aload 8
    //   120: invokevirtual 58	android/os/Parcel:recycle	()V
    //   123: aload 6
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	nux
    //   0	126	1	paramLong	long
    //   0	126	3	paramInt1	int
    //   0	126	4	paramInt2	int
    //   0	126	5	paramInt3	int
    //   0	126	6	paramString	String
    //   0	126	7	paramBoolean	boolean
    //   6	113	8	localParcel	Parcel
    //   1	53	9	i	int
    // Exception table:
    //   from	to	target	type
    //   8	48	89	android/os/RemoteException
    //   56	78	89	android/os/RemoteException
    //   8	48	116	finally
    //   56	78	116	finally
    //   91	110	116	finally
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeTypedArray(paramArrayOfAIORichMediaData, 0);
      localParcel.writeInt(paramInt);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramArrayOfAIORichMediaData)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProviderCallBack", 2, paramArrayOfAIORichMediaData.getMessage(), paramArrayOfAIORichMediaData);
      }
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


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */