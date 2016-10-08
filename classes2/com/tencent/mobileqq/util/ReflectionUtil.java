package com.tencent.mobileqq.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Paint;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.VersionUtils;

@Deprecated
public class ReflectionUtil
{
  public static final int a = 7;
  public static final int b = 6;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  
  public ReflectionUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(Context paramContext, MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getX(paramInt);
  }
  
  public static int a(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  public static int a(Context paramContext, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getPointerCount();
  }
  
  public static int a(Context paramContext, MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getPointerId(paramInt);
  }
  
  public static int a(View paramView)
  {
    if (VersionUtils.e()) {
      return paramView.getLayerType();
    }
    return -5;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 80	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 76	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: ldc 82
    //   21: aastore
    //   22: invokevirtual 86	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: aastore
    //   33: invokevirtual 92	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: ldc 98
    //   43: iconst_2
    //   44: anewarray 76	java/lang/Class
    //   47: dup
    //   48: iconst_0
    //   49: ldc 82
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   57: aastore
    //   58: invokevirtual 108	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: aload_0
    //   62: iconst_2
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: ldc 110
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: iconst_1
    //   74: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokevirtual 120	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 100	java/lang/Integer
    //   84: invokevirtual 123	java/lang/Integer:intValue	()I
    //   87: istore_2
    //   88: aload_0
    //   89: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   92: ldc 125
    //   94: invokevirtual 129	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   97: aconst_null
    //   98: invokevirtual 135	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   101: istore_3
    //   102: aload_0
    //   103: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   106: ldc -119
    //   108: invokevirtual 129	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   111: aconst_null
    //   112: invokevirtual 135	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   115: istore 4
    //   117: aload_0
    //   118: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: ldc -117
    //   123: invokevirtual 129	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   126: aconst_null
    //   127: invokevirtual 135	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   130: istore 5
    //   132: iload_2
    //   133: iload_3
    //   134: if_icmpeq +15 -> 149
    //   137: iload_2
    //   138: iload 4
    //   140: if_icmpeq +9 -> 149
    //   143: iload_2
    //   144: iload 5
    //   146: if_icmpne +21 -> 167
    //   149: iload_2
    //   150: bipush 90
    //   152: isub
    //   153: ireturn
    //   154: astore_0
    //   155: iconst_0
    //   156: istore_2
    //   157: aload_0
    //   158: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   161: iload_2
    //   162: ireturn
    //   163: astore_0
    //   164: goto -7 -> 157
    //   167: iload_2
    //   168: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   5	8	1	localClass	Class
    //   87	81	2	i	int
    //   101	34	3	j	int
    //   115	26	4	k	int
    //   130	17	5	m	int
    // Exception table:
    //   from	to	target	type
    //   0	6	154	java/lang/Exception
    //   12	88	154	java/lang/Exception
    //   88	132	163	java/lang/Exception
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    if (VersionUtils.e()) {
      paramView.setLayerType(paramInt, paramPaint);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static float b(Context paramContext, MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getY(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\ReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */