import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rke
  implements Runnable
{
  public rke(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null)
    {
      ((VipComicMqqManager)this.a.a.getManager(140)).a();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */