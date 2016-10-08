package com.tencent.mobileqq.app;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qdk;
import qdl;
import qdm;

public class PublicAccountDataManager
  implements Manager
{
  public static final String a = "Q.contacttab.pub";
  private int jdField_a_of_type_Int;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean a;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  private volatile boolean jdField_b_of_type_Boolean;
  ArrayList c;
  
  public PublicAccountDataManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 50;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.b().postDelayed(new qdk(this), 10L);
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      return false;
      localAccountDetail = b(paramString);
    } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
    return true;
  }
  
  public AccountDetail a(String paramString)
  {
    AccountDetail localAccountDetail = null;
    Object localObject = localAccountDetail;
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null)
    {
      localObject = localAccountDetail;
      if (paramString != null)
      {
        localAccountDetail = (AccountDetail)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        localObject = localAccountDetail;
        if (localAccountDetail == null)
        {
          localObject = localAccountDetail;
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
          {
            paramString = (AccountDetail)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(AccountDetail.class, paramString);
            localObject = paramString;
            if (paramString != null)
            {
              this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString.uin, paramString);
              localObject = paramString;
            }
          }
        }
      }
    }
    return (AccountDetail)localObject;
  }
  
  public PublicAccountInfo a(String paramString)
  {
    return (PublicAccountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PublicAccountInfo)((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  /* Error */
  public List a(List paramList, long paramLong)
  {
    // Byte code:
    //   0: new 34	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 35	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: aload_1
    //   10: ifnonnull +6 -> 16
    //   13: aload 6
    //   15: areturn
    //   16: aload_0
    //   17: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 128	java/util/concurrent/ConcurrentHashMap
    //   27: dup
    //   28: invokespecial 165	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   31: putfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: aconst_null
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: invokevirtual 168	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   44: astore 5
    //   46: aload 5
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 172	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   55: aload_1
    //   56: ifnull +77 -> 133
    //   59: aload_1
    //   60: invokeinterface 178 1 0
    //   65: ifle +68 -> 133
    //   68: aload_1
    //   69: invokeinterface 179 1 0
    //   74: astore_1
    //   75: aload_1
    //   76: invokeinterface 149 1 0
    //   81: ifeq +52 -> 133
    //   84: aload_1
    //   85: invokeinterface 153 1 0
    //   90: checkcast 131	com/tencent/mobileqq/data/PublicAccountInfo
    //   93: astore 5
    //   95: aload_0
    //   96: aload 5
    //   98: invokevirtual 182	com/tencent/mobileqq/app/PublicAccountDataManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   101: pop
    //   102: aload_0
    //   103: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   106: aload 5
    //   108: invokevirtual 186	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   111: aload 5
    //   113: invokevirtual 187	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: goto -42 -> 75
    //   120: astore_1
    //   121: aload 4
    //   123: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   126: aload_0
    //   127: invokevirtual 190	com/tencent/mobileqq/app/PublicAccountDataManager:b	()V
    //   130: aload 6
    //   132: areturn
    //   133: aload_0
    //   134: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   137: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   140: invokeinterface 143 1 0
    //   145: astore_1
    //   146: aload_1
    //   147: invokeinterface 149 1 0
    //   152: ifeq +78 -> 230
    //   155: aload_1
    //   156: invokeinterface 153 1 0
    //   161: checkcast 155	java/util/Map$Entry
    //   164: invokeinterface 158 1 0
    //   169: checkcast 131	com/tencent/mobileqq/data/PublicAccountInfo
    //   172: astore 5
    //   174: aload 5
    //   176: getfield 193	com/tencent/mobileqq/data/PublicAccountInfo:extendType	I
    //   179: iconst_2
    //   180: if_icmpne -34 -> 146
    //   183: aload 5
    //   185: getfield 197	com/tencent/mobileqq/data/PublicAccountInfo:dateTime	J
    //   188: lload_2
    //   189: lcmp
    //   190: ifge -44 -> 146
    //   193: aload_1
    //   194: invokeinterface 200 1 0
    //   199: aload_0
    //   200: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   203: aload 5
    //   205: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   208: pop
    //   209: aload 6
    //   211: aload 5
    //   213: invokeinterface 203 2 0
    //   218: pop
    //   219: goto -73 -> 146
    //   222: astore_1
    //   223: aload 4
    //   225: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   228: aload_1
    //   229: athrow
    //   230: aload 4
    //   232: invokevirtual 205	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   235: aload 4
    //   237: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: goto -114 -> 126
    //   243: astore_1
    //   244: aconst_null
    //   245: astore 4
    //   247: goto -24 -> 223
    //   250: astore_1
    //   251: goto -130 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	PublicAccountDataManager
    //   0	254	1	paramList	List
    //   0	254	2	paramLong	long
    //   35	211	4	localObject1	Object
    //   44	168	5	localObject2	Object
    //   7	203	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	55	120	java/lang/Exception
    //   59	75	120	java/lang/Exception
    //   75	117	120	java/lang/Exception
    //   133	146	120	java/lang/Exception
    //   146	219	120	java/lang/Exception
    //   230	235	120	java/lang/Exception
    //   50	55	222	finally
    //   59	75	222	finally
    //   75	117	222	finally
    //   133	146	222	finally
    //   146	219	222	finally
    //   230	235	222	finally
    //   37	46	243	finally
    //   37	46	250	java/lang/Exception
  }
  
  /* Error */
  public List a(List paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: ifnonnull +28 -> 32
    //   7: aload_1
    //   8: ifnull +176 -> 184
    //   11: aload_1
    //   12: invokeinterface 178 1 0
    //   17: istore 10
    //   19: aload_0
    //   20: new 128	java/util/concurrent/ConcurrentHashMap
    //   23: dup
    //   24: iload 10
    //   26: invokespecial 209	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   29: putfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   32: new 34	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 35	java/util/ArrayList:<init>	()V
    //   39: astore 8
    //   41: aconst_null
    //   42: astore 6
    //   44: aload_0
    //   45: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: invokevirtual 168	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   51: astore 7
    //   53: aload 7
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 172	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload_1
    //   63: ifnull +180 -> 243
    //   66: aload_1
    //   67: invokeinterface 178 1 0
    //   72: ifle +171 -> 243
    //   75: aload_1
    //   76: invokeinterface 179 1 0
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 149 1 0
    //   88: ifeq +155 -> 243
    //   91: aload_1
    //   92: invokeinterface 153 1 0
    //   97: checkcast 131	com/tencent/mobileqq/data/PublicAccountInfo
    //   100: astore 7
    //   102: aload_0
    //   103: aload 7
    //   105: invokevirtual 186	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   108: invokevirtual 211	com/tencent/mobileqq/app/PublicAccountDataManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PublicAccountInfo;
    //   111: astore 9
    //   113: aload 9
    //   115: ifnull +75 -> 190
    //   118: aload 9
    //   120: getfield 214	com/tencent/mobileqq/data/PublicAccountInfo:lastAIOReadTime	J
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +65 -> 190
    //   128: aload 7
    //   130: aload 9
    //   132: getfield 214	com/tencent/mobileqq/data/PublicAccountInfo:lastAIOReadTime	J
    //   135: putfield 214	com/tencent/mobileqq/data/PublicAccountInfo:lastAIOReadTime	J
    //   138: aload_0
    //   139: aload 7
    //   141: invokevirtual 182	com/tencent/mobileqq/app/PublicAccountDataManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   144: pop
    //   145: aload 7
    //   147: invokevirtual 217	com/tencent/mobileqq/data/PublicAccountInfo:isNeedShow	()Z
    //   150: ifeq +59 -> 209
    //   153: aload_0
    //   154: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: aload 7
    //   159: invokevirtual 186	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   162: aload 7
    //   164: invokevirtual 187	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: pop
    //   168: goto -86 -> 82
    //   171: astore_1
    //   172: aload 6
    //   174: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   177: aload_0
    //   178: invokevirtual 190	com/tencent/mobileqq/app/PublicAccountDataManager:b	()V
    //   181: aload 8
    //   183: areturn
    //   184: iconst_0
    //   185: istore 10
    //   187: goto -168 -> 19
    //   190: aload 7
    //   192: invokestatic 223	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   195: putfield 214	com/tencent/mobileqq/data/PublicAccountInfo:lastAIOReadTime	J
    //   198: goto -60 -> 138
    //   201: astore_1
    //   202: aload 6
    //   204: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   207: aload_1
    //   208: athrow
    //   209: aload_0
    //   210: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   213: aload 7
    //   215: invokevirtual 186	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   218: invokevirtual 225	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aload 7
    //   224: invokevirtual 228	com/tencent/mobileqq/data/PublicAccountInfo:isVisible	()Z
    //   227: ifne -145 -> 82
    //   230: aload 8
    //   232: aload 7
    //   234: invokeinterface 203 2 0
    //   239: pop
    //   240: goto -158 -> 82
    //   243: iload 4
    //   245: ifne +96 -> 341
    //   248: iload 5
    //   250: ifeq +91 -> 341
    //   253: aload_0
    //   254: getfield 126	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   257: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   260: invokeinterface 143 1 0
    //   265: astore_1
    //   266: aload_1
    //   267: invokeinterface 149 1 0
    //   272: ifeq +69 -> 341
    //   275: aload_1
    //   276: invokeinterface 153 1 0
    //   281: checkcast 155	java/util/Map$Entry
    //   284: invokeinterface 158 1 0
    //   289: checkcast 131	com/tencent/mobileqq/data/PublicAccountInfo
    //   292: astore 7
    //   294: aload 7
    //   296: getfield 193	com/tencent/mobileqq/data/PublicAccountInfo:extendType	I
    //   299: ifne -33 -> 266
    //   302: aload 7
    //   304: getfield 197	com/tencent/mobileqq/data/PublicAccountInfo:dateTime	J
    //   307: lload_2
    //   308: lcmp
    //   309: ifge -43 -> 266
    //   312: aload_1
    //   313: invokeinterface 200 1 0
    //   318: aload_0
    //   319: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   322: aload 7
    //   324: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   327: pop
    //   328: aload 8
    //   330: aload 7
    //   332: invokeinterface 203 2 0
    //   337: pop
    //   338: goto -72 -> 266
    //   341: aload 6
    //   343: invokevirtual 205	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   346: aload 6
    //   348: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   351: goto -174 -> 177
    //   354: astore_1
    //   355: aconst_null
    //   356: astore 6
    //   358: goto -156 -> 202
    //   361: astore_1
    //   362: goto -190 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	PublicAccountDataManager
    //   0	365	1	paramList	List
    //   0	365	2	paramLong	long
    //   0	365	4	paramBoolean1	boolean
    //   0	365	5	paramBoolean2	boolean
    //   42	315	6	localObject1	Object
    //   51	280	7	localObject2	Object
    //   39	290	8	localArrayList	ArrayList
    //   111	20	9	localPublicAccountInfo	PublicAccountInfo
    //   17	169	10	i	int
    // Exception table:
    //   from	to	target	type
    //   57	62	171	java/lang/Exception
    //   66	82	171	java/lang/Exception
    //   82	113	171	java/lang/Exception
    //   118	138	171	java/lang/Exception
    //   138	168	171	java/lang/Exception
    //   190	198	171	java/lang/Exception
    //   209	240	171	java/lang/Exception
    //   253	266	171	java/lang/Exception
    //   266	338	171	java/lang/Exception
    //   341	346	171	java/lang/Exception
    //   57	62	201	finally
    //   66	82	201	finally
    //   82	113	201	finally
    //   118	138	201	finally
    //   138	168	201	finally
    //   190	198	201	finally
    //   209	240	201	finally
    //   253	266	201	finally
    //   266	338	201	finally
    //   341	346	201	finally
    //   44	53	354	finally
    //   44	53	361	java/lang/Exception
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 230	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 231	com/tencent/mobileqq/app/PublicAccountDataManager:c	()V
    //   18: aload_0
    //   19: invokevirtual 190	com/tencent/mobileqq/app/PublicAccountDataManager:b	()V
    //   22: aload_0
    //   23: invokevirtual 234	com/tencent/mobileqq/app/PublicAccountDataManager:e	()V
    //   26: aload_0
    //   27: invokevirtual 237	com/tencent/mobileqq/app/PublicAccountDataManager:d	()V
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 230	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_Boolean	Z
    //   35: invokestatic 242	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:a	()Lcom/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager;
    //   38: aload_0
    //   39: getfield 61	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: aload_0
    //   43: invokevirtual 244	com/tencent/mobileqq/app/PublicAccountDataManager:a	()Ljava/util/List;
    //   46: invokevirtual 247	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   49: invokestatic 252	com/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderManager:a	()Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderManager;
    //   52: aload_0
    //   53: getfield 61	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 254	com/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   59: goto -48 -> 11
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	PublicAccountDataManager
    //   62	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	62	finally
    //   14	59	62	finally
  }
  
  public void a(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramAccountDetail.uin, paramAccountDetail);
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.pub", 2, "mAccountDetailCache size: " + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + " cacheCount()" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.cacheCount() + "  maxSize=" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.maxSize() + "  putCount:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.putCount() + "  createCount:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.createCount() + "  missed:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.missCount());
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramPublicAccountInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    PublicAccountInfo localPublicAccountInfo = b(paramPublicAccountInfo.getUin());
    if ((localPublicAccountInfo != null) && (localPublicAccountInfo.lastAIOReadTime > 0L))
    {
      paramPublicAccountInfo.lastAIOReadTime = localPublicAccountInfo.lastAIOReadTime;
      a(paramPublicAccountInfo);
      if (!paramPublicAccountInfo.isNeedShow()) {
        break label94;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPublicAccountInfo.getUin(), paramPublicAccountInfo);
    }
    for (;;)
    {
      b();
      return;
      paramPublicAccountInfo.lastAIOReadTime = NetConnInfoCenter.getServerTimeMillis();
      break;
      label94:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPublicAccountInfo.getUin(), paramPublicAccountInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(this.jdField_a_of_type_Int);
    }
    AccountDetail localAccountDetail = a(paramString);
    if (localAccountDetail != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localAccountDetail);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    do
    {
      return;
      paramString = b(paramString);
    } while (paramString == null);
    paramString.lastAIOReadTime = paramLong;
    ThreadManager.b(new qdm(this, paramString));
  }
  
  public void a(ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    Object localObject = new ArrayList();
    if (paramArrayList.size() > 0) {
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (paramArrayList.hasNext()) {
        localMessageRecord = (MessageRecord)paramArrayList.next();
      }
      try
      {
        long l = Long.parseLong(localMessageRecord.senderuin);
        if (((l == 9954L) && (localMessageRecord.istroop == 7220)) || (localMessageRecord.istroop != 1008) || (((ArrayList)localObject).contains(Long.valueOf(l)))) {
          continue;
        }
        ((ArrayList)localObject).add(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException) {}
      paramArrayList = ((ArrayList)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (Long)paramArrayList.next();
        if ((b(((Long)localObject).toString()) == null) && (a(((Long)localObject).toString()) == null) && ((this.jdField_a_of_type_JavaUtilHashMap.get(localObject) == null) || ((this.jdField_a_of_type_JavaUtilHashMap.get(localObject) != null) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).longValue() > 120000L))))
        {
          PublicAccountUtil.a(paramQQAppInterface, BaseApplication.getContext(), null, ((Long)localObject).toString());
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Long.valueOf(System.currentTimeMillis()));
        }
      }
      return;
    }
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +88 -> 89
    //   4: aload_1
    //   5: invokeinterface 178 1 0
    //   10: ifle +79 -> 89
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   19: invokevirtual 168	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 172	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   29: aload_0
    //   30: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: ldc_w 377
    //   36: invokevirtual 380	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +49 -> 90
    //   44: aload_3
    //   45: invokeinterface 179 1 0
    //   50: astore_3
    //   51: aload_3
    //   52: invokeinterface 149 1 0
    //   57: ifeq +33 -> 90
    //   60: aload_3
    //   61: invokeinterface 153 1 0
    //   66: checkcast 377	com/tencent/mobileqq/data/PublicRecommendAccountInfo
    //   69: astore 4
    //   71: aload_0
    //   72: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   75: aload 4
    //   77: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   80: pop
    //   81: goto -30 -> 51
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   89: return
    //   90: aload_1
    //   91: invokeinterface 179 1 0
    //   96: astore_3
    //   97: aload_3
    //   98: invokeinterface 149 1 0
    //   103: ifeq +33 -> 136
    //   106: aload_3
    //   107: invokeinterface 153 1 0
    //   112: checkcast 377	com/tencent/mobileqq/data/PublicRecommendAccountInfo
    //   115: astore 4
    //   117: aload_0
    //   118: getfield 59	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   121: aload 4
    //   123: invokevirtual 383	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   126: goto -29 -> 97
    //   129: astore_1
    //   130: aload_2
    //   131: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   134: aload_1
    //   135: athrow
    //   136: aload_0
    //   137: getfield 41	com/tencent/mobileqq/app/PublicAccountDataManager:c	Ljava/util/ArrayList;
    //   140: ifnull +3 -> 143
    //   143: aload_0
    //   144: aload_1
    //   145: checkcast 34	java/util/ArrayList
    //   148: putfield 41	com/tencent/mobileqq/app/PublicAccountDataManager:c	Ljava/util/ArrayList;
    //   151: aload_2
    //   152: invokevirtual 205	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   155: aload_2
    //   156: invokevirtual 189	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   159: return
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_2
    //   163: goto -33 -> 130
    //   166: astore_1
    //   167: goto -82 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	PublicAccountDataManager
    //   0	170	1	paramList	List
    //   14	149	2	localObject1	Object
    //   22	85	3	localObject2	Object
    //   69	53	4	localPublicRecommendAccountInfo	PublicRecommendAccountInfo
    // Exception table:
    //   from	to	target	type
    //   25	40	84	java/lang/Exception
    //   44	51	84	java/lang/Exception
    //   51	81	84	java/lang/Exception
    //   90	97	84	java/lang/Exception
    //   97	126	84	java/lang/Exception
    //   136	143	84	java/lang/Exception
    //   143	155	84	java/lang/Exception
    //   25	40	129	finally
    //   44	51	129	finally
    //   51	81	129	finally
    //   90	97	129	finally
    //   97	126	129	finally
    //   136	143	129	finally
    //   143	155	129	finally
    //   15	23	160	finally
    //   15	23	166	java/lang/Exception
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected boolean a(Entity paramEntity)
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
  
  public boolean a(Long paramLong)
  {
    List localList = a();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      if (((PublicAccountInfo)localList.get(i)).uin == paramLong.longValue()) {
        return true;
      }
      i += 1;
    }
    paramLong = a(String.valueOf(paramLong));
    return (paramLong != null) && (paramLong.followType == 1);
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      PublicAccountInfo localPublicAccountInfo = c(paramString);
      if (localPublicAccountInfo != null) {
        return localPublicAccountInfo.isSupportQQCallAbility(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramString = a(paramString.toString());
    } while ((paramString == null) || ((paramString.accountFlag2 & 0x80) == 0L));
    return true;
  }
  
  public AccountDetail b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (AccountDetail)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      }
    }
    return (AccountDetail)localObject1;
  }
  
  public PublicAccountInfo b(String paramString)
  {
    PublicAccountInfo localPublicAccountInfo = null;
    Object localObject = localPublicAccountInfo;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = localPublicAccountInfo;
      if (paramString != null)
      {
        localPublicAccountInfo = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localPublicAccountInfo;
        if (localPublicAccountInfo == null)
        {
          localObject = localPublicAccountInfo;
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
          {
            paramString = (PublicAccountInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PublicAccountInfo.class, paramString);
            localObject = paramString;
            if (paramString != null)
            {
              localObject = paramString;
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
              {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getUin(), paramString);
                localObject = paramString;
              }
            }
          }
        }
      }
    }
    return (PublicAccountInfo)localObject;
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.pub", 2, "buildPublicAccountUI begin");
        }
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          break label256;
        }
        int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
        ArrayList localArrayList1 = new ArrayList(i);
        localArrayList2 = new ArrayList(i);
        localArrayList3 = new ArrayList(i);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Entity localEntity = (Entity)localIterator.next();
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localEntity;
        if ((localPublicAccountInfo.mCompareSpell == null) || (localPublicAccountInfo.mCompareSpell.length() == 0)) {
          ContactSorter.a(localPublicAccountInfo);
        }
        if (localPublicAccountInfo.hasIvrAbility()) {
          localArrayList2.add(localEntity);
        } else {
          localArrayList3.add(localEntity);
        }
      }
      finally {}
    }
    if (localArrayList2.size() > 0)
    {
      if (localArrayList2.size() > 1) {
        Collections.sort(localArrayList2, ContactSorter.a);
      }
      localList.addAll(localArrayList2);
    }
    if (localArrayList3.size() > 0)
    {
      if (localArrayList3.size() > 1) {
        Collections.sort(localArrayList3, ContactSorter.a);
      }
      localList.addAll(localArrayList3);
    }
    this.jdField_a_of_type_JavaUtilArrayList = localList;
    if (localList.size() > 1) {
      Collections.sort(localList, ContactSorter.a);
    }
    this.jdField_b_of_type_JavaUtilArrayList = localList;
    PAOfflineSearchManager.a().jdField_a_of_type_Boolean = true;
    label256:
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "buildPublicAccountUI end: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    a(paramAccountDetail.uin);
  }
  
  public void b(PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramPublicAccountInfo == null) {
      return;
    }
    b(paramPublicAccountInfo.getUin());
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    PublicAccountInfo localPublicAccountInfo = b(paramString);
    if (localPublicAccountInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPublicAccountInfo);
    }
    b();
  }
  
  public boolean b()
  {
    Object localObject = e();
    if ((localObject == null) || (((ArrayList)localObject).size() < PublicAccountConfigUtil.j)) {}
    long l1;
    do
    {
      return false;
      Collections.sort((List)localObject, new qdl(this));
      long l3 = PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis()) / PublicAccountConfigUtil.c;
      localObject = ((ArrayList)localObject).iterator();
      l1 = 0L;
      int i = 0;
      while (i < PublicAccountConfigUtil.j)
      {
        long l2 = l1;
        if (l3 - PublicAccountUtil.b(((PublicAccountInfo)((Iterator)localObject).next()).lastAIOReadTime) / PublicAccountConfigUtil.c >= PublicAccountConfigUtil.k) {
          l2 = l1 + 1L;
        }
        i += 1;
        l1 = l2;
      }
    } while (l1 < PublicAccountConfigUtil.j);
    return true;
  }
  
  public boolean b(Long paramLong)
  {
    List localList = a();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      if ((((PublicAccountInfo)localList.get(i)).uin == paramLong.longValue()) && (((PublicAccountInfo)localList.get(i)).isShieldMsg)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    label59:
    for (;;)
    {
      return false;
      PublicAccountInfo localPublicAccountInfo = b(paramString);
      if (localPublicAccountInfo != null) {}
      for (long l = localPublicAccountInfo.accountFlag2;; l = paramString.accountFlag2)
      {
        if ((l & 0x100) == 0L) {
          break label59;
        }
        return true;
        paramString = a(paramString.toString());
        if (paramString == null) {
          break;
        }
      }
    }
  }
  
  public PublicAccountInfo c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    return (PublicAccountInfo)localObject1;
  }
  
  public ArrayList c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localIterator.next();
        if (PublicAccountUtil.a(localPublicAccountInfo.accountFlag, localPublicAccountInfo.accountFlag2)) {
          localArrayList.add(localPublicAccountInfo);
        }
      }
      return localArrayList;
    }
    return new ArrayList(0);
  }
  
  public void c()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicAccountCache begin");
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PublicAccountInfo.class, false, "showFlag=?", new String[] { String.valueOf(1) }, null, null, null, null);
    if (localObject2 != null) {}
    ArrayList localArrayList;
    for (int i = ((List)localObject2).size();; i = 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label296;
      }
      localArrayList = new ArrayList();
      long l = NetConnInfoCenter.getServerTimeMillis();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject2).next();
        if (localPublicAccountInfo.isNeedShow())
        {
          if ((!PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!TextUtils.equals(localPublicAccountInfo.getUin(), AppConstants.aY))) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
          }
        }
        else
        {
          if ((localPublicAccountInfo.mCompareSpell == null) || (localPublicAccountInfo.mCompareSpell.length() == 0))
          {
            ContactSorter.a(localPublicAccountInfo);
            localArrayList.add(localPublicAccountInfo);
          }
          if (localPublicAccountInfo.lastAIOReadTime <= 0L)
          {
            if (localArrayList.contains(localPublicAccountInfo)) {
              localArrayList.remove(localPublicAccountInfo);
            }
            localPublicAccountInfo.lastAIOReadTime = l;
            localArrayList.add(localPublicAccountInfo);
          }
        }
      }
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
    label296:
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicAccountCache end: " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (b(paramString) != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      b();
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!PublicAccountConfigUtil.d) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    Object localObject = e();
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    long l1 = PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis()) / PublicAccountConfigUtil.c;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    long l2;
    int i3;
    int i4;
    int i5;
    if (((Iterator)localObject).hasNext())
    {
      l2 = l1 - PublicAccountUtil.b(((PublicAccountInfo)((Iterator)localObject).next()).lastAIOReadTime) / PublicAccountConfigUtil.c;
      if ((0L <= l2) && (l2 <= 10L))
      {
        i3 = i2;
        i4 = i1;
        i5 = n;
        i2 = i + 1;
        i1 = j;
        n = k;
        k = i5;
        j = i4;
        i = i3;
      }
    }
    for (;;)
    {
      i3 = i2;
      i4 = i1;
      i5 = n;
      i2 = i;
      i1 = j;
      n = k;
      k = i5;
      j = i4;
      i = i3;
      break;
      if ((11L <= l2) && (l2 <= 20L))
      {
        i3 = k;
        i5 = j + 1;
        i4 = i;
        i = i2;
        j = i1;
        k = n;
        n = i3;
        i1 = i5;
        i2 = i4;
      }
      else if ((21L <= l2) && (l2 <= 30L))
      {
        i5 = k + 1;
        i3 = j;
        i4 = i;
        i = i2;
        j = i1;
        k = n;
        n = i5;
        i1 = i3;
        i2 = i4;
      }
      else if ((31L <= l2) && (l2 <= 50L))
      {
        m += 1;
        i3 = k;
        i4 = j;
        i5 = i;
        i = i2;
        j = i1;
        k = n;
        n = i3;
        i1 = i4;
        i2 = i5;
      }
      else if ((51L <= l2) && (l2 <= 70L))
      {
        i5 = n + 1;
        n = k;
        i3 = j;
        i4 = i;
        i = i2;
        j = i1;
        k = i5;
        i1 = i3;
        i2 = i4;
      }
      else if ((71L <= l2) && (l2 <= 100L))
      {
        i5 = i1 + 1;
        i1 = k;
        i3 = j;
        i4 = i;
        i = i2;
        j = i5;
        k = n;
        n = i1;
        i1 = i3;
        i2 = i4;
      }
      else if (101L <= l2)
      {
        i5 = i2 + 1;
        i2 = k;
        i3 = j;
        i4 = i;
        i = i5;
        j = i1;
        k = n;
        n = i2;
        i1 = i3;
        i2 = i4;
        continue;
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("0-10", i);
          ((JSONObject)localObject).put("11-20", j);
          ((JSONObject)localObject).put("21-30", k);
          ((JSONObject)localObject).put("31-50", m);
          ((JSONObject)localObject).put("51-70", n);
          ((JSONObject)localObject).put("71-100", i1);
          ((JSONObject)localObject).put("101+", i2);
          localObject = ((JSONObject)localObject).toString();
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.pub", 2, "reportUnreadDayCount->json:" + (String)localObject);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X800679C", "0X800679C", 0, 0, (String)localObject, "", "", "");
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      else
      {
        i3 = k;
        i4 = j;
        i5 = i;
        i = i2;
        j = i1;
        k = n;
        n = i3;
        i1 = i4;
        i2 = i5;
      }
    }
  }
  
  public ArrayList d()
  {
    return this.c;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initAccountDetailCache begin");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(AccountDetail.class);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AccountDetail localAccountDetail = (AccountDetail)((Iterator)localObject).next();
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localAccountDetail.uin, localAccountDetail);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initAccountDetailCache end: " + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size());
    }
  }
  
  public ArrayList e()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((localPublicAccountInfo.extendType != 2) && (c(localPublicAccountInfo.getUin()))) {
          localArrayList.add(localPublicAccountInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicRecommendAccountCache begin");
    }
    this.c = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PublicRecommendAccountInfo.class));
    if ((QLog.isColorLevel()) && (this.c != null)) {
      QLog.d("Q.contacttab.pub", 2, "initPublicRecommendAccountCache end: " + this.c.size());
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PublicAccountDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */