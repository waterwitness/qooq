package com.tencent.arrange.op;

import android.os.Message;
import com.tencent.arrange.ui.ArrangeUtil;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QavWrapper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoWrapper;
import gcp;
import gcq;
import gcr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x920.oidb_cmd0x920.CancleMeeting;
import tencent.im.oidb.cmd0x920.oidb_cmd0x920.CreateMeeting;
import tencent.im.oidb.cmd0x920.oidb_cmd0x920.GetSpecifiedMeeting;
import tencent.im.oidb.cmd0x920.oidb_cmd0x920.MeetingInfo;
import tencent.im.oidb.cmd0x920.oidb_cmd0x920.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x7a.submsgtype0x7a.MsgBody;

public class ArrangeHandler
  extends BusinessHandler
  implements ArrangeResult
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "ArrangeHandler";
  public static final int b = 1;
  public static final String b = "OidbSvc.0x920_0";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  private ArrangeResult jdField_a_of_type_ComTencentArrangeOpArrangeResult;
  private MeetingInfo jdField_a_of_type_ComTencentArrangeOpMeetingInfo;
  private MeetingInfo b;
  private int g;
  
  public ArrangeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = 0;
    this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo = new MeetingInfo();
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 62	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +261 -> 268
    //   10: aconst_null
    //   11: astore_2
    //   12: new 64	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 65	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: aload_3
    //   22: checkcast 67	[B
    //   25: checkcast 67	[B
    //   28: invokevirtual 71	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   31: checkcast 64	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +230 -> 268
    //   41: aload_1
    //   42: getfield 75	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   45: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   48: istore 9
    //   50: new 82	java/util/ArrayList
    //   53: dup
    //   54: invokespecial 83	java/util/ArrayList:<init>	()V
    //   57: astore_2
    //   58: iload 9
    //   60: ifne +548 -> 608
    //   63: aload_1
    //   64: getfield 87	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   67: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   70: ifeq +538 -> 608
    //   73: aload_1
    //   74: getfield 87	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   77: invokevirtual 96	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   80: ifnull +528 -> 608
    //   83: aload_1
    //   84: getfield 87	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   87: invokevirtual 96	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   90: invokevirtual 102	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   93: astore_1
    //   94: ldc 12
    //   96: aload_1
    //   97: invokestatic 107	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;[B)V
    //   100: new 109	tencent/im/oidb/cmd0x920/oidb_cmd0x920$RspBody
    //   103: dup
    //   104: invokespecial 110	tencent/im/oidb/cmd0x920/oidb_cmd0x920$RspBody:<init>	()V
    //   107: astore_3
    //   108: aload_3
    //   109: aload_1
    //   110: invokevirtual 111	tencent/im/oidb/cmd0x920/oidb_cmd0x920$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: aload_0
    //   115: getfield 39	com/tencent/arrange/op/ArrangeHandler:g	I
    //   118: iconst_1
    //   119: if_icmpne +150 -> 269
    //   122: aload_0
    //   123: getfield 114	com/tencent/arrange/op/ArrangeHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   126: ldc 116
    //   128: ldc 118
    //   130: ldc 118
    //   132: ldc 120
    //   134: ldc 120
    //   136: iconst_0
    //   137: iconst_0
    //   138: ldc 118
    //   140: ldc 118
    //   142: ldc 118
    //   144: ldc 118
    //   146: invokestatic 125	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_3
    //   150: getfield 129	tencent/im/oidb/cmd0x920/oidb_cmd0x920$RspBody:msg_create_meeting	Ltencent/im/oidb/cmd0x920/oidb_cmd0x920$CreateMeeting;
    //   153: getfield 135	tencent/im/oidb/cmd0x920/oidb_cmd0x920$CreateMeeting:rpt_msg_meeting_info1	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   156: invokevirtual 140	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   159: iconst_0
    //   160: invokeinterface 145 2 0
    //   165: checkcast 147	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo
    //   168: astore_3
    //   169: aload_3
    //   170: getfield 150	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint32_err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   173: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   176: istore 7
    //   178: iload 7
    //   180: istore 8
    //   182: new 152	java/lang/String
    //   185: dup
    //   186: aload_3
    //   187: getfield 155	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:bytes_error_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   190: invokevirtual 96	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   193: invokevirtual 102	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   196: invokespecial 158	java/lang/String:<init>	([B)V
    //   199: astore_1
    //   200: aload_0
    //   201: getfield 160	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpMeetingInfo	Lcom/tencent/arrange/op/MeetingInfo;
    //   204: aload_3
    //   205: getfield 164	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint64_meeting_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   208: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   211: invokevirtual 173	com/tencent/arrange/op/MeetingInfo:setSeq	(J)V
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 160	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpMeetingInfo	Lcom/tencent/arrange/op/MeetingInfo;
    //   219: invokevirtual 175	com/tencent/arrange/op/ArrangeHandler:a	(Lcom/tencent/arrange/op/MeetingInfo;)V
    //   222: aload_0
    //   223: getfield 177	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpArrangeResult	Lcom/tencent/arrange/op/ArrangeResult;
    //   226: ifnull +42 -> 268
    //   229: aload_0
    //   230: getfield 39	com/tencent/arrange/op/ArrangeHandler:g	I
    //   233: tableswitch	default:+35->268, 1:+392->625, 2:+407->640, 3:+422->655, 4:+422->655, 5:+422->655
    //   268: return
    //   269: aload_0
    //   270: getfield 39	com/tencent/arrange/op/ArrangeHandler:g	I
    //   273: iconst_2
    //   274: if_icmpne +73 -> 347
    //   277: aload_3
    //   278: getfield 181	tencent/im/oidb/cmd0x920/oidb_cmd0x920$RspBody:msg_cancle_meeting	Ltencent/im/oidb/cmd0x920/oidb_cmd0x920$CancleMeeting;
    //   281: getfield 186	tencent/im/oidb/cmd0x920/oidb_cmd0x920$CancleMeeting:rpt_msg_meeting_info2	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   284: invokevirtual 140	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   287: iconst_0
    //   288: invokeinterface 145 2 0
    //   293: checkcast 147	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo
    //   296: astore_1
    //   297: aload_1
    //   298: getfield 150	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint32_err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   301: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   304: istore 7
    //   306: iload 7
    //   308: istore 8
    //   310: new 152	java/lang/String
    //   313: dup
    //   314: aload_1
    //   315: getfield 155	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:bytes_error_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   318: invokevirtual 96	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   321: invokevirtual 102	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   324: invokespecial 158	java/lang/String:<init>	([B)V
    //   327: astore_1
    //   328: aload_0
    //   329: getfield 160	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpMeetingInfo	Lcom/tencent/arrange/op/MeetingInfo;
    //   332: iconst_0
    //   333: invokevirtual 190	com/tencent/arrange/op/MeetingInfo:setEnable	(I)V
    //   336: aload_0
    //   337: aload_0
    //   338: getfield 160	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpMeetingInfo	Lcom/tencent/arrange/op/MeetingInfo;
    //   341: invokevirtual 175	com/tencent/arrange/op/ArrangeHandler:a	(Lcom/tencent/arrange/op/MeetingInfo;)V
    //   344: goto -122 -> 222
    //   347: aload_0
    //   348: getfield 39	com/tencent/arrange/op/ArrangeHandler:g	I
    //   351: iconst_3
    //   352: if_icmpeq +19 -> 371
    //   355: aload_0
    //   356: getfield 39	com/tencent/arrange/op/ArrangeHandler:g	I
    //   359: iconst_4
    //   360: if_icmpeq +11 -> 371
    //   363: aload_0
    //   364: getfield 39	com/tencent/arrange/op/ArrangeHandler:g	I
    //   367: iconst_5
    //   368: if_icmpne +248 -> 616
    //   371: aload_3
    //   372: getfield 193	tencent/im/oidb/cmd0x920/oidb_cmd0x920$RspBody:rpt_msg_meeting_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   375: invokevirtual 140	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   378: invokeinterface 197 1 0
    //   383: astore_1
    //   384: aload_1
    //   385: invokeinterface 202 1 0
    //   390: ifeq +226 -> 616
    //   393: aload_1
    //   394: invokeinterface 206 1 0
    //   399: checkcast 147	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo
    //   402: astore_3
    //   403: new 41	com/tencent/arrange/op/MeetingInfo
    //   406: dup
    //   407: invokespecial 44	com/tencent/arrange/op/MeetingInfo:<init>	()V
    //   410: astore 4
    //   412: aload 4
    //   414: aload_3
    //   415: getfield 209	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint64_discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   418: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   421: invokestatic 215	java/lang/Long:toString	(J)Ljava/lang/String;
    //   424: invokevirtual 219	com/tencent/arrange/op/MeetingInfo:setDiscuss_uin	(Ljava/lang/String;)V
    //   427: aload 4
    //   429: aload_3
    //   430: getfield 222	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint64_creator_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   433: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   436: invokestatic 215	java/lang/Long:toString	(J)Ljava/lang/String;
    //   439: invokevirtual 225	com/tencent/arrange/op/MeetingInfo:setCreator_uin	(Ljava/lang/String;)V
    //   442: aload 4
    //   444: aload_3
    //   445: getfield 228	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint32_begin_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   448: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   451: i2l
    //   452: ldc2_w 229
    //   455: lmul
    //   456: invokevirtual 233	com/tencent/arrange/op/MeetingInfo:setBegin_time	(J)V
    //   459: aload 4
    //   461: aload_3
    //   462: getfield 236	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint32_end_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   465: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   468: i2l
    //   469: ldc2_w 229
    //   472: lmul
    //   473: invokevirtual 239	com/tencent/arrange/op/MeetingInfo:setEnd_time	(J)V
    //   476: new 82	java/util/ArrayList
    //   479: dup
    //   480: invokespecial 83	java/util/ArrayList:<init>	()V
    //   483: astore 5
    //   485: aload_3
    //   486: getfield 243	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:rpt_uint64_participants	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   489: invokevirtual 246	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   492: invokeinterface 197 1 0
    //   497: astore 6
    //   499: aload 6
    //   501: invokeinterface 202 1 0
    //   506: ifeq +25 -> 531
    //   509: aload 5
    //   511: aload 6
    //   513: invokeinterface 206 1 0
    //   518: checkcast 211	java/lang/Long
    //   521: invokevirtual 249	java/lang/Long:toString	()Ljava/lang/String;
    //   524: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   527: pop
    //   528: goto -29 -> 499
    //   531: aload 4
    //   533: aload 5
    //   535: invokevirtual 257	com/tencent/arrange/op/MeetingInfo:setParticipants	(Ljava/util/ArrayList;)V
    //   538: aload 4
    //   540: new 152	java/lang/String
    //   543: dup
    //   544: aload_3
    //   545: getfield 260	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:bytes_meeting_intro	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   548: invokevirtual 96	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   551: invokevirtual 102	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   554: invokespecial 158	java/lang/String:<init>	([B)V
    //   557: invokevirtual 263	com/tencent/arrange/op/MeetingInfo:setIntroduction	(Ljava/lang/String;)V
    //   560: aload 4
    //   562: aload_3
    //   563: getfield 164	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint64_meeting_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   566: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   569: invokevirtual 173	com/tencent/arrange/op/MeetingInfo:setSeq	(J)V
    //   572: aload 4
    //   574: aload_3
    //   575: getfield 266	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint32_enable	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   578: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   581: invokevirtual 190	com/tencent/arrange/op/MeetingInfo:setEnable	(I)V
    //   584: aload 4
    //   586: aload_3
    //   587: getfield 269	tencent/im/oidb/cmd0x920/oidb_cmd0x920$MeetingInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   590: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   593: invokevirtual 272	com/tencent/arrange/op/MeetingInfo:setType	(I)V
    //   596: aload_2
    //   597: aload 4
    //   599: invokeinterface 273 2 0
    //   604: pop
    //   605: goto -221 -> 384
    //   608: iload 9
    //   610: sipush 1203
    //   613: if_icmpne +3 -> 616
    //   616: ldc 118
    //   618: astore_1
    //   619: iconst_0
    //   620: istore 7
    //   622: goto -400 -> 222
    //   625: aload_0
    //   626: getfield 177	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpArrangeResult	Lcom/tencent/arrange/op/ArrangeResult;
    //   629: iload 9
    //   631: iload 7
    //   633: aload_1
    //   634: invokeinterface 276 4 0
    //   639: return
    //   640: aload_0
    //   641: getfield 177	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpArrangeResult	Lcom/tencent/arrange/op/ArrangeResult;
    //   644: iload 9
    //   646: iload 7
    //   648: aload_1
    //   649: invokeinterface 278 4 0
    //   654: return
    //   655: aload_0
    //   656: getfield 177	com/tencent/arrange/op/ArrangeHandler:jdField_a_of_type_ComTencentArrangeOpArrangeResult	Lcom/tencent/arrange/op/ArrangeResult;
    //   659: iload 9
    //   661: aload_2
    //   662: invokeinterface 281 3 0
    //   667: return
    //   668: astore_1
    //   669: ldc 118
    //   671: astore_1
    //   672: iload 8
    //   674: istore 7
    //   676: goto -454 -> 222
    //   679: astore_3
    //   680: goto -458 -> 222
    //   683: astore_3
    //   684: goto -462 -> 222
    //   687: astore_1
    //   688: aload_2
    //   689: astore_1
    //   690: goto -653 -> 37
    //   693: astore_2
    //   694: goto -657 -> 37
    //   697: astore_1
    //   698: ldc 118
    //   700: astore_1
    //   701: iconst_0
    //   702: istore 7
    //   704: goto -482 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	ArrangeHandler
    //   0	707	1	paramToServiceMsg	ToServiceMsg
    //   0	707	2	paramFromServiceMsg	FromServiceMsg
    //   0	707	3	paramObject	Object
    //   410	188	4	localMeetingInfo	MeetingInfo
    //   483	51	5	localArrayList	ArrayList
    //   497	15	6	localIterator	Iterator
    //   176	527	7	i	int
    //   180	493	8	j	int
    //   48	612	9	k	int
    // Exception table:
    //   from	to	target	type
    //   182	200	668	java/lang/Exception
    //   310	328	668	java/lang/Exception
    //   200	222	679	java/lang/Exception
    //   328	344	683	java/lang/Exception
    //   12	20	687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   20	35	693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	178	697	java/lang/Exception
    //   269	306	697	java/lang/Exception
    //   347	371	697	java/lang/Exception
    //   371	384	697	java/lang/Exception
    //   384	499	697	java/lang/Exception
    //   499	528	697	java/lang/Exception
    //   531	605	697	java/lang/Exception
  }
  
  private void c(MeetingInfo paramMeetingInfo)
  {
    gcr localgcr = new gcr(this, paramMeetingInfo);
    new Timer().schedule(localgcr, paramMeetingInfo.getShowTimeCount());
  }
  
  private void d(MeetingInfo paramMeetingInfo)
  {
    long l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, Long.parseLong(paramMeetingInfo.getDiscuss_uin()));
    HashMap localHashMap = new HashMap();
    localHashMap.put("sessiontype", String.valueOf(2));
    localHashMap.put("sessionid", paramMeetingInfo.getDiscuss_uin());
    localHashMap.put("arrangeseq", String.valueOf(paramMeetingInfo.getSeq()));
    localHashMap.put("roommemnum", String.valueOf(l));
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actConfRoomState", true, 0L, 0L, localHashMap, null, true);
  }
  
  protected Class a()
  {
    return ArrangeObserver.class;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt, List paramList)
  {
    if ((paramInt == 0) && (((MeetingInfo)paramList.get(0)).getEnable() != 0))
    {
      ((MeetingInfo)paramList.get(0)).setNotifContent(this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo.getNotifContent());
      this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo = ((MeetingInfo)paramList.get(0));
      b(this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo);
    }
  }
  
  public void a(long paramLong1, long paramLong2, ArrangeResult paramArrangeResult)
  {
    oidb_cmd0x920.ReqBody localReqBody = new oidb_cmd0x920.ReqBody();
    localReqBody.uint32_subcmd.set(5);
    localReqBody.setHasFlag(true);
    oidb_cmd0x920.MeetingInfo localMeetingInfo = new oidb_cmd0x920.MeetingInfo();
    localMeetingInfo.uint64_discuss_uin.set(paramLong1);
    localMeetingInfo.uint64_meeting_seq.set(paramLong2);
    localReqBody.msg_get_specified_meeting.rpt_msg_meeting_info3.add(localMeetingInfo);
    localReqBody.msg_get_specified_meeting.setHasFlag(true);
    this.g = 5;
    this.jdField_a_of_type_ComTencentArrangeOpArrangeResult = paramArrangeResult;
    a(localReqBody);
  }
  
  public void a(MeetingInfo paramMeetingInfo)
  {
    String str2 = paramMeetingInfo.getDiscuss_uin();
    paramMeetingInfo.getCreator_uin();
    String str1 = paramMeetingInfo.getIntroduction();
    Long localLong = Long.valueOf(paramMeetingInfo.getSeq());
    String str6 = Long.toString(paramMeetingInfo.getEnable());
    String str3 = paramMeetingInfo.getFormatTime();
    String str5 = ContactUtils.i(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMeetingInfo.getCreator_uin());
    Object localObject2 = "时间：" + str3 + "\n主题：" + str1;
    Object localObject1;
    if (this.g == 1)
    {
      localObject1 = "预约";
      String str4 = (String)localObject1 + "了" + "QQ电话";
      String str7 = "<msg serviceID=\"49\" templateID=\"1\" action=\"plugin\" " + "i_actionData=\"mqqapi://conference/viewconfdetail?maintype=discuss&amp;uin=" + str2 + "&amp;seq=" + localLong + "&amp;enable=" + str6 + "&amp;type=" + paramMeetingInfo.getType() + "&amp;version=1&amp;src_type=internal\" ";
      str7 = str7 + "a_actionData=\"mqqapi://conference/viewconfdetail?maintype=discuss&amp;uin=" + str2 + "&amp;seq=" + localLong + "&amp;enable=" + str6 + "&amp;type=" + paramMeetingInfo.getType() + "&amp;version=1&amp;src_type=internal\" ";
      paramMeetingInfo = str7 + "actionData=\"AppCmd://ViewConfScheduleDetail/?maintype=discuss&amp;uin=" + str2 + "&amp;seq=" + localLong + "&amp;enable=" + str6 + "&amp;type=" + paramMeetingInfo.getType() + "\"  ";
      paramMeetingInfo = paramMeetingInfo + "flag=\"3\" brief=\"" + str5 + str4 + "\">";
      paramMeetingInfo = paramMeetingInfo + "<item layout=\"2\">";
      paramMeetingInfo = paramMeetingInfo + "<picture cover=\"http://fwd.3g.qq.com:8080/forward.jsp?bid=1101\"/>";
      paramMeetingInfo = paramMeetingInfo + "<title>" + "QQ电话" + (String)localObject1 + "</title>";
      paramMeetingInfo = paramMeetingInfo + "<summary>" + (String)localObject2 + "</summary>";
      localObject1 = TestStructMsg.a(paramMeetingInfo + "</item></msg>");
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder().append(str4).append(":");
        if (str1.length() <= 10) {
          break label612;
        }
      }
    }
    label612:
    for (paramMeetingInfo = str1.substring(0, 10) + "…";; paramMeetingInfo = str1)
    {
      ((AbsStructMsg)localObject1).mCompatibleText = (paramMeetingInfo + "\r\n时间：" + str3);
      ShareMsgHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str2, 3000, (AbsStructMsg)localObject1, null);
      return;
      localObject1 = "取消";
      break;
    }
  }
  
  public void a(MeetingInfo paramMeetingInfo, ArrangeResult paramArrangeResult)
  {
    oidb_cmd0x920.ReqBody localReqBody = new oidb_cmd0x920.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    localReqBody.setHasFlag(true);
    oidb_cmd0x920.MeetingInfo localMeetingInfo = new oidb_cmd0x920.MeetingInfo();
    localMeetingInfo.uint64_discuss_uin.set(Long.parseLong(paramMeetingInfo.getDiscuss_uin()));
    localMeetingInfo.uint64_creator_uin.set(Long.parseLong(paramMeetingInfo.getCreator_uin()));
    localMeetingInfo.uint32_begin_time.set((int)(paramMeetingInfo.getBegin_time() / 1000L));
    localMeetingInfo.uint32_end_time.set((int)(paramMeetingInfo.getEnd_time() / 1000L));
    localMeetingInfo.uint32_type.set(paramMeetingInfo.getType());
    Iterator localIterator = paramMeetingInfo.getParticipants().iterator();
    for (;;)
    {
      String str;
      if (localIterator.hasNext()) {
        str = (String)localIterator.next();
      }
      try
      {
        long l = Long.parseLong(str);
        localMeetingInfo.rpt_uint64_participants.add(Long.valueOf(l));
      }
      catch (Exception localException) {}
      localMeetingInfo.bytes_meeting_intro.set(ByteStringMicro.copyFrom(paramMeetingInfo.getIntroduction().getBytes()));
      localMeetingInfo.uint32_enable.set(1);
      localReqBody.msg_create_meeting.rpt_msg_meeting_info1.add(localMeetingInfo);
      localReqBody.msg_create_meeting.setHasFlag(true);
      this.g = 1;
      this.jdField_a_of_type_ComTencentArrangeOpArrangeResult = paramArrangeResult;
      this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = paramMeetingInfo;
      a(localReqBody);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArrangeHandler", 2, "onReceive");
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("ArrangeHandler", 2, "cmdfilter error = " + str);
      }
    }
    while (!"OidbSvc.0x920_0".equalsIgnoreCase(str)) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(oidb_cmd0x920.ReqBody paramReqBody)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2336);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramReqBody.toByteArray()));
    paramReqBody = a("OidbSvc.0x920_0");
    paramReqBody.putWupBuffer(localOIDBSSOPkg.toByteArray());
    b(paramReqBody);
  }
  
  public void a(submsgtype0x7a.MsgBody paramMsgBody)
  {
    if (NetConnInfoCenter.getServerTime() > paramMsgBody.uint64_at_time.get() + 60L)
    {
      ((QCallFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37)).a(String.valueOf(paramMsgBody.uint64_discuss_uin.get()), String.valueOf(paramMsgBody.uint64_from_uin.get()));
      return;
    }
    this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo.setSeq(paramMsgBody.uint64_seq.get());
    this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo.setNotifContent(new String(paramMsgBody.bytes_content.get().toByteArray()));
    a(paramMsgBody.uint64_discuss_uin.get(), this.jdField_b_of_type_ComTencentArrangeOpMeetingInfo.getSeq(), this);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x920_0");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString) {}
  
  public void b(MeetingInfo paramMeetingInfo)
  {
    int i = 0;
    if ((paramMeetingInfo.getNotifContent() == null) || (paramMeetingInfo.getNotifContent().length() == 0)) {
      paramMeetingInfo.setNotifContent("预约的QQ电话开始了");
    }
    MqqHandler localMqqHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(10012);
      localMessage.obj = paramMeetingInfo;
      localMqqHandler.sendMessage(localMessage);
    }
    c(paramMeetingInfo);
    ArrangeUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMeetingInfo, 0);
    long l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (l > 0L) {
      i = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
    }
    if ((j == 1) && (i == 2))
    {
      new GroupVideoWrapper(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(new gcp(this, paramMeetingInfo));
      return;
    }
    new QavWrapper(BaseApplication.getContext()).a(new gcq(this, paramMeetingInfo));
  }
  
  public void b(MeetingInfo paramMeetingInfo, ArrangeResult paramArrangeResult)
  {
    oidb_cmd0x920.ReqBody localReqBody = new oidb_cmd0x920.ReqBody();
    localReqBody.uint32_subcmd.set(2);
    localReqBody.setHasFlag(true);
    oidb_cmd0x920.MeetingInfo localMeetingInfo = new oidb_cmd0x920.MeetingInfo();
    localMeetingInfo.uint64_discuss_uin.set(Long.parseLong(paramMeetingInfo.getDiscuss_uin()));
    localMeetingInfo.uint64_meeting_seq.set(paramMeetingInfo.getSeq());
    localReqBody.msg_cancle_meeting.rpt_msg_meeting_info2.add(localMeetingInfo);
    localReqBody.msg_cancle_meeting.setHasFlag(true);
    this.g = 2;
    this.jdField_a_of_type_ComTencentArrangeOpArrangeResult = paramArrangeResult;
    this.jdField_a_of_type_ComTencentArrangeOpMeetingInfo = paramMeetingInfo;
    a(localReqBody);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\op\ArrangeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */