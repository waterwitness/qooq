import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionCommentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hvo
  implements TextWatcher
{
  public hvo(ImageCollectionCommentActivity paramImageCollectionCommentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    ImageCollectionCommentActivity.a(this.a, paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */