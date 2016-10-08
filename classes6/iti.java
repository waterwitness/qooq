import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

class iti
  implements DialogInterface.OnClickListener
{
  iti(ith paramith)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.a != null) && (this.a.a.user != null))
    {
      ((QQStoryHandler)QQStoryContext.a().a().a(98)).a(1, this.a.a.user.getUnionId(), 1, 2);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(String.valueOf(this.a.a.user.uid));
      StoryListUtils.a(localArrayList);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */