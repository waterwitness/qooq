import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.GagMemInfo;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mqo
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  public mqo(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(int paramInt)
  {
    TroopGagActivity.GagMemInfo localGagMemInfo = (TroopGagActivity.GagMemInfo)getItem(paramInt);
    if (localGagMemInfo == null) {
      return null;
    }
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = localGagMemInfo.jdField_a_of_type_JavaLangString;
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  protected String a(long paramLong)
  {
    String str = ((TroopGagMgr)this.a.app.getManager(47)).a(this.a, paramLong);
    if (!TextUtils.isEmpty(str)) {
      return "" + str;
    }
    return "";
  }
  
  public int getCount()
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.a.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt > 0)
    {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903670, paramViewGroup, false);
        paramViewGroup = new mqp(this, null);
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131299657));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296932));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299658));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299659));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        TroopGagActivity.GagMemInfo localGagMemInfo = (TroopGagActivity.GagMemInfo)getItem(paramInt);
        paramViewGroup.d.setImageBitmap(a(1, localGagMemInfo.jdField_a_of_type_JavaLangString));
        if ((TextUtils.isEmpty(localGagMemInfo.jdField_b_of_type_JavaLangString)) || (localGagMemInfo.jdField_b_of_type_JavaLangString.equals(localGagMemInfo.jdField_a_of_type_JavaLangString))) {
          localGagMemInfo.jdField_b_of_type_JavaLangString = ((TroopManager)this.a.app.getManager(51)).a(this.a.jdField_b_of_type_JavaLangString, localGagMemInfo.jdField_a_of_type_JavaLangString);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGagMemInfo.jdField_b_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localGagMemInfo);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localGagMemInfo.jdField_a_of_type_Long));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewGroup.jdField_b_of_type_JavaLangString = localGagMemInfo.jdField_a_of_type_JavaLangString;
        if ((!TroopGagActivity.a(this.a, this.a.app.a())) && ((TroopGagActivity.b(this.a, localGagMemInfo.jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, localGagMemInfo.jdField_a_of_type_JavaLangString)))) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
          break;
        }
        paramView.setBackgroundResource(2130838352);
        return paramView;
        paramViewGroup = (mqp)paramView.getTag();
      }
      paramView.setBackgroundResource(2130838357);
      return paramView;
    }
    return this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopGagActivity.GagMemInfo)) {
      return;
    }
    paramView = (TroopGagActivity.GagMemInfo)paramView;
    String str = paramView.jdField_a_of_type_JavaLangString;
    TroopGagMgr localTroopGagMgr = (TroopGagMgr)this.a.app.getManager(47);
    localTroopGagMgr.a(this.a.jdField_b_of_type_JavaLangString, str, 0L);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramView);
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onClick cancelGag, uin=" + str);
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, this.a.jdField_b_of_type_JavaLangString + "", localTroopGagMgr.a(this.a.jdField_b_of_type_JavaLangString), "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */