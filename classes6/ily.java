import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StackBlur;

public class ily
  implements Runnable
{
  public ily(ContentEmptyView paramContentEmptyView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap1 = ContentEmptyView.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.headUrl);
    if (localBitmap1 == null) {}
    Bitmap localBitmap2;
    do
    {
      return;
      localBitmap2 = ChatSettingForTroop.a(this.a.jdField_a_of_type_AndroidUtilDisplayMetrics, localBitmap1);
    } while (localBitmap2 == null);
    StackBlur.a(localBitmap2, 10);
    new Handler(Looper.getMainLooper()).post(new ilz(this, localBitmap2, localBitmap1));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ily.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */