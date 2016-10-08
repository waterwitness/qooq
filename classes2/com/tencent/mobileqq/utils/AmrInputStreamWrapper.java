package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.PttComponentProcessor;
import java.io.PipedInputStream;

public final class AmrInputStreamWrapper
  extends PttComponentProcessor
{
  private static final String jdField_a_of_type_JavaLangString = "AmrInputStream";
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int c = 320;
  private static final int d = 160;
  private static final int h = 1;
  private int e;
  private int f;
  private int g;
  
  public AmrInputStreamWrapper(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.f = CreateEncoder();
    this.g = GsmAmrEncoderNew(this.f);
    GsmAmrEncoderInitialize(this.g);
  }
  
  public static native int CreateDecoder();
  
  public static native int CreateEncoder();
  
  public static native void GsmAmrDecoderCleanup(int paramInt1, int paramInt2);
  
  public static native int GsmAmrDecoderDecode(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4);
  
  public static native void GsmAmrDecoderDelete(int paramInt1, int paramInt2);
  
  public static native void GsmAmrDecoderInitialize(int paramInt);
  
  public static native int GsmAmrDecoderNew(int paramInt);
  
  public static native void GsmAmrEncoderCleanup(int paramInt1, int paramInt2);
  
  public static native void GsmAmrEncoderDelete(int paramInt1, int paramInt2);
  
  public static native int GsmAmrEncoderEncode(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, int paramInt4, byte[] paramArrayOfByte2, int paramInt5);
  
  public static native void GsmAmrEncoderInitialize(int paramInt);
  
  public static native int GsmAmrEncoderNew(int paramInt);
  
  public static int a()
  {
    return GsmAmrEncoderNew(CreateEncoder());
  }
  
  public static void a(Context paramContext)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    this.b = 320;
    this.jdField_a_of_type_ArrayOfByte = new byte[this.b];
    this.c = new byte['π'];
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData = new IPttProcessor.ProcessData(this.c, 0);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 93	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 93	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   11: invokevirtual 97	java/io/PipedInputStream:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 93	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   19: aload_0
    //   20: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   23: ifeq +14 -> 37
    //   26: aload_0
    //   27: getfield 45	com/tencent/mobileqq/utils/AmrInputStreamWrapper:f	I
    //   30: aload_0
    //   31: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   34: invokestatic 99	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(II)V
    //   37: aload_0
    //   38: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   41: ifeq +14 -> 55
    //   44: aload_0
    //   45: getfield 45	com/tencent/mobileqq/utils/AmrInputStreamWrapper:f	I
    //   48: aload_0
    //   49: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   52: invokestatic 101	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   74: ifeq +14 -> 88
    //   77: aload_0
    //   78: getfield 45	com/tencent/mobileqq/utils/AmrInputStreamWrapper:f	I
    //   81: aload_0
    //   82: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   85: invokestatic 101	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 93	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   109: aload_0
    //   110: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   113: ifeq +14 -> 127
    //   116: aload_0
    //   117: getfield 45	com/tencent/mobileqq/utils/AmrInputStreamWrapper:f	I
    //   120: aload_0
    //   121: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   124: invokestatic 99	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(II)V
    //   127: aload_0
    //   128: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   131: ifeq +14 -> 145
    //   134: aload_0
    //   135: getfield 45	com/tencent/mobileqq/utils/AmrInputStreamWrapper:f	I
    //   138: aload_0
    //   139: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   142: invokestatic 101	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: aload_0
    //   162: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   165: ifeq +14 -> 179
    //   168: aload_0
    //   169: getfield 45	com/tencent/mobileqq/utils/AmrInputStreamWrapper:f	I
    //   172: aload_0
    //   173: getfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   176: invokestatic 101	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 51	com/tencent/mobileqq/utils/AmrInputStreamWrapper:g	I
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	AmrInputStreamWrapper
    //   61	7	1	localObject1	Object
    //   69	25	1	localObject2	Object
    //   95	7	1	localObject3	Object
    //   103	48	1	localObject4	Object
    //   152	7	1	localObject5	Object
    //   160	25	1	localObject6	Object
    //   186	7	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   37	55	61	finally
    //   19	37	69	finally
    //   70	88	95	finally
    //   0	14	103	finally
    //   127	145	152	finally
    //   109	127	160	finally
    //   161	179	186	finally
  }
  
  protected void finalize()
  {
    if (this.g != 0) {}
    try
    {
      close();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.g == 0) || (this.f == 0)) {
      throw new IllegalStateException("not open");
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.b) == -1) {
      return -1;
    }
    this.e = GsmAmrEncoderEncode(this.f, this.g, 1, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0);
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, this.e);
    return this.e;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\AmrInputStreamWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */