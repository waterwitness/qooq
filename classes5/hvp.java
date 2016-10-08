import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionCommentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hvp
  implements TextView.OnEditorActionListener
{
  public hvp(ImageCollectionCommentActivity paramImageCollectionCommentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.getKeyCode() == 66;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */