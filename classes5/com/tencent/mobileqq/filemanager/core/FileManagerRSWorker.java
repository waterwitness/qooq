package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploader;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;
import com.weiyun.sdk.IWyTaskManager.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import rwu;
import rwz;
import rxa;
import rxb;
import rxc;
import rxd;
import rxe;

public class FileManagerRSWorker
  implements IFileHttpBase, IHttpCommunicatorListener
{
  private static final int e = 8;
  private static final int f = 6000;
  private static final String jdField_k_of_type_JavaLangString = "FileManagerRSWorker<FileAssistant>";
  private static final long m = 1000L;
  public int a;
  public long a;
  public QQAppInterface a;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  public FileManagerEntity a;
  public OfflineFileHttpUploder a;
  OfflineFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader;
  public FMSettings a;
  HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  public IWyTaskManager.Task a;
  File jdField_a_of_type_JavaIoFile;
  InputStream jdField_a_of_type_JavaIoInputStream;
  public OutputStream a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  public boolean a;
  public byte[] a;
  int[] jdField_a_of_type_ArrayOfInt;
  public int b;
  public long b;
  HttpMsg b;
  public String b;
  public byte[] b;
  int c;
  public long c;
  public String c;
  public byte[] c;
  public int d;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  private int g;
  public long g;
  public String g;
  private int h;
  public long h;
  public String h;
  private int i;
  public long i;
  public String i;
  private int j;
  public long j;
  public String j;
  long jdField_k_of_type_Long;
  long jdField_l_of_type_Long;
  private String jdField_l_of_type_JavaLangString;
  private long n;
  
  public FileManagerRSWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_a_of_type_JavaIoInputStream = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaIoFile = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new rwu(this);
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = null;
    this.k = 0L;
    this.jdField_l_of_type_Long = 0L;
    if (paramFileManagerEntity == null)
    {
      try
      {
        throw new NullPointerException("entry = null,why?");
      }
      catch (NullPointerException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      label172:
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
    this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
    this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
    this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings = FMSettings.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName == null)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        }
        b();
        switch (this.jdField_b_of_type_Int)
        {
        case 2: 
        case 3: 
        case 4: 
        case 7: 
        default: 
          this.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
          this.jdField_b_of_type_Long = paramFileManagerEntity.uniseq;
          this.jdField_c_of_type_Long = paramFileManagerEntity.nSessionId;
          paramFileManagerEntity.status = 0;
          paramQQAppInterface.a().c(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.jdField_a_of_type_ComTencentWsttSSCMSSCM != null) {
            break label172;
          }
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + paramFileManagerEntity.nSessionId + "]" + "filepath[" + this.jdField_b_of_type_JavaLangString + "]:size[" + String.valueOf(paramFileManagerEntity.fileSize) + "]");
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileUp";
        this.jdField_j_of_type_JavaLangString = "actFileUpDetail";
      }
      for (;;)
      {
        if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() <= 0)) {
          break label578;
        }
        this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.getFilePath());
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_i_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      label578:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath");
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDown";
        this.jdField_j_of_type_JavaLangString = "actFileDownDetail";
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDiscDownLoad";
        this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoadDetail";
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
        }
        this.jdField_i_of_type_JavaLangString = "actFileWyDown";
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
        }
        this.jdField_i_of_type_JavaLangString = "actFileWyUp";
      }
    }
  }
  
  private String a(ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = HexUtil.bytes2HexStr(paramByteStringMicro.toByteArray());
    return "/?ver=2&rkey=" + paramByteStringMicro;
  }
  
  private String a(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private String a(String paramString1, String paramString2, long paramLong)
  {
    return "/?ver=2&ukey=" + paramString1 + "&filekey=" + paramString2 + "&filesize=" + paramLong;
  }
  
  private void a(long paramLong, FileManagerRSWorker.ChangeNewPath paramChangeNewPath)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    paramChangeNewPath = new ArrayList();
    paramChangeNewPath.add(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a(paramLong, paramChangeNewPath, SplashActivity.sTopActivity, new rxe(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      String str2 = "bytes=" + paramLong + "-";
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_f_of_type_JavaLangString, null, this, true);
      localHttpMsg.b(false);
      String str1 = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localHttpMsg.a("Net-type", str1);
      localHttpMsg.a("cache-control", "no-cache");
      localHttpMsg.a("Range", str2);
      if (paramString != null) {
        localHttpMsg.a("Cookie", paramString);
      }
      localHttpMsg.b(1);
      localHttpMsg.a(true);
      localHttpMsg.jdField_d_of_type_Int = 0;
      localHttpMsg.e = this.jdField_a_of_type_Int;
      localHttpMsg.ai = String.valueOf(this.jdField_c_of_type_Long);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    if (paramFileUploadInfo.jdField_d_of_type_Int == 2)
    {
      if (paramFileUploadInfo.a == 0) {
        paramFileUploadInfo.a = 80;
      }
      this.jdField_f_of_type_JavaLangString = (paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.a);
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]" + "sendFilePakage transferData null");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((HttpMsg)localObject).b(false);
      ((HttpMsg)localObject).a("cache-control", "no-cache");
      paramString = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((HttpMsg)localObject).a("Net-type", paramString);
      ((HttpMsg)localObject).a("Range", "bytes=" + paramLong + "-");
      ((HttpMsg)localObject).c("POST");
      ((HttpMsg)localObject).b(1);
      ((HttpMsg)localObject).jdField_d_of_type_Int = 0;
      ((HttpMsg)localObject).e = this.jdField_a_of_type_Int;
      ((HttpMsg)localObject).ai = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]" + "send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((HttpMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader = new OfflineFileUploader();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader.a(HexUtil.bytes2HexStr(paramArrayOfByte), HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte), HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder = new OfflineFileHttpUploder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder.b();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new OfflineFileUploadPara();
    paramString.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    paramString.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramString.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramString.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
    paramString.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramLong <= 104857600L)
    {
      paramString.jdField_a_of_type_Int = 1700;
      this.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(new String(paramArrayOfByte1));
      if (this.jdField_b_of_type_ArrayOfByte == null)
      {
        a(null);
        return;
      }
      paramString.d = this.jdField_b_of_type_ArrayOfByte;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, paramFileManagerEntity);
      return;
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = FileManagerUtil.b(new String(paramArrayOfByte1));
      if (this.jdField_c_of_type_ArrayOfByte == null)
      {
        a(null);
        return;
      }
      paramString.e = this.jdField_c_of_type_ArrayOfByte;
    }
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {}
    do
    {
      return false;
      if (paramHttpMsg2 == null) {
        return true;
      }
    } while (!NetworkUtil.e(BaseApplication.getContext()));
    return true;
  }
  
  private static String f()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject;
    try
    {
      if (!FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "rename error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
        b(null, null);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      localObject = HexUtil.bytes2HexStr(FileManagerUtil.c(this.jdField_b_of_type_JavaLangString));
      if (localObject != null) {
        break label904;
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if ((2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType) && (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, 150, 150);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      return;
      label904:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
      }
      else
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      }
    }
  }
  
  private void l()
  {
    ThreadManager.a().post(new rxd(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = f();
    }
    paramString1 = new File(str + paramString1);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return;
    }
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath))
    {
      k();
      return;
    }
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      b();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
        return;
      }
      catch (Exception localException)
      {
        a(null);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  public void a(int paramInt)
  {
    paramInt = FileManagerUtil.d(paramInt);
    if ((this.jdField_j_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_j_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_g_of_type_JavaLangString != null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)
    {
      localFileManagerEntity.Uuid = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i1;
    int i2;
    int i3;
    if (paramHttpMsg != null)
    {
      i1 = paramHttpMsg.jdField_d_of_type_Int;
      i2 = paramHttpMsg.e;
      i3 = paramHttpMsg.f;
      if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
      }
      if (!"POST".equals(paramHttpMsg.e())) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, i3, i1, i2, paramHttpMsg.jdField_i_of_type_Int);
      return;
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ArrayOfInt	[I
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: invokevirtual 794	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	()Z
    //   13: ifeq +55 -> 68
    //   16: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +45 -> 64
    //   22: ldc_w 525
    //   25: iconst_2
    //   26: new 223	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 796
    //   36: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   43: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   46: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 798
    //   55: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 6
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   73: if_acmpeq +307 -> 380
    //   76: aload_1
    //   77: ifnull +92 -> 169
    //   80: aload_0
    //   81: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   84: ifnull +85 -> 169
    //   87: ldc 17
    //   89: iconst_1
    //   90: new 223	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 800
    //   100: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   107: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 802
    //   116: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 804	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   123: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 806
    //   132: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   139: invokevirtual 804	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   142: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc -21
    //   150: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 6
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload 6
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +144 -> 314
    //   173: ldc 17
    //   175: iconst_1
    //   176: new 223	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 800
    //   186: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   193: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 802
    //   202: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 804	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   209: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc -21
    //   217: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -67 -> 159
    //   229: astore 4
    //   231: aload 4
    //   233: invokevirtual 807	java/lang/Exception:printStackTrace	()V
    //   236: ldc 17
    //   238: iconst_1
    //   239: aload 4
    //   241: invokevirtual 808	java/lang/Exception:toString	()Ljava/lang/String;
    //   244: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: ldc 111
    //   249: astore_3
    //   250: aload 4
    //   252: invokevirtual 812	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   255: astore 4
    //   257: aload 4
    //   259: arraylength
    //   260: istore 8
    //   262: iconst_0
    //   263: istore 7
    //   265: iload 7
    //   267: iload 8
    //   269: if_icmpge +1964 -> 2233
    //   272: aload 4
    //   274: iload 7
    //   276: aaload
    //   277: astore 5
    //   279: new 223	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   286: aload_3
    //   287: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 5
    //   292: invokevirtual 815	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: ldc_w 817
    //   298: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore_3
    //   305: iload 7
    //   307: iconst_1
    //   308: iadd
    //   309: istore 7
    //   311: goto -46 -> 265
    //   314: aload_0
    //   315: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   318: ifnull -159 -> 159
    //   321: ldc 17
    //   323: iconst_1
    //   324: new 223	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 800
    //   334: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_0
    //   338: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   341: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   344: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 819
    //   350: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   357: invokevirtual 804	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   360: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   363: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc -21
    //   368: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: goto -218 -> 159
    //   380: aload_0
    //   381: getfield 152	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Int	I
    //   384: ifne +1072 -> 1456
    //   387: aload_2
    //   388: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   391: sipush 200
    //   394: if_icmpne +866 -> 1260
    //   397: aload_0
    //   398: getfield 212	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   401: invokevirtual 822	com/tencent/wstt/SSCM/SSCM:b	()V
    //   404: aload_2
    //   405: ldc_w 824
    //   408: invokevirtual 825	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   411: ifnull +1999 -> 2410
    //   414: aload_2
    //   415: ldc_w 824
    //   418: invokevirtual 825	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   421: invokestatic 758	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   424: lstore 9
    //   426: lload 9
    //   428: lconst_0
    //   429: lcmp
    //   430: ifeq +110 -> 540
    //   433: aload_0
    //   434: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   437: aload_0
    //   438: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   441: aload_0
    //   442: getfield 94	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   445: aload_0
    //   446: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   449: aload_0
    //   450: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   453: aload_0
    //   454: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   457: aload_0
    //   458: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   461: aload_0
    //   462: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   465: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   468: ldc2_w 826
    //   471: ldc 111
    //   473: aload_0
    //   474: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   477: aload_0
    //   478: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   481: aload_0
    //   482: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   485: aload_2
    //   486: invokevirtual 828	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   489: aload_2
    //   490: getfield 831	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 502	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   497: new 223	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 833
    //   507: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: lload 9
    //   512: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   515: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc -21
    //   520: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: aconst_null
    //   527: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   530: aload_0
    //   531: aload_1
    //   532: aload_2
    //   533: invokevirtual 505	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   536: aload 6
    //   538: monitorexit
    //   539: return
    //   540: aload_2
    //   541: ldc_w 413
    //   544: invokevirtual 825	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   547: astore_3
    //   548: aload_3
    //   549: ifnull +1855 -> 2404
    //   552: aload_3
    //   553: invokestatic 758	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   556: lstore 9
    //   558: lload 9
    //   560: aload_0
    //   561: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   564: lcmp
    //   565: ifgt +364 -> 929
    //   568: new 223	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 835
    //   578: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: lload 9
    //   583: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   586: ldc_w 837
    //   589: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_0
    //   593: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   596: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: ldc_w 839
    //   602: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_0
    //   606: getfield 841	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   609: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   612: ldc_w 843
    //   615: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_0
    //   619: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   622: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   625: ldc -21
    //   627: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: astore_3
    //   634: lload 9
    //   636: aload_0
    //   637: getfield 841	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   640: lcmp
    //   641: ifgt +177 -> 818
    //   644: aload_0
    //   645: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   648: iconst_1
    //   649: iadd
    //   650: istore 7
    //   652: aload_0
    //   653: iload 7
    //   655: putfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   658: iload 7
    //   660: iconst_3
    //   661: if_icmple +157 -> 818
    //   664: aload_0
    //   665: sipush 1005
    //   668: invokevirtual 254	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   671: aload_0
    //   672: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   675: invokevirtual 451	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   678: aload_0
    //   679: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   682: aload_0
    //   683: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   686: aload_0
    //   687: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   690: aload_0
    //   691: getfield 142	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   694: bipush 15
    //   696: aconst_null
    //   697: iconst_5
    //   698: aconst_null
    //   699: invokevirtual 456	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   702: aload_0
    //   703: invokevirtual 845	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:c	()V
    //   706: aload_0
    //   707: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   710: aload_0
    //   711: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   714: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   717: aload_0
    //   718: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   721: aload_0
    //   722: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   725: aload_0
    //   726: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   729: aload_0
    //   730: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   733: aload_0
    //   734: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   737: aload_0
    //   738: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   741: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   744: ldc2_w 846
    //   747: ldc 111
    //   749: aload_0
    //   750: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   753: aload_0
    //   754: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   757: aload_0
    //   758: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   761: aload_0
    //   762: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   765: ldc 111
    //   767: aload_0
    //   768: getfield 308	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   771: aload_3
    //   772: aconst_null
    //   773: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   776: ldc 17
    //   778: iconst_1
    //   779: new 223	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 849
    //   789: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_0
    //   793: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   796: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: ldc -21
    //   801: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_3
    //   805: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 852	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: aload 6
    //   816: monitorexit
    //   817: return
    //   818: aload_0
    //   819: lload 9
    //   821: putfield 841	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   824: aload_0
    //   825: lload 9
    //   827: putfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   830: new 854	android/os/Handler
    //   833: dup
    //   834: invokespecial 855	android/os/Handler:<init>	()V
    //   837: new 857	rwx
    //   840: dup
    //   841: aload_0
    //   842: lload 9
    //   844: invokespecial 860	rwx:<init>	(Lcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker;J)V
    //   847: ldc2_w 861
    //   850: invokevirtual 866	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   853: pop
    //   854: aload_0
    //   855: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   858: aload_0
    //   859: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   862: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   865: aload_0
    //   866: getfield 94	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   869: aload_0
    //   870: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   873: aload_0
    //   874: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   877: aload_0
    //   878: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   881: aload_0
    //   882: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   885: aload_0
    //   886: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   889: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   892: ldc2_w 846
    //   895: ldc 111
    //   897: aload_0
    //   898: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   901: aload_0
    //   902: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   905: aload_0
    //   906: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   909: aload_0
    //   910: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   913: aload_2
    //   914: getfield 831	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   917: aload_0
    //   918: getfield 502	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   921: aload_3
    //   922: aconst_null
    //   923: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   926: goto -150 -> 776
    //   929: iconst_0
    //   930: istore 8
    //   932: iload 8
    //   934: istore 7
    //   936: aload_0
    //   937: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   940: lconst_0
    //   941: lcmp
    //   942: ifne +68 -> 1010
    //   945: iload 8
    //   947: istore 7
    //   949: lload 9
    //   951: aload_0
    //   952: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   955: lcmp
    //   956: ifne +54 -> 1010
    //   959: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +1454 -> 2416
    //   965: ldc_w 525
    //   968: iconst_2
    //   969: new 223	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   976: ldc_w 796
    //   979: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: aload_0
    //   983: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   986: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   989: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   992: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: ldc_w 868
    //   998: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1007: goto +1409 -> 2416
    //   1010: aload_0
    //   1011: lload 9
    //   1013: putfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1016: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1019: ifeq +77 -> 1096
    //   1022: ldc 17
    //   1024: iconst_2
    //   1025: new 223	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   1032: ldc -30
    //   1034: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_0
    //   1038: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1041: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1044: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc -21
    //   1049: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: ldc_w 523
    //   1055: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: aload_0
    //   1059: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1062: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1065: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: ldc_w 870
    //   1071: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1078: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1081: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 872
    //   1087: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1096: lload 9
    //   1098: aload_0
    //   1099: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1102: lcmp
    //   1103: ifge +161 -> 1264
    //   1106: aload_0
    //   1107: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1110: aload_0
    //   1111: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1114: l2f
    //   1115: aload_0
    //   1116: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1119: l2f
    //   1120: fdiv
    //   1121: putfield 210	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1124: aload_0
    //   1125: sipush 1002
    //   1128: invokevirtual 254	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1131: invokestatic 604	java/lang/System:currentTimeMillis	()J
    //   1134: lstore 9
    //   1136: lload 9
    //   1138: aload_0
    //   1139: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1142: lsub
    //   1143: ldc2_w 20
    //   1146: lcmp
    //   1147: iflt +96 -> 1243
    //   1150: aload_0
    //   1151: lload 9
    //   1153: putfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1156: aload_0
    //   1157: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1160: iconst_3
    //   1161: invokevirtual 680	com/tencent/mobileqq/filemanager/data/FileManagerEntity:setCloudType	(I)V
    //   1164: aload_0
    //   1165: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1168: invokevirtual 451	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1171: aload_0
    //   1172: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   1175: aload_0
    //   1176: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1179: aload_0
    //   1180: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1183: aload_0
    //   1184: getfield 142	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1187: bipush 16
    //   1189: aconst_null
    //   1190: iconst_0
    //   1191: aconst_null
    //   1192: invokevirtual 456	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1195: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1198: ifeq +45 -> 1243
    //   1201: ldc 17
    //   1203: iconst_2
    //   1204: new 223	java/lang/StringBuilder
    //   1207: dup
    //   1208: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   1211: ldc -30
    //   1213: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload_0
    //   1217: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1220: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1223: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: ldc -21
    //   1228: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: ldc_w 874
    //   1234: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1243: aload_0
    //   1244: iconst_0
    //   1245: putfield 308	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1248: aload_0
    //   1249: aload_0
    //   1250: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1253: aload_0
    //   1254: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1257: invokevirtual 877	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(Ljava/lang/String;J)V
    //   1260: aload 6
    //   1262: monitorexit
    //   1263: return
    //   1264: aload_0
    //   1265: invokestatic 604	java/lang/System:currentTimeMillis	()J
    //   1268: putfield 107	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_Long	J
    //   1271: aload_0
    //   1272: invokestatic 604	java/lang/System:currentTimeMillis	()J
    //   1275: putfield 84	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_h_of_type_Long	J
    //   1278: iload 7
    //   1280: ifne +63 -> 1343
    //   1283: aload_0
    //   1284: invokevirtual 879	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:j	()V
    //   1287: new 697	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData
    //   1290: dup
    //   1291: invokespecial 698	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:<init>	()V
    //   1294: astore_3
    //   1295: aload_3
    //   1296: ldc_w 881
    //   1299: putfield 701	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1302: aload_3
    //   1303: iconst_1
    //   1304: putfield 702	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_a_of_type_Int	I
    //   1307: aload_0
    //   1308: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1311: invokevirtual 703	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1314: aload_3
    //   1315: invokestatic 708	com/tencent/mobileqq/filemanager/util/FileManagerReporter:a	(Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData;)V
    //   1318: aload_0
    //   1319: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1322: iconst_1
    //   1323: putfield 198	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   1326: aload_0
    //   1327: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1330: invokevirtual 201	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   1333: aload_0
    //   1334: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1337: invokevirtual 206	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1340: goto -80 -> 1260
    //   1343: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1346: ifeq +45 -> 1391
    //   1349: ldc_w 525
    //   1352: iconst_2
    //   1353: new 223	java/lang/StringBuilder
    //   1356: dup
    //   1357: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   1360: ldc_w 796
    //   1363: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: aload_0
    //   1367: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1370: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1373: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1376: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: ldc_w 883
    //   1382: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1391: aload_0
    //   1392: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1395: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1398: invokestatic 885	com/tencent/mobileqq/filemanager/util/FileManagerUtil:b	(J)V
    //   1401: aload_0
    //   1402: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1405: invokevirtual 451	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1408: aload_0
    //   1409: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1412: iconst_5
    //   1413: aload_0
    //   1414: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1417: invokevirtual 888	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;ILjava/lang/String;)V
    //   1420: aload_0
    //   1421: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1424: invokevirtual 575	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1427: aload_0
    //   1428: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1431: aload_0
    //   1432: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1435: aload_0
    //   1436: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1439: aload_0
    //   1440: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1443: getfield 145	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   1446: aload_0
    //   1447: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1450: invokevirtual 891	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1453: goto -166 -> 1287
    //   1456: aload_2
    //   1457: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1460: sipush 206
    //   1463: if_icmpeq +17 -> 1480
    //   1466: aload_2
    //   1467: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1470: istore 7
    //   1472: iload 7
    //   1474: sipush 200
    //   1477: if_icmpne -217 -> 1260
    //   1480: aload_0
    //   1481: getfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1484: aload_2
    //   1485: invokevirtual 893	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1488: invokevirtual 898	java/io/OutputStream:write	([B)V
    //   1491: aload_0
    //   1492: iconst_0
    //   1493: putfield 308	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1496: aload_2
    //   1497: invokevirtual 893	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1500: arraylength
    //   1501: i2l
    //   1502: lstore 9
    //   1504: aload_0
    //   1505: aload_0
    //   1506: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1509: lload 9
    //   1511: ladd
    //   1512: putfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1515: aload_0
    //   1516: lload 9
    //   1518: aload_0
    //   1519: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1522: ladd
    //   1523: putfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1526: aload_0
    //   1527: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1530: lstore 9
    //   1532: aload_2
    //   1533: invokevirtual 900	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()J
    //   1536: lstore 9
    //   1538: aload_0
    //   1539: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1542: lload 9
    //   1544: lcmp
    //   1545: iflt +578 -> 2123
    //   1548: aload_0
    //   1549: getfield 142	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1552: sipush 3000
    //   1555: if_icmpeq +35 -> 1590
    //   1558: aload_0
    //   1559: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1562: getfield 764	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   1565: ifne +25 -> 1590
    //   1568: aload_0
    //   1569: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1572: invokevirtual 575	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1575: aload_0
    //   1576: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1579: aload_0
    //   1580: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1583: aload_0
    //   1584: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1587: invokevirtual 903	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1590: aload_0
    //   1591: aconst_null
    //   1592: putfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1595: aload_0
    //   1596: getfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1599: invokevirtual 906	java/io/OutputStream:close	()V
    //   1602: aload_0
    //   1603: aconst_null
    //   1604: putfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1607: aload_0
    //   1608: invokespecial 753	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	()V
    //   1611: goto -351 -> 1260
    //   1614: astore_3
    //   1615: aload_3
    //   1616: invokevirtual 909	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1619: ldc_w 911
    //   1622: invokevirtual 915	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1625: ifeq +126 -> 1751
    //   1628: aload_0
    //   1629: monitorenter
    //   1630: aload_0
    //   1631: iconst_1
    //   1632: putfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Boolean	Z
    //   1635: aload_0
    //   1636: monitorexit
    //   1637: aload_0
    //   1638: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1641: ifnull +83 -> 1724
    //   1644: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1647: ifeq +63 -> 1710
    //   1650: ldc 17
    //   1652: iconst_2
    //   1653: new 223	java/lang/StringBuilder
    //   1656: dup
    //   1657: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   1660: ldc -30
    //   1662: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: aload_0
    //   1666: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1669: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1672: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: ldc -21
    //   1677: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: ldc_w 917
    //   1683: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: aload_0
    //   1687: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1690: invokevirtual 804	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   1693: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1696: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: ldc -21
    //   1701: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1707: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1710: aload_0
    //   1711: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1714: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   1717: aload_0
    //   1718: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1721: invokevirtual 919	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   1724: aload_0
    //   1725: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1728: invokevirtual 347	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerRSCenter;
    //   1731: iconst_0
    //   1732: invokevirtual 352	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(Z)V
    //   1735: aload_0
    //   1736: aload_0
    //   1737: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1740: new 921	rwy
    //   1743: dup
    //   1744: aload_0
    //   1745: invokespecial 922	rwy:<init>	(Lcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker;)V
    //   1748: invokespecial 476	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(JLcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker$ChangeNewPath;)V
    //   1751: aload_0
    //   1752: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1755: aload_0
    //   1756: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1759: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1762: aload_0
    //   1763: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1766: aload_0
    //   1767: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1770: aload_0
    //   1771: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1774: aload_0
    //   1775: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1778: aload_0
    //   1779: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1782: aload_0
    //   1783: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1786: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1789: ldc2_w 492
    //   1792: ldc 111
    //   1794: aload_0
    //   1795: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1798: aload_0
    //   1799: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1802: aload_0
    //   1803: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1806: aload_0
    //   1807: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1810: ldc 111
    //   1812: aload_0
    //   1813: getfield 308	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1816: ldc_w 924
    //   1819: aconst_null
    //   1820: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1823: aload_0
    //   1824: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1827: aload_0
    //   1828: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1831: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1834: aload_0
    //   1835: getfield 94	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1838: aload_0
    //   1839: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1842: aload_0
    //   1843: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1846: aload_0
    //   1847: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1850: aload_0
    //   1851: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1854: aload_0
    //   1855: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1858: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1861: ldc2_w 492
    //   1864: ldc 111
    //   1866: aload_0
    //   1867: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1870: aload_0
    //   1871: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1874: aload_0
    //   1875: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1878: aload_0
    //   1879: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1882: ldc 111
    //   1884: aload_0
    //   1885: getfield 502	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   1888: ldc_w 924
    //   1891: aconst_null
    //   1892: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1895: aload_0
    //   1896: aconst_null
    //   1897: aconst_null
    //   1898: invokevirtual 505	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   1901: aload 6
    //   1903: monitorexit
    //   1904: return
    //   1905: astore_3
    //   1906: aload_0
    //   1907: monitorexit
    //   1908: aload_3
    //   1909: athrow
    //   1910: astore_3
    //   1911: aload_0
    //   1912: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1915: aload_0
    //   1916: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1919: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1922: aload_0
    //   1923: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1926: aload_0
    //   1927: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1930: aload_0
    //   1931: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1934: aload_0
    //   1935: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1938: aload_0
    //   1939: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1942: aload_0
    //   1943: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1946: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1949: ldc2_w 492
    //   1952: ldc 111
    //   1954: aload_0
    //   1955: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1958: aload_0
    //   1959: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1962: aload_0
    //   1963: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1966: aload_0
    //   1967: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1970: ldc 111
    //   1972: aload_0
    //   1973: getfield 308	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1976: ldc_w 924
    //   1979: aconst_null
    //   1980: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1983: aload_0
    //   1984: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1987: aload_0
    //   1988: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1991: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1994: aload_0
    //   1995: getfield 94	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1998: aload_0
    //   1999: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2002: aload_0
    //   2003: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2006: aload_0
    //   2007: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2010: aload_0
    //   2011: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2014: aload_0
    //   2015: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2018: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2021: ldc2_w 492
    //   2024: ldc 111
    //   2026: aload_0
    //   2027: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2030: aload_0
    //   2031: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2034: aload_0
    //   2035: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2038: aload_0
    //   2039: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2042: ldc 111
    //   2044: aload_0
    //   2045: getfield 502	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2048: ldc_w 924
    //   2051: aconst_null
    //   2052: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2055: aload_0
    //   2056: aconst_null
    //   2057: aconst_null
    //   2058: invokevirtual 505	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2061: aload 6
    //   2063: monitorexit
    //   2064: return
    //   2065: astore_3
    //   2066: ldc_w 926
    //   2069: iconst_1
    //   2070: new 223	java/lang/StringBuilder
    //   2073: dup
    //   2074: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   2077: ldc -30
    //   2079: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload_0
    //   2083: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   2086: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2089: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: ldc -21
    //   2094: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: ldc_w 928
    //   2100: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: aload_3
    //   2104: invokevirtual 929	java/io/IOException:toString	()Ljava/lang/String;
    //   2107: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2113: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2116: aload_3
    //   2117: invokevirtual 930	java/io/IOException:printStackTrace	()V
    //   2120: goto -518 -> 1602
    //   2123: aload_0
    //   2124: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2127: aload_0
    //   2128: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2131: l2f
    //   2132: aload_0
    //   2133: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2136: l2f
    //   2137: fdiv
    //   2138: putfield 210	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   2141: aload_0
    //   2142: sipush 2002
    //   2145: invokevirtual 254	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   2148: invokestatic 604	java/lang/System:currentTimeMillis	()J
    //   2151: lstore 9
    //   2153: aload_0
    //   2154: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   2157: lstore 11
    //   2159: lload 9
    //   2161: lload 11
    //   2163: lsub
    //   2164: ldc2_w 20
    //   2167: lcmp
    //   2168: ifge +7 -> 2175
    //   2171: aload 6
    //   2173: monitorexit
    //   2174: return
    //   2175: aload_0
    //   2176: lload 9
    //   2178: putfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   2181: aload_0
    //   2182: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2185: aload_0
    //   2186: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2189: l2f
    //   2190: aload_0
    //   2191: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2194: l2f
    //   2195: fdiv
    //   2196: putfield 210	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   2199: aload_0
    //   2200: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2203: invokevirtual 451	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   2206: aload_0
    //   2207: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   2210: aload_0
    //   2211: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   2214: aload_0
    //   2215: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2218: aload_0
    //   2219: getfield 142	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   2222: bipush 16
    //   2224: aconst_null
    //   2225: iconst_0
    //   2226: aconst_null
    //   2227: invokevirtual 456	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   2230: goto -970 -> 1260
    //   2233: ldc 111
    //   2235: astore 4
    //   2237: ldc 111
    //   2239: astore 5
    //   2241: aload_1
    //   2242: ifnull +9 -> 2251
    //   2245: aload_1
    //   2246: invokevirtual 828	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   2249: astore 4
    //   2251: aload 5
    //   2253: astore_1
    //   2254: aload_2
    //   2255: ifnull +8 -> 2263
    //   2258: aload_2
    //   2259: getfield 831	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   2262: astore_1
    //   2263: aload_0
    //   2264: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2267: aload_0
    //   2268: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2271: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2274: aload_0
    //   2275: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   2278: aload_0
    //   2279: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2282: aload_0
    //   2283: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2286: aload_0
    //   2287: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2290: aload_0
    //   2291: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2294: aload_0
    //   2295: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2298: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2301: ldc2_w 931
    //   2304: aconst_null
    //   2305: aload_0
    //   2306: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2309: aload_0
    //   2310: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2313: aload_0
    //   2314: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2317: aload 4
    //   2319: aload_1
    //   2320: aload_0
    //   2321: getfield 502	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2324: aload_3
    //   2325: aconst_null
    //   2326: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2329: aload_0
    //   2330: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2333: aload_0
    //   2334: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2337: getfield 195	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2340: aload_0
    //   2341: getfield 94	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2344: aload_0
    //   2345: getfield 82	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2348: aload_0
    //   2349: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2352: aload_0
    //   2353: getfield 162	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2356: aload_0
    //   2357: getfield 147	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2360: aload_0
    //   2361: getfield 169	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2364: getfield 491	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2367: ldc2_w 931
    //   2370: aconst_null
    //   2371: aload_0
    //   2372: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2375: aload_0
    //   2376: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2379: aload_0
    //   2380: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2383: aload 4
    //   2385: aload_1
    //   2386: aload_0
    //   2387: getfield 502	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2390: aload_3
    //   2391: aconst_null
    //   2392: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2395: aload_0
    //   2396: aconst_null
    //   2397: aconst_null
    //   2398: invokevirtual 505	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2401: goto -1141 -> 1260
    //   2404: lconst_0
    //   2405: lstore 9
    //   2407: goto -1849 -> 558
    //   2410: lconst_0
    //   2411: lstore 9
    //   2413: goto -1987 -> 426
    //   2416: iconst_1
    //   2417: istore 7
    //   2419: goto -1409 -> 1010
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2422	0	this	FileManagerRSWorker
    //   0	2422	1	paramHttpMsg1	HttpMsg
    //   0	2422	2	paramHttpMsg2	HttpMsg
    //   249	1066	3	localObject1	Object
    //   1614	2	3	localException1	Exception
    //   1905	4	3	localObject2	Object
    //   1910	1	3	localException2	Exception
    //   2065	326	3	localIOException	java.io.IOException
    //   229	22	4	localException3	Exception
    //   255	2129	4	localObject3	Object
    //   277	1975	5	localObject4	Object
    //   4	2168	6	arrayOfInt	int[]
    //   263	2155	7	i1	int
    //   260	686	8	i2	int
    //   424	1988	9	l1	long
    //   2157	5	11	l2	long
    // Exception table:
    //   from	to	target	type
    //   9	64	163	finally
    //   64	67	163	finally
    //   68	76	163	finally
    //   80	159	163	finally
    //   159	162	163	finally
    //   164	167	163	finally
    //   173	226	163	finally
    //   231	247	163	finally
    //   250	262	163	finally
    //   279	305	163	finally
    //   314	377	163	finally
    //   380	426	163	finally
    //   433	536	163	finally
    //   536	539	163	finally
    //   540	548	163	finally
    //   552	558	163	finally
    //   558	658	163	finally
    //   664	776	163	finally
    //   776	814	163	finally
    //   814	817	163	finally
    //   818	926	163	finally
    //   936	945	163	finally
    //   949	1007	163	finally
    //   1010	1096	163	finally
    //   1096	1243	163	finally
    //   1243	1260	163	finally
    //   1260	1263	163	finally
    //   1264	1278	163	finally
    //   1283	1287	163	finally
    //   1287	1340	163	finally
    //   1343	1391	163	finally
    //   1391	1453	163	finally
    //   1456	1472	163	finally
    //   1480	1491	163	finally
    //   1491	1590	163	finally
    //   1590	1595	163	finally
    //   1595	1602	163	finally
    //   1602	1611	163	finally
    //   1615	1630	163	finally
    //   1637	1710	163	finally
    //   1710	1724	163	finally
    //   1724	1735	163	finally
    //   1735	1751	163	finally
    //   1751	1901	163	finally
    //   1901	1904	163	finally
    //   1908	1910	163	finally
    //   1911	2061	163	finally
    //   2061	2064	163	finally
    //   2066	2120	163	finally
    //   2123	2159	163	finally
    //   2171	2174	163	finally
    //   2175	2230	163	finally
    //   2245	2251	163	finally
    //   2258	2263	163	finally
    //   2263	2401	163	finally
    //   9	64	229	java/lang/Exception
    //   68	76	229	java/lang/Exception
    //   80	159	229	java/lang/Exception
    //   173	226	229	java/lang/Exception
    //   314	377	229	java/lang/Exception
    //   380	426	229	java/lang/Exception
    //   433	536	229	java/lang/Exception
    //   540	548	229	java/lang/Exception
    //   552	558	229	java/lang/Exception
    //   558	658	229	java/lang/Exception
    //   664	776	229	java/lang/Exception
    //   776	814	229	java/lang/Exception
    //   818	926	229	java/lang/Exception
    //   936	945	229	java/lang/Exception
    //   949	1007	229	java/lang/Exception
    //   1010	1096	229	java/lang/Exception
    //   1096	1243	229	java/lang/Exception
    //   1243	1260	229	java/lang/Exception
    //   1264	1278	229	java/lang/Exception
    //   1283	1287	229	java/lang/Exception
    //   1287	1340	229	java/lang/Exception
    //   1343	1391	229	java/lang/Exception
    //   1391	1453	229	java/lang/Exception
    //   1456	1472	229	java/lang/Exception
    //   1491	1590	229	java/lang/Exception
    //   1590	1595	229	java/lang/Exception
    //   1595	1602	229	java/lang/Exception
    //   1602	1611	229	java/lang/Exception
    //   1615	1630	229	java/lang/Exception
    //   1637	1710	229	java/lang/Exception
    //   1710	1724	229	java/lang/Exception
    //   1724	1735	229	java/lang/Exception
    //   1751	1901	229	java/lang/Exception
    //   1908	1910	229	java/lang/Exception
    //   1911	2061	229	java/lang/Exception
    //   2066	2120	229	java/lang/Exception
    //   2123	2159	229	java/lang/Exception
    //   2175	2230	229	java/lang/Exception
    //   1480	1491	1614	java/lang/Exception
    //   1630	1637	1905	finally
    //   1906	1908	1905	finally
    //   1735	1751	1910	java/lang/Exception
    //   1595	1602	2065	java/io/IOException
  }
  
  public void a(Object paramObject)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int i1;
    Object localObject;
    switch (this.jdField_b_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          break;
        }
        i1 = 0;
        ((FileManagerEntity)paramObject).status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localHttpMsg == null);
      int i2 = localHttpMsg.jdField_h_of_type_Int;
      localObject = localHttpMsg.d();
      i1 = i2;
      paramObject = localObject;
      if (i2 == 0)
      {
        i1 = i2;
        paramObject = localObject;
        if (localObject == null)
        {
          i1 = 9001;
          paramObject = "[Http_RespValue_Null]" + FileManagerUtil.a();
        }
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + i1 + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        i1 = 9042;
      }
      break;
    }
    for (;;)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(localHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.b(), localHttpMsg.al, this.jdField_i_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      i1 = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        ((FileManagerEntity)paramObject).status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        ((FileManagerEntity)paramObject).status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        ((FileManagerEntity)paramObject).status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        ((FileManagerEntity)paramObject).status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9062L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b(), this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.al, this.jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d() + "&UrlOver", null);
    a(null);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (a()) {
      return;
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    int i2 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1048576);
    int i3 = Utils.a(BaseApplication.getContext());
    int i1;
    if (i3 != 1)
    {
      i1 = i2;
      if (i3 != 2) {}
    }
    else
    {
      i1 = i2;
      if (i2 > 16384) {
        i1 = 16384;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendFilePakage transferedSize[" + paramLong + "], packetSize[" + i1 + "]");
    a(paramString, paramLong, i1);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (a()) {
      return;
    }
    int i1;
    if (paramLong == 0L)
    {
      FMConstants.af = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, FMConstants.ad);
      if (this.jdField_d_of_type_Long < FMConstants.af) {}
      for (l1 = this.jdField_d_of_type_Long;; l1 = FMConstants.af)
      {
        i1 = (int)l1;
        this.jdField_a_of_type_Long = 0L;
        i1 = Math.min(i1, 1048576);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong + "], size[" + i1 + "]");
        }
        a(paramString, paramLong, i1, paramArrayOfByte);
        return;
      }
    }
    FMConstants.ad = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, FMConstants.ad);
    this.jdField_e_of_type_Long = FMConstants.ad;
    if (this.jdField_d_of_type_Long < this.jdField_e_of_type_Long + paramLong) {}
    for (long l1 = this.jdField_d_of_type_Long - paramLong;; l1 = this.jdField_e_of_type_Long)
    {
      int i2 = (int)l1;
      int i3 = Utils.a(BaseApplication.getContext());
      if (i3 != 1)
      {
        i1 = i2;
        if (i3 != 2) {
          break;
        }
      }
      i1 = i2;
      if (i2 <= 16384) {
        break;
      }
      i1 = 16384;
      break;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed." + " recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_i_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      k();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1011	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 137	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 1012	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1011	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 137	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 1012	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   67: iload_3
    //   68: newarray <illegal type>
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1018	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1019	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1019	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   144: lsub
    //   145: invokevirtual 1023	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 930	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1011	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 137	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 1012	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   190: aload_0
    //   191: getfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1023	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 930	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FileManagerRSWorker
    //   0	224	1	paramLong	long
    //   0	224	3	paramInt	int
    //   70	26	4	arrayOfByte	byte[]
    //   98	8	4	localFileNotFoundException1	FileNotFoundException
    //   112	8	4	localFileNotFoundException2	FileNotFoundException
    //   152	3	4	localIOException1	java.io.IOException
    //   202	8	4	localIOException2	java.io.IOException
    //   216	1	4	localException	Exception
    //   219	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	98	java/io/FileNotFoundException
    //   42	62	112	java/io/FileNotFoundException
    //   135	149	152	java/io/IOException
    //   170	199	202	java/io/IOException
    //   72	95	216	java/lang/Exception
  }
  
  public int b()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath dir: " + (String)localObject);
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.c();
      localObject = new File(this.jdField_c_of_type_JavaLangString);
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        bool1 = ((File)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getTmpDir[" + bool1 + "]");
      }
      return this.jdField_c_of_type_JavaLangString;
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],ReceiveOfflineForOldMsg");
    if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get old offlinefile info is error! serverPath is empty");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        i1 = 9080;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "errserverPathForOldMsg", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "errServerPathForOldMsg", null);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          i1 = 9081;
        } else {
          i1 = 9020;
        }
      }
    }
    if (-1L != this.jdField_b_of_type_Long) {}
    Object localObject;
    for (MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_e_of_type_JavaLangString, 0, this.jdField_b_of_type_Long);; localObject = null)
    {
      if (localMessageRecord != null)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        TransFileInfo localTransFileInfo = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_JavaLangString });
        localEntityManager.a();
        if ((localTransFileInfo != null) && (2008 == localTransFileInfo.status)) {
          this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
        }
      }
      if ((localMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + ".tmp");
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        if (a()) {
          break;
        }
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
        return;
      }
      this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        a(2003);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
        }
        FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
        return;
      }
      if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
      {
        long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
        if (SystemUtil.a()) {}
        for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
          a(2005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "sdcard full", null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "sdcard full", null);
          return;
        }
      }
      if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 2002);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        a(this.jdField_a_of_type_Long, null);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;) {}
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    String str1 = null;
    if (paramHttpMsg2 != null) {
      str1 = paramHttpMsg2.d();
    }
    if (str1 == null) {
      str1 = "null";
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "transferedSize[" + this.jdField_a_of_type_Long + "]" + "isStop[" + String.valueOf(a()) + "],  " + "status[" + String.valueOf(this.jdField_j_of_type_Int) + "], " + "strErrString[" + str1 + "], " + "autoRetry[" + String.valueOf(this.jdField_g_of_type_Int) + "]");
      if ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)) {}
      do
      {
        return;
        if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
        {
          c();
          a(null);
          return;
        }
      } while ((!NetworkUtil.e(BaseApplication.getContext())) && ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)));
      int i2 = paramHttpMsg2.jdField_h_of_type_Int;
      if (FileHttpUtils.a(paramHttpMsg2.jdField_h_of_type_Int))
      {
        this.jdField_i_of_type_Int += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor == null) {
          break label1153;
        }
      }
      label663:
      label800:
      label1145:
      label1153:
      for (String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();; str2 = null)
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str2 + "]errCode[" + i2 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i2, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_i_of_type_Int, paramHttpMsg2.d() + "&goChangeUrl", null);
        long l1;
        if ((str2 == null) || (str2.length() == 0))
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i2 + "]");
          l1 = this.jdField_g_of_type_Long;
          if (str1.indexOf("-29602") <= 0) {
            break label663;
          }
          paramHttpMsg2.jdField_h_of_type_Int = 35934;
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, '豞', String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_i_of_type_Int, paramHttpMsg2.d(), null);
        }
        do
        {
          for (;;)
          {
            this.jdField_g_of_type_Int = 0;
            c();
            a(paramHttpMsg2);
            return;
            b(str2);
            return;
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i2 + "]");
            break;
            if (a(paramHttpMsg1, paramHttpMsg2))
            {
              if (str1.indexOf("-29120") > 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
                this.jdField_f_of_type_JavaLangString = "";
              }
              if (str1.indexOf("-6101") <= 0) {
                break label800;
              }
              FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, '⍒', String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_i_of_type_Int, paramHttpMsg2.d(), null);
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "handleError-----------retryTime:" + this.jdField_g_of_type_Int);
          }
        } while (this.jdField_g_of_type_Int >= 8);
        this.jdField_g_of_type_Int += 1;
        this.jdField_i_of_type_Int += 1;
        if ((this.jdField_h_of_type_Int < 3) && (i2 == 9056))
        {
          this.jdField_h_of_type_Int += 1;
          this.jdField_g_of_type_Int -= 1;
          if (i2 != 9056) {
            break label1145;
          }
        }
        for (int i1 = 0;; i1 = 6000)
        {
          new Handler().postDelayed(new rwz(this), i1);
          QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + i1 + "] time retry!");
          if (9048 == i2) {
            i2 = 11202;
          }
          for (;;)
          {
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, l1, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i2, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_i_of_type_Int, "delayTimes[" + i1 + "]" + paramHttpMsg2.d(), null);
            return;
            this.jdField_h_of_type_Int = 0;
            break;
          }
        }
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int += 1;
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_d_of_type_Int += 1;
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, null);
  }
  
  public boolean b()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 13, null, 0, null);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 1002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], strFilePath is null");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      b(null, null);
      return false;
    }
    Object localObject;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (localObject != null)
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], entify" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        }
        this.jdField_e_of_type_Long = FMConstants.ad;
        this.jdField_i_of_type_Long = 0L;
        a(this.jdField_f_of_type_JavaLangString, 0L);
        return true;
      }
    }
    this.jdField_a_of_type_ArrayOfByte = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      a(0);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_d_of_type_Long <= 0L) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Long * 100L / this.jdField_d_of_type_Long);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1225	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   13: invokestatic 1227	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;)Z
    //   16: pop
    //   17: aload_0
    //   18: getfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   21: invokevirtual 1228	java/io/InputStream:close	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   29: aload_0
    //   30: getfield 88	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder	Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 88	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder	Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder;
    //   40: invokevirtual 1229	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:a	()V
    //   43: aload_0
    //   44: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   47: ifnull +83 -> 130
    //   50: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +63 -> 116
    //   56: ldc 17
    //   58: iconst_2
    //   59: new 223	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   66: ldc -30
    //   68: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   75: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   78: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc -21
    //   83: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 917
    //   89: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   96: invokevirtual 804	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   99: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   102: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc -21
    //   107: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: getfield 171	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   120: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   123: aload_0
    //   124: getfield 448	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   127: invokevirtual 919	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   130: aload_0
    //   131: getfield 117	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task	Lcom/weiyun/sdk/IWyTaskManager$Task;
    //   134: ifnull +56 -> 190
    //   137: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +40 -> 180
    //   143: ldc 17
    //   145: iconst_2
    //   146: new 223	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   153: ldc -30
    //   155: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   162: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   165: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 1231
    //   171: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_0
    //   181: getfield 117	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task	Lcom/weiyun/sdk/IWyTaskManager$Task;
    //   184: invokeinterface 1236 1 0
    //   189: pop
    //   190: return
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: goto -168 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	FileManagerRSWorker
    //   191	4	1	localObject	Object
    //   196	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	191	finally
    //   192	194	191	finally
    //   17	29	196	java/lang/Exception
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d()
  {
    c();
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      a(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void f()
  {
    c();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is Successed, return!");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Int == 0) {
        a(1004);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "stop for pause!");
        }
        long l1 = System.currentTimeMillis();
        String str = "Now[" + String.valueOf(l1) + "]startTime[" + String.valueOf(this.jdField_g_of_type_Long) + "]notifyTime[" + String.valueOf(this.jdField_f_of_type_Long) + "]C2CTime[" + String.valueOf(this.jdField_j_of_type_Long) + "]";
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, str, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, str, null);
        return;
        if (1 == this.jdField_b_of_type_Int) {
          a(2004);
        } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)) {
          this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
        } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)) {
          this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
        }
      }
    }
  }
  
  protected void finalize()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      c();
      super.finalize();
      return;
      this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
    }
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRunnable = new rxa(this);
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        l();
      }
      return;
    }
    finally {}
  }
  
  public void h()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (SystemUtil.a()) {}
    for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime, null);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + "] modifytime[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new rxb(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  public void i()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new rxc(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  public void j()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(1003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "uuid is null Entity[" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\FileManagerRSWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */