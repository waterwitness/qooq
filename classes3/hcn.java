import com.tencent.av.widget.stageview.MathUtils;
import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageMemberView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class hcn
  implements Comparator
{
  public hcn(StageEffectView paramStageEffectView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(StageMemberView paramStageMemberView1, StageMemberView paramStageMemberView2)
  {
    if ((paramStageMemberView1 == null) && (paramStageMemberView2 == null)) {
      return 0;
    }
    if (paramStageMemberView2 == null) {
      return -1;
    }
    if (paramStageMemberView1 == null) {
      return 1;
    }
    paramStageMemberView1 = (hcu)paramStageMemberView1.getTag();
    paramStageMemberView2 = (hcu)paramStageMemberView2.getTag();
    if (paramStageMemberView1.a == paramStageMemberView2.a) {
      return 0;
    }
    if (MathUtils.a(paramStageMemberView1.a - 10000, 20000) < MathUtils.a(paramStageMemberView2.a - 10000, 20000)) {
      return -1;
    }
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */