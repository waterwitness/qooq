package com.tencent.mobileqq.magicface.drawable;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import taq;
import tar;

public class PngGifEngine
  implements IMessageHandler
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = PngGifEngine.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new taq(this);
  private tar jdField_a_of_type_Tar;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PngGifEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func PngGifEngine 【Constructor】");
    }
    this.jdField_a_of_type_AndroidOsHandler = PngFrameManager.a(this);
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 71	android/graphics/BitmapFactory$Options
    //   5: dup
    //   6: invokespecial 72	android/graphics/BitmapFactory$Options:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: sipush 320
    //   14: putfield 75	android/graphics/BitmapFactory$Options:inDensity	I
    //   17: aload_2
    //   18: invokestatic 80	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 84	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   24: invokevirtual 90	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   27: getfield 95	android/util/DisplayMetrics:densityDpi	I
    //   30: putfield 98	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   33: aload_2
    //   34: getfield 75	android/graphics/BitmapFactory$Options:inDensity	I
    //   37: aload_2
    //   38: getfield 98	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   41: if_icmpge +11 -> 52
    //   44: aload_2
    //   45: aload_2
    //   46: getfield 98	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   49: putfield 75	android/graphics/BitmapFactory$Options:inDensity	I
    //   52: new 100	java/io/BufferedInputStream
    //   55: dup
    //   56: new 102	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: invokespecial 108	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_1
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aconst_null
    //   72: aload_2
    //   73: invokestatic 114	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   76: astore_2
    //   77: aload_2
    //   78: astore_0
    //   79: aload_1
    //   80: ifnull +9 -> 89
    //   83: aload_1
    //   84: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   87: aload_2
    //   88: astore_0
    //   89: aload_0
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   96: aload_2
    //   97: areturn
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +16 -> 122
    //   109: aload_1
    //   110: astore_0
    //   111: getstatic 30	com/tencent/mobileqq/magicface/drawable/PngGifEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: iconst_2
    //   115: aload_2
    //   116: invokevirtual 123	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   119: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_3
    //   123: astore_0
    //   124: aload_1
    //   125: ifnull -36 -> 89
    //   128: aload_1
    //   129: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_2
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: astore_0
    //   146: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +16 -> 165
    //   152: aload_1
    //   153: astore_0
    //   154: getstatic 30	com/tencent/mobileqq/magicface/drawable/PngGifEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   157: iconst_2
    //   158: aload_2
    //   159: invokevirtual 124	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   162: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_3
    //   166: astore_0
    //   167: aload_1
    //   168: ifnull -79 -> 89
    //   171: aload_1
    //   172: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: ifnull +7 -> 195
    //   191: aload_0
    //   192: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   195: aload_1
    //   196: athrow
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   202: goto -7 -> 195
    //   205: astore_1
    //   206: goto -19 -> 187
    //   209: astore_2
    //   210: goto -66 -> 144
    //   213: astore_2
    //   214: goto -113 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString	String
    //   67	105	1	localBufferedInputStream	java.io.BufferedInputStream
    //   184	12	1	localObject1	Object
    //   205	1	1	localObject2	Object
    //   9	88	2	localObject3	Object
    //   98	18	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   141	18	2	localOutOfMemoryError1	OutOfMemoryError
    //   209	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   213	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	165	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   83	87	91	java/io/IOException
    //   52	68	98	java/io/FileNotFoundException
    //   128	132	134	java/io/IOException
    //   52	68	141	java/lang/OutOfMemoryError
    //   171	175	177	java/io/IOException
    //   52	68	184	finally
    //   191	195	197	java/io/IOException
    //   70	77	205	finally
    //   103	109	205	finally
    //   111	122	205	finally
    //   146	152	205	finally
    //   154	165	205	finally
    //   70	77	209	java/lang/OutOfMemoryError
    //   70	77	213	java/io/FileNotFoundException
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "";
    }
    if (this.jdField_a_of_type_Tar.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Tar.jdField_a_of_type_JavaLangString;
    }
    int i = this.b + 1;
    if (i >= this.jdField_a_of_type_Tar.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      tar localtar = this.jdField_a_of_type_Tar;
      localtar.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Tar.jdField_a_of_type_Int <= 0)
      {
        this.jdField_a_of_type_Boolean = true;
        return this.jdField_a_of_type_Tar.jdField_a_of_type_JavaLangString;
      }
      this.b = -1;
      i = this.b;
      return this.jdField_a_of_type_Tar.jdField_a_of_type_ArrayOfJavaLangString[(i + 1)];
    }
    return this.jdField_a_of_type_Tar.jdField_a_of_type_ArrayOfJavaLangString[i];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func PngGifEngine 【onDestroy】");
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Tar = null;
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Tar.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify != null) {
      this.jdField_a_of_type_Tar.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify.a((Bitmap)paramMessage.obj);
    }
    this.b += 1;
    ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Tar != null) {
      this.jdField_a_of_type_Tar.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(tar paramtar)
  {
    this.jdField_a_of_type_Tar = paramtar;
  }
  
  public boolean a()
  {
    return this.b > -1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func start.");
    }
    if (this.jdField_a_of_type_Tar == null) {
      throw new IllegalArgumentException("【PngGifEngine】 task is null.");
    }
    if (!a()) {
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\drawable\PngGifEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */