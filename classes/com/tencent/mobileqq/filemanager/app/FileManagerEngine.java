package com.tencent.mobileqq.filemanager.app;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader;
import com.tencent.mobileqq.filemanager.core.DiscVideoThumbDownloader;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants.revertMsgCallback;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import mqq.app.MobileQQ;
import rvr;
import rvs;

public class FileManagerEngine
{
  private static final int jdField_a_of_type_Int = 38;
  private static final String jdField_a_of_type_JavaLangString = "FileManagerEngine<FileAssistant>";
  private static final int b = 3;
  private static final int c = 106;
  public QQAppInterface a;
  private DiscPicThumbDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader;
  private DiscVideoThumbDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader;
  private OfflineVideoThumbDownLoader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader;
  private ThumbHttpDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader;
  WeiYunLogicCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter;
  rvs jdField_a_of_type_Rvs;
  
  public FileManagerEngine(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Rvs = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter == null) {
      a();
    }
    FileManagerUtil.a();
    if (this.jdField_a_of_type_Rvs == null) {
      this.jdField_a_of_type_Rvs = new rvs(this, null);
    }
    try
    {
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("android.intent.action.MEDIA_MOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_EJECT");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_REMOVED");
      paramQQAppInterface.addDataScheme("file");
      BaseApplicationImpl.a.registerReceiver(this.jdField_a_of_type_Rvs, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    if (paramLong < 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "uniseq is wrong!can't retry!uniseq[" + String.valueOf(paramLong) + "]");
      }
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  private void b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      }
    }
    do
    {
      do
      {
        return;
        switch (localFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow operation type!");
      return;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.setCloudType(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
      a(localFileManagerEntity);
      return;
      c(localFileManagerEntity);
      return;
      a(localFileManagerEntity, localFileManagerEntity.nOpType);
      return;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        if (localFileManagerEntity.bDelInFM == true)
        {
          localFileManagerEntity.bDelInFM = false;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileManagerEngine<FileAssistant>", 2, "err cloud type.when reTry :" + localFileManagerEntity.getCloudType());
    return;
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    return;
    if (localFileManagerEntity.peerUin.equals(AppConstants.ak)) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, localFileManagerEntity, i);
      return;
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(25, paramFileManagerEntity);
  }
  
  public ThumbHttpDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader = new ThumbHttpDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader;
  }
  
  public WeiYunLogicCenter a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter = new WeiYunLogicCenter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      WeiYunLogicCenter localWeiYunLogicCenter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter;
      return localWeiYunLogicCenter;
    }
    finally {}
  }
  
  public FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.Uuid = paramDataLineMsgRecord.fileUuid;
    localFileManagerEntity.selfUin = String.valueOf(paramDataLineMsgRecord.uOwnerUin);
    localFileManagerEntity.peerUin = paramDataLineMsgRecord.selfuin;
    localFileManagerEntity.fileName = paramDataLineMsgRecord.filename;
    localFileManagerEntity.fileSize = paramDataLineMsgRecord.filesize;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = paramDataLineMsgRecord.nOpType;
    localFileManagerEntity.busId = paramDataLineMsgRecord.busId;
    localFileManagerEntity.forwardTroopFileEntrance = paramDataLineMsgRecord.forwardTroopFileEntrance;
    localFileManagerEntity.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
    localFileManagerEntity.peerType = paramDataLineMsgRecord.istroop;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.Uuid = paramFileManagerEntity.Uuid;
    localFileManagerEntity.selfUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.fileName = paramFileManagerEntity.fileName;
    localFileManagerEntity.fileSize = paramFileManagerEntity.fileSize;
    localFileManagerEntity.strThumbPath = paramFileManagerEntity.strThumbPath;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 29;
    localFileManagerEntity.busId = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().a(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      a(paramString, 20);
      return paramString;
    }
    c(paramString);
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = FileManagerUtil.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    localFileManagerEntity.uniseq = MessageRecordFactory.a(64536).uniseq;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramInt);
    localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    String str = TransfileUtile.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = FileManagerUtil.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = MessageRecordFactory.a(64536).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1))
    {
      localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
      if (!paramBoolean) {
        break label457;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
      return localFileManagerEntity;
      localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      break;
      label457:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    }
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
      }
      return null;
    }
    String str2 = TransfileUtile.a(paramString1, 0L, 0, true);
    String str1 = FileManagerUtil.a(paramString1);
    long l = -1L;
    int i;
    int j;
    label63:
    FileManagerEntity localFileManagerEntity;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label560;
      }
      j = 3;
      if (paramBoolean) {
        l = MessageRecordFactory.a(64536).uniseq;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString3, paramInt);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = FileManagerUtil.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt);
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = FileManagerUtil.a(paramString1);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      localFileManagerEntity.strThumbPath = FileManagerUtil.a(paramString1, 150, 150);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramInt != 1004) && (paramInt != 1000)) {
        break label566;
      }
      str1 = paramString2;
    }
    for (;;)
    {
      if (localFileManagerEntity.nFileType == 5)
      {
        localFileManagerEntity.strApkPackageName = FileCategoryUtil.a(localFileManagerEntity.getFilePath(), BaseApplicationImpl.getContext());
        localFileManagerEntity.fileName = FileCategoryUtil.a(localFileManagerEntity.getFilePath());
      }
      if (FileUtils.b(paramString1))
      {
        paramString2 = new BitmapFactory.Options();
        paramString2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString1, paramString2);
        localFileManagerEntity.imgWidth = paramString2.outWidth;
        localFileManagerEntity.imgHeight = paramString2.outHeight;
        i = URLDrawableHelper.a(localFileManagerEntity.getFilePath());
        if ((i == 90) || (i == 270))
        {
          localFileManagerEntity.imgWidth = paramString2.outHeight;
          localFileManagerEntity.imgHeight = paramString2.outWidth;
        }
      }
      if (paramBoolean)
      {
        ThreadManager.a(new rvr(this, localFileManagerEntity), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString3, str1, true, paramString1, 0L, true, paramInt, str2, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, j, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      return localFileManagerEntity;
      i = 6;
      break;
      label560:
      j = 2;
      break label63;
      label566:
      if (paramInt == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        str1 = paramString2;
      }
    }
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader = new DiscPicThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader.a(paramFileManagerEntity, paramInt);
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean, Object paramObject)
  {
    return a().a(paramString, paramInt, paramBoolean, paramObject);
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().a(paramString1, paramString2, paramInt, paramObject);
  }
  
  public ArrayList a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    while (i < FMDataCache.d().size())
    {
      localObject = (OfflineFileInfo)FMDataCache.d().get(i);
      localArrayList.add(a(FileManagerUtil.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).jdField_a_of_type_Long)));
      i += 1;
    }
    i = 0;
    if (i < FMDataCache.c().size())
    {
      localObject = (FileManagerEntity)FMDataCache.c().get(i);
      FileCategoryUtil.a((FileManagerEntity)localObject);
      switch (((FileManagerEntity)localObject).getCloudType())
      {
      case 2: 
      default: 
        localObject = null;
      }
      for (;;)
      {
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
        break;
        localObject = a(((FileManagerEntity)localObject).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, false);
        continue;
        localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
      }
    }
    i = 0;
    while (i < FMDataCache.b().size())
    {
      localObject = a(((FileInfo)FMDataCache.b().get(i)).d(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
      ((FileManagerEntity)localObject).strApkPackageName = ((FileInfo)FMDataCache.b().get(i)).c();
      localArrayList.add(localObject);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a().a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity != null) {
      a(paramInt1, a(localFileManagerEntity), paramInt2);
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, paramString, 1);
    localFileManagerEntity.fProgress = 0.0F;
    try
    {
      localFileManagerEntity.TroopUin = Long.parseLong(paramString);
      localFileManagerEntity.status = 2;
      if (((FileManagerEntity)localObject).peerType == 0)
      {
        localFileManagerEntity.nOpType = 26;
        if ((TextUtils.isEmpty(localFileManagerEntity.strTroopFileUuid)) || (localFileManagerEntity.mContext == null))
        {
          IForwardCallBack localIForwardCallBack = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localFileManagerEntity.strTroopFileUuid = localIForwardCallBack.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId);
          localFileManagerEntity.mContext = localIForwardCallBack;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break label369;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131368805);
        localFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof IForwardCallBack)) {
          ((IForwardCallBack)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, FileManagerUtil.a());
          continue;
          if (((FileManagerEntity)localObject).peerType == 3000) {
            localFileManagerEntity.nOpType = 27;
          } else if (((FileManagerEntity)localObject).peerType == 6000) {
            localFileManagerEntity.nOpType = 32;
          }
        }
      }
      label369:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(102, paramInt, localFileManagerEntity);
    }
  }
  
  public void a(int paramInt1, FileManagerEntity paramFileManagerEntity, int paramInt2)
  {
    Object localObject;
    if (0L == paramFileManagerEntity.datalineEntitySessionId)
    {
      localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      paramFileManagerEntity.datalineEntitySessionId = ((IForwardCallBack)localObject).a(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.selfUin, paramInt1, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.fileSize, 0);
      paramFileManagerEntity.mContext = localObject;
    }
    while (!NetworkUtil.e(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131368805);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      if ((paramFileManagerEntity.mContext instanceof IForwardCallBack)) {
        ((IForwardCallBack)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.datalineEntitySessionId, 9004, (String)localObject, null, null, null);
      }
      return;
      if (paramFileManagerEntity.mContext == null) {
        paramFileManagerEntity.mContext = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(38, paramInt1, paramFileManagerEntity);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString)
  {
    a(38, paramLong, paramString);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = a(paramDataLineMsgRecord);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    boolean bool;
    if (localFileManagerEntity.datalineEntitySessionId != 0L)
    {
      bool = true;
      if (29 != localFileManagerEntity.nOpType) {
        break label49;
      }
      a(3, localFileManagerEntity, i);
    }
    label49:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (31 != localFileManagerEntity.nOpType);
      if (i == 0)
      {
        a(7, Long.valueOf(localFileManagerEntity.selfUin).longValue(), Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.busId, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.forwardTroopFileEntrance, bool, localFileManagerEntity.datalineEntitySessionId);
        return;
      }
    } while (i != 1);
    a(6003, Long.valueOf(localFileManagerEntity.selfUin).longValue(), Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.busId, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.forwardTroopFileEntrance, bool, localFileManagerEntity.datalineEntitySessionId);
  }
  
  public void a(MessageRecord paramMessageRecord, FileManagerEntity paramFileManagerEntity, FMConstants.revertMsgCallback paramrevertMsgCallback)
  {
    if (paramFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramFileManagerEntity.Uuid, paramrevertMsgCallback);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, paramrevertMsgCallback);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opYype[" + paramFileManagerEntity.nOpType + "]");
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if ((localShieldMsgManger != null) && (localShieldMsgManger.a(paramFileManagerEntity.peerUin)))
    {
      FileManagerUtil.a("该好友已被屏蔽！请先解除屏蔽！");
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    if (paramFileManagerEntity.nOpType == 28)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(106, paramFileManagerEntity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.nOpType = paramInt;
    QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + paramInt + "]");
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if ((paramInt != 27) && (!NetworkUtil.e(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "]");
    paramFileManagerEntity.bSend = true;
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt;
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "] error");
      if (QLog.isDevelopLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "多人聊天转发，selfUin不能为自己！！！");
        throw new NullPointerException("多人聊天转发，selfUin不能为自己！！！");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
        return;
        i = 3;
        continue;
        i = 25;
        continue;
        Object localObject;
        if ((TextUtils.isEmpty(paramFileManagerEntity.strTroopFileUuid)) || (paramFileManagerEntity.mContext == null))
        {
          localObject = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramFileManagerEntity.strTroopFileUuid = ((IForwardCallBack)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        j = paramFileManagerEntity.busId;
        i = j;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          i = j;
          if ((paramFileManagerEntity.mContext instanceof IForwardCallBack))
          {
            localObject = BaseApplicationImpl.getContext().getString(2131368805);
            ((IForwardCallBack)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "ForwardDisc2X" + FileManagerUtil.a(paramFileManagerEntity));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, i);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt);
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt, false);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().a(paramWeiYunFileInfo);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files", 0, 0, "", paramString, "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Succ_upload", 0, 0, "", paramString, String.valueOf(FMDataCache.b().size()), "");
    while (i < FMDataCache.b().size())
    {
      a(((FileInfo)FMDataCache.b().get(i)).d(), paramString);
      i += 1;
    }
    FMDataCache.b();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    a().a(paramString, paramInt1, paramInt2, paramLong);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramString2, paramLong, paramInt2, paramString3, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    a(paramLong, paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a().a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "sendAllSelectedFiles, strSendUin[" + FileManagerUtil.e(paramString1) + "], recvUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "]");
    }
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("last_select_send", true);
      ((SharedPreferences.Editor)localObject).commit();
      int i = 0;
      while (i < FMDataCache.e().size())
      {
        localObject = (WeiYunFileInfo)FMDataCache.e().get(i);
        FileManagerReporter.a("0X8005415");
        b(FileManagerUtil.a((WeiYunFileInfo)localObject), paramString1, paramString2, paramInt);
        i += 1;
        continue;
        while (i < FMDataCache.d().size())
        {
          localObject = (OfflineFileInfo)FMDataCache.d().get(i);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(FileManagerUtil.a((OfflineFileInfo)localObject, paramInt), paramString1, paramString2, paramInt, true);
          ((FileManagerEntity)localObject).peerType = paramInt;
          ((FileManagerEntity)localObject).status = 2;
          if (paramInt == 3000) {
            ((FileManagerEntity)localObject).nOpType = 28;
          }
          a((FileManagerEntity)localObject);
          i += 1;
          continue;
          label245:
          while (i < FMDataCache.c().size())
          {
            localObject = (FileManagerEntity)FMDataCache.c().get(i);
            FileCategoryUtil.a((FileManagerEntity)localObject);
            FileManagerReporter.a("0X8005413");
            a(((FileManagerEntity)localObject).nSessionId, paramString1, paramString2, paramInt, true);
            i += 1;
          }
        }
      }
      for (;;)
      {
        if (i < FMDataCache.b().size())
        {
          localObject = ((FileInfo)FMDataCache.b().get(i)).d();
          FileManagerReporter.a("0X8005414");
          if (paramInt == 1) {
            a((String)localObject, paramString2);
          } else {
            a((String)localObject, paramString1, paramString2, paramInt, true).strApkPackageName = ((FileInfo)FMDataCache.b().get(i)).c();
          }
        }
        else
        {
          if (paramInt == 1) {
            if (FMDataCache.e().size() <= 0) {
              break label588;
            }
          }
          label588:
          for (i = 1;; i = 0)
          {
            int j = i;
            if (FMDataCache.b().size() > 0) {
              j = i + 10;
            }
            if (FMDataCache.c().size() > 0) {}
            for (i = j + 100;; i = j)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "oper", "Clk_send", 0, 0, paramString2, String.format("%03d", new Object[] { Integer.valueOf(i) }), "", "");
              i = FileManagerUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              if ((paramInt != 0) || (i >= 3) || (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2))) {
                break;
              }
              FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2, false);
              paramString1 = BaseApplicationImpl.getContext().getString(2131366199);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt, 62527, paramString1);
              FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i + 1);
              return;
            }
          }
          i = 0;
          break;
          i = 0;
          break label245;
          i = 0;
          continue;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + FileManagerUtil.e(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString3, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    int i = 0;
    for (;;)
    {
      if (i < FMDataCache.b().size())
      {
        String str = ((FileInfo)FMDataCache.b().get(i)).d();
        try
        {
          FileUtil.a(new File(str));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + localException.toString());
            }
          }
        }
      }
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= FMDataCache.e().size()) {
        break;
      }
      a((WeiYunFileInfo)FMDataCache.e().get(i));
      i += 1;
    }
    while (j < FMDataCache.c().size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)FMDataCache.c().get(j);
      FileCategoryUtil.a(localFileManagerEntity);
      b(localFileManagerEntity.nSessionId);
      j += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, long paramLong3, int paramInt3, boolean paramBoolean, long paramLong4)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1);
    IForwardCallBack localIForwardCallBack = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTroopFileTransferManager.a(paramInt3, paramLong1, paramInt2, paramLong2, paramInt1, paramString2, paramString3, paramLong3, paramString1, paramBoolean, paramLong4, localIForwardCallBack);
      return true;
      localIForwardCallBack = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      localIForwardCallBack = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      continue;
      localIForwardCallBack = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    }
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "sessionid[" + String.valueOf(paramLong) + "] call Pause");
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "sessionid[" + String.valueOf(paramLong) + "] item is not exist");
      }
      return false;
    }
    if ((localFileManagerEntity.getCloudType() == 0) && (1 != localFileManagerEntity.nOpType))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      return true;
    }
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData;
    if (1 == localFileManagerEntity.nOpType)
    {
      localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.b = "recv_file_cancel";
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
    }
    while ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq == -1L))
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.b = "send_file_cancel";
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.uniseq, localFileManagerEntity.peerType);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.a(localFileManagerEntity) + " ]");
    }
    return a(localFileManagerEntity.getFilePath(), paramString);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, String.format("ForwardTroopFile==>fileName:%s|mEntrySessionID:%s|old filePath:%s", new Object[] { paramString.fileName, paramLong1 + "", paramString.strTroopFilePath }));
    }
    Object localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, paramString.Uuid, paramString.strTroopFilePath, paramString.fileName, paramString.fileSize, paramString.busId);
    if ((localObject1 == null) || (((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString == null)) {
      return false;
    }
    if (paramInt1 == 1)
    {
      paramInt1 = Math.abs(new Random().nextInt());
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString, paramLong2, ((TroopFileStatusInfo)localObject1).g, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopFileStatusInfo)localObject1).b, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_Int, paramInt1, paramLong1);
      Object localObject2;
      if ((localTroopFileStatusInfo.g != null) && (FileManagerUtil.a(((TroopFileStatusInfo)localObject1).g) == 0)) {
        if (FileUtil.a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localTroopFileStatusInfo.g, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramInt1, String.valueOf(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long), paramLong1, ((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight);
        }
      }
      for (;;)
      {
        paramString.structMsgSeq = paramLong2;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + paramLong1 + "|InsertAIOMsg, msgSeq:" + paramLong2);
        }
        return true;
        localObject2 = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long), 1, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString);
        if (localObject2 != null)
        {
          paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localTroopFileStatusInfo.g, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramInt1, String.valueOf(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long), paramLong1, ((MessageForTroopFile)localObject2).width, ((MessageForTroopFile)localObject2).height);
        }
        else
        {
          paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localTroopFileStatusInfo.g, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramInt1, String.valueOf(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long), paramLong1);
          continue;
          paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localTroopFileStatusInfo.g, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramInt1, String.valueOf(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long), paramLong1);
        }
      }
    }
    if ((paramInt1 == 3000) || (paramInt1 == 0))
    {
      localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
      if (paramLong2 != 0L) {
        break label816;
      }
    }
    label810:
    label816:
    for (paramLong1 = paramString.TroopUin;; paramLong1 = paramLong2)
    {
      ((TroopFileTransferManager)localObject1).a(paramInt2, paramLong1, paramString.busId, paramLong3, paramInt1, paramString.fileName, paramString.strThumbPath, paramString.fileSize, paramString.strTroopFilePath, false, 0L, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      return true;
      if (paramInt1 == 7)
      {
        localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
        if (paramLong2 != 0L) {
          break label810;
        }
      }
      for (paramLong1 = paramString.TroopUin;; paramLong1 = paramLong2)
      {
        if (paramString.datalineEntitySessionId != 0L) {}
        for (boolean bool = true;; bool = false)
        {
          ((TroopFileTransferManager)localObject1).a(paramInt2, paramLong1, paramString.busId, paramLong3, paramInt1, paramString.fileName, paramString.strThumbPath, paramString.fileSize, paramString.strTroopFilePath, bool, paramString.datalineEntitySessionId, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0));
          break;
        }
        if (paramInt1 != 6003) {
          break;
        }
        localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
        if (paramLong2 == 0L) {}
        for (paramLong1 = paramString.TroopUin;; paramLong1 = paramLong2)
        {
          if (paramString.datalineEntitySessionId != 0L) {}
          for (bool = true;; bool = false)
          {
            ((TroopFileTransferManager)localObject1).a(paramInt2, paramLong1, paramString.busId, paramLong3, 7, paramString.fileName, paramString.strThumbPath, paramString.fileSize, paramString.strTroopFilePath, bool, paramString.datalineEntitySessionId, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1));
            break;
          }
        }
      }
    }
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.a(localFileManagerEntity) + " ]");
    }
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.c(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      FileManagerUtil.b(localFileManagerEntity.nSessionId);
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2, paramInt);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt);
      continue;
      if ((localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + FileManagerUtil.e(paramString1) + "], recvUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "], toOffline[" + paramBoolean + "]");
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((paramInt == 1004) || (paramInt == 1000)) {
          localObject = paramString1;
        }
        while (paramInt == 1)
        {
          b(paramLong, paramString2);
          return false;
          if (paramInt == 1006) {
            localObject = paramString1;
          }
        }
        localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt, true);
        FileManagerUtil.b(((FileManagerEntity)localObject).nSessionId);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
        ((FileManagerEntity)localObject).peerType = localFileManagerEntity.peerType;
        if (localFileManagerEntity.peerType == 3000)
        {
          if (paramInt == 3000) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, 22);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, 21);
          }
        }
        else
        {
          if (paramInt == 3000) {
            ((FileManagerEntity)localObject).nOpType = 28;
          }
          a((FileManagerEntity)localObject);
        }
      }
      else if (localFileManagerEntity.getFilePath() != null)
      {
        if (paramInt == 1) {
          a(localFileManagerEntity.getFilePath(), paramString2);
        } else {
          return a(localFileManagerEntity.getFilePath(), paramString1, paramString2, paramInt, paramBoolean) != null;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramString2));
    int i;
    File localFile;
    if (localObject != null)
    {
      i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      localFile = new File(paramString1);
      if (FileManagerUtil.a(paramString1) != 0) {
        break label130;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString1, localOptions);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localFile.getName(), localFile.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, localOptions.outWidth, localOptions.outHeight);
    }
    for (;;)
    {
      return true;
      label130:
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localFile.getName(), localFile.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L);
    }
  }
  
  public String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader = new OfflineVideoThumbDownLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader.a(paramFileManagerEntity, paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public void b(long paramLong, String paramString)
  {
    a(3, paramLong, paramString);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "ReviceFile,entity is null!");
      }
      return;
    }
    switch (paramFileManagerEntity.getCloudType())
    {
    }
    for (;;)
    {
      i();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, but entity is localFile");
      return;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 1);
      continue;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_WEIYUN ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 5);
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1)
    {
      a().a(paramFileManagerEntity, paramString2);
      return;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    a(paramFileManagerEntity, str, paramString2, paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public boolean b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delete record fail. entity is null, sessionid: " + paramLong);
      }
      return false;
    }
    boolean bool;
    if (localFileManagerEntity.getCloudType() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      if ((localFileManagerEntity != null) && (localFileManagerEntity.bDelInAio) && (localFileManagerEntity.bDelInFM) && (localFileManagerEntity.getCloudType() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity.nSessionId);
      }
      if ((3000 != localFileManagerEntity.peerType) && (!TextUtils.isEmpty(localFileManagerEntity.Uuid))) {
        a(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.bSend);
      }
      if (!FileManagerUtil.b(localFileManagerEntity.getFilePath())) {
        break label262;
      }
      localFileManagerEntity.cloudType = 3;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong)) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(paramLong) + "] faild!,status[" + String.valueOf(localFileManagerEntity.status) + "]");
      break;
      label262:
      localFileManagerEntity.status = 16;
    }
  }
  
  public String c(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader = new DiscVideoThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader.a(paramFileManagerEntity, paramInt);
  }
  
  public void c()
  {
    a().a();
  }
  
  public void c(String paramString)
  {
    a().a(paramString);
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.b(paramString);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    a().b();
  }
  
  public void f()
  {
    BaseApplicationImpl.a.unregisterReceiver(this.jdField_a_of_type_Rvs);
    this.jdField_a_of_type_Rvs = null;
    FMSettings.a().b();
    FileViewMusicService.a().c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + FMDataCache.e().size() + "], offline[" + FMDataCache.d().size() + "], recent[" + FMDataCache.c().size() + "], localfile[" + FMDataCache.b().size() + "]");
    }
    int i = 0;
    FileManagerEntity localFileManagerEntity;
    while (i < FMDataCache.e().size())
    {
      localFileManagerEntity = FileManagerUtil.a((WeiYunFileInfo)FMDataCache.e().get(i));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downWeiYunFiles,weiyun[" + i + "]");
      }
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 5);
      i += 1;
    }
    i = 0;
    while (i < FMDataCache.d().size())
    {
      localFileManagerEntity = FileManagerUtil.a((OfflineFileInfo)FMDataCache.d().get(i), 0);
      localFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
      }
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 8);
      i += 1;
    }
    i = 0;
    if (i < FMDataCache.c().size())
    {
      localFileManagerEntity = (FileManagerEntity)FMDataCache.c().get(i);
      FileCategoryUtil.a(localFileManagerEntity);
      switch (localFileManagerEntity.getCloudType())
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + FileManagerUtil.a(localFileManagerEntity));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel())
        {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,local[" + i + "] break");
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,offline[" + i + "]");
          }
          a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 8);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,weiyun[" + i + "]");
          }
          a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 5);
        }
      }
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", false).commit();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", true).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\app\FileManagerEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */