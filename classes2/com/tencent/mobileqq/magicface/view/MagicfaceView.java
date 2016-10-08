package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MagicfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, IMagicFaceView
{
  private static final String jdField_a_of_type_JavaLangString = "MagicfaceView";
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private MagicfaceView.SurfaceCreateListener jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener;
  public volatile boolean a;
  private volatile boolean b;
  
  public MagicfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  /* Error */
  private void b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload 8
    //   11: astore 7
    //   13: aload_0
    //   14: invokevirtual 48	com/tencent/mobileqq/magicface/view/MagicfaceView:getWidth	()I
    //   17: i2f
    //   18: fstore 5
    //   20: aload 8
    //   22: astore 7
    //   24: aload_0
    //   25: invokevirtual 51	com/tencent/mobileqq/magicface/view/MagicfaceView:getHeight	()I
    //   28: i2f
    //   29: fstore 6
    //   31: aload 8
    //   33: astore 7
    //   35: aload_0
    //   36: getfield 35	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   39: aconst_null
    //   40: invokeinterface 55 2 0
    //   45: astore 8
    //   47: new 57	android/graphics/Paint
    //   50: dup
    //   51: invokespecial 59	android/graphics/Paint:<init>	()V
    //   54: astore 7
    //   56: aload 7
    //   58: new 61	android/graphics/PorterDuffXfermode
    //   61: dup
    //   62: getstatic 67	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   65: invokespecial 70	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   68: invokevirtual 74	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   71: pop
    //   72: aload 8
    //   74: aload 7
    //   76: invokevirtual 80	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   79: aload 7
    //   81: new 61	android/graphics/PorterDuffXfermode
    //   84: dup
    //   85: getstatic 83	android/graphics/PorterDuff$Mode:SRC	Landroid/graphics/PorterDuff$Mode;
    //   88: invokespecial 70	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   91: invokevirtual 74	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   94: pop
    //   95: aload 7
    //   97: iconst_1
    //   98: invokevirtual 87	android/graphics/Paint:setFilterBitmap	(Z)V
    //   101: aload 7
    //   103: iconst_1
    //   104: invokevirtual 90	android/graphics/Paint:setAntiAlias	(Z)V
    //   107: fload 5
    //   109: fload 6
    //   111: fcmpg
    //   112: ifge +91 -> 203
    //   115: fload 5
    //   117: iload_2
    //   118: i2f
    //   119: fdiv
    //   120: fstore 5
    //   122: fload 6
    //   124: iload_3
    //   125: i2f
    //   126: fdiv
    //   127: fstore 4
    //   129: iconst_0
    //   130: istore 10
    //   132: aload_0
    //   133: getfield 92	com/tencent/mobileqq/magicface/view/MagicfaceView:b	Z
    //   136: ifne +106 -> 242
    //   139: fload 6
    //   141: f2i
    //   142: iconst_2
    //   143: idiv
    //   144: iload_3
    //   145: i2f
    //   146: fload 5
    //   148: fmul
    //   149: fconst_2
    //   150: fdiv
    //   151: f2i
    //   152: isub
    //   153: i2f
    //   154: fload 5
    //   156: fdiv
    //   157: f2i
    //   158: istore 11
    //   160: aload 8
    //   162: fload 5
    //   164: fload 5
    //   166: invokevirtual 96	android/graphics/Canvas:scale	(FF)V
    //   169: aload 8
    //   171: aload_1
    //   172: iconst_0
    //   173: iload_2
    //   174: iload 10
    //   176: iload 11
    //   178: iload_2
    //   179: iload_3
    //   180: iconst_1
    //   181: aload 7
    //   183: invokevirtual 100	android/graphics/Canvas:drawBitmap	([IIIIIIIZLandroid/graphics/Paint;)V
    //   186: aload 8
    //   188: ifnull +14 -> 202
    //   191: aload_0
    //   192: getfield 35	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   195: aload 8
    //   197: invokeinterface 104 2 0
    //   202: return
    //   203: fload 6
    //   205: iload_3
    //   206: i2f
    //   207: fdiv
    //   208: fstore 4
    //   210: fload 5
    //   212: f2i
    //   213: istore 10
    //   215: iload 10
    //   217: iconst_2
    //   218: idiv
    //   219: iload_2
    //   220: i2f
    //   221: fload 4
    //   223: fmul
    //   224: fconst_2
    //   225: fdiv
    //   226: f2i
    //   227: isub
    //   228: i2f
    //   229: fload 4
    //   231: fdiv
    //   232: f2i
    //   233: istore 10
    //   235: fload 4
    //   237: fstore 5
    //   239: goto -107 -> 132
    //   242: aload 8
    //   244: fload 5
    //   246: fload 4
    //   248: invokevirtual 96	android/graphics/Canvas:scale	(FF)V
    //   251: goto -82 -> 169
    //   254: astore 7
    //   256: aload 8
    //   258: astore_1
    //   259: aload 7
    //   261: astore 8
    //   263: aload_1
    //   264: astore 7
    //   266: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +35 -> 304
    //   272: aload_1
    //   273: astore 7
    //   275: ldc 12
    //   277: iconst_2
    //   278: new 112	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   285: ldc 115
    //   287: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 8
    //   292: invokevirtual 123	java/lang/Exception:toString	()Ljava/lang/String;
    //   295: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload_1
    //   305: ifnull -103 -> 202
    //   308: aload_0
    //   309: getfield 35	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   312: aload_1
    //   313: invokeinterface 104 2 0
    //   318: return
    //   319: astore_1
    //   320: aload 7
    //   322: ifnull +14 -> 336
    //   325: aload_0
    //   326: getfield 35	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   329: aload 7
    //   331: invokeinterface 104 2 0
    //   336: aload_1
    //   337: athrow
    //   338: astore_1
    //   339: aload 8
    //   341: astore 7
    //   343: goto -23 -> 320
    //   346: astore 8
    //   348: aload 9
    //   350: astore_1
    //   351: goto -88 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	MagicfaceView
    //   0	354	1	paramArrayOfInt	int[]
    //   0	354	2	paramInt1	int
    //   0	354	3	paramInt2	int
    //   127	120	4	f1	float
    //   18	227	5	f2	float
    //   29	175	6	f3	float
    //   11	171	7	localObject1	Object
    //   254	6	7	localException1	Exception
    //   264	78	7	localObject2	Object
    //   1	339	8	localObject3	Object
    //   346	1	8	localException2	Exception
    //   4	345	9	localObject4	Object
    //   130	104	10	i	int
    //   7	170	11	j	int
    // Exception table:
    //   from	to	target	type
    //   47	107	254	java/lang/Exception
    //   115	129	254	java/lang/Exception
    //   132	169	254	java/lang/Exception
    //   169	186	254	java/lang/Exception
    //   215	235	254	java/lang/Exception
    //   242	251	254	java/lang/Exception
    //   13	20	319	finally
    //   24	31	319	finally
    //   35	47	319	finally
    //   266	272	319	finally
    //   275	304	319	finally
    //   47	107	338	finally
    //   115	129	338	finally
    //   132	169	338	finally
    //   169	186	338	finally
    //   215	235	338	finally
    //   242	251	338	finally
    //   13	20	346	java/lang/Exception
    //   24	31	346	java/lang/Exception
    //   35	47	346	java/lang/Exception
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    b(paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setSurfaceCreatelistener(MagicfaceView.SurfaceCreateListener paramSurfaceCreateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener = paramSurfaceCreateListener;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener.a();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\view\MagicfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */