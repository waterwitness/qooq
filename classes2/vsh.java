import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

public class vsh
  implements Observer
{
  public vsh(AvatarWallAdapter paramAvatarWallAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    label4:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label4;
                break label4;
                break label4;
                break label4;
                do
                {
                  return;
                } while (!(paramObject instanceof TroopUploadingThread.UploadState));
                i = this.a.b - this.a.j;
              } while (i >= 8);
              paramObservable = (TroopUploadingThread.UploadState)paramObject;
              if (paramObservable.a == 0)
              {
                this.a.a(paramObservable.b, i);
                return;
              }
              if ((paramObservable.c >= 0) && (paramObservable.c <= 1)) {
                this.a.h = false;
              }
              this.a.jdField_a_of_type_AndroidOsHandler.post(new vsi(this, paramObservable));
            } while ((paramObservable.a != 1) || (paramObservable.c < 0));
            paramObject = this.a.a(i);
          } while ((paramObject == null) || (((AvatarWallAdapter.AvatarInfo)paramObject).b == null));
          paramObject = ((AvatarWallAdapter.AvatarInfo)paramObject).b;
          String str = AbsDownloader.d(AvatarTroopUtil.b(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.g, 1)));
          int i = this.a.b((String)paramObject, str);
          if (QLog.isColorLevel()) {
            QLog.d(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, "origin photo,result:" + i);
          }
          paramObservable = AbsDownloader.d(AvatarTroopUtil.a(AvatarTroopUtil.a(String.valueOf(paramObservable.b), this.a.g, 1)));
          i = this.a.a((String)paramObject, paramObservable);
          if (QLog.isColorLevel()) {
            QLog.d(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, "thumb photo,result:" + i);
          }
        } while (this.a.h);
        this.a.h = true;
      } while (this.a.i);
      paramObservable = null;
      if (this.a.jdField_a_of_type_MqqUtilWeakReference != null) {
        paramObservable = (Activity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      }
    } while ((paramObservable == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger == null));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.a.g);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */