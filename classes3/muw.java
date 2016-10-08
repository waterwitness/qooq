import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class muw
  implements View.OnClickListener
{
  public muw(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    String str;
    label273:
    label407:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            boolean bool1;
            do
            {
              do
              {
                do
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnKickOutBtnClickListener onclick");
                  }
                  i = paramView.getId();
                  str = (String)paramView.getTag();
                  if (i != 2131298073) {
                    break label273;
                  }
                  paramView = paramView.findViewById(2131298074);
                  bool1 = bool2;
                  if (paramView.getTag() != null)
                  {
                    bool1 = bool2;
                    if ((paramView.getTag() instanceof Boolean)) {
                      bool1 = ((Boolean)paramView.getTag()).booleanValue();
                    }
                  }
                  paramView = this.a.a(str, bool1);
                  if (!bool1) {
                    break;
                  }
                } while (this.a.jdField_J_of_type_JavaLangString.equals(str));
                if (paramView != null) {
                  paramView.a.a(true);
                }
                if (!TextUtils.isEmpty(this.a.jdField_J_of_type_JavaLangString))
                {
                  paramView = this.a.a(this.a.jdField_J_of_type_JavaLangString, bool1);
                  if (paramView != null) {
                    paramView.a.b(true);
                  }
                }
                this.a.jdField_J_of_type_JavaLangString = str;
                return;
              } while (this.a.I.equals(str));
              if (paramView != null) {
                paramView.a.a(true);
              }
              if (!TextUtils.isEmpty(this.a.I))
              {
                paramView = this.a.a(this.a.I, bool1);
                if (paramView != null) {
                  paramView.a.b(true);
                }
              }
              this.a.I = str;
              return;
              if (i != 2131298072) {
                break label407;
              }
              paramView = paramView.findViewById(2131301785);
              bool1 = bool3;
              if (paramView.getTag() != null)
              {
                bool1 = bool3;
                if ((paramView.getTag() instanceof Boolean)) {
                  bool1 = ((Boolean)paramView.getTag()).booleanValue();
                }
              }
              if (!bool1) {
                break;
              }
              paramView = this.a.a(this.a.jdField_J_of_type_JavaLangString, bool1);
            } while (paramView == null);
            paramView.a.b(true);
            this.a.jdField_J_of_type_JavaLangString = "";
            return;
            paramView = this.a.a(this.a.I, bool1);
          } while (paramView == null);
          paramView.a.b(true);
          this.a.I = "";
          return;
        } while ((i != 2131301787) || (!this.a.jdField_b_of_type_Boolean));
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "delBtn onClick, uin=" + str);
        }
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break;
        }
      } while (!this.a.isResume());
      QQToast.a(this.a, this.a.getString(2131369008), 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_J_of_type_Int == 1)
      {
        this.a.d(str);
        return;
      }
      if (this.a.jdField_J_of_type_Int != 13) {
        break;
      }
      paramView = this.a.a(str);
      this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
    } while (!this.a.jdField_b_of_type_AndroidAppDialog.isShowing());
    if (paramView != null) {
      this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
    return;
    paramView = new Dialog(this.a, 2131558973);
    paramView.setContentView(2130903341);
    ((TextView)paramView.findViewById(2131297840)).setText(this.a.getString(2131367359));
    TextView localTextView = (TextView)paramView.findViewById(2131296852);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131298193);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localTextView.setText(this.a.getString(2131367368));
    localCheckBox.setText(this.a.getString(2131367369));
    localTextView = (TextView)paramView.findViewById(2131297843);
    Object localObject = (TextView)paramView.findViewById(2131297844);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new mux(this, paramView));
    ((TextView)localObject).setOnClickListener(new muy(this, str, localCheckBox, paramView));
    paramView.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */