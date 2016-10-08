import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;

public class yju
  extends FriendListObserver
{
  public static ResultReceiver a;
  private static yju a;
  
  private yju()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static yju a(ResultReceiver paramResultReceiver)
  {
    if (jdField_a_of_type_Yju == null) {
      jdField_a_of_type_Yju = new yju();
    }
    jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
    return jdField_a_of_type_Yju;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = QWalletHelper.a();
      CorpResp localCorpResp = new CorpResp();
      localCorpResp.corpReqType = CorpReq.corpReqType;
      localCorpResp.userNick = ContactUtils.c(localQQAppInterface, paramString, false);
      paramString = new Bundle();
      localCorpResp.toBundle(paramString);
    } while ((paramString == null) || (jdField_a_of_type_AndroidOsResultReceiver == null));
    jdField_a_of_type_AndroidOsResultReceiver.send(0, paramString);
    jdField_a_of_type_AndroidOsResultReceiver = null;
  }
  
  public void d()
  {
    jdField_a_of_type_Yju = null;
    jdField_a_of_type_AndroidOsResultReceiver = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */