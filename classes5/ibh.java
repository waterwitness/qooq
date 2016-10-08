import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ThreadPriorityUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class ibh
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  final double jdField_b_of_type_Double;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  long c;
  
  public ibh(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Long = 0L;
    this.c = 0L;
    this.jdField_b_of_type_Double = 350.0D;
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Double > 0.0D)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Double < 350.0D) {
        bool1 = true;
      }
    }
    QLog.d("canCheckPlay", 2, "result = " + bool1 + ", scrollSpeed: " + this.jdField_a_of_type_Double);
    return bool1;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.z = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    if ((paramAbsListView instanceof ReadInJoyXListView)) {
      ((ReadInJoyXListView)paramAbsListView).a(paramAbsListView, paramInt);
    }
    if (paramInt == 0)
    {
      if (ReadInJoyUtils.a()) {
        DropFrameMonitor.a().a("list_new_kandian", false);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil.b();
      this.jdField_a_of_type_Boolean = true;
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      ApngImage.resumeAll();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
      }
      if (this.jdField_b_of_type_Boolean) {
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentWidgetListView.t(), ReadInJoyBaseAdapter.c());
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentWidgetListView.t() < ReadInJoyBaseAdapter.d()) {
          ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
        }
        switch (paramInt)
        {
        default: 
          ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).removeMessages(1001);
          return;
          ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentWidgetListView.s() - ReadInJoyBaseAdapter.c(), ReadInJoyBaseAdapter.c());
        }
      }
    }
    if (ReadInJoyUtils.a()) {
      DropFrameMonitor.a().a("list_new_kandian");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil.a();
    boolean bool;
    if ((ReadInJoyBaseAdapter.u == 2) || (ReadInJoyBaseAdapter.u == 3)) {
      if (paramInt == 2) {
        bool = ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView);
      }
    }
    for (;;)
    {
      label281:
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged fling");
        }
        URLDrawable.resume();
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        break;
        if (paramInt != 1) {
          break label386;
        }
        if (DeviceInfoUtil.b() > 1)
        {
          bool = true;
          break label281;
        }
        bool = false;
        break label281;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "pause image onScrollStateChanged fling");
        }
        URLDrawable.pause();
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
      }
      if (ReadInJoyBaseAdapter.u != 1) {
        break;
      }
      break;
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView, 500);
      return;
      label386:
      bool = false;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView instanceof ReadInJoyXListView)) {
      ((ReadInJoyXListView)paramAbsListView).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    View localView = paramAbsListView.getChildAt(0);
    if (localView != null) {
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
    label160:
    label304:
    label312:
    do
    {
      do
      {
        boolean bool;
        do
        {
          long l1;
          long l2;
          long l3;
          do
          {
            return;
            this.jdField_b_of_type_Long = (localView.getHeight() * paramInt1 - localView.getTop());
            l1 = this.jdField_b_of_type_Long;
            l2 = this.c;
            l3 = System.currentTimeMillis();
          } while (l3 == this.jdField_a_of_type_Long);
          this.jdField_a_of_type_Double = ((l1 - l2) * 1000L / (l3 - this.jdField_a_of_type_Long));
          this.jdField_a_of_type_Long = l3;
          this.c = this.jdField_b_of_type_Long;
          if (a(paramAbsListView)) {
            ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView, 20);
          }
          if (paramInt1 <= this.jdField_a_of_type_Int) {
            break;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Int = paramInt1;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.z != 2) {
            break label312;
          }
          if ((ReadInJoyBaseAdapter.u != 2) && (ReadInJoyBaseAdapter.u != 3)) {
            break label304;
          }
          bool = ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView);
        } while (this.jdField_a_of_type_Boolean == bool);
        if (bool)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScroll ");
          }
          URLDrawable.resume();
          AbstractGifImage.resumeAll();
          ApngImage.resumeAll();
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          return;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
          this.c = 0L;
          break;
          if (paramInt1 >= this.jdField_a_of_type_Int) {
            break label160;
          }
          this.jdField_b_of_type_Boolean = false;
          break label160;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "pause image onScroll ");
          }
          URLDrawable.pause();
          AbstractGifImage.pauseAll();
          ApngImage.pauseAll();
        }
      } while (ReadInJoyBaseAdapter.u != 1);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.z != 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */