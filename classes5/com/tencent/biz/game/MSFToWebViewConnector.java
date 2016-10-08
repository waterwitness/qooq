package com.tencent.biz.game;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class MSFToWebViewConnector
{
  public static final int a = 60;
  public static final String a = "OnlinePush.ReqPush.GameStatusPush";
  public static final String c = "com.tencent.mobileqq.msf.service.MsfService";
  private static final String g = "MSFToWebViewConnector";
  protected Context a;
  protected MSFToWebViewConnector.IOnMsgReceiveListener a;
  protected MsfRespHandleUtil a;
  ArrayList a;
  protected String b;
  protected String d;
  protected String e;
  protected String f;
  
  public MSFToWebViewConnector()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = "";
    this.f = "";
  }
  
  public String a(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (this.e.equals(paramString))) {
      return this.f;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
  }
  
  /* Error */
  public void a(android.content.Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +796 -> 805
    //   12: aload_1
    //   13: ldc 10
    //   15: invokevirtual 54	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +787 -> 805
    //   21: aload_2
    //   22: invokevirtual 78	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +18 -> 45
    //   30: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +11 -> 44
    //   36: ldc 16
    //   38: iconst_2
    //   39: ldc 86
    //   41: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: new 91	OnlinePushPack/SvcReqPushMsg
    //   48: dup
    //   49: invokespecial 92	OnlinePushPack/SvcReqPushMsg:<init>	()V
    //   52: astore_3
    //   53: new 94	com/qq/jce/wup/UniPacket
    //   56: dup
    //   57: iconst_1
    //   58: invokespecial 97	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   61: astore 4
    //   63: aload 4
    //   65: ldc 99
    //   67: invokevirtual 103	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   70: aload 4
    //   72: aload_1
    //   73: invokevirtual 107	com/qq/jce/wup/UniPacket:decode	([B)V
    //   76: aload 4
    //   78: ldc 109
    //   80: aload_3
    //   81: invokevirtual 113	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 91	OnlinePushPack/SvcReqPushMsg
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   92: ifnonnull +14 -> 106
    //   95: aload_0
    //   96: new 60	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 114	java/util/ArrayList:<init>	()V
    //   103: putfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   106: aload_2
    //   107: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   110: istore 8
    //   112: aload_0
    //   113: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   116: ifnull +732 -> 848
    //   119: aload_0
    //   120: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: astore_3
    //   124: aload_3
    //   125: monitorenter
    //   126: aload_0
    //   127: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: invokevirtual 122	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   133: astore 4
    //   135: aload 4
    //   137: invokeinterface 127 1 0
    //   142: ifeq +700 -> 842
    //   145: aload 4
    //   147: invokeinterface 131 1 0
    //   152: checkcast 133	hhy
    //   155: astore 5
    //   157: aload 5
    //   159: getfield 135	hhy:jdField_a_of_type_Int	I
    //   162: iload 8
    //   164: if_icmpne -29 -> 135
    //   167: aload 5
    //   169: getfield 138	hhy:jdField_a_of_type_Long	J
    //   172: aload_1
    //   173: getfield 141	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   176: lcmp
    //   177: ifne -42 -> 135
    //   180: iconst_1
    //   181: istore 7
    //   183: aload_3
    //   184: monitorexit
    //   185: aload_0
    //   186: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   189: ifnull +181 -> 370
    //   192: aload_0
    //   193: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   196: astore_3
    //   197: aload_3
    //   198: monitorenter
    //   199: iload 7
    //   201: ifeq +86 -> 287
    //   204: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +29 -> 236
    //   210: ldc 16
    //   212: iconst_2
    //   213: new 143	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   220: ldc -110
    //   222: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: iload 8
    //   227: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_3
    //   237: monitorexit
    //   238: return
    //   239: astore_1
    //   240: aload_3
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -204 -> 44
    //   251: ldc 16
    //   253: iconst_2
    //   254: aload_1
    //   255: invokevirtual 159	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   258: aload_1
    //   259: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: return
    //   263: astore_1
    //   264: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq -223 -> 44
    //   270: ldc 16
    //   272: iconst_2
    //   273: aload_1
    //   274: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   277: aload_1
    //   278: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: return
    //   282: astore_1
    //   283: aload_3
    //   284: monitorexit
    //   285: aload_1
    //   286: athrow
    //   287: aload_0
    //   288: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   291: invokevirtual 166	java/util/ArrayList:size	()I
    //   294: bipush 60
    //   296: if_icmpge +364 -> 660
    //   299: new 133	hhy
    //   302: dup
    //   303: aload_0
    //   304: aconst_null
    //   305: invokespecial 169	hhy:<init>	(Lcom/tencent/biz/game/MSFToWebViewConnector;Lhhx;)V
    //   308: astore 4
    //   310: aload 4
    //   312: iload 8
    //   314: putfield 135	hhy:jdField_a_of_type_Int	I
    //   317: aload 4
    //   319: aload_1
    //   320: getfield 141	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   323: putfield 138	hhy:jdField_a_of_type_Long	J
    //   326: aload_0
    //   327: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   330: aload 4
    //   332: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   335: pop
    //   336: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +29 -> 368
    //   342: ldc 16
    //   344: iconst_2
    //   345: new 143	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   352: ldc -82
    //   354: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload 8
    //   359: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_3
    //   369: monitorexit
    //   370: new 60	java/util/ArrayList
    //   373: dup
    //   374: invokespecial 114	java/util/ArrayList:<init>	()V
    //   377: astore_3
    //   378: aload_1
    //   379: getfield 177	OnlinePushPack/SvcReqPushMsg:vMsgInfos	Ljava/util/ArrayList;
    //   382: astore 4
    //   384: aload 4
    //   386: ifnull +337 -> 723
    //   389: aload 4
    //   391: invokevirtual 166	java/util/ArrayList:size	()I
    //   394: ifle +329 -> 723
    //   397: aload 4
    //   399: invokevirtual 122	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   402: astore 4
    //   404: aload 4
    //   406: invokeinterface 127 1 0
    //   411: ifeq +327 -> 738
    //   414: aload 4
    //   416: invokeinterface 131 1 0
    //   421: checkcast 179	OnlinePushPack/MsgInfo
    //   424: astore 5
    //   426: sipush 528
    //   429: aload 5
    //   431: getfield 183	OnlinePushPack/MsgInfo:shMsgType	S
    //   434: if_icmpne +271 -> 705
    //   437: new 185	OnlinePushPack/DelMsgInfo
    //   440: dup
    //   441: invokespecial 186	OnlinePushPack/DelMsgInfo:<init>	()V
    //   444: astore 6
    //   446: aload 6
    //   448: aload 5
    //   450: getfield 189	OnlinePushPack/MsgInfo:lFromUin	J
    //   453: putfield 190	OnlinePushPack/DelMsgInfo:lFromUin	J
    //   456: aload 6
    //   458: aload 5
    //   460: getfield 193	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   463: putfield 194	OnlinePushPack/DelMsgInfo:shMsgSeq	S
    //   466: aload 6
    //   468: aload 5
    //   470: getfield 197	OnlinePushPack/MsgInfo:uMsgTime	J
    //   473: putfield 198	OnlinePushPack/DelMsgInfo:uMsgTime	J
    //   476: aload 6
    //   478: aload 5
    //   480: getfield 202	OnlinePushPack/MsgInfo:vMsgCookies	[B
    //   483: putfield 203	OnlinePushPack/DelMsgInfo:vMsgCookies	[B
    //   486: aload_3
    //   487: aload 6
    //   489: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   492: pop
    //   493: new 205	com/qq/taf/jce/JceInputStream
    //   496: dup
    //   497: aload 5
    //   499: getfield 208	OnlinePushPack/MsgInfo:vMsg	[B
    //   502: invokespecial 210	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   505: astore 6
    //   507: aload 6
    //   509: ldc 99
    //   511: invokevirtual 214	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   514: pop
    //   515: new 216	IMMsgBodyPack/MsgType0x210
    //   518: dup
    //   519: invokespecial 217	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   522: astore 5
    //   524: aload 5
    //   526: aload 6
    //   528: invokevirtual 221	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   531: aload 5
    //   533: ifnull -129 -> 404
    //   536: aload 5
    //   538: getfield 224	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   541: ldc2_w 225
    //   544: lcmp
    //   545: ifne -141 -> 404
    //   548: aload 5
    //   550: getfield 229	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   553: ifnull -149 -> 404
    //   556: new 231	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync
    //   559: dup
    //   560: invokespecial 232	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:<init>	()V
    //   563: astore 6
    //   565: aload 6
    //   567: aload 5
    //   569: getfield 229	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   572: invokevirtual 236	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   575: pop
    //   576: aload 6
    //   578: getfield 240	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:uint32_game_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   581: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   584: istore 7
    //   586: aload 6
    //   588: getfield 249	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   591: invokevirtual 254	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   594: astore 5
    //   596: aload_0
    //   597: getfield 56	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   600: ifnull +87 -> 687
    //   603: aload 5
    //   605: ifnull +82 -> 687
    //   608: new 50	java/lang/String
    //   611: dup
    //   612: aload 5
    //   614: invokevirtual 259	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   617: invokespecial 260	java/lang/String:<init>	([B)V
    //   620: astore 5
    //   622: aload_0
    //   623: getfield 56	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   626: iload 7
    //   628: aload 5
    //   630: invokeinterface 265 3 0
    //   635: goto -231 -> 404
    //   638: astore 5
    //   640: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   643: ifeq -239 -> 404
    //   646: ldc 16
    //   648: iconst_2
    //   649: aload 5
    //   651: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   654: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: goto -253 -> 404
    //   660: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +12 -> 675
    //   666: ldc 16
    //   668: iconst_2
    //   669: ldc_w 267
    //   672: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: aload_0
    //   676: getfield 58	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   679: iconst_0
    //   680: invokevirtual 271	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   683: pop
    //   684: goto -316 -> 368
    //   687: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq -286 -> 404
    //   693: ldc 16
    //   695: iconst_2
    //   696: ldc_w 273
    //   699: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: goto -298 -> 404
    //   705: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq -304 -> 404
    //   711: ldc 16
    //   713: iconst_2
    //   714: ldc_w 275
    //   717: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: goto -316 -> 404
    //   723: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   726: ifeq +12 -> 738
    //   729: ldc 16
    //   731: iconst_2
    //   732: ldc_w 277
    //   735: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_3
    //   739: invokevirtual 166	java/util/ArrayList:size	()I
    //   742: ifle -698 -> 44
    //   745: new 279	OnlinePushPack/SvcRespPushMsg
    //   748: dup
    //   749: invokespecial 280	OnlinePushPack/SvcRespPushMsg:<init>	()V
    //   752: astore 4
    //   754: aload_2
    //   755: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   758: istore 7
    //   760: aload 4
    //   762: aload_1
    //   763: getfield 141	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   766: putfield 281	OnlinePushPack/SvcRespPushMsg:lUin	J
    //   769: aload 4
    //   771: aload_1
    //   772: getfield 284	OnlinePushPack/SvcReqPushMsg:svrip	I
    //   775: putfield 285	OnlinePushPack/SvcRespPushMsg:svrip	I
    //   778: aload 4
    //   780: aload_3
    //   781: putfield 288	OnlinePushPack/SvcRespPushMsg:vDelInfos	Ljava/util/ArrayList;
    //   784: aload_0
    //   785: getfield 56	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   788: ifnull -744 -> 44
    //   791: aload_0
    //   792: getfield 56	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   795: iload 7
    //   797: aload 4
    //   799: invokeinterface 291 3 0
    //   804: return
    //   805: aload_1
    //   806: ifnull -762 -> 44
    //   809: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq -768 -> 44
    //   815: ldc 16
    //   817: iconst_2
    //   818: new 143	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   825: ldc_w 293
    //   828: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload_1
    //   832: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   841: return
    //   842: iconst_0
    //   843: istore 7
    //   845: goto -662 -> 183
    //   848: iconst_0
    //   849: istore 7
    //   851: goto -666 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	MSFToWebViewConnector
    //   0	854	1	paramIntent	android.content.Intent
    //   0	854	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   61	737	4	localObject2	Object
    //   155	474	5	localObject3	Object
    //   638	12	5	localException	Exception
    //   444	143	6	localObject4	Object
    //   181	669	7	i	int
    //   110	248	8	j	int
    // Exception table:
    //   from	to	target	type
    //   204	236	239	finally
    //   236	238	239	finally
    //   240	242	239	finally
    //   287	368	239	finally
    //   368	370	239	finally
    //   660	675	239	finally
    //   675	684	239	finally
    //   63	88	244	java/lang/RuntimeException
    //   63	88	263	java/lang/Exception
    //   126	135	282	finally
    //   135	180	282	finally
    //   183	185	282	finally
    //   283	285	282	finally
    //   493	531	638	java/lang/Exception
    //   536	603	638	java/lang/Exception
    //   608	635	638	java/lang/Exception
    //   687	702	638	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, AppRuntime paramAppRuntime, Context paramContext, MSFToWebViewConnector.IOnMsgReceiveListener paramIOnMsgReceiveListener)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener = paramIOnMsgReceiveListener;
    this.d = MsfSdkUtils.getProcessName(paramContext);
    if (this.d.equals("com.tencent.mobileqq:MSF")) {
      return;
    }
    a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime.isLogin()) {
      paramAppRuntime.setCmdCallbacker();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSFToWebViewConnector", 2, "not login");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\game\MSFToWebViewConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */