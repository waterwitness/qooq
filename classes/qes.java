import android.os.Message;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qes
  implements INetInfoHandler
{
  private qes(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if (1 == paramInt) {
      this.a.F();
    }
    while (2 != paramInt) {
      return;
    }
    this.a.G();
  }
  
  public void onNetMobile2None()
  {
    a(3, "onNetMobile2None");
    ReportLog.a("Network", "onNetMobile2None()");
    MqqHandler localMqqHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, QQAppInterface.a(this.a).getString(2131367256)).sendToTarget();
    }
    localMqqHandler = this.a.a(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().b();
    this.a.a().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.i(this.a) != null) {
      QQAppInterface.j(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(2, "onNetMobile2Wifi");
    ReportLog.a("Network", "onNetMobile2Wifi()");
    MqqHandler localMqqHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().b();
    this.a.a().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.g(this.a) != null) {
      QQAppInterface.h(this.a).onNetMobile2Wifi(paramString);
    }
    this.a.a();
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    ReadInJoyUtils.b(this.a);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1, "onNetNone2Mobile");
    ReportLog.a("Network", "onNetNone2Mobile()");
    MqqHandler localMqqHandler = this.a.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.a(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = this.a.a(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(26).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().b();
    this.a.a().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.b(this.a).onNetNone2Mobile(paramString);
    }
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    paramString = this.a.a(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    StructMsgVideoController.a().b();
    NowVideoController.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2, "onNetNone2Wifi");
    ReportLog.a("Network", "onNetNone2Wifi()");
    MqqHandler localMqqHandler = this.a.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.a(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = this.a.a(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(26).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().b();
    this.a.a().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.e(this.a) != null) {
      QQAppInterface.f(this.a).onNetNone2Wifi(paramString);
    }
    this.a.a();
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    ReadInJoyUtils.b(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(1, "onNetWifi2Mobile");
    Object localObject = PresendPicMgrService.a();
    if (localObject != null) {
      ((PresendPicMgrService)localObject).b();
    }
    ReportLog.a("Network", "onNetWifi2Mobile()");
    localObject = this.a.a(FileManagerNotifyCenter.class);
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    localObject = this.a.a(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().b();
    this.a.a().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.c(this.a) != null) {
      QQAppInterface.d(this.a).onNetWifi2Mobile(paramString);
    }
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    paramString = this.a.a(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetWifi2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    StructMsgVideoController.a().b();
    NowVideoController.a().b();
  }
  
  public void onNetWifi2None()
  {
    a(3, "onNetWifi2None");
    ReportLog.a("Network", "onNetWifi2None()");
    MqqHandler localMqqHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, QQAppInterface.b(this.a).getString(2131367256)).sendToTarget();
    }
    localMqqHandler = this.a.a(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().b();
    this.a.a().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.k(this.a) != null) {
      QQAppInterface.l(this.a).onNetWifi2None();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */