import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.VideoFeedsViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class ibj
  implements INetInfoHandler
{
  public ibj(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetMobile2None()
  {
    ReadInJoyBaseAdapter.a(this.a).b(false);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
      }
    } while (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a());
    ReadInJoyBaseAdapter.a(this.a).post(new ibt(this));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ReadInJoyBaseAdapter.a(this.a).b(true);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
      }
    } while ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()));
    ReadInJoyBaseAdapter.a(this.a).post(new ibs(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ReadInJoyBaseAdapter.a(this.a).b(false);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
      }
      if ((!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()) && (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()) && (ReadInJoyBaseAdapter.a(this.a).a()))
      {
        ReadInJoyBaseAdapter.a(this.a).post(new ibk(this));
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder == null) || (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() != this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.a.a) || (!ReadInJoyBaseAdapter.a(this.a).a()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "continue to play before video ,id : " + this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b());
    }
    ReadInJoyBaseAdapter.a(this.a).post(new ibl(this));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ReadInJoyBaseAdapter.a(this.a).b(true);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
      }
      if ((!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()) && (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()))
      {
        ReadInJoyBaseAdapter.a(this.a).post(new ibq(this));
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder == null) || (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() != this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "continue to play before video ,id : " + this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b());
    }
    ReadInJoyBaseAdapter.a(this.a).post(new ibr(this));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
      }
    } while ((this.a.c) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder == null));
    ReadInJoyBaseAdapter.a(this.a).post(new ibm(this));
  }
  
  public void onNetWifi2None()
  {
    ReadInJoyBaseAdapter.a(this.a).b(false);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none");
    }
    ReadInJoyBaseAdapter.a(this.a).post(new ibu(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */