import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class tql
  implements AbsListView.OnScrollListener
{
  private tql(ItemManager paramItemManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.a.d == 2) && (paramInt != 2))
    {
      i = 1;
      if (i == 0) {
        break label137;
      }
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this.a);
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (!this.a.c) {
        break label129;
      }
      i = j;
      label68:
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, i);
      this.a.b = true;
    }
    for (;;)
    {
      this.a.d = paramInt;
      localObject = this.a.jdField_a_of_type_Tqh.a();
      if (localObject != null) {
        ((AbsListView.OnScrollListener)localObject).a(paramAbsListView, paramInt);
      }
      return;
      i = 0;
      break;
      label129:
      i = 550;
      break label68;
      label137:
      if (paramInt == 2)
      {
        this.a.b = false;
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.a.jdField_a_of_type_Tqh.a();
    if (localOnScrollListener != null) {
      localOnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */