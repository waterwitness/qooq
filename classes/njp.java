import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicHolder;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class njp
  implements View.OnClickListener
{
  public njp(FlashPicItemBuilder paramFlashPicItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    MessageForPic localMessageForPic;
    label103:
    for (;;)
    {
      return;
      FlashPicItemBuilder.a(this.a, l);
      paramView = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView);
      if (paramView != null)
      {
        localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (HotChatHelper.a(localMessageForPic)) {}
        for (boolean bool = HotChatHelper.b(localMessageForPic);; bool = FlashPicHelper.b(localMessageForPic))
        {
          if (bool) {
            break label103;
          }
          if (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
            break label105;
          }
          if (paramView.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
            break;
          }
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          return;
        }
      }
    }
    label105:
    FlashPicItemBuilder.a(this.a, localMessageForPic, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\njp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */