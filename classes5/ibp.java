import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.VideoFeedsViewHolder;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ibp
  implements DialogInterface.OnKeyListener
{
  ibp(ibm paramibm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      ReadInJoyBaseAdapter.a(this.a.a.a).a(false);
      this.a.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(5);
      if ((this.a.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null) && (this.a.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d >= 0))
      {
        paramKeyEvent = this.a.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.a.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d);
        if (paramKeyEvent != null) {
          this.a.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramKeyEvent);
        }
      }
      paramDialogInterface.dismiss();
      bool = true;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */