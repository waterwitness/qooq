package cooperation.qqhotspot.hotspotnode;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HotSpotNodeCacheManager
{
  private static final int jdField_a_of_type_Int = 200;
  private static HotSpotNodeCacheManager jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeCacheManager;
  private static final int jdField_b_of_type_Int = 1000;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private List jdField_b_of_type_JavaUtilList;
  private List c;
  
  private HotSpotNodeCacheManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static HotSpotNodeCacheManager a()
  {
    if (jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeCacheManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeCacheManager == null) {
        jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeCacheManager = new HotSpotNodeCacheManager();
      }
      return jdField_a_of_type_CooperationQqhotspotHotspotnodeHotSpotNodeCacheManager;
    }
    finally {}
  }
  
  public List a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      List localList2 = this.jdField_a_of_type_JavaUtilList;
      return localList2;
    }
  }
  
  public Map a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Map localMap2 = this.jdField_a_of_type_JavaUtilMap;
      return localMap2;
    }
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:b	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +12 -> 22
    //   13: aload_1
    //   14: invokeinterface 51 1 0
    //   19: ifeq +8 -> 27
    //   22: aload_2
    //   23: monitorexit
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 30	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:b	Ljava/util/List;
    //   31: aload_1
    //   32: aload_0
    //   33: getfield 30	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:b	Ljava/util/List;
    //   36: invokestatic 56	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil$SetOpt:c	(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    //   39: invokeinterface 60 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 30	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:b	Ljava/util/List;
    //   49: invokeinterface 64 1 0
    //   54: sipush 1000
    //   57: if_icmple +39 -> 96
    //   60: aload_0
    //   61: getfield 30	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:b	Ljava/util/List;
    //   64: invokeinterface 64 1 0
    //   69: sipush 1000
    //   72: isub
    //   73: istore_3
    //   74: iload_3
    //   75: ifeq +21 -> 96
    //   78: aload_0
    //   79: getfield 30	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:b	Ljava/util/List;
    //   82: iconst_0
    //   83: invokeinterface 68 2 0
    //   88: pop
    //   89: iload_3
    //   90: iconst_1
    //   91: isub
    //   92: istore_3
    //   93: goto -19 -> 74
    //   96: aload_2
    //   97: monitorexit
    //   98: goto -74 -> 24
    //   101: astore_1
    //   102: aload_2
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	HotSpotNodeCacheManager
    //   0	111	1	paramList	List
    //   6	97	2	localList	List
    //   73	20	3	i	int
    // Exception table:
    //   from	to	target	type
    //   13	22	101	finally
    //   22	24	101	finally
    //   27	74	101	finally
    //   78	89	101	finally
    //   96	98	101	finally
    //   102	104	101	finally
    //   2	9	106	finally
    //   104	106	106	finally
  }
  
  public void a(List paramList, Map paramMap)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (paramList != null) {}
    try
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(HotSpotNodeUtil.SetOpt.c(paramList, this.jdField_a_of_type_JavaUtilList));
      if (this.jdField_a_of_type_JavaUtilList.size() > 200)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size() - 200;
        while (i != 0)
        {
          this.jdField_a_of_type_JavaUtilList.remove(0);
          i -= 1;
        }
      }
      paramList = this.jdField_a_of_type_JavaUtilMap;
      if (paramMap != null) {}
      try
      {
        if (paramMap.isEmpty()) {
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
    }
    finally {}
    if (this.jdField_a_of_type_JavaUtilMap.size() > 200)
    {
      paramMap = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        if (!this.jdField_a_of_type_JavaUtilList.contains(((Map.Entry)localObject).getKey())) {
          paramMap.remove();
        }
      }
    }
  }
  
  public List b()
  {
    synchronized (this.b)
    {
      List localList2 = this.b;
      return localList2;
    }
  }
  
  /* Error */
  public void b(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:c	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +12 -> 22
    //   13: aload_1
    //   14: invokeinterface 51 1 0
    //   19: ifeq +17 -> 36
    //   22: aload_0
    //   23: getfield 32	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:c	Ljava/util/List;
    //   26: invokeinterface 110 1 0
    //   31: aload_2
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: aload_1
    //   38: putfield 32	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:c	Ljava/util/List;
    //   41: aload_0
    //   42: getfield 32	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:c	Ljava/util/List;
    //   45: invokeinterface 64 1 0
    //   50: sipush 200
    //   53: if_icmple +39 -> 92
    //   56: aload_0
    //   57: getfield 32	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:c	Ljava/util/List;
    //   60: invokeinterface 64 1 0
    //   65: sipush 200
    //   68: isub
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +21 -> 92
    //   74: aload_0
    //   75: getfield 32	cooperation/qqhotspot/hotspotnode/HotSpotNodeCacheManager:c	Ljava/util/List;
    //   78: iconst_0
    //   79: invokeinterface 68 2 0
    //   84: pop
    //   85: iload_3
    //   86: iconst_1
    //   87: isub
    //   88: istore_3
    //   89: goto -19 -> 70
    //   92: aload_2
    //   93: monitorexit
    //   94: goto -61 -> 33
    //   97: astore_1
    //   98: aload_2
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	HotSpotNodeCacheManager
    //   0	107	1	paramList	List
    //   6	93	2	localList	List
    //   69	20	3	i	int
    // Exception table:
    //   from	to	target	type
    //   13	22	97	finally
    //   22	33	97	finally
    //   36	70	97	finally
    //   74	85	97	finally
    //   92	94	97	finally
    //   98	100	97	finally
    //   2	9	102	finally
    //   100	102	102	finally
  }
  
  public List c()
  {
    synchronized (this.c)
    {
      List localList2 = this.c;
      return localList2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\HotSpotNodeCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */