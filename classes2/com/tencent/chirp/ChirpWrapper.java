package com.tencent.chirp;

import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ChirpWrapper
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "ChirpWrapper";
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = -2;
  private static final String jdField_b_of_type_JavaLangString = "libQChirp.so";
  private static final boolean jdField_b_of_type_Boolean = true;
  private int c;
  
  public ChirpWrapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    try
    {
      if (a) {
        return true;
      }
    }
    finally {}
    try
    {
      String str = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/chirp/" + "libQChirp.so";
      if (new File(str).exists())
      {
        System.load(str);
        a = true;
      }
      for (;;)
      {
        boolean bool = a;
        return bool;
        if (QLog.isColorLevel()) {
          QLog.d("ChirpWrapper", 2, "so not exist");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChirpWrapper", 2, "loadLibrary error", localException);
        }
        a = false;
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_1
    //   5: new 35	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   12: invokestatic 42	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: invokevirtual 48	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 54	java/io/File:getParent	()Ljava/lang/String;
    //   21: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 95
    //   26: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_0
    //   36: aload_2
    //   37: iconst_0
    //   38: invokestatic 100	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   41: ldc 2
    //   43: monitorexit
    //   44: iconst_1
    //   45: ireturn
    //   46: astore_0
    //   47: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +12 -> 62
    //   53: ldc 10
    //   55: iconst_2
    //   56: ldc 102
    //   58: aload_0
    //   59: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   62: new 50	java/io/File
    //   65: dup
    //   66: new 35	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   73: aload_1
    //   74: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 104
    //   79: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 16
    //   84: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 107	java/io/File:delete	()Z
    //   96: pop
    //   97: ldc 2
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    //   108: astore_0
    //   109: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -15 -> 97
    //   115: ldc 10
    //   117: iconst_2
    //   118: ldc 109
    //   120: aload_0
    //   121: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: goto -27 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   4	70	1	localObject	Object
    //   32	5	2	str	String
    // Exception table:
    //   from	to	target	type
    //   5	33	46	java/io/IOException
    //   35	41	46	java/io/IOException
    //   5	33	102	finally
    //   35	41	102	finally
    //   41	44	102	finally
    //   47	62	102	finally
    //   62	97	102	finally
    //   97	100	102	finally
    //   103	106	102	finally
    //   109	124	102	finally
    //   62	97	108	java/lang/Exception
  }
  
  private static native int createChirp();
  
  private static native int decodeChirp(int paramInt1, short[] paramArrayOfShort, int paramInt2);
  
  private static native int encodeChirp(int paramInt1, String paramString, int paramInt2);
  
  private static native int getAudioLength(int paramInt);
  
  private static native int getAudioSample(int paramInt1, short[] paramArrayOfShort, int paramInt2);
  
  private static native String getDecodeString(int paramInt);
  
  private static native int getDecodeStringLen(int paramInt);
  
  private static native int releaseChirp(int paramInt);
  
  public int a()
  {
    if (!a) {
      return -2;
    }
    try
    {
      this.c = createChirp();
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpWrapper", 2, "", localException);
      }
    }
    return -1;
  }
  
  public Pair a(String paramString)
  {
    if (!a) {
      return new Pair(Integer.valueOf(-2), null);
    }
    int i = encodeChirp(this.c, paramString, paramString.length());
    if (i != 0) {
      return new Pair(Integer.valueOf(i), null);
    }
    i = getAudioLength(this.c);
    paramString = new short[i];
    return new Pair(Integer.valueOf(getAudioSample(this.c, paramString, i)), paramString);
  }
  
  public String a(short[] paramArrayOfShort, int paramInt)
  {
    if (!a) {}
    while ((decodeChirp(this.c, paramArrayOfShort, paramArrayOfShort.length) != 0) || (getDecodeStringLen(this.c) != paramInt)) {
      return null;
    }
    return getDecodeString(this.c);
  }
  
  protected void finalize()
  {
    super.finalize();
    try
    {
      releaseChirp(this.c);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\chirp\ChirpWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */