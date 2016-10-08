import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ous
  extends Handler
{
  WeakReference a;
  
  public ous(QzoneHbFragment paramQzoneHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramQzoneHbFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QzoneHbFragment localQzoneHbFragment = (QzoneHbFragment)this.a.get();
    if (localQzoneHbFragment == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      if ((!TextUtils.isEmpty(QzoneHbFragment.a(localQzoneHbFragment))) && (localQzoneHbFragment.isAdded()) && (localQzoneHbFragment.getActivity().getAppRuntime() != null))
      {
        QzoneHbFragment.a(localQzoneHbFragment, PreloadImgManager.a().a((QQAppInterface)localQzoneHbFragment.getActivity().getAppRuntime(), QzoneHbFragment.a(localQzoneHbFragment)));
        if (QzoneHbFragment.a(localQzoneHbFragment) != null)
        {
          QzoneHbFragment.a(localQzoneHbFragment, new BitmapDrawable(localQzoneHbFragment.getResources(), QzoneHbFragment.a(localQzoneHbFragment)));
          QzoneHbFragment.a(localQzoneHbFragment).setImageDrawable(QzoneHbFragment.a(localQzoneHbFragment));
        }
      }
    } while (TextUtils.isEmpty(QzoneHbFragment.b(localQzoneHbFragment)));
    QzoneHbFragment.a(localQzoneHbFragment).setText(QzoneHbFragment.b(localQzoneHbFragment));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ous.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */