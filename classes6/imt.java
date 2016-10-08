import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.biz.qqstory.view.widget.QQStoryWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;

public class imt
  implements Runnable
{
  public imt(PostContentView paramPostContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (this.a.f) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryWebView.loadUrl("javascript:try{networkChange(" + NetworkUtil.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity) + ");}catch(e){}");
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */