import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem;
import java.util.List;

public class wzc
  extends Handler
{
  public static final int a = 0;
  public static final String a = "data";
  public static final int b = 1;
  public static final int c = 2;
  
  public wzc(QidianProfileCardActivity paramQidianProfileCardActivity)
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
      super.handleMessage(paramMessage);
      return;
      try
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a.getResources(), this.a.jdField_a_of_type_AndroidGraphicsBitmap);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localBitmapDrawable);
      }
      catch (Exception localException) {}
      continue;
      Object localObject = (QidianProfileCardActivity.QidianSimpleProfileItem)paramMessage.getData().getParcelable("data");
      localObject = this.a.a((QidianProfileCardActivity.QidianSimpleProfileItem)localObject);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = this.a.c;
        this.a.b.addView((View)localObject, localLayoutParams);
        continue;
        localObject = paramMessage.getData().getParcelableArrayList("data");
        localObject = this.a.a((List)localObject);
        if (localObject != null)
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.leftMargin = this.a.c;
          ((View)localObject).setPadding(0, this.a.d, this.a.c, this.a.d);
          this.a.b.addView((View)localObject, localLayoutParams);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */