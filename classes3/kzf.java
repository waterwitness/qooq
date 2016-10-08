import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

public class kzf
  implements Runnable
{
  public kzf(ChatSettingForTroop paramChatSettingForTroop, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b.size();
    int i = 0;
    for (;;)
    {
      ImageView localImageView;
      Object localObject;
      if (i < j)
      {
        localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b.get(i);
        localObject = (String)localImageView.getTag();
      }
      try
      {
        long l = Long.valueOf((String)localObject).longValue();
        if (l == this.jdField_a_of_type_Long)
        {
          localObject = ImageUtil.a();
          localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, 1, Long.toString(this.jdField_a_of_type_Long), 3, (Drawable)localObject, (Drawable)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.runOnUiThread(new kzg(this, localImageView, (FaceDrawable)localObject));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */