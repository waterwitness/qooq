import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.InfoCardOnDismissListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.TipsView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imi
  extends QQStoryObserver
{
  public imi(InfoCardDialog paramInfoCardDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo)
  {
    if (paramBoolean) {
      this.a.a(paramUserInfo);
    }
  }
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo)
  {
    super.a(paramBoolean, paramQQStoryUserInfo);
    TextView localTextView;
    if (paramBoolean)
    {
      localTextView = (TextView)this.a.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297843);
      if (this.a.jdField_a_of_type_Int != 6) {
        break label76;
      }
      if (paramQQStoryUserInfo.isAllowed == 1)
      {
        localTextView.setText("对他可见");
        this.a.d = false;
      }
    }
    else
    {
      return;
    }
    localTextView.setText("不让他看");
    this.a.d = true;
    return;
    label76:
    if (paramQQStoryUserInfo.isInterested == 1)
    {
      localTextView.setText("已屏蔽");
      this.a.c = false;
      return;
    }
    localTextView.setText("屏蔽");
    this.a.c = true;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    if ((paramBoolean1) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null))
    {
      this.a.jdField_b_of_type_Boolean = paramBoolean2;
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.isSubscribe = paramBoolean2;
      InfoCardDialog.a(this.a, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type);
      if (paramBoolean2)
      {
        QQStoryManager localQQStoryManager = (QQStoryManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
        if (!localQQStoryManager.b())
        {
          localQQStoryManager.a();
          if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type != 1) {
            break label195;
          }
          TipsView.a(this.a.getContext(), this.a.jdField_a_of_type_AndroidWidgetLinearLayout, "关注成功，可在首页“好友更新”中查看TA的日迹。", 1, 3, 0);
          StoryReportor.a("new_guide", "vip_card", this.a.jdField_a_of_type_Int, 0, new String[] { paramString });
        }
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewInfoCardOnDismissListener != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewInfoCardOnDismissListener.a(true);
        this.a.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.isSubscribe;
      }
      return;
      label195:
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type == 0)
      {
        TipsView.a(this.a.getContext(), this.a.jdField_a_of_type_AndroidWidgetLinearLayout, "订阅成功，新日迹将在首页优先展示。", 1, 3, 0);
        StoryReportor.a("new_guide", "mini_card", this.a.jdField_a_of_type_Int, 0, new String[] { paramString });
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3);
    TextView localTextView;
    if (paramBoolean1)
    {
      localTextView = (TextView)this.a.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297843);
      if ((this.a.jdField_a_of_type_Int != 6) || (!paramBoolean3)) {
        break label80;
      }
      if (!paramBoolean2) {
        break label64;
      }
      localTextView.setText("对他可见");
      this.a.d = false;
    }
    label64:
    label80:
    while ((this.a.jdField_a_of_type_Int == 6) || (paramBoolean3))
    {
      return;
      localTextView.setText("不让他看");
      this.a.d = true;
      return;
    }
    if (paramBoolean2)
    {
      localTextView.setText("已屏蔽");
      this.a.c = false;
      return;
    }
    localTextView.setText("屏蔽");
    this.a.c = true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */