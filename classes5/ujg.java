import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.ArrayList;
import java.util.List;

public class ujg
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList;
  
  public ujg(StatusHistoryActivity paramStatusHistoryActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity).inflate(2130904621, null);
    }
    paramView = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131303364);
    localImageView.setContentDescription("头像");
    if (paramView.equals(StatusHistoryActivity.a))
    {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841867));
      localImageView.setContentDescription("更多");
      return paramViewGroup;
    }
    localImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.app, paramView, (byte)3));
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */