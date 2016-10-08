import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.DeviceFriendListOpenFrame;
import com.tencent.open.agent.DeviceFriendListOpenFrame.ViewHolder;

public class wqx
  implements Runnable
{
  public wqx(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame, String paramString, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        DeviceFriendListOpenFrame.ViewHolder localViewHolder = (DeviceFriendListOpenFrame.ViewHolder)this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (this.jdField_a_of_type_JavaLangString.equals(localViewHolder.jdField_a_of_type_JavaLangString))) {
          localViewHolder.b.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */