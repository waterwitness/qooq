import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class lrp
  implements Runnable
{
  lrp(lro paramlro, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Lro.a) == null) {
      Leba.a(this.jdField_a_of_type_Lro.a, new ArrayList());
    }
    Iterator localIterator1 = Leba.a(this.jdField_a_of_type_Lro.a).iterator();
    while (localIterator1.hasNext())
    {
      LebaViewItem localLebaViewItem1 = (LebaViewItem)localIterator1.next();
      if ((localLebaViewItem1 != null) && (localLebaViewItem1.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          LebaViewItem localLebaViewItem2 = (LebaViewItem)localIterator2.next();
          if ((localLebaViewItem2 != null) && (localLebaViewItem2.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem2.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName))) {
            localLebaViewItem2.jdField_a_of_type_AndroidGraphicsBitmap = localLebaViewItem1.jdField_a_of_type_AndroidGraphicsBitmap;
          }
        }
      }
    }
    Leba.a(this.jdField_a_of_type_Lro.a).clear();
    Leba.a(this.jdField_a_of_type_Lro.a).addAll(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. lebaData size=" + Leba.a(this.jdField_a_of_type_Lro.a).size());
    }
    if (this.jdField_a_of_type_Lro.a.a != null)
    {
      this.jdField_a_of_type_Lro.a.a.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.b(this.jdField_a_of_type_Lro.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */