package com.tencent.upload.a;

import android.content.ComponentName;
import android.content.ServiceConnection;

final class c
  implements ServiceConnection
{
  c(b paramb) {}
  
  /* Error */
  public final void onServiceConnected(ComponentName arg1, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 22
    //   2: ldc 23
    //   4: invokestatic 29	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   11: new 31	android/os/Messenger
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 34	android/os/Messenger:<init>	(Landroid/os/IBinder;)V
    //   19: putfield 38	com/tencent/upload/a/b:e	Landroid/os/Messenger;
    //   22: aload_0
    //   23: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   26: iconst_1
    //   27: putfield 41	com/tencent/upload/a/b:a	Z
    //   30: aconst_null
    //   31: iconst_2
    //   32: invokestatic 47	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   35: astore_1
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   41: getfield 50	com/tencent/upload/a/b:c	Landroid/os/Messenger;
    //   44: putfield 53	android/os/Message:replyTo	Landroid/os/Messenger;
    //   47: aload_0
    //   48: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   51: getfield 38	com/tencent/upload/a/b:e	Landroid/os/Messenger;
    //   54: ifnull +14 -> 68
    //   57: aload_0
    //   58: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   61: getfield 38	com/tencent/upload/a/b:e	Landroid/os/Messenger;
    //   64: aload_1
    //   65: invokevirtual 57	android/os/Messenger:send	(Landroid/os/Message;)V
    //   68: aload_0
    //   69: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   72: getfield 61	com/tencent/upload/a/b:d	Lcom/tencent/upload/a/b$a;
    //   75: invokevirtual 65	com/tencent/upload/a/b$a:a	()V
    //   78: aload_0
    //   79: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   82: getfield 68	com/tencent/upload/a/b:b	[B
    //   85: astore_1
    //   86: aload_1
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 12	com/tencent/upload/a/c:a	Lcom/tencent/upload/a/b;
    //   92: getfield 68	com/tencent/upload/a/b:b	[B
    //   95: invokevirtual 71	java/lang/Object:notify	()V
    //   98: aload_1
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: ldc 22
    //   104: ldc 73
    //   106: aload_1
    //   107: invokestatic 76	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: goto -42 -> 68
    //   113: astore_2
    //   114: aload_1
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	c
    //   0	118	2	paramIBinder	android.os.IBinder
    // Exception table:
    //   from	to	target	type
    //   47	68	101	java/lang/Exception
    //   88	100	113	finally
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    b.b("ServiceImpl", "onServiceDisconnected");
    this.a.a = false;
    this.a.e = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */