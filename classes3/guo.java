import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.InviteStartAudioDialog;
import com.tencent.av.ui.InviteStartAudioDialog.ViewHolder;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;

public class guo
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  private guo(InviteStartAudioDialog paramInviteStartAudioDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    InviteBaseData localInviteBaseData1 = new InviteBaseData();
    localInviteBaseData1.c = 0;
    localInviteBaseData1.a = InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog).f();
    localInviteBaseData1.b = InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog).b();
    InviteBaseData localInviteBaseData2 = new InviteBaseData();
    localInviteBaseData2.d = 1;
    this.jdField_a_of_type_JavaUtilList.add(localInviteBaseData1);
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_JavaUtilList.add(localInviteBaseData2);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog)).inflate(2130903571, null);
      paramViewGroup = new InviteStartAudioDialog.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299298));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297384));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131299299));
      paramView.setTag(paramViewGroup);
    }
    InviteBaseData localInviteBaseData;
    for (;;)
    {
      localInviteBaseData = (InviteBaseData)getItem(paramInt);
      if (localInviteBaseData.d != 1) {
        break;
      }
      paramViewGroup.b.setText(2131372470);
      paramViewGroup.b.setTextColor(InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog).getResources().getColor(2131427727));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838981);
      return paramView;
      paramViewGroup = (InviteStartAudioDialog.ViewHolder)paramView.getTag();
      InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog, paramViewGroup);
    }
    paramViewGroup.b.setText(localInviteBaseData.b);
    Bitmap localBitmap = InviteStartAudioDialog.a(this.jdField_a_of_type_ComTencentAvUiInviteStartAudioDialog, localInviteBaseData);
    if (localBitmap != null)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.d(localInviteBaseData.b));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */