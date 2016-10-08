package com.tencent.mobileqq.filemanager.core;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyCloudFileSystem;
import com.weiyun.sdk.IWyFileSystem;
import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.IWyTaskManager;
import com.weiyun.sdk.IWyTaskManager.Task;
import cooperation.weiyun.WeiyunHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import saj;
import sak;
import sal;
import sam;
import san;
import sao;
import sap;
import saq;
import sar;
import sas;
import sat;
import sau;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ExtensionReq;

public class WeiYunLogicCenter
{
  static final String jdField_a_of_type_JavaLangString = "WeiYunLogicCenter<FileAssistant>";
  static boolean jdField_a_of_type_Boolean;
  public int a;
  public QQAppInterface a;
  IWyFileSystem jdField_a_of_type_ComWeiyunSdkIWyFileSystem;
  public LinkedHashMap a;
  public List a;
  
  public WeiYunLogicCenter(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (jdField_a_of_type_Boolean) {
      WeiyunHelper.a();
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem = WeiyunHelper.a();
    jdField_a_of_type_Boolean = true;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : entity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : fromUin is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.uniseq = -1L;
    localFileManagerEntity.nOpType = 4;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramFileManagerEntity.peerType);
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.peerUin = paramString;
    if (paramFileManagerEntity.peerType == 3000) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())
    {
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity FileManagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      return localFileManagerEntity;
    }
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity : entity is null, peerUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "]");
      }
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    String str = TransfileUtile.a("", 0L, 0, true);
    long l = MessageRecordFactory.a(64536).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 3;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    paramFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if ((paramInt == 1004) || (paramInt == 1000)) {
      paramFileManagerEntity = paramString1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramFileManagerEntity, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 2, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity peerType[" + paramInt + "],FileManagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      return localFileManagerEntity;
      if (paramInt == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString1;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
        paramFileManagerEntity = paramString1;
      }
    }
  }
  
  public IWyTaskManager.Task a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile strPath is null");
      }
    }
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile, strPath[" + paramString + "]");
      }
      paramString = this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getTaskManager().createUploadTask(paramString, paramObject);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile create upload task faild!");
    return null;
    return paramString;
  }
  
  public IWyTaskManager.Task a(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile fileId is null");
      }
      paramString1 = null;
      return paramString1;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile fileName is null!");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      if ("downLoadWeiYunFile, fileId[" + paramString1 + "], fileName[" + paramString2 + "], fileName[" + paramString2 != null) {
        break label144;
      }
    }
    label144:
    for (String str = "null";; str = paramString2 + "], fileSize[" + String.valueOf(paramLong1) + "],modifyTime[" + String.valueOf(paramLong2) + "]")
    {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, str);
      paramString2 = this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getTaskManager().createDownloadTask(paramString1, paramString2, paramLong1, paramLong2, paramObject);
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "create download task faild!");
      }
      return null;
    }
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 39, new Object[] { paramString, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getOfflinePicThumb : strUuid error");
      }
      localObject1 = null;
    }
    do
    {
      return (String)localObject1;
      QLog.d("WeiYunLogicCenter<FileAssistant>", 1, "getOfflinePicThumb strUuid[" + paramString + "], WeiYunThumbnailType[" + paramInt + "]");
      localObject2 = this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getOfflineFileThumbnail(paramString, IWyFileSystem.ThumbnailType.values()[paramInt]);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 39, new Object[] { paramString, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getOfflinePicThumb : network error");
      }
      return null;
    }
    Object localObject1 = this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem;
    Object localObject2 = IWyFileSystem.ThumbnailType.values()[paramInt];
    if (paramBoolean) {}
    for (paramInt = i;; paramInt = 2)
    {
      ((IWyFileSystem)localObject1).getOfflineFileThumbnail(paramString, (IWyFileSystem.ThumbnailType)localObject2, paramInt, paramObject, new sas(this));
      return null;
    }
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : strFileId[" + paramString1 + "], strFileName[" + paramString2 + "], WeiYunThumbnailType[" + paramInt + "]");
    }
    Object localObject;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 39, new Object[] { paramString1, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : fileID error");
      }
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      str = this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getThumbnail(paramString1, IWyFileSystem.ThumbnailType.values()[paramInt], paramString2, 0L);
      localObject = str;
    } while (str != null);
    if ((!NetworkUtil.e(BaseApplication.getContext())) || (paramString1 == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 39, new Object[] { paramString1, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : network error");
      }
      return null;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getThumbnail(paramString1, IWyFileSystem.ThumbnailType.values()[paramInt], paramString2, 0L, paramObject, new sar(this));
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunTypeList");
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 30, new Object[] { Integer.valueOf(0), "network error" });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunTypeList : network error");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().listCategory(new saj(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList, type[" + paramInt1 + "], offset[" + paramInt2 + "], count[" + paramInt3 + "]");
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 32, new Object[] { Integer.valueOf(0), "network error" });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "net work error");
      }
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().listOfflineFiles(paramInt1, paramInt2, paramInt3, new sao(this));
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : entity is null");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, "actFileWy2Of", 0L, "", "", "", "", 9006L, "entity is null", 0L, 0L, 0L, "", "", 0, "", null);
      FileManagerUtil.a();
      return;
    }
    paramFileManagerEntity.status = 2;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 3, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 33, new Object[] { Integer.valueOf(2), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : network error");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", paramFileManagerEntity.peerUin, "", "", 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline, peerUin[" + FileManagerUtil.e(paramFileManagerEntity.peerUin) + "peerType[" + paramInt + "]" + "], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "]");
    }
    paramFileManagerEntity.fProgress = 0.0F;
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramFileManagerEntity.peerUin.replace("+", ""));
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if ((localShieldMsgManger != null) && (localShieldMsgManger.a(paramFileManagerEntity.peerUin)))
      {
        FileManagerUtil.a("该好友已被屏蔽！请先解除屏蔽！");
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 3, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 33, new Object[] { Integer.valueOf(10), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : shield");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
          l1 = l2;
        }
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) || (TextUtils.isEmpty(paramFileManagerEntity.fileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: weiyunID is null[" + TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId) + "], fileName is Null[" + TextUtils.isEmpty(paramFileManagerEntity.fileName) + "]");
        }
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId, 1005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 33, new Object[] { Integer.valueOf(1), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        return;
      }
      int i = 3;
      if (paramInt == 3000) {
        i = 106;
      }
      Object localObject = null;
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        Cmd0X31B.ExtensionReq localExtensionReq = new Cmd0X31B.ExtensionReq();
        localExtensionReq.uint64_type.set(paramFileManagerEntity.tmpSessionType);
        localExtensionReq.uint64_id.set(3L);
        if (paramFileManagerEntity.tmpSessionType == 102L) {
          localExtensionReq.str_dst_phonenum.set(paramFileManagerEntity.peerUin);
        }
        paramFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        localObject = localExtensionReq;
        if (paramFileManagerEntity.tmpSessionSig != null)
        {
          localObject = localExtensionReq;
          if (paramFileManagerEntity.tmpSessionSig.length > 0)
          {
            localExtensionReq.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
            localObject = localExtensionReq;
          }
        }
      }
      this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().sendWyFile2Ftn(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nWeiYunSrcType, null, l1, i, null, (Cmd0X31B.ExtensionReq)localObject, new sap(this, paramFileManagerEntity, paramInt));
      FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : entity is null");
      }
    }
    TroopFileTransferManager localTroopFileTransferManager;
    int i;
    TroopFileStatusInfo localTroopFileStatusInfo;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(paramString).longValue());
      } while (localTroopFileTransferManager == null);
      i = Math.abs(new Random().nextInt());
      localTroopFileStatusInfo = localTroopFileTransferManager.a(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize, 25, i, 8888L);
    } while (localTroopFileStatusInfo == null);
    Object localObject;
    if ((localTroopFileStatusInfo.jdField_a_of_type_JavaLangString != null) && (FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileManagerUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString) == 0))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), i, String.valueOf(localTroopFileStatusInfo.jdField_a_of_type_Long), paramFileManagerEntity.nSessionId, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      if (localItem != null)
      {
        localItem.width = ((BitmapFactory.Options)localObject).outWidth;
        localItem.height = ((BitmapFactory.Options)localObject).outHeight;
      }
    }
    for (;;)
    {
      paramFileManagerEntity.status = 2;
      if (NetworkUtil.e(BaseApplication.getContext())) {
        break label332;
      }
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, -1, null, "当前网络不可用，请检查你的网络设置");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : network error");
      return;
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), i, String.valueOf(8888L), paramFileManagerEntity.nSessionId);
    }
    label332:
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop, peerUin[" + FileManagerUtil.e(paramFileManagerEntity.peerUin) + "], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "]");
    }
    paramFileManagerEntity.fProgress = 0.0F;
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      paramString = null;
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject = new Cmd0X31B.ExtensionReq();
        ((Cmd0X31B.ExtensionReq)localObject).uint64_type.set(paramFileManagerEntity.tmpSessionType);
        ((Cmd0X31B.ExtensionReq)localObject).uint64_id.set(3L);
        if (paramFileManagerEntity.tmpSessionType == 102L) {
          ((Cmd0X31B.ExtensionReq)localObject).str_dst_phonenum.set(paramFileManagerEntity.peerUin);
        }
        paramFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        paramString = (String)localObject;
        if (paramFileManagerEntity.tmpSessionSig != null)
        {
          paramString = (String)localObject;
          if (paramFileManagerEntity.tmpSessionSig.length > 0)
          {
            ((Cmd0X31B.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
            paramString = (String)localObject;
          }
        }
      }
      this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().sendWyFile2Ftn(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nWeiYunSrcType, paramFileManagerEntity.strFileMd5, l1, 102, null, paramString, new saq(this, paramFileManagerEntity, localTroopFileTransferManager, localTroopFileStatusInfo));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
          l1 = l2;
        }
      }
    }
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, strFileId[" + String.valueOf(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString) + "],strFileName[" + paramWeiYunFileInfo.b + "]");
    }
    FMDataCache.a(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString, paramWeiYunFileInfo);
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().deleteWyFile(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString, paramWeiYunFileInfo.c, new sau(this, paramWeiYunFileInfo));
  }
  
  public void a(IWyTaskManager.Task paramTask)
  {
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getTaskManager().submitTask(paramTask);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd");
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd : network error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 45, new Object[] { Integer.valueOf(0), BaseApplication.getContext().getString(2131367481) });
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().verifyIndependentPassword(paramString, null, new sal(this));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList, categoryId[" + paramString + "], offset[" + paramInt1 + "], count[" + paramInt2 + "], timestamp[" + paramLong + "]");
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 31, new Object[] { Integer.valueOf(0), "network error", paramString });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : network error");
      }
    }
    do
    {
      return;
      if (paramInt1 == 0)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        this.jdField_a_of_type_Int = 0;
      }
      while (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().listCloudFiles(paramString, paramInt1, paramInt2, paramLong, new san(this, paramString));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : start not from zero?!");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getPreviewUrl strFileId[" + paramString1 + "], strName[" + paramString2 + "]");
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getPreviewUrl : network error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 40, new Object[] { Integer.valueOf(0), "network error" });
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().getPreviewUrl(paramString1, paramString2, new sat(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().hasQueriedVerifyPassword();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd");
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().needVerifyIndependentPassword(new sak(this));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComWeiyunSdkIWyFileSystem.getCloudFileSystem().getPreviewAddress(paramString, new sam(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\WeiYunLogicCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */