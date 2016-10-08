package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.URLUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VideoUploadHelper
{
  public static final int a = 3;
  public static final String a = "Q.qqstory.publish:VideoUploadHelper";
  private static final int jdField_b_of_type_Int = 10000;
  public static final String b = "ver";
  private static final int c = 20000;
  public static final String c = "seq";
  public static final String d = "openid";
  public static final String e = "authkey";
  public static final String f = "rangestart";
  public static final String g = "rangeend";
  public static final String h = "filetype";
  public static final String i = "filekey";
  public static final String j = "totalsize";
  public static final String k = "bid";
  public static final String l = "filedata";
  public static final String m = "filemd5";
  public static final String n = "isneedbitmap";
  public static final String o = "fileid";
  public static final String p = "filebitmap";
  public static final String q = "retcode";
  public static final String r = "cdnurl";
  public static final String s = "0";
  public static final String t = "8";
  public static final String u = "2307";
  public static final String v = "10012";
  private String A;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int d;
  private String w;
  private String x;
  private String y;
  private String z;
  
  public VideoUploadHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = QQStoryContext.a();
  }
  
  /* Error */
  private VideoUploadHelper.UploadResult a(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   3: lstore 9
    //   5: new 116	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult
    //   8: dup
    //   9: invokespecial 117	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_0
    //   17: getfield 119	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:z	Ljava/lang/String;
    //   20: putfield 121	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:d	Ljava/lang/String;
    //   23: aload 5
    //   25: iload_1
    //   26: putfield 123	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Int	I
    //   29: aload 5
    //   31: aload_0
    //   32: getfield 125	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:w	Ljava/lang/String;
    //   35: invokestatic 130	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/lang/String;)J
    //   38: putfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   41: aload 5
    //   43: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifne +22 -> 70
    //   51: aload 5
    //   53: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   56: dup
    //   57: ldc -120
    //   59: ldc -118
    //   61: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   64: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   67: aload 5
    //   69: areturn
    //   70: aload_0
    //   71: getfield 146	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:d	I
    //   74: sipush 1024
    //   77: iadd
    //   78: invokestatic 152	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   81: astore 4
    //   83: aload 4
    //   85: invokevirtual 156	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   88: pop
    //   89: aload_0
    //   90: getfield 158	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:y	Ljava/lang/String;
    //   93: astore_2
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 160	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:x	Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 158	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:y	Ljava/lang/String;
    //   103: aload 5
    //   105: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   108: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 168	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:jdField_a_of_type_ArrayOfByte	[B
    //   115: aload_2
    //   116: invokestatic 171	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/nio/ByteBuffer;
    //   119: putfield 173	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   122: iload_1
    //   123: ifeq +172 -> 295
    //   126: iconst_1
    //   127: istore 13
    //   129: aconst_null
    //   130: astore_2
    //   131: new 175	java/io/RandomAccessFile
    //   134: dup
    //   135: aload_0
    //   136: getfield 125	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:w	Ljava/lang/String;
    //   139: ldc -80
    //   141: invokespecial 179	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: astore_3
    //   145: iload_1
    //   146: i2l
    //   147: lstore 11
    //   149: aload_3
    //   150: astore_2
    //   151: aload_3
    //   152: lload 11
    //   154: invokevirtual 183	java/io/RandomAccessFile:seek	(J)V
    //   157: aload_3
    //   158: astore_2
    //   159: aload_3
    //   160: aload_0
    //   161: getfield 185	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:b	[B
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 146	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:d	I
    //   169: invokevirtual 189	java/io/RandomAccessFile:read	([BII)I
    //   172: istore 8
    //   174: iload 8
    //   176: iconst_m1
    //   177: if_icmpne +124 -> 301
    //   180: aload_3
    //   181: astore_2
    //   182: ldc 10
    //   184: ldc -65
    //   186: invokestatic 195	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_3
    //   190: astore_2
    //   191: aload 5
    //   193: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   196: dup
    //   197: ldc -60
    //   199: ldc -65
    //   201: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   204: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   215: aload 5
    //   217: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   220: lload 9
    //   222: lsub
    //   223: putfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   226: aload 5
    //   228: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   231: lconst_0
    //   232: lcmp
    //   233: ifle +913 -> 1146
    //   236: aload 5
    //   238: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   241: aload 5
    //   243: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   246: ldiv
    //   247: lstore 9
    //   249: aload 5
    //   251: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   254: invokevirtual 205	com/tencent/biz/qqstory/base/ErrorMessage:isSuccess	()Z
    //   257: ifeq +240 -> 497
    //   260: ldc -49
    //   262: astore_2
    //   263: ldc 10
    //   265: ldc -47
    //   267: aload_2
    //   268: aload 5
    //   270: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   273: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: aload 5
    //   278: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   281: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   284: lload 9
    //   286: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   289: invokestatic 217	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   292: aload 5
    //   294: areturn
    //   295: iconst_0
    //   296: istore 13
    //   298: goto -169 -> 129
    //   301: iconst_0
    //   302: istore 6
    //   304: iload 13
    //   306: istore 14
    //   308: iload_1
    //   309: istore 7
    //   311: iload 6
    //   313: iconst_3
    //   314: if_icmpge +96 -> 410
    //   317: aload_3
    //   318: astore_2
    //   319: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   322: lstore 11
    //   324: aload_3
    //   325: astore_2
    //   326: aload_0
    //   327: aload_0
    //   328: getfield 219	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:A	Ljava/lang/String;
    //   331: iload 13
    //   333: iload_1
    //   334: iload 8
    //   336: aload 4
    //   338: aload 5
    //   340: invokespecial 222	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:a	(Ljava/lang/String;ZIILjava/nio/ByteBuffer;Lcom/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult;)V
    //   343: aload_3
    //   344: astore_2
    //   345: aload 5
    //   347: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   350: invokevirtual 205	com/tencent/biz/qqstory/base/ErrorMessage:isSuccess	()Z
    //   353: ifeq +94 -> 447
    //   356: iconst_0
    //   357: istore 14
    //   359: iload_1
    //   360: iload 8
    //   362: iadd
    //   363: istore 7
    //   365: aload_3
    //   366: astore_2
    //   367: aload 5
    //   369: iload 7
    //   371: putfield 123	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Int	I
    //   374: aload_3
    //   375: astore_2
    //   376: ldc 10
    //   378: ldc -32
    //   380: iload 8
    //   382: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   388: lload 11
    //   390: lsub
    //   391: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   394: iload 7
    //   396: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: aload 5
    //   401: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   404: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: invokestatic 217	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   410: aload_3
    //   411: astore_2
    //   412: aload 5
    //   414: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   417: invokevirtual 232	com/tencent/biz/qqstory/base/ErrorMessage:isFail	()Z
    //   420: ifne -213 -> 207
    //   423: iload 14
    //   425: istore 13
    //   427: iload 7
    //   429: istore_1
    //   430: aload_3
    //   431: astore_2
    //   432: iload 7
    //   434: i2l
    //   435: aload 5
    //   437: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   440: lcmp
    //   441: ifne -284 -> 157
    //   444: goto -237 -> 207
    //   447: aload_3
    //   448: astore_2
    //   449: ldc 10
    //   451: ldc -22
    //   453: iconst_1
    //   454: anewarray 4	java/lang/Object
    //   457: dup
    //   458: iconst_0
    //   459: iload 8
    //   461: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: aastore
    //   465: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   468: aload_3
    //   469: astore_2
    //   470: ldc2_w 238
    //   473: invokestatic 244	java/lang/Thread:sleep	(J)V
    //   476: iload 6
    //   478: iconst_1
    //   479: iadd
    //   480: istore 6
    //   482: goto -178 -> 304
    //   485: astore_2
    //   486: ldc 10
    //   488: ldc -10
    //   490: aload_2
    //   491: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   494: goto -279 -> 215
    //   497: ldc -5
    //   499: astore_2
    //   500: goto -237 -> 263
    //   503: astore_3
    //   504: ldc 10
    //   506: new 253	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 256
    //   516: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: getfield 125	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:w	Ljava/lang/String;
    //   523: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: aload_3
    //   530: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload 5
    //   535: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   538: dup
    //   539: ldc_w 265
    //   542: aload_3
    //   543: invokevirtual 268	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   546: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   549: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   552: aload_2
    //   553: ifnull +7 -> 560
    //   556: aload_2
    //   557: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   560: aload 5
    //   562: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   565: lload 9
    //   567: lsub
    //   568: putfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   571: aload 5
    //   573: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   576: lconst_0
    //   577: lcmp
    //   578: ifle +562 -> 1140
    //   581: aload 5
    //   583: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   586: aload 5
    //   588: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   591: ldiv
    //   592: lstore 9
    //   594: aload 5
    //   596: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   599: invokevirtual 205	com/tencent/biz/qqstory/base/ErrorMessage:isSuccess	()Z
    //   602: ifeq +50 -> 652
    //   605: ldc -49
    //   607: astore_2
    //   608: ldc 10
    //   610: ldc -47
    //   612: aload_2
    //   613: aload 5
    //   615: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   618: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: aload 5
    //   623: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   626: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   629: lload 9
    //   631: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   634: invokestatic 217	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   637: aload 5
    //   639: areturn
    //   640: astore_2
    //   641: ldc 10
    //   643: ldc -10
    //   645: aload_2
    //   646: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   649: goto -89 -> 560
    //   652: ldc -5
    //   654: astore_2
    //   655: goto -47 -> 608
    //   658: astore 4
    //   660: aconst_null
    //   661: astore_3
    //   662: aload_3
    //   663: astore_2
    //   664: ldc 10
    //   666: new 253	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   673: ldc_w 256
    //   676: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_0
    //   680: getfield 125	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:w	Ljava/lang/String;
    //   683: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: aload 4
    //   691: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   694: aload_3
    //   695: astore_2
    //   696: aload 5
    //   698: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   701: dup
    //   702: ldc_w 269
    //   705: aload 4
    //   707: invokevirtual 270	java/io/IOException:getMessage	()Ljava/lang/String;
    //   710: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   713: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   716: aload_3
    //   717: ifnull +7 -> 724
    //   720: aload_3
    //   721: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   724: aload 5
    //   726: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   729: lload 9
    //   731: lsub
    //   732: putfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   735: aload 5
    //   737: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   740: lconst_0
    //   741: lcmp
    //   742: ifle +392 -> 1134
    //   745: aload 5
    //   747: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   750: aload 5
    //   752: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   755: ldiv
    //   756: lstore 9
    //   758: aload 5
    //   760: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   763: invokevirtual 205	com/tencent/biz/qqstory/base/ErrorMessage:isSuccess	()Z
    //   766: ifeq +50 -> 816
    //   769: ldc -49
    //   771: astore_2
    //   772: ldc 10
    //   774: ldc -47
    //   776: aload_2
    //   777: aload 5
    //   779: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   782: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   785: aload 5
    //   787: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   790: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   793: lload 9
    //   795: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   798: invokestatic 217	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   801: aload 5
    //   803: areturn
    //   804: astore_2
    //   805: ldc 10
    //   807: ldc -10
    //   809: aload_2
    //   810: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   813: goto -89 -> 724
    //   816: ldc -5
    //   818: astore_2
    //   819: goto -47 -> 772
    //   822: astore 4
    //   824: aconst_null
    //   825: astore_3
    //   826: aload_3
    //   827: astore_2
    //   828: ldc 10
    //   830: new 253	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   837: ldc_w 256
    //   840: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload_0
    //   844: getfield 125	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:w	Ljava/lang/String;
    //   847: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: aload 4
    //   855: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   858: aload_3
    //   859: astore_2
    //   860: aload 5
    //   862: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   865: dup
    //   866: ldc_w 271
    //   869: aload 4
    //   871: invokevirtual 272	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   874: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   877: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   880: aload_3
    //   881: ifnull +7 -> 888
    //   884: aload_3
    //   885: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   888: aload 5
    //   890: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   893: lload 9
    //   895: lsub
    //   896: putfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   899: aload 5
    //   901: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   904: lconst_0
    //   905: lcmp
    //   906: ifle +222 -> 1128
    //   909: aload 5
    //   911: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   914: aload 5
    //   916: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   919: ldiv
    //   920: lstore 9
    //   922: aload 5
    //   924: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   927: invokevirtual 205	com/tencent/biz/qqstory/base/ErrorMessage:isSuccess	()Z
    //   930: ifeq +50 -> 980
    //   933: ldc -49
    //   935: astore_2
    //   936: ldc 10
    //   938: ldc -47
    //   940: aload_2
    //   941: aload 5
    //   943: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   946: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   949: aload 5
    //   951: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   954: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   957: lload 9
    //   959: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   962: invokestatic 217	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   965: aload 5
    //   967: areturn
    //   968: astore_2
    //   969: ldc 10
    //   971: ldc -10
    //   973: aload_2
    //   974: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   977: goto -89 -> 888
    //   980: ldc -5
    //   982: astore_2
    //   983: goto -47 -> 936
    //   986: astore_3
    //   987: aconst_null
    //   988: astore_2
    //   989: aload_2
    //   990: ifnull +7 -> 997
    //   993: aload_2
    //   994: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   997: aload 5
    //   999: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   1002: lload 9
    //   1004: lsub
    //   1005: putfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   1008: aload 5
    //   1010: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   1013: lconst_0
    //   1014: lcmp
    //   1015: ifle +107 -> 1122
    //   1018: aload 5
    //   1020: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   1023: aload 5
    //   1025: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   1028: ldiv
    //   1029: lstore 9
    //   1031: aload 5
    //   1033: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1036: invokevirtual 205	com/tencent/biz/qqstory/base/ErrorMessage:isSuccess	()Z
    //   1039: ifeq +49 -> 1088
    //   1042: ldc -49
    //   1044: astore_2
    //   1045: ldc 10
    //   1047: ldc -47
    //   1049: aload_2
    //   1050: aload 5
    //   1052: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   1055: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1058: aload 5
    //   1060: getfield 201	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_Long	J
    //   1063: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1066: lload 9
    //   1068: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1071: invokestatic 217	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1074: aload_3
    //   1075: athrow
    //   1076: astore_2
    //   1077: ldc 10
    //   1079: ldc -10
    //   1081: aload_2
    //   1082: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1085: goto -88 -> 997
    //   1088: ldc -5
    //   1090: astore_2
    //   1091: goto -46 -> 1045
    //   1094: astore_3
    //   1095: goto -106 -> 989
    //   1098: astore_3
    //   1099: goto -110 -> 989
    //   1102: astore 4
    //   1104: goto -278 -> 826
    //   1107: astore 4
    //   1109: goto -447 -> 662
    //   1112: astore 4
    //   1114: aload_3
    //   1115: astore_2
    //   1116: aload 4
    //   1118: astore_3
    //   1119: goto -615 -> 504
    //   1122: lconst_0
    //   1123: lstore 9
    //   1125: goto -94 -> 1031
    //   1128: lconst_0
    //   1129: lstore 9
    //   1131: goto -209 -> 922
    //   1134: lconst_0
    //   1135: lstore 9
    //   1137: goto -379 -> 758
    //   1140: lconst_0
    //   1141: lstore 9
    //   1143: goto -549 -> 594
    //   1146: lconst_0
    //   1147: lstore 9
    //   1149: goto -900 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1152	0	this	VideoUploadHelper
    //   0	1152	1	paramInt	int
    //   93	377	2	localObject1	Object
    //   485	6	2	localIOException1	java.io.IOException
    //   499	114	2	str1	String
    //   640	6	2	localIOException2	java.io.IOException
    //   654	123	2	localObject2	Object
    //   804	6	2	localIOException3	java.io.IOException
    //   818	123	2	localObject3	Object
    //   968	6	2	localIOException4	java.io.IOException
    //   982	68	2	str2	String
    //   1076	6	2	localIOException5	java.io.IOException
    //   1090	26	2	localObject4	Object
    //   144	325	3	localRandomAccessFile	java.io.RandomAccessFile
    //   503	40	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   661	224	3	localObject5	Object
    //   986	89	3	localObject6	Object
    //   1094	1	3	localObject7	Object
    //   1098	17	3	localObject8	Object
    //   1118	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   81	256	4	localByteBuffer	ByteBuffer
    //   658	48	4	localIOException6	java.io.IOException
    //   822	48	4	localException1	Exception
    //   1102	1	4	localException2	Exception
    //   1107	1	4	localIOException7	java.io.IOException
    //   1112	5	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   12	1047	5	localUploadResult	VideoUploadHelper.UploadResult
    //   302	179	6	i1	int
    //   309	124	7	i2	int
    //   172	288	8	i3	int
    //   3	1145	9	l1	long
    //   147	242	11	l2	long
    //   127	299	13	bool1	boolean
    //   306	118	14	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   211	215	485	java/io/IOException
    //   131	145	503	java/io/FileNotFoundException
    //   556	560	640	java/io/IOException
    //   131	145	658	java/io/IOException
    //   720	724	804	java/io/IOException
    //   131	145	822	java/lang/Exception
    //   884	888	968	java/io/IOException
    //   131	145	986	finally
    //   993	997	1076	java/io/IOException
    //   151	157	1094	finally
    //   159	174	1094	finally
    //   182	189	1094	finally
    //   191	207	1094	finally
    //   319	324	1094	finally
    //   326	343	1094	finally
    //   345	356	1094	finally
    //   367	374	1094	finally
    //   376	410	1094	finally
    //   412	423	1094	finally
    //   432	444	1094	finally
    //   449	468	1094	finally
    //   470	476	1094	finally
    //   664	694	1094	finally
    //   696	716	1094	finally
    //   828	858	1094	finally
    //   860	880	1094	finally
    //   504	552	1098	finally
    //   151	157	1102	java/lang/Exception
    //   159	174	1102	java/lang/Exception
    //   182	189	1102	java/lang/Exception
    //   191	207	1102	java/lang/Exception
    //   319	324	1102	java/lang/Exception
    //   326	343	1102	java/lang/Exception
    //   345	356	1102	java/lang/Exception
    //   367	374	1102	java/lang/Exception
    //   376	410	1102	java/lang/Exception
    //   412	423	1102	java/lang/Exception
    //   432	444	1102	java/lang/Exception
    //   449	468	1102	java/lang/Exception
    //   470	476	1102	java/lang/Exception
    //   151	157	1107	java/io/IOException
    //   159	174	1107	java/io/IOException
    //   182	189	1107	java/io/IOException
    //   191	207	1107	java/io/IOException
    //   319	324	1107	java/io/IOException
    //   326	343	1107	java/io/IOException
    //   345	356	1107	java/io/IOException
    //   367	374	1107	java/io/IOException
    //   376	410	1107	java/io/IOException
    //   412	423	1107	java/io/IOException
    //   432	444	1107	java/io/IOException
    //   449	468	1107	java/io/IOException
    //   470	476	1107	java/io/IOException
    //   151	157	1112	java/io/FileNotFoundException
    //   159	174	1112	java/io/FileNotFoundException
    //   182	189	1112	java/io/FileNotFoundException
    //   191	207	1112	java/io/FileNotFoundException
    //   319	324	1112	java/io/FileNotFoundException
    //   326	343	1112	java/io/FileNotFoundException
    //   345	356	1112	java/io/FileNotFoundException
    //   367	374	1112	java/io/FileNotFoundException
    //   376	410	1112	java/io/FileNotFoundException
    //   412	423	1112	java/io/FileNotFoundException
    //   432	444	1112	java/io/FileNotFoundException
    //   449	468	1112	java/io/FileNotFoundException
    //   470	476	1112	java/io/FileNotFoundException
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    Map localMap;
    do
    {
      do
      {
        return paramString1;
        i1 = paramString1.indexOf("?");
      } while (-1 == i1);
      localMap = URLUtil.b(paramString1.substring(i1 + 1));
    } while (localMap.remove(paramString2) == null);
    paramString1 = paramString1.substring(0, i1 + 1);
    Iterator localIterator = localMap.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      paramString2 = (String)localIterator.next();
      paramString2 = paramString1 + '&' + URLUtil.a(paramString2) + '=' + URLUtil.a((String)localMap.get(paramString2));
      paramString1 = paramString2;
      if (i1 == 0) {
        paramString1 = paramString2.replace("&", "");
      }
      i1 += 1;
    }
    return paramString1;
  }
  
  private static ByteBuffer a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1024);
    localByteBuffer.clear();
    TLVHelper.a(localByteBuffer, "ver", "0");
    TLVHelper.a(localByteBuffer, "seq", "8");
    TLVHelper.a(localByteBuffer, "openid", paramString1);
    TLVHelper.a(localByteBuffer, "authkey", paramArrayOfByte, paramArrayOfByte.length);
    TLVHelper.a(localByteBuffer, "filetype", "2307");
    TLVHelper.a(localByteBuffer, "filekey", paramString4);
    TLVHelper.a(localByteBuffer, "totalsize", paramString3);
    TLVHelper.a(localByteBuffer, "bid", "10012");
    TLVHelper.a(localByteBuffer, "filemd5", paramString2);
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  /* Error */
  private void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, VideoUploadHelper.UploadResult paramUploadResult)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 17
    //   3: aconst_null
    //   4: astore 18
    //   6: aconst_null
    //   7: astore 19
    //   9: aconst_null
    //   10: astore 20
    //   12: aconst_null
    //   13: astore 21
    //   15: aconst_null
    //   16: astore 22
    //   18: aconst_null
    //   19: astore 7
    //   21: aconst_null
    //   22: astore 16
    //   24: aconst_null
    //   25: astore 15
    //   27: aload 7
    //   29: astore 9
    //   31: aload 17
    //   33: astore 8
    //   35: aload 18
    //   37: astore 10
    //   39: aload 19
    //   41: astore 11
    //   43: aload 20
    //   45: astore 12
    //   47: aload 21
    //   49: astore 13
    //   51: aload 22
    //   53: astore 14
    //   55: aload 5
    //   57: invokevirtual 156	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   60: pop
    //   61: aload 7
    //   63: astore 9
    //   65: aload 17
    //   67: astore 8
    //   69: aload 18
    //   71: astore 10
    //   73: aload 19
    //   75: astore 11
    //   77: aload 20
    //   79: astore 12
    //   81: aload 21
    //   83: astore 13
    //   85: aload 22
    //   87: astore 14
    //   89: aload 5
    //   91: aload_0
    //   92: getfield 173	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   95: invokevirtual 354	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   98: pop
    //   99: aload 7
    //   101: astore 9
    //   103: aload 17
    //   105: astore 8
    //   107: aload 18
    //   109: astore 10
    //   111: aload 19
    //   113: astore 11
    //   115: aload 20
    //   117: astore 12
    //   119: aload 21
    //   121: astore 13
    //   123: aload 22
    //   125: astore 14
    //   127: aload_0
    //   128: getfield 173	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   131: invokevirtual 357	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   134: pop
    //   135: aload 7
    //   137: astore 9
    //   139: aload 17
    //   141: astore 8
    //   143: aload 18
    //   145: astore 10
    //   147: aload 19
    //   149: astore 11
    //   151: aload 20
    //   153: astore 12
    //   155: aload 21
    //   157: astore 13
    //   159: aload 22
    //   161: astore 14
    //   163: aload 5
    //   165: aload_0
    //   166: getfield 185	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:b	[B
    //   169: iload 4
    //   171: iload_3
    //   172: iload_2
    //   173: invokestatic 360	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:a	(Ljava/nio/ByteBuffer;[BIIZ)V
    //   176: aload 7
    //   178: astore 9
    //   180: aload 17
    //   182: astore 8
    //   184: aload 18
    //   186: astore 10
    //   188: aload 19
    //   190: astore 11
    //   192: aload 20
    //   194: astore 12
    //   196: aload 21
    //   198: astore 13
    //   200: aload 22
    //   202: astore 14
    //   204: aload 5
    //   206: invokevirtual 344	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   209: pop
    //   210: aload 7
    //   212: astore 9
    //   214: aload 17
    //   216: astore 8
    //   218: aload 18
    //   220: astore 10
    //   222: aload 19
    //   224: astore 11
    //   226: aload 20
    //   228: astore 12
    //   230: aload 21
    //   232: astore 13
    //   234: aload 22
    //   236: astore 14
    //   238: new 362	java/net/URL
    //   241: dup
    //   242: aload_1
    //   243: invokespecial 365	java/net/URL:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 369	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   249: checkcast 371	java/net/HttpURLConnection
    //   252: astore 7
    //   254: aload 7
    //   256: astore 9
    //   258: aload 7
    //   260: astore 8
    //   262: aload 7
    //   264: astore 10
    //   266: aload 7
    //   268: astore 11
    //   270: aload 7
    //   272: astore 12
    //   274: aload 7
    //   276: astore 13
    //   278: aload 7
    //   280: astore 14
    //   282: aload 7
    //   284: ldc_w 373
    //   287: invokevirtual 376	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   290: aload 7
    //   292: astore 9
    //   294: aload 7
    //   296: astore 8
    //   298: aload 7
    //   300: astore 10
    //   302: aload 7
    //   304: astore 11
    //   306: aload 7
    //   308: astore 12
    //   310: aload 7
    //   312: astore 13
    //   314: aload 7
    //   316: astore 14
    //   318: aload 7
    //   320: iconst_1
    //   321: invokevirtual 380	java/net/HttpURLConnection:setDoInput	(Z)V
    //   324: aload 7
    //   326: astore 9
    //   328: aload 7
    //   330: astore 8
    //   332: aload 7
    //   334: astore 10
    //   336: aload 7
    //   338: astore 11
    //   340: aload 7
    //   342: astore 12
    //   344: aload 7
    //   346: astore 13
    //   348: aload 7
    //   350: astore 14
    //   352: aload 7
    //   354: iconst_1
    //   355: invokevirtual 383	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   358: aload 7
    //   360: astore 9
    //   362: aload 7
    //   364: astore 8
    //   366: aload 7
    //   368: astore 10
    //   370: aload 7
    //   372: astore 11
    //   374: aload 7
    //   376: astore 12
    //   378: aload 7
    //   380: astore 13
    //   382: aload 7
    //   384: astore 14
    //   386: aload 7
    //   388: sipush 10000
    //   391: invokevirtual 387	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   394: aload 7
    //   396: astore 9
    //   398: aload 7
    //   400: astore 8
    //   402: aload 7
    //   404: astore 10
    //   406: aload 7
    //   408: astore 11
    //   410: aload 7
    //   412: astore 12
    //   414: aload 7
    //   416: astore 13
    //   418: aload 7
    //   420: astore 14
    //   422: aload 7
    //   424: sipush 20000
    //   427: invokevirtual 390	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   430: aload 7
    //   432: astore 9
    //   434: aload 7
    //   436: astore 8
    //   438: aload 7
    //   440: astore 10
    //   442: aload 7
    //   444: astore 11
    //   446: aload 7
    //   448: astore 12
    //   450: aload 7
    //   452: astore 13
    //   454: aload 7
    //   456: astore 14
    //   458: aload 5
    //   460: invokevirtual 394	java/nio/ByteBuffer:array	()[B
    //   463: astore 18
    //   465: aload 7
    //   467: astore 9
    //   469: aload 7
    //   471: astore 8
    //   473: aload 7
    //   475: astore 10
    //   477: aload 7
    //   479: astore 11
    //   481: aload 7
    //   483: astore 12
    //   485: aload 7
    //   487: astore 13
    //   489: aload 7
    //   491: astore 14
    //   493: aload 7
    //   495: invokevirtual 398	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   498: astore 17
    //   500: aload 17
    //   502: astore 8
    //   504: aload 8
    //   506: aload 18
    //   508: aload 5
    //   510: invokevirtual 402	java/nio/ByteBuffer:position	()I
    //   513: aload 5
    //   515: invokevirtual 405	java/nio/ByteBuffer:limit	()I
    //   518: invokevirtual 411	java/io/OutputStream:write	([BII)V
    //   521: aload 8
    //   523: invokevirtual 414	java/io/OutputStream:flush	()V
    //   526: aload 7
    //   528: invokevirtual 417	java/net/HttpURLConnection:connect	()V
    //   531: aload 5
    //   533: invokevirtual 156	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   536: pop
    //   537: aload 7
    //   539: invokevirtual 421	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   542: astore 9
    //   544: aload 7
    //   546: astore 12
    //   548: aload 9
    //   550: astore 11
    //   552: aload 8
    //   554: astore 10
    //   556: aload 9
    //   558: aload_0
    //   559: getfield 185	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:b	[B
    //   562: invokevirtual 426	java/io/InputStream:read	([B)I
    //   565: istore 23
    //   567: iload 23
    //   569: iconst_m1
    //   570: if_icmpeq +126 -> 696
    //   573: aload 7
    //   575: astore 12
    //   577: aload 9
    //   579: astore 11
    //   581: aload 8
    //   583: astore 10
    //   585: aload 5
    //   587: aload_0
    //   588: getfield 185	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:b	[B
    //   591: iconst_0
    //   592: iload 23
    //   594: invokevirtual 429	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   597: pop
    //   598: goto -54 -> 544
    //   601: astore 10
    //   603: aload 8
    //   605: astore 5
    //   607: aload 9
    //   609: astore 8
    //   611: aload 10
    //   613: astore 9
    //   615: new 253	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 431
    //   625: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload_1
    //   629: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: astore_1
    //   636: ldc 10
    //   638: aload_1
    //   639: aload 9
    //   641: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   644: aload 6
    //   646: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   649: dup
    //   650: ldc_w 432
    //   653: aload_1
    //   654: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   657: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   660: aload 5
    //   662: ifnull +13 -> 675
    //   665: aload 5
    //   667: invokevirtual 414	java/io/OutputStream:flush	()V
    //   670: aload 5
    //   672: invokevirtual 433	java/io/OutputStream:close	()V
    //   675: aload 8
    //   677: ifnull +8 -> 685
    //   680: aload 8
    //   682: invokevirtual 434	java/io/InputStream:close	()V
    //   685: aload 7
    //   687: ifnull +8 -> 695
    //   690: aload 7
    //   692: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   695: return
    //   696: aload 7
    //   698: astore 12
    //   700: aload 9
    //   702: astore 11
    //   704: aload 8
    //   706: astore 10
    //   708: aload 5
    //   710: invokevirtual 344	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   713: pop
    //   714: aload 7
    //   716: astore 12
    //   718: aload 9
    //   720: astore 11
    //   722: aload 8
    //   724: astore 10
    //   726: aload 7
    //   728: invokevirtual 440	java/net/HttpURLConnection:getResponseCode	()I
    //   731: istore 23
    //   733: iload 23
    //   735: sipush 200
    //   738: if_icmpeq +11 -> 749
    //   741: iload 23
    //   743: sipush 206
    //   746: if_icmpne +1051 -> 1797
    //   749: aload 7
    //   751: astore 12
    //   753: aload 9
    //   755: astore 11
    //   757: aload 8
    //   759: astore 10
    //   761: new 442	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond
    //   764: dup
    //   765: aload 5
    //   767: invokestatic 445	com/tencent/biz/qqstory/base/videoupload/TLVHelper:a	(Ljava/nio/ByteBuffer;)Ljava/util/HashMap;
    //   770: invokespecial 448	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond:<init>	(Ljava/util/HashMap;)V
    //   773: astore 5
    //   775: aload 7
    //   777: astore 12
    //   779: aload 9
    //   781: astore 11
    //   783: aload 8
    //   785: astore 10
    //   787: aload 5
    //   789: getfield 449	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond:jdField_a_of_type_Int	I
    //   792: ifne +821 -> 1613
    //   795: aload 7
    //   797: astore 12
    //   799: aload 9
    //   801: astore 11
    //   803: aload 8
    //   805: astore 10
    //   807: ldc 10
    //   809: ldc_w 451
    //   812: iload 4
    //   814: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aload 5
    //   819: invokestatic 454	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   822: iload_2
    //   823: ifeq +165 -> 988
    //   826: aload 7
    //   828: astore 12
    //   830: aload 9
    //   832: astore 11
    //   834: aload 8
    //   836: astore 10
    //   838: aload 5
    //   840: iload_3
    //   841: invokevirtual 457	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond:a	(I)Z
    //   844: ifne +144 -> 988
    //   847: aload 7
    //   849: astore 12
    //   851: aload 9
    //   853: astore 11
    //   855: aload 8
    //   857: astore 10
    //   859: aload 6
    //   861: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   864: dup
    //   865: ldc_w 458
    //   868: ldc_w 460
    //   871: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   874: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   877: aload 7
    //   879: astore 12
    //   881: aload 9
    //   883: astore 11
    //   885: aload 8
    //   887: astore 10
    //   889: ldc 10
    //   891: aload 6
    //   893: getfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   896: invokevirtual 461	com/tencent/biz/qqstory/base/ErrorMessage:toString	()Ljava/lang/String;
    //   899: invokestatic 195	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   902: aload 7
    //   904: astore 12
    //   906: aload 9
    //   908: astore 11
    //   910: aload 8
    //   912: astore 10
    //   914: aload_0
    //   915: getfield 100	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext	Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   918: iconst_1
    //   919: aload_0
    //   920: getfield 100	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext	Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   923: invokevirtual 464	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lmqq/app/MobileQQ;
    //   926: invokestatic 469	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   929: ldc_w 470
    //   932: ldc_w 471
    //   935: iload 4
    //   937: i2l
    //   938: invokevirtual 474	com/tencent/biz/qqstory/app/QQStoryContext:a	(ZIIIJ)V
    //   941: aload 8
    //   943: ifnull +13 -> 956
    //   946: aload 8
    //   948: invokevirtual 414	java/io/OutputStream:flush	()V
    //   951: aload 8
    //   953: invokevirtual 433	java/io/OutputStream:close	()V
    //   956: aload 9
    //   958: ifnull +8 -> 966
    //   961: aload 9
    //   963: invokevirtual 434	java/io/InputStream:close	()V
    //   966: aload 7
    //   968: ifnull -273 -> 695
    //   971: aload 7
    //   973: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   976: return
    //   977: astore_1
    //   978: ldc 10
    //   980: ldc_w 476
    //   983: aload_1
    //   984: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   987: return
    //   988: iload_3
    //   989: iload 4
    //   991: iadd
    //   992: i2l
    //   993: lstore 24
    //   995: aload 7
    //   997: astore 12
    //   999: aload 9
    //   1001: astore 11
    //   1003: aload 8
    //   1005: astore 10
    //   1007: lload 24
    //   1009: aload 6
    //   1011: getfield 133	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_Long	J
    //   1014: lcmp
    //   1015: ifne -113 -> 902
    //   1018: aload 7
    //   1020: astore 12
    //   1022: aload 9
    //   1024: astore 11
    //   1026: aload 8
    //   1028: astore 10
    //   1030: aload 6
    //   1032: aload_0
    //   1033: getfield 158	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:y	Ljava/lang/String;
    //   1036: putfield 478	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1039: aload 7
    //   1041: astore 12
    //   1043: aload 9
    //   1045: astore 11
    //   1047: aload 8
    //   1049: astore 10
    //   1051: aload 6
    //   1053: aload 5
    //   1055: getfield 480	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond:c	Ljava/lang/String;
    //   1058: putfield 482	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1061: aload 7
    //   1063: astore 12
    //   1065: aload 9
    //   1067: astore 11
    //   1069: aload 8
    //   1071: astore 10
    //   1073: aload 6
    //   1075: aload 5
    //   1077: getfield 484	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond:f	Ljava/lang/String;
    //   1080: ldc 24
    //   1082: invokestatic 486	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1085: putfield 487	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:c	Ljava/lang/String;
    //   1088: aload 7
    //   1090: astore 12
    //   1092: aload 9
    //   1094: astore 11
    //   1096: aload 8
    //   1098: astore 10
    //   1100: aload 6
    //   1102: getfield 482	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1105: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1108: ifeq +166 -> 1274
    //   1111: aload 7
    //   1113: astore 12
    //   1115: aload 9
    //   1117: astore 11
    //   1119: aload 8
    //   1121: astore 10
    //   1123: aload 6
    //   1125: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1128: dup
    //   1129: ldc_w 494
    //   1132: ldc_w 496
    //   1135: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1138: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1141: goto -239 -> 902
    //   1144: astore 5
    //   1146: aload 7
    //   1148: astore 12
    //   1150: aload 9
    //   1152: astore 11
    //   1154: aload 8
    //   1156: astore 10
    //   1158: new 253	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1165: ldc_w 498
    //   1168: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: aload_1
    //   1172: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: astore_1
    //   1179: aload 7
    //   1181: astore 12
    //   1183: aload 9
    //   1185: astore 11
    //   1187: aload 8
    //   1189: astore 10
    //   1191: ldc 10
    //   1193: aload_1
    //   1194: aload 5
    //   1196: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1199: aload 7
    //   1201: astore 12
    //   1203: aload 9
    //   1205: astore 11
    //   1207: aload 8
    //   1209: astore 10
    //   1211: aload 6
    //   1213: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1216: dup
    //   1217: ldc_w 499
    //   1220: aload_1
    //   1221: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1224: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1227: aload 8
    //   1229: ifnull +13 -> 1242
    //   1232: aload 8
    //   1234: invokevirtual 414	java/io/OutputStream:flush	()V
    //   1237: aload 8
    //   1239: invokevirtual 433	java/io/OutputStream:close	()V
    //   1242: aload 9
    //   1244: ifnull +8 -> 1252
    //   1247: aload 9
    //   1249: invokevirtual 434	java/io/InputStream:close	()V
    //   1252: aload 7
    //   1254: ifnull -559 -> 695
    //   1257: aload 7
    //   1259: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   1262: return
    //   1263: astore_1
    //   1264: ldc 10
    //   1266: ldc_w 476
    //   1269: aload_1
    //   1270: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1273: return
    //   1274: aload 7
    //   1276: astore 12
    //   1278: aload 9
    //   1280: astore 11
    //   1282: aload 8
    //   1284: astore 10
    //   1286: aload 6
    //   1288: getfield 487	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:c	Ljava/lang/String;
    //   1291: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1294: ifeq +166 -> 1460
    //   1297: aload 7
    //   1299: astore 12
    //   1301: aload 9
    //   1303: astore 11
    //   1305: aload 8
    //   1307: astore 10
    //   1309: aload 6
    //   1311: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1314: dup
    //   1315: ldc_w 494
    //   1318: ldc_w 501
    //   1321: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1324: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1327: goto -425 -> 902
    //   1330: astore 5
    //   1332: aload 7
    //   1334: astore 12
    //   1336: aload 9
    //   1338: astore 11
    //   1340: aload 8
    //   1342: astore 10
    //   1344: new 253	java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1351: ldc_w 503
    //   1354: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: aload_1
    //   1358: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: astore_1
    //   1365: aload 7
    //   1367: astore 12
    //   1369: aload 9
    //   1371: astore 11
    //   1373: aload 8
    //   1375: astore 10
    //   1377: ldc 10
    //   1379: aload_1
    //   1380: aload 5
    //   1382: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1385: aload 7
    //   1387: astore 12
    //   1389: aload 9
    //   1391: astore 11
    //   1393: aload 8
    //   1395: astore 10
    //   1397: aload 6
    //   1399: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1402: dup
    //   1403: ldc_w 504
    //   1406: aload_1
    //   1407: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1410: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1413: aload 8
    //   1415: ifnull +13 -> 1428
    //   1418: aload 8
    //   1420: invokevirtual 414	java/io/OutputStream:flush	()V
    //   1423: aload 8
    //   1425: invokevirtual 433	java/io/OutputStream:close	()V
    //   1428: aload 9
    //   1430: ifnull +8 -> 1438
    //   1433: aload 9
    //   1435: invokevirtual 434	java/io/InputStream:close	()V
    //   1438: aload 7
    //   1440: ifnull -745 -> 695
    //   1443: aload 7
    //   1445: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   1448: return
    //   1449: astore_1
    //   1450: ldc 10
    //   1452: ldc_w 476
    //   1455: aload_1
    //   1456: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1459: return
    //   1460: aload 7
    //   1462: astore 12
    //   1464: aload 9
    //   1466: astore 11
    //   1468: aload 8
    //   1470: astore 10
    //   1472: ldc 10
    //   1474: ldc_w 506
    //   1477: invokestatic 508	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1480: goto -578 -> 902
    //   1483: astore 5
    //   1485: aload 7
    //   1487: astore 12
    //   1489: aload 9
    //   1491: astore 11
    //   1493: aload 8
    //   1495: astore 10
    //   1497: new 253	java/lang/StringBuilder
    //   1500: dup
    //   1501: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1504: ldc_w 510
    //   1507: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: aload_1
    //   1511: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: astore_1
    //   1518: aload 7
    //   1520: astore 12
    //   1522: aload 9
    //   1524: astore 11
    //   1526: aload 8
    //   1528: astore 10
    //   1530: ldc 10
    //   1532: aload_1
    //   1533: aload 5
    //   1535: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1538: aload 7
    //   1540: astore 12
    //   1542: aload 9
    //   1544: astore 11
    //   1546: aload 8
    //   1548: astore 10
    //   1550: aload 6
    //   1552: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1555: dup
    //   1556: ldc_w 265
    //   1559: aload_1
    //   1560: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1563: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1566: aload 8
    //   1568: ifnull +13 -> 1581
    //   1571: aload 8
    //   1573: invokevirtual 414	java/io/OutputStream:flush	()V
    //   1576: aload 8
    //   1578: invokevirtual 433	java/io/OutputStream:close	()V
    //   1581: aload 9
    //   1583: ifnull +8 -> 1591
    //   1586: aload 9
    //   1588: invokevirtual 434	java/io/InputStream:close	()V
    //   1591: aload 7
    //   1593: ifnull -898 -> 695
    //   1596: aload 7
    //   1598: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   1601: return
    //   1602: astore_1
    //   1603: ldc 10
    //   1605: ldc_w 476
    //   1608: aload_1
    //   1609: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1612: return
    //   1613: aload 7
    //   1615: astore 12
    //   1617: aload 9
    //   1619: astore 11
    //   1621: aload 8
    //   1623: astore 10
    //   1625: aload 6
    //   1627: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1630: dup
    //   1631: ldc_w 511
    //   1634: new 253	java/lang/StringBuilder
    //   1637: dup
    //   1638: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1641: ldc_w 513
    //   1644: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: aload 5
    //   1649: getfield 449	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadRespond:jdField_a_of_type_Int	I
    //   1652: invokevirtual 516	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1655: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1658: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1661: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1664: goto -762 -> 902
    //   1667: astore 5
    //   1669: aload 7
    //   1671: astore 12
    //   1673: aload 9
    //   1675: astore 11
    //   1677: aload 8
    //   1679: astore 10
    //   1681: new 253	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1688: ldc_w 518
    //   1691: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aload_1
    //   1695: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1701: astore_1
    //   1702: aload 7
    //   1704: astore 12
    //   1706: aload 9
    //   1708: astore 11
    //   1710: aload 8
    //   1712: astore 10
    //   1714: ldc 10
    //   1716: aload_1
    //   1717: aload 5
    //   1719: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1722: aload 7
    //   1724: astore 12
    //   1726: aload 9
    //   1728: astore 11
    //   1730: aload 8
    //   1732: astore 10
    //   1734: aload 6
    //   1736: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1739: dup
    //   1740: ldc_w 269
    //   1743: aload_1
    //   1744: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1747: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1750: aload 8
    //   1752: ifnull +13 -> 1765
    //   1755: aload 8
    //   1757: invokevirtual 414	java/io/OutputStream:flush	()V
    //   1760: aload 8
    //   1762: invokevirtual 433	java/io/OutputStream:close	()V
    //   1765: aload 9
    //   1767: ifnull +8 -> 1775
    //   1770: aload 9
    //   1772: invokevirtual 434	java/io/InputStream:close	()V
    //   1775: aload 7
    //   1777: ifnull -1082 -> 695
    //   1780: aload 7
    //   1782: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   1785: return
    //   1786: astore_1
    //   1787: ldc 10
    //   1789: ldc_w 476
    //   1792: aload_1
    //   1793: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1796: return
    //   1797: aload 7
    //   1799: astore 12
    //   1801: aload 9
    //   1803: astore 11
    //   1805: aload 8
    //   1807: astore 10
    //   1809: aload 7
    //   1811: ldc_w 520
    //   1814: invokevirtual 523	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1817: astore 5
    //   1819: aload 7
    //   1821: astore 12
    //   1823: aload 9
    //   1825: astore 11
    //   1827: aload 8
    //   1829: astore 10
    //   1831: ldc 10
    //   1833: ldc_w 525
    //   1836: iconst_2
    //   1837: anewarray 4	java/lang/Object
    //   1840: dup
    //   1841: iconst_0
    //   1842: iload 23
    //   1844: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1847: aastore
    //   1848: dup
    //   1849: iconst_1
    //   1850: aload 5
    //   1852: aastore
    //   1853: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1856: aload 7
    //   1858: astore 12
    //   1860: aload 9
    //   1862: astore 11
    //   1864: aload 8
    //   1866: astore 10
    //   1868: aload 6
    //   1870: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1873: dup
    //   1874: ldc_w 526
    //   1877: ldc_w 525
    //   1880: iconst_2
    //   1881: anewarray 4	java/lang/Object
    //   1884: dup
    //   1885: iconst_0
    //   1886: iload 23
    //   1888: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1891: aastore
    //   1892: dup
    //   1893: iconst_1
    //   1894: aload 5
    //   1896: aastore
    //   1897: invokestatic 530	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1900: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1903: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1906: goto -1004 -> 902
    //   1909: astore 5
    //   1911: aload 7
    //   1913: astore 12
    //   1915: aload 9
    //   1917: astore 11
    //   1919: aload 8
    //   1921: astore 10
    //   1923: new 253	java/lang/StringBuilder
    //   1926: dup
    //   1927: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1930: ldc_w 532
    //   1933: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: aload_1
    //   1937: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1943: astore_1
    //   1944: aload 7
    //   1946: astore 12
    //   1948: aload 9
    //   1950: astore 11
    //   1952: aload 8
    //   1954: astore 10
    //   1956: ldc 10
    //   1958: aload_1
    //   1959: aload 5
    //   1961: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1964: aload 7
    //   1966: astore 12
    //   1968: aload 9
    //   1970: astore 11
    //   1972: aload 8
    //   1974: astore 10
    //   1976: aload 6
    //   1978: new 135	com/tencent/biz/qqstory/base/ErrorMessage
    //   1981: dup
    //   1982: ldc_w 271
    //   1985: aload_1
    //   1986: invokespecial 141	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   1989: putfield 144	com/tencent/biz/qqstory/base/videoupload/VideoUploadHelper$UploadResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   1992: aload 8
    //   1994: ifnull +13 -> 2007
    //   1997: aload 8
    //   1999: invokevirtual 414	java/io/OutputStream:flush	()V
    //   2002: aload 8
    //   2004: invokevirtual 433	java/io/OutputStream:close	()V
    //   2007: aload 9
    //   2009: ifnull +8 -> 2017
    //   2012: aload 9
    //   2014: invokevirtual 434	java/io/InputStream:close	()V
    //   2017: aload 7
    //   2019: ifnull -1324 -> 695
    //   2022: aload 7
    //   2024: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   2027: return
    //   2028: astore_1
    //   2029: ldc 10
    //   2031: ldc_w 476
    //   2034: aload_1
    //   2035: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2038: return
    //   2039: astore_1
    //   2040: ldc 10
    //   2042: ldc_w 476
    //   2045: aload_1
    //   2046: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2049: return
    //   2050: astore_1
    //   2051: aconst_null
    //   2052: astore 11
    //   2054: aconst_null
    //   2055: astore 8
    //   2057: aload 9
    //   2059: astore 7
    //   2061: aload 8
    //   2063: ifnull +13 -> 2076
    //   2066: aload 8
    //   2068: invokevirtual 414	java/io/OutputStream:flush	()V
    //   2071: aload 8
    //   2073: invokevirtual 433	java/io/OutputStream:close	()V
    //   2076: aload 11
    //   2078: ifnull +8 -> 2086
    //   2081: aload 11
    //   2083: invokevirtual 434	java/io/InputStream:close	()V
    //   2086: aload 7
    //   2088: ifnull +8 -> 2096
    //   2091: aload 7
    //   2093: invokevirtual 437	java/net/HttpURLConnection:disconnect	()V
    //   2096: aload_1
    //   2097: athrow
    //   2098: astore 5
    //   2100: ldc 10
    //   2102: ldc_w 476
    //   2105: aload 5
    //   2107: invokestatic 249	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2110: goto -14 -> 2096
    //   2113: astore_1
    //   2114: aconst_null
    //   2115: astore 11
    //   2117: goto -56 -> 2061
    //   2120: astore_1
    //   2121: aload 12
    //   2123: astore 7
    //   2125: aload 10
    //   2127: astore 8
    //   2129: goto -68 -> 2061
    //   2132: astore_1
    //   2133: aload 8
    //   2135: astore 11
    //   2137: aload 5
    //   2139: astore 8
    //   2141: goto -80 -> 2061
    //   2144: astore 5
    //   2146: aconst_null
    //   2147: astore 9
    //   2149: aconst_null
    //   2150: astore 10
    //   2152: aload 8
    //   2154: astore 7
    //   2156: aload 10
    //   2158: astore 8
    //   2160: goto -249 -> 1911
    //   2163: astore 5
    //   2165: aconst_null
    //   2166: astore 9
    //   2168: goto -257 -> 1911
    //   2171: astore 5
    //   2173: aconst_null
    //   2174: astore 9
    //   2176: aconst_null
    //   2177: astore 8
    //   2179: aload 10
    //   2181: astore 7
    //   2183: goto -514 -> 1669
    //   2186: astore 5
    //   2188: aconst_null
    //   2189: astore 9
    //   2191: goto -522 -> 1669
    //   2194: astore 5
    //   2196: aconst_null
    //   2197: astore 9
    //   2199: aconst_null
    //   2200: astore 8
    //   2202: aload 11
    //   2204: astore 7
    //   2206: goto -721 -> 1485
    //   2209: astore 5
    //   2211: aconst_null
    //   2212: astore 9
    //   2214: goto -729 -> 1485
    //   2217: astore 5
    //   2219: aconst_null
    //   2220: astore 9
    //   2222: aconst_null
    //   2223: astore 8
    //   2225: aload 12
    //   2227: astore 7
    //   2229: goto -897 -> 1332
    //   2232: astore 5
    //   2234: aconst_null
    //   2235: astore 9
    //   2237: goto -905 -> 1332
    //   2240: astore 5
    //   2242: aconst_null
    //   2243: astore 9
    //   2245: aconst_null
    //   2246: astore 8
    //   2248: aload 13
    //   2250: astore 7
    //   2252: goto -1106 -> 1146
    //   2255: astore 5
    //   2257: aconst_null
    //   2258: astore 9
    //   2260: goto -1114 -> 1146
    //   2263: astore 9
    //   2265: aload 15
    //   2267: astore 8
    //   2269: aload 16
    //   2271: astore 5
    //   2273: aload 14
    //   2275: astore 7
    //   2277: goto -1662 -> 615
    //   2280: astore 9
    //   2282: aload 8
    //   2284: astore 5
    //   2286: aload 15
    //   2288: astore 8
    //   2290: goto -1675 -> 615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2293	0	this	VideoUploadHelper
    //   0	2293	1	paramString	String
    //   0	2293	2	paramBoolean	boolean
    //   0	2293	3	paramInt1	int
    //   0	2293	4	paramInt2	int
    //   0	2293	5	paramByteBuffer	ByteBuffer
    //   0	2293	6	paramUploadResult	VideoUploadHelper.UploadResult
    //   19	2257	7	localObject1	Object
    //   33	2256	8	localObject2	Object
    //   29	2230	9	localObject3	Object
    //   2263	1	9	localProtocolException1	java.net.ProtocolException
    //   2280	1	9	localProtocolException2	java.net.ProtocolException
    //   37	547	10	localObject4	Object
    //   601	11	10	localProtocolException3	java.net.ProtocolException
    //   706	1474	10	localObject5	Object
    //   41	2162	11	localObject6	Object
    //   45	2181	12	localObject7	Object
    //   49	2200	13	localObject8	Object
    //   53	2221	14	localObject9	Object
    //   25	2262	15	localObject10	Object
    //   22	2248	16	localObject11	Object
    //   1	500	17	localOutputStream	java.io.OutputStream
    //   4	503	18	arrayOfByte	byte[]
    //   7	216	19	localObject12	Object
    //   10	217	20	localObject13	Object
    //   13	218	21	localObject14	Object
    //   16	219	22	localObject15	Object
    //   565	1322	23	i1	int
    //   993	15	24	l1	long
    // Exception table:
    //   from	to	target	type
    //   556	567	601	java/net/ProtocolException
    //   585	598	601	java/net/ProtocolException
    //   708	714	601	java/net/ProtocolException
    //   726	733	601	java/net/ProtocolException
    //   761	775	601	java/net/ProtocolException
    //   787	795	601	java/net/ProtocolException
    //   807	822	601	java/net/ProtocolException
    //   838	847	601	java/net/ProtocolException
    //   859	877	601	java/net/ProtocolException
    //   889	902	601	java/net/ProtocolException
    //   914	941	601	java/net/ProtocolException
    //   1007	1018	601	java/net/ProtocolException
    //   1030	1039	601	java/net/ProtocolException
    //   1051	1061	601	java/net/ProtocolException
    //   1073	1088	601	java/net/ProtocolException
    //   1100	1111	601	java/net/ProtocolException
    //   1123	1141	601	java/net/ProtocolException
    //   1286	1297	601	java/net/ProtocolException
    //   1309	1327	601	java/net/ProtocolException
    //   1472	1480	601	java/net/ProtocolException
    //   1625	1664	601	java/net/ProtocolException
    //   1809	1819	601	java/net/ProtocolException
    //   1831	1856	601	java/net/ProtocolException
    //   1868	1906	601	java/net/ProtocolException
    //   946	956	977	java/io/IOException
    //   961	966	977	java/io/IOException
    //   971	976	977	java/io/IOException
    //   556	567	1144	java/net/MalformedURLException
    //   585	598	1144	java/net/MalformedURLException
    //   708	714	1144	java/net/MalformedURLException
    //   726	733	1144	java/net/MalformedURLException
    //   761	775	1144	java/net/MalformedURLException
    //   787	795	1144	java/net/MalformedURLException
    //   807	822	1144	java/net/MalformedURLException
    //   838	847	1144	java/net/MalformedURLException
    //   859	877	1144	java/net/MalformedURLException
    //   889	902	1144	java/net/MalformedURLException
    //   914	941	1144	java/net/MalformedURLException
    //   1007	1018	1144	java/net/MalformedURLException
    //   1030	1039	1144	java/net/MalformedURLException
    //   1051	1061	1144	java/net/MalformedURLException
    //   1073	1088	1144	java/net/MalformedURLException
    //   1100	1111	1144	java/net/MalformedURLException
    //   1123	1141	1144	java/net/MalformedURLException
    //   1286	1297	1144	java/net/MalformedURLException
    //   1309	1327	1144	java/net/MalformedURLException
    //   1472	1480	1144	java/net/MalformedURLException
    //   1625	1664	1144	java/net/MalformedURLException
    //   1809	1819	1144	java/net/MalformedURLException
    //   1831	1856	1144	java/net/MalformedURLException
    //   1868	1906	1144	java/net/MalformedURLException
    //   1232	1242	1263	java/io/IOException
    //   1247	1252	1263	java/io/IOException
    //   1257	1262	1263	java/io/IOException
    //   556	567	1330	java/net/SocketTimeoutException
    //   585	598	1330	java/net/SocketTimeoutException
    //   708	714	1330	java/net/SocketTimeoutException
    //   726	733	1330	java/net/SocketTimeoutException
    //   761	775	1330	java/net/SocketTimeoutException
    //   787	795	1330	java/net/SocketTimeoutException
    //   807	822	1330	java/net/SocketTimeoutException
    //   838	847	1330	java/net/SocketTimeoutException
    //   859	877	1330	java/net/SocketTimeoutException
    //   889	902	1330	java/net/SocketTimeoutException
    //   914	941	1330	java/net/SocketTimeoutException
    //   1007	1018	1330	java/net/SocketTimeoutException
    //   1030	1039	1330	java/net/SocketTimeoutException
    //   1051	1061	1330	java/net/SocketTimeoutException
    //   1073	1088	1330	java/net/SocketTimeoutException
    //   1100	1111	1330	java/net/SocketTimeoutException
    //   1123	1141	1330	java/net/SocketTimeoutException
    //   1286	1297	1330	java/net/SocketTimeoutException
    //   1309	1327	1330	java/net/SocketTimeoutException
    //   1472	1480	1330	java/net/SocketTimeoutException
    //   1625	1664	1330	java/net/SocketTimeoutException
    //   1809	1819	1330	java/net/SocketTimeoutException
    //   1831	1856	1330	java/net/SocketTimeoutException
    //   1868	1906	1330	java/net/SocketTimeoutException
    //   1418	1428	1449	java/io/IOException
    //   1433	1438	1449	java/io/IOException
    //   1443	1448	1449	java/io/IOException
    //   556	567	1483	java/io/FileNotFoundException
    //   585	598	1483	java/io/FileNotFoundException
    //   708	714	1483	java/io/FileNotFoundException
    //   726	733	1483	java/io/FileNotFoundException
    //   761	775	1483	java/io/FileNotFoundException
    //   787	795	1483	java/io/FileNotFoundException
    //   807	822	1483	java/io/FileNotFoundException
    //   838	847	1483	java/io/FileNotFoundException
    //   859	877	1483	java/io/FileNotFoundException
    //   889	902	1483	java/io/FileNotFoundException
    //   914	941	1483	java/io/FileNotFoundException
    //   1007	1018	1483	java/io/FileNotFoundException
    //   1030	1039	1483	java/io/FileNotFoundException
    //   1051	1061	1483	java/io/FileNotFoundException
    //   1073	1088	1483	java/io/FileNotFoundException
    //   1100	1111	1483	java/io/FileNotFoundException
    //   1123	1141	1483	java/io/FileNotFoundException
    //   1286	1297	1483	java/io/FileNotFoundException
    //   1309	1327	1483	java/io/FileNotFoundException
    //   1472	1480	1483	java/io/FileNotFoundException
    //   1625	1664	1483	java/io/FileNotFoundException
    //   1809	1819	1483	java/io/FileNotFoundException
    //   1831	1856	1483	java/io/FileNotFoundException
    //   1868	1906	1483	java/io/FileNotFoundException
    //   1571	1581	1602	java/io/IOException
    //   1586	1591	1602	java/io/IOException
    //   1596	1601	1602	java/io/IOException
    //   556	567	1667	java/io/IOException
    //   585	598	1667	java/io/IOException
    //   708	714	1667	java/io/IOException
    //   726	733	1667	java/io/IOException
    //   761	775	1667	java/io/IOException
    //   787	795	1667	java/io/IOException
    //   807	822	1667	java/io/IOException
    //   838	847	1667	java/io/IOException
    //   859	877	1667	java/io/IOException
    //   889	902	1667	java/io/IOException
    //   914	941	1667	java/io/IOException
    //   1007	1018	1667	java/io/IOException
    //   1030	1039	1667	java/io/IOException
    //   1051	1061	1667	java/io/IOException
    //   1073	1088	1667	java/io/IOException
    //   1100	1111	1667	java/io/IOException
    //   1123	1141	1667	java/io/IOException
    //   1286	1297	1667	java/io/IOException
    //   1309	1327	1667	java/io/IOException
    //   1472	1480	1667	java/io/IOException
    //   1625	1664	1667	java/io/IOException
    //   1809	1819	1667	java/io/IOException
    //   1831	1856	1667	java/io/IOException
    //   1868	1906	1667	java/io/IOException
    //   1755	1765	1786	java/io/IOException
    //   1770	1775	1786	java/io/IOException
    //   1780	1785	1786	java/io/IOException
    //   556	567	1909	java/lang/Exception
    //   585	598	1909	java/lang/Exception
    //   708	714	1909	java/lang/Exception
    //   726	733	1909	java/lang/Exception
    //   761	775	1909	java/lang/Exception
    //   787	795	1909	java/lang/Exception
    //   807	822	1909	java/lang/Exception
    //   838	847	1909	java/lang/Exception
    //   859	877	1909	java/lang/Exception
    //   889	902	1909	java/lang/Exception
    //   914	941	1909	java/lang/Exception
    //   1007	1018	1909	java/lang/Exception
    //   1030	1039	1909	java/lang/Exception
    //   1051	1061	1909	java/lang/Exception
    //   1073	1088	1909	java/lang/Exception
    //   1100	1111	1909	java/lang/Exception
    //   1123	1141	1909	java/lang/Exception
    //   1286	1297	1909	java/lang/Exception
    //   1309	1327	1909	java/lang/Exception
    //   1472	1480	1909	java/lang/Exception
    //   1625	1664	1909	java/lang/Exception
    //   1809	1819	1909	java/lang/Exception
    //   1831	1856	1909	java/lang/Exception
    //   1868	1906	1909	java/lang/Exception
    //   1997	2007	2028	java/io/IOException
    //   2012	2017	2028	java/io/IOException
    //   2022	2027	2028	java/io/IOException
    //   665	675	2039	java/io/IOException
    //   680	685	2039	java/io/IOException
    //   690	695	2039	java/io/IOException
    //   55	61	2050	finally
    //   89	99	2050	finally
    //   127	135	2050	finally
    //   163	176	2050	finally
    //   204	210	2050	finally
    //   238	254	2050	finally
    //   282	290	2050	finally
    //   318	324	2050	finally
    //   352	358	2050	finally
    //   386	394	2050	finally
    //   422	430	2050	finally
    //   458	465	2050	finally
    //   493	500	2050	finally
    //   2066	2076	2098	java/io/IOException
    //   2081	2086	2098	java/io/IOException
    //   2091	2096	2098	java/io/IOException
    //   504	544	2113	finally
    //   556	567	2120	finally
    //   585	598	2120	finally
    //   708	714	2120	finally
    //   726	733	2120	finally
    //   761	775	2120	finally
    //   787	795	2120	finally
    //   807	822	2120	finally
    //   838	847	2120	finally
    //   859	877	2120	finally
    //   889	902	2120	finally
    //   914	941	2120	finally
    //   1007	1018	2120	finally
    //   1030	1039	2120	finally
    //   1051	1061	2120	finally
    //   1073	1088	2120	finally
    //   1100	1111	2120	finally
    //   1123	1141	2120	finally
    //   1158	1179	2120	finally
    //   1191	1199	2120	finally
    //   1211	1227	2120	finally
    //   1286	1297	2120	finally
    //   1309	1327	2120	finally
    //   1344	1365	2120	finally
    //   1377	1385	2120	finally
    //   1397	1413	2120	finally
    //   1472	1480	2120	finally
    //   1497	1518	2120	finally
    //   1530	1538	2120	finally
    //   1550	1566	2120	finally
    //   1625	1664	2120	finally
    //   1681	1702	2120	finally
    //   1714	1722	2120	finally
    //   1734	1750	2120	finally
    //   1809	1819	2120	finally
    //   1831	1856	2120	finally
    //   1868	1906	2120	finally
    //   1923	1944	2120	finally
    //   1956	1964	2120	finally
    //   1976	1992	2120	finally
    //   615	660	2132	finally
    //   55	61	2144	java/lang/Exception
    //   89	99	2144	java/lang/Exception
    //   127	135	2144	java/lang/Exception
    //   163	176	2144	java/lang/Exception
    //   204	210	2144	java/lang/Exception
    //   238	254	2144	java/lang/Exception
    //   282	290	2144	java/lang/Exception
    //   318	324	2144	java/lang/Exception
    //   352	358	2144	java/lang/Exception
    //   386	394	2144	java/lang/Exception
    //   422	430	2144	java/lang/Exception
    //   458	465	2144	java/lang/Exception
    //   493	500	2144	java/lang/Exception
    //   504	544	2163	java/lang/Exception
    //   55	61	2171	java/io/IOException
    //   89	99	2171	java/io/IOException
    //   127	135	2171	java/io/IOException
    //   163	176	2171	java/io/IOException
    //   204	210	2171	java/io/IOException
    //   238	254	2171	java/io/IOException
    //   282	290	2171	java/io/IOException
    //   318	324	2171	java/io/IOException
    //   352	358	2171	java/io/IOException
    //   386	394	2171	java/io/IOException
    //   422	430	2171	java/io/IOException
    //   458	465	2171	java/io/IOException
    //   493	500	2171	java/io/IOException
    //   504	544	2186	java/io/IOException
    //   55	61	2194	java/io/FileNotFoundException
    //   89	99	2194	java/io/FileNotFoundException
    //   127	135	2194	java/io/FileNotFoundException
    //   163	176	2194	java/io/FileNotFoundException
    //   204	210	2194	java/io/FileNotFoundException
    //   238	254	2194	java/io/FileNotFoundException
    //   282	290	2194	java/io/FileNotFoundException
    //   318	324	2194	java/io/FileNotFoundException
    //   352	358	2194	java/io/FileNotFoundException
    //   386	394	2194	java/io/FileNotFoundException
    //   422	430	2194	java/io/FileNotFoundException
    //   458	465	2194	java/io/FileNotFoundException
    //   493	500	2194	java/io/FileNotFoundException
    //   504	544	2209	java/io/FileNotFoundException
    //   55	61	2217	java/net/SocketTimeoutException
    //   89	99	2217	java/net/SocketTimeoutException
    //   127	135	2217	java/net/SocketTimeoutException
    //   163	176	2217	java/net/SocketTimeoutException
    //   204	210	2217	java/net/SocketTimeoutException
    //   238	254	2217	java/net/SocketTimeoutException
    //   282	290	2217	java/net/SocketTimeoutException
    //   318	324	2217	java/net/SocketTimeoutException
    //   352	358	2217	java/net/SocketTimeoutException
    //   386	394	2217	java/net/SocketTimeoutException
    //   422	430	2217	java/net/SocketTimeoutException
    //   458	465	2217	java/net/SocketTimeoutException
    //   493	500	2217	java/net/SocketTimeoutException
    //   504	544	2232	java/net/SocketTimeoutException
    //   55	61	2240	java/net/MalformedURLException
    //   89	99	2240	java/net/MalformedURLException
    //   127	135	2240	java/net/MalformedURLException
    //   163	176	2240	java/net/MalformedURLException
    //   204	210	2240	java/net/MalformedURLException
    //   238	254	2240	java/net/MalformedURLException
    //   282	290	2240	java/net/MalformedURLException
    //   318	324	2240	java/net/MalformedURLException
    //   352	358	2240	java/net/MalformedURLException
    //   386	394	2240	java/net/MalformedURLException
    //   422	430	2240	java/net/MalformedURLException
    //   458	465	2240	java/net/MalformedURLException
    //   493	500	2240	java/net/MalformedURLException
    //   504	544	2255	java/net/MalformedURLException
    //   55	61	2263	java/net/ProtocolException
    //   89	99	2263	java/net/ProtocolException
    //   127	135	2263	java/net/ProtocolException
    //   163	176	2263	java/net/ProtocolException
    //   204	210	2263	java/net/ProtocolException
    //   238	254	2263	java/net/ProtocolException
    //   282	290	2263	java/net/ProtocolException
    //   318	324	2263	java/net/ProtocolException
    //   352	358	2263	java/net/ProtocolException
    //   386	394	2263	java/net/ProtocolException
    //   422	430	2263	java/net/ProtocolException
    //   458	465	2263	java/net/ProtocolException
    //   493	500	2263	java/net/ProtocolException
    //   504	544	2280	java/net/ProtocolException
  }
  
  private static void a(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      TLVHelper.a(paramByteBuffer, "isneedbitmap", str);
      TLVHelper.a(paramByteBuffer, "rangestart", String.valueOf(paramInt2));
      TLVHelper.a(paramByteBuffer, "rangeend", String.valueOf(paramInt2 + paramInt1 - 1));
      TLVHelper.a(paramByteBuffer, "filedata", paramArrayOfByte, paramInt1);
      return;
    }
  }
  
  public VideoUploadHelper.UploadResult a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte)
  {
    this.x = paramString1;
    this.w = paramString2;
    this.y = paramString3;
    this.d = paramInt2;
    this.z = paramString4;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.A = String.format("http://%s:80/asn.com/qqstorageupload", new Object[] { this.z });
    this.b = new byte[this.d];
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      SLog.d("Q.qqstory.publish:VideoUploadHelper", "start upload is continue upload %b", new Object[] { Boolean.valueOf(bool) });
      paramString2 = a(paramInt1);
      paramString1 = paramString2;
      if (paramInt1 != 0) {
        if ((paramString2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode != 940014) && (paramString2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode != 940015))
        {
          paramString1 = paramString2;
          if (paramString2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode != 940016) {}
        }
        else
        {
          SLog.d("Q.qqstory.publish:VideoUploadHelper", "start upload after continue upload fail %s", new Object[] { paramString2 });
          paramString1 = a(0);
        }
      }
      return paramString1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\VideoUploadHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */