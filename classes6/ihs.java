import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.pgc.PGCPlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker.CheckResultListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import java.util.Map;

public class ihs
  implements PGCUrlChecker.CheckResultListener
{
  public ihs(PGCPlayingListPreloader paramPGCPlayingListPreloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Map paramMap)
  {
    paramMap = (List)paramMap.get("playing_list");
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = (StoryVideoItem)paramMap.get(0);
      this.a.a.a(paramMap.mVid, paramMap.mVideoUrl, 0, true);
      PGCPlayingListPreloader.a(this.a, paramMap.mVid, paramMap.mVideoUrl, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */