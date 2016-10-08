import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.biz.qqstory.playvideo.QQStoryCommentDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;

public class iny
  implements InputFilter
{
  protected final int a;
  
  public iny(QQStoryCommentDialog paramQQStoryCommentDialog, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = (paramInt * 3);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog.a(paramSpanned);
    paramInt3 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog.a(paramSpanned.subSequence(paramInt3, paramInt4));
    paramInt1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog.a(paramCharSequence.subSequence(paramInt1, paramInt2));
    paramInt4 = this.jdField_a_of_type_Int - (i - paramInt3);
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt1) {
      return null;
    }
    paramSpanned = new StringBuilder();
    i = paramCharSequence.length();
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt1 < i)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (StringUtil.d(c)) {}
      for (paramInt3 = 3;; paramInt3 = 1)
      {
        paramInt2 += paramInt3;
        if (paramInt2 > paramInt4) {
          break label154;
        }
        paramSpanned.append(c);
        paramInt1 += 1;
        break;
      }
    }
    label154:
    return paramSpanned.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */