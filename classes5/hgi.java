import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardSameCity;
import com.tencent.biz.addContactTroopView.TroopCardSameCity.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item2;

public class hgi
  extends BaseAdapter
{
  public hgi(TroopCardSameCity paramTroopCardSameCity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    if (this.a.a != null) {
      return this.a.a.size();
    }
    return 0;
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
    Object localObject;
    if (paramView == null)
    {
      localObject = new TroopCardSameCity.ViewHolder();
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2130903639, paramViewGroup, false);
      ((TroopCardSameCity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299534));
      ((TroopCardSameCity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299536));
      ((TroopCardSameCity.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131299537));
      paramView.setTag(localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (TroopCardSameCity.ViewHolder)paramView.getTag())
    {
      localObject = (searchtab.Item2)this.a.a.get(paramInt);
      paramInt = AIOUtils.a(38.0F, this.a.getResources());
      int i = AIOUtils.a(57.0F, this.a.getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(((searchtab.Item2)localObject).str_img_url.get(), paramInt, i);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
        localURLDrawable.restartDownload();
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((searchtab.Item2)localObject).str_name.get());
      paramViewGroup.b.setText(((searchtab.Item2)localObject).str_desc.get());
      return paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */