import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashSet;

public class njs
  implements Runnable
{
  public njs(FlashPicItemBuilder.FlashPicAIOThumbView paramFlashPicAIOThumbView, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      synchronized (BaseApplicationImpl.a)
      {
        String str = HotChatHelper.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
        BaseApplicationImpl.a.put(str, this.jdField_a_of_type_ComTencentImageURLDrawable);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.b) {
          FlashPicItemBuilder.a().add(str);
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "cache flashpic abumb exception:" + localException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\njs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */