import NearbyGroup.GroupLabel;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import java.util.ArrayList;

public class vuk
  implements Runnable
{
  public vuk(TroopLabelLayout paramTroopLabelLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
          break label229;
        }
        return;
        GroupLabel localGroupLabel;
        Object localObject2;
        if (j < this.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localGroupLabel = (GroupLabel)this.a.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (j == 0)
          {
            i = 0;
            break label238;
          }
          localObject2 = (GroupLabel)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)((GroupLabel)localObject2).type) <= TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)localGroupLabel.type))
          {
            i = j;
            break label238;
          }
        }
        else
        {
          localGroupLabel = (GroupLabel)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          i = k;
          if (i < this.a.getChildCount())
          {
            localObject2 = this.a.getChildAt(i);
            if (!(localObject2 instanceof TextView)) {
              break label247;
            }
            localObject2 = (TextView)localObject2;
            if (!((TextView)localObject2).getText().toString().equals(localGroupLabel.strWording)) {
              break label247;
            }
            ((TextView)localObject2).setVisibility(8);
            this.a.requestLayout();
            break label247;
          }
          return;
        }
      }
      break label238;
      label229:
      int j = 0;
      int i = 0;
      continue;
      label238:
      j += 1;
      continue;
      label247:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */