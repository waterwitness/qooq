package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class VipPngPlayAnimationDrawable
  extends Drawable
  implements Runnable
{
  static final int jdField_a_of_type_Int = -1;
  private static final String jdField_a_of_type_JavaLangString = "VipPngPlayAnimationDrawable";
  static final int b = 50;
  public static final int c = 101;
  public static final int d = 102;
  public static final int e = 103;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public Resources a;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  public VipPngPlayAnimationDrawable.DecodeNextFrameTask a;
  public Object a;
  public boolean a;
  public Bitmap b;
  public boolean b;
  public boolean c;
  public boolean d;
  public int i;
  public int j;
  public int k;
  public int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public VipPngPlayAnimationDrawable(Resources paramResources)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = -1;
    this.m = -1;
    this.j = -1;
    this.k = 50;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.n - 1)
    {
      this.l -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, paramInt1, (BitmapFactory.Options)localObject);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    if (((String)paramObject).startsWith("file:///android_assets/bubbles/"))
    {
      paramObject = ((String)paramObject).substring("file:///android_assets/".length());
      paramObject = new BufferedInputStream(this.jdField_a_of_type_AndroidContentResResources.getAssets().open((String)paramObject));
    }
    for (;;)
    {
      localObject = BitmapFactory.decodeStream((InputStream)paramObject, null, (BitmapFactory.Options)localObject);
      if (paramObject != null) {}
      try
      {
        ((InputStream)paramObject).close();
        return (Bitmap)localObject;
        paramObject = new BufferedInputStream(new FileInputStream((String)paramObject));
      }
      catch (IOException paramObject)
      {
        for (;;)
        {
          ((IOException)paramObject).printStackTrace();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask = null;
    }
    this.i = -1;
    this.jdField_a_of_type_Boolean = true;
    this.j = -1;
    this.k = 50;
    this.l = -1;
    this.d = true;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.l = paramInt2;
    this.d = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      super.invalidateSelf();
    }
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    a(paramArrayOfString, paramInt, true);
  }
  
  /* Error */
  public void a(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:i	I
    //   4: ifne +21 -> 25
    //   7: aload_0
    //   8: getfield 210	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   11: checkcast 111	[Ljava/lang/String;
    //   14: checkcast 111	[Ljava/lang/String;
    //   17: aload_1
    //   18: invokestatic 216	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   21: ifeq +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: invokevirtual 218	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:a	()V
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 54	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:i	I
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 210	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   39: new 100	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 101	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 4
    //   48: aload 4
    //   50: iconst_1
    //   51: putfield 221	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_1
    //   55: iconst_0
    //   56: aaload
    //   57: astore 5
    //   59: aload 5
    //   61: ldc -126
    //   63: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +150 -> 216
    //   69: aload 5
    //   71: ldc -118
    //   73: invokevirtual 142	java/lang/String:length	()I
    //   76: invokevirtual 146	java/lang/String:substring	(I)Ljava/lang/String;
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 89	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:jdField_a_of_type_AndroidContentResResources	Landroid/content/res/Resources;
    //   85: invokevirtual 152	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   88: aload 5
    //   90: invokevirtual 158	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   93: astore 5
    //   95: aload 5
    //   97: aconst_null
    //   98: aload 4
    //   100: invokestatic 165	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   103: pop
    //   104: aload 5
    //   106: ifnull +8 -> 114
    //   109: aload 5
    //   111: invokevirtual 170	java/io/InputStream:close	()V
    //   114: iload_3
    //   115: ifeq +53 -> 168
    //   118: aload_0
    //   119: aload 4
    //   121: getfield 224	android/graphics/BitmapFactory$Options:outWidth	I
    //   124: sipush 320
    //   127: aload_0
    //   128: getfield 89	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:jdField_a_of_type_AndroidContentResResources	Landroid/content/res/Resources;
    //   131: invokevirtual 120	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   134: getfield 125	android/util/DisplayMetrics:densityDpi	I
    //   137: invokestatic 229	com/tencent/mobileqq/util/Utils:a	(III)I
    //   140: putfield 231	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:o	I
    //   143: aload_0
    //   144: aload 4
    //   146: getfield 234	android/graphics/BitmapFactory$Options:outHeight	I
    //   149: sipush 320
    //   152: aload_0
    //   153: getfield 89	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:jdField_a_of_type_AndroidContentResResources	Landroid/content/res/Resources;
    //   156: invokevirtual 120	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   159: getfield 125	android/util/DisplayMetrics:densityDpi	I
    //   162: invokestatic 229	com/tencent/mobileqq/util/Utils:a	(III)I
    //   165: putfield 236	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:p	I
    //   168: aload_0
    //   169: aload_1
    //   170: arraylength
    //   171: putfield 93	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:n	I
    //   174: aload_0
    //   175: iload_2
    //   176: putfield 60	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:k	I
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 197	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:d	Z
    //   184: return
    //   185: astore_1
    //   186: invokestatic 242	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 12
    //   194: iconst_4
    //   195: ldc -12
    //   197: aload_1
    //   198: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: invokevirtual 218	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:a	()V
    //   205: return
    //   206: astore 5
    //   208: aload 5
    //   210: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   213: goto -99 -> 114
    //   216: new 148	java/io/BufferedInputStream
    //   219: dup
    //   220: new 172	java/io/FileInputStream
    //   223: dup
    //   224: aload_1
    //   225: iconst_0
    //   226: aaload
    //   227: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   230: invokespecial 161	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   233: aconst_null
    //   234: aload 4
    //   236: invokestatic 165	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   239: pop
    //   240: goto -126 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	VipPngPlayAnimationDrawable
    //   0	243	1	paramArrayOfString	String[]
    //   0	243	2	paramInt	int
    //   0	243	3	paramBoolean	boolean
    //   46	189	4	localOptions	BitmapFactory.Options
    //   57	53	5	localObject	Object
    //   206	3	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   25	54	185	java/io/IOException
    //   59	104	185	java/io/IOException
    //   118	168	185	java/io/IOException
    //   168	184	185	java/io/IOException
    //   208	213	185	java/io/IOException
    //   216	240	185	java/io/IOException
    //   109	114	206	java/io/IOException
  }
  
  public boolean a()
  {
    return (!this.d) && (this.j >= 0);
  }
  
  protected void b()
  {
    if ((this.i == 1) && (this.j >= 0)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.k);
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.k;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask = new VipPngPlayAnimationDrawable.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.j), Long.valueOf(this.i) });
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.i == -1) {
      return;
    }
    if (this.j != -1)
    {
      Rect localRect = super.getBounds();
      int i1 = 0;
      if (this.c)
      {
        i1 = paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      if (this.i != 1) {
        break label109;
      }
      if (this.c) {
        paramCanvas.restoreToCount(i1);
      }
    }
    if (this.l == 0)
    {
      if ((102 == this.m) || (103 == this.m)) {}
      for (;;)
      {
        super.invalidateSelf();
        this.d = true;
        return;
        label109:
        if (((this.i != 0) && (this.i != 2)) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsPaint == null)) {
          break;
        }
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, super.getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        break;
        a();
      }
    }
    b();
  }
  
  public int getIntrinsicHeight()
  {
    return this.p;
  }
  
  public int getIntrinsicWidth()
  {
    return this.o;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      this.j = a(this.j);
    } while ((this.i == -1) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == this.jdField_b_of_type_AndroidGraphicsBitmap));
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    super.invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\VipPngPlayAnimationDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */