import android.content.Context;
import android.widget.Button;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ilu
  extends QQStoryObserver
{
  public ilu(BaseContentPagerView paramBaseContentPagerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo)
  {
    if ((paramBoolean) && (paramUserInfo != null))
    {
      this.a.jdField_a_of_type_Boolean = paramUserInfo.isSubscribe;
      if (this.a.jdField_a_of_type_AndroidWidgetButton != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetButton.setSelected(this.a.jdField_a_of_type_Boolean);
        if (!this.a.jdField_a_of_type_Boolean) {
          break label106;
        }
        this.a.jdField_a_of_type_AndroidWidgetButton.setText("已订阅");
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(DisplayUtil.a(this.a.getContext(), 4.0F));
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130841507, 0, 0, 0);
      }
    }
    return;
    label106:
    this.a.jdField_a_of_type_AndroidWidgetButton.setText("订阅");
    this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(DisplayUtil.a(this.a.getContext(), 0.0F));
    this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    this.a.jdField_a_of_type_Boolean = paramBoolean2;
    if (paramBoolean1)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetButton != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.isSubscribe = this.a.jdField_a_of_type_Boolean;
        if (!this.a.jdField_a_of_type_Boolean) {
          break label158;
        }
        this.a.jdField_a_of_type_AndroidWidgetButton.setText("已订阅");
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(DisplayUtil.a(this.a.getContext(), 4.0F));
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130841507, 0, 0, 0);
        paramString = (QQStoryManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
        if ((!paramString.b()) && (this.a.b))
        {
          paramString.a();
          this.a.g();
        }
      }
      for (;;)
      {
        this.a.b = false;
        return;
        label158:
        this.a.jdField_a_of_type_AndroidWidgetButton.setText("订阅");
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablePadding(DisplayUtil.a(this.a.getContext(), 0.0F));
        this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
    Context localContext = this.a.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean2) {}
    for (paramString = "订阅";; paramString = "取消订阅")
    {
      QQToast.a(localContext, paramString + "失败，请重试", 0).a();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */