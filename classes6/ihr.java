import com.tencent.biz.qqstory.base.preload.pgc.PGCPlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker.CheckResultListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import java.util.Map;

public class ihr
  implements PGCUrlChecker.CheckResultListener
{
  public ihr(PGCPlayingListPreloader paramPGCPlayingListPreloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Map paramMap)
  {
    List localList = (List)paramMap.get("playing_list");
    if (localList != null)
    {
      SLog.b("Q.qqstory.download.preload.PGCPlayingListPreloader", "setPlayingList ,video size = " + paramMap.size());
      PGCPlayingListPreloader.a(this.a, localList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */