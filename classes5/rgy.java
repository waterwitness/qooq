import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class rgy
  implements Runnable
{
  rgy(rgx paramrgx, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoRoamingObserver", 2, "start upload and download fav");
    }
    this.jdField_a_of_type_Rgx.a.syncUpload(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Rgx.a.downLoadFav();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */