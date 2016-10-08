import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.PhotoWallView;
import java.util.ArrayList;

public class wnf
  implements Runnable
{
  public wnf(PhotoWallView paramPhotoWallView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (QZonePhotoWall)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(QZonePhotoWall.class, this.a.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.a.a(((QZonePhotoWall)localObject).totalPic, ((QZonePhotoWall)localObject).hasMore, ((QZonePhotoWall)localObject).attachInfo, ((QZonePhotoWall)localObject).unpackPhotoWallData(), localArrayList);
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = localArrayList;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */