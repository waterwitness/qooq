import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.RecyclerListener;

public class ibg
  implements AbsListView.RecyclerListener
{
  public ibg(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b(View paramView)
  {
    paramView = (ReadInJoyBaseAdapter.ViewHolder)paramView.getTag();
    if ((paramView != null) && ((paramView instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder)))
    {
      paramView = ((ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView).a;
      if ((this.a.a()) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() == paramView.a) && (!ReadInJoyBaseAdapter.b(this.a)))
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramView.a, 3);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onMovedToScrapHeap 1");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onMovedToScrapHeap 2");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */