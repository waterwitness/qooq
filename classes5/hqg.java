import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hqg
  implements Runnable
{
  public hqg(PublicAccountManager paramPublicAccountManager, String paramString, QQAppInterface paramQQAppInterface, PublicAccountManager.InitDoneObserver paramInitDoneObserver, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 16	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   7: getfield 43	com/tencent/biz/pubaccount/PublicAccountManager:c	Ljava/util/Map;
    //   10: aload_0
    //   11: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokeinterface 49 2 0
    //   19: ifne +257 -> 276
    //   22: aload_0
    //   23: getfield 20	hqg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   29: invokevirtual 60	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: ldc 62
    //   34: aload_0
    //   35: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 67	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   41: checkcast 62	com/tencent/mobileqq/data/PublicAccountMenuEntity
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +198 -> 244
    //   49: new 69	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse
    //   52: dup
    //   53: invokespecial 70	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_2
    //   59: getfield 74	com/tencent/mobileqq/data/PublicAccountMenuEntity:data	[B
    //   62: invokevirtual 78	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   65: pop
    //   66: aload_1
    //   67: ifnull +167 -> 234
    //   70: aload_1
    //   71: getfield 82	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:button_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: invokevirtual 88	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   77: ifeq +157 -> 234
    //   80: aload_1
    //   81: getfield 82	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:button_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 92	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: astore_3
    //   88: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +33 -> 124
    //   94: ldc 99
    //   96: iconst_2
    //   97: new 101	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   104: ldc 104
    //   106: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokeinterface 114 1 0
    //   115: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_2
    //   125: getfield 129	com/tencent/mobileqq/data/PublicAccountMenuEntity:savedDateTime	J
    //   128: lstore 6
    //   130: aload_2
    //   131: getfield 133	com/tencent/mobileqq/data/PublicAccountMenuEntity:seqno	I
    //   134: istore 5
    //   136: aload_0
    //   137: getfield 16	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   140: getfield 135	com/tencent/biz/pubaccount/PublicAccountManager:a	Ljava/util/Map;
    //   143: aload_0
    //   144: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: lload 6
    //   149: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   152: invokeinterface 145 3 0
    //   157: pop
    //   158: aload_0
    //   159: getfield 16	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   162: aload_0
    //   163: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   166: iload 5
    //   168: invokevirtual 148	com/tencent/biz/pubaccount/PublicAccountManager:a	(Ljava/lang/String;I)V
    //   171: aload_0
    //   172: getfield 16	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   175: getfield 43	com/tencent/biz/pubaccount/PublicAccountManager:c	Ljava/util/Map;
    //   178: aload_0
    //   179: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   182: aload_3
    //   183: invokeinterface 145 3 0
    //   188: pop
    //   189: aload_0
    //   190: getfield 16	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   193: getfield 151	com/tencent/biz/pubaccount/PublicAccountManager:d	Ljava/util/Map;
    //   196: astore_2
    //   197: aload_0
    //   198: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: astore_3
    //   202: aload_1
    //   203: getfield 155	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:menu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   206: invokevirtual 158	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   209: ifeq +12 -> 221
    //   212: aload_1
    //   213: getfield 155	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:menu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   216: invokevirtual 160	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   219: istore 4
    //   221: aload_2
    //   222: aload_3
    //   223: iload 4
    //   225: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: invokeinterface 145 3 0
    //   233: pop
    //   234: aload_0
    //   235: getfield 22	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$InitDoneObserver	Lcom/tencent/biz/pubaccount/PublicAccountManager$InitDoneObserver;
    //   238: invokeinterface 169 1 0
    //   243: return
    //   244: new 171	hqh
    //   247: dup
    //   248: aload_0
    //   249: invokespecial 174	hqh:<init>	(Lhqg;)V
    //   252: astore_1
    //   253: aload_0
    //   254: getfield 16	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   257: aload_0
    //   258: getfield 24	hqg:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   261: aload_0
    //   262: getfield 20	hqg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   265: aload_0
    //   266: getfield 18	hqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   269: aload_1
    //   270: iconst_0
    //   271: invokevirtual 177	com/tencent/biz/pubaccount/PublicAccountManager:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lmqq/observer/BusinessObserver;Z)Lmqq/app/NewIntent;
    //   274: pop
    //   275: return
    //   276: aload_0
    //   277: getfield 22	hqg:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$InitDoneObserver	Lcom/tencent/biz/pubaccount/PublicAccountManager$InitDoneObserver;
    //   280: invokeinterface 169 1 0
    //   285: return
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_1
    //   289: goto -223 -> 66
    //   292: astore_3
    //   293: goto -227 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	hqg
    //   56	214	1	localObject1	Object
    //   286	1	1	localException1	Exception
    //   288	1	1	localObject2	Object
    //   44	178	2	localObject3	Object
    //   87	136	3	localObject4	Object
    //   292	1	3	localException2	Exception
    //   1	223	4	i	int
    //   134	33	5	j	int
    //   128	20	6	l	long
    // Exception table:
    //   from	to	target	type
    //   49	57	286	java/lang/Exception
    //   57	66	292	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */