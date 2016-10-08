package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.LinkedList;
import vol;

public class RollangleImageView$ImageCache
{
  private static ImageCache jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  public static final String a = "troopfileimage://";
  private Handler jdField_a_of_type_AndroidOsHandler;
  public HashMap a;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  public boolean a;
  
  private RollangleImageView$ImageCache()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840399));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840362));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840363));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840349));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840425));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840424));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840343));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840382));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840350));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840380));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840392));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840398));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130840398));
      this.jdField_a_of_type_AndroidOsHandler = new vol(this, BaseApplication.getContext().getMainLooper());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
    }
  }
  
  public static ImageCache a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache == null) {
      jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache = new ImageCache();
    }
    return jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: ifnull -4 -> 11
    //   18: aload_0
    //   19: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   22: invokevirtual 102	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface 108 1 0
    //   32: ifeq -21 -> 11
    //   35: aload_2
    //   36: invokeinterface 112 1 0
    //   41: checkcast 114	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem
    //   44: astore_3
    //   45: aload_1
    //   46: aload_3
    //   47: getfield 116	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq -27 -> 26
    //   56: aload_0
    //   57: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   60: aload_3
    //   61: invokevirtual 125	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ImageCache
    //   0	73	1	paramString	String
    //   6	30	2	localObject	Object
    //   44	17	3	localQueueItem	RollangleImageView.ImageCache.QueueItem
    // Exception table:
    //   from	to	target	type
    //   2	7	68	finally
    //   18	26	68	finally
    //   26	65	68	finally
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject1 = FileUtil.a(paramString);
    if (localObject1 != null) {}
    for (int i = FileManagerUtil.a((String)localObject1);; i = -1)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      Object localObject2 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), FileManagerUtil.b(paramString));
        localObject1 = localObject2;
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localObject2);
        return (Bitmap)localObject2;
      }
      catch (OutOfMemoryError paramString)
      {
        return (Bitmap)localObject1;
      }
    }
  }
  
  public Bitmap a(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      paramString = (Bitmap)RollangleImageView.a.get("troopfileimage://" + paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   18: invokevirtual 166	java/util/LinkedList:clear	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ImageCache
    //   6	2	1	localLinkedList	LinkedList
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally {}
  }
  
  /* Error */
  public Bitmap b(String paramString, RollangleImageView paramRollangleImageView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 151	com/tencent/mobileqq/troop/utils/RollangleImageView:a	Landroid/support/v4/util/LruCache;
    //   5: new 153	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   12: ldc 9
    //   14: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 165	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 142	android/graphics/Bitmap
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   45: ifnonnull +14 -> 59
    //   48: aload_0
    //   49: new 98	java/util/LinkedList
    //   52: dup
    //   53: invokespecial 170	java/util/LinkedList:<init>	()V
    //   56: putfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   59: aload_0
    //   60: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   63: invokevirtual 173	java/util/LinkedList:isEmpty	()Z
    //   66: ifeq +17 -> 83
    //   69: new 175	vok
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 178	vok:<init>	(Lcom/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache;)V
    //   77: iconst_5
    //   78: aconst_null
    //   79: iconst_1
    //   80: invokestatic 183	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   83: new 114	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem
    //   86: dup
    //   87: invokespecial 184	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:<init>	()V
    //   90: astore_3
    //   91: aload_3
    //   92: aload_2
    //   93: putfield 187	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView	Lcom/tencent/mobileqq/troop/utils/RollangleImageView;
    //   96: aload_3
    //   97: aload_1
    //   98: putfield 116	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: aload_0
    //   102: getfield 95	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   105: aload_3
    //   106: invokevirtual 190	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: aconst_null
    //   111: astore_1
    //   112: goto -75 -> 37
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	ImageCache
    //   0	120	1	paramString	String
    //   0	120	2	paramRollangleImageView	RollangleImageView
    //   30	76	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	115	finally
    //   41	59	115	finally
    //   59	83	115	finally
    //   83	110	115	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\RollangleImageView$ImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */