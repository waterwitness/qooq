import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqUploadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class vqf
  extends TroopFileProtocol.ReqUploadFileObserver
{
  public vqf(TroopFileTransferManager paramTroopFileTransferManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a.get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      paramBundle = UUID.fromString(str);
      try
      {
        paramBundle = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(paramBundle);
        if (paramBundle == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    if (!paramBoolean)
    {
      ReportController.b((QQAppInterface)this.b.get(), "P_CliOper", "Grp_files", "", "file", "fail_upload", 0, 0, l + "", "", "", "");
      paramUploadFileRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.g, 3, 207);
      this.a.a(paramBundle, 3, paramUploadFileRspBody);
      if (QLog.isDevelopLevel()) {
        QLog.w("TroopFileTransferManager", 2, "onReqResendFileResult,errCode=" + paramInt);
      }
    }
    else
    {
      int i = paramUploadFileRspBody.int32_ret_code.get();
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onRspUpload - retCode: %d", new Object[] { Integer.valueOf(i) }));
      }
      if (i < 0)
      {
        paramInt = 207;
        switch (i)
        {
        }
        for (;;)
        {
          paramUploadFileRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.g, 3, paramInt);
          this.a.a(paramBundle, 3, paramUploadFileRspBody);
          return;
          paramInt = 202;
          continue;
          paramInt = 208;
          continue;
          new Handler(Looper.getMainLooper()).postDelayed(new vqg(this, paramBundle), 1000L);
          return;
          if (paramBundle.BusId != 104)
          {
            paramBundle.BusId = 104;
            this.a.b(paramBundle);
            return;
          }
          paramInt = 204;
          continue;
          paramInt = 209;
          continue;
          paramInt = 65400;
          continue;
          paramInt = 65398;
        }
      }
      paramBundle.FilePath = paramUploadFileRspBody.str_file_id.get();
      paramBundle.UploadIp = paramUploadFileRspBody.str_upload_ip.get();
      paramBundle.CheckKey = paramUploadFileRspBody.bytes_check_key.get().toByteArray();
      paramBundle.BusId = paramUploadFileRspBody.uint32_bus_id.get();
      if (!this.a.a(paramBundle)) {
        new TroopFileTransferManager.TaskHttpUpload(this.a, paramBundle);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */