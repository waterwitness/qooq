import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;

public class lqv
  extends QZoneObserver
{
  public lqv(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QZoneLogTags.b + "Q.lebatab.leba", 2, "on Get QZone Count:" + paramBoolean1 + ",HasNew:" + paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      if (17 == paramInt) {
        QLog.d(QZoneLogTags.b + QZoneLogTags.e, 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      QLog.d(QZoneLogTags.b, 2, "Leba onGetQZoneFeedCountFin type: " + paramInt + " and then call Leba freshEntryItemUI");
    }
    if (paramBoolean1)
    {
      Leba.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "onGetQZoneFeedCountFin. notifyData.");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */