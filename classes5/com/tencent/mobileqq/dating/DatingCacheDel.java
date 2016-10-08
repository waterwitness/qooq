package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingApplyInfoDel;
import com.tencent.mobileqq.data.DatingPublishInfoDel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class DatingCacheDel
  implements Handler.Callback
{
  public static final int a = 100;
  public static final long a = 60000L;
  public static final String a = "sp_file_del_dating";
  public static final int b = 5;
  private static final SparseArray jdField_b_of_type_AndroidUtilSparseArray;
  private static final int c = 1;
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private final byte[] jdField_a_of_type_ArrayOfByte = { 0, 0, 0, 0 };
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { null, "data_type_my_published", "data_type_my_applied", null };
  private final byte[] jdField_b_of_type_ArrayOfByte = { 0, 0, 0, 0 };
  private final String[] jdField_b_of_type_ArrayOfJavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(2);
    jdField_b_of_type_AndroidUtilSparseArray.put(1, DatingPublishInfoDel.class);
    jdField_b_of_type_AndroidUtilSparseArray.put(2, DatingApplyInfoDel.class);
  }
  
  protected DatingCacheDel(AppInterface paramAppInterface, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new ArrayList());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new ArrayList());
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.a(), this);
    DatingUtil.a("init", new Object[] { "dataToDel" });
    paramAppInterface = paramAppInterface.a().getSharedPreferences(paramAppInterface.getAccount() + "sp_file_del_dating", 0);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangString[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_b_of_type_ArrayOfJavaLangString[i] = paramAppInterface.getString("latest_id_" + this.jdField_a_of_type_ArrayOfJavaLangString[i], "");
        paramEntityManager = new ArrayList();
        Object localObject = (Class)jdField_b_of_type_AndroidUtilSparseArray.get(i);
        localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Class)localObject);
        paramEntityManager.clear();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while ((localObject != null) && (((Iterator)localObject).hasNext()))
          {
            String str = DatingCacheMng.a((Entity)((Iterator)localObject).next());
            if (!TextUtils.isEmpty(str)) {
              paramEntityManager.add(str);
            }
          }
        }
        localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i, null);
        if (localObject != null) {
          try
          {
            ((ArrayList)localObject).clear();
            ((ArrayList)localObject).addAll(paramEntityManager);
          }
          finally {}
        }
      }
    }
  }
  
  private void a(int paramInt, byte paramByte)
  {
    DatingUtil.a("updateDelCacheFlag", new Object[] { Integer.valueOf(paramInt), Byte.valueOf(paramByte) });
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_ArrayOfByte.length))
    {
      this.jdField_a_of_type_ArrayOfByte[paramInt] = paramByte;
      if ((paramByte != 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1))) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 60000L);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iload 5
    //   5: aload_0
    //   6: getfield 61	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   9: arraylength
    //   10: if_icmpge +328 -> 338
    //   13: aload_0
    //   14: getfield 64	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfByte	[B
    //   17: iload 5
    //   19: baload
    //   20: ifeq +13 -> 33
    //   23: aload_0
    //   24: getfield 61	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   27: iload 5
    //   29: aaload
    //   30: ifnonnull +12 -> 42
    //   33: iload 5
    //   35: iconst_1
    //   36: iadd
    //   37: istore 5
    //   39: goto -36 -> 3
    //   42: aload_0
    //   43: getfield 72	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   46: iload 5
    //   48: invokevirtual 137	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   51: checkcast 74	java/util/ArrayList
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 68	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   59: invokevirtual 103	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   62: new 105	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   69: aload_0
    //   70: getfield 68	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   73: invokevirtual 110	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   76: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 15
    //   81: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: iconst_0
    //   88: invokevirtual 123	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   91: invokeinterface 221 1 0
    //   96: astore_2
    //   97: aload_2
    //   98: new 105	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   105: ldc 125
    //   107: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 61	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   114: iload 5
    //   116: aaload
    //   117: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 77	com/tencent/mobileqq/dating/DatingCacheDel:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   127: iload 5
    //   129: aaload
    //   130: invokeinterface 227 3 0
    //   135: pop
    //   136: aload_2
    //   137: invokeinterface 230 1 0
    //   142: pop
    //   143: getstatic 41	com/tencent/mobileqq/dating/DatingCacheDel:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   146: iload 5
    //   148: invokevirtual 137	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   151: checkcast 139	java/lang/Class
    //   154: astore_2
    //   155: aload_1
    //   156: monitorenter
    //   157: aload_1
    //   158: invokevirtual 234	java/util/ArrayList:size	()I
    //   161: anewarray 55	java/lang/String
    //   164: astore_3
    //   165: aload_1
    //   166: aload_3
    //   167: invokevirtual 238	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   170: pop
    //   171: aload_1
    //   172: monitorexit
    //   173: aload_3
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: arraylength
    //   179: iconst_1
    //   180: if_icmpge +39 -> 219
    //   183: aload_0
    //   184: getfield 70	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   187: aload_2
    //   188: invokestatic 243	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/Class;)Ljava/lang/String;
    //   191: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/String;)Z
    //   194: pop
    //   195: goto -162 -> 33
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 249	java/lang/InstantiationException:printStackTrace	()V
    //   203: goto -170 -> 33
    //   206: astore_2
    //   207: aload_1
    //   208: monitorexit
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 250	java/lang/IllegalAccessException:printStackTrace	()V
    //   216: goto -183 -> 33
    //   219: aload_0
    //   220: getfield 70	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   223: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 257	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   231: aload_2
    //   232: aload_3
    //   233: iconst_0
    //   234: aaload
    //   235: invokestatic 260	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   238: astore 4
    //   240: aload_0
    //   241: getfield 70	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   244: aload 4
    //   246: invokevirtual 263	com/tencent/mobileqq/persistence/EntityManager:c	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   249: aload_3
    //   250: arraylength
    //   251: istore 7
    //   253: iconst_0
    //   254: istore 6
    //   256: iload 6
    //   258: iload 7
    //   260: if_icmpge +60 -> 320
    //   263: aload_3
    //   264: iload 6
    //   266: aaload
    //   267: astore 4
    //   269: aload 4
    //   271: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +6 -> 280
    //   277: goto +62 -> 339
    //   280: aload_2
    //   281: aload 4
    //   283: invokestatic 260	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   286: astore 4
    //   288: aload_0
    //   289: getfield 70	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   292: aload 4
    //   294: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   297: goto +42 -> 339
    //   300: astore_2
    //   301: aload_2
    //   302: invokevirtual 266	java/lang/Exception:printStackTrace	()V
    //   305: aload_1
    //   306: invokevirtual 268	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   309: aload_0
    //   310: getfield 64	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfByte	[B
    //   313: iload 5
    //   315: iconst_0
    //   316: bastore
    //   317: goto -284 -> 33
    //   320: aload_1
    //   321: invokevirtual 270	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   324: aload_1
    //   325: invokevirtual 268	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   328: goto -19 -> 309
    //   331: astore_2
    //   332: aload_1
    //   333: invokevirtual 268	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   336: aload_2
    //   337: athrow
    //   338: return
    //   339: iload 6
    //   341: iconst_1
    //   342: iadd
    //   343: istore 6
    //   345: goto -89 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	DatingCacheDel
    //   54	118	1	localArrayList	ArrayList
    //   198	10	1	localInstantiationException	InstantiationException
    //   211	2	1	localIllegalAccessException	IllegalAccessException
    //   226	107	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   96	92	2	localObject1	Object
    //   206	75	2	localClass	Class
    //   300	2	2	localException	Exception
    //   331	6	2	localObject2	Object
    //   164	100	3	arrayOfString	String[]
    //   238	55	4	localObject3	Object
    //   1	313	5	i	int
    //   254	90	6	j	int
    //   251	10	7	k	int
    // Exception table:
    //   from	to	target	type
    //   183	195	198	java/lang/InstantiationException
    //   157	173	206	finally
    //   207	209	206	finally
    //   183	195	211	java/lang/IllegalAccessException
    //   227	253	300	java/lang/Exception
    //   269	277	300	java/lang/Exception
    //   280	297	300	java/lang/Exception
    //   320	324	300	java/lang/Exception
    //   227	253	331	finally
    //   269	277	331	finally
    //   280	297	331	finally
    //   301	305	331	finally
    //   320	324	331	finally
  }
  
  public Boolean a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).contains(paramString));
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      return null;
    }
    return this.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public ArrayList a(int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return (ArrayList)localObject;
      localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject = localArrayList;
    } while (localArrayList.size() <= 100);
    return new ArrayList(localArrayList.subList(0, 99));
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = this.jdField_b_of_type_ArrayOfByte;
        int i;
        if (paramBoolean)
        {
          i = 1;
          localObject1[paramInt] = ((byte)i);
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel())
    {
      if ("idSize:" + paramArrayList == null)
      {
        localObject = "null";
        DatingUtil.a("onDelResult", new Object[] { "type:", Integer.valueOf(paramInt), "success:", Boolean.valueOf(paramBoolean2), "clearAction:", Boolean.valueOf(paramBoolean1), localObject });
      }
    }
    else {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length) && (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] != null)) {
        break label126;
      }
    }
    label126:
    do
    {
      return;
      localObject = Integer.valueOf(paramArrayList.size());
      break;
      a(paramInt, false);
    } while (!paramBoolean2);
    localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        paramArrayList = (String)paramArrayList.get(0);
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ArrayOfJavaLangString[paramInt])) && (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt].equals(paramArrayList))) {
          this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = "";
        }
        a(paramInt, (byte)1);
        return;
      }
      finally {}
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        ((ArrayList)localObject).removeAll(paramArrayList);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      return;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = paramString;
        localArrayList.clear();
        a(paramInt, (byte)1);
        DatingUtil.a("addToDelCache", new Object[] { "dataType:" + paramInt, "clear:" + paramBoolean, "datingId:" + paramString, "cacheDelSize:" + localArrayList.size(), " latest:" + this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] });
        return;
      }
      finally {}
      try
      {
        localArrayList.add(paramString);
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 4
    //   7: istore_3
    //   8: iload_1
    //   9: iflt +29 -> 38
    //   12: iload 4
    //   14: istore_3
    //   15: iload_1
    //   16: aload_0
    //   17: getfield 61	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   20: arraylength
    //   21: if_icmpge +17 -> 38
    //   24: aload_0
    //   25: getfield 61	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   28: iload_1
    //   29: aaload
    //   30: astore_2
    //   31: aload_2
    //   32: ifnonnull +10 -> 42
    //   35: iload 4
    //   37: istore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_3
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 66	com/tencent/mobileqq/dating/DatingCacheDel:jdField_b_of_type_ArrayOfByte	[B
    //   46: iload_1
    //   47: baload
    //   48: istore_1
    //   49: iload 4
    //   51: istore_3
    //   52: iload_1
    //   53: ifle -15 -> 38
    //   56: iconst_1
    //   57: istore_3
    //   58: goto -20 -> 38
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	DatingCacheDel
    //   0	66	1	paramInt	int
    //   30	2	2	str	String
    //   61	4	2	localObject	Object
    //   7	51	3	bool1	boolean
    //   1	49	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   15	31	61	finally
    //   42	49	61	finally
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt1] == null)) {
      return false;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    return (!TextUtils.isEmpty(this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1])) || (localArrayList.size() >= paramInt2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingCacheDel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */