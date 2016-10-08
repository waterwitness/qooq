package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import rxf;
import rxg;
import rxh;
import rxi;
import rxj;

public class FileUploader
  implements rxi
{
  private static final int jdField_a_of_type_Int = 6000;
  private static final String jdField_a_of_type_JavaLangString = "FtnHttpUploader<FileAssistant>";
  private static final int jdField_b_of_type_Int = 8;
  private final long jdField_a_of_type_Long;
  private FileUploader.IFileUploaderSink jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink;
  private FileUploader.IFlowControl jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl;
  private final HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private rxj jdField_a_of_type_Rxj;
  private boolean jdField_a_of_type_Boolean;
  private final long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private int f;
  private int g;
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new rxh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramString2);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Rxj = Md5HttpUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Rxj != null) {
      this.jdField_a_of_type_Rxj.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new rxh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramString4);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Rxj = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Rxj != null) {
      this.jdField_a_of_type_Rxj.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new rxh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString4);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Rxj = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Rxj != null) {
      this.jdField_a_of_type_Rxj.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List paramList, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new rxh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString2);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Rxj = Md5HttpUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Rxj != null) {
      this.jdField_a_of_type_Rxj.a(this);
    }
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramString1.length() != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        return null;
        if (paramString2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      return null;
      if (paramString2.length() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
    return null;
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
      }
      return null;
    }
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramList, paramString4);
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List paramList, String paramString2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramList, paramString2);
  }
  
  private void a(int paramInt)
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    }
    if ((str == null) || (str.length() == 0))
    {
      QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + paramInt + "]");
      return;
    }
    this.jdField_c_of_type_JavaLangString = str;
    this.jdField_e_of_type_Int += 1;
    this.jdField_c_of_type_Int = 0;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
          return true;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localFileNotFoundException.printStackTrace();
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  private byte[] a(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: invokespecial 202	com/tencent/mobileqq/filemanager/core/FileUploader:a	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 204	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   19: lstore 5
    //   21: lload_1
    //   22: lload 5
    //   24: lcmp
    //   25: ifle +79 -> 104
    //   28: aload_0
    //   29: getfield 185	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 204	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   37: lsub
    //   38: invokevirtual 208	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 204	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   47: aload_0
    //   48: getfield 38	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl	Lcom/tencent/mobileqq/filemanager/core/FileUploader$IFlowControl;
    //   51: aload_0
    //   52: getfield 97	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_d_of_type_Long	J
    //   55: aload_0
    //   56: getfield 53	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_b_of_type_Long	J
    //   59: invokeinterface 213 5 0
    //   64: istore 4
    //   66: iload 4
    //   68: newarray <illegal type>
    //   70: astore_3
    //   71: aload_0
    //   72: getfield 185	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   75: aload_3
    //   76: iconst_0
    //   77: iload 4
    //   79: invokevirtual 217	java/io/InputStream:read	([BII)I
    //   82: pop
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 204	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   88: iload 4
    //   90: i2l
    //   91: ladd
    //   92: putfield 204	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   95: aload_3
    //   96: areturn
    //   97: astore_3
    //   98: aload_3
    //   99: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   102: aconst_null
    //   103: areturn
    //   104: lload_1
    //   105: aload_0
    //   106: getfield 204	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   109: lcmp
    //   110: ifge -68 -> 42
    //   113: aload_0
    //   114: invokespecial 202	com/tencent/mobileqq/filemanager/core/FileUploader:a	()Z
    //   117: istore 7
    //   119: iload 7
    //   121: ifeq +65 -> 186
    //   124: aload_0
    //   125: getfield 185	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   128: lload_1
    //   129: invokevirtual 208	java/io/InputStream:skip	(J)J
    //   132: pop2
    //   133: goto -91 -> 42
    //   136: astore_3
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 185	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   142: aload_3
    //   143: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   153: ldc 12
    //   155: iconst_1
    //   156: new 152	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   163: ldc -36
    //   165: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_3
    //   169: invokevirtual 221	java/lang/Exception:toString	()Ljava/lang/String;
    //   172: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aconst_null
    //   182: astore_3
    //   183: goto -88 -> 95
    //   186: aconst_null
    //   187: areturn
    //   188: astore_3
    //   189: aconst_null
    //   190: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	FileUploader
    //   0	191	1	paramLong	long
    //   70	26	3	arrayOfByte	byte[]
    //   97	2	3	localIOException1	IOException
    //   136	7	3	localIOException2	IOException
    //   148	21	3	localException1	Exception
    //   182	1	3	localObject	Object
    //   188	1	3	localException2	Exception
    //   64	25	4	i	int
    //   19	4	5	l	long
    //   117	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	42	97	java/io/IOException
    //   124	133	136	java/io/IOException
    //   71	95	148	java/lang/Exception
    //   6	13	188	java/lang/Exception
    //   15	21	188	java/lang/Exception
    //   28	42	188	java/lang/Exception
    //   42	71	188	java/lang/Exception
    //   98	102	188	java/lang/Exception
    //   104	119	188	java/lang/Exception
    //   124	133	188	java/lang/Exception
    //   137	146	188	java/lang/Exception
    //   149	181	188	java/lang/Exception
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new rxh(this);
    new Handler().postDelayed(new rxg(this), paramInt);
  }
  
  private void b(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.jdField_d_of_type_Long + "], lastRoolbackSize[" + this.jdField_c_of_type_Long + "], retry[" + this.g + "]";
    if (paramLong <= this.jdField_c_of_type_Long)
    {
      int i = this.g + 1;
      this.g = i;
      if (i > 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, paramLong, str, paramString);
        return;
      }
    }
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = paramLong;
    new Handler().postDelayed(new rxf(this), 6000L);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(false, paramLong, str, paramString);
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      this.jdField_a_of_type_Rxj.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9343, "parseDataErr", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (56009 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 35934, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.h();
        return;
      }
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
    if (FileHttpUtils.a(paramInt)) {
      a(paramInt);
    }
    if (this.jdField_c_of_type_Int < 8)
    {
      this.f += 1;
      if ((this.jdField_d_of_type_Int < 3) && (9056 == paramInt))
      {
        this.jdField_d_of_type_Int += 1;
        if (paramInt != 9056) {
          break label248;
        }
      }
    }
    label248:
    for (int i = 0;; i = 6000)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(false, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      b(i);
      return;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl.a();
    if (paramLong <= this.jdField_d_of_type_Long)
    {
      b(paramLong, paramString);
      return;
    }
    if ((this.jdField_d_of_type_Long == 0L) && (paramLong == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a();
      return;
    }
    this.jdField_d_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FtnHttpUploader<FileAssistant>", 2, "send http data size[" + String.valueOf(this.jdField_d_of_type_Long) + "] fileSize[" + this.jdField_b_of_type_Long + "] success!");
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(paramLong);
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      a(this.jdField_d_of_type_Long);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.b();
  }
  
  public void a(FileUploader.IFileUploaderSink paramIFileUploaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink = paramIFileUploaderSink;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9062, "UrlOver", null);
  }
  
  public boolean a(long paramLong)
  {
    byte[] arrayOfByte = a(paramLong);
    if (arrayOfByte == null)
    {
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "getSendStreamSlice return null");
      return false;
    }
    return this.jdField_a_of_type_Rxj.a(this.jdField_c_of_type_JavaLangString, paramLong, arrayOfByte);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a();
  }
  
  public int c()
  {
    return this.f;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\FileUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */