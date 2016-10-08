import android.view.View;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class nod
{
  private Map jdField_a_of_type_JavaUtilMap;
  
  public nod(ReplyTextItemBuilder paramReplyTextItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public View a(int paramInt)
  {
    LinkedList localLinkedList = (LinkedList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localLinkedList == null) {
      return null;
    }
    return (View)localLinkedList.poll();
  }
  
  public void a(int paramInt, View paramView)
  {
    LinkedList localLinkedList2 = (LinkedList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    localLinkedList1.add(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */