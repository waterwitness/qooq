import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class lie
  implements View.OnClickListener
{
  public lie(EmosmActivity paramEmosmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131370274);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(true);
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
    }
    while ((this.a.e != 2) && (this.a.e != 1)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131370271);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
    this.a.b();
    this.a.b = false;
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */