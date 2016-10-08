package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ValueAnimation;
import ttn;
import ttw;

public class HongBaoPendantHolder
  extends BaseAnimHolder
{
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 1;
  public long a;
  public Context a;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public View a;
  public Animation a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  BaseAnimHolder jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  public SaQianView a;
  public boolean a;
  public long b;
  BaseAnimHolder b;
  public int f;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  private int o;
  
  public HongBaoPendantHolder(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.j = 2;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
  }
  
  public RectF a()
  {
    float f1 = this.c / 2;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Int - f1, this.jdField_b_of_type_Int - f1, this.jdField_a_of_type_Int + this.c + f1, f1 + (this.jdField_b_of_type_Int + this.d));
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    super.a();
    e();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.d = paramInt;
    if (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_b_of_type_Int = (this.d + paramInt + this.o);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(this.jdField_a_of_type_Int + this.c / 2, this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.f = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493757);
    paramInt3 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493756);
    paramInt4 = this.c / 2;
    int i1 = paramInt2 / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840807);
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt4 + paramInt1 - i1, 0, paramInt2, paramInt3, paramView);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.n = this.f;
    this.m = (this.f + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.j = 1;
    a(paramLong);
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void a(boolean paramBoolean, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +280 -> 281
    //   4: aload_0
    //   5: new 168	android/graphics/drawable/BitmapDrawable
    //   8: dup
    //   9: aload_0
    //   10: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   16: aload_0
    //   17: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   20: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: ldc -87
    //   25: invokestatic 175	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   28: getstatic 181	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   31: iconst_1
    //   32: invokevirtual 187	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   35: invokespecial 190	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   38: putfield 191	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   41: aload_0
    //   42: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   45: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   48: ldc -63
    //   50: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   53: fstore_3
    //   54: fload_3
    //   55: f2i
    //   56: istore 9
    //   58: aload_0
    //   59: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   62: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   65: ldc -62
    //   67: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   70: f2i
    //   71: istore 14
    //   73: aload_0
    //   74: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   77: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   80: ldc -61
    //   82: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   85: f2i
    //   86: istore 11
    //   88: aload_0
    //   89: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   92: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   95: ldc -60
    //   97: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   100: f2i
    //   101: istore 10
    //   103: aload_0
    //   104: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   107: invokevirtual 69	android/view/View:getWidth	()I
    //   110: iload 14
    //   112: isub
    //   113: iload 11
    //   115: isub
    //   116: istore 11
    //   118: aload_2
    //   119: astore 6
    //   121: aload_2
    //   122: ifnonnull +17 -> 139
    //   125: aload_0
    //   126: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   129: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   132: ldc -59
    //   134: invokestatic 175	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   137: astore 6
    //   139: aload_0
    //   140: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   143: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   146: ldc -58
    //   148: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   151: fstore_3
    //   152: aload_0
    //   153: getfield 191	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   156: checkcast 168	android/graphics/drawable/BitmapDrawable
    //   159: invokevirtual 202	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   162: astore_2
    //   163: new 204	android/graphics/Canvas
    //   166: dup
    //   167: aload_2
    //   168: invokespecial 207	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   171: astore 7
    //   173: fload_3
    //   174: aload_2
    //   175: invokevirtual 208	android/graphics/Bitmap:getWidth	()I
    //   178: i2f
    //   179: fmul
    //   180: iload 14
    //   182: i2f
    //   183: fdiv
    //   184: fstore_3
    //   185: new 41	android/graphics/RectF
    //   188: dup
    //   189: invokespecial 42	android/graphics/RectF:<init>	()V
    //   192: astore 8
    //   194: aload_2
    //   195: invokevirtual 208	android/graphics/Bitmap:getWidth	()I
    //   198: i2f
    //   199: fload_3
    //   200: fsub
    //   201: fconst_2
    //   202: fdiv
    //   203: fstore 4
    //   205: aload_2
    //   206: invokevirtual 209	android/graphics/Bitmap:getHeight	()I
    //   209: i2f
    //   210: fload_3
    //   211: fsub
    //   212: aload_0
    //   213: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   216: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   219: ldc -46
    //   221: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   224: fsub
    //   225: fstore 5
    //   227: aload 8
    //   229: fload 4
    //   231: fload 5
    //   233: fload 4
    //   235: fload_3
    //   236: fadd
    //   237: fload_3
    //   238: fload 5
    //   240: fadd
    //   241: invokevirtual 91	android/graphics/RectF:set	(FFFF)V
    //   244: aload 7
    //   246: aload 6
    //   248: aconst_null
    //   249: aload 8
    //   251: aconst_null
    //   252: invokevirtual 214	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   255: aload_0
    //   256: iload 11
    //   258: iload 10
    //   260: iload 14
    //   262: iload 9
    //   264: aload_0
    //   265: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   268: invokevirtual 215	com/tencent/mobileqq/portal/HongBaoPendantHolder:a	(IIIILandroid/view/View;)V
    //   271: iload_1
    //   272: ifeq +85 -> 357
    //   275: aload_0
    //   276: aconst_null
    //   277: putfield 107	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   280: return
    //   281: aload_0
    //   282: new 168	android/graphics/drawable/BitmapDrawable
    //   285: dup
    //   286: aload_0
    //   287: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   290: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   293: aload_0
    //   294: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   297: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   300: ldc -40
    //   302: invokestatic 175	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   305: getstatic 181	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   308: iconst_1
    //   309: invokevirtual 187	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   312: invokespecial 190	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   315: putfield 191	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   318: aload_0
    //   319: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   322: invokevirtual 192	android/view/View:getResources	()Landroid/content/res/Resources;
    //   325: ldc -39
    //   327: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   330: fstore_3
    //   331: fload_3
    //   332: f2i
    //   333: istore 9
    //   335: goto -277 -> 58
    //   338: astore_2
    //   339: aload_2
    //   340: invokevirtual 220	java/lang/OutOfMemoryError:printStackTrace	()V
    //   343: return
    //   344: astore 6
    //   346: aload 6
    //   348: invokevirtual 220	java/lang/OutOfMemoryError:printStackTrace	()V
    //   351: aload_2
    //   352: astore 6
    //   354: goto -215 -> 139
    //   357: aload_0
    //   358: new 4	com/tencent/mobileqq/portal/BaseAnimHolder
    //   361: dup
    //   362: invokespecial 34	com/tencent/mobileqq/portal/BaseAnimHolder:<init>	()V
    //   365: putfield 107	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   368: aload_0
    //   369: aload_0
    //   370: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   373: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   376: ldc -35
    //   378: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   381: f2i
    //   382: putfield 109	com/tencent/mobileqq/portal/HongBaoPendantHolder:o	I
    //   385: aload_0
    //   386: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   389: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   392: ldc -34
    //   394: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   397: f2i
    //   398: istore 12
    //   400: aload_0
    //   401: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   404: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   407: ldc -33
    //   409: invokevirtual 131	android/content/res/Resources:getDimension	(I)F
    //   412: f2i
    //   413: istore 13
    //   415: iload 14
    //   417: iconst_2
    //   418: idiv
    //   419: istore 14
    //   421: iload 12
    //   423: iconst_2
    //   424: idiv
    //   425: istore 15
    //   427: aload_0
    //   428: getfield 109	com/tencent/mobileqq/portal/HongBaoPendantHolder:o	I
    //   431: istore 16
    //   433: aload_0
    //   434: getfield 107	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   437: aload_0
    //   438: getfield 58	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   441: invokevirtual 124	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   444: ldc -32
    //   446: invokevirtual 137	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   449: putfield 140	com/tencent/mobileqq/portal/BaseAnimHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   452: aload_0
    //   453: getfield 107	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   456: iload 14
    //   458: iload 11
    //   460: iadd
    //   461: iload 15
    //   463: isub
    //   464: iload 16
    //   466: iload 10
    //   468: iload 9
    //   470: iadd
    //   471: iadd
    //   472: iload 12
    //   474: iload 13
    //   476: aload_0
    //   477: getfield 50	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   480: invokevirtual 116	com/tencent/mobileqq/portal/BaseAnimHolder:a	(IIIILandroid/view/View;)V
    //   483: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	HongBaoPendantHolder
    //   0	484	1	paramBoolean	boolean
    //   0	484	2	paramBitmap	android.graphics.Bitmap
    //   53	279	3	f1	float
    //   203	31	4	f2	float
    //   225	14	5	f3	float
    //   119	128	6	localBitmap1	android.graphics.Bitmap
    //   344	3	6	localOutOfMemoryError	OutOfMemoryError
    //   352	1	6	localBitmap2	android.graphics.Bitmap
    //   171	74	7	localCanvas	Canvas
    //   192	58	8	localRectF	RectF
    //   56	415	9	i1	int
    //   101	370	10	i2	int
    //   86	375	11	i3	int
    //   398	75	12	i4	int
    //   413	62	13	i5	int
    //   71	390	14	i6	int
    //   425	39	15	i7	int
    //   431	41	16	i8	int
    // Exception table:
    //   from	to	target	type
    //   4	54	338	java/lang/OutOfMemoryError
    //   281	331	338	java/lang/OutOfMemoryError
    //   125	139	344	java/lang/OutOfMemoryError
  }
  
  public boolean a(Canvas paramCanvas)
  {
    b();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.l);
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.e != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.e = this.e;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.e != 0))
    {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.e = this.e;
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    boolean bool = super.a(paramCanvas);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramCanvas);
    paramCanvas.restore();
    return (this.jdField_a_of_type_Boolean) || (bool);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / (float)this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {}
    for (float f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f2);; f1 = f2)
    {
      float f3 = this.n;
      a((int)(f1 * (this.m - this.n) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.j)
      {
      case 2: 
      default: 
        e();
        return;
      case 1: 
        this.j = 3;
        c();
        return;
      }
      this.j = 2;
      return;
    }
  }
  
  public void c()
  {
    this.n = this.jdField_b_of_type_Int;
    this.m = this.f;
    this.j = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new ttn();
    a(1500L);
  }
  
  public void d()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.1F), new ttw(this));
    localValueAnimation.setDuration(200L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.j = 2;
    a(this.f);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\HongBaoPendantHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */