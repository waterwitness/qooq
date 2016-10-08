package com.tencent.mobileqq.nearby;

import android.content.res.Resources;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingSubjectItem;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NearbyConfigUtil
{
  DatingConfig a;
  
  public NearbyConfigUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List b()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = BaseApplication.getContext().getResources().getStringArray(2131230764);
    int[] arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230765);
    int i = 0;
    if (i < arrayOfString.length)
    {
      int j;
      if (arrayOfInt[i] == 5)
      {
        j = 60;
        label54:
        if (arrayOfInt[i] != 5) {
          break label115;
        }
      }
      label115:
      for (String str = BaseApplication.getContext().getResources().getString(2131371715);; str = BaseApplication.getContext().getResources().getString(2131371716))
      {
        localArrayList.add(new DatingSubjectItem(arrayOfInt[i], arrayOfString[i], j, str));
        i += 1;
        break;
        j = 15;
        break label54;
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public DatingConfig a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 64	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aconst_null
    //   19: astore_2
    //   20: iconst_1
    //   21: anewarray 66	java/lang/Class
    //   24: astore_3
    //   25: aload_3
    //   26: iconst_0
    //   27: ldc 4
    //   29: aastore
    //   30: ldc 68
    //   32: aload_3
    //   33: invokestatic 73	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[Ljava/lang/Class;)[Ljava/lang/Object;
    //   36: astore 4
    //   38: aload_2
    //   39: astore_1
    //   40: aload 4
    //   42: ifnull -28 -> 14
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: arraylength
    //   50: aload_3
    //   51: arraylength
    //   52: if_icmpne -38 -> 14
    //   55: aload 4
    //   57: iconst_0
    //   58: aaload
    //   59: checkcast 75	com/tencent/mobileqq/data/DatingConfig
    //   62: astore_1
    //   63: aload_0
    //   64: aload_1
    //   65: putfield 64	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   68: goto -54 -> 14
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	NearbyConfigUtil
    //   13	52	1	localObject1	Object
    //   71	4	1	localObject2	Object
    //   19	27	2	localObject3	Object
    //   24	27	3	arrayOfClass	Class[]
    //   36	20	4	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   2	14	71	finally
    //   20	25	71	finally
    //   30	38	71	finally
    //   47	68	71	finally
  }
  
  public List a()
  {
    List localList = null;
    Object localObject = a();
    if (localObject != null) {
      localList = ((DatingConfig)localObject).subjects;
    }
    if (localList != null)
    {
      localObject = localList;
      if (localList.size() != 0) {}
    }
    else
    {
      localObject = b();
    }
    return (List)localObject;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 64	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   19: goto -8 -> 11
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	NearbyConfigUtil
    //   6	2	1	localDatingConfig	DatingConfig
    //   22	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
    //   14	19	22	finally
  }
  
  public void a(DatingConfig paramDatingConfig)
  {
    try
    {
      DatingUtil.b("saveDatingConfig", new Object[] { "" });
      this.a = paramDatingConfig;
      File localFile = new File(BaseApplication.getContext().getFilesDir(), "dating_others.cfg");
      if (localFile.exists()) {
        localFile.delete();
      }
      FileUtils.a("dating_others.cfg", new Object[] { paramDatingConfig });
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */