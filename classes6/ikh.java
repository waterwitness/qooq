import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

class ikh
  implements DialogInterface.OnDismissListener
{
  ikh(ikf paramikf)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!this.a.a.isFinishing()) && (this.a.a.a.size() > this.a.a.h)) {
      ((BaseContentPagerView)this.a.a.a.get(this.a.a.h)).i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */