import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.activity.BlessPTVActivity.MusicListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class kqw
  implements Runnable
{
  public kqw(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicListAdapter.a(BlessPTVActivity.a(this.a));
    int j = this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int k = this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    if (i > k)
    {
      int m = AIOUtils.a(64.0F, this.a.getResources());
      this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.c(m * (i - (j + k) / 2 - 1));
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " selection = " + i + " lp  = " + k + " fp = " + j);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */