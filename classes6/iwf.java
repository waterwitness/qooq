import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantType;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStorySelectPendant;
import com.tencent.biz.qqstory.takevideo.pendant.PendantPageAdapter;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class iwf
  implements AdapterView.OnItemClickListener
{
  private iwf(NewStorySelectPendant paramNewStorySelectPendant)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    NewStorySelectPendant.a(this.a).setCurrentItem(NewStorySelectPendant.a(this.a).a(paramInt));
    paramView = ((PendantManager)SuperManager.a(11)).a(false);
    paramAdapterView = "";
    if (paramInt < paramView.size()) {
      paramAdapterView = ((NewStoryPendantType)paramView.get(paramInt)).c;
    }
    StoryReportor.a("video_shoot", "clk_effect", 0, 0, new String[] { paramAdapterView });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */