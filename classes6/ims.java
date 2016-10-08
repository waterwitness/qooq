import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ims
  extends QQStoryObserver
{
  public ims(PostContentView paramPostContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (paramBoolean2) {}
    for (paramString = "sub";; paramString = "un_sub")
    {
      String str2 = (String)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      String str1 = "{\"ret\":0}";
      if (!paramBoolean1) {
        str1 = "{\"ret\":1}";
      }
      if ((paramBoolean1) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.a != null)) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.a.isSubscribe = paramBoolean2;
      }
      PostContentView.a(this.a, str2, str1);
      this.a.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ims.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */