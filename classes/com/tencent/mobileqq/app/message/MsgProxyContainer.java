package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import java.util.concurrent.ConcurrentHashMap;

public class MsgProxyContainer
  extends BaseProxy
{
  static final String jdField_a_of_type_JavaLangString = "Q.msg.BaseMsgProxyContainer";
  private MsgProxy jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy;
  private TroopAndDiscMsgProxy jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy;
  private volatile boolean jdField_a_of_type_Boolean;
  private TroopAndDiscMsgProxy b;
  private TroopAndDiscMsgProxy c;
  
  public MsgProxyContainer(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy = new MsgProxy(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy = new TroopAndDiscMsgProxy(paramQQAppInterface, paramProxyManager);
    this.b = new TroopAndDiscMsgProxy(paramQQAppInterface, paramProxyManager);
    this.c = new TroopAndDiscMsgProxy(paramQQAppInterface, paramProxyManager);
  }
  
  public MsgProxy a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy;
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy;
    case 3000: 
      return this.b;
    }
    return this.c;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 43	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_Boolean	Z
    //   7: ifne +556 -> 563
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 43	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_Boolean	Z
    //   16: ifne +219 -> 235
    //   19: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   22: lstore 8
    //   24: aload_0
    //   25: getfield 32	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy	Lcom/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy;
    //   28: invokevirtual 51	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:a	()V
    //   31: aload_0
    //   32: getfield 34	com/tencent/mobileqq/app/message/MsgProxyContainer:b	Lcom/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy;
    //   35: invokevirtual 51	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:a	()V
    //   38: aload_0
    //   39: getfield 27	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy	Lcom/tencent/mobileqq/app/message/MsgProxy;
    //   42: invokevirtual 52	com/tencent/mobileqq/app/message/MsgProxy:a	()V
    //   45: aload_0
    //   46: getfield 36	com/tencent/mobileqq/app/message/MsgProxyContainer:c	Lcom/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy;
    //   49: invokevirtual 51	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:a	()V
    //   52: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +11 -> 66
    //   58: ldc 8
    //   60: iconst_2
    //   61: ldc 60
    //   63: invokestatic 64	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 67	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: bipush 17
    //   72: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   75: checkcast 75	com/tencent/mobileqq/app/proxy/ProxyManager
    //   78: invokevirtual 78	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   81: iconst_1
    //   82: invokevirtual 83	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Z)Ljava/util/List;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnonnull +6 -> 93
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +33 -> 129
    //   99: ldc 8
    //   101: iconst_2
    //   102: new 85	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   109: ldc 89
    //   111: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokeinterface 99 1 0
    //   120: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iconst_0
    //   130: istore 6
    //   132: iload 4
    //   134: istore 5
    //   136: aload_1
    //   137: invokeinterface 99 1 0
    //   142: istore 7
    //   144: iload 4
    //   146: istore 5
    //   148: iload 6
    //   150: iload 7
    //   152: if_icmpge +14 -> 166
    //   155: iload 6
    //   157: bipush 40
    //   159: if_icmplt +84 -> 243
    //   162: iload 4
    //   164: istore 5
    //   166: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   169: lstore 10
    //   171: invokestatic 114	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   174: ldc 116
    //   176: new 85	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   183: lload 10
    //   185: lload 8
    //   187: lsub
    //   188: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   191: ldc 121
    //   193: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokevirtual 124	com/tencent/util/MsgAutoMonitorUtil:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: invokestatic 114	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   205: ldc 126
    //   207: new 85	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   214: iload 5
    //   216: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc 121
    //   221: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 124	com/tencent/util/MsgAutoMonitorUtil:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_0
    //   231: iconst_1
    //   232: putfield 43	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_Boolean	Z
    //   235: aload_0
    //   236: monitorexit
    //   237: return
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    //   243: iload 4
    //   245: istore 5
    //   247: aload_1
    //   248: iload 6
    //   250: invokeinterface 130 2 0
    //   255: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   258: getfield 136	com/tencent/mobileqq/data/RecentUser:type	I
    //   261: sipush 6000
    //   264: if_icmpne +6 -> 270
    //   267: goto +297 -> 564
    //   270: iload 4
    //   272: istore 5
    //   274: aload_1
    //   275: iload 6
    //   277: invokeinterface 130 2 0
    //   282: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   285: getfield 136	com/tencent/mobileqq/data/RecentUser:type	I
    //   288: ifne +44 -> 332
    //   291: iload 4
    //   293: istore 5
    //   295: getstatic 141	com/tencent/mobileqq/app/AppConstants:aw	Ljava/lang/String;
    //   298: aload_1
    //   299: iload 6
    //   301: invokeinterface 130 2 0
    //   306: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   309: getfield 144	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   312: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +17 -> 332
    //   318: iload 4
    //   320: istore 5
    //   322: invokestatic 155	com/tencent/mobileqq/systemmsg/GroupSystemMsgController:a	()Lcom/tencent/mobileqq/systemmsg/GroupSystemMsgController;
    //   325: aload_0
    //   326: getfield 67	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   329: invokevirtual 158	com/tencent/mobileqq/systemmsg/GroupSystemMsgController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   332: iload 4
    //   334: istore 5
    //   336: aload_0
    //   337: getfield 67	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   340: invokevirtual 161	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   343: invokestatic 166	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/MsgPool;
    //   346: aload_1
    //   347: iload 6
    //   349: invokeinterface 130 2 0
    //   354: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   357: getfield 144	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   360: aload_1
    //   361: iload 6
    //   363: invokeinterface 130 2 0
    //   368: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   371: getfield 136	com/tencent/mobileqq/data/RecentUser:type	I
    //   374: invokevirtual 169	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   377: astore_2
    //   378: iload 4
    //   380: istore 5
    //   382: aload_2
    //   383: monitorenter
    //   384: iload 4
    //   386: istore 7
    //   388: aload_0
    //   389: aload_1
    //   390: iload 6
    //   392: invokeinterface 130 2 0
    //   397: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   400: getfield 136	com/tencent/mobileqq/data/RecentUser:type	I
    //   403: invokevirtual 171	com/tencent/mobileqq/app/message/MsgProxyContainer:a	(I)Lcom/tencent/mobileqq/app/message/MsgProxy;
    //   406: aload_1
    //   407: iload 6
    //   409: invokeinterface 130 2 0
    //   414: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   417: getfield 144	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   420: aload_1
    //   421: iload 6
    //   423: invokeinterface 130 2 0
    //   428: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   431: getfield 136	com/tencent/mobileqq/data/RecentUser:type	I
    //   434: invokevirtual 175	com/tencent/mobileqq/app/message/MsgProxy:g	(Ljava/lang/String;I)Ljava/util/List;
    //   437: astore_3
    //   438: aload_3
    //   439: ifnull +121 -> 560
    //   442: iload 4
    //   444: istore 7
    //   446: aload_3
    //   447: invokeinterface 178 1 0
    //   452: ifne +108 -> 560
    //   455: iload 4
    //   457: istore 7
    //   459: aload_0
    //   460: getfield 67	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   463: invokevirtual 161	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   466: invokestatic 166	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/MsgPool;
    //   469: invokevirtual 181	com/tencent/mobileqq/app/message/MsgPool:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   472: aload_1
    //   473: iload 6
    //   475: invokeinterface 130 2 0
    //   480: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   483: getfield 144	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   486: aload_1
    //   487: iload 6
    //   489: invokeinterface 130 2 0
    //   494: checkcast 132	com/tencent/mobileqq/data/RecentUser
    //   497: getfield 136	com/tencent/mobileqq/data/RecentUser:type	I
    //   500: invokestatic 186	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   503: aload_3
    //   504: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: iload 4
    //   510: istore 7
    //   512: aload_3
    //   513: invokeinterface 99 1 0
    //   518: istore 5
    //   520: iload 4
    //   522: iload 5
    //   524: iadd
    //   525: istore 4
    //   527: aload_2
    //   528: monitorexit
    //   529: goto +35 -> 564
    //   532: astore_1
    //   533: iload 4
    //   535: istore 5
    //   537: iload 5
    //   539: istore 7
    //   541: aload_2
    //   542: monitorexit
    //   543: aload_1
    //   544: athrow
    //   545: astore_1
    //   546: goto -380 -> 166
    //   549: astore_1
    //   550: aload_1
    //   551: athrow
    //   552: astore_1
    //   553: iload 7
    //   555: istore 5
    //   557: goto -20 -> 537
    //   560: goto -33 -> 527
    //   563: return
    //   564: iload 6
    //   566: iconst_1
    //   567: iadd
    //   568: istore 6
    //   570: goto -438 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	MsgProxyContainer
    //   85	52	1	localList1	java.util.List
    //   238	249	1	localObject1	Object
    //   532	12	1	localObject2	Object
    //   545	1	1	localException	Exception
    //   549	2	1	localObject3	Object
    //   552	1	1	localObject4	Object
    //   377	165	2	localObject5	Object
    //   437	76	3	localList2	java.util.List
    //   1	533	4	i	int
    //   134	422	5	j	int
    //   130	439	6	k	int
    //   142	412	7	m	int
    //   22	164	8	l1	long
    //   169	15	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   12	66	238	finally
    //   66	86	238	finally
    //   90	92	238	finally
    //   93	129	238	finally
    //   166	235	238	finally
    //   235	237	238	finally
    //   239	241	238	finally
    //   550	552	238	finally
    //   527	529	532	finally
    //   136	144	545	java/lang/Exception
    //   247	267	545	java/lang/Exception
    //   274	291	545	java/lang/Exception
    //   295	318	545	java/lang/Exception
    //   322	332	545	java/lang/Exception
    //   336	378	545	java/lang/Exception
    //   382	384	545	java/lang/Exception
    //   543	545	545	java/lang/Exception
    //   136	144	549	finally
    //   247	267	549	finally
    //   274	291	549	finally
    //   295	318	549	finally
    //   322	332	549	finally
    //   336	378	549	finally
    //   382	384	549	finally
    //   543	545	549	finally
    //   388	438	552	finally
    //   446	455	552	finally
    //   459	508	552	finally
    //   512	520	552	finally
    //   541	543	552	finally
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy.b();
    this.b.b();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy.b();
    this.c.b();
    MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().clear();
    MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\MsgProxyContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */