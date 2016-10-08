import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

public class sgb
  extends TroopFileProtocol.ReqDownloadFileObserver
{
  public sgb(OfflineVideoFileView paramOfflineVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramDownloadFileRspBody == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("OfflineVideoFileView", 4, "error DownloadFileRspBody is null!!!!!");
      }
      this.a.a.sendMessage(this.a.a.obtainMessage(4));
      return;
    }
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a.get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("OfflineVideoFileView", 4, "bad troopUin" + l);
        }
        this.a.a.sendMessage(this.a.a.obtainMessage(4));
        return;
      }
    }
    finally {}
    paramBundle = paramBundle.getString("itemKey");
    if (paramBundle == null)
    {
      this.a.a.sendMessage(this.a.a.obtainMessage(4));
      return;
    }
    Object localObject = UUID.fromString(paramBundle);
    try
    {
      localObject = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localObject);
      if (localObject == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("OfflineVideoFileView", 4, "bad item key" + paramBundle);
        }
        this.a.a.sendMessage(this.a.a.obtainMessage(4));
        return;
      }
    }
    finally {}
    paramInt = paramDownloadFileRspBody.int32_ret_code.get();
    if (QLog.isDevelopLevel()) {
      QLog.e("OfflineVideoFileView", 4, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    ((TroopFileTransferManager.Item)localObject).cookieValue = HexUtil.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
    if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
      ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
    }
    ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    ((TroopFileTransferManager.Item)localObject).DownloadUrl = HexUtil.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if ((paramInt == 65403) || (paramInt == 65404) || (paramInt == 65402))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("OfflineVideoFileView", 4, "file invalidate retCode = " + paramInt);
      }
      this.a.a.sendMessage(this.a.a.obtainMessage(4));
      return;
    }
    if ((paramInt == -103) || (paramInt == 65235))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("OfflineVideoFileView", 4, "file invalidate retCode = " + paramInt);
      }
      this.a.a.sendMessage(this.a.a.obtainMessage(5));
      return;
    }
    paramDownloadFileRspBody = TroopFileVideoOnlinePlayManager.a(((TroopFileTransferManager.Item)localObject).DownloadIp, ((TroopFileTransferManager.Item)localObject).DownloadUrl, ((TroopFileTransferManager.Item)localObject).FilePath, ((TroopFileTransferManager.Item)localObject).cookieValue, "");
    if (!TextUtils.isEmpty(paramDownloadFileRspBody))
    {
      this.a.b = paramDownloadFileRspBody;
      this.a.c = ((TroopFileTransferManager.Item)localObject).cookieValue;
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "url = " + this.a.b + ", cookies = " + this.a.c);
      }
      this.a.a.sendMessage(this.a.a.obtainMessage(3));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "url = " + this.a.b + ", cookies = " + this.a.c);
    }
    this.a.a.sendMessage(this.a.a.obtainMessage(4));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */