package cooperation.huangye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import ycv;

public class HYPhoneAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private HYBusinessPhone jdField_a_of_type_CooperationHuangyeHYBusinessPhone;
  
  public HYPhoneAdapter(Context paramContext, HYBusinessPhone paramHYBusinessPhone)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationHuangyeHYBusinessPhone = paramHYBusinessPhone;
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904105, null);
    ycv localycv = new ycv(null);
    localycv.a = ((TextView)paramViewGroup.findViewById(2131301417));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localycv.a.getLayoutParams();
    localLayoutParams.width = AIOUtils.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localycv.a.setLayoutParams(localLayoutParams);
    localycv.b = ((TextView)paramViewGroup.findViewById(2131301418));
    localLayoutParams = (RelativeLayout.LayoutParams)localycv.b.getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.a(170.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localycv.b.setLayoutParams(localLayoutParams);
    paramViewGroup.setTag(localycv);
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (ycv)paramView.getTag();
    paramViewGroup = (String)this.jdField_a_of_type_CooperationHuangyeHYBusinessPhone.a.get(paramInt);
    String str = (String)this.jdField_a_of_type_CooperationHuangyeHYBusinessPhone.b.get(paramInt);
    paramView.a.setText(str);
    paramView.b.setText(paramViewGroup);
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_CooperationHuangyeHYBusinessPhone.a.size();
    if (i > 20) {
      return 20;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView, paramViewGroup);
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYPhoneAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */