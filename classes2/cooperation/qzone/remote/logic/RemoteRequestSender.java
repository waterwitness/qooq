package cooperation.qzone.remote.logic;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.DiscoverTab;
import java.util.ArrayList;

public class RemoteRequestSender
  implements RemoteHandleConst
{
  private RemoteHandleManager a;
  
  public RemoteRequestSender(RemoteHandleManager paramRemoteHandleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRemoteHandleManager;
  }
  
  public int a()
  {
    return this.a.a("cmd.qzoneFontChanged", null, false);
  }
  
  public int a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    return this.a.a("cmd.pre.getpassivefeeds", localBundle, true);
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, ArrayList paramArrayList, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_qun_id", paramString2);
    localBundle.putString("ken_qun_name", paramString3);
    localBundle.putString("UploadPhoto.key_album_id", paramString4);
    localBundle.putString("UploadPhoto.key_album_name", paramString5);
    localBundle.putString("refer", "mqqChat");
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = paramInt;
    }
    for (;;)
    {
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", paramArrayList);
      localBundle.putInt("key_quality", i);
      paramString2 = String.valueOf(MessageUtils.a());
      localBundle.putString("key_upload_client_key", paramString2);
      paramString3 = QZoneHelper.UserInfo.a();
      paramString3.a = paramString1;
      localBundle.putString("qzone_uin", paramString3.a);
      localBundle.putString("nickname", paramString3.b);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      paramIntent.putExtra("key_upload_client_key", paramString2);
      return this.a.a("cmd_upload_troop_photos", localBundle, true);
      i = 0;
      continue;
      i = 3;
    }
  }
  
  public void a()
  {
    this.a.a("cmd.resumePlay", null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.playModeRandom", paramInt1);
    localBundle.putInt("param.playModeAuto", paramInt2);
    this.a.a("cmd.savePlayMode", localBundle, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.a.a("cmd.playMusicList", localBundle, false);
  }
  
  public void a(DiscoverTab paramDiscoverTab)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("tab", paramDiscoverTab);
    this.a.a("cmd.discover.onShowDiscoverTab", localBundle, false);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.a.a("cmd.getDynamicPhoto", localBundle, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putInt("web_hash_code", paramInt);
    this.a.a("cmd.webview.getproxydata", localBundle, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.textContent", paramString1);
    localBundle.putString("param.signInPictureUrl", paramString2);
    this.a.a("cmd.SyncWechatWithSignIn", localBundle, false);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", paramString1);
    localBundle.putString("value", paramString2);
    localBundle.putLong("uin", paramLong);
    this.a.a("cmd.update.friendsetting", localBundle, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    localBundle.putString("GiftMd5_FullScreen", paramString3);
    this.a.a("cmd.downloadGift", localBundle, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("DeviceStrDiyMemo", paramString1);
    localBundle.putString("DeviceStrDeviceTail", paramString2);
    localBundle.putString("DeviceStrDeviceIcon", paramString3);
    localBundle.putString("DeviceStrIdentifySqua", paramString4);
    this.a.a("cmd.setUserTail", localBundle, true);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.PrepathList", paramArrayList);
    this.a.a("cmd.removePreUploadTak", localBundle, true);
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoId", paramArrayList2);
    this.a.a("cmd.videoGetLocalProxyUrl", localBundle, true);
  }
  
  public void b()
  {
    this.a.a("cmd.pausePlay", null, false);
  }
  
  public void b(DiscoverTab paramDiscoverTab)
  {
    QLog.d("QZoneDiscoverActivity", 2, "startWebSoRequestWithCheck name:" + paramDiscoverTab.a);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("tab", paramDiscoverTab);
    this.a.a("cmd.discover.startWebSoRequestWithCheck", localBundle, false);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.a.a("cmd.getDynamicSelnum", localBundle, true);
  }
  
  public void b(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoStates", paramArrayList2);
    this.a.a("cmd.videoSetState", localBundle, false);
  }
  
  public void c()
  {
    this.a.a("cmd.stopPlay", null, false);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.Prepath", paramString);
    this.a.a("cmd.addPreUploadTak", localBundle, true);
  }
  
  public void d()
  {
    this.a.a("cmd.getPlayingSong", null, true);
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.a.a("cmd.troop.download.photo", localBundle, true);
  }
  
  public void e()
  {
    this.a.a("cmd.getPlayMode", null, true);
  }
  
  public void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.a.a("cmd.troop.cancel.download.photo", localBundle, false);
  }
  
  public void f()
  {
    this.a.a("cmd.notifyPlayListChange", null, false);
  }
  
  public void g()
  {
    Bundle localBundle = new Bundle();
    this.a.a("cmd.cancelAllpreLoad", localBundle, true);
  }
  
  public void h()
  {
    this.a.a("cmd.getDeviceInfos", null, true);
  }
  
  public void i()
  {
    this.a.a("cmd.videoStopAll", null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\remote\logic\RemoteRequestSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */