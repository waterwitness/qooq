import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenActionManager.MagicfaceActionListener;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;

public class ylh
  implements QzoneGiftFullScreenActionManager.MagicfaceActionListener
{
  public ylh(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController, long paramLong, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
    boolean bool = this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.b();
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a(bool);
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_AndroidOsHandler.post(new yli(this, paramActionGlobalData));
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_AndroidOsHandler.post(new ylj(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */