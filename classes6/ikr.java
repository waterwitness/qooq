import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.pgc.adapter.DiscoverAdapter;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ikr
  implements AdapterView.OnItemLongClickListener
{
  public ikr(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this.a, this.a.app);
    paramAdapterView = this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.a(paramInt).a;
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(paramAdapterView, 2);
    StoryReportor.a("hall", "press", 0, paramAdapterView.type, new String[0]);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */