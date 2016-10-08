import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class lru
  implements View.OnClickListener
{
  public lru(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      int i = ((Integer)paramView.getTag(-1)).intValue();
      if (i > -1)
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.getItem(i);
        if ((localLebaViewItem != null) && (localLebaViewItem.a != null) && (localLebaViewItem.a.uiResId == 3050L)) {
          StoryReportor.a("dynamic", "clk_story", 0, ((TroopRedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).d(), new String[0]);
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QLog.w("Q.lebatab.leba", 2, "" + localNullPointerException);
      }
    }
    this.a.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener.a(this.a.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, paramView, ((Integer)paramView.getTag(-1)).intValue(), 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */