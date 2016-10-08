import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class hrj
  implements BusinessObserver
{
  public hrj(VideoListView paramVideoListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoListView", 2, "getPublicAccountName() isSuccess=" + paramBoolean);
        }
        if (paramBundle != null)
        {
          Object localObject = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          ((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get() == 0)
          {
            paramBundle = new AccountDetail((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject);
            if (paramBundle.followType == 1)
            {
              localObject = (TextView)this.a.a.findViewById(2131298766);
              if (localObject != null)
              {
                ((TextView)localObject).setText("已关注");
                ((TextView)localObject).setTextColor(872415231);
                ((TextView)localObject).setBackgroundDrawable(null);
                ((TextView)localObject).setOnClickListener(null);
              }
            }
            VideoListView.a(this.a, paramBundle);
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoListView", 2, "response.ret_info.get().ret_code.get() == 0");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.pubaccount.video.VideoListView", 2, "response.ret_info.get().ret_code.get() == " + ((mobileqq_mp.RetInfo)((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get());
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoListView", 2, "Exception e=" + paramBundle.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */