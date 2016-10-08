package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;

public class VideoPlayRecommendHandler
  extends BusinessHandler
{
  public static final int a = 0;
  static final String a;
  public static final int b = 1743;
  public static final String b = "OidbSvc.0x6cf";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "Q.pubaccount.video." + VideoPlayRecommendHandler.class.getSimpleName();
  }
  
  public VideoPlayRecommendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 57	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +863 -> 867
    //   7: aload_3
    //   8: ifnull +859 -> 867
    //   11: iconst_1
    //   12: istore 7
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +30 -> 55
    //   28: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: iconst_2
    //   32: new 22	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   39: ldc 64
    //   41: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload 7
    //   46: invokevirtual 67	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iload 7
    //   57: ifeq +998 -> 1055
    //   60: aload 4
    //   62: astore_2
    //   63: new 73	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   66: dup
    //   67: invokespecial 74	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   70: astore 6
    //   72: aload 4
    //   74: astore_2
    //   75: aload 6
    //   77: aload_3
    //   78: checkcast 76	[B
    //   81: checkcast 76	[B
    //   84: invokevirtual 80	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: aload 4
    //   90: astore_2
    //   91: aload 6
    //   93: getfield 84	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   96: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   99: invokevirtual 96	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   102: astore_3
    //   103: aload 4
    //   105: astore_2
    //   106: new 98	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody
    //   109: dup
    //   110: invokespecial 99	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:<init>	()V
    //   113: astore 6
    //   115: aload 4
    //   117: astore_2
    //   118: aload 6
    //   120: aload_3
    //   121: invokevirtual 100	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: pop
    //   125: aload 4
    //   127: astore_2
    //   128: aload 6
    //   130: getfield 104	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   133: invokevirtual 109	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   136: ifeq +890 -> 1026
    //   139: aload 4
    //   141: astore_2
    //   142: aload 6
    //   144: getfield 104	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   147: invokevirtual 112	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   150: ifnull +876 -> 1026
    //   153: aload 4
    //   155: astore_2
    //   156: aload 6
    //   158: getfield 104	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   161: invokevirtual 112	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   164: astore_3
    //   165: aload 5
    //   167: astore_1
    //   168: aload_3
    //   169: ifnull +815 -> 984
    //   172: aload 5
    //   174: astore_1
    //   175: aload 4
    //   177: astore_2
    //   178: aload_3
    //   179: invokeinterface 117 1 0
    //   184: ifne +800 -> 984
    //   187: aload 4
    //   189: astore_2
    //   190: new 119	java/util/ArrayList
    //   193: dup
    //   194: aload_3
    //   195: invokeinterface 123 1 0
    //   200: invokespecial 126	java/util/ArrayList:<init>	(I)V
    //   203: astore_1
    //   204: aload_3
    //   205: invokeinterface 130 1 0
    //   210: astore_3
    //   211: aload_3
    //   212: invokeinterface 135 1 0
    //   217: ifeq +767 -> 984
    //   220: aload_3
    //   221: invokeinterface 139 1 0
    //   226: checkcast 141	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary
    //   229: astore_2
    //   230: new 143	com/tencent/biz/pubaccount/VideoInfo
    //   233: dup
    //   234: invokespecial 144	com/tencent/biz/pubaccount/VideoInfo:<init>	()V
    //   237: astore 4
    //   239: aload_2
    //   240: getfield 147	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   243: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   246: ifeq +28 -> 274
    //   249: aload_2
    //   250: getfield 147	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: ifnull +18 -> 274
    //   259: aload 4
    //   261: aload_2
    //   262: getfield 147	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   265: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   268: invokevirtual 151	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   271: putfield 154	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   274: aload_2
    //   275: getfield 157	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_summary	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   278: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   281: ifeq +28 -> 309
    //   284: aload_2
    //   285: getfield 157	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_summary	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   291: ifnull +18 -> 309
    //   294: aload 4
    //   296: aload_2
    //   297: getfield 157	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_summary	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   303: invokevirtual 151	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   306: putfield 159	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_2
    //   310: getfield 163	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   313: invokevirtual 166	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   316: ifeq +58 -> 374
    //   319: aload_2
    //   320: getfield 163	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   323: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   326: lconst_0
    //   327: lcmp
    //   328: ifeq +46 -> 374
    //   331: aload 4
    //   333: new 171	java/text/SimpleDateFormat
    //   336: dup
    //   337: ldc -83
    //   339: invokespecial 176	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   342: aload_2
    //   343: getfield 163	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   346: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   349: ldc2_w 177
    //   352: lmul
    //   353: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   356: invokevirtual 188	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   359: putfield 191	com/tencent/biz/pubaccount/VideoInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   362: aload 4
    //   364: aload_2
    //   365: getfield 163	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   368: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   371: putfield 194	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Long	J
    //   374: aload_2
    //   375: getfield 197	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   378: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   381: ifeq +28 -> 409
    //   384: aload_2
    //   385: getfield 197	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   388: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   391: ifnull +18 -> 409
    //   394: aload 4
    //   396: aload_2
    //   397: getfield 197	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   400: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   403: invokevirtual 151	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   406: putfield 200	com/tencent/biz/pubaccount/VideoInfo:i	Ljava/lang/String;
    //   409: aload_2
    //   410: getfield 203	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   413: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   416: ifeq +28 -> 444
    //   419: aload_2
    //   420: getfield 203	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   423: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   426: ifnull +18 -> 444
    //   429: aload 4
    //   431: aload_2
    //   432: getfield 203	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_subscribe_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   435: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   438: invokevirtual 151	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   441: putfield 206	com/tencent/biz/pubaccount/VideoInfo:j	Ljava/lang/String;
    //   444: aload_2
    //   445: getfield 209	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_content_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   448: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   451: ifeq +28 -> 479
    //   454: aload_2
    //   455: getfield 209	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_content_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   458: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   461: ifnull +18 -> 479
    //   464: aload 4
    //   466: aload_2
    //   467: getfield 209	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:bytes_article_content_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   470: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   473: invokevirtual 151	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   476: putfield 212	com/tencent/biz/pubaccount/VideoInfo:f	Ljava/lang/String;
    //   479: aload_2
    //   480: getfield 216	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_strategy_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   483: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   486: ifeq +15 -> 501
    //   489: aload 4
    //   491: aload_2
    //   492: getfield 216	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint32_strategy_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: putfield 223	com/tencent/biz/pubaccount/VideoInfo:jdField_e_of_type_Int	I
    //   501: aload_2
    //   502: getfield 226	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_algorithm_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   505: invokevirtual 166	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   508: ifeq +15 -> 523
    //   511: aload 4
    //   513: aload_2
    //   514: getfield 226	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:uint64_algorithm_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   517: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   520: putfield 228	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Long	J
    //   523: aload_2
    //   524: getfield 231	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   527: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   530: ifeq +193 -> 723
    //   533: aload_2
    //   534: getfield 231	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   537: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   540: astore 5
    //   542: aload 5
    //   544: ifnull +179 -> 723
    //   547: new 233	org/json/JSONObject
    //   550: dup
    //   551: aload_2
    //   552: getfield 231	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:json_video_list	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   555: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   558: invokevirtual 151	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   561: invokespecial 234	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   564: ldc -20
    //   566: invokevirtual 240	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   569: iconst_0
    //   570: invokevirtual 246	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   573: astore_2
    //   574: aload_2
    //   575: ifnull +148 -> 723
    //   578: aload 4
    //   580: aload_2
    //   581: ldc -8
    //   583: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   586: putfield 253	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   589: aload_2
    //   590: ldc -1
    //   592: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   595: ifeq +14 -> 609
    //   598: aload 4
    //   600: aload_2
    //   601: ldc -1
    //   603: invokevirtual 262	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   606: putfield 264	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Int	I
    //   609: aload_2
    //   610: ldc_w 266
    //   613: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   616: ifeq +15 -> 631
    //   619: aload 4
    //   621: aload_2
    //   622: ldc_w 266
    //   625: invokevirtual 262	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   628: putfield 268	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_Int	I
    //   631: aload 4
    //   633: aload_2
    //   634: ldc_w 270
    //   637: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   640: invokestatic 275	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   643: putfield 277	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Int	I
    //   646: aload 4
    //   648: aload_2
    //   649: ldc_w 279
    //   652: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 281	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   658: aload_2
    //   659: ldc_w 283
    //   662: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   665: ifeq +15 -> 680
    //   668: aload 4
    //   670: aload_2
    //   671: ldc_w 283
    //   674: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   677: putfield 286	com/tencent/biz/pubaccount/VideoInfo:g	Ljava/lang/String;
    //   680: aload 4
    //   682: iconst_1
    //   683: putfield 288	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_Int	I
    //   686: aload_2
    //   687: ldc_w 290
    //   690: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   693: ifeq +15 -> 708
    //   696: aload 4
    //   698: aload_2
    //   699: ldc_w 290
    //   702: invokevirtual 262	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   705: putfield 288	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_Int	I
    //   708: aload 4
    //   710: getfield 288	com/tencent/biz/pubaccount/VideoInfo:jdField_d_of_type_Int	I
    //   713: iconst_1
    //   714: if_icmpne +179 -> 893
    //   717: aload 4
    //   719: iconst_1
    //   720: putfield 292	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Boolean	Z
    //   723: aload 4
    //   725: getfield 253	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   728: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   731: ifne +14 -> 745
    //   734: aload 4
    //   736: getfield 154	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   739: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   742: ifeq +232 -> 974
    //   745: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -537 -> 211
    //   751: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   754: iconst_2
    //   755: new 22	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   762: ldc_w 299
    //   765: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload 4
    //   770: getfield 253	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   773: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: ldc_w 301
    //   779: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 4
    //   784: getfield 154	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   787: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 303
    //   793: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload 4
    //   798: getfield 286	com/tencent/biz/pubaccount/VideoInfo:g	Ljava/lang/String;
    //   801: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: goto -599 -> 211
    //   813: astore 4
    //   815: aload_1
    //   816: astore_2
    //   817: aload_2
    //   818: astore_3
    //   819: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   822: ifeq +36 -> 858
    //   825: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   828: iconst_2
    //   829: new 22	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   836: ldc_w 307
    //   839: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload 4
    //   844: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   847: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: aload_2
    //   857: astore_3
    //   858: aload_0
    //   859: iconst_1
    //   860: iload 7
    //   862: aload_3
    //   863: invokespecial 313	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   866: return
    //   867: iconst_0
    //   868: istore 7
    //   870: goto -856 -> 14
    //   873: astore_2
    //   874: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   877: ifeq +201 -> 1078
    //   880: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   883: iconst_2
    //   884: ldc_w 315
    //   887: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: goto +188 -> 1078
    //   893: aload 4
    //   895: iconst_0
    //   896: putfield 292	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_Boolean	Z
    //   899: aload 4
    //   901: aload_2
    //   902: ldc_w 317
    //   905: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   908: putfield 320	com/tencent/biz/pubaccount/VideoInfo:l	Ljava/lang/String;
    //   911: aload 4
    //   913: aload_2
    //   914: ldc_w 322
    //   917: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   920: putfield 325	com/tencent/biz/pubaccount/VideoInfo:m	Ljava/lang/String;
    //   923: aload 4
    //   925: aload_2
    //   926: ldc_w 327
    //   929: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   932: putfield 330	com/tencent/biz/pubaccount/VideoInfo:k	Ljava/lang/String;
    //   935: aload 4
    //   937: aload_2
    //   938: ldc_w 332
    //   941: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   944: putfield 335	com/tencent/biz/pubaccount/VideoInfo:n	Ljava/lang/String;
    //   947: aload 4
    //   949: aload_2
    //   950: ldc_w 337
    //   953: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   956: putfield 340	com/tencent/biz/pubaccount/VideoInfo:o	Ljava/lang/String;
    //   959: aload 4
    //   961: aload_2
    //   962: ldc_w 342
    //   965: invokevirtual 346	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   968: putfield 348	com/tencent/biz/pubaccount/VideoInfo:jdField_b_of_type_Long	J
    //   971: goto -248 -> 723
    //   974: aload_1
    //   975: aload 4
    //   977: invokevirtual 352	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   980: pop
    //   981: goto -770 -> 211
    //   984: aload_1
    //   985: ifnull +14 -> 999
    //   988: aload_1
    //   989: astore_3
    //   990: aload_1
    //   991: astore_2
    //   992: aload_1
    //   993: invokevirtual 353	java/util/ArrayList:isEmpty	()Z
    //   996: ifeq -138 -> 858
    //   999: aload_1
    //   1000: astore_3
    //   1001: aload_1
    //   1002: astore_2
    //   1003: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1006: ifeq -148 -> 858
    //   1009: aload_1
    //   1010: astore_2
    //   1011: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1014: iconst_2
    //   1015: ldc_w 355
    //   1018: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: aload_1
    //   1022: astore_3
    //   1023: goto -165 -> 858
    //   1026: aload_1
    //   1027: astore_3
    //   1028: aload 4
    //   1030: astore_2
    //   1031: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1034: ifeq -176 -> 858
    //   1037: aload 4
    //   1039: astore_2
    //   1040: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1043: iconst_2
    //   1044: ldc_w 357
    //   1047: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: aload_1
    //   1051: astore_3
    //   1052: goto -194 -> 858
    //   1055: aload_1
    //   1056: astore_3
    //   1057: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq -202 -> 858
    //   1063: getstatic 42	com/tencent/biz/pubaccount/VideoPlayRecommendHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1066: iconst_2
    //   1067: ldc_w 359
    //   1070: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1073: aload_1
    //   1074: astore_3
    //   1075: goto -217 -> 858
    //   1078: aconst_null
    //   1079: astore_2
    //   1080: goto -506 -> 574
    //   1083: astore 4
    //   1085: goto -268 -> 817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1088	0	this	VideoPlayRecommendHandler
    //   0	1088	1	paramToServiceMsg	ToServiceMsg
    //   0	1088	2	paramFromServiceMsg	FromServiceMsg
    //   0	1088	3	paramObject	Object
    //   18	779	4	localVideoInfo	VideoInfo
    //   813	225	4	localException1	Exception
    //   1083	1	4	localException2	Exception
    //   15	528	5	localByteStringMicro	ByteStringMicro
    //   70	87	6	localObject	Object
    //   12	857	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   204	211	813	java/lang/Exception
    //   211	274	813	java/lang/Exception
    //   274	309	813	java/lang/Exception
    //   309	374	813	java/lang/Exception
    //   374	409	813	java/lang/Exception
    //   409	444	813	java/lang/Exception
    //   444	479	813	java/lang/Exception
    //   479	501	813	java/lang/Exception
    //   501	523	813	java/lang/Exception
    //   523	542	813	java/lang/Exception
    //   547	574	813	java/lang/Exception
    //   578	609	813	java/lang/Exception
    //   609	631	813	java/lang/Exception
    //   631	680	813	java/lang/Exception
    //   680	708	813	java/lang/Exception
    //   708	723	813	java/lang/Exception
    //   723	745	813	java/lang/Exception
    //   745	810	813	java/lang/Exception
    //   874	890	813	java/lang/Exception
    //   893	971	813	java/lang/Exception
    //   974	981	813	java/lang/Exception
    //   547	574	873	org/json/JSONException
    //   63	72	1083	java/lang/Exception
    //   75	88	1083	java/lang/Exception
    //   91	103	1083	java/lang/Exception
    //   106	115	1083	java/lang/Exception
    //   118	125	1083	java/lang/Exception
    //   128	139	1083	java/lang/Exception
    //   142	153	1083	java/lang/Exception
    //   156	165	1083	java/lang/Exception
    //   178	187	1083	java/lang/Exception
    //   190	204	1083	java/lang/Exception
    //   992	999	1083	java/lang/Exception
    //   1003	1009	1083	java/lang/Exception
    //   1011	1021	1083	java/lang/Exception
    //   1031	1037	1083	java/lang/Exception
    //   1040	1050	1083	java/lang/Exception
  }
  
  protected Class a()
  {
    return VideoPlayRecommendObserver.class;
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "getRecommendList()  articleId" + paramString);
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localReqBody.bytes_inner_id.set(paramString);
    localReqBody.uint64_uin.set(paramLong);
    super.b(super.a("OidbSvc.0x6cf", 1743, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoPlayRecommendHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */