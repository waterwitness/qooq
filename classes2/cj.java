import android.view.View;
import com.dataline.activities.RouterAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cj
  implements ActionSheet.OnButtonClickListener
{
  public cj(RouterAdvanceActivity paramRouterAdvanceActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      ((RouterHandler)this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity.app.a(48)).c();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */