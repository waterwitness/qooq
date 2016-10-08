import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imq
  implements DialogInterface.OnClickListener
{
  public imq(PostContentView paramPostContentView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PostContentView.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewPostContentView, this.jdField_a_of_type_JavaLangString, "{\"ret\":1}");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */