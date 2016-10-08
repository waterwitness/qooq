import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class tzt
  implements Runnable
{
  tzt(tzs paramtzs, List paramList, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a) == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a).jdField_a_of_type_JavaUtilList == null) {
        break label131;
      }
      QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a).jdField_a_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a, this.jdField_a_of_type_Boolean);
      if (QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a) == null) {
        break;
      }
      QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a).notifyDataSetChanged();
      return;
      label131:
      QCallDetailActivity.a(this.jdField_a_of_type_Tzs.a).jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */