import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;

class ylj
  implements Runnable
{
  ylj(ylh paramylh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.a).setBackgroundColor(0);
    QzoneGiftFullScreenViewController.a(this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController);
    this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController$GiftFullScreenPlayListener.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */