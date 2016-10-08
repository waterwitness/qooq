package com.tencent.biz.qqstory.pgc.view;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Method;

public class FullScreenVideoHelper
{
  protected static final String a = "FullScreenVideoHelper";
  protected int a;
  protected View a;
  public FrameLayout a;
  protected FullScreenVideoHelper.OnPlayCompleteListener a;
  protected Method a;
  public boolean a;
  protected Method b;
  protected Method c;
  protected Method d;
  protected Method e;
  protected Method f;
  
  public FullScreenVideoHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int > 0) {
        return this.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
      try
      {
        int i = ((Integer)this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[0])).intValue();
        this.jdField_a_of_type_Int = i;
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.d.setAccessible(true);
    }
    try
    {
      this.d.invoke(this.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt >= 0)) {
      this.c.setAccessible(true);
    }
    try
    {
      this.c.invoke(this.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(FullScreenVideoHelper.OnPlayCompleteListener paramOnPlayCompleteListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewFullScreenVideoHelper$OnPlayCompleteListener = paramOnPlayCompleteListener;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.f.setAccessible(true);
      try
      {
        boolean bool = ((Boolean)this.f.invoke(this.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[0])).booleanValue();
        return bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace(System.out);
      }
    }
    return false;
  }
  
  /* Error */
  public boolean a(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 61	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 34	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_Boolean	Z
    //   10: aload_1
    //   11: instanceof 93
    //   14: ifeq +200 -> 214
    //   17: aload_1
    //   18: checkcast 93	android/widget/FrameLayout
    //   21: astore_1
    //   22: aload_0
    //   23: aload_1
    //   24: iconst_0
    //   25: invokevirtual 97	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   28: checkcast 93	android/widget/FrameLayout
    //   31: putfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   34: aload_0
    //   35: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   38: invokevirtual 101	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: astore_2
    //   42: iconst_1
    //   43: istore_3
    //   44: iload_3
    //   45: aload_0
    //   46: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   49: invokevirtual 104	android/widget/FrameLayout:getChildCount	()I
    //   52: if_icmpge +31 -> 83
    //   55: aload_0
    //   56: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   59: aload_0
    //   60: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   63: iload_3
    //   64: invokevirtual 97	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   67: invokevirtual 108	android/widget/FrameLayout:removeView	(Landroid/view/View;)V
    //   70: iload_3
    //   71: iconst_1
    //   72: iadd
    //   73: istore_3
    //   74: goto -30 -> 44
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 34	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_Boolean	Z
    //   82: ireturn
    //   83: aload_0
    //   84: aload_2
    //   85: ldc 110
    //   87: iconst_0
    //   88: anewarray 112	java/lang/Class
    //   91: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   94: putfield 38	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   97: aload_0
    //   98: aload_2
    //   99: ldc 118
    //   101: iconst_0
    //   102: anewarray 112	java/lang/Class
    //   105: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   108: putfield 120	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:b	Ljava/lang/reflect/Method;
    //   111: aload_0
    //   112: aload_2
    //   113: ldc 122
    //   115: iconst_1
    //   116: anewarray 112	java/lang/Class
    //   119: dup
    //   120: iconst_0
    //   121: getstatic 126	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   128: putfield 66	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:c	Ljava/lang/reflect/Method;
    //   131: aload_0
    //   132: aload_2
    //   133: ldc -128
    //   135: iconst_0
    //   136: anewarray 112	java/lang/Class
    //   139: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   142: putfield 63	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:d	Ljava/lang/reflect/Method;
    //   145: aload_0
    //   146: aload_2
    //   147: ldc -126
    //   149: iconst_0
    //   150: anewarray 112	java/lang/Class
    //   153: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   156: putfield 132	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:e	Ljava/lang/reflect/Method;
    //   159: aload_0
    //   160: aload_2
    //   161: ldc -122
    //   163: iconst_0
    //   164: anewarray 112	java/lang/Class
    //   167: invokevirtual 116	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   170: putfield 76	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:f	Ljava/lang/reflect/Method;
    //   173: aload_0
    //   174: iconst_1
    //   175: putfield 34	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_Boolean	Z
    //   178: aload_1
    //   179: aload_0
    //   180: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   183: invokevirtual 108	android/widget/FrameLayout:removeView	(Landroid/view/View;)V
    //   186: aload_0
    //   187: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   190: iconst_0
    //   191: invokevirtual 97	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   194: iconst_0
    //   195: invokevirtual 139	android/view/View:setEnabled	(Z)V
    //   198: aload_0
    //   199: getfield 46	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   202: new 141	img
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 144	img:<init>	(Lcom/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper;)V
    //   210: invokevirtual 148	android/widget/FrameLayout:post	(Ljava/lang/Runnable;)Z
    //   213: pop
    //   214: aload_0
    //   215: getfield 34	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_Boolean	Z
    //   218: ireturn
    //   219: astore_1
    //   220: aload_0
    //   221: iconst_0
    //   222: putfield 34	com/tencent/biz/qqstory/pgc/view/FullScreenVideoHelper:jdField_a_of_type_Boolean	Z
    //   225: goto -11 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	FullScreenVideoHelper
    //   0	228	1	paramView	View
    //   41	120	2	localClass	Class
    //   43	31	3	i	int
    // Exception table:
    //   from	to	target	type
    //   22	34	77	java/lang/Exception
    //   44	70	219	java/lang/Exception
    //   83	214	219	java/lang/Exception
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setAccessible(true);
      try
      {
        Integer localInteger = (Integer)this.b.invoke(this.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[0]);
        if ((localInteger.intValue() > 100) && (a() > 100) && (localInteger.intValue() + 100 > a()) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcViewFullScreenVideoHelper$OnPlayCompleteListener != null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryPgcViewFullScreenVideoHelper$OnPlayCompleteListener.a();
        }
        int i = localInteger.intValue();
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.e.setAccessible(true);
    }
    try
    {
      this.e.invoke(this.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\FullScreenVideoHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */