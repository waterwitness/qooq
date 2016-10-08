import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoNotifyCenter;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggg
  implements ServiceConnection
{
  public ggg(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   4: aload_2
    //   5: invokestatic 33	com/tencent/av/service/IQQServiceForAV$Stub:a	(Landroid/os/IBinder;)Lcom/tencent/av/service/IQQServiceForAV;
    //   8: putfield 38	com/tencent/av/app/VideoAppInterface:jdField_a_of_type_ComTencentAvServiceIQQServiceForAV	Lcom/tencent/av/service/IQQServiceForAV;
    //   11: aload_0
    //   12: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   15: getfield 38	com/tencent/av/app/VideoAppInterface:jdField_a_of_type_ComTencentAvServiceIQQServiceForAV	Lcom/tencent/av/service/IQQServiceForAV;
    //   18: aload_0
    //   19: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   22: getfield 41	com/tencent/av/app/VideoAppInterface:jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub	Lcom/tencent/av/service/IQQServiceCallback$Stub;
    //   25: invokeinterface 46 2 0
    //   30: aload_0
    //   31: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   34: getfield 49	com/tencent/av/app/VideoAppInterface:i	Z
    //   37: ifeq +10 -> 47
    //   40: aload_0
    //   41: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   44: invokevirtual 52	com/tencent/av/app/VideoAppInterface:g	()V
    //   47: aload_0
    //   48: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: bipush 10
    //   59: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokevirtual 61	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   66: aload_0
    //   67: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   70: getfield 38	com/tencent/av/app/VideoAppInterface:jdField_a_of_type_ComTencentAvServiceIQQServiceForAV	Lcom/tencent/av/service/IQQServiceForAV;
    //   73: invokeinterface 65 1 0
    //   78: new 67	ggh
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 70	ggh:<init>	(Lggg;)V
    //   86: iconst_0
    //   87: invokeinterface 76 3 0
    //   92: aload_0
    //   93: getfield 12	ggg:a	Lcom/tencent/av/app/VideoAppInterface;
    //   96: invokestatic 78	com/tencent/av/app/VideoAppInterface:a	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   99: return
    //   100: astore_1
    //   101: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq -38 -> 66
    //   107: getstatic 87	com/tencent/av/app/VideoAppInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: iconst_2
    //   111: ldc 88
    //   113: aload_1
    //   114: invokestatic 92	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: goto -51 -> 66
    //   120: astore_1
    //   121: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq -32 -> 92
    //   127: getstatic 87	com/tencent/av/app/VideoAppInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   130: iconst_2
    //   131: ldc 88
    //   133: aload_1
    //   134: invokestatic 92	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -45 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	ggg
    //   0	140	1	paramComponentName	ComponentName
    //   0	140	2	paramIBinder	android.os.IBinder
    // Exception table:
    //   from	to	target	type
    //   11	47	100	android/os/RemoteException
    //   47	66	100	android/os/RemoteException
    //   66	92	120	java/lang/Exception
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
      }
      this.a.a(new Object[] { Integer.valueOf(11) });
      this.a.a().deleteObservers();
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "onServiceDisconnected", paramComponentName);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */