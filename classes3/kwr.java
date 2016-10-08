import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileView;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.HistoryFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kwr
  implements View.OnClickListener
{
  public kwr(ChatHistoryFileView paramChatHistoryFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    paramView = (FileManagerEntity)((ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag()).a;
    this.a.a(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */