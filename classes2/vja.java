import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class vja
  extends TroopObserver
{
  public vja(TroopCreateAvatarActivity paramTroopCreateAvatarActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    boolean bool = true;
    if (this.a.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_b_of_type_JavaLangString)));
      if (paramInt1 == 0)
      {
        if (paramInt2 == 0) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          b(paramString1, paramBoolean, paramList);
          return;
        }
      }
      if (paramString2 != null)
      {
        QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
        return;
      }
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        QQToast.a(this.a, this.a.getString(2131364666), 1).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt1 == 19)
      {
        QQToast.a(this.a, this.a.getString(2131364667), 1).b(this.a.getTitleBarHeight());
        return;
      }
    } while (paramInt1 != 65);
    QQToast.a(this.a, this.a.getString(2131364668), 1).b(this.a.getTitleBarHeight());
  }
  
  protected void b(String paramString, boolean paramBoolean, List paramList)
  {
    Object localObject = (TroopCreateLogic)this.a.app.getManager(31);
    if (localObject != null)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        ((TroopCreateLogic)localObject).a().jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      if (!this.a.jdField_a_of_type_Boolean) {
        break label231;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label217;
      }
      this.a.rightViewText.setEnabled(true);
      label78:
      TroopInfo localTroopInfo = ((TroopManager)this.a.app.getManager(51)).a(paramString);
      paramString = new Message();
      paramString.what = 10;
      localObject = paramString.getData();
      if (localTroopInfo == null) {
        break label245;
      }
      ((Bundle)localObject).putStringArrayList("AVATAR_WALL_LIST", (ArrayList)localTroopInfo.mTroopPicList);
      paramList = localTroopInfo.mTroopVerifyingPics;
      if (paramList != null) {
        ((Bundle)localObject).putStringArray("VERIFYING_PICTURE_LIST", (String[])paramList.toArray(new String[paramList.size()]));
      }
    }
    for (;;)
    {
      ((Bundle)localObject).putBoolean("IS_DEFAULT_AVATAR", paramBoolean);
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      return;
      ((TroopCreateLogic)localObject).a().jdField_a_of_type_Boolean = false;
      break;
      label217:
      this.a.rightViewText.setEnabled(false);
      break label78;
      label231:
      this.a.rightViewText.setEnabled(true);
      break label78;
      label245:
      ((Bundle)localObject).putStringArrayList("AVATAR_WALL_LIST", (ArrayList)paramList);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramInt1 == 0)
    {
      b(paramString1, false, paramList);
      return;
    }
    if (paramString2 != null)
    {
      b(paramString1, false, paramList);
      QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 1)
    {
      QQToast.a(this.a, this.a.getString(2131364666), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 2)
    {
      QQToast.a(this.a, this.a.getString(2131364667), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 3)
    {
      QQToast.a(this.a, this.a.getString(2131364670), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 4)
    {
      QQToast.a(this.a, this.a.getString(2131364671), 1).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, this.a.getString(2131364672), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */