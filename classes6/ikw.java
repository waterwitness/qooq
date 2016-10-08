import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ikw
  implements DialogInterface.OnDismissListener
{
  public ikw(QQStoryDiscoverActivity paramQQStoryDiscoverActivity, View paramView, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ThreadManager.c().postDelayed(new ikx(this), 150L);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */