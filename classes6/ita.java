import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ita
  implements DialogInterface.OnClickListener
{
  public ita(StoryListPresenter paramStoryListPresenter, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.c(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ita.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */