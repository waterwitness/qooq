package com.tencent.mobileqq.troop.data;

import PushNotifyPack.GroupMsgReadedNotify;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgHelper;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import vnk;

public class TroopMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static final String c = "Q.msg.TroopMessageProcessor";
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public Comparator b;
  
  public TroopMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new vnk(this);
  }
  
  /* Error */
  private long a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 45	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 48	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 51	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   16: aload 4
    //   18: invokevirtual 61	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;)J
    //   21: lstore 14
    //   23: aload_1
    //   24: ifnonnull +6 -> 30
    //   27: lload 14
    //   29: lreturn
    //   30: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +41 -> 74
    //   36: ldc 8
    //   38: iconst_2
    //   39: new 69	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   46: ldc 72
    //   48: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 4
    //   53: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 78
    //   58: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 82	java/util/ArrayList:size	()I
    //   65: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 97	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   78: astore 6
    //   80: aload 6
    //   82: invokeinterface 102 1 0
    //   87: ifeq +678 -> 765
    //   90: aload 6
    //   92: invokeinterface 106 1 0
    //   97: checkcast 108	msf/msgcomm/msg_comm$Msg
    //   100: astore 7
    //   102: aload 7
    //   104: ifnull -24 -> 80
    //   107: aload 7
    //   109: getfield 112	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   112: invokevirtual 118	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 114	msf/msgcomm/msg_comm$MsgHead
    //   118: astore_1
    //   119: aload_1
    //   120: getfield 122	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: i2l
    //   127: lstore 16
    //   129: aload_1
    //   130: getfield 130	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   133: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   136: lstore 18
    //   138: aload_1
    //   139: getfield 138	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   142: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   145: lstore 20
    //   147: aload_1
    //   148: getfield 141	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: lstore 22
    //   156: aload_1
    //   157: getfield 144	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   160: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   163: i2l
    //   164: lstore 24
    //   166: aload_1
    //   167: getfield 147	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   170: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   173: istore 11
    //   175: aload_1
    //   176: getfield 150	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: istore 12
    //   184: aload_1
    //   185: getfield 154	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   188: invokevirtual 157	msf/msgcomm/msg_comm$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   191: checkcast 156	msf/msgcomm/msg_comm$GroupInfo
    //   194: astore_1
    //   195: aload_1
    //   196: getfield 160	msf/msgcomm/msg_comm$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   202: istore 13
    //   204: aload_1
    //   205: getfield 163	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   208: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   211: lstore 26
    //   213: aload_1
    //   214: getfield 166	msf/msgcomm/msg_comm$GroupInfo:group_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   220: lstore 28
    //   222: new 168	com/tencent/mobileqq/troop/data/MessageInfo
    //   225: dup
    //   226: invokespecial 169	com/tencent/mobileqq/troop/data/MessageInfo:<init>	()V
    //   229: astore 8
    //   231: aload_1
    //   232: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 178	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   238: ifeq +497 -> 735
    //   241: aload_1
    //   242: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   245: invokevirtual 181	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   248: ifnull +487 -> 735
    //   251: aload_1
    //   252: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 181	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 187	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: astore_1
    //   262: new 189	java/lang/String
    //   265: dup
    //   266: aload_1
    //   267: ldc -65
    //   269: invokespecial 194	java/lang/String:<init>	([BLjava/lang/String;)V
    //   272: astore_1
    //   273: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +173 -> 449
    //   279: ldc 8
    //   281: iconst_2
    //   282: new 69	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   289: ldc 72
    //   291: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 4
    //   296: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc -60
    //   301: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: lload 22
    //   306: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   309: ldc -55
    //   311: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 20
    //   316: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc -53
    //   321: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: lload 24
    //   326: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   329: ldc -51
    //   331: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: lload 16
    //   336: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc -49
    //   341: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: lload 18
    //   346: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: ldc -47
    //   351: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 11
    //   356: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc -45
    //   361: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 12
    //   366: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc -43
    //   371: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: lload 26
    //   376: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: ldc -41
    //   381: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: iload 13
    //   386: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc -39
    //   391: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: lload 28
    //   396: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: ldc -37
    //   401: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_1
    //   405: invokestatic 224	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   408: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc -30
    //   413: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 7
    //   418: getfield 230	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   421: invokevirtual 233	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   424: invokevirtual 236	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   427: ldc -18
    //   429: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 7
    //   434: getfield 242	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   437: invokevirtual 245	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   440: invokevirtual 236	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   443: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: new 45	java/util/ArrayList
    //   452: dup
    //   453: invokespecial 48	java/util/ArrayList:<init>	()V
    //   456: astore 9
    //   458: new 247	com/tencent/mobileqq/service/message/PBDecodeContext
    //   461: dup
    //   462: invokespecial 248	com/tencent/mobileqq/service/message/PBDecodeContext:<init>	()V
    //   465: astore_1
    //   466: aload_1
    //   467: aload 4
    //   469: invokestatic 254	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   472: invokevirtual 257	java/lang/Long:longValue	()J
    //   475: putfield 260	com/tencent/mobileqq/service/message/PBDecodeContext:jdField_e_of_type_Long	J
    //   478: aload_1
    //   479: iconst_1
    //   480: putfield 262	com/tencent/mobileqq/service/message/PBDecodeContext:d	I
    //   483: aload_1
    //   484: iload 13
    //   486: putfield 264	com/tencent/mobileqq/service/message/PBDecodeContext:jdField_e_of_type_Int	I
    //   489: aload 7
    //   491: getfield 268	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   494: invokevirtual 271	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   497: ifeq +112 -> 609
    //   500: aload 7
    //   502: getfield 268	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   505: invokevirtual 272	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   508: checkcast 270	msf/msgcomm/msg_comm$ContentHead
    //   511: astore 10
    //   513: aload 10
    //   515: getfield 275	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   521: istore 11
    //   523: aload 10
    //   525: getfield 278	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   528: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   531: istore 12
    //   533: aload 10
    //   535: getfield 281	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: istore 13
    //   543: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +63 -> 609
    //   549: ldc 8
    //   551: iconst_2
    //   552: new 69	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 283
    //   562: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 4
    //   567: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 285
    //   573: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload 11
    //   578: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 287
    //   584: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: iload 12
    //   589: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc_w 289
    //   595: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 13
    //   600: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   612: lstore 18
    //   614: aload_0
    //   615: aload 7
    //   617: aload 9
    //   619: aload_1
    //   620: iconst_0
    //   621: aload 8
    //   623: invokevirtual 297	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lcom/tencent/mobileqq/service/message/PBDecodeContext;ZLcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   626: astore_1
    //   627: aload_1
    //   628: ifnull +10 -> 638
    //   631: aload 5
    //   633: aload_1
    //   634: invokevirtual 301	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   637: pop
    //   638: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq +49 -> 690
    //   644: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   647: lstore 20
    //   649: ldc 8
    //   651: iconst_2
    //   652: new 69	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 303
    //   662: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 4
    //   667: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 305
    //   673: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: lload 20
    //   678: lload 18
    //   680: lsub
    //   681: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   684: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload 9
    //   692: ifnull -612 -> 80
    //   695: aload 9
    //   697: invokevirtual 82	java/util/ArrayList:size	()I
    //   700: ifeq -620 -> 80
    //   703: aload 9
    //   705: invokestatic 310	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Ljava/util/List;)V
    //   708: aload_3
    //   709: aload 9
    //   711: invokevirtual 314	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   714: pop
    //   715: lload 16
    //   717: lload 14
    //   719: lcmp
    //   720: ifle +42 -> 762
    //   723: lload 16
    //   725: lstore 14
    //   727: goto -647 -> 80
    //   730: astore_1
    //   731: aload_1
    //   732: invokevirtual 317	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   735: aconst_null
    //   736: astore_1
    //   737: goto -464 -> 273
    //   740: astore_1
    //   741: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +13 -> 757
    //   747: ldc 8
    //   749: iconst_2
    //   750: ldc_w 319
    //   753: aload_1
    //   754: invokestatic 323	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   757: aconst_null
    //   758: astore_1
    //   759: goto -132 -> 627
    //   762: goto -35 -> 727
    //   765: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   768: lstore 16
    //   770: aload_0
    //   771: getfield 51	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   774: bipush 51
    //   776: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   779: checkcast 329	com/tencent/mobileqq/app/TroopManager
    //   782: aload 5
    //   784: invokevirtual 332	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/List;)Z
    //   787: pop
    //   788: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +119 -> 910
    //   794: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   797: lstore 18
    //   799: ldc 8
    //   801: iconst_2
    //   802: new 69	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 334
    //   812: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 4
    //   817: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc_w 305
    //   823: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: lload 18
    //   828: lload 16
    //   830: lsub
    //   831: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   834: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: lload 18
    //   842: lstore 16
    //   844: aload_3
    //   845: ifnull +10 -> 855
    //   848: aload_0
    //   849: aload_3
    //   850: aload_2
    //   851: iconst_1
    //   852: invokevirtual 337	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    //   855: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   858: ifeq +49 -> 907
    //   861: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   864: lstore 18
    //   866: ldc 8
    //   868: iconst_2
    //   869: new 69	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 339
    //   879: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 4
    //   884: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: ldc_w 305
    //   890: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: lload 18
    //   895: lload 16
    //   897: lsub
    //   898: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   901: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: lload 14
    //   909: lreturn
    //   910: goto -66 -> 844
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	this	TroopMessageProcessor
    //   0	913	1	paramArrayList1	ArrayList
    //   0	913	2	paramArrayList2	ArrayList
    //   0	913	3	paramArrayList3	ArrayList
    //   0	913	4	paramString1	String
    //   0	913	5	paramString2	String
    //   78	13	6	localIterator	java.util.Iterator
    //   100	516	7	localMsg	msg_comm.Msg
    //   229	393	8	localMessageInfo	MessageInfo
    //   456	254	9	localArrayList	ArrayList
    //   511	23	10	localContentHead	msg_comm.ContentHead
    //   173	404	11	i	int
    //   182	406	12	j	int
    //   202	397	13	k	int
    //   21	887	14	l1	long
    //   127	769	16	l2	long
    //   136	758	18	l3	long
    //   145	532	20	l4	long
    //   154	151	22	l5	long
    //   164	161	24	l6	long
    //   211	164	26	l7	long
    //   220	175	28	l8	long
    // Exception table:
    //   from	to	target	type
    //   262	273	730	java/io/UnsupportedEncodingException
    //   614	627	740	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
    }
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1);
    if (paramArrayList != null) {
      l1 = a(paramArrayList, (ArrayList)localObject2, (ArrayList)localObject3, (String)localObject1, paramString);
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      long l2;
      if ((paramPbGetGroupMsgResp.result.get() == 104) && (((ArrayList)localObject2).size() == 0))
      {
        l2 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetGroupMsgResp.return_end_seq.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "initGetPullTroopMsg reply 104 !! reqEndSeq = " + l2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1, l2);
      }
      for (int j = 1;; j = 0)
      {
        paramArrayList = new StringBuilder(128);
        int i;
        label671:
        boolean bool3;
        if (((ArrayList)localObject2).size() > 0)
        {
          Collections.sort((List)localObject2, this.b);
          paramToServiceMsg = new ArrayList();
          paramPbGetGroupMsgResp = new ArrayList();
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = (MessageRecord)((ArrayList)localObject2).get(i);
            if (QLog.isColorLevel())
            {
              paramArrayList.setLength(0);
              paramArrayList.append("----------initGetPullTroopMsg update send message  mr.senderuin: ").append(((MessageRecord)localObject3).senderuin).append(" mr.msgtype: ").append(((MessageRecord)localObject3).msgtype).append(" mr.frienduin: ").append(((MessageRecord)localObject3).frienduin).append(" mr.shmsgseq: ").append(((MessageRecord)localObject3).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject3).time).append(" mr.msg: ").append(((MessageRecord)localObject3).getLogColorContent());
              QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
            }
            if (((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || ((AnonymousChatHelper.a((MessageRecord)localObject3)) && (AnonymousChatHelper.b((MessageRecord)localObject3))))
            {
              if (AnonymousChatHelper.a((MessageRecord)localObject3))
              {
                ((MessageRecord)localObject3).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                localObject4 = AnonymousChatHelper.a((MessageRecord)localObject3);
                AnonymousChatHelper.a().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).vipBubbleID, ((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_b_of_type_Int, ((AnonymousChatHelper.AnonymousExtInfo)localObject4).jdField_b_of_type_JavaLangString, ((AnonymousChatHelper.AnonymousExtInfo)localObject4).c, ((AnonymousChatHelper.AnonymousExtInfo)localObject4).a);
              }
              Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 1, (MessageRecord)localObject3);
              if (localObject4 == null) {
                break label671;
              }
              if (((localObject3 instanceof MessageForText)) && ((localObject4 instanceof MessageForText)) && (((MessageRecord)localObject3).getRepeatCount() > 0))
              {
                ((MessageRecord)localObject4).setRepeatCount(((MessageRecord)localObject3).getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.TroopMessageProcessor", 2, "<---initGetPullTroopMsg_PB ===> update findMr.repeatCount=" + ((MessageRecord)localObject3).getRepeatCount());
                }
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e()) {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject3).frienduin, 1, ((MessageRecord)localObject4).uniseq, ((MessageRecord)localObject3).shmsgseq, ((MessageRecord)localObject3).time);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, ((MessageRecord)localObject3).shmsgseq);
            }
            for (;;)
            {
              i -= 1;
              break;
              if (!paramPbGetGroupMsgResp.contains(((MessageRecord)localObject3).senderuin)) {
                paramPbGetGroupMsgResp.add(((MessageRecord)localObject3).senderuin);
              }
              paramToServiceMsg.add(0, localObject3);
            }
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramPbGetGroupMsgResp != null) && (paramPbGetGroupMsgResp.size() > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (MessageCache.a == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              MessageCache.a = new MessageCache.RegPrxyCache();
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (MessageCache.a.a == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              MessageCache.a.a = new ConcurrentHashMap();
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            MessageCache.a.a.put(localObject1, paramPbGetGroupMsgResp);
          }
          if (paramToServiceMsg.size() > 0)
          {
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramPbGetGroupMsgResp == null) {
              break label1267;
            }
            paramArrayList = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1);
            l2 = ((Long)paramPbGetGroupMsgResp[0]).longValue();
            int k = paramToServiceMsg.size();
            i = 0;
            while (i < k)
            {
              if ((((MessageRecord)paramToServiceMsg.get(i)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
              {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
                ((MessageRecord)paramToServiceMsg.get(i)).issend = 2;
              }
              if (l2 >= ((MessageRecord)paramToServiceMsg.get(i)).shmsgseq) {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
              }
              i += 1;
            }
            if (paramArrayList.a((String)localObject1, 1, paramToServiceMsg, paramString)) {
              break label1267;
            }
            bool2 = MessageHandlerUtils.a(paramToServiceMsg);
            bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
            i = MsgProxyUtils.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
            {
              bool1 = true;
              paramPbGetGroupMsgResp.a(paramToServiceMsg, paramString, bool1, false);
              paramArrayList.c((String)localObject1, 1, l2);
              paramArrayList.a((String)localObject1, paramToServiceMsg);
              bool1 = bool3;
            }
          }
        }
        for (;;)
        {
          if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1) == 1))
          {
            paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramArrayList != null)
            {
              l2 = ((Long)paramArrayList[0]).longValue();
              ((BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1)).c((String)localObject1, 1, l2);
            }
          }
          if (l1 >= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "groupMsgRecordHandle info.lGroupCode: " + (String)localObject1 + " info.lsMsgSeq: " + l1);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, l1);
          }
          bool3 = MessageHandlerUtils.b(paramToServiceMsg);
          a("initGetPullTroopMsg", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool1, bool3, paramToServiceMsg), false);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
          return;
          bool1 = false;
          break;
          j = 1;
          i = 0;
          bool1 = false;
          bool2 = false;
          continue;
          j = 1;
          paramToServiceMsg = (ToServiceMsg)localObject2;
          i = 0;
          continue;
          label1267:
          i = 0;
          bool1 = false;
          bool2 = false;
        }
      }
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 45	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 48	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: new 168	com/tencent/mobileqq/troop/data/MessageInfo
    //   12: dup
    //   13: invokespecial 169	com/tencent/mobileqq/troop/data/MessageInfo:<init>	()V
    //   16: astore 5
    //   18: aload_3
    //   19: ifnull +680 -> 699
    //   22: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 8
    //   30: iconst_2
    //   31: new 69	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 593
    //   41: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 82	java/util/ArrayList:size	()I
    //   48: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 45	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 48	java/util/ArrayList:<init>	()V
    //   64: astore 6
    //   66: aload_3
    //   67: invokevirtual 97	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   70: astore 7
    //   72: aload 7
    //   74: invokeinterface 102 1 0
    //   79: ifeq +602 -> 681
    //   82: aload 7
    //   84: invokeinterface 106 1 0
    //   89: checkcast 108	msf/msgcomm/msg_comm$Msg
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull -24 -> 72
    //   99: aload 8
    //   101: getfield 112	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   104: invokevirtual 118	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 114	msf/msgcomm/msg_comm$MsgHead
    //   110: astore_3
    //   111: aload_3
    //   112: getfield 122	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: i2l
    //   119: lstore 14
    //   121: aload_3
    //   122: getfield 130	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   125: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   128: lstore 16
    //   130: aload_3
    //   131: getfield 138	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   134: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   137: lstore 18
    //   139: aload_3
    //   140: getfield 141	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   143: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   146: lstore 20
    //   148: aload_3
    //   149: getfield 144	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   152: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   155: i2l
    //   156: lstore 22
    //   158: aload_3
    //   159: getfield 147	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   162: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   165: istore 11
    //   167: aload_3
    //   168: getfield 150	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore 12
    //   176: aload_3
    //   177: getfield 154	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   180: invokevirtual 157	msf/msgcomm/msg_comm$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   183: checkcast 156	msf/msgcomm/msg_comm$GroupInfo
    //   186: astore 9
    //   188: aload 9
    //   190: getfield 160	msf/msgcomm/msg_comm$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   193: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   196: istore 13
    //   198: aload 9
    //   200: getfield 163	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   203: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   206: lstore 24
    //   208: aload 9
    //   210: getfield 166	msf/msgcomm/msg_comm$GroupInfo:group_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: lstore 26
    //   218: aload 9
    //   220: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 178	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   226: ifeq +428 -> 654
    //   229: aload 9
    //   231: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   234: invokevirtual 181	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   237: ifnull +417 -> 654
    //   240: aload 9
    //   242: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   245: invokevirtual 181	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   248: invokevirtual 187	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   251: astore_3
    //   252: new 189	java/lang/String
    //   255: dup
    //   256: aload_3
    //   257: ldc -65
    //   259: invokespecial 194	java/lang/String:<init>	([BLjava/lang/String;)V
    //   262: astore_3
    //   263: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +181 -> 447
    //   269: ldc 8
    //   271: iconst_2
    //   272: new 69	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 595
    //   282: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: lload 20
    //   287: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   290: ldc -55
    //   292: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload 18
    //   297: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: ldc -53
    //   302: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: lload 22
    //   307: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: ldc -51
    //   312: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: lload 14
    //   317: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: ldc -49
    //   322: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: lload 16
    //   327: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   330: ldc -47
    //   332: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 11
    //   337: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc -45
    //   342: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 12
    //   347: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc -43
    //   352: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: lload 24
    //   357: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: ldc -41
    //   362: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 13
    //   367: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: ldc -39
    //   372: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 26
    //   377: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc_w 597
    //   383: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 9
    //   388: getfield 173	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   391: invokevirtual 178	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   394: invokevirtual 236	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: ldc -37
    //   399: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_3
    //   403: invokestatic 224	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   406: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc -30
    //   411: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 8
    //   416: getfield 230	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   419: invokevirtual 233	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   422: invokevirtual 236	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   425: ldc -18
    //   427: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 8
    //   432: getfield 242	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   435: invokevirtual 245	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   438: invokevirtual 236	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   441: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: new 45	java/util/ArrayList
    //   450: dup
    //   451: invokespecial 48	java/util/ArrayList:<init>	()V
    //   454: astore 9
    //   456: new 247	com/tencent/mobileqq/service/message/PBDecodeContext
    //   459: dup
    //   460: invokespecial 248	com/tencent/mobileqq/service/message/PBDecodeContext:<init>	()V
    //   463: astore_3
    //   464: aload_3
    //   465: aload_2
    //   466: getfield 356	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   469: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   472: putfield 260	com/tencent/mobileqq/service/message/PBDecodeContext:jdField_e_of_type_Long	J
    //   475: aload_3
    //   476: iconst_1
    //   477: putfield 262	com/tencent/mobileqq/service/message/PBDecodeContext:d	I
    //   480: aload_3
    //   481: iload 13
    //   483: putfield 264	com/tencent/mobileqq/service/message/PBDecodeContext:jdField_e_of_type_Int	I
    //   486: aload 8
    //   488: getfield 268	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   491: invokevirtual 271	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   494: ifeq +101 -> 595
    //   497: aload 8
    //   499: getfield 268	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   502: invokevirtual 272	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   505: checkcast 270	msf/msgcomm/msg_comm$ContentHead
    //   508: astore 10
    //   510: aload 10
    //   512: getfield 275	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   515: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   518: istore 11
    //   520: aload 10
    //   522: getfield 278	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   525: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   528: istore 12
    //   530: aload 10
    //   532: getfield 281	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   535: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   538: istore 13
    //   540: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +52 -> 595
    //   546: ldc 8
    //   548: iconst_2
    //   549: new 69	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 599
    //   559: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 11
    //   564: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc_w 287
    //   570: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: iload 12
    //   575: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: ldc_w 289
    //   581: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 13
    //   586: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload_0
    //   596: aload 8
    //   598: aload 9
    //   600: aload_3
    //   601: iconst_0
    //   602: aload 5
    //   604: invokevirtual 297	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lcom/tencent/mobileqq/service/message/PBDecodeContext;ZLcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   607: astore_3
    //   608: aload_3
    //   609: ifnull +10 -> 619
    //   612: aload 6
    //   614: aload_3
    //   615: invokevirtual 301	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: aload 9
    //   621: invokevirtual 82	java/util/ArrayList:size	()I
    //   624: ifeq -552 -> 72
    //   627: aload 9
    //   629: invokestatic 310	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Ljava/util/List;)V
    //   632: aload 4
    //   634: ifnull -562 -> 72
    //   637: aload_0
    //   638: aload 9
    //   640: aload 4
    //   642: iconst_1
    //   643: invokevirtual 337	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    //   646: goto -574 -> 72
    //   649: astore_3
    //   650: aload_3
    //   651: invokevirtual 317	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   654: aconst_null
    //   655: astore_3
    //   656: goto -393 -> 263
    //   659: astore_3
    //   660: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +13 -> 676
    //   666: ldc 8
    //   668: iconst_2
    //   669: ldc_w 319
    //   672: aload_3
    //   673: invokestatic 323	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   676: aconst_null
    //   677: astore_3
    //   678: goto -70 -> 608
    //   681: aload_0
    //   682: getfield 51	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   685: bipush 51
    //   687: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   690: checkcast 329	com/tencent/mobileqq/app/TroopManager
    //   693: aload 6
    //   695: invokevirtual 332	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/List;)Z
    //   698: pop
    //   699: aload 4
    //   701: invokevirtual 97	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   704: astore_3
    //   705: aload_3
    //   706: invokeinterface 102 1 0
    //   711: ifeq +55 -> 766
    //   714: aload_3
    //   715: invokeinterface 106 1 0
    //   720: checkcast 392	com/tencent/mobileqq/data/MessageRecord
    //   723: astore 6
    //   725: aload 6
    //   727: getfield 400	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   730: ifnull +27 -> 757
    //   733: aload 6
    //   735: getfield 400	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   738: aload_0
    //   739: getfield 51	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   742: invokevirtual 427	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   745: invokevirtual 538	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   748: ifeq +9 -> 757
    //   751: aload 6
    //   753: iconst_2
    //   754: putfield 544	com/tencent/mobileqq/data/MessageRecord:issend	I
    //   757: aload 6
    //   759: iconst_1
    //   760: putfield 541	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   763: goto -58 -> 705
    //   766: aload 4
    //   768: aload_0
    //   769: getfield 36	com/tencent/mobileqq/troop/data/TroopMessageProcessor:b	Ljava/util/Comparator;
    //   772: invokestatic 387	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   775: aload_2
    //   776: getfield 356	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   779: invokevirtual 602	java/lang/Object:toString	()Ljava/lang/String;
    //   782: astore_3
    //   783: aload_0
    //   784: getfield 51	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   787: bipush 36
    //   789: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   792: checkcast 604	com/tencent/mobileqq/model/TroopInfoManager
    //   795: aload_3
    //   796: aload 5
    //   798: invokevirtual 607	com/tencent/mobileqq/model/TroopInfoManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/troop/data/MessageInfo;
    //   801: pop
    //   802: aload_1
    //   803: getfield 346	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   806: ldc_w 609
    //   809: invokevirtual 613	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   812: astore_1
    //   813: new 45	java/util/ArrayList
    //   816: dup
    //   817: invokespecial 48	java/util/ArrayList:<init>	()V
    //   820: astore_3
    //   821: aload_1
    //   822: ifnull +39 -> 861
    //   825: aload_1
    //   826: ldc_w 615
    //   829: aload_2
    //   830: getfield 618	msf/msgsvc/msg_svc$PbGetGroupMsgResp:return_begin_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   833: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   836: invokevirtual 621	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   839: aload_1
    //   840: ldc_w 623
    //   843: aload_2
    //   844: getfield 369	msf/msgsvc/msg_svc$PbGetGroupMsgResp:return_end_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   847: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   850: invokevirtual 621	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   853: aload_1
    //   854: ldc_w 625
    //   857: iconst_1
    //   858: invokevirtual 629	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   861: aload_0
    //   862: getfield 51	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   865: invokevirtual 462	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   868: aload_2
    //   869: getfield 356	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   872: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   875: invokestatic 359	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   878: iconst_1
    //   879: aload 4
    //   881: aload_3
    //   882: aload_1
    //   883: invokevirtual 632	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Landroid/os/Bundle;)V
    //   886: aload_0
    //   887: getfield 491	com/tencent/mobileqq/troop/data/TroopMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   890: aload_3
    //   891: invokevirtual 590	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/util/ArrayList;)V
    //   894: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	895	0	this	TroopMessageProcessor
    //   0	895	1	paramToServiceMsg	ToServiceMsg
    //   0	895	2	paramPbGetGroupMsgResp	msg_svc.PbGetGroupMsgResp
    //   0	895	3	paramArrayList	ArrayList
    //   0	895	4	paramString	String
    //   16	781	5	localMessageInfo	MessageInfo
    //   64	694	6	localObject1	Object
    //   70	13	7	localIterator	java.util.Iterator
    //   92	505	8	localMsg	msg_comm.Msg
    //   186	453	9	localObject2	Object
    //   508	23	10	localContentHead	msg_comm.ContentHead
    //   165	398	11	i	int
    //   174	400	12	j	int
    //   196	389	13	k	int
    //   119	197	14	l1	long
    //   128	198	16	l2	long
    //   137	159	18	l3	long
    //   146	140	20	l4	long
    //   156	150	22	l5	long
    //   206	150	24	l6	long
    //   216	160	26	l7	long
    // Exception table:
    //   from	to	target	type
    //   252	263	649	java/io/UnsupportedEncodingException
    //   595	608	659	java/lang/Exception
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---TroopMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).group_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject3 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l2 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l3 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int n = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i1 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l7 = ((msg_comm.GroupInfo)localObject3).group_code.get();
    int m = ((msg_comm.GroupInfo)localObject3).group_type.get();
    long l8 = ((msg_comm.GroupInfo)localObject3).group_info_seq.get();
    label162:
    long l4;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l4 = ((Long)localObject1).longValue();
      if ((!((msg_comm.GroupInfo)localObject3).group_card.has()) || (((msg_comm.GroupInfo)localObject3).group_card.get() == null)) {
        break label470;
      }
      localObject1 = ((msg_comm.GroupInfo)localObject3).group_card.get().toByteArray();
    }
    for (;;)
    {
      Object localObject4;
      ArrayList localArrayList;
      PBDecodeContext localPBDecodeContext;
      TroopInfoManager localTroopInfoManager;
      try
      {
        localObject1 = new String((byte[])localObject1, "utf-8");
        localObject3 = new ArrayList();
        if (!paramMsg.content_head.has()) {
          break label1982;
        }
        localObject4 = (msg_comm.ContentHead)paramMsg.content_head.get();
        k = ((msg_comm.ContentHead)localObject4).div_seq.get();
        i = ((msg_comm.ContentHead)localObject4).pkg_index.get();
        j = ((msg_comm.ContentHead)localObject4).pkg_num.get();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq = n;
        localObject4 = String.valueOf(l7);
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
        localArrayList = new ArrayList();
        localPBDecodeContext = new PBDecodeContext();
        localPBDecodeContext.jdField_e_of_type_Long = l7;
        localPBDecodeContext.d = 1;
        localPBDecodeContext.jdField_e_of_type_Int = m;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4) != 2) {
          break label475;
        }
        bool1 = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a()) {
          break;
        }
        localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (MessageHandler.b) {
          break label481;
        }
        if (bool1) {
          break label519;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, new Object[] { paramMsg, paramFromServiceMsg });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : unfinished troopuin=" + (String)localObject4);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
      break label162;
      label470:
      Object localObject2 = null;
      continue;
      label475:
      boolean bool1 = false;
      continue;
      label481:
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, new Object[] { paramMsg, paramFromServiceMsg });
        return;
      }
      label519:
      Object localObject5;
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder("<---handleMsgPush_PB_Group : before analysis :");
        ((StringBuilder)localObject5).append(" fromUin:").append(l1).append(" toUin:").append(l5).append(" msgTime:").append(l3).append(" msgSeq:").append(l2).append(" msgUid:").append(l6).append(" userActive:").append(n).append(" fromInstid:").append(i1).append(" groupCode:").append(l7).append(" groupType:").append(m).append(" groupSeq:").append(l8).append(" cardName:").append(Utils.a((String)localObject2)).append(" hasAppShare:").append(paramMsg.appshare_info.has()).append(" bFinished:").append(bool1).append(" divSeq:").append(k).append(" pkgIndex:").append(i).append(" pkgNum:").append(j);
        QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject5).toString());
        if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
        {
          l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() / 1000L;
          QLog.d("Q.msg.TroopMessageProcessor", 2, "push_cost=" + (l5 - l3) + ",type=GROUP_PUSH_MSG");
        }
      }
      paramFromServiceMsg = new MessageInfo();
      try
      {
        a(paramMsg, (ArrayList)localObject3, localPBDecodeContext, true, paramFromServiceMsg);
        MessageHandlerUtils.a((List)localObject3);
        if (((ArrayList)localObject3).size() == 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
          return;
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
          }
        }
        if (localArrayList != null) {
          a((ArrayList)localObject3, localArrayList, true);
        }
        localObject2 = new ArrayList();
        if (localArrayList == null) {
          break label1798;
        }
      }
      Object localObject6;
      if (localArrayList.size() > 0)
      {
        k = localArrayList.size();
        j = 0;
        if (j < k)
        {
          localObject5 = (MessageRecord)localArrayList.get(j);
          if (l1 == 10000L)
          {
            paramMsg = (MessageForStructing)localObject5;
            if ((paramMsg != null) && (paramMsg.structingMsg != null) && (paramMsg.structingMsg.mMsgServiceID == 60))
            {
              paramMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              localObject6 = String.valueOf(l4);
              if (paramMsg == null) {
                break label1974;
              }
              paramMsg = paramMsg.a((String)localObject4);
              if (paramMsg == null) {
                break label1968;
              }
              if ((!TextUtils.isEmpty(paramMsg.troopowneruin)) || (!TextUtils.isEmpty(paramMsg.Administrator))) {
                break label1484;
              }
              i = 0;
            }
          }
        }
      }
      for (;;)
      {
        label1028:
        if ((i != 2) || (paramMsg == null)) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong((String)localObject4));
        }
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
          paramMsg.append(" mr.senderuin:").append(((MessageRecord)localObject5).senderuin).append(" mr.msgtype:").append(((MessageRecord)localObject5).msgtype).append(" mr.frienduin:").append(((MessageRecord)localObject5).frienduin).append(" mr.shmsgseq:").append(((MessageRecord)localObject5).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject5).time).append(" mr.msg:").append(((MessageRecord)localObject5).getLogColorContent());
          QLog.d("Q.msg.TroopMessageProcessor", 2, paramMsg.toString());
        }
        if (((((MessageRecord)localObject5).senderuin != null) && (((MessageRecord)localObject5).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || ((AnonymousChatHelper.a((MessageRecord)localObject5)) && (AnonymousChatHelper.b((MessageRecord)localObject5))))
        {
          if (AnonymousChatHelper.a((MessageRecord)localObject5))
          {
            ((MessageRecord)localObject5).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            paramMsg = AnonymousChatHelper.a((MessageRecord)localObject5);
            AnonymousChatHelper.a().a(String.valueOf(localPBDecodeContext.jdField_e_of_type_Long), ((MessageRecord)localObject5).vipBubbleID, paramMsg.jdField_b_of_type_Int, paramMsg.jdField_b_of_type_JavaLangString, paramMsg.c, paramMsg.a);
          }
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, (MessageRecord)localObject5);
          if (paramMsg != null)
          {
            if (((localObject5 instanceof MessageForText)) && ((paramMsg instanceof MessageForText)) && (((MessageRecord)localObject5).getRepeatCount() > 0))
            {
              paramMsg.setRepeatCount(((MessageRecord)localObject5).getRepeatCount());
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group ===> update findMr.repeatCount=" + paramMsg.getRepeatCount());
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject5).frienduin, 1, paramMsg.uniseq, ((MessageRecord)localObject5).shmsgseq, ((MessageRecord)localObject5).time);
            if (paramMsg.msgtype == 63519)
            {
              localObject6 = MsgProxyUtils.a(paramMsg, (MessageRecord)localObject5);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, paramMsg.uniseq, (byte[])localObject6);
              i = 1;
            }
          }
        }
        for (;;)
        {
          label1434:
          if (i != 0) {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg))
            {
              a(paramMsg);
              label1458:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, ((MessageRecord)localObject5).shmsgseq);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label1484:
            if ((!TextUtils.isEmpty(paramMsg.troopowneruin)) && (paramMsg.troopowneruin.equalsIgnoreCase((String)localObject6)))
            {
              i = 0;
              break label1028;
            }
            if ((TextUtils.isEmpty(paramMsg.Administrator)) || (!paramMsg.Administrator.contains((CharSequence)localObject6))) {
              break label1968;
            }
            i = 1;
            break label1028;
            if ((StructMsgHelper.a(paramMsg)) || (paramMsg.msgtype == 63488))
            {
              if (((MessageRecord)localObject5).msgtype == 63488)
              {
                localObject6 = (MessageForTroopReward)localObject5;
                ((MessageForTroopReward)localObject6).mediaPath = ((MessageForTroopReward)paramMsg).mediaPath;
                ((MessageForTroopReward)localObject6).prewrite();
                ((MessageRecord)localObject5).msgData = ((MessageForTroopReward)localObject6).msgData;
                if (QLog.isColorLevel()) {
                  QLog.d(".troop.troop_reward", 2, "replace msg,rewardId:" + ((MessageForTroopReward)localObject6).rewardId);
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, paramMsg.uniseq);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, paramMsg.uniseq, ((MessageRecord)localObject5).msgData);
              a(999, true, ((MessageRecord)localObject5).frienduin);
              i = 1;
              break label1434;
            }
            if (paramMsg.msgtype != 64487) {
              break label1962;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg.frienduin, paramMsg.istroop, paramMsg.uniseq);
            i = 0;
            break label1434;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((MessageRecord)localObject5, paramMsg);
            break label1458;
            ((MessageRecord)localObject5).isread = true;
            ((MessageRecord)localObject5).issend = 2;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject5).shmsgseq);
            ((ArrayList)localObject2).add(localObject5);
          }
          label1798:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
          boolean bool2 = MessageHandlerUtils.a((ArrayList)localObject2);
          boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
          boolean bool4 = MessageHandlerUtils.b((ArrayList)localObject2);
          i = MsgProxyUtils.a((List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localTroopInfoManager.a((String)localObject4, paramFromServiceMsg);
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
          for (bool1 = true;; bool1 = false)
          {
            paramMsg.a((ArrayList)localObject2, String.valueOf(l4), bool1);
            if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, l2);
            }
            if (m == 127) {
              break;
            }
            a("handleMsgPush_PB_Group", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3, bool4, (List)localObject2), false);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
            return;
          }
          label1962:
          i = 1;
        }
        label1968:
        i = 2;
        continue;
        label1974:
        paramMsg = null;
        i = 2;
      }
      label1982:
      int k = 0;
      int i = 0;
      int j = 0;
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 2))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetGroupMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      a((ArrayList)paramVarArgs[2], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], (msg_svc.PbGetGroupMsgResp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    String str = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "GroupMsgReadedNotify lGroupCode is " + paramGroupMsgReadedNotify.lGroupCode + ", lMemberSeq  is " + paramGroupMsgReadedNotify.lMemberSeq);
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramGroupMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, new Object[] { Long.valueOf(paramGroupMsgReadedNotify.lMemberSeq), Long.valueOf(paramGroupMsgReadedNotify.lGroupMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1, paramGroupMsgReadedNotify.lMemberSeq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, paramGroupMsgReadedNotify.lMemberSeq);
    paramGroupMsgReadedNotify = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    if (paramGroupMsgReadedNotify.c(str))
    {
      paramGroupMsgReadedNotify.d(str);
      if (!paramGroupMsgReadedNotify.b(str)) {
        paramGroupMsgReadedNotify.b(str);
      }
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "doSomeAfterGetPullTroopMsg doSome:" + paramInt + " troopUin:" + paramString);
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramString, paramPbGetGroupMsgResp, paramInt);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */