import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.net.MalformedURLException;

public class kis
  extends Handler
{
  public kis(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      if ((this.a.isFinishing()) || (AddFriendVerifyActivity.a(this.a) == null)) {
        continue;
      }
      AddFriendVerifyActivity.a(this.a).setVisibility(0);
      ((Animatable)AddFriendVerifyActivity.a(this.a).getDrawable()).start();
      return;
      if (this.a.isFinishing()) {
        continue;
      }
      if (!TextUtils.isEmpty(AddFriendVerifyActivity.b(this.a))) {}
      try
      {
        paramMessage = new File(AddFriendVerifyActivity.c(this.a)).toURL();
        AddFriendVerifyActivity.a(this.a).setImageDrawable(URLDrawable.getDrawable(paramMessage, 100, 100));
        if (AddFriendVerifyActivity.a(this.a) == null) {
          continue;
        }
        AddFriendVerifyActivity.a(this.a).setVisibility(8);
        return;
        QQToast.a(this.a.getApplicationContext(), 1, 2131368757, 0).b(this.a.getTitleBarHeight());
        return;
      }
      catch (MalformedURLException paramMessage)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */