package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GiftBitmapAnimaionCache
{
  public static final int a = 10;
  public static final String a;
  public static final int b = 5;
  public static final int c = 300;
  private long jdField_a_of_type_Long = 100L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public LruCache a;
  public List a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private int d = -1;
  private int e;
  private int f;
  private int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GiftBitmapAnimaionCache.class.getName();
  }
  
  public GiftBitmapAnimaionCache()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(4096);
  }
  
  public Bitmap a()
  {
    int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);
    int j = this.d;
    this.d = ((int)(i / this.jdField_a_of_type_Long));
    if (this.d < j) {
      this.d = j;
    }
    if (this.d >= this.jdField_a_of_type_JavaUtilList.size())
    {
      this.d = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_a_of_type_Boolean = true;
      if (this.c) {
        return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaUtilList.get(this.d));
      }
      return null;
    }
    Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaUtilList.get(this.d));
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaUtilList.get(this.e));
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        this.d = this.e;
        localBitmap1 = localBitmap2;
      }
    }
    if ((this.d != j) && (this.d - j != 1)) {
      this.f += 1;
    }
    if (localBitmap1 != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "current i:" + this.d + ",time:" + i);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: getfield 68	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield 68	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   17: invokestatic 132	java/util/Collections:sort	(Ljava/util/List;)V
    //   20: iconst_0
    //   21: istore 4
    //   23: iload 4
    //   25: aload_0
    //   26: getfield 68	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   29: invokeinterface 74 1 0
    //   34: if_icmpge -22 -> 12
    //   37: aload_0
    //   38: getfield 134	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_b_of_type_Boolean	Z
    //   41: ifne -29 -> 12
    //   44: aload_0
    //   45: getfield 68	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   48: iload 4
    //   50: invokeinterface 82 2 0
    //   55: checkcast 136	java/lang/String
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +113 -> 173
    //   63: new 138	android/graphics/BitmapFactory$Options
    //   66: dup
    //   67: invokespecial 139	android/graphics/BitmapFactory$Options:<init>	()V
    //   70: astore_2
    //   71: aload_2
    //   72: getstatic 145	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   75: putfield 148	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   78: aload_1
    //   79: aload_2
    //   80: invokestatic 154	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 51	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   88: invokevirtual 155	android/support/v4/util/LruCache:size	()I
    //   91: iconst_5
    //   92: if_icmple +65 -> 157
    //   95: iload 4
    //   97: iconst_5
    //   98: isub
    //   99: istore 5
    //   101: iload 5
    //   103: iflt +54 -> 157
    //   106: iload 5
    //   108: aload_0
    //   109: getfield 68	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   112: invokeinterface 74 1 0
    //   117: if_icmpge +40 -> 157
    //   120: aload_0
    //   121: getfield 51	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   124: aload_0
    //   125: getfield 68	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   128: iload 5
    //   130: invokeinterface 82 2 0
    //   135: invokevirtual 158	android/support/v4/util/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 87	android/graphics/Bitmap
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +14 -> 157
    //   146: aload_3
    //   147: invokevirtual 161	android/graphics/Bitmap:isRecycled	()Z
    //   150: ifne +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 164	android/graphics/Bitmap:recycle	()V
    //   157: aload_0
    //   158: getfield 51	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   161: aload_1
    //   162: aload_2
    //   163: invokevirtual 168	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: pop
    //   167: aload_0
    //   168: iload 4
    //   170: putfield 89	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:e	I
    //   173: aload_0
    //   174: iload 4
    //   176: putfield 89	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:e	I
    //   179: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   182: lload 6
    //   184: lsub
    //   185: lstore 8
    //   187: invokestatic 99	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   190: ifeq +52 -> 242
    //   193: getstatic 38	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   196: iconst_4
    //   197: new 101	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   204: ldc -86
    //   206: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload 4
    //   211: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: ldc 113
    //   216: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lload 8
    //   221: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: ldc -81
    //   226: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 55	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_Long	J
    //   233: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: lload 8
    //   244: iload 4
    //   246: iconst_1
    //   247: iadd
    //   248: i2l
    //   249: aload_0
    //   250: getfield 55	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_Long	J
    //   253: lmul
    //   254: lcmp
    //   255: ifge +115 -> 370
    //   258: iload 4
    //   260: aload_0
    //   261: getfield 57	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:d	I
    //   264: if_icmple +23 -> 287
    //   267: iload 4
    //   269: iconst_1
    //   270: iadd
    //   271: i2l
    //   272: lstore 10
    //   274: lload 10
    //   276: aload_0
    //   277: getfield 55	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_Long	J
    //   280: lmul
    //   281: lload 8
    //   283: lsub
    //   284: invokestatic 181	java/lang/Thread:sleep	(J)V
    //   287: iload 4
    //   289: iconst_1
    //   290: iadd
    //   291: istore 4
    //   293: goto -270 -> 23
    //   296: astore_1
    //   297: aload_0
    //   298: iconst_1
    //   299: putfield 183	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:g	I
    //   302: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq -126 -> 179
    //   308: getstatic 38	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: iconst_2
    //   312: new 101	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   319: ldc -68
    //   321: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 4
    //   326: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: goto -156 -> 179
    //   338: astore_1
    //   339: aload_0
    //   340: iconst_2
    //   341: putfield 183	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:g	I
    //   344: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -168 -> 179
    //   350: getstatic 38	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   353: iconst_2
    //   354: ldc -64
    //   356: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: goto -180 -> 179
    //   362: astore_1
    //   363: aload_1
    //   364: invokevirtual 195	java/lang/InterruptedException:printStackTrace	()V
    //   367: goto -80 -> 287
    //   370: aload_0
    //   371: getfield 57	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:d	I
    //   374: aload_0
    //   375: getfield 89	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:e	I
    //   378: iconst_1
    //   379: isub
    //   380: if_icmplt -93 -> 287
    //   383: aload_0
    //   384: getfield 55	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_Long	J
    //   387: ldc2_w 196
    //   390: lcmp
    //   391: ifge -104 -> 287
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 55	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_Long	J
    //   399: l2d
    //   400: ldc2_w 198
    //   403: dmul
    //   404: d2l
    //   405: putfield 55	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:jdField_a_of_type_Long	J
    //   408: goto -121 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	GiftBitmapAnimaionCache
    //   58	104	1	str	String
    //   296	1	1	localOutOfMemoryError	OutOfMemoryError
    //   338	1	1	localThrowable	Throwable
    //   362	2	1	localInterruptedException	InterruptedException
    //   70	93	2	localObject	Object
    //   141	13	3	localBitmap	Bitmap
    //   21	304	4	i	int
    //   99	30	5	j	int
    //   3	180	6	l1	long
    //   185	97	8	l2	long
    //   272	3	10	l3	long
    // Exception table:
    //   from	to	target	type
    //   44	59	296	java/lang/OutOfMemoryError
    //   63	95	296	java/lang/OutOfMemoryError
    //   106	142	296	java/lang/OutOfMemoryError
    //   146	157	296	java/lang/OutOfMemoryError
    //   157	173	296	java/lang/OutOfMemoryError
    //   173	179	296	java/lang/OutOfMemoryError
    //   44	59	338	java/lang/Throwable
    //   63	95	338	java/lang/Throwable
    //   106	142	338	java/lang/Throwable
    //   146	157	338	java/lang/Throwable
    //   157	173	338	java/lang/Throwable
    //   173	179	338	java/lang/Throwable
    //   274	287	362	java/lang/InterruptedException
  }
  
  public void a(List paramList, Handler paramHandler, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = false;
    this.d = -1;
    this.e = 0;
    this.jdField_a_of_type_Long = 100L;
    this.g = 0;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidOsHandler != null);
  }
  
  public int[] a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_ArrayOfInt[0] = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfInt;
      Object localObject = (String)this.jdField_a_of_type_JavaUtilList.get(0);
      if (localObject != null)
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        try
        {
          localObject = BitmapFactory.decodeFile((String)localObject, localOptions);
          if (localObject != null)
          {
            this.jdField_a_of_type_ArrayOfInt[0] = ((Bitmap)localObject).getWidth();
            this.jdField_a_of_type_ArrayOfInt[1] = ((Bitmap)localObject).getHeight();
            ((Bitmap)localObject).recycle();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    }
  }
  
  public void b()
  {
    this.d = 0;
    this.f = 0;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaUtilList.get(this.d)));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      ReportController.b(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "drop_frame", 0, this.f, String.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_b_of_type_JavaLangString, "", "");
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaUtilList.get(i));
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          localBitmap.recycle();
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaUtilList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public void d()
  {
    if (a())
    {
      this.jdField_b_of_type_Boolean = true;
      c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopgift\GiftBitmapAnimaionCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */