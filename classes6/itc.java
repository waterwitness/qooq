import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class itc
  implements DialogInterface.OnClickListener
{
  public itc(StoryListPresenter paramStoryListPresenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */