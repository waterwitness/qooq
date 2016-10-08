import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.LinkedList;

public class nvi
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  public nvi(PhotoListPanel paramPhotoListPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getCount() <= 0) {
      return;
    }
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(this.jdField_a_of_type_Int);
    if ((!localLocalMediaInfo.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.d)
      {
        paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131367229), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, paramView);
        paramView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
        paramView.show();
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.jdField_a_of_type_Boolean);
        return;
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.peek());
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h) && (j != -1) && (j != i))
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, 2131367232);
        paramView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
        paramView.show();
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.jdField_a_of_type_Boolean);
        return;
      }
      if ((j == 1) && (i == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.e))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.e > 1) {}
        for (paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131367230), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131367233))
        {
          paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, paramView);
          paramView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.jdField_a_of_type_Boolean);
          return;
        }
      }
    }
    if ((i == 1) && (localLocalMediaInfo.b > this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Long))
    {
      paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, 2131367231);
      paramView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
      paramView.show();
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.jdField_a_of_type_Boolean);
      return;
    }
    if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (localLocalMediaInfo.b > PhotoListPanel.jdField_a_of_type_Int))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131370138), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getDimensionPixelSize(2131492908));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.jdField_a_of_type_Boolean);
      return;
    }
    boolean bool;
    if (!localLocalMediaInfo.jdField_a_of_type_Boolean)
    {
      bool = true;
      localLocalMediaInfo.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.jdField_a_of_type_Boolean);
      if (!localLocalMediaInfo.jdField_a_of_type_Boolean) {
        break label710;
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(localLocalMediaInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.add(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.indexOf(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
      ((NumberCheckBox)this.jdField_a_of_type_AndroidWidgetCheckBox).setCheckedNumber(i + 1);
      PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      ReportController.b(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h();
      return;
      bool = false;
      break;
      label710:
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.remove(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.remove(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
      PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */