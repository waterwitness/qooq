import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.FriendListOpenFrame;
import com.tencent.open.agent.FriendListOpenFrame.ViewHolder;

public class wrf
  extends Handler
{
  public wrf(FriendListOpenFrame paramFriendListOpenFrame)
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
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 40, 0);
      return;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      return;
      String str = paramMessage.getData().getString("url");
      paramMessage = (Bitmap)paramMessage.obj;
      int j = this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        FriendListOpenFrame.ViewHolder localViewHolder = (FriendListOpenFrame.ViewHolder)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i).getTag();
        if ((localViewHolder != null) && (str.equals(localViewHolder.a)))
        {
          localViewHolder.b.setImageBitmap(paramMessage);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */