import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;

public class vfn
  implements Runnable
{
  public vfn(PublicCommentWindow paramPublicCommentWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b = false;
    if ((this.a.isShowing()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842147);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364801));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */