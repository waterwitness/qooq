import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class iqe
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList;
  
  public iqe(QQStoryShieldListActivity paramQQStoryShieldListActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
    super.notifyDataSetChanged();
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
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity).inflate(2130904487, null);
      paramViewGroup = new iqf(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296814));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296829));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a.widthPixels - AIOUtils.a(175.0F, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getResources()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131302902));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
      paramView.setTag(paramViewGroup);
      localObject = (QQStoryUserInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((QQStoryUserInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((QQStoryUserInfo)localObject).nick);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        break label258;
      }
      if (paramInt != 0) {
        break label225;
      }
      paramView.setBackgroundResource(2130838357);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.app.a(((QQStoryUserInfo)localObject).uin, true);
      if (localObject == null) {
        break label315;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      return paramView;
      paramViewGroup = (iqf)paramView.getTag();
      break;
      label225:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramView.setBackgroundResource(2130838352);
      }
      else
      {
        paramView.setBackgroundResource(2130838355);
        continue;
        label258:
        if (this.jdField_a_of_type_JavaUtilList.size() == 2)
        {
          if (paramInt == 0) {
            paramView.setBackgroundResource(2130838357);
          } else {
            paramView.setBackgroundResource(2130838352);
          }
        }
        else if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
          paramView.setBackgroundResource(2130838352);
        }
      }
    }
    label315:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */