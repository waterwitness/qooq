import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;

class iaz
  implements Runnable
{
  iaz(iay paramiay, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!ReadInJoyBaseAdapter.a(this.jdField_a_of_type_Iay.a)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_Iay.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a)));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b = 0L;
      } while ((this.jdField_a_of_type_Iay.a.jdField_a_of_type_ComTencentWidgetListView == null) || (!ReadInJoyBaseAdapter.a(this.jdField_a_of_type_Iay.a).a()));
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g;
      int j = this.jdField_a_of_type_Iay.a.jdField_a_of_type_ComTencentWidgetListView.m();
      this.jdField_a_of_type_Iay.a.jdField_a_of_type_ComTencentWidgetListView.post(new iba(this, i + j));
    } while (!ReadInJoyHelper.a(ReadInJoyUtils.a()));
    QQToast.a(this.jdField_a_of_type_Iay.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */