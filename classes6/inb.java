import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryVideoDes;
import com.tencent.biz.qqstory.pgc.model.VideoInfo;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class inb
  extends QQStoryObserver
{
  public inb(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    String str;
    if ((paramBoolean) && (paramList != null) && (this.a.a != null) && (this.a.a.videoDes != null))
    {
      str = this.a.a.videoDes.vid;
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramList.next();
      if ((localVideoInfo != null) && (!TextUtils.isEmpty(localVideoInfo.a)) && (localVideoInfo.a.equals(str)))
      {
        this.a.a(localVideoInfo);
      }
      else
      {
        StoryReportor.b("story_play", "content_video_play", 0, 1, new String[] { this.a.a(), StoryReportor.a(this.a.getContext().getApplicationContext()), "1", this.a.b() });
        continue;
        if (!paramBoolean) {
          StoryReportor.b("story_play", "content_video_play", 0, 1, new String[] { this.a.a(), StoryReportor.a(this.a.getContext().getApplicationContext()), "2", this.a.b() });
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */