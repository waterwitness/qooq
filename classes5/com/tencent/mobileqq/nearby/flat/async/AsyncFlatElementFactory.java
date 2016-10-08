package com.tencent.mobileqq.nearby.flat.async;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AsyncFlatElementFactory
{
  static int jdField_a_of_type_Int;
  static HeadlessElementHost jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncHeadlessElementHost;
  
  private AsyncFlatElementFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static AsyncFlatElement a(android.content.Context paramContext, com.tencent.mobileqq.freshnews.data.FNDefaultItemData paramFNDefaultItemData, android.graphics.Bitmap paramBitmap, com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder paramFNDefaultItemBuilder)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 24	com/tencent/mobileqq/nearby/NearbyAppInterface:a	Lcom/tencent/mobileqq/nearby/flat/async/UIElementCache;
    //   6: astore 5
    //   8: aload 5
    //   10: aload_1
    //   11: getfield 30	com/tencent/mobileqq/freshnews/data/FNDefaultItemData:e	Ljava/lang/String;
    //   14: invokevirtual 36	com/tencent/mobileqq/nearby/flat/async/UIElementCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 38	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElement
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull +11 -> 35
    //   27: aload 4
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: getstatic 40	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElementFactory:jdField_a_of_type_Int	I
    //   38: ldc 41
    //   40: invokestatic 47	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   43: istore 6
    //   45: iconst_0
    //   46: iconst_0
    //   47: invokestatic 47	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   50: istore 7
    //   52: getstatic 49	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElementFactory:jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncHeadlessElementHost	Lcom/tencent/mobileqq/nearby/flat/async/HeadlessElementHost;
    //   55: ifnonnull +14 -> 69
    //   58: new 51	com/tencent/mobileqq/nearby/flat/async/HeadlessElementHost
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 54	com/tencent/mobileqq/nearby/flat/async/HeadlessElementHost:<init>	(Landroid/content/Context;)V
    //   66: putstatic 49	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElementFactory:jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncHeadlessElementHost	Lcom/tencent/mobileqq/nearby/flat/async/HeadlessElementHost;
    //   69: new 56	com/tencent/mobileqq/nearby/flat/widget/FreshElement
    //   72: dup
    //   73: getstatic 49	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElementFactory:jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncHeadlessElementHost	Lcom/tencent/mobileqq/nearby/flat/async/HeadlessElementHost;
    //   76: invokespecial 59	com/tencent/mobileqq/nearby/flat/widget/FreshElement:<init>	(Lcom/tencent/mobileqq/nearby/flat/canvas/UIElementHost;)V
    //   79: astore 4
    //   81: aload 4
    //   83: aload_0
    //   84: aload_1
    //   85: aload_2
    //   86: aload_3
    //   87: invokevirtual 62	com/tencent/mobileqq/nearby/flat/widget/FreshElement:a	(Landroid/content/Context;Lcom/tencent/mobileqq/freshnews/data/FNDefaultItemData;Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/freshnews/feed/FNDefaultItemBuilder;)V
    //   90: aload 4
    //   92: iload 6
    //   94: iload 7
    //   96: invokevirtual 65	com/tencent/mobileqq/nearby/flat/widget/FreshElement:a	(II)V
    //   99: aload 4
    //   101: iconst_0
    //   102: iconst_0
    //   103: aload 4
    //   105: invokevirtual 69	com/tencent/mobileqq/nearby/flat/widget/FreshElement:b	()I
    //   108: aload 4
    //   110: invokevirtual 72	com/tencent/mobileqq/nearby/flat/widget/FreshElement:c	()I
    //   113: invokevirtual 75	com/tencent/mobileqq/nearby/flat/widget/FreshElement:a	(IIII)V
    //   116: new 38	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElement
    //   119: dup
    //   120: aload 4
    //   122: invokespecial 78	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElement:<init>	(Lcom/tencent/mobileqq/nearby/flat/widget/FreshElement;)V
    //   125: astore_0
    //   126: aload 5
    //   128: aload_1
    //   129: getfield 30	com/tencent/mobileqq/freshnews/data/FNDefaultItemData:e	Ljava/lang/String;
    //   132: aload_0
    //   133: invokevirtual 82	com/tencent/mobileqq/nearby/flat/async/UIElementCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: goto -107 -> 30
    //   140: astore_0
    //   141: ldc 2
    //   143: monitorexit
    //   144: aload_0
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	android.content.Context
    //   0	146	1	paramFNDefaultItemData	com.tencent.mobileqq.freshnews.data.FNDefaultItemData
    //   0	146	2	paramBitmap	android.graphics.Bitmap
    //   0	146	3	paramFNDefaultItemBuilder	com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder
    //   20	101	4	localObject	Object
    //   6	121	5	localUIElementCache	UIElementCache
    //   43	50	6	i	int
    //   50	45	7	j	int
    // Exception table:
    //   from	to	target	type
    //   3	22	140	finally
    //   35	69	140	finally
    //   69	137	140	finally
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElementFactory:jdField_a_of_type_Int	I
    //   6: istore_2
    //   7: iload_2
    //   8: iload_1
    //   9: if_icmpne +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: iload_1
    //   17: putstatic 40	com/tencent/mobileqq/nearby/flat/async/AsyncFlatElementFactory:jdField_a_of_type_Int	I
    //   20: goto -8 -> 12
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	paramContext	android.content.Context
    //   0	29	1	paramInt	int
    //   6	4	2	i	int
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
    //   16	20	23	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\async\AsyncFlatElementFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */