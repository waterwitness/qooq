import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sog
  implements ActionMode.Callback
{
  public sog(BlockableEditTextView paramBlockableEditTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (BlockableEditTextView.a(this.a) == 0) {
      return true;
    }
    return BlockableEditTextView.a(this.a);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */