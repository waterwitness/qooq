import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionCommentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hvt
  implements CompoundButton.OnCheckedChangeListener
{
  public hvt(ImageCollectionCommentActivity paramImageCollectionCommentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ImageCollectionCommentActivity.b(this.a, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */