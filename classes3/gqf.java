import android.content.Context;
import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.ui.BeautyToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.widget.BidirectionSeekBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqf
  implements SeekBar.OnSeekBarChangeListener
{
  public gqf(BeautyToolbar paramBeautyToolbar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.jdField_b_of_type_Int != paramInt)
    {
      this.a.b(paramInt);
      this.a.a(paramInt);
      if ((paramInt != 0) || (this.a.jdField_b_of_type_Int <= 0)) {
        break label130;
      }
      this.a.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.a.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setContentDescription(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363736) + paramInt + "%");
      }
      this.a.jdField_b_of_type_Int = paramInt;
      this.a.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a();
      return;
      label130:
      if ((paramInt > 0) && (paramInt <= 30) && ((this.a.jdField_b_of_type_Int <= 0) || (this.a.jdField_b_of_type_Int > 30))) {
        this.a.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.a.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      } else if ((paramInt > 30) && (paramInt <= 60) && ((this.a.jdField_b_of_type_Int <= 30) || (this.a.jdField_b_of_type_Int > 60))) {
        this.a.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.a.c);
      } else if ((paramInt > 60) && (paramInt <= 100) && ((this.a.jdField_b_of_type_Int <= 60) || (this.a.jdField_b_of_type_Int > 100))) {
        this.a.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.a.d);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */