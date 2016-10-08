package com.tencent.mobileqq.app;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class DiscussionManager
  implements Manager
{
  public static final int a = 80;
  public static final String a = "Q.contacttab.dscs";
  private static final int b = 100;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public Map a;
  public Set a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public DiscussionManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  private void b()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label272;
      }
      localArrayList = new ArrayList(10);
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((ArrayList)localObject2).get(i);
        localConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        if (ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionInfo))
        {
          Map localMap = a(localDiscussionInfo.uin);
          if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionInfo.uin, localDiscussionInfo, localMap, false)) {
            localArrayList.add(localDiscussionInfo);
          }
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache, updateList=" + localArrayList.size());
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i = j;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label272:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "buildDiscussUI begin: ");
      }
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        break label134;
      }
      int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      if (i <= 0) {
        break label134;
      }
      localArrayList.ensureCapacity(i);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        if ((localDiscussionInfo.mCompareSpell == null) || (localDiscussionInfo.mCompareSpell.length() == 0)) {
          ContactSorter.a(localDiscussionInfo);
        }
        localArrayList.add(localDiscussionInfo);
      }
      if (i <= 1) {
        break label134;
      }
    }
    finally {}
    Collections.sort(localList, ContactSorter.a);
    label134:
    this.jdField_a_of_type_JavaUtilArrayList = localList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "buildDiscussUI end: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label52;
      }
      if (!((DiscussionInfo)localIterator.next()).hasCollect) {
        break label54;
      }
      i += 1;
    }
    label52:
    label54:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.size();
    }
    return 0;
  }
  
  public DiscussionInfo a(String paramString)
  {
    Object localObject;
    if (!DiscussionInfo.isValidDisUin(paramString)) {
      localObject = null;
    }
    do
    {
      do
      {
        return (DiscussionInfo)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "findDiscussionInfoByID " + paramString + " isDiscussCacheInited=" + this.jdField_a_of_type_Boolean);
        }
        localDiscussionInfo = (DiscussionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localDiscussionInfo;
      } while (localDiscussionInfo != null);
      localObject = localDiscussionInfo;
    } while (this.jdField_a_of_type_Boolean);
    DiscussionInfo localDiscussionInfo = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("findDiscussionInfoByID db ");
      if (localDiscussionInfo == null) {
        break label154;
      }
    }
    label154:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.contacttab.dscs", 2, bool);
      localObject = localDiscussionInfo;
      if (localDiscussionInfo == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localDiscussionInfo);
      return localDiscussionInfo;
    }
  }
  
  public DiscussionMemberInfo a(String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = a(paramString1);
    if (paramString1 != null) {
      paramString1 = (DiscussionMemberInfo)paramString1.get(paramString2);
    }
    do
    {
      return paramString1;
      paramString1 = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfo null");
    return null;
  }
  
  public DiscussionMemberInfo a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      paramString1 = null;
    }
    do
    {
      do
      {
        return paramString1;
        paramString2 = a(paramString1, paramString2);
        paramString1 = paramString2;
      } while (paramString2 == null);
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramString2.inteRemark == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.inteRemark.equals(paramArrayOfByte));
    paramString2.inteRemark = paramArrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.equals(paramString2.memberName))) {}
    for (paramString2.inteRemarkSource = 129L;; paramString2.inteRemarkSource = 128L)
    {
      paramString1 = paramString2;
      if (!paramBoolean) {
        break;
      }
      a(paramString2);
      return paramString2;
    }
  }
  
  public ArrayList a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    paramString = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.size() > 0)) {
      localArrayList.addAll(paramString.values());
    }
    return localArrayList;
  }
  
  public Map a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin param is null");
      }
      return null;
    }
    Object localObject2 = (Map)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("getDiscussionMemberInfoListByUin from map list disUin=").append(paramString).append(" size=");
        if (localObject2 != null) {
          break label98;
        }
        i = -1;
        label79:
        QLog.d("Q.contacttab.dscs", 2, i);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return (Map)localObject1;
      label98:
      i = ((Map)localObject2).size();
      break label79;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[] { paramString }, null, null, "memberUin", null);
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from DB list is null disUin=" + paramString);
        return null;
      }
      localObject1 = new HashMap(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
        ((Map)localObject1).put(localDiscussionMemberInfo.memberUin, localDiscussionMemberInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from db list disUin=" + paramString + " size=" + ((Map)localObject1).size());
      }
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
    }
  }
  
  public Map a(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramArrayOfString[i], new ArrayList());
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("discussionUin in (");
    i = 0;
    while (i < paramArrayOfString.length)
    {
      if (i != 0) {
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("?");
      i += 1;
    }
    ((StringBuilder)localObject).append(")");
    String[] arrayOfString = new String[paramArrayOfString.length];
    i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = SecurityUtile.b(paramArrayOfString[i]);
      i += 1;
    }
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, ((StringBuilder)localObject).toString(), arrayOfString, "memberUin", null, "memberUin", null);
    if (paramArrayOfString != null)
    {
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        localObject = (DiscussionMemberInfo)paramArrayOfString.next();
        ((List)localHashMap.get(((DiscussionMemberInfo)localObject).discussionUin)).add(localObject);
      }
    }
    return localHashMap;
  }
  
  public void a()
  {
    b();
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("saveDiscussInfo ");
      if (paramDiscussionInfo == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject1 = paramDiscussionInfo.uin;; localObject1 = Integer.valueOf(-1))
    {
      QLog.d("Q.contacttab.dscs", 2, localObject1);
      if (paramDiscussionInfo != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDiscussionInfo.uin, paramDiscussionInfo);
    }
    a(paramDiscussionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = ((ProxyManager)localObject1).a().a(paramDiscussionInfo.uin, 3000);
    if (((RecentUser)localObject2).getStatus() == 1001)
    {
      ((RecentUser)localObject2).displayName = paramDiscussionInfo.discussionName;
      ((ProxyManager)localObject1).a().a((RecentUser)localObject2);
    }
    c();
  }
  
  public void a(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (paramDiscussionMemberInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfo " + paramDiscussionMemberInfo);
      }
      Map localMap = a(paramDiscussionMemberInfo.discussionUin);
      if (localMap != null) {
        localMap.put(paramDiscussionMemberInfo.memberUin, paramDiscussionMemberInfo);
      }
      a(paramDiscussionMemberInfo);
      DiscussionInfo localDiscussionInfo = a(paramDiscussionMemberInfo.discussionUin);
      if ((localDiscussionInfo != null) && (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionMemberInfo.discussionUin, localDiscussionInfo, localMap, false))) {
        a(localDiscussionInfo);
      }
    }
  }
  
  /* Error */
  public void a(String paramString, DiscussionInfo paramDiscussionInfo, long paramLong1, Map paramMap, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +56 -> 59
    //   6: ldc 12
    //   8: iconst_2
    //   9: new 133	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 388
    //   19: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 390
    //   29: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 5
    //   34: invokeinterface 230 1 0
    //   39: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 392
    //   45: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: lload 6
    //   50: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 44	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   63: aload_1
    //   64: aload 5
    //   66: invokevirtual 322	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 229	java/util/Map
    //   72: astore 8
    //   74: aload 8
    //   76: ifnull +57 -> 133
    //   79: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +51 -> 133
    //   85: ldc 12
    //   87: iconst_2
    //   88: new 133	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 397
    //   98: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 8
    //   103: invokeinterface 230 1 0
    //   108: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc_w 399
    //   114: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 5
    //   119: invokeinterface 230 1 0
    //   124: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: new 48	java/util/HashSet
    //   136: dup
    //   137: invokespecial 49	java/util/HashSet:<init>	()V
    //   140: astore 9
    //   142: aload_0
    //   143: getfield 77	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   146: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   149: astore 8
    //   151: aload 8
    //   153: invokevirtual 154	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   156: aload 5
    //   158: invokeinterface 403 1 0
    //   163: invokeinterface 406 1 0
    //   168: astore 10
    //   170: aload 10
    //   172: invokeinterface 194 1 0
    //   177: ifeq +141 -> 318
    //   180: aload 10
    //   182: invokeinterface 198 1 0
    //   187: checkcast 408	java/util/Map$Entry
    //   190: invokeinterface 411 1 0
    //   195: checkcast 254	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   198: astore 11
    //   200: new 133	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   207: aload 11
    //   209: getfield 340	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   212: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 413
    //   218: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 11
    //   223: getfield 318	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   226: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore 12
    //   234: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +30 -> 267
    //   240: ldc 12
    //   242: iconst_2
    //   243: new 133	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 415
    //   253: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 12
    //   258: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload 9
    //   269: aload 12
    //   271: invokevirtual 418	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   274: ifne -104 -> 170
    //   277: aload 9
    //   279: aload 12
    //   281: invokevirtual 419	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   284: pop
    //   285: aload_0
    //   286: aload 11
    //   288: invokevirtual 159	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   291: pop
    //   292: goto -122 -> 170
    //   295: astore_1
    //   296: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +13 -> 312
    //   302: ldc 12
    //   304: iconst_2
    //   305: ldc_w 421
    //   308: aload_1
    //   309: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload 8
    //   314: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   317: return
    //   318: aload_0
    //   319: getfield 64	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: invokevirtual 427	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   325: ifnull +77 -> 402
    //   328: aload_0
    //   329: getfield 64	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: invokevirtual 427	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   335: new 254	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   338: dup
    //   339: invokespecial 428	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   342: invokevirtual 431	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   345: ldc_w 433
    //   348: iconst_2
    //   349: anewarray 203	java/lang/String
    //   352: dup
    //   353: iconst_0
    //   354: aload_1
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: lload 6
    //   360: invokestatic 436	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   363: aastore
    //   364: invokevirtual 441	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   367: istore 13
    //   369: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +30 -> 402
    //   375: ldc 12
    //   377: iconst_2
    //   378: new 133	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 443
    //   388: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload 13
    //   393: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_0
    //   403: getfield 64	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: aload_1
    //   407: aload_2
    //   408: aload 5
    //   410: iconst_0
    //   411: invokestatic 127	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   414: pop
    //   415: aload_2
    //   416: lload_3
    //   417: putfield 446	com/tencent/mobileqq/data/DiscussionInfo:infoSeq	J
    //   420: aload_0
    //   421: aload_2
    //   422: invokevirtual 447	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   425: aload 8
    //   427: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   430: aload 8
    //   432: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   435: return
    //   436: astore_1
    //   437: aload 8
    //   439: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   442: aload_1
    //   443: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	DiscussionManager
    //   0	444	1	paramString	String
    //   0	444	2	paramDiscussionInfo	DiscussionInfo
    //   0	444	3	paramLong1	long
    //   0	444	5	paramMap	Map
    //   0	444	6	paramLong2	long
    //   72	366	8	localObject	Object
    //   140	138	9	localHashSet	HashSet
    //   168	13	10	localIterator	Iterator
    //   198	89	11	localDiscussionMemberInfo	DiscussionMemberInfo
    //   232	48	12	str	String
    //   367	25	13	i	int
    // Exception table:
    //   from	to	target	type
    //   156	170	295	java/lang/Exception
    //   170	267	295	java/lang/Exception
    //   267	292	295	java/lang/Exception
    //   318	402	295	java/lang/Exception
    //   402	430	295	java/lang/Exception
    //   156	170	436	finally
    //   170	267	436	finally
    //   267	292	436	finally
    //   296	312	436	finally
    //   318	402	436	finally
    //   402	430	436	finally
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMember disUin=" + paramString1 + " memberUin=" + paramString2);
    }
    Object localObject1 = (Map)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (DiscussionMemberInfo)((Map)localObject1).remove(paramString2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        if ("removed from cache " + localObject2 == null) {
          break label181;
        }
        localObject1 = "true";
        QLog.d("Q.contacttab.dscs", 2, (String)localObject1);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, new String[] { paramString1, paramString2 });
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "removed from db ");
        }
      }
      return;
      label181:
      localObject1 = "false";
      break;
    }
  }
  
  public void a(String paramString, Set paramSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers disuin=" + paramString);
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) || (paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        localMap = a(paramString);
        if (localMap != null)
        {
          localStringBuilder = new StringBuilder(paramSet.size() * 8);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("remove member=");
          }
          paramSet = paramSet.iterator();
          while (paramSet.hasNext())
          {
            String str = (String)paramSet.next();
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localMap.remove(str);
            if (localDiscussionMemberInfo != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionMemberInfo);
              if (QLog.isColorLevel()) {
                localStringBuilder.append(str.substring(0, 4)).append("|");
              }
            }
          }
        }
      }
      catch (Exception paramSet)
      {
        Map localMap;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers exp disUin=" + paramString, paramSet);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
        }
        paramSet = a(paramString);
        if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramSet, localMap, false)) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramSet);
        }
        localEntityTransaction.c();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryDiscs_" + paramList.size());
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "preloadData size=" + paramList.size());
    }
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (DiscussionInfo)paramList.next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((DiscussionInfo)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    DiscussionInfo localDiscussionInfo = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscuss uin=" + paramString);
    }
    if (localDiscussionInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
      paramString = "delete from DiscussionMemberInfo where discussionUin='" + paramString + "'";
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionInfo);
      c();
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin=?", new String[] { paramString1, paramString2 }, null, null, "memberUin", null) != null) {
      bool = true;
    }
    return bool;
  }
  
  boolean a(ArrayList paramArrayList, long paramLong, boolean paramBoolean)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    label298:
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        int i;
        DiscussionInfo localDiscussionInfo;
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i = 0;
          if (i < paramArrayList.size())
          {
            localDiscussionInfo = (DiscussionInfo)paramArrayList.get(i);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
            a(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              break label298;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been updated");
            break label298;
          }
        }
        if (paramBoolean)
        {
          paramArrayList = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          if (paramArrayList.hasNext())
          {
            localDiscussionInfo = (DiscussionInfo)((Map.Entry)paramArrayList.next()).getValue();
            if (localDiscussionInfo.timeSec >= paramLong) {
              continue;
            }
            paramArrayList.remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been removed");
            continue;
          }
        }
        i += 1;
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 2, "saveAllDiscussions exception:", paramArrayList);
        }
        localEntityTransaction.b();
        paramBoolean = false;
        c();
        return paramBoolean;
        localEntityTransaction.c();
        localEntityTransaction.b();
        paramBoolean = true;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  public ArrayList b(String paramString)
  {
    ArrayList localArrayList = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin<>? ", new String[] { paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() }, null, null, "memberUin", String.valueOf(5));
    paramString = localArrayList;
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localArrayList.add(((DiscussionMemberInfo)((Iterator)localObject).next()).memberUin);
      }
    }
    return paramString;
  }
  
  /* Error */
  public void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 12
    //   8: iconst_2
    //   9: new 133	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 551
    //   19: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 553
    //   29: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 77	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 154	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload_0
    //   63: getfield 77	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: ldc -2
    //   68: iconst_0
    //   69: ldc_w 555
    //   72: iconst_1
    //   73: anewarray 203	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: aconst_null
    //   81: aconst_null
    //   82: ldc_w 307
    //   85: aconst_null
    //   86: invokevirtual 99	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   89: checkcast 59	java/util/ArrayList
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +174 -> 270
    //   99: aload 4
    //   101: invokevirtual 103	java/util/ArrayList:size	()I
    //   104: ifle +166 -> 270
    //   107: aload 4
    //   109: invokevirtual 223	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 194 1 0
    //   121: ifeq +149 -> 270
    //   124: aload 4
    //   126: invokeinterface 198 1 0
    //   131: checkcast 254	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   134: getfield 340	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   137: astore 5
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 385	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   145: astore 6
    //   147: aload_0
    //   148: aload 5
    //   150: invokevirtual 124	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Ljava/util/Map;
    //   153: astore 7
    //   155: aload 7
    //   157: ifnull +45 -> 202
    //   160: aload 7
    //   162: aload_1
    //   163: invokeinterface 252 2 0
    //   168: checkcast 254	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   171: astore 8
    //   173: aload 8
    //   175: ifnull +27 -> 202
    //   178: aload 8
    //   180: aload_2
    //   181: putfield 265	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   184: aload 8
    //   186: ldc2_w 281
    //   189: putfield 277	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   192: aload_0
    //   193: getfield 77	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   196: aload 8
    //   198: invokevirtual 484	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   201: pop
    //   202: aload 6
    //   204: ifnull -90 -> 114
    //   207: aload 6
    //   209: aload 6
    //   211: getfield 558	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   214: ldc2_w 559
    //   217: lor
    //   218: putfield 558	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   221: aload_0
    //   222: getfield 64	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   225: aload 5
    //   227: aload 6
    //   229: aload 7
    //   231: iconst_0
    //   232: invokestatic 127	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   235: ifeq -121 -> 114
    //   238: aload_0
    //   239: aload 6
    //   241: invokevirtual 159	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   244: pop
    //   245: goto -131 -> 114
    //   248: astore_1
    //   249: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +13 -> 265
    //   255: ldc 12
    //   257: iconst_2
    //   258: ldc_w 562
    //   261: aload_1
    //   262: invokestatic 565	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_3
    //   266: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   269: return
    //   270: aload_3
    //   271: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   274: aload_3
    //   275: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   278: return
    //   279: astore_1
    //   280: aload_3
    //   281: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   284: aload_1
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	DiscussionManager
    //   0	286	1	paramString1	String
    //   0	286	2	paramString2	String
    //   57	224	3	localEntityTransaction	EntityTransaction
    //   92	33	4	localObject	Object
    //   137	89	5	str	String
    //   145	95	6	localDiscussionInfo	DiscussionInfo
    //   153	77	7	localMap	Map
    //   171	26	8	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   58	94	248	java/lang/Exception
    //   99	114	248	java/lang/Exception
    //   114	155	248	java/lang/Exception
    //   160	173	248	java/lang/Exception
    //   178	202	248	java/lang/Exception
    //   207	245	248	java/lang/Exception
    //   270	274	248	java/lang/Exception
    //   58	94	279	finally
    //   99	114	279	finally
    //   114	155	279	finally
    //   160	173	279	finally
    //   178	202	279	finally
    //   207	245	279	finally
    //   249	265	279	finally
    //   270	274	279	finally
  }
  
  public void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList");
    }
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (paramList.size() == 1)
    {
      a((DiscussionMemberInfo)paramList.get(0));
      return;
    }
    HashSet localHashSet = new HashSet();
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    localEntityTransaction.a();
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localStringBuffer = new StringBuffer();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.next();
            String str = localDiscussionMemberInfo.discussionUin + "_" + localDiscussionMemberInfo.memberUin;
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(str);
              localStringBuffer.append(";");
            }
            if (localHashSet.contains(str)) {
              continue;
            }
            a(localDiscussionMemberInfo);
            localHashSet.add(str);
            continue;
          }
        }
        StringBuffer localStringBuffer = null;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList ex=", paramList);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList info=" + localStringBuffer.toString());
        }
        localEntityTransaction.c();
        return;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DiscussionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */