package com.tencent.mobileqq.app.message;

import android.util.Pair;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import qlr;

public class HCTopicMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static final String c = "HCTopicMsgProc";
  public Comparator b;
  
  public HCTopicMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new qlr(this);
  }
  
  private ArrayList a(ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HCTopicMsgProc", new Object[] { "<---groupMsgRecordHandle_PB", paramString, Integer.valueOf(paramArrayList.size()) });
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    PBDecodeContext localPBDecodeContext = new PBDecodeContext();
    localPBDecodeContext.jdField_e_of_type_Long = Long.valueOf(paramString).longValue();
    localPBDecodeContext.d = 1026;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramString = (msg_comm.Msg)paramArrayList.next();
      if (paramString != null)
      {
        localArrayList1.clear();
        Object localObject = (msg_comm.MsgHead)paramString.msg_head.get();
        long l = ((msg_comm.MsgHead)localObject).msg_uid.get();
        localPBDecodeContext.jdField_e_of_type_Int = ((msg_comm.GroupInfo)((msg_comm.MsgHead)localObject).group_info.get()).group_type.get();
        try
        {
          a(paramString, localArrayList1, localPBDecodeContext, false, null);
          if (localArrayList1.size() != 0)
          {
            MessageHandlerUtils.a(localArrayList1);
            if (localArrayList1.size() > 0)
            {
              paramString = localArrayList1.iterator();
              while (paramString.hasNext())
              {
                localObject = (MessageRecord)paramString.next();
                if (((MessageRecord)localObject).msgUid == 0L) {
                  ((MessageRecord)localObject).msgUid = l;
                }
              }
            }
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramString);
            }
          }
          localArrayList2.addAll(localArrayList1);
        }
      }
    }
    a(localArrayList2);
    localArrayList1.clear();
    a(localArrayList2, localArrayList1, true);
    return localArrayList1;
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---HCTopicMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("HCTopicMsgProc", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+27->28, 1001:+28->29, 1002:+95->96, 1003:+95->96
    //   28: return
    //   29: aload_2
    //   30: iconst_0
    //   31: aaload
    //   32: checkcast 97	msf/msgcomm/msg_comm$Msg
    //   35: astore_3
    //   36: aload_2
    //   37: iconst_1
    //   38: aaload
    //   39: checkcast 216	java/lang/String
    //   42: astore_2
    //   43: aload_3
    //   44: getfield 220	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   47: iconst_0
    //   48: invokevirtual 226	msf/msgcomm/msg_comm$AppShareInfo:setHasFlag	(Z)V
    //   51: iconst_1
    //   52: istore 7
    //   54: iload 7
    //   56: ifeq +27 -> 83
    //   59: aload_0
    //   60: aload_3
    //   61: aload_2
    //   62: invokevirtual 229	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/lang/String;)V
    //   65: return
    //   66: astore 4
    //   68: aconst_null
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: aload 4
    //   74: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   77: iconst_0
    //   78: istore 7
    //   80: goto -26 -> 54
    //   83: aload_0
    //   84: aload_0
    //   85: invokevirtual 236	java/lang/Object:getClass	()Ljava/lang/Class;
    //   88: invokevirtual 241	java/lang/Class:getName	()Ljava/lang/String;
    //   91: iload_1
    //   92: invokevirtual 244	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Ljava/lang/String;I)V
    //   95: return
    //   96: lconst_0
    //   97: lstore 8
    //   99: new 34	java/util/ArrayList
    //   102: dup
    //   103: invokespecial 62	java/util/ArrayList:<init>	()V
    //   106: astore_3
    //   107: aload_0
    //   108: aload_2
    //   109: iconst_0
    //   110: aaload
    //   111: checkcast 34	java/util/ArrayList
    //   114: aload_3
    //   115: invokespecial 246	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Ljava/util/List;Ljava/util/List;)V
    //   118: aload_2
    //   119: iconst_1
    //   120: aaload
    //   121: checkcast 216	java/lang/String
    //   124: astore 4
    //   126: aload_2
    //   127: iconst_2
    //   128: aaload
    //   129: checkcast 216	java/lang/String
    //   132: astore 6
    //   134: aload_2
    //   135: iconst_3
    //   136: aaload
    //   137: checkcast 67	java/lang/Long
    //   140: invokevirtual 74	java/lang/Long:longValue	()J
    //   143: lstore 10
    //   145: lload 10
    //   147: lstore 8
    //   149: iconst_1
    //   150: istore 12
    //   152: aload 6
    //   154: astore 5
    //   156: aload 4
    //   158: astore_2
    //   159: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +53 -> 215
    //   165: ldc 8
    //   167: bipush 6
    //   169: anewarray 46	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: ldc -8
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: iload 12
    //   181: invokestatic 251	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: aload_2
    //   188: aastore
    //   189: dup
    //   190: iconst_3
    //   191: aload 5
    //   193: aastore
    //   194: dup
    //   195: iconst_4
    //   196: lload 8
    //   198: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: dup
    //   203: iconst_5
    //   204: aload_3
    //   205: invokevirtual 38	java/util/ArrayList:size	()I
    //   208: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: aastore
    //   212: invokestatic 59	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: iload 12
    //   217: ifeq +56 -> 273
    //   220: iload_1
    //   221: sipush 1002
    //   224: if_icmpne +43 -> 267
    //   227: iconst_1
    //   228: istore 12
    //   230: aload_0
    //   231: iload 12
    //   233: aload_2
    //   234: aload_3
    //   235: aload 5
    //   237: lload 8
    //   239: invokevirtual 257	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;J)V
    //   242: return
    //   243: astore 5
    //   245: aconst_null
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_3
    //   250: aconst_null
    //   251: astore_2
    //   252: aload 5
    //   254: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   257: iconst_0
    //   258: istore 12
    //   260: aload 4
    //   262: astore 5
    //   264: goto -105 -> 159
    //   267: iconst_0
    //   268: istore 12
    //   270: goto -40 -> 230
    //   273: aload_0
    //   274: aload_0
    //   275: invokevirtual 236	java/lang/Object:getClass	()Ljava/lang/Class;
    //   278: invokevirtual 241	java/lang/Class:getName	()Ljava/lang/String;
    //   281: iload_1
    //   282: invokevirtual 244	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Ljava/lang/String;I)V
    //   285: return
    //   286: astore 5
    //   288: aconst_null
    //   289: astore 4
    //   291: aconst_null
    //   292: astore_2
    //   293: goto -41 -> 252
    //   296: astore 5
    //   298: aconst_null
    //   299: astore 6
    //   301: aload 4
    //   303: astore_2
    //   304: aload 6
    //   306: astore 4
    //   308: goto -56 -> 252
    //   311: astore 5
    //   313: aload 4
    //   315: astore_2
    //   316: aload 6
    //   318: astore 4
    //   320: goto -68 -> 252
    //   323: astore 4
    //   325: aconst_null
    //   326: astore_2
    //   327: goto -255 -> 72
    //   330: astore 4
    //   332: goto -260 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	HCTopicMessageProcessor
    //   0	335	1	paramInt	int
    //   0	335	2	paramVarArgs	Object[]
    //   35	215	3	localObject1	Object
    //   66	7	4	localException1	Exception
    //   124	195	4	localObject2	Object
    //   323	1	4	localException2	Exception
    //   330	1	4	localException3	Exception
    //   154	82	5	str1	String
    //   243	10	5	localException4	Exception
    //   262	1	5	localObject3	Object
    //   286	1	5	localException5	Exception
    //   296	1	5	localException6	Exception
    //   311	1	5	localException7	Exception
    //   132	185	6	str2	String
    //   52	27	7	i	int
    //   97	141	8	l1	long
    //   143	3	10	l2	long
    //   150	119	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	36	66	java/lang/Exception
    //   99	107	243	java/lang/Exception
    //   107	126	286	java/lang/Exception
    //   126	134	296	java/lang/Exception
    //   134	145	311	java/lang/Exception
    //   36	43	323	java/lang/Exception
    //   43	51	330	java/lang/Exception
  }
  
  protected void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        PttShowRoomMng localPttShowRoomMng = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(true).a(true);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localPttShowRoomMng.a((MessageRecord)paramList.next());
        }
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  protected void a(msg_comm.Msg paramMsg, String paramString)
  {
    NearbyUtils.a("HCTopicMsgProc", "processPush", new Object[] { paramString, paramMsg });
    if ((paramMsg == null) || (!paramMsg.msg_head.has())) {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HCTopicMsgProc", new Object[] { "processPush invalidate params" });
      }
    }
    Object localObject1;
    Object localObject2;
    long l1;
    int j;
    long l4;
    int i;
    for (;;)
    {
      return;
      localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (!((msg_comm.MsgHead)localObject1).group_info.has())
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("HCTopicMsgProc", new Object[] { "<---handleMsgPush_PB_Group: no groupInfo." });
        }
      }
      else
      {
        localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
        l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
        long l3 = ((msg_comm.GroupInfo)localObject2).group_code.get();
        j = ((msg_comm.GroupInfo)localObject2).group_type.get();
        l4 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
        if (l3 != 0L) {
          paramString = String.valueOf(l3);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((MessageCacheItem)localObject1).a(paramString) == 2) {}
        for (i = 1; i == 0; i = 0)
        {
          ((MessageCacheItem)localObject1).a(paramString, new Object[] { paramMsg, paramString });
          return;
        }
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = new PBDecodeContext();
        ((PBDecodeContext)localObject3).jdField_e_of_type_Long = l3;
        ((PBDecodeContext)localObject3).d = 1026;
        ((PBDecodeContext)localObject3).jdField_e_of_type_Int = j;
        try
        {
          a(paramMsg, (ArrayList)localObject2, (PBDecodeContext)localObject3, false, null);
          a((List)localObject2);
          MessageHandlerUtils.a((List)localObject2);
          if (((ArrayList)localObject2).size() == 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HCTopicMsgProc", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
            }
          }
          i = 0;
          while (i < ((ArrayList)localObject2).size())
          {
            paramMsg = (MessageRecord)((ArrayList)localObject2).get(i);
            if ((paramMsg != null) && (paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
              a(paramMsg);
            }
            i += 1;
          }
          a((ArrayList)localObject2, localArrayList, true);
          ((ArrayList)localObject2).clear();
          int k = localArrayList.size();
          i = 0;
          if (i < k)
          {
            paramMsg = (MessageRecord)localArrayList.get(i);
            if (paramMsg.msgUid == 0L) {
              paramMsg.msgUid = l2;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
              ((StringBuilder)localObject3).append("mr.senderuin:").append(paramMsg.senderuin).append(" mr.msgtype:").append(paramMsg.msgtype).append(" mr.msgUid:").append(paramMsg.msgUid).append(" mr.frienduin:").append(paramMsg.frienduin).append(" mr.shmsgseq:").append(paramMsg.shmsgseq).append(" mr.time:").append(paramMsg.time).append(" mr.msg:").append(paramMsg.getLogColorContent());
              QLog.d("HCTopicMsgProc", 2, ((StringBuilder)localObject3).toString());
            }
            if ((paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
              if (!a(paramMsg)) {}
            }
            for (;;)
            {
              i += 1;
              break;
              paramMsg.isread = true;
              paramMsg.issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMsg.frienduin, 1026, paramMsg.shmsgseq);
              ((ArrayList)localObject2).add(paramMsg);
            }
          }
          bool = MessageHandlerUtils.a((ArrayList)localObject2);
          MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
          i = MsgProxyUtils.a((List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (!bool) {
            break label800;
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {}
    label800:
    for (boolean bool = true;; bool = false)
    {
      paramMsg.a((ArrayList)localObject2, String.valueOf(l4), bool);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        HotChatUtil.a((MessageCacheItem)localObject1, l1, paramString, 1);
        ((MessageCacheItem)localObject1).a(1, paramString, l1, 2);
      }
      if (j == 127) {
        break;
      }
      a("handleMsgPush_PB_Group", true, i, false, false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, ArrayList paramArrayList, String paramString2, long paramLong)
  {
    if (paramArrayList != null)
    {
      paramString2 = Integer.valueOf(paramArrayList.size());
      NearbyUtils.a("HCTopicMsgProc", "processGetMsgs", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
      if (paramArrayList == null) {
        break label599;
      }
    }
    label119:
    label503:
    label599:
    for (paramArrayList = a(paramArrayList, paramString1);; paramArrayList = null)
    {
      long l2 = Long.MIN_VALUE;
      long l1 = Long.MAX_VALUE;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
      MessageCacheItem localMessageCacheItem = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      int i;
      int j;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        Collections.sort(paramArrayList, this.b);
        paramString2 = new ArrayList();
        i = paramArrayList.size() - 1;
        Object localObject;
        long l3;
        if (i >= 0)
        {
          localObject = (MessageRecord)paramArrayList.get(i);
          l3 = l2;
          if (l2 < ((MessageRecord)localObject).shmsgseq) {
            l3 = ((MessageRecord)localObject).shmsgseq;
          }
          l2 = l1;
          if (l1 > ((MessageRecord)localObject).shmsgseq) {
            l2 = ((MessageRecord)localObject).shmsgseq;
          }
          if ((((MessageRecord)localObject).senderuin != null) && (((MessageRecord)localObject).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (a((MessageRecord)localObject))) {}
          for (;;)
          {
            i -= 1;
            l1 = l2;
            l2 = l3;
            break label119;
            paramString2 = "null";
            break;
            paramString2.add(0, localObject);
          }
        }
        if (paramString2.size() > 0)
        {
          l3 = localMessageCacheItem.a(2, paramString1);
          paramArrayList = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1026);
          localObject = paramString2.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (localMessageRecord != null)
            {
              if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
              {
                localMessageRecord.isread = true;
                localMessageRecord.issend = 2;
              }
              if (l3 >= localMessageRecord.shmsgseq) {
                localMessageRecord.isread = true;
              }
            }
          }
          paramBoolean = MessageHandlerUtils.a(paramString2);
          j = MsgProxyUtils.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
          {
            paramBoolean = true;
            ((QQMessageFacade)localObject).a(paramString2, str, paramBoolean, false);
            paramArrayList.c(paramString1, 1026, l3);
            paramArrayList.a(paramString1, paramString2);
            if (l2 != Long.MIN_VALUE) {
              HotChatUtil.a(localMessageCacheItem, l2, paramString1, 3);
            }
            if (l1 != Long.MAX_VALUE)
            {
              localMessageCacheItem.a(1, paramString1, l1, 2);
              if (paramLong == 0L) {
                localMessageCacheItem.a(3, paramString1, l1, 1);
              }
            }
            i = 0;
            paramArrayList = paramString2;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) && (localMessageCacheItem.a(paramString1) == 1))
        {
          paramLong = localMessageCacheItem.a(2, paramString1);
          ((BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1026)).c(paramString1, 1026, paramLong);
        }
        a("processGetMsgs", true, j, false, false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
        return;
        paramBoolean = false;
        break;
        i = 1;
        j = 0;
        break label503;
        i = 1;
        j = 0;
      }
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, 1026, paramMessageRecord);
    if (localMessageRecord != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord)) {
        a(localMessageRecord);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.frienduin, 1026, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(), paramMessageRecord.shmsgseq, paramMessageRecord.frienduin, 2);
      bool = true;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\HCTopicMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */