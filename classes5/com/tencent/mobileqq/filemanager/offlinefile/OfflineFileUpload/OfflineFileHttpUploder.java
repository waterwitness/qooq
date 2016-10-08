package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OfflineFileHttpUploder
  implements INetEngine.INetEngineListener
{
  final int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  IOfflineFileHttpUploderSink jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  File jdField_a_of_type_JavaIoFile;
  InputStream jdField_a_of_type_JavaIoInputStream;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  final int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  final int e;
  int f;
  
  public OfflineFileHttpUploder(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, IOfflineFileHttpUploderSink paramIOfflineFileHttpUploderSink)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "OfflineFileHttpUploder<FileAssistant>";
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM = null;
    this.jdField_a_of_type_JavaIoFile = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaIoInputStream = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 0;
    this.e = 5;
    this.f = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramQQAppInterface.a(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink = paramIOfflineFileHttpUploderSink;
    paramIOfflineFileHttpUploderSink = new ArrayList(1);
    paramIOfflineFileHttpUploderSink.add(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramIOfflineFileHttpUploderSink, "/ftn_handler");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
    this.jdField_a_of_type_JavaIoFile = new File(paramString2);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 2, "Id[" + this.jdField_d_of_type_JavaLangString + "]" + "stop");
    }
  }
  
  public void a(long paramLong)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localHttpNetReq.jdField_c_of_type_Int = 1;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    try
    {
      byte[] arrayOfByte = a(paramLong);
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a(arrayOfByte, paramLong);
      if (arrayOfByte == null) {
        return;
      }
      localHttpNetReq.jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
      if (QLog.isColorLevel())
      {
        QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]Send Http Request!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "] Exception:" + localException.toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, "nID[" + this.jdField_d_of_type_JavaLangString + "]onUpdateProgeress[" + paramLong1 + "]/[" + paramLong2 + "]");
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OfflineFileHttpUploder<FileAssistant>", 4, "logID[" + this.jdField_d_of_type_JavaLangString + "]onResp result:" + paramNetResp.e + " errCode:" + paramNetResp.f + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
      i = paramNetResp.g;
      if ((paramNetResp.f == 9364) && (this.jdField_b_of_type_Int < 3))
      {
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]onNetChanged:mNetworkChangRetryCount[" + this.jdField_b_of_type_Int + "] retry!");
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a(true);
        }
        a(this.jdField_b_of_type_Long);
        return;
      }
      if ((FileHttpUtils.a(paramNetResp.f)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor != null))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
        if (str != null)
        {
          this.jdField_b_of_type_JavaLangString = str;
          a(this.jdField_b_of_type_Long);
          return;
        }
      }
      if ((i == 200) && (paramNetResp.e == 0)) {
        break;
      }
      if ((paramNetResp.e == 9056) && (this.f < 5))
      {
        this.f += 1;
        a(this.jdField_b_of_type_Long);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
    } while (!QLog.isColorLevel());
    QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]httpRetCode:" + i + "]onResp result:" + paramNetResp.e + " errCode:" + paramNetResp.f + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    return;
    this.f = 0;
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
    String str = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode");
    if (str != null) {}
    for (long l = Long.parseLong(str);; l = 0L)
    {
      if (l != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "ResponCode[206]But UserCode[" + l + "]");
        return;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a(paramNetResp);
      if (l == -1L)
      {
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server resp data read len -1");
        if (QLog.isDevelopLevel()) {
          throw new IllegalArgumentException();
        }
      }
      if (l == 0L)
      {
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server resp data read len 0");
        return;
      }
      if (l == this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "miaochuan");
        return;
      }
      if (l < this.jdField_b_of_type_Long)
      {
        paramNetResp = "RangSizeError_rangError tSize[" + String.valueOf(l) + "]<=mSize[" + String.valueOf(this.jdField_b_of_type_Long) + "],reTryafter[" + String.valueOf(this.jdField_d_of_type_Int) + "]";
        QLog.w("OfflineFileHttpUploder<FileAssistant>", 1, "nSessionId[" + this.jdField_d_of_type_JavaLangString + "]" + paramNetResp);
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_d_of_type_Int < 3)
        {
          QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server rang error retry,mmaxRangErrorRetryCount [" + this.jdField_d_of_type_Int + "], maxRangErrorRetry[" + 3 + "]");
          a(l);
          return;
        }
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]server rang error not retry,mmaxRangErrorRetryCount [" + this.jdField_d_of_type_Int + "], maxRangErrorRetry[" + 3 + "]");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
        return;
      }
      this.jdField_d_of_type_Int = 0;
      this.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
      a(l);
      return;
    }
  }
  
  /* Error */
  byte[] a(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +8 -> 11
    //   6: aload_0
    //   7: lconst_0
    //   8: putfield 55	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_b_of_type_Long	J
    //   11: aload_0
    //   12: getfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   15: ifnonnull +23 -> 38
    //   18: aload_0
    //   19: new 313	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: getfield 45	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   33: aload_0
    //   34: lconst_0
    //   35: putfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: ifne +110 -> 151
    //   44: aload_0
    //   45: getfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: new 313	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: getfield 45	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   68: aload_0
    //   69: lconst_0
    //   70: putfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   73: aload_0
    //   74: lload_1
    //   75: putfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   78: aload_0
    //   79: getfield 47	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   82: aload_0
    //   83: getfield 51	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_Long	J
    //   86: aload_0
    //   87: getfield 55	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_b_of_type_Long	J
    //   90: lload_1
    //   91: invokestatic 319	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUtils:a	(Lcom/tencent/wstt/SSCM/SSCM;JJJ)I
    //   94: istore 4
    //   96: iload 4
    //   98: newarray <illegal type>
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload_3
    //   106: iconst_0
    //   107: iload 4
    //   109: invokevirtual 325	java/io/InputStream:read	([BII)I
    //   112: pop
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   118: iload 4
    //   120: i2l
    //   121: ladd
    //   122: putfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   125: aload_3
    //   126: areturn
    //   127: astore_3
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   133: aload_3
    //   134: invokevirtual 328	java/io/FileNotFoundException:printStackTrace	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_3
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   145: aload_3
    //   146: invokevirtual 328	java/io/FileNotFoundException:printStackTrace	()V
    //   149: aconst_null
    //   150: areturn
    //   151: lload_1
    //   152: aload_0
    //   153: getfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   156: lcmp
    //   157: ifle +27 -> 184
    //   160: aload_0
    //   161: getfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   164: lload_1
    //   165: aload_0
    //   166: getfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   169: lsub
    //   170: invokevirtual 332	java/io/InputStream:skip	(J)J
    //   173: pop2
    //   174: goto -101 -> 73
    //   177: astore_3
    //   178: aload_3
    //   179: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   182: aconst_null
    //   183: areturn
    //   184: lload_1
    //   185: aload_0
    //   186: getfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   189: lcmp
    //   190: ifge -117 -> 73
    //   193: aload_0
    //   194: new 313	java/io/FileInputStream
    //   197: dup
    //   198: aload_0
    //   199: getfield 45	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   202: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   205: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   208: aload_0
    //   209: lconst_0
    //   210: putfield 75	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_c_of_type_Long	J
    //   213: aload_0
    //   214: getfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   217: lload_1
    //   218: invokevirtual 332	java/io/InputStream:skip	(J)J
    //   221: pop2
    //   222: goto -149 -> 73
    //   225: astore_3
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 53	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   231: aload_3
    //   232: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -115 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	OfflineFileHttpUploder
    //   0	243	1	paramLong	long
    //   100	26	3	arrayOfByte	byte[]
    //   127	7	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   139	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   177	2	3	localIOException1	java.io.IOException
    //   225	7	3	localIOException2	java.io.IOException
    //   237	1	3	localException	Exception
    //   239	1	3	localObject	Object
    //   94	25	4	i	int
    // Exception table:
    //   from	to	target	type
    //   18	38	127	java/io/FileNotFoundException
    //   53	73	139	java/io/FileNotFoundException
    //   160	174	177	java/io/IOException
    //   193	222	225	java/io/IOException
    //   101	125	237	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 2, "Id[" + this.jdField_d_of_type_JavaLangString + "]" + "Run");
    }
    a(0L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\offlinefile\OfflineFileUpload\OfflineFileHttpUploder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */