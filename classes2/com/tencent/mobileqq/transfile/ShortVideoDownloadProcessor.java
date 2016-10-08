package com.tencent.mobileqq.transfile;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import vbo;
import vbp;

public class ShortVideoDownloadProcessor
  extends BaseDownloadProcessor
{
  static HashSet a;
  public static final String i = "ShortVideoDownloadProcessor";
  int aJ = -1;
  int aK = 0;
  private int aL;
  private int aM;
  private INetEngine.IBreakDownFix b;
  long c;
  private String j;
  private String k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ShortVideoDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new vbp(this);
    paramTransFileController = paramTransferRequest.i;
    if (paramTransFileController != null)
    {
      String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramTransferRequest.h = arrayOfString[0];
      this.j = arrayOfString[1];
      this.aL = Integer.parseInt(arrayOfString[2]);
      if (arrayOfString.length > 3) {
        this.aM = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private boolean f()
  {
    if ((ProgressiveUtils.a.get()) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.supportProgressive)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "isSupportProgressive() : " + bool);
      }
      return bool;
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      d(2001);
      this.aU = 0;
      this.bc = "";
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vbo(this));
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mFileId) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.j));
    }
    if (jdField_a_of_type_JavaUtilHashSet.contains(this.j)) {
      return;
    }
    jdField_a_of_type_JavaUtilHashSet.add(this.j);
    d(2001);
    e();
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_k_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong2;
      d(2002);
      int m = (int)(10000L * paramLong1 / paramLong2);
      paramNetReq = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramNetReq.hasNext()) {
        ((DownCallBack)paramNetReq.next()).a(m, false);
      }
    }
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 239	com/tencent/mobileqq/transfile/BaseDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   11: new 77	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   18: ldc -15
    //   20: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 243	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   27: invokevirtual 147	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: ldc -11
    //   32: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: astore_2
    //   36: aload_1
    //   37: getfield 249	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   40: ifne +572 -> 612
    //   43: iconst_1
    //   44: istore 8
    //   46: aload_0
    //   47: ldc -5
    //   49: aload_2
    //   50: iload 8
    //   52: invokevirtual 147	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 254	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +90 -> 154
    //   67: ldc 10
    //   69: iconst_2
    //   70: new 77	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 256
    //   80: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: getfield 249	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   87: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: ldc 10
    //   98: iconst_2
    //   99: new 77	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 261
    //   109: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: getfield 263	com/tencent/mobileqq/transfile/NetResp:f	I
    //   116: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: ldc 10
    //   127: iconst_2
    //   128: new 77	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 265
    //   138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: getfield 267	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +36 -> 193
    //   160: ldc 10
    //   162: iconst_2
    //   163: new 77	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 269
    //   173: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: getfield 271	com/tencent/mobileqq/transfile/NetResp:jdField_j_of_type_Long	J
    //   180: ldc2_w 272
    //   183: ldiv
    //   184: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_0
    //   194: getfield 243	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   197: ifeq +421 -> 618
    //   200: aload_0
    //   201: getfield 279	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   204: astore_2
    //   205: aload_1
    //   206: getfield 249	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   209: ifne +417 -> 626
    //   212: iconst_1
    //   213: istore 8
    //   215: aload_0
    //   216: aload_2
    //   217: aload_1
    //   218: iload 8
    //   220: invokevirtual 282	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   223: aload_0
    //   224: aload_1
    //   225: getfield 283	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Long	J
    //   228: putfield 284	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   231: aload_0
    //   232: getfield 284	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   235: lconst_0
    //   236: lcmp
    //   237: ifgt +19 -> 256
    //   240: aload_0
    //   241: aload_1
    //   242: getfield 286	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Long	J
    //   245: aload_1
    //   246: getfield 289	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   249: getfield 292	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_Long	J
    //   252: ladd
    //   253: putfield 284	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   256: aload_0
    //   257: aload_0
    //   258: getfield 293	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   261: aload_1
    //   262: getfield 294	com/tencent/mobileqq/transfile/NetResp:jdField_c_of_type_Long	J
    //   265: ladd
    //   266: putfield 293	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   269: aload_0
    //   270: aload_1
    //   271: getfield 297	com/tencent/mobileqq/transfile/NetResp:g	J
    //   274: putfield 48	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_c_of_type_Long	J
    //   277: aload_0
    //   278: aload_1
    //   279: getfield 299	com/tencent/mobileqq/transfile/NetResp:jdField_j_of_type_Int	I
    //   282: putfield 50	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aK	I
    //   285: aload_1
    //   286: getfield 249	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   289: ifne +500 -> 789
    //   292: aload_0
    //   293: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   296: getfield 301	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   299: astore_2
    //   300: aload_2
    //   301: invokestatic 307	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne +667 -> 971
    //   307: aload_0
    //   308: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   311: getfield 102	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   314: astore_1
    //   315: new 309	java/io/FileInputStream
    //   318: dup
    //   319: aload_1
    //   320: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   323: astore_1
    //   324: aload_1
    //   325: aload_1
    //   326: invokevirtual 313	java/io/FileInputStream:available	()I
    //   329: i2l
    //   330: invokestatic 319	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   333: astore_3
    //   334: aload_3
    //   335: ifnull +630 -> 965
    //   338: aload_0
    //   339: aload_3
    //   340: invokestatic 325	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   343: putfield 44	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   346: aload_0
    //   347: getfield 44	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   350: aload_2
    //   351: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifne +611 -> 965
    //   357: aload_0
    //   358: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   361: getfield 330	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   364: bipush 6
    //   366: if_icmpeq +27 -> 393
    //   369: aload_0
    //   370: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   373: getfield 330	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   376: bipush 9
    //   378: if_icmpeq +15 -> 393
    //   381: aload_0
    //   382: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   385: getfield 330	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   388: bipush 17
    //   390: if_icmpne +575 -> 965
    //   393: aload_0
    //   394: ldc_w 331
    //   397: ldc_w 333
    //   400: invokevirtual 336	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   403: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +42 -> 448
    //   409: ldc 10
    //   411: iconst_2
    //   412: new 77	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 338
    //   422: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_2
    //   426: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 340
    //   432: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: getfield 44	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   439: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: iconst_0
    //   449: istore 4
    //   451: iload 4
    //   453: istore 5
    //   455: aload_1
    //   456: ifnull +11 -> 467
    //   459: aload_1
    //   460: invokevirtual 343	java/io/FileInputStream:close	()V
    //   463: iload 4
    //   465: istore 5
    //   467: aload_0
    //   468: getfield 346	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   471: astore_1
    //   472: iload 5
    //   474: ifeq +288 -> 762
    //   477: iconst_1
    //   478: istore 4
    //   480: aload_1
    //   481: ldc_w 348
    //   484: iload 4
    //   486: invokestatic 352	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   489: invokevirtual 358	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   492: pop
    //   493: aload_0
    //   494: invokespecial 118	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:f	()Z
    //   497: ifeq +100 -> 597
    //   500: new 360	java/io/File
    //   503: dup
    //   504: aload_0
    //   505: getfield 361	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   508: getfield 363	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   511: invokespecial 364	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: astore_1
    //   515: new 360	java/io/File
    //   518: dup
    //   519: aload_0
    //   520: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   523: getfield 102	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   526: invokespecial 364	java/io/File:<init>	(Ljava/lang/String;)V
    //   529: astore_2
    //   530: aload_1
    //   531: aload_2
    //   532: invokestatic 369	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   535: pop
    //   536: iload 10
    //   538: istore 8
    //   540: iload 8
    //   542: istore 9
    //   544: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +50 -> 597
    //   550: ldc 10
    //   552: iconst_2
    //   553: new 77	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 371
    //   563: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   570: getfield 102	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   573: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 373
    //   579: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: iload 8
    //   584: invokevirtual 147	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   587: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: iload 8
    //   595: istore 9
    //   597: iload 9
    //   599: ifne +7 -> 606
    //   602: aload_0
    //   603: invokevirtual 375	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:c	()V
    //   606: aload_0
    //   607: aconst_null
    //   608: putfield 361	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   611: return
    //   612: iconst_0
    //   613: istore 8
    //   615: goto -569 -> 46
    //   618: aload_0
    //   619: getfield 377	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   622: astore_2
    //   623: goto -418 -> 205
    //   626: iconst_0
    //   627: istore 8
    //   629: goto -414 -> 215
    //   632: astore_1
    //   633: iload 4
    //   635: istore 5
    //   637: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq -173 -> 467
    //   643: ldc 10
    //   645: iconst_2
    //   646: ldc_w 379
    //   649: aload_1
    //   650: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   653: iload 4
    //   655: istore 5
    //   657: goto -190 -> 467
    //   660: astore_2
    //   661: aconst_null
    //   662: astore_1
    //   663: iconst_1
    //   664: istore 4
    //   666: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +13 -> 682
    //   672: ldc 10
    //   674: iconst_2
    //   675: ldc_w 379
    //   678: aload_2
    //   679: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   682: iload 4
    //   684: istore 5
    //   686: aload_1
    //   687: ifnull -220 -> 467
    //   690: aload_1
    //   691: invokevirtual 343	java/io/FileInputStream:close	()V
    //   694: iload 4
    //   696: istore 5
    //   698: goto -231 -> 467
    //   701: astore_1
    //   702: iload 4
    //   704: istore 5
    //   706: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq -242 -> 467
    //   712: ldc 10
    //   714: iconst_2
    //   715: ldc_w 379
    //   718: aload_1
    //   719: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   722: iload 4
    //   724: istore 5
    //   726: goto -259 -> 467
    //   729: astore_2
    //   730: aconst_null
    //   731: astore_1
    //   732: aload_1
    //   733: ifnull +7 -> 740
    //   736: aload_1
    //   737: invokevirtual 343	java/io/FileInputStream:close	()V
    //   740: aload_2
    //   741: athrow
    //   742: astore_1
    //   743: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq -6 -> 740
    //   749: ldc 10
    //   751: iconst_2
    //   752: ldc_w 379
    //   755: aload_1
    //   756: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   759: goto -19 -> 740
    //   762: iconst_0
    //   763: istore 4
    //   765: goto -285 -> 480
    //   768: astore_1
    //   769: aload_0
    //   770: sipush 35536
    //   773: ldc_w 384
    //   776: invokevirtual 336	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   779: aload_0
    //   780: invokevirtual 386	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:b	()V
    //   783: iconst_1
    //   784: istore 8
    //   786: goto -246 -> 540
    //   789: aload_0
    //   790: getfield 243	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   793: ifeq +10 -> 803
    //   796: aload_0
    //   797: invokevirtual 193	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:e	()V
    //   800: goto -194 -> 606
    //   803: aload_1
    //   804: getfield 387	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   807: ldc_w 389
    //   810: invokevirtual 392	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   813: ifnonnull +71 -> 884
    //   816: ldc2_w 393
    //   819: lstore 6
    //   821: aload_0
    //   822: getfield 346	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   825: ldc_w 396
    //   828: lload 6
    //   830: invokestatic 399	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   833: invokevirtual 358	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   836: pop
    //   837: aload_1
    //   838: getfield 263	com/tencent/mobileqq/transfile/NetResp:f	I
    //   841: sipush 9364
    //   844: if_icmpne +61 -> 905
    //   847: aload_0
    //   848: getfield 402	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aW	I
    //   851: iconst_3
    //   852: if_icmpge +53 -> 905
    //   855: aload_0
    //   856: ldc_w 404
    //   859: ldc_w 406
    //   862: invokevirtual 254	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   865: aload_0
    //   866: aload_0
    //   867: getfield 402	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aW	I
    //   870: iconst_1
    //   871: iadd
    //   872: putfield 402	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aW	I
    //   875: aload_0
    //   876: invokevirtual 409	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:q	()V
    //   879: aload_0
    //   880: invokevirtual 193	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:e	()V
    //   883: return
    //   884: aload_1
    //   885: getfield 387	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   888: ldc_w 389
    //   891: invokevirtual 392	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   894: checkcast 65	java/lang/String
    //   897: invokestatic 415	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   900: lstore 6
    //   902: goto -81 -> 821
    //   905: aload_1
    //   906: getfield 387	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   909: getstatic 420	com/tencent/mobileqq/utils/httputils/HttpMsg:am	Ljava/lang/String;
    //   912: invokevirtual 392	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   915: checkcast 65	java/lang/String
    //   918: astore_2
    //   919: aload_0
    //   920: aload_1
    //   921: getfield 263	com/tencent/mobileqq/transfile/NetResp:f	I
    //   924: aload_1
    //   925: getfield 267	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   928: aload_2
    //   929: aload_0
    //   930: getfield 377	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   933: invokevirtual 423	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   936: aload_0
    //   937: invokevirtual 386	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:b	()V
    //   940: goto -334 -> 606
    //   943: astore_2
    //   944: goto -212 -> 732
    //   947: astore_2
    //   948: goto -216 -> 732
    //   951: astore_2
    //   952: iconst_1
    //   953: istore 4
    //   955: goto -289 -> 666
    //   958: astore_2
    //   959: iconst_0
    //   960: istore 4
    //   962: goto -296 -> 666
    //   965: iconst_1
    //   966: istore 4
    //   968: goto -517 -> 451
    //   971: iconst_1
    //   972: istore 5
    //   974: goto -507 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	977	0	this	ShortVideoDownloadProcessor
    //   0	977	1	paramNetResp	NetResp
    //   35	588	2	localObject1	Object
    //   660	19	2	localIOException1	java.io.IOException
    //   729	12	2	localObject2	Object
    //   918	11	2	str	String
    //   943	1	2	localObject3	Object
    //   947	1	2	localObject4	Object
    //   951	1	2	localIOException2	java.io.IOException
    //   958	1	2	localIOException3	java.io.IOException
    //   333	7	3	arrayOfByte	byte[]
    //   449	518	4	m	int
    //   453	520	5	n	int
    //   819	82	6	l	long
    //   44	741	8	bool1	boolean
    //   1	597	9	i1	int
    //   4	533	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   459	463	632	java/io/IOException
    //   315	324	660	java/io/IOException
    //   690	694	701	java/io/IOException
    //   315	324	729	finally
    //   736	740	742	java/io/IOException
    //   530	536	768	java/lang/OutOfMemoryError
    //   324	334	943	finally
    //   338	393	943	finally
    //   393	403	943	finally
    //   403	448	943	finally
    //   666	682	947	finally
    //   324	334	951	java/io/IOException
    //   338	393	951	java/io/IOException
    //   393	403	951	java/io/IOException
    //   403	448	958	java/io/IOException
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int m = 0;
      if (m < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(m);
        a("procUrl", paramRichProtoReq.toString());
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_a_of_type_Int == 1)
        {
          ArrayList localArrayList = InnerDns.a().a(paramRichProtoReq.jdField_b_of_type_JavaLangString, 1005);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            int n = 0;
            while (n < localArrayList.size())
            {
              ServerAddr localServerAddr = new ServerAddr();
              localServerAddr.jdField_a_of_type_JavaLangString = ((String)localArrayList.get(m));
              localServerAddr.jdField_b_of_type_Int = 80;
              this.jdField_a_of_type_JavaUtilArrayList.add(localServerAddr);
              n += 1;
            }
          }
          this.g = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          label169:
          if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
            break label384;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " isDomain:" + paramRichProtoReq.jdField_a_of_type_Int + " domain:" + paramRichProtoReq.jdField_b_of_type_JavaLangString + " url:" + paramRichProtoReq.jdField_c_of_type_JavaLangString);
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- downResp.md5:" + HexUtil.bytes2HexStr(paramRichProtoReq.jdField_a_of_type_ArrayOfByte));
          }
          this.f = paramRichProtoReq.jdField_c_of_type_JavaLangString;
          if (!StringUtil.b(this.f)) {
            break label372;
          }
          this.f = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          a(paramRichProtoReq.jdField_b_of_type_ArrayOfByte, true);
        }
        for (;;)
        {
          m += 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          break label169;
          label372:
          a(paramRichProtoReq.jdField_b_of_type_ArrayOfByte, false);
        }
        label384:
        if (-5100026 != this.aU) {
          break label470;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
        }
        a(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
      }
    }
    for (;;)
    {
      b();
      return;
      label470:
      if ((56009 == this.aU) && ((this.bc.equals("H_400_-5103017")) || (this.bc.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.aU);
        }
        a(this.aU, "视频文件过期");
      }
      else
      {
        a(9045, "申请信令失败");
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Boolean) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.aU))) || (this.i) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int n = this.aX;
    int m;
    String str1;
    label100:
    long l;
    if (paramBoolean)
    {
      m = 2;
      this.aX = (m | n);
      str1 = "actShortVideoDownloadVideo";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 7) {
        break label528;
      }
      str1 = "actShortVideoDownloadThumb";
      if (this.aK > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int));
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actShortVideoRedirect", true, this.jdField_c_of_type_Long, this.aK, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.aK + " " + this.jdField_c_of_type_Long + " " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + str1);
      }
      l = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.j);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.aJ + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.aM));
      if (!paramBoolean) {
        break label645;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      return;
      m = 1;
      break;
      label528:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6)
      {
        str1 = "actShortVideoDownloadVideo";
        break label100;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 18))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        str1 = "actShortVideoDiscussgroupDownloadThumb";
        break label100;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 17))
      {
        str1 = "actShortVideoDiscussgroupDownloadVideo";
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      }
      break label100;
      label645:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      if (this.aU == -6103066) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + "fileMd5=" + this.jdField_k_of_type_JavaLangString);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int m = 0;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile encrypted ! ");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt", String.valueOf(1));
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      if (!paramBoolean) {
        break label517;
      }
    }
    Object localObject1;
    Object localObject2;
    label517:
    for (String str = d();; str = c())
    {
      localObject1 = new HttpNetReq();
      if (!StringUtil.b(this.g)) {
        ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("host", this.g);
      }
      ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = str;
      ((HttpNetReq)localObject1).jdField_c_of_type_Int = 0;
      ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      ((HttpNetReq)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject1).o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject1).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 17))
      {
        localObject2 = SharedPreUtils.f(BaseApplication.getContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0)) {
            ((HttpNetReq)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject2);
          }
        }
      }
      if (paramArrayOfByte != null) {
        ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$AESDecryptor = new HttpNetReq.AESDecryptor(paramArrayOfByte);
      }
      ((HttpNetReq)localObject1).jdField_a_of_type_Long = 0L;
      ((HttpNetReq)localObject1).f = true;
      ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((HttpNetReq)localObject1).jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "." + MD5.toMD5(this.j) + ".tmp");
      if (f())
      {
        paramArrayOfByte = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        ((HttpNetReq)localObject1).jdField_d_of_type_Boolean = true;
        ((HttpNetReq)localObject1).e = false;
        if (new File(((HttpNetReq)localObject1).jdField_c_of_type_JavaLangString).exists()) {
          ((HttpNetReq)localObject1).jdField_a_of_type_Long = paramArrayOfByte.transferedSize;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mUseRaf =>>>");
        }
      }
      a("httpDown", "url:" + str + ",downOffset:" + ((HttpNetReq)localObject1).jdField_a_of_type_Long);
      if (e()) {
        break label525;
      }
      jdField_a_of_type_JavaUtilHashSet.remove(this.j);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile unencrypted ! ");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt", String.valueOf(0));
      break;
    }
    label525:
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject1);
    r();
    ((HttpNetReq)localObject1).jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Boolean + " domain=" + this.g + " ipsize=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Boolean)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (!StringUtil.b(this.g)))
      {
        if (StringUtil.b(this.g))
        {
          paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
          for (;;)
          {
            localObject1 = paramArrayOfByte;
            if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            localObject1 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(m);
            localObject2 = new StringBuffer();
            ((StringBuffer)localObject2).append("http://");
            ((StringBuffer)localObject2).append(((ServerAddr)localObject1).jdField_a_of_type_JavaLangString);
            if (((ServerAddr)localObject1).jdField_b_of_type_Int != 80)
            {
              ((StringBuffer)localObject2).append(":");
              ((StringBuffer)localObject2).append(((ServerAddr)localObject1).jdField_b_of_type_Int);
            }
            ((StringBuffer)localObject2).append("/");
            paramArrayOfByte[m] = RichMediaUtil.a(str, ((StringBuffer)localObject2).toString());
            m += 1;
          }
        }
        paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size() + 1];
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          paramArrayOfByte[(paramArrayOfByte.length - 1)] = str;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "last url= " + paramArrayOfByte[(paramArrayOfByte.length - 1)]);
          }
          break;
          localObject1 = new StringBuffer();
          if (!this.g.startsWith("http://")) {
            ((StringBuffer)localObject1).append("http://");
          }
          ((StringBuffer)localObject1).append(this.g);
          if (!this.g.endsWith("/")) {
            ((StringBuffer)localObject1).append("/");
          }
          paramArrayOfByte[(paramArrayOfByte.length - 1)] = RichMediaUtil.a(str, ((StringBuffer)localObject1).toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c = ((String[])localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.w = this.g;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      d(2002);
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(a());
      jdField_a_of_type_JavaUtilHashSet.remove(this.j);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject1);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.j);
    return super.b();
  }
  
  void b()
  {
    super.b();
    jdField_a_of_type_JavaUtilHashSet.remove(this.j);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aE = this.aU;
    if (-5100026 == this.aU) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.aU);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.bc);
      }
      Object localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      }
      if (localObject != null)
      {
        ((TransferResult)localObject).jdField_d_of_type_Int = -1;
        ((TransferResult)localObject).jdField_a_of_type_Long = this.aU;
        ((TransferResult)localObject).jdField_a_of_type_JavaLangString = this.bc;
        ((TransferResult)localObject).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.aU;
        localDownResult.jdField_a_of_type_JavaLangString = this.bc;
        localDownCallBack.a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((56009 == this.aU) && ((this.bc.equals("H_400_-5103017")) || (this.bc.equals("H_400_-5103059")))) {
        d(5002);
      } else {
        d(2005);
      }
    }
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h == null))
    {
      a(9302, "下载路径文件保存路径未指定。");
      b();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.n = true;
    }
    return 0;
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
      if (localServerAddr.jdField_b_of_type_Int != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localServerAddr.jdField_b_of_type_Int);
      }
      localStringBuilder.append("/");
    }
    for (;;)
    {
      localStringBuilder.append(this.f);
      a("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      if (!this.g.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.g);
      if (!this.g.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
  
  void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.j);
    d(2003);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject != null)
    {
      ((TransferResult)localObject).jdField_d_of_type_Int = 0;
      ((TransferResult)localObject).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject).next();
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_a_of_type_Int = 0;
      localDownResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      localDownResult.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      localDownResult.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int;
      localDownCallBack.a(localDownResult);
    }
  }
  
  protected String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_b_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.jdField_b_of_type_Int);
    }
    localStringBuilder.append("/qqdownload?ver=");
    localStringBuilder.append("2880");
    localStringBuilder.append("&rkey=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("&filetype=");
    localStringBuilder.append(this.aL);
    localStringBuilder.append("&mType=shortVideo");
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    for (int m = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; m = 0)
    {
      localStringBuilder.append("&videotype=").append(m);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType == 1)) {
        localStringBuilder.append("&subvideotype=").append(1);
      }
      a("getConnUrl", "url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.jdField_k_of_type_Boolean) && (2004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoDownReq.jdField_c_of_type_Int);
    }
    localShortVideoDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoDownReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoDownReq.jdField_d_of_type_Int = 0;
    if (localShortVideoDownReq.jdField_e_of_type_Int == 0)
    {
      localShortVideoDownReq.jdField_a_of_type_Int = 0;
      if ((localShortVideoDownReq.jdField_e_of_type_Int != 0) && (1008 != localShortVideoDownReq.jdField_e_of_type_Int)) {
        break label484;
      }
      localShortVideoDownReq.jdField_b_of_type_JavaLangString = null;
      label164:
      localShortVideoDownReq.jdField_b_of_type_Int = 2;
      localShortVideoDownReq.jdField_a_of_type_JavaLangString = this.j;
      localShortVideoDownReq.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label498;
      }
      localShortVideoDownReq.f = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      label231:
      this.aJ = localShortVideoDownReq.f;
      localShortVideoDownReq.jdField_j_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType == 1)) {
        localShortVideoDownReq.jdField_j_of_type_Int = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 7) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 16) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 18)) {
        break label530;
      }
    }
    for (localShortVideoDownReq.jdField_g_of_type_Int = 1;; localShortVideoDownReq.jdField_g_of_type_Int = 2) {
      label484:
      label498:
      label530:
      do
      {
        localShortVideoDownReq.h = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof Integer))) {
          localShortVideoDownReq.i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).intValue();
        }
        localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
        localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_dw";
        localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoDownReq);
        localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (d()) {
          break label574;
        }
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
        if (1 == localShortVideoDownReq.jdField_e_of_type_Int)
        {
          localShortVideoDownReq.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localShortVideoDownReq.jdField_e_of_type_Int)
        {
          localShortVideoDownReq.jdField_a_of_type_Int = 2;
          break;
        }
        localShortVideoDownReq.jdField_a_of_type_Int = 3;
        break;
        localShortVideoDownReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
        break label164;
        if (1008 == localShortVideoDownReq.jdField_e_of_type_Int)
        {
          localShortVideoDownReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int;
          break label231;
        }
        localShortVideoDownReq.f = 0;
        break label231;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 17));
    }
    label574:
    a("requestStart", localRichProtoReq.toString());
    if (!e())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.j);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.jdField_k_of_type_Boolean);
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      d(2004);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ShortVideoDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */