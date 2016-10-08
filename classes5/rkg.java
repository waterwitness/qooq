import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class rkg
  implements Runnable
{
  rkg(rkf paramrkf, SharedPreferences paramSharedPreferences, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Rkf.a.a == null) {
      return;
    }
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)this.jdField_a_of_type_Rkf.a.a.getManager(148);
    List localList1 = localFavroamingDBManager.a();
    if ((localList1 != null) && (localList1.size() > FavEmoConstant.a))
    {
      List localList2 = localList1.subList(0, localList1.size() - FavEmoConstant.a);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "delListOverflow=" + localList2.toString() + "emolist.size=" + localList1.size());
      }
      localFavroamingDBManager.a(localList2);
      this.jdField_a_of_type_Rkf.a.e();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("local_overflow" + this.jdField_a_of_type_JavaLangString, true).commit();
    EmoticonMainPanel.a(this.jdField_a_of_type_Rkf.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */