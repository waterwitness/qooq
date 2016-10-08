import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class vqu
  implements Runnable
{
  vqu(vqt paramvqt, int paramInt, boolean paramBoolean, List paramList, long paramLong)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Int != 6)
    {
      i = j;
      if (this.jdField_a_of_type_Int != 3) {}
    }
    else
    {
      i = j;
      if (this.jdField_a_of_type_Boolean)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (i = 0; localIterator.hasNext(); i = 1)
        {
          label45:
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
          if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has()) || (!localmemberlist.uint32_shutup_timestap.has())) {
            break label45;
          }
          long l1 = localmemberlist.uint32_shutup_timestap.get();
          long l2 = localmemberlist.uint64_member_uin.get();
          ((TroopManager)this.jdField_a_of_type_Vqt.a.a.getManager(51)).a(this.jdField_a_of_type_Long + "", l2 + "", null, -100, null, null, -100, -100, -100, -100L, l1);
        }
      }
    }
    if (i != 0) {
      new Handler(Looper.getMainLooper()).post(new vqv(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */