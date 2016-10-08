package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import quh;
import qui;
import quj;
import quk;
import qun;

public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  private static final String jdField_a_of_type_JavaLangString;
  public static final Executor a;
  private static volatile quk jdField_a_of_type_Quk = new quk(null);
  private static final int jdField_f_of_type_Int = 0;
  private static final int jdField_g_of_type_Int = 2;
  private static final int h = 1;
  protected int a;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private QQAnimationDrawable.QQAnimationListener jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private FutureTask jdField_a_of_type_JavaUtilConcurrentFutureTask;
  public final quj a;
  private qun jdField_a_of_type_Qun;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int = 160;
  public Bitmap b;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private int i = 2;
  private int j;
  private int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QQAnimationDrawable.class.getSimpleName();
    jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor(new quh());
  }
  
  public QQAnimationDrawable(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQAnimationDrawable(Context paramContext, QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    this.jdField_a_of_type_Int = -1;
    this.f = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Quj = new quj(this);
    this.jdField_b_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_Int = m;
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener = paramQQAnimationListener;
      d();
      return;
      m = this.jdField_b_of_type_Int;
    }
  }
  
  /* Error */
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 169	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   9: ifnull +198 -> 207
    //   12: aload_3
    //   13: astore 4
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 169	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   20: arraylength
    //   21: if_icmpge +186 -> 207
    //   24: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   27: lstore 7
    //   29: aload_0
    //   30: getfield 169	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: iload_2
    //   34: aaload
    //   35: astore 6
    //   37: aload_3
    //   38: astore 4
    //   40: aload 6
    //   42: ifnull +165 -> 207
    //   45: aload_0
    //   46: getfield 108	com/tencent/mobileqq/bubble/QQAnimationDrawable:f	Z
    //   49: ifeq +187 -> 236
    //   52: aload_0
    //   53: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   56: aload 6
    //   58: invokevirtual 179	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 181	java/lang/ref/SoftReference
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +24 -> 92
    //   71: aload 4
    //   73: invokevirtual 184	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 4
    //   81: invokevirtual 184	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 186	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: aload_0
    //   93: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   96: iconst_0
    //   97: putfield 189	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   100: aload_0
    //   101: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   104: iconst_1
    //   105: putfield 192	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   108: aload_0
    //   109: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   112: sipush 320
    //   115: putfield 195	android/graphics/BitmapFactory$Options:inDensity	I
    //   118: aload_0
    //   119: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   122: aload_0
    //   123: getfield 99	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   126: putfield 198	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   129: aload 6
    //   131: ldc -56
    //   133: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   136: ifeq +77 -> 213
    //   139: aload 6
    //   141: ldc -48
    //   143: invokevirtual 212	java/lang/String:length	()I
    //   146: invokevirtual 216	java/lang/String:substring	(I)Ljava/lang/String;
    //   149: astore 4
    //   151: aload_0
    //   152: getfield 129	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   155: invokevirtual 220	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   158: aload 4
    //   160: invokevirtual 226	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   163: astore 5
    //   165: aload 5
    //   167: new 228	android/graphics/Rect
    //   170: dup
    //   171: invokespecial 229	android/graphics/Rect:<init>	()V
    //   174: aload_0
    //   175: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   178: invokestatic 235	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   181: astore 5
    //   183: aload 5
    //   185: astore_3
    //   186: aload_0
    //   187: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   190: aload 4
    //   192: new 181	java/lang/ref/SoftReference
    //   195: dup
    //   196: aload_3
    //   197: invokespecial 238	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   200: invokevirtual 242	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload_3
    //   205: astore 4
    //   207: aload 4
    //   209: astore_3
    //   210: goto -122 -> 88
    //   213: new 244	java/io/FileInputStream
    //   216: dup
    //   217: aload 6
    //   219: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   222: astore 5
    //   224: aload 6
    //   226: astore 4
    //   228: goto -63 -> 165
    //   231: astore 4
    //   233: goto -29 -> 204
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   241: lload 7
    //   243: aload 6
    //   245: invokespecial 252	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JLjava/lang/String;)V
    //   248: aload_0
    //   249: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   252: astore 4
    //   254: goto -47 -> 207
    //   257: astore_3
    //   258: aload_0
    //   259: monitorexit
    //   260: aload_3
    //   261: athrow
    //   262: astore 4
    //   264: goto -60 -> 204
    //   267: astore 4
    //   269: goto -65 -> 204
    //   272: astore 4
    //   274: goto -70 -> 204
    //   277: astore 4
    //   279: goto -75 -> 204
    //   282: astore 4
    //   284: goto -80 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	QQAnimationDrawable
    //   0	287	1	paramBoolean	boolean
    //   0	287	2	paramInt	int
    //   0	287	3	paramBitmap	Bitmap
    //   3	224	4	localObject1	Object
    //   231	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   252	1	4	localBitmap	Bitmap
    //   262	1	4	localIOException1	java.io.IOException
    //   267	1	4	localIOException2	java.io.IOException
    //   272	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   277	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   282	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   163	60	5	localObject2	Object
    //   35	209	6	str	String
    //   27	215	7	l	long
    // Exception table:
    //   from	to	target	type
    //   92	165	231	java/lang/OutOfMemoryError
    //   165	183	231	java/lang/OutOfMemoryError
    //   213	224	231	java/lang/OutOfMemoryError
    //   5	12	257	finally
    //   15	37	257	finally
    //   45	66	257	finally
    //   71	88	257	finally
    //   92	165	257	finally
    //   165	183	257	finally
    //   186	204	257	finally
    //   213	224	257	finally
    //   236	254	257	finally
    //   92	165	262	java/io/IOException
    //   165	183	262	java/io/IOException
    //   213	224	262	java/io/IOException
    //   186	204	267	java/io/IOException
    //   92	165	272	java/io/FileNotFoundException
    //   165	183	272	java/io/FileNotFoundException
    //   213	224	272	java/io/FileNotFoundException
    //   186	204	277	java/io/FileNotFoundException
    //   186	204	282	java/lang/OutOfMemoryError
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile OOM");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile " + paramString + " " + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth + "——" + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
      }
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile OOM");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m = this.jdField_a_of_type_Int + 1;
    if (m >= this.jdField_c_of_type_Int) {
      m = 0;
    }
    for (;;)
    {
      if (paramBoolean2) {
        unscheduleSelf(this);
      }
      int n;
      if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (m >= this.jdField_c_of_type_Int - 1))
      {
        n = 1;
        if ((n == 0) && (this.jdField_e_of_type_Boolean) && (paramBoolean3))
        {
          this.jdField_e_of_type_Boolean = false;
          if (!paramBoolean1) {
            break label158;
          }
        }
      }
      label158:
      for (long l = 0L;; l = SystemClock.uptimeMillis() + this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Qun = new qun(this, m, l);
        this.jdField_a_of_type_JavaUtilConcurrentFutureTask = new FutureTask(this.jdField_a_of_type_Qun);
        jdField_a_of_type_Quk.execute(this.jdField_a_of_type_JavaUtilConcurrentFutureTask);
        if (n != 0)
        {
          stop();
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener.a();
          }
        }
        return;
        n = 0;
        break;
      }
    }
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7: invokevirtual 369	java/util/ArrayList:size	()I
    //   10: if_icmpge +23 -> 33
    //   13: aload_0
    //   14: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 372	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 186	android/graphics/Bitmap
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +7 -> 33
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: areturn
    //   33: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   36: lstore 9
    //   38: aload_0
    //   39: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   42: iconst_1
    //   43: putfield 189	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload_0
    //   47: getfield 374	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   54: invokestatic 318	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aload_0
    //   59: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   62: getfield 262	android/graphics/BitmapFactory$Options:outWidth	I
    //   65: i2f
    //   66: aload_0
    //   67: getfield 376	com/tencent/mobileqq/bubble/QQAnimationDrawable:j	I
    //   70: i2f
    //   71: fconst_1
    //   72: fmul
    //   73: fdiv
    //   74: f2i
    //   75: istore 7
    //   77: aload_0
    //   78: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   81: getfield 265	android/graphics/BitmapFactory$Options:outHeight	I
    //   84: i2f
    //   85: aload_0
    //   86: getfield 378	com/tencent/mobileqq/bubble/QQAnimationDrawable:k	I
    //   89: i2f
    //   90: fconst_1
    //   91: fmul
    //   92: fdiv
    //   93: f2i
    //   94: istore 8
    //   96: aload_0
    //   97: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   100: iconst_0
    //   101: putfield 189	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   104: aload_0
    //   105: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   108: sipush 320
    //   111: putfield 195	android/graphics/BitmapFactory$Options:inDensity	I
    //   114: aload_0
    //   115: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   118: aload_0
    //   119: getfield 99	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   122: putfield 198	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   125: aload_0
    //   126: getfield 374	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   129: aload_0
    //   130: getfield 104	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   133: invokestatic 318	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   136: astore_3
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: aload_0
    //   143: getfield 378	com/tencent/mobileqq/bubble/QQAnimationDrawable:k	I
    //   146: if_icmpge +95 -> 241
    //   149: iconst_0
    //   150: istore 6
    //   152: iload 6
    //   154: aload_0
    //   155: getfield 376	com/tencent/mobileqq/bubble/QQAnimationDrawable:j	I
    //   158: if_icmpge +217 -> 375
    //   161: aload_3
    //   162: iload 6
    //   164: iload 7
    //   166: imul
    //   167: iload 5
    //   169: iload 8
    //   171: imul
    //   172: iload 7
    //   174: iload 8
    //   176: aconst_null
    //   177: iconst_1
    //   178: invokestatic 381	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   181: astore 4
    //   183: aload 4
    //   185: ifnull +181 -> 366
    //   188: invokestatic 289	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   191: ifeq +37 -> 228
    //   194: getstatic 56	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   197: iconst_4
    //   198: new 291	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 383
    //   208: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload 5
    //   213: bipush 8
    //   215: imul
    //   216: iload 6
    //   218: iadd
    //   219: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   232: aload 4
    //   234: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   237: pop
    //   238: goto +128 -> 366
    //   241: aload_3
    //   242: ifnull +14 -> 256
    //   245: aload_3
    //   246: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   249: ifne +7 -> 256
    //   252: aload_3
    //   253: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   256: aload_0
    //   257: aload_0
    //   258: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   261: invokevirtual 369	java/util/ArrayList:size	()I
    //   264: putfield 328	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   267: invokestatic 289	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   270: ifeq +35 -> 305
    //   273: getstatic 56	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   276: iconst_4
    //   277: new 291	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 395
    //   287: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   293: lload 9
    //   295: lsub
    //   296: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_0
    //   306: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   309: iload_2
    //   310: invokevirtual 372	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   313: checkcast 186	android/graphics/Bitmap
    //   316: astore_3
    //   317: goto -288 -> 29
    //   320: astore_3
    //   321: invokestatic 289	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   324: ifeq -19 -> 305
    //   327: getstatic 56	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: iconst_4
    //   331: aload_3
    //   332: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: goto -33 -> 305
    //   341: astore_3
    //   342: aload_0
    //   343: monitorexit
    //   344: aload_3
    //   345: athrow
    //   346: astore_3
    //   347: invokestatic 289	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   350: ifeq -45 -> 305
    //   353: getstatic 56	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   356: iconst_4
    //   357: ldc_w 314
    //   360: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: goto -58 -> 305
    //   366: iload 6
    //   368: iconst_1
    //   369: iadd
    //   370: istore 6
    //   372: goto -220 -> 152
    //   375: iload 5
    //   377: iconst_1
    //   378: iadd
    //   379: istore 5
    //   381: goto -241 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	QQAnimationDrawable
    //   0	384	1	paramBoolean	boolean
    //   0	384	2	paramInt	int
    //   24	293	3	localBitmap1	Bitmap
    //   320	12	3	localException	Exception
    //   341	4	3	localObject	Object
    //   346	1	3	localOutOfMemoryError	OutOfMemoryError
    //   181	52	4	localBitmap2	Bitmap
    //   138	242	5	m	int
    //   150	221	6	n	int
    //   75	98	7	i1	int
    //   94	81	8	i2	int
    //   36	258	9	l	long
    // Exception table:
    //   from	to	target	type
    //   33	137	320	java/lang/Exception
    //   140	149	320	java/lang/Exception
    //   152	183	320	java/lang/Exception
    //   188	228	320	java/lang/Exception
    //   228	238	320	java/lang/Exception
    //   245	256	320	java/lang/Exception
    //   256	305	320	java/lang/Exception
    //   2	25	341	finally
    //   33	137	341	finally
    //   140	149	341	finally
    //   152	183	341	finally
    //   188	228	341	finally
    //   228	238	341	finally
    //   245	256	341	finally
    //   256	305	341	finally
    //   305	317	341	finally
    //   321	338	341	finally
    //   347	363	341	finally
    //   33	137	346	java/lang/OutOfMemoryError
    //   140	149	346	java/lang/OutOfMemoryError
    //   152	183	346	java/lang/OutOfMemoryError
    //   188	228	346	java/lang/OutOfMemoryError
    //   228	238	346	java/lang/OutOfMemoryError
    //   245	256	346	java/lang/OutOfMemoryError
    //   256	305	346	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   9: ifnull +122 -> 131
    //   12: aload_3
    //   13: astore 4
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   20: arraylength
    //   21: if_icmpge +110 -> 131
    //   24: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   27: lstore 5
    //   29: aload_0
    //   30: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   33: iload_2
    //   34: iaload
    //   35: istore_2
    //   36: aload_3
    //   37: astore 4
    //   39: iload_2
    //   40: ifle +91 -> 131
    //   43: aload_0
    //   44: getfield 108	com/tencent/mobileqq/bubble/QQAnimationDrawable:f	Z
    //   47: ifeq +90 -> 137
    //   50: aload_0
    //   51: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: iload_2
    //   55: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 179	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 181	java/lang/ref/SoftReference
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +24 -> 92
    //   71: aload 4
    //   73: invokevirtual 184	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 4
    //   81: invokevirtual 184	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 186	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: aload_0
    //   93: getfield 129	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   96: invokevirtual 142	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   99: iload_2
    //   100: invokestatic 406	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   103: astore 4
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: iload_2
    //   113: invokestatic 408	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   116: new 181	java/lang/ref/SoftReference
    //   119: dup
    //   120: aload_3
    //   121: invokespecial 238	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   124: invokevirtual 242	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_3
    //   129: astore 4
    //   131: aload 4
    //   133: astore_3
    //   134: goto -46 -> 88
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   142: lload 5
    //   144: iload_2
    //   145: invokespecial 410	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JI)V
    //   148: aload_0
    //   149: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   152: astore 4
    //   154: goto -23 -> 131
    //   157: astore_3
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_3
    //   161: athrow
    //   162: astore 4
    //   164: goto -36 -> 128
    //   167: astore 4
    //   169: goto -41 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	QQAnimationDrawable
    //   0	172	1	paramBoolean	boolean
    //   0	172	2	paramInt	int
    //   0	172	3	paramBitmap	Bitmap
    //   3	150	4	localObject	Object
    //   162	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   167	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   27	116	5	l	long
    // Exception table:
    //   from	to	target	type
    //   5	12	157	finally
    //   15	36	157	finally
    //   43	66	157	finally
    //   71	88	157	finally
    //   92	105	157	finally
    //   108	128	157	finally
    //   137	154	157	finally
    //   92	105	162	java/lang/OutOfMemoryError
    //   108	128	167	java/lang/OutOfMemoryError
  }
  
  private void d()
  {
    jdField_a_of_type_Quk.execute(new qui(this));
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap a(boolean paramBoolean, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (this.i == 0) {
      localBitmap1 = a(paramBoolean, paramInt, null);
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      return localBitmap2;
      if (this.i == 2) {
        localBitmap1 = b(paramBoolean, paramInt, null);
      } else if (this.i == 1) {
        localBitmap1 = b(paramBoolean, paramInt);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, " reset");
    }
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int > 1) {
      b(false);
    }
    for (;;)
    {
      start();
      return;
      if (this.jdField_d_of_type_Int == 1) {
        b(true);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    c();
    b(1);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = true;
    b(paramBoolean);
    start();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramBoolean);
      return;
    }
    a(paramInt);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    b(2);
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfInt, paramArrayOfInt))
    {
      c();
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    }
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfInt.length;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(String[] paramArrayOfString)
  {
    b(0);
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfJavaLangString, paramArrayOfString))
    {
      c();
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void b()
  {
    if (jdField_a_of_type_Quk != null) {
      jdField_a_of_type_Quk.b();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentFutureTask != null) {
      this.jdField_a_of_type_JavaUtilConcurrentFutureTask.cancel(true);
    }
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 460	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 460	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   13: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 460	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   23: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   26: aload_0
    //   27: getfield 423	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   30: ifnull +29 -> 59
    //   33: aload_0
    //   34: getfield 423	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   37: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   40: ifne +19 -> 59
    //   43: aload_0
    //   44: getfield 127	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 423	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   54: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   63: ifnull +20 -> 83
    //   66: aload_0
    //   67: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   70: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +10 -> 83
    //   76: aload_0
    //   77: getfield 249	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   83: aload_0
    //   84: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   87: ifnull +65 -> 152
    //   90: aload_0
    //   91: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: invokevirtual 464	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   97: astore_1
    //   98: aload_1
    //   99: invokeinterface 469 1 0
    //   104: ifeq +41 -> 145
    //   107: aload_1
    //   108: invokeinterface 472 1 0
    //   113: checkcast 186	android/graphics/Bitmap
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull -20 -> 98
    //   121: aload_2
    //   122: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne -27 -> 98
    //   128: aload_2
    //   129: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   132: goto -34 -> 98
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: getfield 113	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: invokevirtual 475	java/util/ArrayList:clear	()V
    //   152: aload_0
    //   153: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   156: ifnull +84 -> 240
    //   159: aload_0
    //   160: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   163: invokevirtual 479	java/util/HashMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 482 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 469 1 0
    //   178: ifeq +55 -> 233
    //   181: aload_1
    //   182: invokeinterface 472 1 0
    //   187: checkcast 202	java/lang/String
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   195: aload_2
    //   196: invokevirtual 179	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 181	java/lang/ref/SoftReference
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -32 -> 172
    //   207: aload_2
    //   208: invokevirtual 184	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   211: checkcast 186	android/graphics/Bitmap
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull -44 -> 172
    //   219: aload_2
    //   220: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   223: ifne -51 -> 172
    //   226: aload_2
    //   227: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   230: goto -58 -> 172
    //   233: aload_0
    //   234: getfield 118	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   237: invokevirtual 483	java/util/HashMap:clear	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QQAnimationDrawable
    //   135	7	1	localObject2	Object
    //   171	11	1	localIterator	java.util.Iterator
    //   116	13	2	localBitmap	Bitmap
    //   140	4	2	localObject3	Object
    //   190	37	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	135	finally
    //   26	50	135	finally
    //   59	83	135	finally
    //   83	98	135	finally
    //   98	117	135	finally
    //   121	132	135	finally
    //   143	145	135	finally
    //   145	152	135	finally
    //   152	172	135	finally
    //   172	203	135	finally
    //   207	215	135	finally
    //   219	230	135	finally
    //   233	240	135	finally
    //   50	59	140	finally
    //   141	143	140	finally
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        a(false, false, true);
        return;
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledWidth(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Int > -1;
  }
  
  public void run()
  {
    if (!this.g) {
      return;
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener.b();
    }
    this.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2)) {
        d();
      }
      return bool;
    }
    unscheduleSelf(this);
    return bool;
  }
  
  public void start()
  {
    this.g = true;
    if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_a_of_type_Long <= 0L)) {}
    while (isRunning()) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    a(true, false, true);
  }
  
  public void stop()
  {
    this.g = false;
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Int = 1;
    }
    a();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Int = -1;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\QQAnimationDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */