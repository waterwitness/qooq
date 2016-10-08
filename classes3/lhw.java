import QQService.TagInfo;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

class lhw
  implements CompoundButton.OnCheckedChangeListener
{
  lhw(lhv paramlhv, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.app.cn)
      {
        this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Lhv.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Lhx != null) {
        this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Lhx.notifyDataSetChanged();
      }
      return;
      paramCompoundButton.setChecked(false);
      continue;
      int i = 0;
      while (i < this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((TagInfo)this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).iTagId == ((TagInfo)this.jdField_a_of_type_Lhv.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).iTagId)
        {
          this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.remove(i);
          this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.jdField_a_of_type_Lhv.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size());
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */