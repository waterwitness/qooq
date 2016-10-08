import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class vsm
  implements AdapterView.OnItemClickListener
{
  public vsm(AvatarWallAdapter paramAvatarWallAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.a.jdField_a_of_type_MqqUtilWeakReference != null) && (this.a.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {}
    for (paramView = (Activity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();; paramView = null)
    {
      if (paramView == null) {}
      Object localObject1;
      Bundle localBundle;
      label311:
      do
      {
        do
        {
          return;
          localObject1 = this.a.a(paramInt);
        } while (localObject1 == null);
        if (((AvatarWallAdapter.AvatarInfo)localObject1).d.equals("PLUS")) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(paramView, TroopAvatarWallPreviewActivity.class);
        localBundle = new Bundle();
        if (!this.a.j) {}
        Object localObject2;
        for (boolean bool = true;; bool = false)
        {
          localBundle.putBoolean("is_show_action", bool);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < this.a.b)
          {
            new Rect();
            Rect localRect = AnimationUtils.a(paramAdapterView.getChildAt(i));
            if (localRect != null) {
              ((ArrayList)localObject2).add(localRect);
            }
            i += 1;
          }
        }
        if (((ArrayList)localObject2).size() > 0) {
          ((Intent)localObject1).putParcelableArrayListExtra("KEY_THUMBNAL_BOUND", (ArrayList)localObject2);
        }
        localBundle.putInt("index", paramInt);
        paramAdapterView = new ArrayList();
        paramInt = 0;
        if (paramInt < this.a.b)
        {
          localObject2 = this.a.a(paramInt);
          if (localObject2 != null)
          {
            if (((!((AvatarWallAdapter.AvatarInfo)localObject2).d.equals("AVATAR_URL_STR")) && (!((AvatarWallAdapter.AvatarInfo)localObject2).d.equals("SYSTEM_PHOTO"))) || (((AvatarWallAdapter.AvatarInfo)localObject2).b != null) || (((AvatarWallAdapter.AvatarInfo)localObject2).c == null)) {
              break label311;
            }
            paramAdapterView.add(((AvatarWallAdapter.AvatarInfo)localObject2).c);
          }
          for (;;)
          {
            paramInt += 1;
            break;
            if (((AvatarWallAdapter.AvatarInfo)localObject2).b != null) {
              paramAdapterView.add(((AvatarWallAdapter.AvatarInfo)localObject2).b);
            }
          }
        }
      } while (paramAdapterView.size() == 0);
      localBundle.putBoolean("IS_EDIT", this.a.c);
      localBundle.putStringArrayList("seqNum", paramAdapterView);
      localBundle.putString("troop_uin", this.a.g);
      localBundle.putBoolean("troop_info_is_member", this.a.e);
      ((Intent)localObject1).putExtras(localBundle);
      paramView.startActivityForResult((Intent)localObject1, 12);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.a.h, "nonmber_Clk_head", 0, 0, this.a.g, "", "", "");
      return;
      if (this.a.jdField_a_of_type_ArrayOfInt == null) {
        this.a.jdField_a_of_type_ArrayOfInt = new int[AvatarWallAdapter.s];
      }
      this.a.jdField_a_of_type_ArrayOfInt[0] = 13;
      this.a.jdField_a_of_type_ArrayOfInt[1] = 14;
      this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
      paramInt = 3;
      while (paramInt < AvatarWallAdapter.s)
      {
        this.a.jdField_a_of_type_ArrayOfInt[paramInt] = -1;
        paramInt += 1;
      }
      this.a.a(this.a.jdField_a_of_type_ArrayOfInt, paramView);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */