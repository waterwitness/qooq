package com.tencent.mobileqq.mixedmsg;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import teh;
import tei;
import tek;
import tel;

public class MixedMsgManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 460;
  private static final String jdField_a_of_type_JavaLangString = "MixedMsgManager";
  private static final String b;
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  public ConcurrentHashMap a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = AppConstants.bj + "fight/pic_expire.png";
  }
  
  public MixedMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 64	tencent/im/msg/im_msg_body$RichText
    //   3: dup
    //   4: invokespecial 65	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   7: astore_2
    //   8: aload 4
    //   10: getfield 71	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   13: invokeinterface 77 1 0
    //   18: istore 8
    //   20: iconst_0
    //   21: istore_3
    //   22: iload_3
    //   23: iload 8
    //   25: if_icmpge +133 -> 158
    //   28: aload 4
    //   30: getfield 71	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   33: iload_3
    //   34: invokeinterface 81 2 0
    //   39: checkcast 83	com/tencent/mobileqq/data/MessageRecord
    //   42: astore 6
    //   44: aload 6
    //   46: instanceof 85
    //   49: ifeq +67 -> 116
    //   52: aload 6
    //   54: checkcast 85	com/tencent/mobileqq/data/MessageForText
    //   57: invokestatic 90	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/data/MessageForText;)Ltencent/im/msg/im_msg_body$RichText;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnonnull +10 -> 74
    //   67: iload_3
    //   68: iconst_1
    //   69: iadd
    //   70: istore_3
    //   71: goto -49 -> 22
    //   74: iconst_0
    //   75: istore 7
    //   77: iload 7
    //   79: aload 6
    //   81: getfield 94	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 97	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   87: if_icmpge -20 -> 67
    //   90: aload_2
    //   91: getfield 94	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   94: aload 6
    //   96: getfield 94	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   99: iload 7
    //   101: invokevirtual 100	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   104: invokevirtual 104	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   107: iload 7
    //   109: iconst_1
    //   110: iadd
    //   111: istore 7
    //   113: goto -36 -> 77
    //   116: aload 6
    //   118: instanceof 106
    //   121: ifeq -54 -> 67
    //   124: aload 6
    //   126: checkcast 108	com/tencent/mobileqq/data/MessageForPic
    //   129: getfield 112	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   132: astore 6
    //   134: aload 6
    //   136: ifnull -69 -> 67
    //   139: aload_2
    //   140: getfield 94	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   143: aload 6
    //   145: getfield 94	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   148: iconst_0
    //   149: invokevirtual 100	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: invokevirtual 104	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   155: goto -88 -> 67
    //   158: aload_2
    //   159: invokevirtual 116	tencent/im/msg/im_msg_body$RichText:toByteArray	()[B
    //   162: arraylength
    //   163: istore 8
    //   165: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +29 -> 197
    //   171: ldc 12
    //   173: iconst_2
    //   174: new 26	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   181: ldc 124
    //   183: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload 8
    //   188: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 4
    //   199: iload 8
    //   201: putfield 134	com/tencent/mobileqq/data/MessageForMixedMsg:mRichTextLength	I
    //   204: sipush 460
    //   207: istore 7
    //   209: aload_1
    //   210: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   213: invokevirtual 145	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   216: invokestatic 151	com/tencent/mobileqq/utils/SharedPreUtils:g	(Landroid/content/Context;)Ljava/lang/String;
    //   219: astore_2
    //   220: iload 7
    //   222: istore_3
    //   223: aload_2
    //   224: ifnull +87 -> 311
    //   227: iload 7
    //   229: istore_3
    //   230: aload_2
    //   231: invokevirtual 156	java/lang/String:length	()I
    //   234: ifle +77 -> 311
    //   237: aload_2
    //   238: ldc -98
    //   240: invokevirtual 162	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   243: astore_2
    //   244: iload 7
    //   246: istore_3
    //   247: aload_2
    //   248: ifnull +63 -> 311
    //   251: iload 7
    //   253: istore_3
    //   254: aload_2
    //   255: arraylength
    //   256: iconst_1
    //   257: if_icmple +54 -> 311
    //   260: aload_2
    //   261: iconst_1
    //   262: aaload
    //   263: invokestatic 168	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   266: istore_3
    //   267: iload_3
    //   268: ifle +184 -> 452
    //   271: iload_3
    //   272: istore 7
    //   274: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +31 -> 308
    //   280: ldc 12
    //   282: iconst_2
    //   283: new 26	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   290: ldc -86
    //   292: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload_3
    //   296: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: iload_3
    //   306: istore 7
    //   308: iload 7
    //   310: istore_3
    //   311: iload 8
    //   313: iload_3
    //   314: if_icmpge +86 -> 400
    //   317: new 172	tej
    //   320: dup
    //   321: aload_0
    //   322: aload 4
    //   324: invokespecial 175	tej:<init>	(Lcom/tencent/mobileqq/mixedmsg/MixedMsgManager;Lcom/tencent/mobileqq/data/MessageForMixedMsg;)V
    //   327: astore_2
    //   328: aload_1
    //   329: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   332: aload 4
    //   334: aload_2
    //   335: invokevirtual 183	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   338: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +33 -> 374
    //   344: ldc 12
    //   346: iconst_2
    //   347: new 26	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   354: ldc -71
    //   356: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: iload_3
    //   360: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: ldc -69
    //   365: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: return
    //   375: astore_2
    //   376: iload 7
    //   378: istore_3
    //   379: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -71 -> 311
    //   385: ldc 12
    //   387: iconst_2
    //   388: ldc -67
    //   390: aload_2
    //   391: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: iload 7
    //   396: istore_3
    //   397: goto -86 -> 311
    //   400: aload_0
    //   401: aload 4
    //   403: aload_1
    //   404: iconst_0
    //   405: invokevirtual 196	com/tencent/mobileqq/mixedmsg/MixedMsgManager:a	(Lcom/tencent/mobileqq/data/MessageForMixedMsg;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   408: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq -37 -> 374
    //   414: ldc 12
    //   416: iconst_2
    //   417: new 26	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   424: ldc -58
    //   426: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: iload_3
    //   430: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc -56
    //   435: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: return
    //   445: astore_2
    //   446: iload_3
    //   447: istore 7
    //   449: goto -73 -> 376
    //   452: sipush 460
    //   455: istore 7
    //   457: goto -149 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	MixedMsgManager
    //   0	460	1	paramQQAppInterface	QQAppInterface
    //   0	460	2	paramString	String
    //   0	460	3	paramInt	int
    //   0	460	4	paramMessageForMixedMsg	MessageForMixedMsg
    //   0	460	5	paramBoolean	boolean
    //   42	102	6	localObject	Object
    //   75	381	7	i	int
    //   18	297	8	j	int
    // Exception table:
    //   from	to	target	type
    //   260	267	375	java/lang/NumberFormatException
    //   274	305	445	java/lang/NumberFormatException
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    PicReq localPicReq = PicBusiManager.a(8, 7);
    localPicReq.a(paramArrayList);
    localPicReq.a(new tei(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    PicBusiManager.a(localPicReq, paramQQAppInterface);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(false, paramBoolean, paramMessageForMixedMsg, paramString);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForMixedMsg paramMessageForMixedMsg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_isresend", String.valueOf(paramMessageForMixedMsg.mIsResend));
    if (!paramMessageForMixedMsg.mIsResend)
    {
      localHashMap.put("param_forwardFromUin", paramMessageForMixedMsg.mForwardFromUin);
      localHashMap.put("param_forwardFromUinType", String.valueOf(paramMessageForMixedMsg.mForwardFromIsTroop));
    }
    localHashMap.put("param_senderUin", paramMessageForMixedMsg.senderuin);
    localHashMap.put("param_toUin", paramMessageForMixedMsg.frienduin);
    localHashMap.put("param_toUinType", String.valueOf(paramMessageForMixedMsg.istroop));
    localHashMap.put("param_sendByLongStruct", String.valueOf(paramBoolean2));
    localHashMap.put("param_richTextLength", String.valueOf(paramMessageForMixedMsg.mRichTextLength));
    if (paramString != null) {
      localHashMap.put("param_errDesc", paramString);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.h = 1;
    localTransferRequest.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
    localTransferRequest.c = paramString2;
    localTransferRequest.d = paramString3;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.e = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public void a(SessionInfo paramSessionInfo, long paramLong)
  {
    Object localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null) {
      if (((ChatMessage)localObject).msgtype == 64500)
      {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
        ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
        a(paramSessionInfo, (MessageForMixedMsg)localObject, false);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        localObject = (MessageForMixedMsg)localObject;
      }
    }
    QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    paramSessionInfo = new teh(this, paramSessionInfo, paramMessageForMixedMsg, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSessionInfo);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().a(1000, false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
    }
    if ((paramMessageForMixedMsg instanceof ChatMessage)) {
      paramMessageForMixedMsg.mPendantAnimatable = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.a().a().a(paramMessageForMixedMsg);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        tek localtek = new tek(this, paramQQAppInterface, paramMessageForMixedMsg);
        paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.a(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new tel(this, paramQQAppInterface, paramMessageForMixedMsg, localtek, paramBoolean));
        if (!paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(AnonymousChatHelper.a(paramMessageRecord)));
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
  }
  
  protected void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32770;
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().a(1000, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mixedmsg\MixedMsgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */