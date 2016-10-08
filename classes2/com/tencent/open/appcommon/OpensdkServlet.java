package com.tencent.open.appcommon;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class OpensdkServlet
  extends MSFServlet
{
  public OpensdkServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: new 21	android/os/Bundle
    //   3: dup
    //   4: invokespecial 22	android/os/Bundle:<init>	()V
    //   7: astore_3
    //   8: aload_2
    //   9: invokevirtual 28	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +96 -> 112
    //   19: aload 6
    //   21: arraylength
    //   22: iconst_4
    //   23: if_icmple +89 -> 112
    //   26: new 30	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload 6
    //   32: invokespecial 33	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: astore 4
    //   37: new 35	java/io/DataInputStream
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 38	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 42	java/io/DataInputStream:readInt	()I
    //   53: iconst_4
    //   54: isub
    //   55: istore 8
    //   57: iload 8
    //   59: newarray <illegal type>
    //   61: astore 7
    //   63: aload 6
    //   65: iconst_4
    //   66: aload 7
    //   68: iconst_0
    //   69: iload 8
    //   71: invokestatic 48	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   74: aload_3
    //   75: ldc 50
    //   77: aload 7
    //   79: invokevirtual 54	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   82: aload_3
    //   83: ldc 56
    //   85: aload_2
    //   86: invokevirtual 59	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   89: invokevirtual 63	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   92: aload_3
    //   93: ldc 65
    //   95: aload_2
    //   96: invokevirtual 69	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   99: invokevirtual 73	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 4
    //   104: invokevirtual 76	java/io/ByteArrayInputStream:close	()V
    //   107: aload 5
    //   109: invokevirtual 77	java/io/DataInputStream:close	()V
    //   112: aload_0
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_2
    //   116: invokevirtual 81	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   119: aload_3
    //   120: ldc 83
    //   122: invokevirtual 87	com/tencent/open/appcommon/OpensdkServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   125: return
    //   126: astore 6
    //   128: aload 4
    //   130: invokevirtual 76	java/io/ByteArrayInputStream:close	()V
    //   133: aload 5
    //   135: invokevirtual 77	java/io/DataInputStream:close	()V
    //   138: goto -26 -> 112
    //   141: astore 4
    //   143: goto -31 -> 112
    //   146: astore_1
    //   147: aload 4
    //   149: invokevirtual 76	java/io/ByteArrayInputStream:close	()V
    //   152: aload 5
    //   154: invokevirtual 77	java/io/DataInputStream:close	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_2
    //   160: goto -3 -> 157
    //   163: astore 4
    //   165: goto -53 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	OpensdkServlet
    //   0	168	1	paramIntent	Intent
    //   0	168	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   7	113	3	localBundle	android.os.Bundle
    //   35	94	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   141	7	4	localException1	Exception
    //   163	1	4	localException2	Exception
    //   46	107	5	localDataInputStream	java.io.DataInputStream
    //   12	52	6	arrayOfByte1	byte[]
    //   126	1	6	localException3	Exception
    //   61	17	7	arrayOfByte2	byte[]
    //   55	15	8	i	int
    // Exception table:
    //   from	to	target	type
    //   48	102	126	java/lang/Exception
    //   128	138	141	java/lang/Exception
    //   48	102	146	finally
    //   147	157	159	java/lang/Exception
    //   102	112	163	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  /* Error */
  public void service(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 93	mqq/app/MSFServlet:service	(Landroid/content/Intent;)V
    //   5: aload_1
    //   6: ldc 95
    //   8: invokevirtual 101	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: new 103	com/tencent/qphone/base/remote/ToServiceMsg
    //   15: dup
    //   16: aconst_null
    //   17: aload_1
    //   18: ldc 105
    //   20: invokevirtual 101	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   23: aload_2
    //   24: invokespecial 108	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_1
    //   29: ldc 50
    //   31: invokevirtual 112	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   34: astore 5
    //   36: new 114	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: aload 5
    //   42: arraylength
    //   43: iconst_4
    //   44: iadd
    //   45: invokespecial 117	java/io/ByteArrayOutputStream:<init>	(I)V
    //   48: astore_3
    //   49: new 119	java/io/DataOutputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 122	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: aload 5
    //   63: arraylength
    //   64: iconst_4
    //   65: iadd
    //   66: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   69: aload 4
    //   71: aload 5
    //   73: invokevirtual 128	java/io/DataOutputStream:write	([B)V
    //   76: aload_2
    //   77: aload_3
    //   78: invokevirtual 131	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: invokevirtual 134	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   84: aload_3
    //   85: invokevirtual 135	java/io/ByteArrayOutputStream:close	()V
    //   88: aload 4
    //   90: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   93: aload_2
    //   94: ldc2_w 137
    //   97: invokevirtual 142	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   100: aload_2
    //   101: ldc -112
    //   103: ldc -110
    //   105: invokevirtual 150	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_0
    //   110: aload_1
    //   111: aload_2
    //   112: invokevirtual 154	com/tencent/open/appcommon/OpensdkServlet:sendToMSF	(Landroid/content/Intent;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   115: return
    //   116: astore 5
    //   118: aload_3
    //   119: invokevirtual 135	java/io/ByteArrayOutputStream:close	()V
    //   122: aload 4
    //   124: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   127: goto -34 -> 93
    //   130: astore_3
    //   131: goto -38 -> 93
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual 135	java/io/ByteArrayOutputStream:close	()V
    //   139: aload 4
    //   141: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_2
    //   147: goto -3 -> 144
    //   150: astore_3
    //   151: goto -58 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	OpensdkServlet
    //   0	154	1	paramIntent	Intent
    //   11	101	2	localObject	Object
    //   146	1	2	localException1	Exception
    //   48	71	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   130	6	3	localException2	Exception
    //   150	1	3	localException3	Exception
    //   57	83	4	localDataOutputStream	java.io.DataOutputStream
    //   34	38	5	arrayOfByte	byte[]
    //   116	1	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   59	84	116	java/lang/Exception
    //   118	127	130	java/lang/Exception
    //   59	84	134	finally
    //   135	144	146	java/lang/Exception
    //   84	93	150	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\OpensdkServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */