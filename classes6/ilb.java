import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker.CheckResultListener;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ilb
  implements PGCUrlChecker.CheckResultListener
{
  ilb(ila paramila)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ((StoryManager)SuperManager.a(5)).b().a(IPreloadVideoSource.e, (String)localEntry.getKey(), (List)localEntry.getValue(), false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */