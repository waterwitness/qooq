package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class BitmapCache
  implements ImageViewTouchBase.Recycler
{
  private final BitmapCache.Entry[] a;
  
  public BitmapCache(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new BitmapCache.Entry[paramInt];
    paramInt = 0;
    while (paramInt < this.a.length)
    {
      this.a[paramInt] = new BitmapCache.Entry();
      paramInt += 1;
    }
  }
  
  private BitmapCache.Entry a(int paramInt)
  {
    BitmapCache.Entry[] arrayOfEntry = this.a;
    int j = arrayOfEntry.length;
    int i = 0;
    while (i < j)
    {
      BitmapCache.Entry localEntry = arrayOfEntry[i];
      if (paramInt == localEntry.jdField_a_of_type_Int) {
        return localEntry;
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 32	com/tencent/mobileqq/widget/BitmapCache:a	(I)Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +12 -> 21
    //   12: aload_2
    //   13: getfield 35	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: areturn
    //   21: aconst_null
    //   22: astore_2
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	BitmapCache
    //   0	31	1	paramInt	int
    //   7	16	2	localObject1	Object
    //   26	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	26	finally
    //   12	17	26	finally
  }
  
  public void a()
  {
    try
    {
      BitmapCache.Entry[] arrayOfEntry = this.a;
      int j = arrayOfEntry.length;
      int i = 0;
      while (i < j)
      {
        BitmapCache.Entry localEntry = arrayOfEntry[i];
        if (localEntry.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          localEntry.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
        localEntry.a();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      try
      {
        localObject1 = a(paramInt);
        if (localObject1 != null) {
          return;
        }
        localObject1 = null;
        BitmapCache.Entry[] arrayOfEntry = this.a;
        int m = arrayOfEntry.length;
        j = 0;
        i = -1;
        if (j >= m) {
          break label136;
        }
        localObject2 = arrayOfEntry[j];
        if (((BitmapCache.Entry)localObject2).jdField_a_of_type_Int == -1)
        {
          if (localObject2 == null) {
            continue;
          }
          if (((BitmapCache.Entry)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null) {
            ((BitmapCache.Entry)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          }
          ((BitmapCache.Entry)localObject2).jdField_a_of_type_Int = paramInt;
          ((BitmapCache.Entry)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          continue;
        }
        k = Math.abs(paramInt - ((BitmapCache.Entry)localObject2).jdField_a_of_type_Int);
      }
      finally {}
      int k;
      if (k > i)
      {
        localObject1 = localObject2;
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
      }
      label136:
      Object localObject2 = localObject1;
    }
  }
  
  /* Error */
  public void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/mobileqq/widget/BitmapCache:a	[Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   6: astore_2
    //   7: aload_2
    //   8: arraylength
    //   9: istore 5
    //   11: iconst_0
    //   12: istore 4
    //   14: iload 4
    //   16: iload 5
    //   18: if_icmpge +38 -> 56
    //   21: aload_2
    //   22: iload 4
    //   24: aaload
    //   25: astore_3
    //   26: aload_3
    //   27: getfield 29	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_Int	I
    //   30: iconst_m1
    //   31: if_icmpeq +16 -> 47
    //   34: aload_3
    //   35: getfield 35	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   38: astore_3
    //   39: aload_3
    //   40: aload_1
    //   41: if_acmpne +6 -> 47
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: iload 4
    //   49: iconst_1
    //   50: iadd
    //   51: istore 4
    //   53: goto -39 -> 14
    //   56: aload_1
    //   57: invokevirtual 40	android/graphics/Bitmap:recycle	()V
    //   60: goto -16 -> 44
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	BitmapCache
    //   0	68	1	paramBitmap	Bitmap
    //   6	16	2	arrayOfEntry	BitmapCache.Entry[]
    //   25	15	3	localObject	Object
    //   12	40	4	i	int
    //   9	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   2	11	63	finally
    //   26	39	63	finally
    //   56	60	63	finally
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 32	com/tencent/mobileqq/widget/BitmapCache:a	(I)Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +9 -> 18
    //   12: iconst_1
    //   13: istore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_3
    //   20: goto -6 -> 14
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	BitmapCache
    //   0	28	1	paramInt	int
    //   7	2	2	localEntry	BitmapCache.Entry
    //   23	4	2	localObject	Object
    //   13	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	23	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\BitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */