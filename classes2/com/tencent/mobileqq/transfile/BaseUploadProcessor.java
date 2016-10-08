package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseUploadProcessor
  extends BaseTransProcessor
{
  static final int bh = 14600;
  static final int bi = 32768;
  static final int bj = 131072;
  public long a;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  public RandomAccessFile a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  protected boolean a;
  public byte[] a;
  int aM;
  int aN;
  long jdField_b_of_type_Long;
  public Transaction b;
  boolean jdField_b_of_type_Boolean;
  int be;
  int bf;
  int bg;
  public int bk;
  public int bl;
  public int bm;
  public long c;
  boolean c;
  boolean d;
  public String e;
  protected boolean e;
  String f;
  String g;
  public String h;
  String i;
  long jdField_j_of_type_Long;
  String jdField_j_of_type_JavaLangString;
  public long k;
  
  public BaseUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.be = 0;
    this.jdField_c_of_type_Long = 0L;
    this.bf = 0;
    this.bg = 0;
    this.j = 20480L;
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.bk = -1;
    this.bl = -1;
    this.bm = 0;
    b(paramTransferRequest.c + paramTransferRequest.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = paramTransferRequest.e;
  }
  
  public void J_()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l1 = this.jdField_c_of_type_Long;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      b();
    }
    do
    {
      return;
      a("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.jdField_a_of_type_Long) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
    r();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
  }
  
  public int a()
  {
    return super.a();
  }
  
  protected long a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    return Math.min(this.j, l - paramLong);
  }
  
  protected HttpNetReq a(byte[] paramArrayOfByte)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = a(paramArrayOfByte);
    localHttpNetReq.c = 1;
    localHttpNetReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.d = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localHttpNetReq.f = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_c_of_type_Long + "-");
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    return localHttpNetReq;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(true, 1, paramInt, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(true, 1, paramInt, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(true, 0, paramInt, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(true, 0, paramInt, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int m = 0;
      paramInt1 = paramInt2;
      while (m < paramInt2)
      {
        int n = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte, m, paramInt1);
        if (n == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        m += n;
        paramInt1 -= n;
      }
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      localIOException.printStackTrace();
    }
    return null;
  }
  
  public int b()
  {
    return super.b();
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, paramString);
    }
  }
  
  protected void e()
  {
    int m = 1;
    if ((this.bm == 2) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_BdhTrans"))) {
      if ((this.jdField_g_of_type_Long > 0L) && (this.h > 0L))
      {
        if ((this.p) && (m != 0))
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
          this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.bd).append("_").append("tr").append(this.jdField_g_of_type_Long).append("_").append("ht").append(this.jdField_f_of_type_Long).append("_").append("pic").append(this.h).append(";");
          this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.h));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.bd));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.bd).append(";").append("tc_s:").append(this.jdField_g_of_type_Long).append(";").append("tc_h:").append(this.jdField_f_of_type_Long).append(";").append("tc_p:").append(this.h).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", localStringBuilder.toString());
      }
    }
    while ((this.bm != 1) || (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null)) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        m = 0;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
  }
  
  public void f()
  {
    this.jdField_d_of_type_Long = System.nanoTime();
  }
  
  /* Error */
  public boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 203	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   4: getfield 356	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   7: astore_3
    //   8: new 358	java/io/FileInputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 360	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 363	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   25: getfield 366	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   28: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   31: putfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   41: invokestatic 378	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   44: putfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   54: putfield 382	com/tencent/mobileqq/transfile/BaseUploadProcessor:e	Ljava/lang/String;
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 363	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   63: aload_0
    //   64: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   67: putfield 384	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   70: aload_2
    //   71: astore_1
    //   72: aload_0
    //   73: new 87	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   80: aload_0
    //   81: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 386
    //   90: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: getfield 388	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: putfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 390	java/io/FileInputStream:close	()V
    //   114: iconst_1
    //   115: istore 4
    //   117: iload 4
    //   119: ireturn
    //   120: astore_1
    //   121: aload_2
    //   122: astore_1
    //   123: new 392	java/io/File
    //   126: dup
    //   127: aload_3
    //   128: invokespecial 393	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore_3
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: invokevirtual 396	java/io/File:exists	()Z
    //   138: istore 4
    //   140: iload 4
    //   142: ifeq -108 -> 34
    //   145: aload_2
    //   146: astore_1
    //   147: aload_3
    //   148: invokestatic 401	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +16 -> 169
    //   156: aload_2
    //   157: astore_1
    //   158: aload_0
    //   159: aload_3
    //   160: invokestatic 405	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   163: putfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   166: goto -132 -> 34
    //   169: ldc_w 407
    //   172: astore_3
    //   173: goto -17 -> 156
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   181: goto -67 -> 114
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: astore_1
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   194: aload_2
    //   195: astore_1
    //   196: aload_0
    //   197: aload_3
    //   198: invokevirtual 265	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Ljava/io/IOException;)V
    //   201: iconst_0
    //   202: istore 4
    //   204: aload_2
    //   205: ifnull -88 -> 117
    //   208: aload_2
    //   209: invokevirtual 390	java/io/FileInputStream:close	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 390	java/io/FileInputStream:close	()V
    //   232: aload_2
    //   233: athrow
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   239: goto -7 -> 232
    //   242: astore_2
    //   243: goto -19 -> 224
    //   246: astore_3
    //   247: goto -60 -> 187
    //   250: astore_1
    //   251: goto -217 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	BaseUploadProcessor
    //   18	54	1	localFileInputStream1	java.io.FileInputStream
    //   120	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   122	36	1	localFileInputStream2	java.io.FileInputStream
    //   176	2	1	localIOException1	IOException
    //   188	8	1	localFileInputStream3	java.io.FileInputStream
    //   214	2	1	localIOException2	IOException
    //   223	6	1	localObject1	Object
    //   234	2	1	localIOException3	IOException
    //   250	1	1	localIOException4	IOException
    //   16	193	2	localFileInputStream4	java.io.FileInputStream
    //   221	12	2	localObject2	Object
    //   242	1	2	localObject3	Object
    //   7	166	3	localObject4	Object
    //   184	14	3	localIOException5	IOException
    //   246	1	3	localIOException6	IOException
    //   115	88	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	34	120	java/lang/UnsatisfiedLinkError
    //   110	114	176	java/io/IOException
    //   8	17	184	java/io/IOException
    //   208	212	214	java/io/IOException
    //   8	17	221	finally
    //   228	232	234	java/io/IOException
    //   19	34	242	finally
    //   36	47	242	finally
    //   49	57	242	finally
    //   59	70	242	finally
    //   72	106	242	finally
    //   123	132	242	finally
    //   134	140	242	finally
    //   147	152	242	finally
    //   158	166	242	finally
    //   189	194	242	finally
    //   196	201	242	finally
    //   19	34	246	java/io/IOException
    //   36	47	246	java/io/IOException
    //   49	57	246	java/io/IOException
    //   59	70	246	java/io/IOException
    //   72	106	246	java/io/IOException
    //   123	132	246	java/io/IOException
    //   134	140	246	java/io/IOException
    //   147	152	250	java/io/IOException
    //   158	166	250	java/io/IOException
  }
  
  protected boolean g()
  {
    HwNetworkCenter.getInstance(BaseApplication.getContext()).updateNetInfo(BaseApplication.getContext());
    return HwNetworkCenter.getInstance(BaseApplication.getContext()).getNetType() != 0L;
  }
  
  public void k()
  {
    super.k();
    if (!this.k)
    {
      this.k = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1004);
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\BaseUploadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */