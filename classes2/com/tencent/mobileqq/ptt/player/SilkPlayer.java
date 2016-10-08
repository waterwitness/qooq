package com.tencent.mobileqq.ptt.player;

import android.app.Application;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import tym;

public final class SilkPlayer
  implements Handler.Callback, IPttPlayer
{
  private static final String jdField_a_of_type_JavaLangString = "SilkPlayer";
  private byte jdField_a_of_type_Byte;
  private Application jdField_a_of_type_AndroidAppApplication;
  private IPttPlayerListener jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private tym jdField_a_of_type_Tym;
  private String b;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public SilkPlayer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 3;
    this.e = -1;
    this.f = -1;
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_AndroidAppApplication = BaseApplicationImpl.a;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return this.h * 20;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Tym == null)
    {
      this.jdField_a_of_type_Tym = new tym(this, this.jdField_a_of_type_AndroidAppApplication);
      if ((this.f == -1) && (this.h > 0)) {
        b(a());
      }
      this.jdField_a_of_type_Tym.start();
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt, byte paramByte)
  {
    this.e = paramInt;
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public void a(IPttPlayerListener paramIPttPlayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener = paramIPttPlayerListener;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Tym != null) && (tym.a(this.jdField_a_of_type_Tym));
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Tym = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "seekTo=" + paramInt);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Tym != null) && (this.jdField_a_of_type_Tym.isAlive()))
    {
      tym.a(this.jdField_a_of_type_Tym, false);
      this.jdField_a_of_type_Tym = null;
    }
    this.e = -1;
    this.jdField_a_of_type_Byte = -1;
    this.g = 0;
    this.h = 0;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_Tym != null) && (this.jdField_a_of_type_Tym.isAlive()))
    {
      tym.a(this.jdField_a_of_type_Tym, false);
      this.jdField_a_of_type_Tym = null;
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mobileqq/ptt/player/SilkPlayer:e	I
    //   4: iconst_m1
    //   5: if_icmpeq +11 -> 16
    //   8: aload_0
    //   9: getfield 42	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   12: iconst_m1
    //   13: if_icmpne +67 -> 80
    //   16: new 138	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 72	com/tencent/mobileqq/ptt/player/SilkPlayer:b	Ljava/lang/String;
    //   24: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 42	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   34: iconst_m1
    //   35: if_icmpne +46 -> 81
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: aload_2
    //   42: invokestatic 145	com/tencent/mobileqq/utils/RecordParams:a	(Ljava/io/InputStream;)B
    //   45: putfield 42	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 38	com/tencent/mobileqq/ptt/player/SilkPlayer:e	I
    //   54: iconst_m1
    //   55: if_icmpne +17 -> 72
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 42	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   65: aload_2
    //   66: invokestatic 150	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: putfield 38	com/tencent/mobileqq/ptt/player/SilkPlayer:e	I
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 153	java/io/FileInputStream:close	()V
    //   80: return
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ldc2_w 154
    //   87: invokevirtual 159	java/io/FileInputStream:skip	(J)J
    //   90: pop2
    //   91: goto -43 -> 48
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +33 -> 133
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 12
    //   107: iconst_2
    //   108: new 111	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   115: ldc -95
    //   117: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_3
    //   121: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_2
    //   134: ifnull -54 -> 80
    //   137: aload_2
    //   138: invokevirtual 153	java/io/FileInputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: return
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 153	java/io/FileInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: return
    //   159: astore_1
    //   160: goto -5 -> 155
    //   163: astore_2
    //   164: goto -17 -> 147
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -75 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	SilkPlayer
    //   29	76	1	localFileInputStream1	java.io.FileInputStream
    //   142	1	1	localException1	Exception
    //   146	6	1	localObject1	Object
    //   157	1	1	localException2	Exception
    //   159	1	1	localException3	Exception
    //   27	111	2	localFileInputStream2	java.io.FileInputStream
    //   144	12	2	localObject2	Object
    //   163	1	2	localObject3	Object
    //   169	1	2	localObject4	Object
    //   94	27	3	localException4	Exception
    //   167	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	94	java/lang/Exception
    //   40	48	94	java/lang/Exception
    //   50	58	94	java/lang/Exception
    //   60	72	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   137	141	142	java/lang/Exception
    //   16	28	144	finally
    //   76	80	157	java/lang/Exception
    //   151	155	159	java/lang/Exception
    //   30	38	163	finally
    //   40	48	163	finally
    //   50	58	163	finally
    //   60	72	163	finally
    //   83	91	163	finally
    //   97	103	163	finally
    //   105	133	163	finally
    //   16	28	167	java/lang/Exception
  }
  
  public void h()
  {
    this.jdField_a_of_type_Tym = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a(this, 0, 0);
      }
    }
    while ((paramMessage.what != 2) || (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener == null)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayerListener.a();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\player\SilkPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */