import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nmz
  implements ActionSheet.OnButtonClickListener
{
  public nmz(PicItemBuilder paramPicItemBuilder, MessageForPic paramMessageForPic, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    label172:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.b < 500L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.b = l;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((paramView != null) && ((paramView instanceof BaseTransProcessor)))
      {
        paramView = (BaseTransProcessor)paramView;
        if ((paramView.b()) && (paramView.c()))
        {
          paramInt = 1;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq));
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          break label172;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        break;
        paramInt = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */