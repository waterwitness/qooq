import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class ijc
  implements Comparator
{
  public ijc(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    if (paramStoryVideoItem1.mCreateTime > paramStoryVideoItem2.mCreateTime) {
      return 1;
    }
    if (paramStoryVideoItem1.mCreateTime < paramStoryVideoItem2.mCreateTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */