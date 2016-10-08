package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Pair;
import fb.support.v4.util.Pools.SynchronizedPool;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public final class BitmapUtil
{
  public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
  public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
  public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
  private static final FbSynchronizedPool<ByteBuffer> DECODE_BUFFERS = new FbSynchronizedPool(12);
  private static final int DECODE_BUFFER_SIZE = 16384;
  public static final float MAX_BITMAP_SIZE = 2048.0F;
  private static final int POOL_SIZE = 12;
  public static final int RGB_565_BYTES_PER_PIXEL = 2;
  
  /* Error */
  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 75	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: getstatic 64	com/facebook/imageutils/BitmapUtil:DECODE_BUFFERS	Lcom/facebook/imageutils/BitmapUtil$FbSynchronizedPool;
    //   10: invokevirtual 79	com/facebook/imageutils/BitmapUtil$FbSynchronizedPool:acquire	()Ljava/lang/Object;
    //   13: checkcast 81	java/nio/ByteBuffer
    //   16: astore_3
    //   17: aload_3
    //   18: astore_1
    //   19: aload_3
    //   20: ifnonnull +10 -> 30
    //   23: sipush 16384
    //   26: invokestatic 85	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   29: astore_1
    //   30: new 87	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 88	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: iconst_1
    //   40: putfield 92	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual 96	java/nio/ByteBuffer:array	()[B
    //   48: putfield 100	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   51: aload_0
    //   52: aconst_null
    //   53: aload_3
    //   54: invokestatic 106	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aload_2
    //   59: astore_0
    //   60: aload_3
    //   61: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   64: iconst_m1
    //   65: if_icmpeq +17 -> 82
    //   68: aload_3
    //   69: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   72: istore 4
    //   74: iload 4
    //   76: iconst_m1
    //   77: if_icmpne +15 -> 92
    //   80: aload_2
    //   81: astore_0
    //   82: getstatic 64	com/facebook/imageutils/BitmapUtil:DECODE_BUFFERS	Lcom/facebook/imageutils/BitmapUtil$FbSynchronizedPool;
    //   85: aload_1
    //   86: invokevirtual 116	com/facebook/imageutils/BitmapUtil$FbSynchronizedPool:release	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: aload_0
    //   91: areturn
    //   92: new 118	android/util/Pair
    //   95: dup
    //   96: aload_3
    //   97: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   100: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aload_3
    //   104: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   107: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokespecial 127	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   113: astore_0
    //   114: goto -32 -> 82
    //   117: astore_0
    //   118: getstatic 64	com/facebook/imageutils/BitmapUtil:DECODE_BUFFERS	Lcom/facebook/imageutils/BitmapUtil$FbSynchronizedPool;
    //   121: aload_1
    //   122: invokevirtual 116	com/facebook/imageutils/BitmapUtil$FbSynchronizedPool:release	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramInputStream	java.io.InputStream
    //   18	104	1	localObject1	Object
    //   1	80	2	localObject2	Object
    //   16	88	3	localObject3	Object
    //   72	6	4	i	int
    // Exception table:
    //   from	to	target	type
    //   43	58	117	finally
    //   60	74	117	finally
    //   92	114	117	finally
  }
  
  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(byte[] paramArrayOfByte)
  {
    return decodeDimensions(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static int getPixelSizeForBitmapConfig(Bitmap.Config paramConfig)
  {
    int i = 2;
    switch (paramConfig)
    {
    default: 
      throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    case ARGB_8888: 
      i = 4;
    case ARGB_4444: 
    case RGB_565: 
      return i;
    }
    return 1;
  }
  
  public static int getSizeInByteForBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * getPixelSizeForBitmapConfig(paramConfig);
  }
  
  @SuppressLint({"NewApi"})
  public static int getSizeInBytes(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {
      try
      {
        int i = Integer.parseInt(String.valueOf(Bitmap.class.getDeclaredMethod("getAllocationByteCount", new Class[0]).invoke(paramBitmap, new Object[0])));
        return i;
      }
      catch (Exception paramBitmap)
      {
        paramBitmap.printStackTrace();
        return 0;
      }
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getWidth() * paramBitmap.getRowBytes();
  }
  
  public static void onDestroy()
  {
    try
    {
      DECODE_BUFFERS.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static class FbSynchronizedPool<T>
    extends Pools.SynchronizedPool<T>
  {
    public FbSynchronizedPool(int paramInt)
    {
      super();
    }
    
    public void onDestroy()
    {
      while (acquire() != null) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imageutils\BitmapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */