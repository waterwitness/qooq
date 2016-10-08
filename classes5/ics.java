import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

public class ics
  extends MessageObserver
{
  public ics(ServiceAccountFolderManager paramServiceAccountFolderManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ServiceAccountFolderManager.b(), 2, "onUpdateSendMsgError->uin:" + paramString1 + ", type:" + paramInt1 + ", uniseq:" + paramLong2 + ", errorCode:" + paramInt2);
    }
    ServiceAccountFolderManager.a(this.a, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ServiceAccountFolderManager.b(), 2, "onSendResult->puin:" + paramString + ", isSuccess:" + paramBoolean);
    }
    ServiceAccountFolderManager.a(this.a, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */