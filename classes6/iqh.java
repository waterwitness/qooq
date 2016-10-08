import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.ProgressView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqh
  implements Runnable
{
  public iqh(QQStoryBaseActivity paramQQStoryBaseActivity, Context paramContext, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.a = new QQStoryBaseActivity.ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b = new Dialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.requestWindowFeature(1);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.setContentView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.setCancelable(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.a.a(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.show();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.b.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */