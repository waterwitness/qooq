import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class itf
  implements DialogInterface.OnClickListener
{
  public itf(StoryListPresenter paramStoryListPresenter, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_JavaLangString)) {
      StoryListPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      StoryListPresenter.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */