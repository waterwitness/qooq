import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class iqd
  extends QQStoryObserver
{
  public iqd(QQStoryShieldListActivity paramQQStoryShieldListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, List paramList, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        paramList = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
        if (this.a.d == 2) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramList.a(paramArrayOfByte, 10, paramBoolean1);
          return;
        }
      }
      QQStoryShieldListActivity.a(this.a);
      this.a.a(paramList);
      return;
    }
    QQStoryShieldListActivity.b(this.a);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    if (paramBoolean1)
    {
      List localList = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(paramBoolean3);
      this.a.a(localList);
      return;
    }
    QQToast.a(this.a, 2131371675, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */