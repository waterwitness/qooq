import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ibn
  implements DialogInterface.OnClickListener
{
  ibn(ibm paramibm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReadInJoyBaseAdapter.a(this.a.a.a).a(true);
    this.a.a.a.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */