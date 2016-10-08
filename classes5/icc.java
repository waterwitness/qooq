import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class icc
  implements DialogInterface.OnClickListener
{
  public icc(ReadInJoyListViewGroup paramReadInJoyListViewGroup, VideoPlayManager.VideoPlayParam paramVideoPlayParam, ArticleInfo paramArticleInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ReportController.b(null, "CliOper", "", "", "0X80069AC", "0X80069AC", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID), "", "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mVideoVid);
    paramDialogInterface.dismiss();
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, System.currentTimeMillis());
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).notifyDataSetChanged();
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */