package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class SearchHistoryManager
  implements Manager
{
  public static final int a = 8;
  public static final String a = "search_keyword";
  public static boolean a = false;
  public static final int b = 8;
  private static final boolean b = false;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final int c;
  private final int d;
  
  public SearchHistoryManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 10000;
    this.d = 10001;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + paramQQAppInterface.a(), "");
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramString = localFriendsManager.c(paramString);
    if (paramString != null)
    {
      paramString = localFriendsManager.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_Boolean = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("search_keyword" + paramQQAppInterface.a(), paramString);
    localEditor.commit();
  }
  
  /* Error */
  public java.util.ArrayList a()
  {
    // Byte code:
    //   0: new 137	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 138	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: bipush 50
    //   14: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   17: checkcast 96	com/tencent/mobileqq/app/FriendsManager
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: bipush 51
    //   27: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   30: checkcast 140	com/tencent/mobileqq/app/TroopManager
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: iconst_0
    //   40: ldc -114
    //   42: invokevirtual 147	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: ldc -107
    //   52: aconst_null
    //   53: invokevirtual 154	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_1
    //   57: iconst_0
    //   58: istore 9
    //   60: aload_1
    //   61: ifnull +328 -> 389
    //   64: aload_1
    //   65: invokeinterface 159 1 0
    //   70: ifeq +319 -> 389
    //   73: new 142	com/tencent/mobileqq/data/SearchHistory
    //   76: dup
    //   77: invokespecial 160	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   80: astore 5
    //   82: aload 5
    //   84: aload_1
    //   85: aload_1
    //   86: ldc -94
    //   88: invokeinterface 166 2 0
    //   93: invokeinterface 169 2 0
    //   98: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   101: aload 5
    //   103: aload_1
    //   104: aload_1
    //   105: ldc -83
    //   107: invokeinterface 166 2 0
    //   112: invokeinterface 169 2 0
    //   117: putfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   120: aload 5
    //   122: aload_1
    //   123: aload_1
    //   124: ldc -79
    //   126: invokeinterface 166 2 0
    //   131: invokeinterface 169 2 0
    //   136: putfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   139: aload 5
    //   141: aload_1
    //   142: aload_1
    //   143: ldc -75
    //   145: invokeinterface 166 2 0
    //   150: invokeinterface 169 2 0
    //   155: putfield 183	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   158: aload 5
    //   160: aload_1
    //   161: aload_1
    //   162: ldc -71
    //   164: invokeinterface 166 2 0
    //   169: invokeinterface 189 2 0
    //   174: putfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   177: aload 5
    //   179: aload_1
    //   180: aload_1
    //   181: ldc -63
    //   183: invokeinterface 166 2 0
    //   188: invokeinterface 169 2 0
    //   193: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   196: aload 5
    //   198: aload_1
    //   199: aload_1
    //   200: ldc -59
    //   202: invokeinterface 166 2 0
    //   207: invokeinterface 189 2 0
    //   212: putfield 199	com/tencent/mobileqq/data/SearchHistory:count	I
    //   215: aload 5
    //   217: aload_1
    //   218: aload_1
    //   219: ldc -55
    //   221: invokeinterface 166 2 0
    //   226: invokeinterface 205 2 0
    //   231: putfield 208	com/tencent/mobileqq/data/SearchHistory:time	J
    //   234: iconst_0
    //   235: istore 8
    //   237: iconst_0
    //   238: istore 7
    //   240: aload 5
    //   242: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   245: lookupswitch	default:+433->678, 0:+156->401, 1:+251->496, 1000:+174->419, 1004:+174->419, 1008:+299->544, 1021:+440->685, 3000:+270->515, 7220:+347->592
    //   320: iload 7
    //   322: ifeq +317 -> 639
    //   325: aload_0
    //   326: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   329: ldc -114
    //   331: aload 5
    //   333: getfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   336: invokevirtual 211	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   339: checkcast 142	com/tencent/mobileqq/data/SearchHistory
    //   342: astore 5
    //   344: aload 5
    //   346: ifnull +13 -> 359
    //   349: aload_0
    //   350: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   353: aload 5
    //   355: invokevirtual 214	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   358: pop
    //   359: aload_1
    //   360: invokeinterface 217 1 0
    //   365: istore 10
    //   367: iload 10
    //   369: ifeq +20 -> 389
    //   372: iload 9
    //   374: iconst_1
    //   375: iadd
    //   376: istore 7
    //   378: iload 7
    //   380: istore 9
    //   382: iload 7
    //   384: bipush 8
    //   386: if_icmplt -313 -> 73
    //   389: aload_1
    //   390: ifnull +9 -> 399
    //   393: aload_1
    //   394: invokeinterface 220 1 0
    //   399: aload_2
    //   400: areturn
    //   401: aload_3
    //   402: aload 5
    //   404: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   407: invokevirtual 223	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   410: ifne +268 -> 678
    //   413: iconst_1
    //   414: istore 7
    //   416: goto -96 -> 320
    //   419: aload_3
    //   420: aload 5
    //   422: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   425: invokevirtual 223	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   428: ifeq +6 -> 434
    //   431: iconst_1
    //   432: istore 7
    //   434: iload 7
    //   436: istore 8
    //   438: aload 5
    //   440: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   443: sipush 1000
    //   446: if_icmpne +232 -> 678
    //   449: aload_0
    //   450: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   453: bipush 51
    //   455: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   458: checkcast 140	com/tencent/mobileqq/app/TroopManager
    //   461: astore 6
    //   463: iload 7
    //   465: istore 8
    //   467: aload 6
    //   469: aload 6
    //   471: aload 5
    //   473: getfield 183	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   476: invokevirtual 225	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   479: aload 5
    //   481: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   484: invokevirtual 228	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   487: ifnonnull +191 -> 678
    //   490: iconst_1
    //   491: istore 7
    //   493: goto -173 -> 320
    //   496: aload 4
    //   498: aload 5
    //   500: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   503: invokevirtual 231	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   506: ifnonnull +172 -> 678
    //   509: iconst_1
    //   510: istore 7
    //   512: goto -192 -> 320
    //   515: aload_0
    //   516: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   519: bipush 52
    //   521: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   524: checkcast 233	com/tencent/mobileqq/app/DiscussionManager
    //   527: aload 5
    //   529: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   532: invokevirtual 236	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   535: ifnonnull +143 -> 678
    //   538: iconst_1
    //   539: istore 7
    //   541: goto -221 -> 320
    //   544: aload 5
    //   546: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   549: getstatic 241	com/tencent/mobileqq/app/AppConstants:aZ	Ljava/lang/String;
    //   552: invokestatic 245	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   555: ifeq +136 -> 691
    //   558: aload_0
    //   559: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   562: invokestatic 250	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   565: ifeq +6 -> 571
    //   568: goto +123 -> 691
    //   571: aload 5
    //   573: aload_0
    //   574: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   577: invokestatic 253	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   580: invokestatic 258	com/tencent/biz/pubaccount/util/PublicAccountConfigUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   583: putfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   586: iconst_0
    //   587: istore 7
    //   589: goto -269 -> 320
    //   592: aload_0
    //   593: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   596: invokestatic 250	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   599: ifne +9 -> 608
    //   602: iconst_1
    //   603: istore 7
    //   605: goto -285 -> 320
    //   608: aload 5
    //   610: aload_0
    //   611: getfield 35	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   614: invokestatic 253	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   617: invokestatic 260	com/tencent/biz/pubaccount/util/PublicAccountConfigUtil:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   620: putfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   623: goto +55 -> 678
    //   626: astore_3
    //   627: aload_1
    //   628: ifnull -229 -> 399
    //   631: aload_1
    //   632: invokeinterface 220 1 0
    //   637: aload_2
    //   638: areturn
    //   639: aload_2
    //   640: aload 5
    //   642: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   645: pop
    //   646: goto -287 -> 359
    //   649: astore_3
    //   650: aload_1
    //   651: astore_2
    //   652: aload_3
    //   653: astore_1
    //   654: aload_2
    //   655: ifnull +9 -> 664
    //   658: aload_2
    //   659: invokeinterface 220 1 0
    //   664: aload_1
    //   665: athrow
    //   666: astore_1
    //   667: aconst_null
    //   668: astore_2
    //   669: goto -15 -> 654
    //   672: astore_1
    //   673: aconst_null
    //   674: astore_1
    //   675: goto -48 -> 627
    //   678: iload 8
    //   680: istore 7
    //   682: goto -362 -> 320
    //   685: iconst_1
    //   686: istore 7
    //   688: goto -368 -> 320
    //   691: iconst_1
    //   692: istore 7
    //   694: goto -374 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	SearchHistoryManager
    //   56	609	1	localObject1	Object
    //   666	1	1	localObject2	Object
    //   672	1	1	localException1	Exception
    //   674	1	1	localObject3	Object
    //   7	662	2	localObject4	Object
    //   20	400	3	localFriendsManager	FriendsManager
    //   626	1	3	localException2	Exception
    //   649	4	3	localObject5	Object
    //   33	464	4	localTroopManager1	TroopManager
    //   80	561	5	localSearchHistory	com.tencent.mobileqq.data.SearchHistory
    //   461	9	6	localTroopManager2	TroopManager
    //   238	455	7	i	int
    //   235	444	8	j	int
    //   58	323	9	k	int
    //   365	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   64	73	626	java/lang/Exception
    //   73	234	626	java/lang/Exception
    //   240	320	626	java/lang/Exception
    //   325	344	626	java/lang/Exception
    //   349	359	626	java/lang/Exception
    //   359	367	626	java/lang/Exception
    //   401	413	626	java/lang/Exception
    //   419	431	626	java/lang/Exception
    //   438	463	626	java/lang/Exception
    //   467	490	626	java/lang/Exception
    //   496	509	626	java/lang/Exception
    //   515	538	626	java/lang/Exception
    //   544	568	626	java/lang/Exception
    //   571	586	626	java/lang/Exception
    //   592	602	626	java/lang/Exception
    //   608	623	626	java/lang/Exception
    //   639	646	626	java/lang/Exception
    //   64	73	649	finally
    //   73	234	649	finally
    //   240	320	649	finally
    //   325	344	649	finally
    //   349	359	649	finally
    //   359	367	649	finally
    //   401	413	649	finally
    //   419	431	649	finally
    //   438	463	649	finally
    //   467	490	649	finally
    //   496	509	649	finally
    //   515	538	649	finally
    //   544	568	649	finally
    //   571	586	649	finally
    //   592	602	649	finally
    //   608	623	649	finally
    //   639	646	649	finally
    //   35	57	666	finally
    //   35	57	672	java/lang/Exception
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.data.SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 199	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   9: putfield 208	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+92->108, 0:+93->109, 1:+238->254, 1000:+349->365, 1004:+386->402, 1006:+312->328, 1008:+460->476, 1021:+423->439, 3000:+275->291, 7220:+510->526, 56938:+312->328
    //   108: return
    //   109: aload_1
    //   110: aload_0
    //   111: aload_1
    //   112: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   115: invokespecial 273	com/tencent/mobileqq/app/SearchHistoryManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   118: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   121: aload_1
    //   122: getfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   125: ifnonnull +10 -> 135
    //   128: aload_1
    //   129: ldc_w 275
    //   132: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   135: aload_1
    //   136: new 64	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   143: aload_1
    //   144: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   147: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: sipush 10001
    //   153: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   166: ldc -114
    //   168: aload_1
    //   169: getfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   172: invokevirtual 211	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   175: checkcast 142	com/tencent/mobileqq/data/SearchHistory
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull +383 -> 563
    //   183: aload_2
    //   184: aload_1
    //   185: getfield 208	com/tencent/mobileqq/data/SearchHistory:time	J
    //   188: putfield 208	com/tencent/mobileqq/data/SearchHistory:time	J
    //   191: aload_2
    //   192: aload_2
    //   193: getfield 199	com/tencent/mobileqq/data/SearchHistory:count	I
    //   196: iconst_1
    //   197: iadd
    //   198: putfield 199	com/tencent/mobileqq/data/SearchHistory:count	I
    //   201: aload_2
    //   202: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   205: aload_1
    //   206: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   209: if_icmpeq +35 -> 244
    //   212: aload_2
    //   213: aload_1
    //   214: getfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   217: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   220: aload_2
    //   221: aload_1
    //   222: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   225: putfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   228: aload_2
    //   229: aload_1
    //   230: getfield 183	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   233: putfield 183	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   236: aload_2
    //   237: aload_1
    //   238: getfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   241: putfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   248: aload_2
    //   249: invokevirtual 277	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   252: pop
    //   253: return
    //   254: aload_1
    //   255: ldc_w 279
    //   258: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   261: aload_1
    //   262: new 64	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   269: aload_1
    //   270: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   273: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: sipush 10000
    //   279: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   288: goto -126 -> 162
    //   291: aload_1
    //   292: ldc_w 281
    //   295: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   298: aload_1
    //   299: new 64	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   306: aload_1
    //   307: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   310: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: sipush 10000
    //   316: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   325: goto -163 -> 162
    //   328: aload_1
    //   329: ldc_w 283
    //   332: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   335: aload_1
    //   336: new 64	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   343: aload_1
    //   344: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   347: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: sipush 10001
    //   353: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   362: goto -200 -> 162
    //   365: aload_1
    //   366: ldc_w 285
    //   369: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   372: aload_1
    //   373: new 64	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   380: aload_1
    //   381: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   384: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: sipush 10001
    //   390: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   399: goto -237 -> 162
    //   402: aload_1
    //   403: ldc_w 287
    //   406: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   409: aload_1
    //   410: new 64	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   417: aload_1
    //   418: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   421: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: sipush 10001
    //   427: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   436: goto -274 -> 162
    //   439: aload_1
    //   440: ldc_w 289
    //   443: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   446: aload_1
    //   447: new 64	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   454: aload_1
    //   455: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   458: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: sipush 10001
    //   464: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   473: goto -311 -> 162
    //   476: aload_1
    //   477: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   480: getstatic 241	com/tencent/mobileqq/app/AppConstants:aZ	Ljava/lang/String;
    //   483: invokestatic 245	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   486: ifeq -324 -> 162
    //   489: aload_1
    //   490: ldc_w 291
    //   493: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   496: aload_1
    //   497: new 64	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   504: aload_1
    //   505: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   508: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: sipush 10001
    //   514: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   523: goto -361 -> 162
    //   526: aload_1
    //   527: ldc_w 291
    //   530: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   533: aload_1
    //   534: new 64	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   541: aload_1
    //   542: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   545: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: sipush 10001
    //   551: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   560: goto -398 -> 162
    //   563: aload_0
    //   564: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   567: iconst_0
    //   568: ldc -114
    //   570: invokevirtual 147	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   573: aconst_null
    //   574: aconst_null
    //   575: aconst_null
    //   576: aconst_null
    //   577: aconst_null
    //   578: ldc_w 293
    //   581: aconst_null
    //   582: invokevirtual 154	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   585: astore_3
    //   586: aload_3
    //   587: ifnull +174 -> 761
    //   590: aload_3
    //   591: astore_2
    //   592: bipush 8
    //   594: aload_3
    //   595: invokeinterface 297 1 0
    //   600: if_icmpgt +161 -> 761
    //   603: aload_3
    //   604: astore_2
    //   605: aload_3
    //   606: invokeinterface 159 1 0
    //   611: ifeq +139 -> 750
    //   614: aload_3
    //   615: astore_2
    //   616: aload_3
    //   617: aload_3
    //   618: ldc -94
    //   620: invokeinterface 166 2 0
    //   625: invokeinterface 169 2 0
    //   630: astore 4
    //   632: aload_3
    //   633: astore_2
    //   634: aload_0
    //   635: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   638: ldc -114
    //   640: aload 4
    //   642: invokevirtual 211	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   645: checkcast 142	com/tencent/mobileqq/data/SearchHistory
    //   648: astore 4
    //   650: aload_3
    //   651: astore_2
    //   652: aload 4
    //   654: aload_1
    //   655: getfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   658: putfield 171	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   661: aload_3
    //   662: astore_2
    //   663: aload 4
    //   665: aload_1
    //   666: getfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   669: putfield 179	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   672: aload_3
    //   673: astore_2
    //   674: aload 4
    //   676: aload_1
    //   677: getfield 183	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   680: putfield 183	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   683: aload_3
    //   684: astore_2
    //   685: aload 4
    //   687: aload_1
    //   688: getfield 208	com/tencent/mobileqq/data/SearchHistory:time	J
    //   691: putfield 208	com/tencent/mobileqq/data/SearchHistory:time	J
    //   694: aload_3
    //   695: astore_2
    //   696: aload 4
    //   698: aload_1
    //   699: getfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   702: putfield 175	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   705: aload_3
    //   706: astore_2
    //   707: aload 4
    //   709: aload_1
    //   710: getfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   713: putfield 191	com/tencent/mobileqq/data/SearchHistory:type	I
    //   716: aload_3
    //   717: astore_2
    //   718: aload 4
    //   720: aload_1
    //   721: getfield 199	com/tencent/mobileqq/data/SearchHistory:count	I
    //   724: putfield 199	com/tencent/mobileqq/data/SearchHistory:count	I
    //   727: aload_3
    //   728: astore_2
    //   729: aload 4
    //   731: aload_1
    //   732: getfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   735: putfield 195	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   738: aload_3
    //   739: astore_2
    //   740: aload_0
    //   741: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   744: aload 4
    //   746: invokevirtual 277	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   749: pop
    //   750: aload_3
    //   751: ifnull -643 -> 108
    //   754: aload_3
    //   755: invokeinterface 220 1 0
    //   760: return
    //   761: aload_3
    //   762: astore_2
    //   763: aload_0
    //   764: getfield 48	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   767: aload_1
    //   768: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   771: goto -21 -> 750
    //   774: astore_1
    //   775: aload_3
    //   776: astore_2
    //   777: aload_1
    //   778: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   781: aload_3
    //   782: ifnull -674 -> 108
    //   785: aload_3
    //   786: invokeinterface 220 1 0
    //   791: return
    //   792: astore_1
    //   793: aconst_null
    //   794: astore_2
    //   795: aload_2
    //   796: ifnull +9 -> 805
    //   799: aload_2
    //   800: invokeinterface 220 1 0
    //   805: aload_1
    //   806: athrow
    //   807: astore_1
    //   808: goto -13 -> 795
    //   811: astore_1
    //   812: aconst_null
    //   813: astore_3
    //   814: goto -39 -> 775
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	this	SearchHistoryManager
    //   0	817	1	paramSearchHistory	com.tencent.mobileqq.data.SearchHistory
    //   178	622	2	localObject1	Object
    //   585	229	3	localCursor	android.database.Cursor
    //   630	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   592	603	774	java/lang/Exception
    //   605	614	774	java/lang/Exception
    //   616	632	774	java/lang/Exception
    //   634	650	774	java/lang/Exception
    //   652	661	774	java/lang/Exception
    //   663	672	774	java/lang/Exception
    //   674	683	774	java/lang/Exception
    //   685	694	774	java/lang/Exception
    //   696	705	774	java/lang/Exception
    //   707	716	774	java/lang/Exception
    //   718	727	774	java/lang/Exception
    //   729	738	774	java/lang/Exception
    //   740	750	774	java/lang/Exception
    //   763	771	774	java/lang/Exception
    //   563	586	792	finally
    //   592	603	807	finally
    //   605	614	807	finally
    //   616	632	807	finally
    //   634	650	807	finally
    //   652	661	807	finally
    //   663	672	807	finally
    //   674	683	807	finally
    //   685	694	807	finally
    //   696	705	807	finally
    //   707	716	807	finally
    //   718	727	807	finally
    //   729	738	807	finally
    //   740	750	807	finally
    //   763	771	807	finally
    //   777	781	807	finally
    //   563	586	811	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SearchHistoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */