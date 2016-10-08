import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hgm
  implements Handler.Callback
{
  public hgm(QQAnonymousDialog paramQQAnonymousDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 291) {
      switch (this.a.f)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(i));
      paramMessage = this.a;
      paramMessage.f += 1;
      if (this.a.f == 4) {
        this.a.f = 0;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(291, 1000L);
      return false;
      i = 2131364926;
      continue;
      i = 2131364927;
      continue;
      i = 2131364928;
      continue;
      i = 2131364929;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */