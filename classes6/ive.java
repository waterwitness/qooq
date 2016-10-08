import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.POIFilterData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ive
  extends iva
{
  TextView a;
  
  ive(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302772));
  }
  
  int a()
  {
    return 2;
  }
  
  protected View a(Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2130904473, paramViewGroup, false);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  void a(NewStoryFilterViewPagerController.POIFilterData paramPOIFilterData, int paramInt)
  {
    if (paramPOIFilterData != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramPOIFilterData.a + "，" + paramPOIFilterData.b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */