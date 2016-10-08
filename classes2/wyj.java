import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wyj
  implements ActionSheet.OnButtonClickListener
{
  public wyj(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.b == 1) {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.g(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity).dismiss();
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e();
        continue;
        if (paramInt == 0) {
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.g(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */