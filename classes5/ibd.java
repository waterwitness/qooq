import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

public class ibd
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  public ibd(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, ReadInJoyBaseAdapter.ViewHolder paramViewHolder, Long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView, int paramInt, ArrayList paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      ((Animation)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$ViewHolder.b.getTag(2131296653)).setAnimationListener(new ibe(this, paramArrayList));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$ViewHolder.b.startAnimation((Animation)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$ViewHolder.b.getTag(2131296653));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */