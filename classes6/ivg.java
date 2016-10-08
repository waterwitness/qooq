import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.VideoEffectsFilterData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ivg
  extends iva
{
  int jdField_a_of_type_Int;
  final ImageView jdField_a_of_type_AndroidWidgetImageView;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  NewStoryFilterViewPagerController.VideoEffectsFilterData jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData;
  
  private ivg(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296792));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296303));
  }
  
  int a()
  {
    return 1;
  }
  
  protected View a(Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2130904451, paramViewGroup, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(NewStoryFilterViewPagerController.VideoEffectsFilterData paramVideoEffectsFilterData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData = paramVideoEffectsFilterData;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData.a);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData.f != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$VideoEffectsFilterData.f);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */