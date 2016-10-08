import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public final class sjm
  implements IForwardCallBack
{
  public sjm(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    paramString5 = TroopFileManager.a(this.a, Long.parseLong(paramString2));
    if (paramString5 != null) {
      paramString5.b(paramString3, paramString4, paramLong, paramInt2);
    }
    String str = TransfileUtile.a("", 0L, 0, true);
    paramString5 = null;
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString2);
      l1 = l2;
      localObject = TroopFileManager.a(this.a, l2).a(paramString3);
      paramString5 = (String)localObject;
      l1 = l2;
    }
    catch (Exception localException)
    {
      long l2;
      Object localObject;
      for (;;) {}
    }
    localObject = new FileManagerEntity();
    ((FileManagerEntity)localObject).nSessionId = FileManagerUtil.a().longValue();
    ((FileManagerEntity)localObject).fileName = paramString4;
    l2 = MessageRecordFactory.a(64536).uniseq;
    ((FileManagerEntity)localObject).uniseq = l2;
    if (paramInt1 == 0)
    {
      ((FileManagerEntity)localObject).nOpType = 24;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + ((FileManagerEntity)localObject).nSessionId + "],[troopToOffline]");
      }
    }
    do
    {
      for (;;)
      {
        ((FileManagerEntity)localObject).bSend = true;
        ((FileManagerEntity)localObject).isReaded = true;
        ((FileManagerEntity)localObject).peerType = paramInt1;
        ((FileManagerEntity)localObject).peerUin = paramString1;
        ((FileManagerEntity)localObject).peerNick = FileManagerUtil.a(this.a, paramString1, null, paramInt1);
        ((FileManagerEntity)localObject).selfUin = paramString2;
        ((FileManagerEntity)localObject).srvTime = (MessageCache.a() * 1000L);
        ((FileManagerEntity)localObject).setCloudType(4);
        ((FileManagerEntity)localObject).status = 2;
        ((FileManagerEntity)localObject).msgSeq = FileManagerUtil.a();
        ((FileManagerEntity)localObject).msgUid = FileManagerUtil.b();
        ((FileManagerEntity)localObject).fileSize = paramLong;
        ((FileManagerEntity)localObject).TroopUin = l1;
        ((FileManagerEntity)localObject).busId = paramInt2;
        ((FileManagerEntity)localObject).strTroopFilePath = paramString3;
        ((FileManagerEntity)localObject).strTroopFileID = paramString5.a.toString();
        ((FileManagerEntity)localObject).lastTime = paramString5.c;
        ((FileManagerEntity)localObject).TroopUin = l1;
        ((FileManagerEntity)localObject).forwardTroopFileEntrance = paramInt3;
        paramString2 = this.a.a();
        this.a.a().a(paramString1, paramString2, true, "", paramLong, true, paramInt1, str, ((FileManagerEntity)localObject).msgSeq, ((FileManagerEntity)localObject).msgSeq, paramString3, 1, l2, ((FileManagerEntity)localObject).msgUid, -1L, MessageCache.a());
        this.a.a().a((FileManagerEntity)localObject);
        return ((FileManagerEntity)localObject).nSessionId;
        if (paramInt1 != 3000) {
          break;
        }
        ((FileManagerEntity)localObject).nOpType = 25;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + ((FileManagerEntity)localObject).nSessionId + "],[troopToDisc]");
        }
      }
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("群同事传递的peerType不对！");
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    FileManagerEntity localFileManagerEntity = this.a.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult,but entity is null SessionId[" + paramLong + "]");
      return;
    }
    if (localFileManagerEntity.nOpType == 24)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToOffline]");
      }
      if ((paramBoolean) && (TextUtils.isEmpty(paramString4) != true)) {
        break label436;
      }
      localFileManagerEntity.status = 0;
      if (TextUtils.isEmpty(paramString4) == true) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "!!!!!!!！！！new uuid is null!!!!!!!");
      }
    }
    label224:
    label275:
    label307:
    label327:
    label436:
    label801:
    label809:
    label901:
    label910:
    for (;;)
    {
      String str;
      if (paramInt != 0)
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          FMToastUtil.c(paramString1);
          paramBoolean = false;
        }
      }
      else
      {
        if (localFileManagerEntity.peerType != 0) {
          break label809;
        }
        paramString4 = this.a;
        str = localFileManagerEntity.forwardTroopFileEntrance + "";
        if (paramBoolean != true) {
          break label801;
        }
        paramString2 = "1";
        ReportController.b(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_fri", 0, 0, paramString3, str, paramString2, localFileManagerEntity.peerUin);
        paramString2 = this.a.a();
        if (localFileManagerEntity.status != 1) {
          break label901;
        }
        paramBoolean = true;
        paramString2.a(paramBoolean, 46, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Integer.valueOf(paramInt), paramString1 });
        return;
        if (localFileManagerEntity.nOpType == 25)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToDisc]");
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "getC2CProcessCallBack->onResult operation Error![" + localFileManagerEntity.nOpType + "]");
        break;
        localFileManagerEntity.status = 1;
        localFileManagerEntity.setCloudType(1);
        localFileManagerEntity.Uuid = paramString4;
        localFileManagerEntity.TroopUin = 0L;
        localFileManagerEntity.strTroopFileID = null;
        localFileManagerEntity.strTroopFilePath = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerUtil<FileAssistant>", 1, "onResult bSuccess[true],peerType[" + localFileManagerEntity.peerType + "],peerUin[" + localFileManagerEntity.peerUin + "],uuid[" + localFileManagerEntity.Uuid + "]");
        }
        if (localFileManagerEntity.peerType == 3000)
        {
          this.a.a().a(localFileManagerEntity, 64, "");
          this.a.a().a(localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, this.a.a(), localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramString4, localFileManagerEntity.uniseq, localFileManagerEntity.msgUid, null);
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0) {
            paramString2 = this.a.a().a(localFileManagerEntity, 5);
          }
        }
      }
      for (;;)
      {
        if (paramString2 == null) {
          break label910;
        }
        localFileManagerEntity.strThumbPath = paramString2;
        break;
        if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2)
        {
          paramString2 = this.a.a().c(localFileManagerEntity, 2);
          continue;
          this.a.a().a(localFileManagerEntity, 63, "");
          this.a.a().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0)
          {
            paramString2 = this.a.a().a(paramString4, 5, true, localFileManagerEntity);
            continue;
          }
          if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2)
          {
            paramString2 = this.a.a().b(localFileManagerEntity, 2);
            continue;
            FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131362944));
            break label224;
            paramString2 = "2";
            break label275;
            if (localFileManagerEntity.peerType != 3000) {
              break label307;
            }
            paramString4 = this.a;
            str = localFileManagerEntity.forwardTroopFileEntrance + "";
            if (paramBoolean == true) {}
            for (paramString2 = "1";; paramString2 = "2")
            {
              ReportController.b(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_talk", 0, 0, paramString3, str, paramString2, "");
              break;
            }
            paramBoolean = false;
            break label327;
          }
        }
        paramString2 = null;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */