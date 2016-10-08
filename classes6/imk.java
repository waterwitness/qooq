import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.biz.qqstory.view.widget.QQStoryWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class imk
  implements Runnable
{
  public imk(PostContentView paramPostContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.a.getHeight();
    int i = j;
    if (!this.a.d) {
      i = j - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 61.0F) - 1;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.setMinHeight(i);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */