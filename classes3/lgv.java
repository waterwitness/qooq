import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class lgv
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public lgv(DiscussionMemberActivity paramDiscussionMemberActivity, List paramList)
  {
    super(paramDiscussionMemberActivity, paramDiscussionMemberActivity.app, paramDiscussionMemberActivity.a, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    lgs locallgs = (lgs)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (locallgs != null)
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = locallgs.jdField_a_of_type_JavaLangString;
      localFaceInfo.jdField_a_of_type_Int = 1;
    }
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    lgs locallgs;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2130903328, paramViewGroup, false);
      paramViewGroup = new lgx(null);
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131298136));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131297466));
      paramView.setTag(paramViewGroup);
      locallgs = (lgs)getItem(paramInt);
      if (locallgs != null)
      {
        if ((locallgs.b != null) && (!"".equals(locallgs.b.trim()))) {
          break label149;
        }
        paramViewGroup.a.setText(locallgs.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramViewGroup.b = locallgs.jdField_a_of_type_JavaLangString;
      paramViewGroup.d.setImageBitmap(a(1, locallgs.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (lgx)paramView.getTag();
      break;
      label149:
      paramViewGroup.a.setText(locallgs.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */