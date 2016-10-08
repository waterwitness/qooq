import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class rwu
  extends FileTransferObserver
{
  final int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  
  public rwu(FileManagerRSWorker paramFileManagerRSWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 1000;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.j();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]" + "Notify UI Progress! and send continue!");
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramLong2) + "] SendCC [" + String.valueOf(paramBoolean) + "],retCode[" + String.valueOf(paramLong1) + "]");
    if (!paramBoolean)
    {
      if (paramLong1 == -100001L) {}
      for (long l = 9043L;; l = 90460L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(1005);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, paramLong2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 15, null, 5, null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c();
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]" + "OnSendCCReplay Faild! !");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "sendCCFaild", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "sendCCFaild", null);
        return;
      }
    }
    if (paramLong1 == 58L)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ServerMasking", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ServerMasking", null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(1005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, paramLong2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 15, null, 5, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]" + "OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      return;
    }
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Int > 0) {
      str = "ChanedUrlCount[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Int + "]";
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), str);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), str);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, ByteStringMicro paramByteStringMicro, String paramString2, short paramShort, String paramString3, List paramList, int paramInt, String paramString4, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a()) {
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "server ret error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "server ret error", null);
        return;
      }
    }
    if (paramString4 != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, paramString4);
    }
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    Object localObject2 = null;
    paramList = (List)localObject2;
    if (paramString2 != null)
    {
      paramList = (List)localObject2;
      if (paramByteStringMicro != null)
      {
        paramList = paramString2 + ":" + paramShort;
        if (FMConfig.b)
        {
          ((List)localObject1).clear();
          paramList = "113.108.29.146" + paramShort;
        }
        ((List)localObject1).add(0, paramList);
        FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1, paramString3));
        paramList = FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker).a();
      }
    }
    if (paramList == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] get offlinefile info Url is null, IP is null too");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2005);
      if ((paramLong1 == -6101L) || (paramLong1 == -7003L)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == 0L) {
        paramLong1 = 9048L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ip url error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ip url error", null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f = paramList;
    FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]");
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if (-1L != this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long);
    }
    paramList = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_JavaLangString + paramList);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "net", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "net", null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2003);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 11, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
      }
      FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString), new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a() < l)
      {
        paramList = new ArrayList();
        paramList.addAll((Collection)localObject1);
        FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, l, new rwv(this, paramBoolean, paramLong1, paramString1, paramByteStringMicro, paramString2, paramShort, paramString3, paramList, paramInt, paramString4, paramLong2));
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString, true);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, 2002);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, null);
      return;
    }
    catch (FileNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a()) {
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ret error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ret error", null);
        return;
      }
    }
    String str2 = null;
    String str1 = str2;
    if (paramString3 != null)
    {
      str1 = str2;
      if (paramString4 != null)
      {
        str1 = paramString3 + ":" + paramInt1;
        str2 = FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, paramString4);
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str1);
        FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, str2));
        str1 = FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker).a();
      }
    }
    if (str1 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] get DiscdownLoad info Url is null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == 0L) {
        paramLong1 = 9048L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt2), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ip url error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt2), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "ip url error", null);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f = str1;
    FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f) + "]");
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "]renamed[" + String.valueOf(paramString2) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_JavaLangString + "dsc-" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 1, null, 2, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "], NetWork Error, notify UI!");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "net", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "net", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(2003);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 11, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
      }
      FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString), new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_JavaLangString);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "], fileExisted, notify UI!");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a() < l)
      {
        FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, l, new rww(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2));
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_JavaLangString, true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, 2002);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      for (paramString1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString; paramString1.length() < 10; paramString1 = "0" + paramString1) {}
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_JavaLangString = ("FTN5K=" + paramString5);
      FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_JavaLangString);
      return;
    }
    catch (FileNotFoundException paramString1)
    {
      for (;;) {}
    }
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "]" + "wk,onUpdateSetOfflineFileState-->failed");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(1005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      if (paramFileUploadInfo.jdField_a_of_type_Int == -100001) {}
      for (int i = 9043;; i = 9045)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_b_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "setSuccFaild", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_b_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "setSuccFaild", null);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "]" + "onUpdateSetOfflineFileState success, send CC!");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker));
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "]" + "onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long = 0L;
    int i;
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "]" + "wk,onUpdateSendOfflineFile-->failed");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(1005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      if (paramFileUploadInfo.jdField_a_of_type_Int == -100001) {}
      for (i = 9043;; i = 9045)
      {
        paramList = "server retError";
        if (paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) {
          paramList = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
        }
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_b_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), paramList, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_b_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), paramList, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "]" + "wk,handleSendOfflineFileResp");
    }
    if ((paramFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (paramFileUploadInfo.jdField_b_of_type_JavaLangString.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(1005);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "]" + "ResultCodeNoServerAddr ip = 0");
      if (paramFileUploadInfo.jdField_a_of_type_Int == 0) {}
      for (i = 9048;; i = paramFileUploadInfo.jdField_a_of_type_Int)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_b_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "onUpSend ip url error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_b_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "", FileManagerRSWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker), "onUpSend ip url error", null);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
    if ((paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) && (paramFileUploadInfo.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "], retMsg:" + paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Int, 4, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
    }
    if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = new byte[this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ArrayOfByte.length + 4];
      PkgTools.a((byte[])localObject, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ArrayOfByte.length);
      PkgTools.a((byte[])localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ArrayOfByte.length, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long);
      if ((paramFileUploadInfo.jdField_a_of_type_Boolean != true) || (paramFileUploadInfo.jdField_c_of_type_Long > 104857600L)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker));
      paramFileUploadInfo = new FileManagerReporter.fileAssistantReportData();
      paramFileUploadInfo.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramFileUploadInfo.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFileUploadInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
    paramStatictisInfo = HexUtil.bytes2HexStr(paramFileUploadInfo.jdField_b_of_type_ArrayOfByte);
    Object localObject = HexUtil.bytes2HexStr((byte[])localObject).toLowerCase(Locale.US);
    if (paramList == null)
    {
      paramList = new ArrayList();
      paramList.add(paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
      if (FMConfig.b)
      {
        paramList.clear();
        paramList.add(0, "14.17.29.27:" + paramFileUploadInfo.jdField_a_of_type_Short);
      }
      if (paramFileUploadInfo.jdField_d_of_type_Int != 2) {
        break label2200;
      }
    }
    label2200:
    for (paramStatictisInfo = "/ftn_handler";; paramStatictisInfo = FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, paramStatictisInfo, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long))
    {
      FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramStatictisInfo));
      FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, paramFileUploadInfo);
      FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      if ((!paramFileUploadInfo.jdField_a_of_type_Boolean) || (paramFileUploadInfo.jdField_d_of_type_Int != 1)) {
        break label2221;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "], onUpdateSendOfflineFile: file Exist");
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_c_of_type_Long + "], FileSize[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long + "], Uuid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "CS秒传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker));
      paramFileUploadInfo = new FileManagerReporter.fileAssistantReportData();
      paramFileUploadInfo.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramFileUploadInfo.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFileUploadInfo);
      return;
      paramList.add(0, paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
      break;
    }
    label2221:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_Long = paramFileUploadInfo.jdField_b_of_type_Int;
    if (paramFileUploadInfo.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, 0L, paramFileUploadInfo.jdField_b_of_type_ArrayOfByte);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f, 0L);
  }
  
  protected void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    super.b(paramBoolean, paramFileUploadInfo, paramStatictisInfo);
    if ((paramBoolean) && ((paramFileUploadInfo.jdField_c_of_type_Int == 2) || (paramFileUploadInfo.jdField_c_of_type_Int == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.jdField_c_of_type_Int + "]. need to send file receipt");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.jdField_c_of_type_Int + "]. don't need to send file receipt");
  }
  
  protected void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if ((paramFileUploadInfo.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.c();
      if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte == null) || (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label272;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.f);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, FileManagerRSWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker));
      paramFileUploadInfo = new FileManagerReporter.fileAssistantReportData();
      paramFileUploadInfo.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramFileUploadInfo.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFileUploadInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      label272:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */