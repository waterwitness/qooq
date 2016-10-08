package com.tencent.mobileqq.app;

import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.TextMsgPush;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class DataLineHandler_210
  extends DataLineHandler
{
  DataLineHandler_210(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type == 1L) {
      b(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
    }
  }
  
  private void b(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {}
    TextMsgPush localTextMsgPush;
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
      {
        localTextMsgPush = new TextMsgPush(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localTextMsgPush);
      }
      for (;;)
      {
        Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
        localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
        localObject = new String();
        int i = 0;
        while (i < localType_1_QQDataTextMsg.msg_item.size())
        {
          String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i)).bytes_text);
          localObject = (String)localObject + str;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, str);
          }
          i += 1;
        }
        localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      }
      localTextMsgPush.a((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    } while (!localTextMsgPush.a());
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    Object localObject = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).msg = localTextMsgPush.a();
    ((DataLineMsgRecord)localObject).msgtype = 64536;
    ((DataLineMsgRecord)localObject).issend = 0;
    ((DataLineMsgRecord)localObject).isread = false;
    ((DataLineMsgRecord)localObject).time = paramInt;
    ((DataLineMsgRecord)localObject).issuc = true;
    ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
    ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
    paramShort = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject).sessionid);
    this.b.a().a(paramShort).a((DataLineMsgRecord)localObject, true);
    this.b.a(1, true, true);
    b(8, true, new Object[] { Integer.valueOf(paramInt), localTextMsgPush.a(), Long.valueOf(((DataLineMsgRecord)localObject).sessionid) });
  }
  
  /* Error */
  public void a(msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 208	com/tencent/mobileqq/app/DataLineHandler:a	(Lmsf/msgcomm/msg_comm$Msg;)V
    //   5: new 210	msf/msgcomm/msg_comm$MsgType0x210
    //   8: dup
    //   9: invokespecial 211	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_1
    //   15: getfield 217	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   18: invokevirtual 222	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 219	tencent/im/msg/im_msg_body$MsgBody
    //   24: getfield 226	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   27: invokevirtual 231	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   30: invokevirtual 237	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   33: invokevirtual 241	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   36: checkcast 210	msf/msgcomm/msg_comm$MsgType0x210
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 116
    //   50: iconst_2
    //   51: ldc -13
    //   53: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 63	com/qq/taf/jce/JceInputStream
    //   59: dup
    //   60: aload_2
    //   61: getfield 244	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   64: invokevirtual 231	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   67: invokevirtual 237	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   70: invokespecial 70	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   73: astore_3
    //   74: new 246	IMMsgBodyPack/MsgType0x210
    //   77: dup
    //   78: invokespecial 247	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   81: astore_2
    //   82: aload_2
    //   83: aload_3
    //   84: invokevirtual 248	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   87: new 136	com/tencent/mobileqq/data/DataLineMsgRecord
    //   90: dup
    //   91: invokespecial 137	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_1
    //   97: getfield 252	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   100: invokevirtual 255	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 254	msf/msgcomm/msg_comm$MsgHead
    //   106: getfield 259	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: i2l
    //   113: putfield 168	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   116: aload_3
    //   117: aload_1
    //   118: getfield 252	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   121: invokevirtual 255	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: checkcast 254	msf/msgcomm/msg_comm$MsgHead
    //   127: getfield 266	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: i2l
    //   134: putfield 162	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   137: aload_3
    //   138: aload_1
    //   139: getfield 252	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   142: invokevirtual 255	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   145: checkcast 254	msf/msgcomm/msg_comm$MsgHead
    //   148: getfield 270	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: putfield 140	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   157: aload_0
    //   158: aload_3
    //   159: iconst_1
    //   160: invokevirtual 278	com/tencent/mobileqq/app/DataLineHandler_210:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   163: ifeq +78 -> 241
    //   166: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +51 -> 220
    //   172: ldc 116
    //   174: iconst_2
    //   175: new 99	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 280
    //   185: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: getfield 168	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   192: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc_w 285
    //   198: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: getfield 162	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   205: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc_w 287
    //   211: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_3
    //   222: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +13 -> 238
    //   228: ldc 116
    //   230: iconst_2
    //   231: ldc_w 289
    //   234: aload_3
    //   235: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: goto -196 -> 42
    //   241: aload_0
    //   242: getfield 175	com/tencent/mobileqq/app/DataLineHandler_210:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   245: bipush 10
    //   247: invokevirtual 296	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   250: checkcast 298	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   253: astore_1
    //   254: aload_1
    //   255: ifnull +43 -> 298
    //   258: aload_1
    //   259: invokevirtual 300	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	()I
    //   262: istore 4
    //   264: aload_1
    //   265: invokevirtual 303	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:g	()I
    //   268: istore 5
    //   270: iload 4
    //   272: iconst_1
    //   273: if_icmpne +9 -> 282
    //   276: iload 4
    //   278: iconst_2
    //   279: if_icmpeq +8 -> 287
    //   282: aload_1
    //   283: iconst_1
    //   284: invokevirtual 306	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	(I)V
    //   287: iload 5
    //   289: iconst_1
    //   290: if_icmpeq +8 -> 298
    //   293: aload_1
    //   294: iconst_1
    //   295: invokevirtual 308	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:d	(I)V
    //   298: aload_2
    //   299: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   302: ldc2_w 312
    //   305: lcmp
    //   306: ifne +69 -> 375
    //   309: aload_0
    //   310: aload_2
    //   311: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   314: getfield 320	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   317: l2i
    //   318: aload_2
    //   319: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   322: getfield 323	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   325: l2i
    //   326: invokevirtual 326	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   329: ifne -109 -> 220
    //   332: aload_0
    //   333: aload_2
    //   334: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   337: getfield 329	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   340: l2i
    //   341: aload_2
    //   342: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   345: getfield 332	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   348: l2i
    //   349: invokevirtual 334	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   352: ifeq -132 -> 220
    //   355: aload_0
    //   356: aload_3
    //   357: getfield 162	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   360: l2i
    //   361: aload_3
    //   362: getfield 168	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   365: l2i
    //   366: i2s
    //   367: aload_2
    //   368: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   371: invokespecial 336	com/tencent/mobileqq/app/DataLineHandler_210:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   374: return
    //   375: aload_2
    //   376: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   379: ldc2_w 337
    //   382: lcmp
    //   383: ifne +161 -> 544
    //   386: aload_0
    //   387: aload_2
    //   388: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   391: getfield 347	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   394: l2i
    //   395: aload_2
    //   396: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   399: getfield 350	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   402: l2i
    //   403: invokevirtual 326	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   406: ifne -186 -> 220
    //   409: aload_0
    //   410: aload_2
    //   411: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   414: getfield 353	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   417: l2i
    //   418: aload_2
    //   419: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   422: getfield 356	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   425: l2i
    //   426: invokevirtual 334	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   429: ifeq -209 -> 220
    //   432: aload_0
    //   433: getfield 359	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   436: aload_2
    //   437: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   440: getfield 362	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   443: aload_2
    //   444: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   447: getfield 365	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   450: aload_2
    //   451: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   454: getfield 368	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   457: new 76	java/lang/String
    //   460: dup
    //   461: aload_2
    //   462: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   465: getfield 371	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   468: invokespecial 97	java/lang/String:<init>	([B)V
    //   471: aload_2
    //   472: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   475: getfield 374	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   478: aload_2
    //   479: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   482: getfield 377	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   485: new 76	java/lang/String
    //   488: dup
    //   489: aload_2
    //   490: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   493: getfield 380	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   496: invokespecial 97	java/lang/String:<init>	([B)V
    //   499: aload_2
    //   500: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   503: getfield 383	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   506: iconst_0
    //   507: iconst_0
    //   508: iconst_0
    //   509: iconst_0
    //   510: aload_3
    //   511: getfield 162	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   514: l2i
    //   515: i2l
    //   516: aload_3
    //   517: getfield 168	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   520: l2i
    //   521: i2s
    //   522: i2l
    //   523: aload_3
    //   524: getfield 140	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   527: iconst_0
    //   528: invokevirtual 389	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFTNNotify_0x210	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   531: astore_1
    //   532: aload_0
    //   533: getfield 392	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   536: aload_1
    //   537: invokevirtual 398	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   540: return
    //   541: astore_1
    //   542: aload_1
    //   543: athrow
    //   544: aload_2
    //   545: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   548: ldc2_w 399
    //   551: lcmp
    //   552: ifne +172 -> 724
    //   555: aload_0
    //   556: aload_2
    //   557: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   560: getfield 407	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   563: l2i
    //   564: aload_2
    //   565: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   568: getfield 408	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   571: l2i
    //   572: invokevirtual 326	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   575: ifne -355 -> 220
    //   578: aload_0
    //   579: aload_2
    //   580: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   583: getfield 409	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   586: l2i
    //   587: aload_2
    //   588: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   591: getfield 410	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   594: l2i
    //   595: invokevirtual 334	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   598: ifeq -378 -> 220
    //   601: aload_0
    //   602: getfield 359	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   605: aload_2
    //   606: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   609: getfield 411	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   612: aload_2
    //   613: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   616: getfield 412	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   619: aload_2
    //   620: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   623: getfield 413	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   626: new 76	java/lang/String
    //   629: dup
    //   630: aload_2
    //   631: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   634: getfield 414	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   637: invokespecial 97	java/lang/String:<init>	([B)V
    //   640: aload_2
    //   641: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   644: getfield 417	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   647: aload_2
    //   648: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   651: getfield 420	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   654: aload_2
    //   655: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   658: getfield 423	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   661: aload_2
    //   662: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   665: getfield 426	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   668: aload_2
    //   669: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   672: getfield 429	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   675: aload_2
    //   676: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   679: getfield 432	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   682: aload_2
    //   683: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   686: getfield 433	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   689: iconst_0
    //   690: iconst_0
    //   691: iconst_0
    //   692: iconst_0
    //   693: aload_3
    //   694: getfield 162	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   697: l2i
    //   698: i2l
    //   699: aload_3
    //   700: getfield 168	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   703: l2i
    //   704: i2s
    //   705: i2l
    //   706: aload_3
    //   707: getfield 140	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   710: iconst_0
    //   711: invokevirtual 437	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromNFCNotify_0x210	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   714: astore_1
    //   715: aload_0
    //   716: getfield 392	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   719: aload_1
    //   720: invokevirtual 398	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   723: return
    //   724: aload_2
    //   725: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   728: ldc2_w 438
    //   731: lcmp
    //   732: ifne -512 -> 220
    //   735: aload_0
    //   736: aload_2
    //   737: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   740: getfield 446	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   743: l2i
    //   744: aload_2
    //   745: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   748: getfield 447	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   751: l2i
    //   752: invokevirtual 326	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   755: ifne -535 -> 220
    //   758: aload_0
    //   759: aload_2
    //   760: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   763: getfield 448	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   766: l2i
    //   767: aload_2
    //   768: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   771: getfield 449	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   774: l2i
    //   775: invokevirtual 334	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   778: ifeq -558 -> 220
    //   781: aload_0
    //   782: getfield 359	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   785: aload_2
    //   786: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   789: getfield 450	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   792: aload_2
    //   793: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   796: getfield 453	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   799: iconst_0
    //   800: aload_3
    //   801: getfield 162	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   804: l2i
    //   805: aload_3
    //   806: getfield 168	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   809: l2i
    //   810: i2s
    //   811: invokevirtual 457	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFileControl_0x210	(JJIIS)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   814: astore_1
    //   815: aload_0
    //   816: getfield 392	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   819: aload_1
    //   820: invokevirtual 398	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   823: return
    //   824: astore_1
    //   825: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	826	0	this	DataLineHandler_210
    //   0	826	1	paramMsg	msf.msgcomm.msg_comm.Msg
    //   12	781	2	localObject1	Object
    //   39	163	3	localObject2	Object
    //   221	585	3	localException	Exception
    //   262	18	4	i	int
    //   268	23	5	j	int
    // Exception table:
    //   from	to	target	type
    //   13	40	221	java/lang/Exception
    //   82	220	541	finally
    //   241	254	541	finally
    //   258	270	541	finally
    //   282	287	541	finally
    //   293	298	541	finally
    //   298	374	541	finally
    //   375	540	541	finally
    //   544	723	541	finally
    //   724	823	541	finally
    //   82	220	824	java/lang/Exception
    //   241	254	824	java/lang/Exception
    //   258	270	824	java/lang/Exception
    //   282	287	824	java/lang/Exception
    //   293	298	824	java/lang/Exception
    //   298	374	824	java/lang/Exception
    //   375	540	824	java/lang/Exception
    //   544	723	824	java/lang/Exception
    //   724	823	824	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DataLineHandler_210.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */