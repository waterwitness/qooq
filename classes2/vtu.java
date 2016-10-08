import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class vtu
  extends TroopFeedViewFactory.ViewProvider
{
  public vtu(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2130903879, null);
    }
    paramView = (vtv)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new vtv(this);
      ((vtv)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131299762));
      ((vtv)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297123));
      ((vtv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131300547));
      ((vtv)localObject).b = ((TextView)localView.findViewById(2131300546));
      ((vtv)localObject).c = ((TextView)localView.findViewById(2131300549));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((vtv)localObject).jdField_a_of_type_Int = paramInt;
    ((vtv)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((vtv)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((vtv)localObject).b.setText(paramTroopFeedItem.content);
    ((vtv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.b(paramTroopFeedItem.ex_1))
    {
      ((vtv)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((vtv)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839782);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((vtv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vtu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */