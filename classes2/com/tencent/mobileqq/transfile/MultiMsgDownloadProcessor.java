package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMsgDownloadProcessor
  extends BaseDownloadProcessor
{
  private byte[] a;
  private int aJ;
  private byte[] b;
  private byte[] c;
  private String i;
  
  public MultiMsgDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.l.getBytes();
    this.aJ = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 52	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 59	java/io/File:exists	()Z
    //   11: ifne +30 -> 41
    //   14: aload_0
    //   15: ldc 61
    //   17: new 63	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   24: ldc 68
    //   26: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 81	java/io/RandomAccessFile
    //   44: dup
    //   45: aload_1
    //   46: ldc 83
    //   48: invokespecial 85	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: invokevirtual 89	java/io/RandomAccessFile:length	()J
    //   58: l2i
    //   59: newarray <illegal type>
    //   61: astore 4
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: aload 4
    //   68: invokevirtual 93	java/io/RandomAccessFile:read	([B)I
    //   71: istore 5
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   81: aload 4
    //   83: ifnull +14 -> 97
    //   86: aload 4
    //   88: arraylength
    //   89: ifle +8 -> 97
    //   92: iload 5
    //   94: ifgt +135 -> 229
    //   97: aload_0
    //   98: ldc 61
    //   100: ldc 98
    //   102: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   112: goto -31 -> 81
    //   115: astore 4
    //   117: aconst_null
    //   118: astore_3
    //   119: aload_3
    //   120: astore_2
    //   121: aload 4
    //   123: invokevirtual 102	java/io/FileNotFoundException:printStackTrace	()V
    //   126: aload_3
    //   127: astore_2
    //   128: aload_0
    //   129: ldc 61
    //   131: new 63	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   138: ldc 68
    //   140: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   168: goto -7 -> 161
    //   171: astore_1
    //   172: aconst_null
    //   173: astore_3
    //   174: aload_3
    //   175: astore_2
    //   176: aload_0
    //   177: ldc 61
    //   179: ldc 104
    //   181: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_3
    //   185: astore_2
    //   186: aload_1
    //   187: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   205: goto -7 -> 198
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_2
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: aload 4
    //   231: arraylength
    //   232: istore 5
    //   234: aload 4
    //   236: iconst_0
    //   237: baload
    //   238: bipush 40
    //   240: if_icmpne +15 -> 255
    //   243: aload 4
    //   245: iload 5
    //   247: iconst_1
    //   248: isub
    //   249: baload
    //   250: bipush 41
    //   252: if_icmpeq +82 -> 334
    //   255: new 63	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   262: ldc 106
    //   264: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: iload 5
    //   269: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc 111
    //   274: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore_1
    //   281: aload 4
    //   283: invokevirtual 114	java/lang/Object:toString	()Ljava/lang/String;
    //   286: astore_2
    //   287: new 63	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   294: aload_1
    //   295: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: astore_3
    //   299: aload_2
    //   300: astore_1
    //   301: aload_2
    //   302: invokevirtual 117	java/lang/String:length	()I
    //   305: bipush 20
    //   307: if_icmple +11 -> 318
    //   310: aload_2
    //   311: iconst_0
    //   312: bipush 20
    //   314: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   317: astore_1
    //   318: aload_0
    //   319: ldc 61
    //   321: aload_3
    //   322: aload_1
    //   323: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: iconst_0
    //   333: ireturn
    //   334: new 123	java/io/DataInputStream
    //   337: dup
    //   338: new 125	java/io/ByteArrayInputStream
    //   341: dup
    //   342: aload 4
    //   344: invokespecial 128	java/io/ByteArrayInputStream:<init>	([B)V
    //   347: invokespecial 131	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   350: astore_2
    //   351: aload_2
    //   352: invokevirtual 135	java/io/DataInputStream:readByte	()B
    //   355: pop
    //   356: aload_2
    //   357: invokevirtual 138	java/io/DataInputStream:readInt	()I
    //   360: istore 7
    //   362: aload_2
    //   363: invokevirtual 138	java/io/DataInputStream:readInt	()I
    //   366: istore 6
    //   368: iload 7
    //   370: iload 5
    //   372: if_icmpgt +10 -> 382
    //   375: iload 6
    //   377: iload 5
    //   379: if_icmple +41 -> 420
    //   382: aload_0
    //   383: ldc 61
    //   385: new 63	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   392: ldc -116
    //   394: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: iload 7
    //   399: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: ldc -114
    //   404: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload 6
    //   409: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: iconst_0
    //   419: ireturn
    //   420: iload 7
    //   422: ifle +436 -> 858
    //   425: iload 7
    //   427: newarray <illegal type>
    //   429: astore_1
    //   430: aload_2
    //   431: aload_1
    //   432: invokevirtual 143	java/io/DataInputStream:read	([B)I
    //   435: pop
    //   436: new 145	tencent/im/msg/im_msg_head$Head
    //   439: dup
    //   440: invokespecial 146	tencent/im/msg/im_msg_head$Head:<init>	()V
    //   443: astore_3
    //   444: aload_3
    //   445: aload_1
    //   446: invokevirtual 150	tencent/im/msg/im_msg_head$Head:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   449: pop
    //   450: aload_3
    //   451: getfield 154	tencent/im/msg/im_msg_head$Head:msg_httpconn_head	Ltencent/im/msg/im_msg_head$HttpConnHead;
    //   454: invokevirtual 160	tencent/im/msg/im_msg_head$HttpConnHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: checkcast 156	tencent/im/msg/im_msg_head$HttpConnHead
    //   460: getfield 164	tencent/im/msg/im_msg_head$HttpConnHead:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   463: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   466: istore 5
    //   468: goto +393 -> 861
    //   471: aload_0
    //   472: ldc 61
    //   474: new 63	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   481: ldc -86
    //   483: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: iload 6
    //   488: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc -84
    //   493: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: iload 5
    //   498: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: iconst_0
    //   508: ireturn
    //   509: iload 6
    //   511: newarray <illegal type>
    //   513: astore_1
    //   514: aload_2
    //   515: aload_1
    //   516: invokevirtual 143	java/io/DataInputStream:read	([B)I
    //   519: pop
    //   520: new 174	com/tencent/qphone/base/util/Cryptor
    //   523: dup
    //   524: invokespecial 175	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   527: aload_1
    //   528: aload_0
    //   529: getfield 177	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   532: invokevirtual 181	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   535: astore_2
    //   536: aload_2
    //   537: ifnull +8 -> 545
    //   540: aload_2
    //   541: arraylength
    //   542: ifgt +13 -> 555
    //   545: aload_0
    //   546: ldc 61
    //   548: ldc -73
    //   550: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: iconst_0
    //   554: ireturn
    //   555: new 185	tencent/im/longconn/longmsg/LongMsg$RspBody
    //   558: dup
    //   559: invokespecial 186	tencent/im/longconn/longmsg/LongMsg$RspBody:<init>	()V
    //   562: astore_3
    //   563: aload_3
    //   564: aload_2
    //   565: invokevirtual 187	tencent/im/longconn/longmsg/LongMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   568: pop
    //   569: aload_3
    //   570: getfield 191	tencent/im/longconn/longmsg/LongMsg$RspBody:rpt_msg_down_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   573: iconst_0
    //   574: invokevirtual 196	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   577: checkcast 198	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp
    //   580: astore_2
    //   581: aload_2
    //   582: ifnonnull +13 -> 595
    //   585: aload_0
    //   586: ldc 61
    //   588: ldc -56
    //   590: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: iconst_0
    //   594: ireturn
    //   595: aload_2
    //   596: getfield 203	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   599: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   602: ifne +13 -> 615
    //   605: aload_0
    //   606: ldc 61
    //   608: ldc -48
    //   610: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: iconst_0
    //   614: ireturn
    //   615: aload_2
    //   616: getfield 203	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   619: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   622: ifeq +13 -> 635
    //   625: aload_0
    //   626: ldc 61
    //   628: ldc -46
    //   630: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: iconst_0
    //   634: ireturn
    //   635: aload_2
    //   636: getfield 214	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   639: invokevirtual 217	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   642: ifne +13 -> 655
    //   645: aload_0
    //   646: ldc 61
    //   648: ldc -37
    //   650: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: iconst_0
    //   654: ireturn
    //   655: aload_0
    //   656: aload_2
    //   657: getfield 214	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   660: invokevirtual 222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   663: invokevirtual 227	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   666: putfield 229	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   669: aload_0
    //   670: getfield 229	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   673: ifnull +11 -> 684
    //   676: aload_0
    //   677: getfield 229	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   680: arraylength
    //   681: ifgt +13 -> 694
    //   684: aload_0
    //   685: ldc 61
    //   687: ldc -25
    //   689: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: iconst_0
    //   693: ireturn
    //   694: aload_0
    //   695: ldc 61
    //   697: new 63	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   704: ldc -23
    //   706: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload_1
    //   710: invokestatic 239	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   713: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   722: aload_0
    //   723: ldc 61
    //   725: new 63	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   732: ldc -15
    //   734: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload_1
    //   738: arraylength
    //   739: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_0
    //   749: ldc 61
    //   751: new 63	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   758: ldc -13
    //   760: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload_0
    //   764: getfield 229	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   767: invokestatic 239	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   770: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: aload_0
    //   780: ldc 61
    //   782: new 63	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   789: ldc -11
    //   791: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload_0
    //   795: getfield 229	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   798: arraylength
    //   799: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   802: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iconst_1
    //   809: ireturn
    //   810: astore_1
    //   811: aload_1
    //   812: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   815: aload_0
    //   816: ldc 61
    //   818: new 63	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   825: ldc -8
    //   827: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload_1
    //   831: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   834: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokevirtual 79	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: iconst_0
    //   844: ireturn
    //   845: astore_1
    //   846: goto -635 -> 211
    //   849: astore_1
    //   850: goto -676 -> 174
    //   853: astore 4
    //   855: goto -736 -> 119
    //   858: iconst_0
    //   859: istore 5
    //   861: iload 6
    //   863: ifle -392 -> 471
    //   866: iload 5
    //   868: ifeq -359 -> 509
    //   871: goto -400 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	MultiMsgDownloadProcessor
    //   0	874	1	paramString	String
    //   53	163	2	localObject1	Object
    //   221	2	2	localIOException	java.io.IOException
    //   286	371	2	localObject2	Object
    //   51	519	3	localObject3	Object
    //   61	26	4	arrayOfByte	byte[]
    //   115	228	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   853	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   71	796	5	j	int
    //   366	496	6	k	int
    //   360	66	7	m	int
    // Exception table:
    //   from	to	target	type
    //   77	81	107	java/io/IOException
    //   41	52	115	java/io/FileNotFoundException
    //   157	161	163	java/io/IOException
    //   41	52	171	java/io/IOException
    //   194	198	200	java/io/IOException
    //   41	52	208	finally
    //   215	219	221	java/io/IOException
    //   334	368	810	java/lang/Exception
    //   382	418	810	java/lang/Exception
    //   425	468	810	java/lang/Exception
    //   471	507	810	java/lang/Exception
    //   509	536	810	java/lang/Exception
    //   540	545	810	java/lang/Exception
    //   545	553	810	java/lang/Exception
    //   555	581	810	java/lang/Exception
    //   585	593	810	java/lang/Exception
    //   595	613	810	java/lang/Exception
    //   615	633	810	java/lang/Exception
    //   635	653	810	java/lang/Exception
    //   655	684	810	java/lang/Exception
    //   684	692	810	java/lang/Exception
    //   694	808	810	java/lang/Exception
    //   54	63	845	finally
    //   65	73	845	finally
    //   121	126	845	finally
    //   128	153	845	finally
    //   176	184	845	finally
    //   186	190	845	finally
    //   54	63	849	java/io/IOException
    //   65	73	849	java/io/IOException
    //   54	63	853	java/io/FileNotFoundException
    //   65	73	853	java/io/FileNotFoundException
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq.MultiMsgDownReq localMultiMsgDownReq = new RichProto.RichProtoReq.MultiMsgDownReq();
    localMultiMsgDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localMultiMsgDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localMultiMsgDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localMultiMsgDownReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localMultiMsgDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "multi_msg_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localMultiMsgDownReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  private void f()
  {
    Object localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    String str = "http://" + ((ServerAddr)localObject).jdField_a_of_type_JavaLangString;
    if (((ServerAddr)localObject).jdField_b_of_type_Int != 80) {
      str = str + ":" + ((ServerAddr)localObject).jdField_b_of_type_Int;
    }
    for (;;)
    {
      str = str + this.jdField_d_of_type_JavaLangString;
      this.jdField_i_of_type_JavaLangString = AbsDownloader.d(str);
      localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = str;
      ((HttpNetReq)localObject).jdField_c_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject).jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      ((HttpNetReq)localObject).jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject).o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject).jdField_a_of_type_Long = 0L;
      ((HttpNetReq)localObject).f = true;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      a("httpDown", "url:" + str + ",downOffset:" + ((HttpNetReq)localObject).jdField_a_of_type_Long);
      if (!e()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
      r();
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
      return;
    }
  }
  
  public void a()
  {
    d(1000);
    d(2001);
    e();
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
    if (paramNetResp.jdField_e_of_type_Int == 0)
    {
      bool1 = true;
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.jdField_e_of_type_Int != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.b + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a.jdField_e_of_type_JavaLangString = ((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramNetResp.jdField_e_of_type_Int != 0) || (!a(this.jdField_i_of_type_JavaLangString))) {
        break label157;
      }
      c();
      return;
      bool1 = false;
      break;
    }
    label157:
    if ((paramNetResp.f == 9364) && (this.aW < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.aW += 1;
      q();
      e();
      return;
    }
    b();
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp == null) {
      b();
    }
    for (;;)
    {
      return;
      int j = 0;
      while (j < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(j);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label111;
        }
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_d_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_ArrayOfByte = paramRichProtoReq.jdField_b_of_type_ArrayOfByte;
        f();
        j += 1;
      }
    }
    label111:
    b();
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) {}
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int k = this.aX;
    int j;
    long l;
    if (paramBoolean)
    {
      j = 2;
      this.aX = (j | k);
      l = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      String str = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      if (!paramBoolean) {
        break label227;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgDownload", true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      return;
      j = 1;
      break;
      label227:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgDownload", false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_b_of_type_Int = -1;
      localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
      localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString = "[MultiMsgDownloadProcessor] download failed";
      localDownResult.jdField_a_of_type_ArrayOfByte = null;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(localDownResult);
    }
    this.jdField_c_of_type_ArrayOfByte = null;
    d(2005);
  }
  
  public int c()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    return 0;
  }
  
  void c()
  {
    super.c();
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      localObject1 = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject1).jdField_b_of_type_Int = 0;
      ((DownCallBack.DownResult)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
      ((DownCallBack.DownResult)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      ((DownCallBack.DownResult)localObject1).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((DownCallBack.DownResult)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a((DownCallBack.DownResult)localObject1);
    }
    for (;;)
    {
      this.jdField_c_of_type_ArrayOfByte = null;
      d(2003);
      return;
      localObject1 = new HashMap();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_c_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        MultiMsgManager.a().a((HashMap)localObject1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "BaseTransProcessoronSuccess.onDownload,MultiMsg ");
        }
      }
    }
  }
  
  protected void r()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.aJ)) {
        break label56;
      }
      str = "multimsgCd";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label56:
      if (this.aJ == 1) {
        str = "multimsgGd";
      } else {
        str = "multimsgDd";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\MultiMsgDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */