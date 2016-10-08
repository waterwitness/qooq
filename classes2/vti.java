import android.graphics.Point;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.mobileqq.troop.widget.RadarMembersView;
import com.tencent.mobileqq.troop.widget.RadarMembersView.OnMemberIconClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class vti
  implements GestureDetector.OnGestureListener
{
  public vti(RadarMembersView paramRadarMembersView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    long l1 = System.currentTimeMillis();
    Object localObject = "";
    int k = this.a.c;
    k = this.a.d + k;
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    NearbyMember localNearbyMember;
    do
    {
      paramMotionEvent = (MotionEvent)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      localNearbyMember = (NearbyMember)localIterator.next();
      paramMotionEvent = this.a.a(localNearbyMember.a);
    } while ((localNearbyMember.c > this.a.i) || (i <= paramMotionEvent.x - k) || (i >= paramMotionEvent.x + k) || (j <= paramMotionEvent.y - k) || (j >= paramMotionEvent.y + k));
    localObject = localNearbyMember.a + "";
    paramMotionEvent = (MotionEvent)localObject;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnMemberIconClickListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnMemberIconClickListener.a(localNearbyMember.a);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("RadarMembersView.click", 2, "onSingleTapUp:" + (String)localObject + ", " + (l2 - l1));
      }
      return true;
      localObject = paramMotionEvent;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */