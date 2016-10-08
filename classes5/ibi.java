import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.OnDrawCompleteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class ibi
  implements ReadInJoyXListView.OnDrawCompleteListener
{
  public ibi(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView)
  {
    ReadInJoyBaseAdapter.b(this.a, false);
    if (!ReadInJoyBaseAdapter.c(this.a)) {
      return;
    }
    ReadInJoyBaseAdapter.a(this.a, false);
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      ReadInJoyBaseAdapter.a(this.a, paramReadInJoyXListView, 500);
    }
    ReadInJoyBaseAdapter.a(this.a, this.a.a.t() + 1, ReadInJoyBaseAdapter.c());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */