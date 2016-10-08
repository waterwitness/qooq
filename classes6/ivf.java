import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.TimeFilterData;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ivf
  extends iva
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  NewStoryFilterViewPagerController.TimeFilterData jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  private ivf(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302946));
    this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302947));
    this.c = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302948));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302949));
  }
  
  int a()
  {
    return 3;
  }
  
  protected View a(Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2130904495, paramViewGroup, false);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData = null;
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130841484);
      return;
    case '1': 
      paramImageView.setImageResource(2130841485);
      return;
    case '2': 
      paramImageView.setImageResource(2130841486);
      return;
    case '3': 
      paramImageView.setImageResource(2130841487);
      return;
    case '4': 
      paramImageView.setImageResource(2130841488);
      return;
    case '5': 
      paramImageView.setImageResource(2130841489);
      return;
    case '6': 
      paramImageView.setImageResource(2130841490);
      return;
    case '7': 
      paramImageView.setImageResource(2130841491);
      return;
    case '8': 
      paramImageView.setImageResource(2130841492);
      return;
    }
    paramImageView.setImageResource(2130841493);
  }
  
  void a(NewStoryFilterViewPagerController.TimeFilterData paramTimeFilterData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData = paramTimeFilterData;
    paramTimeFilterData = new SimpleDateFormat("HH:mm");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData.a = paramTimeFilterData.format(new Date());
    SLog.b("Q.qqstory.record.FilterViewPagerController", "TimeFilterData time:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData.a);
    a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData.a.charAt(0));
    a(this.b, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData.a.charAt(1));
    a(this.c, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData.a.charAt(3));
    a(this.d, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$TimeFilterData.a.charAt(4));
    paramInt = UIUtils.b(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */